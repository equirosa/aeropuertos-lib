package com.eduardoquiros.bl.dao.tripulacion;

import com.eduardoquiros.bl.Tripulante;

import java.util.ArrayList;

public class Tripulacion {
	private String codigo,nombre;
	private ArrayList<Tripulante> tripulantes;
	
	public Tripulacion(String codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.tripulantes = new ArrayList<>();
	}
	
	public Tripulacion() {
	}
	
	public Tripulacion(String codigo, String nombre, ArrayList<Tripulante> tripulantes) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.tripulantes = tripulantes;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public ArrayList<Tripulante> getTripulantes() {
		return tripulantes;
	}
	
	public void setTripulantes(ArrayList<Tripulante> tripulantes) {
		this.tripulantes = tripulantes;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		Tripulacion that = (Tripulacion) o;
		
		return getCodigo().equals(that.getCodigo());
		
	}
	
	@Override
	public String toString() {
		return "Tripulacion{" +
				"codigo='" + codigo + '\'' +
				", nombre='" + nombre + '\'' +
				", tripulantes=" + tripulantes +
				'}';
	}
}
