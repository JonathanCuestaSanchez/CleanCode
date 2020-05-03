package com.prueba.servicios;

import com.prueba.modelo.Apuesta;
import com.prueba.modelo.Resultado;

/**
 * @author jonathan cuesta 
 * interface para el servicio de Apuestas
 */
public interface ApuestaServicio {
	
	/**Metodo encargado de abrir las apuestas en una ruleta
	 * @param id identificador de una ruleta
	 * @throws ServicioException
	 */
	void abrirApuestas(String id) throws ServicioException;
	
	/**Metodo encargado de cerrar las apuesta en una ruleta
	 * @param id identificador de una ruleta
	 * @return clase reultado que representa el resultado del juego
	 * @throws ServicioException
	 */
	Resultado cerrarApuestas(String id) throws ServicioException;
	/**Metodo encargado de crear una apuesta para una ruleta
	 * @param id identificador de una ruleta
	 * @param apuesta 
	 * @throws ServicioException
	 */
	void creacionApuesta(String id,Apuesta apuesta) throws ServicioException;

}
