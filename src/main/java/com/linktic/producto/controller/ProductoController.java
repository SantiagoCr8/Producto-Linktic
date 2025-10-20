package com.linktic.producto.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linktic.producto.dto.ProductoDto;
import com.linktic.producto.service.ProductoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	private final ProductoService svc;

    public ProductoController(ProductoService svc) {
        this.svc = svc;
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ProductoDto> getOne(@Valid @PathVariable Long id) {
        ProductoDto productoDto = svc.findById(id);
        return ResponseEntity.ok(productoDto);
    }

    @PostMapping("/crear")
    public ResponseEntity<ProductoDto> create(@Valid  @RequestBody ProductoDto payload) {
        ProductoDto created = svc.create(payload);
        return ResponseEntity
            .created(URI.create("/products/" + created.getId()))
            .body(created);
    }
}
