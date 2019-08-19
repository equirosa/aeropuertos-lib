package com.eduardoquiros.bl.dao.usuario;

import com.eduardoquiros.bl.dao.persona.Persona;
import com.eduardoquiros.bl.dao.pais.Pais;

import java.time.LocalDate;

public class Usuario extends Persona {
	protected int edad;
	
	public Usuario() {
	}
	
	public Usuario(String nombre, String apellido1, String apellido2, String cedula, String email, String direccion,
	               Pais nacionalidad, LocalDate fechaNacimiento, int edad) {
		super(nombre, apellido1, apellido2, cedula, email, direccion, nacionalidad, fechaNacimiento);
		this.edad = edad;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@Override
	public String toString() {
		return "Usuario{" +
				"edad=" + edad +
				"} " + super.toString();
	}
}
