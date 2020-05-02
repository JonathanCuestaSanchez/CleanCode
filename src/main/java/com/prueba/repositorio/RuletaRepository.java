package com.prueba.repositorio;

import java.util.Map;

import org.springframework.data.repository.CrudRepository;

import com.prueba.modelo.Ruleta;

public interface RuletaRepository extends CrudRepository<Ruleta,String> {
	
}
