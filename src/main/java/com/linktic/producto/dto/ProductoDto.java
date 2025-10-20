package com.linktic.producto.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductoDto {

	private Long id;
	@NotBlank(message = "El campo de nombre es obligatorio")
	private String nombre;
	@NotNull(message = "El campo precio es obligatorio")
	private BigDecimal precio;
	@NotBlank(message = "El campo de descripcion es obligatorio")
	private String descripcion;

	public ProductoDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductoDto(Long id, @NotBlank(message = "El campo de nombre es obligatorio") String nombre,
					@NotNull(message = "El campo precio es obligatorio") BigDecimal precio,
					@NotBlank(message = "El campo de descripcion es obligatorio") String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
