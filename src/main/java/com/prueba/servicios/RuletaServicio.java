package com.prueba.servicios;

import java.util.HashMap;



/**
 * @author jonathan cuesta 
 * interface para el servicio de ruleta
 */
/**
 * @author user
 *
 */
public interface RuletaServicio {
	
	/**Metodo que crea una ruleta
	 * @return id de la ruleta creada
	 */
	long creacionRuleta() ;
	
	/**metodo que colsulta el estado de todas las ruletas
	 * @return  HashMap donde la key es el id de la ruleta y el value es el estado de esta
	 */
	HashMap<Long,String> consultarRuletas() ;

}
