package com.eduardoquiros.bl.dao.admin;

import com.eduardoquiros.bl.dao.pais.Pais;
import com.eduardoquiros.bl.dao.persona.Persona;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author Eduardo Quiros
 * @since 2019-08-21
 * @version 1.0
 */
public class Admin extends Persona {
	private int edad;
	private char genero;
	
	/**
	 * Constructor cargado de Admin.
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param cedula
	 * @param email
	 * @param direccion
	 * @param nacionalidad
	 * @param fechaNacimiento
	 * @param edad
	 * @param genero
	 */
	public Admin(String nombre, String apellido1, String apellido2, String cedula, String email, String direccion, Pais nacionalidad, LocalDate fechaNacimiento, int edad, char genero) {
		super(nombre, apellido1, apellido2, cedula, email, direccion, nacionalidad, fechaNacimiento);
		this.edad = edad;
		this.genero = genero;
	}
	
	/**
	 * Constructor por defecto de Admin.
	 */
	public Admin() {
	}
	
	/**
	 * Constructor semicargado de Admin que calcula automaticamente el valor del campo edad.
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param cedula
	 * @param email
	 * @param direccion
	 * @param nacionalidad
	 * @param fechaNacimiento
	 * @param genero
	 */
	public Admin(String nombre, String apellido1, String apellido2, String cedula, String email, String direccion,
	             Pais nacionalidad, LocalDate fechaNacimiento, char genero) {
		super(nombre, apellido1, apellido2, cedula, email, direccion, nacionalidad, fechaNacimiento);
		calcularEdad(fechaNacimiento);
		this.genero = genero;
	}
	
	/**
	 * Calula la edad basado en la fecha de nacimiento.
	 * @param fechaNacimiento
	 */
	private void calcularEdad(LocalDate fechaNacimiento) {
		edad = Period.between(fechaNacimiento,LocalDate.now()).getYears();
	}
	
	/**
	 *
	 * @return Retorna el valor del atributo edad.
	 */
	public int getEdad() {
		return edad;
	}
	
	/**
	 * Asigna el valor recibido al atributo edad.
	 * @param edad
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	/**
	 *
	 * @return Retorna el valor del atributo genero.
	 */
	public char getGenero() {
		return genero;
	}
	
	/**
	 * Asigna un valor arbitrario al atributo genero.
	 * @param genero
	 */
	public void setGenero(char genero) {
		this.genero = genero;
	}
	
	@Override
	public String toString() {
		return "Admin{" +
				"edad=" + edad +
				", genero=" + genero +
				"} " + super.toString();
	}
}
