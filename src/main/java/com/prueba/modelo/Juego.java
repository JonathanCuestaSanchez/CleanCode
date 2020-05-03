package com.prueba.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.redis.core.RedisHash;


/**
 * @author jonathan cuesta 
 * clase que representa un juego de ruleta
 */
@RedisHash("Juego")
public class Juego {
	
	private int id;
	private long ruleta;
	private LocalDateTime  fechaInicio;
	private LocalDateTime   fechaFin;
	private List<Apuesta> apuestas ;
	private int numeroGanador;
	
	
	public Juego(int id, long ruleta) {
		super();
		this.id = id;
		this.ruleta = ruleta;
		fechaInicio= LocalDateTime.now();
		fechaFin= null;
		apuestas=new ArrayList<>();		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public long getRuleta() {
		return ruleta;
	}


	public void setRuleta(long ruleta) {
		this.ruleta = ruleta;
	}


	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public LocalDateTime getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}


	public int getNumeroGanador() {
		return numeroGanador;
	}


	public void setNumeroGanador(int numeroGanador) {
		this.numeroGanador = numeroGanador;
	}


	@Override
	public String toString() {
		return "Juego [id=" + id + ", ruleta=" + ruleta + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
				+ ", apuestas=" + apuestas + ", numeroGanador=" + numeroGanador + "]";
	}


	public List<Apuesta> getApuestas() {
		return apuestas;
	}


	public void setApuestas(List<Apuesta> apuestas) {
		this.apuestas = apuestas;
	}
	
	
	
	

}
