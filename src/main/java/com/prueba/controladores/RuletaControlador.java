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

/**
 * @author jonathan cuesta
 * controlador de peticiones http para las ruletas
 *
 */
@RestController
@RequestMapping("/ruletas")
public class RuletaControlador {
	@Autowired
	RuletaServicio ruletaService;

	/**
	 * Metodo para crear una ruleta
	 * 
	 * @return long que identifica a la ruleta creada
	 */
	@PostMapping("")
	public ResponseEntity<Long> crearRuleta() {
		return new ResponseEntity<>(ruletaService.creacionRuleta(), HttpStatus.CREATED);
	}

	/**
	 * Metodo para consultar el id y el estado de las ruletas
	 * 
	 * @return HashMap donde la llave es el id de la ruleta y el valor es el estado
	 *         de esta
	 */
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
