package com.prueba.servicios.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.modelo.Apuesta;
import com.prueba.modelo.Juego;
import com.prueba.modelo.Resultado;
import com.prueba.modelo.Ruleta;
import com.prueba.repositorio.RuletaRepository;
import com.prueba.servicios.ApuestaServicio;
import com.prueba.servicios.JuegoServicio;

@Service
public class ApuestaServicioImpl implements ApuestaServicio {
	@Autowired
	RuletaRepository ruletaRepository;
	@Autowired
	JuegoServicio juegoService;

	@Override
	public String abrirApuestas(String id) {
		Ruleta ruleta;	
		ruleta = ruletaRepository.findById(id).get();		
		if(!ruleta.getEstado()) {		
			ruleta.setEstado(true);
			ruleta.getJuegos().add(new Juego(ruleta.getJuegos().size(),ruleta.getId()));
			ruletaRepository.save(ruleta);
			return "Se han abierto las apuestas para esta ruleta";
		}else {
			return "Las apuestas de esta ruleta ya se encontraban abieras";
			
		}
		
	}

	@Override
	public Resultado cerrarApuestas(String id) {
		Ruleta ruleta = ruletaRepository.findById(id).get();
		if(ruleta.getEstado()) {	
			ruleta.setEstado(false);
			ruleta.getJuegos().get(ruleta.getJuegos().size()-1).setNumeroGanador(juegoService.lanzarBola());
			ruleta.getJuegos().get(ruleta.getJuegos().size()-1).setFechaFin(LocalDateTime.now());		
			ruletaRepository.save(ruleta);
			return (juegoService.pagarApuesta(ruleta.getJuegos().get(ruleta.getJuegos().size()-1)));			
		}else {			
			return null;
		}
		
	}

	@Override
	public void creacionApuesta(String id, Apuesta apuesta) {
		Ruleta ruleta = ruletaRepository.findById(id).get();
		if(ruleta.getEstado()) {
			HashMap<Integer,List<Apuesta>> apuestas = ruleta.getJuegos().get(ruleta.getJuegos().size()-1).getApuestas();			
			if(apuestas.containsKey(apuesta.getCliente())) {
				apuestas.get(apuesta.getCliente()).add(apuesta);				
				
			}else {
				List<Apuesta> apuestasCliente = new ArrayList<>();
				apuestasCliente.add(apuesta);
				apuestas.put(apuesta.getCliente(), apuestasCliente);
			}	
			ruletaRepository.save(ruleta);
		}
	}

}
