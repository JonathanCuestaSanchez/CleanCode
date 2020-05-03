package com.prueba.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.prueba.modelo.Ruleta;
/**
 * @author jonathan cuesta 
 * clase que se encarga de la persistencia con la base de datos REDIS
 */
public interface RuletaRepository extends CrudRepository<Ruleta,String> {
	
}
