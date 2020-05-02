package com.prueba.servicios.impl;


import org.springframework.stereotype.Service;

import com.prueba.modelo.Apuesta;
import com.prueba.modelo.Juego;
import com.prueba.modelo.Resultado;
import com.prueba.servicios.JuegoServicio;

@Service
public class JuegoServicioImpl implements JuegoServicio {

	@Override
	public int lanzarBola() {
		double casilla=Math.random()*37;		
		return (int)casilla;
	}

	@Override
	public Resultado pagarApuesta(Juego juego) {		
		Resultado resultadoJuego = new Resultado(juego.getRuleta(),juego.getId(),juego.getFechaInicio(),juego.getFechaFin(),juego.getApuestas(),juego.getNumeroGanador());
			
		for (Apuesta apuesta : juego.getApuestas()) {
			long ganancia = 0;
			if(resultadoJuego.getResultadosClientes().containsKey(apuesta.getCliente())) {
				if(apuesta.getNumeroApostado()==resultadoJuego.getNumeroGanador()) {					
					ganancia = resultadoJuego.getResultadosClientes().get(apuesta.getCliente());
					ganancia+= apuesta.getCantidad()*36;
					resultadoJuego.getResultadosClientes().replace(apuesta.getCliente(), ganancia);
				}
			}else {				
				if(apuesta.getNumeroApostado()==resultadoJuego.getNumeroGanador()) {
					ganancia=apuesta.getCantidad()*36;
				}
				resultadoJuego.getResultadosClientes().put(apuesta.getCliente(), ganancia);
			}
					
		}
		return resultadoJuego;
	}
	

}
