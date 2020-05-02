package com.prueba.controladores;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Long> crearRuleta() {
		return new ResponseEntity<>(ruletaService.creacionRuleta(), HttpStatus.CREATED);
	}

	@GetMapping("")
	public ResponseEntity<HashMap<Long, String>> consultarRuletas() {
		HashMap<Long, String> estados = ruletaService.consultarRuletas();
		if (estados.isEmpty()) {
			return new ResponseEntity<>(estados, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(estados, HttpStatus.OK);
		}
	}

}
