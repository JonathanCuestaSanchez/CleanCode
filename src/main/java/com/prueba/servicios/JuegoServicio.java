package com.prueba.servicios;

import com.prueba.modelo.Juego;
import com.prueba.modelo.Resultado;
/**
 * @author jonathan cuesta 
 * interface para el servicio de Juego
 */
public interface JuegoServicio {
	
	/**metodo que represetna el lanzamiento de la bola en la ruleta
	 * @return
	 */
	int lanzarBola();
	
	/**metod que da los resultados del juego para poder pagar las apuestas
	 * @param juego el juego que se quiere pagar
	 * @return resultado del juego 
	 */
	Resultado pagarApuesta(Juego juego);

}
