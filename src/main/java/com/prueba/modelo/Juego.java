package com.prueba.modelo;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class Juego {
	
	private int id;
	private long ruleta;
	private LocalDateTime  fechaInicio;
	private LocalDateTime   fechaFin;
	private HashMap<Integer,List<Apuesta>> apuestas ;
	private int numeroGanador;
	
	
	public Juego(int id, long ruleta) {
		super();
		this.id = id;
		this.ruleta = ruleta;
		fechaInicio= LocalDateTime.now();
		fechaFin= null;
		apuestas=new HashMap<>();		
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


	public HashMap<Integer, List<Apuesta>> getApuestas() {
		return apuestas;
	}


	public void setApuestas(HashMap<Integer, List<Apuesta>> apuestas) {
		this.apuestas = apuestas;
	}


	public int getNumeroGanador() {
		return numeroGanador;
	}


	public void setNumeroGanador(int numeroGanador) {
		this.numeroGanador = numeroGanador;
	}


	
	
	
	
	
	
	
	
	
	

}
