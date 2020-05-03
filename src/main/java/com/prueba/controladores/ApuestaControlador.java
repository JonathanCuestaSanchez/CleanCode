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

/**
 * @author Jonathan cuesta 
 * controlador de peticiones http para las apuestas
 */
@RestController
@RequestMapping("/apuestas")
public class ApuestaControlador {

	@Autowired
	ApuestaServicio apuestaServicio;

	/**
	 * Metodo encargado de abrir las apuestas en una ruleta
	 * 
	 * @param ruleta id de la ruleta en la que se quieren abrir las apuestas
	 * @return string con informacion sobre el proceso, status Http
	 */
	@PatchMapping("/{ruleta}/abrir")
	public ResponseEntity<String> abrirApuesta(@PathVariable String ruleta) {
		try {
			apuestaServicio.abrirApuestas(ruleta);
			return new ResponseEntity<>("Abierto", HttpStatus.OK);
		} catch (ServicioException e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
		}

	}

	/**
	 * Metodo encargado de cerrar las apuestas en una ruleta
	 * 
	 * @param ruleta id de la ruleta en la que se quieren cerrar las apuestas
	 * @return string con informacion sobre el proceso, status Http
	 */
	@PatchMapping("/{ruleta}/cerrar")
	public ResponseEntity<?> cerrarApuesta(@PathVariable String ruleta) {
		try {
			return new ResponseEntity<>(apuestaServicio.cerrarApuestas(ruleta), HttpStatus.OK);
		} catch (ServicioException e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
		}

	}

	/**
	 * Metodo encargado de crear una apuesta para una ruleta
	 * 
	 * @param ruleta  id de la ruleta en la que se quieren cerrar las apuestas
	 * @param apuesta objeto enviado por el body de la peticion http, apuesta para
	 *                la ruleta especificada
	 * @return string con informacion sobre el proceso, status Http
	 */
	@PostMapping("/{ruleta}")
	public ResponseEntity<String> crearApuesta(@PathVariable String ruleta, @RequestBody Apuesta apuesta) {
		if (apuesta.getNumeroApostado() < 0 || apuesta.getNumeroApostado() > 36) {
			return new ResponseEntity<>(
					"El numero apostado no es correcto para el juego de la ruleta, sobrepasa 36 o es negativo",
					HttpStatus.BAD_REQUEST);
		}
		try {
			apuestaServicio.creacionApuesta(ruleta, apuesta);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (ServicioException e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
		}

	}

}
