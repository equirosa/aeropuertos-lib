package com.eduardoquiros.bl.dao.avion;

import com.eduardoquiros.bl.dao.aerolinea.Aerolinea;

public class Avion {
	private String placa, marca,modelo;
	private int capacidad;
	private Aerolinea propietaria;
	
	public Avion() {
	}
	
	public Avion(String placa, String marca, String modelo, int capacidad, Aerolinea propietaria) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.capacidad = capacidad;
		this.propietaria = propietaria;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public int getCapacidad() {
		return capacidad;
	}
	
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	public Aerolinea getPropietaria() {
		return propietaria;
	}
	
	public void setPropietaria(Aerolinea propietaria) {
		this.propietaria = propietaria;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		Avion avion = (Avion) o;
		
		return getPlaca().equals(avion.getPlaca());
		
	}
	
	@Override
	public String toString() {
		return "Avion{" +
				"placa='" + placa + '\'' +
				", marca='" + marca + '\'' +
				", modelo='" + modelo + '\'' +
				", capacidad=" + capacidad +
				", propietaria=" + propietaria +
				'}';
	}
}
