package com.eduardoquiros.bl.dao.tiquete;

import com.eduardoquiros.bl.dao.vuelo.Vuelo;

public class Tiquete {
	String numero,asiento,tipoAsiento;
	double precio;
	Vuelo viaje;
	
	public Tiquete(String numero, String asiento, String tipoAsiento, double precio, Vuelo viaje) {
		this.numero = numero;
		this.asiento = asiento;
		this.tipoAsiento = tipoAsiento;
		this.precio = precio;
		this.viaje = viaje;
	}
	
	public Tiquete() {
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getAsiento() {
		return asiento;
	}
	
	public void setAsiento(String asiento) {
		this.asiento = asiento;
	}
	
	public String getTipoAsiento() {
		return tipoAsiento;
	}
	
	public void setTipoAsiento(String tipoAsiento) {
		this.tipoAsiento = tipoAsiento;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public Vuelo getViaje() {
		return viaje;
	}
	
	public void setViaje(Vuelo viaje) {
		this.viaje = viaje;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		Tiquete tiquete = (Tiquete) o;
		
		return getNumero().equals(tiquete.getNumero());
		
	}
	
	@Override
	public String toString() {
		return "Tiquete{" +
				"numero='" + numero + '\'' +
				", asiento='" + asiento + '\'' +
				", tipoAsiento='" + tipoAsiento + '\'' +
				", precio=" + precio +
				", viaje=" + viaje +
				'}';
	}
}
