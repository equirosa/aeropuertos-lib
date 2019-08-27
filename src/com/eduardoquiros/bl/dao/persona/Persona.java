package com.eduardoquiros.bl.dao.persona;

import com.eduardoquiros.bl.dao.pais.Pais;

import java.time.LocalDate;

public class Persona {
	protected String nombre, apellido1, apellido2, cedula,email, direccion, contrasenna;
	protected Pais nacionalidad;
	protected LocalDate fechaNacimiento;
	
	public Persona() {
	}
	
	public Persona(String nombre, String apellido1, String apellido2, String cedula, String email,String contrasenna,
	               String direccion, Pais nacionalidad, LocalDate fechaNacimiento) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.cedula = cedula;
		this.email = email;
		this.contrasenna = contrasenna;
		this.direccion = direccion;
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getContrasenna() {
		return contrasenna;
	}
	
	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido1() {
		return apellido1;
	}
	
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	
	public String getApellido2() {
		return apellido2;
	}
	
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	
	public String getCedula() {
		return cedula;
	}
	
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public Pais getNacionalidad() {
		return nacionalidad;
	}
	
	public void setNacionalidad(Pais nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		Persona persona = (Persona) o;
		
		return getCedula().equals(persona.getCedula());
		
	}
	
	@Override
	public String toString() {
		return "Persona{" +
				"nombre='" + nombre + '\'' +
				", apellido1='" + apellido1 + '\'' +
				", apellido2='" + apellido2 + '\'' +
				", cedula='" + cedula + '\'' +
				", email='" + email + '\'' +
				", direccion='" + direccion + '\'' +
				", nacionalidad=" + nacionalidad +
				", fechaNacimiento=" + fechaNacimiento +
				'}';
	}
}
