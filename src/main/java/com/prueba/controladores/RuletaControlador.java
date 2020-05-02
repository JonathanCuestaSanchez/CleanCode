package com.prueba.controladores;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.prueba.servicios.RuletaServicio;

@RestController
@RequestMapping("/ruletas")
public class RuletaControlador {
	@Autowired
	RuletaServicio ruletaService;
	
	@PostMapping("")
	public long crearRuleta() {
		return (ruletaService.creacionRuleta());
	}
	
	@GetMapping("")
	public HashMap<Long,String> consultarRuletas() {
		return ruletaService.consultarRuletas();
	}
	
	
	
}
