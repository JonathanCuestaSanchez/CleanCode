package com.prueba.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.modelo.Apuesta;
import com.prueba.servicios.ApuestaServicio;
import com.prueba.servicios.ServicioException;

@RestController
@RequestMapping("/apuestas")
public class ApuestaControlador {
	
	@Autowired
	ApuestaServicio apuestaServicio;
	
	@PatchMapping("/{ruleta}/abrir")
	public ResponseEntity<String> abrirApuesta(@PathVariable String ruleta) {
		try {
			apuestaServicio.abrirApuestas(ruleta);
			return new ResponseEntity<>("Abierto",HttpStatus.OK);
		}catch (ServicioException e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PatchMapping("/{ruleta}/cerrar")
	public ResponseEntity<?> cerrarApuesta(@PathVariable String ruleta) {
		try {
			return new ResponseEntity<>(apuestaServicio.cerrarApuestas(ruleta),HttpStatus.OK);
		}catch (ServicioException e) {
			return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/{ruleta}")
	public ResponseEntity<String> crearApuesta(@PathVariable String ruleta, @RequestBody Apuesta apuesta) {
		if(apuesta.getNumeroApostado()<0 || apuesta.getNumeroApostado() > 36 ) {
			return new ResponseEntity<>("El numero apostado no es correcto para el juego de la ruleta, sobrepasa 36 o es negativo",HttpStatus.BAD_REQUEST);
		}
		try {			
			apuestaServicio.creacionApuesta(ruleta,apuesta);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch (ServicioException e) {
			return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.NOT_FOUND);
		}
		
		
	}

}
