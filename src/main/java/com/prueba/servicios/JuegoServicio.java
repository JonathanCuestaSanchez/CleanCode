package com.prueba.servicios;

import com.prueba.modelo.Juego;
import com.prueba.modelo.Resultado;

public interface JuegoServicio {
	
	int lanzarBola();
	Resultado pagarApuesta(Juego juego);

}
