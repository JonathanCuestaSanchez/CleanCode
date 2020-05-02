package com.prueba.servicios;

public class ServicioException extends Exception {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServicioException(String message) {
        super(message);
    }

    public ServicioException(String message, Throwable cause) {
        super(message, cause);
    }
}