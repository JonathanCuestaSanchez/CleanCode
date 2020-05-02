package com.prueba.servicios;

import com.prueba.modelo.Apuesta;
import com.prueba.modelo.Resultado;

public interface ApuestaServicio {
	
	void abrirApuestas(String id) throws ServicioException;
	Resultado cerrarApuestas(String id) throws ServicioException;
	void creacionApuesta(String id,Apuesta apuesta) throws ServicioException;

}
