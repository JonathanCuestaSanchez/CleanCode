package com.prueba.servicios.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.modelo.Ruleta;
import com.prueba.repositorio.RuletaRepository;
import com.prueba.servicios.RuletaServicio;
@Service
public class RuletaServicioImpl implements RuletaServicio {
	@Autowired
	RuletaRepository ruletaRepository;
	
	@Override
	public long creacionRuleta() {			
		Ruleta ruleta = new Ruleta(ruletaRepository.count()+1);
		ruletaRepository.save(ruleta);				
		return ruleta.getId();
	}
	
	@Override
	public HashMap<Long,String> consultarRuletas()  {	
		HashMap<Long,String> estados = new HashMap<>();
		Iterable<Ruleta> ruletas = (Iterable<Ruleta>) ruletaRepository.findAll();
		for (Ruleta ruleta : ruletas) {
			if(ruleta.getEstado()) {
				estados.put(ruleta.getId(), "Abierta");
			}else {
				estados.put(ruleta.getId(), "Cerrada");
			}	        
	    }
		return estados;		
	}

}
