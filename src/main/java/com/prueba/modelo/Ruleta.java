package com.prueba.modelo;


import java.util.ArrayList;
import java.util.List;
import org.springframework.data.redis.core.RedisHash;




@RedisHash("Ruleta")
public class Ruleta  {
	
	private long id;
	private Boolean estado;
	private List<Juego> juegos;
	
	
	
	public Ruleta(long id) {
		super();
		this.id = id;
		estado=false;
		juegos=new ArrayList<>();
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public Boolean getEstado() {
		return estado;
	}



	public void setEstado(Boolean estado) {
		this.estado = estado;
	}



	public List<Juego> getJuegos() {
		return juegos;
	}



	public void setJuegos(List<Juego> juegos) {
		this.juegos = juegos;
	}
	
	
	
	
	

}
