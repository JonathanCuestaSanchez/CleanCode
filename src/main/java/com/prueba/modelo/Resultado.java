package com.prueba.modelo;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class Resultado {	
	
	private long ruleta;
	private int numeroJuegoMesa;
	private LocalDateTime  fechaInicio;
	private LocalDateTime  fechaFin;
	private HashMap<Integer,List<Apuesta>> apuestas ;
	private int numeroGanador;
	private HashMap<Integer,Long> resultadosClientes;
	
	public Resultado(long ruleta, int numeroJuegoMesa, LocalDateTime fechaInicio, LocalDateTime fechaFin,
			HashMap<Integer,List<Apuesta>> apuestas, int numeroGanador) {
		super();
		this.ruleta = ruleta;
		this.numeroJuegoMesa = numeroJuegoMesa;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.apuestas = apuestas;
		this.numeroGanador = numeroGanador;
		resultadosClientes= new HashMap<>();
	}

	public long getRuleta() {
		return ruleta;
	}

	public void setRuleta(long ruleta) {
		this.ruleta = ruleta;
	}

	public int getNumeroJuegoMesa() {
		return numeroJuegoMesa;
	}

	public void setNumeroJuegoMesa(int numeroJuegoMesa) {
		this.numeroJuegoMesa = numeroJuegoMesa;
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

	public HashMap<Integer, Long> getResultadosClientes() {
		return resultadosClientes;
	}

	public void setResultadosClientes(HashMap<Integer, Long> resultadosClientes) {
		this.resultadosClientes = resultadosClientes;
	}
	
	
	
	
	 
	

}
