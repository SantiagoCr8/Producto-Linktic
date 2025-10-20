package com.linktic.producto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linktic.producto.dto.ProductoDto;
import com.linktic.producto.exception.NotFoundException;
import com.linktic.producto.model.Producto;
import com.linktic.producto.repository.ProductoRepository;

@Service
public class ProductoService {

    private final ProductoRepository repository;
    
    @Autowired
    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public ProductoDto create(ProductoDto dto) {
        Producto p = new Producto();
        p.setNombre(dto.getNombre());
        p.setPrecio(dto.getPrecio());
        p.setDescripcion(dto.getDescripcion());
        Producto producto = repository.save(p);
        dto.setId(producto.getId());
    	dto.setNombre(producto.getNombre());
        dto.setPrecio(producto.getPrecio());
        dto.setDescripcion(producto.getDescripcion());
        return dto;
    }

    public ProductoDto findById(Long id) {
    	Optional<Producto> opt = repository.findById(id);
    	ProductoDto dto = new ProductoDto();
    	if (opt.isPresent()) {
    		Producto producto = opt.get();
    		dto.setId(producto.getId());
    	 	dto.setNombre(producto.getNombre());
        	dto.setPrecio(producto.getPrecio());
        	dto.setDescripcion(producto.getDescripcion());
    	}else {
    		throw new NotFoundException("No se ha encontrado el producto con el ID: " + id);
		}
        return dto;
    }
}
