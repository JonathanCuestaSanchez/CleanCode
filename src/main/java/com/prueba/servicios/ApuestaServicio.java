package com.prueba.servicios;

import com.prueba.modelo.Apuesta;
import com.prueba.modelo.Resultado;

public interface ApuestaServicio {
	
	String abrirApuestas(String id);
	Resultado cerrarApuestas(String id);
	void creacionApuesta(String id,Apuesta apuesta);

}
