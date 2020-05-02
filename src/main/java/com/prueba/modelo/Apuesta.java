package com.prueba.modelo;

import java.time.LocalDateTime;

public class Apuesta {
	
	private int cliente;
	private int cantidad;
	private int numeroApostado;
	private LocalDateTime fecha;
	
	
	public Apuesta() {
		super();
		fecha= LocalDateTime.now();
	}


	public int getCliente() {
		return cliente;
	}


	public void setCliente(int cliente) {
		this.cliente = cliente;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public int getNumeroApostado() {
		return numeroApostado;
	}


	public void setNumeroApostado(int numeroApostado) {
		this.numeroApostado = numeroApostado;
	}


	public LocalDateTime getFecha() {
		return fecha;
	}


	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	
	
	
}
