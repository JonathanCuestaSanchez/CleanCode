package com.prueba.modelo;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author jonathan cuesta 
 * clase que representa el resultado de un juego de ruleta
 */
public class Resultado {	
	
	private long ruleta;
	private int numeroJuegoMesa;
	private LocalDateTime  fechaInicio;
	private LocalDateTime  fechaFin;
	private List<Apuesta> apuestas ;
	private int numeroGanador;
	private HashMap<Integer,Long> resultadosClientes;
	
	public Resultado(long ruleta, int numeroJuegoMesa, LocalDateTime fechaInicio, LocalDateTime fechaFin,
			List<Apuesta> apuestas, int numeroGanador) {
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

	public int getNumeroGanador() {
		return numeroGanador;
	}

	public void setNumeroGanador(int numeroGanador) {
		this.numeroGanador = numeroGanador;
	}

	public Map<Integer, Long> getResultadosClientes() {
		return resultadosClientes;
	}

	public void setResultadosClientes(HashMap<Integer, Long> resultadosClientes) {
		this.resultadosClientes = resultadosClientes;
	}

	public List<Apuesta> getApuestas() {
		return apuestas;
	}

	public void setApuestas(List<Apuesta> apuestas) {
		this.apuestas = apuestas;
	}
	
	
	
	
	
	
	 
	

}
