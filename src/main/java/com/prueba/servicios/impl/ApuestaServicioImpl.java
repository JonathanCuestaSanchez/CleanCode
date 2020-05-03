package com.prueba.servicios.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.modelo.Apuesta;
import com.prueba.modelo.Juego;
import com.prueba.modelo.Resultado;
import com.prueba.modelo.Ruleta;
import com.prueba.repositorio.RuletaRepository;
import com.prueba.servicios.ApuestaServicio;
import com.prueba.servicios.JuegoServicio;
import com.prueba.servicios.ServicioException;

@Service
public class ApuestaServicioImpl implements ApuestaServicio {
	private static final String NOSEENCUENTRA="No se a encontrado la ruleta";
	@Autowired
	RuletaRepository ruletaRepository;
	@Autowired
	JuegoServicio juegoService;

	@Override
	public void abrirApuestas(String id) throws ServicioException {
		Ruleta ruleta;	
		Optional<Ruleta> opcionalRuleta = ruletaRepository.findById(id);
		if(opcionalRuleta.isPresent()) {
			ruleta=opcionalRuleta.get();
			if(!ruleta.getEstado()) {		
				ruleta.setEstado(true);
				ruleta.getJuegos().add(new Juego(ruleta.getJuegos().size(),ruleta.getId()));
				ruletaRepository.save(ruleta);			
			}else {
				throw new ServicioException("La ruleta "+id+" ya se encuentra abierta");			
			}
		}else {
			throw new ServicioException(NOSEENCUENTRA);
		}
		
		
	}

	@Override
	public Resultado cerrarApuestas(String id) throws ServicioException {
		Optional<Ruleta> opcionalRuleta = ruletaRepository.findById(id);
		if(opcionalRuleta.isPresent()) {
			Ruleta ruleta = opcionalRuleta.get();
			if(ruleta.getEstado()) {	
				ruleta.setEstado(false);
				ruleta.getJuegos().get(ruleta.getJuegos().size()-1).setNumeroGanador(juegoService.lanzarBola());
				ruleta.getJuegos().get(ruleta.getJuegos().size()-1).setFechaFin(LocalDateTime.now());		
				ruletaRepository.save(ruleta);
				return (juegoService.pagarApuesta(ruleta.getJuegos().get(ruleta.getJuegos().size()-1)));			
			}else {			
				throw new ServicioException("La ruleta "+id+" ya se encuentra cerrada");
			}
		}else {
			throw new ServicioException(NOSEENCUENTRA);
		}
		
		
		
	}

	@Override
	public void creacionApuesta(String id, Apuesta apuesta) throws ServicioException {
		Optional<Ruleta> opcionalRuleta = ruletaRepository.findById(id);
		if(opcionalRuleta.isPresent()) {
			Ruleta ruleta = opcionalRuleta.get();
			if(ruleta.getEstado()) {
				List<Apuesta> apuestas = ruleta.getJuegos().get(ruleta.getJuegos().size()-1).getApuestas();	
				apuestas.add(apuesta);	
				ruletaRepository.save(ruleta);
			}else {
				throw new ServicioException("La ruleta numero "+id+" ya se encuentra cerrada para apuestas");
			}
		}else {
			throw new ServicioException(NOSEENCUENTRA);
		}
	
		
	}

}
