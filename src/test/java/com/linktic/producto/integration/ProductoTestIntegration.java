package com.linktic.producto.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest // levanta el contexto completo
@AutoConfigureMockMvc // inyecta MockMvc
@ActiveProfiles("test") // usa el perfil test con H2
@Sql("/data.sql")
public class ProductoTestIntegration {
	 @Autowired
	    private MockMvc mockMvc;

	    @Test
	    void buscarProductoTest() throws Exception {
	    	mockMvc.perform(get("/productos/buscar/2")).andExpect(status().isOk())
			.andExpect(jsonPath("$.id").value(2))
			.andExpect(jsonPath("$.nombre").value("Pastel"))
	    	.andExpect(jsonPath("$.precio").value(1000))
			.andExpect(jsonPath("$.descripcion").value("Pastel"));
	    
	    }
	    
	    @Test
	    void crearProductoTest() throws Exception {
	    	String json = "{\r\n"
	    			+ "    \"id\": 3,\r\n"
	    			+ "    \"nombre\": \"Pan\",\r\n"
	    			+ "    \"precio\": 1000.00,\r\n"
	    			+ "    \"descripcion\": \"Pan de sal\"\r\n"
	    			+ "}";
	    	 mockMvc.perform(post("/productos/crear")
		    .contentType("application/json")
		    .content(json))
			.andExpect(jsonPath("$.id").isNumber())
			.andExpect(jsonPath("$.nombre").value("Pan"))
	    	.andExpect(jsonPath("$.precio").value(1000))
			.andExpect(jsonPath("$.descripcion").value("Pan de sal"));
	    
	    }
}
