package com.prueba.servicios;
/**
 * @author jonathan cuesta 
 * clase de exception de los servicios
 */
public class ServicioException extends Exception {

	private static final long serialVersionUID = 1L;

	public ServicioException(String message) {
		super(message);
	}

	public ServicioException(String message, Throwable cause) {
		super(message, cause);
	}
}