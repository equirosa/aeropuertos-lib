package com.eduardoquiros.bl.dao.cliente;

import com.eduardoquiros.bl.dao.persona.Persona;
import com.eduardoquiros.bl.dao.pais.Pais;

import java.time.LocalDate;
import java.time.Period;

public class Cliente extends Persona {
	protected int edad;
	
	public Cliente() {
	}
	
	public Cliente(String nombre, String apellido1, String apellido2, String cedula, String email, String contrasenna,
	               String direccion,
	               Pais nacionalidad, LocalDate fechaNacimiento, int edad) {
		super(nombre, apellido1, apellido2, cedula, email,contrasenna, direccion, nacionalidad, fechaNacimiento);
		this.edad = edad;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	private void calcularEdad(LocalDate fechaNacimiento) {
		edad = Period.between(fechaNacimiento,LocalDate.now()).getYears();
	}
	
	@Override
	public String toString() {
		return "Cliente{" +
				"edad=" + edad +
				"} " + super.toString();
	}
}
