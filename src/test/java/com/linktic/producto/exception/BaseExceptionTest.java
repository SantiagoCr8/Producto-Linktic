package com.linktic.producto.exception;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.linktic.producto.controller.ProductoController;
import com.linktic.producto.service.ProductoService;

@WebMvcTest(controllers = ProductoController.class)
@Import(BaseExcepcion.class)
public class BaseExceptionTest {

	@MockBean
	private ProductoService productoService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void RecursoNoEncotradoTest() throws Exception {
		when(productoService.findById(2L)).thenThrow(new NotFoundException("No se ha encontrado el producto con el ID: 2"));
		mockMvc.perform(get("/productos/buscar/2")).andExpect(status().isNotFound())
				.andExpect(jsonPath("$.severity").value("WARNING"))
				.andExpect(jsonPath("$.userMessage").value("No se ha encontrado el producto con el ID: 2"));
	}

	@Test
	void ArgumantosNoValidosTest() throws Exception {
		   String json = "{\"precio\": 100,\"descripcion\": \"cafe\"}";
		   mockMvc.perform(post("/productos/crear")
	                .contentType("application/json")
	                .content(json))
	            .andExpect(status().isBadRequest())
	            .andExpect(jsonPath("$.severity").value("ERROR"))
	            .andExpect(jsonPath("$.userMessage").value("El campo de nombre es obligatorio"));

	}

	@Test
	void ServerErrorTest() throws Exception {
		when(productoService.findById(1L))
	    .thenThrow(new RuntimeException("Error inesperado"));
		mockMvc.perform(get("/productos/1")).andExpect(status().isInternalServerError())
				.andExpect(jsonPath("$.severity").value("ERROR"))
				.andExpect(jsonPath("$.userMessage").value("Error inesperado, comuniquese con el administrador"));
	}

}
