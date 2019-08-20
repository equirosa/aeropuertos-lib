package com.eduardoquiros.bl.dao.tripulante;

import com.eduardoquiros.bl.dao.persona.Persona;
import com.eduardoquiros.bl.dao.pais.Pais;

import java.time.LocalDate;

public class Tripulante extends Persona {
	private int annosExp;
	private String numLicencia, puesto, telefono;
	private LocalDate fechaGraduacion;
	private char genero;
	
	public Tripulante() {
	}
	
	public Tripulante(String nombre, String apellido1, String apellido2, String cedula, String email, String direccion,
	                  Pais nacionalidad,char genero, LocalDate fechaNacimiento, int annosExp, String numLicencia,
	                  String puesto, String telefono, LocalDate fechaGraduacion) {
		super(nombre, apellido1, apellido2, cedula, email, direccion, nacionalidad, fechaNacimiento);
		this.annosExp = annosExp;
		this.numLicencia = numLicencia;
		this.puesto = puesto;
		this.telefono = telefono;
		this.fechaGraduacion = fechaGraduacion;
		this.genero = genero;
	}
	
	public char getGenero() {
		return genero;
	}
	
	public void setGenero(char genero) {
		this.genero = genero;
	}
	
	public int getAnnosExp() {
		return annosExp;
	}
	
	public void setAnnosExp(int annosExp) {
		this.annosExp = annosExp;
	}
	
	public String getNumLicencia() {
		return numLicencia;
	}
	
	public void setNumLicencia(String numLicencia) {
		this.numLicencia = numLicencia;
	}
	
	public String getPuesto() {
		return puesto;
	}
	
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public LocalDate getFechaGraduacion() {
		return fechaGraduacion;
	}
	
	public void setFechaGraduacion(LocalDate fechaGraduacion) {
		this.fechaGraduacion = fechaGraduacion;
	}
	
	@Override
	public String toString() {
		return "Tripulante{" +
				"annosExp=" + annosExp +
				", numLicencia='" + numLicencia + '\'' +
				", puesto='" + puesto + '\'' +
				", telefono='" + telefono + '\'' +
				", fechaGraduacion=" + fechaGraduacion +
				", genero=" + genero +
				"} " + super.toString();
	}
}
