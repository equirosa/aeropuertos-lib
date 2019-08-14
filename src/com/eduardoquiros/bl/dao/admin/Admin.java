package com.eduardoquiros.bl.dao.admin;

import com.eduardoquiros.bl.dao.pais.Pais;
import com.eduardoquiros.bl.Persona;

import java.time.LocalDate;
import java.time.Period;

public class Admin extends Persona {
    private int edad;
    private char genero;
    
    public Admin(String nombre, String apellido1, String apellido2, String cedula, String email, String direccion, Pais nacionalidad, LocalDate fechaNacimiento, int edad, char genero) {
        super(nombre, apellido1, apellido2, cedula, email, direccion, nacionalidad, fechaNacimiento);
        this.edad = edad;
        this.genero = genero;
    }
    
    public Admin() {
    }

    public Admin(String nombre, String apellido1, String apellido2, String cedula, String email, String direccion,
                 Pais nacionalidad, LocalDate fechaNacimiento, char genero) {
        super(nombre, apellido1, apellido2, cedula, email, direccion, nacionalidad, fechaNacimiento);
        calcularEdad(fechaNacimiento);
        this.genero = genero;
    }

    private void calcularEdad(LocalDate fechaNacimiento) {
        edad = Period.between(fechaNacimiento,LocalDate.now()).getYears();
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getGenero() {
        return genero;
    }

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
