package com.prueba.servicios.impl;


import java.util.List;

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
		resultadoJuego.getApuestas().keySet();		
		for (int cliente : juego.getApuestas().keySet()) {			
			List<Apuesta> apuestaCliente = resultadoJuego.getApuestas().get(cliente);
			System.out.println(apuestaCliente.toString());
			long gananciaCliente = 0;
			for (Apuesta apuesta : apuestaCliente) {
				if(apuesta.getNumeroApostado()==resultadoJuego.getNumeroGanador()) {
					gananciaCliente+=apuesta.getCantidad()*36;
				}
			}
			resultadoJuego.getResultadosClientes().put(cliente, gananciaCliente);			
		}
		return resultadoJuego;
	}
	

}
