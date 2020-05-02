package com.prueba.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.modelo.Apuesta;
import com.prueba.modelo.Resultado;
import com.prueba.servicios.ApuestaServicio;

@RestController
@RequestMapping("/apuestas")
public class ApuestaControlador {
	@Autowired
	ApuestaServicio apuestaServicio;
	
	@PatchMapping("/{ruleta}/abrir")
	public String abrirApuesta(@PathVariable String ruleta) {
		return apuestaServicio.abrirApuestas(ruleta);
	}
	
	@PatchMapping("/{ruleta}/cerrar")
	public Resultado cerrarApuesta(@PathVariable String ruleta) {
		return apuestaServicio.cerrarApuestas(ruleta);
	}
	
	@PostMapping("/{ruleta}")
	public void crearApuesta(@PathVariable String ruleta, @RequestBody Apuesta apuesta) {
		apuestaServicio.creacionApuesta(ruleta, apuesta);
		
	}

}
