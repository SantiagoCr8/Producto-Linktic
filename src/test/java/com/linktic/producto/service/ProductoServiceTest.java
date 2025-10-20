package com.linktic.producto.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.linktic.producto.dto.ProductoDto;
import com.linktic.producto.model.Producto;
import com.linktic.producto.repository.ProductoRepository;

@ExtendWith(MockitoExtension.class) 
public class ProductoServiceTest {
	@Mock
	private ProductoRepository productoRepository;

	@InjectMocks
	private ProductoService productoServise;
	

	@Test
	void verificarBusquedaProducto() {
		BigDecimal precio = new BigDecimal("1000");
		Producto mockUser = new Producto(Long.valueOf(1L), "Chocolate", precio ,"Chocolate en pastillas");
		when(productoRepository.findById(Long.valueOf(1L))).thenReturn(Optional.of(mockUser));
		ProductoDto producto = productoServise.findById(1L);
		assertEquals(Long.valueOf(1L), producto.getId());
		assertEquals("Chocolate", producto.getNombre());
		assertEquals(precio, producto.getPrecio());
		assertEquals("Chocolate en pastillas", producto.getDescripcion());
		verify(productoRepository).findById(Long.valueOf(1L));
	}
	
	@Test
	void crearProducto() {
		BigDecimal precio = new BigDecimal("1000");
		Producto mockUser = new Producto(Long.valueOf(1L), "Chocolate", precio ,"Chocolate en pastillas");
		when(productoRepository.save(any(Producto.class))).thenReturn(mockUser);
		ProductoDto producto = new ProductoDto(1L, "Chocolate", precio ,"Chocolate en pastillas");
		ProductoDto productoCreado = productoServise.create(producto);
		assertEquals(Long.valueOf(1L), productoCreado.getId());
		assertEquals("Chocolate", productoCreado.getNombre());
		assertEquals(precio, productoCreado.getPrecio());
		assertEquals("Chocolate en pastillas", productoCreado.getDescripcion());
		verify(productoRepository).save(any(Producto.class));
	}
	
	@Test
	void listarProductos() {
		BigDecimal precio = new BigDecimal("1000");
		Producto mockUser = new Producto(Long.valueOf(1L), "Chocolate", precio ,"Chocolate en pastillas");
		when(productoRepository.save(any(Producto.class))).thenReturn(mockUser);
		ProductoDto producto = new ProductoDto(1L, "Chocolate", precio ,"Chocolate en pastillas");
		ProductoDto productoCreado = productoServise.create(producto);
		assertEquals(Long.valueOf(1L), productoCreado.getId());
		assertEquals("Chocolate", productoCreado.getNombre());
		assertEquals(precio, productoCreado.getPrecio());
		assertEquals("Chocolate en pastillas", productoCreado.getDescripcion());
		verify(productoRepository).save(any(Producto.class));
	}
}
