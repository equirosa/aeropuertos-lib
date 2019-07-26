package com.eduardoquiros.dl;

import com.eduardoquiros.bl.Admin;
import com.eduardoquiros.bl.Aeropuerto;
import com.eduardoquiros.bl.Pais;

import java.util.ArrayList;

public class Logica {
    private double impuesto;
    private ArrayList<Admin> administradores = new ArrayList<Admin>();
    private ArrayList<Pais> paises = new ArrayList<>();
    private ArrayList<Aeropuerto> aeropuertos = new ArrayList<>();

    public Logica() {
    }

    //Verifica si hay al menos una entrada en el ArrayList de administradores.
    public boolean verificarExistenciaAdmin() {
        if (administradores.size() != 0) {
            return true;
        }
        return false;
    }

    //Agrega Admin a lista.
    public void registrarAdmin(Admin tmpAdmin) {
        administradores.add(tmpAdmin);
    }

    //Cambia la tasa de impuesto.
    public double getImpuesto() {
        return impuesto;
    }

    //Retorna la tasa de impuesto.
    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    //Regresa la comparacion de si la lista contiene algo.
    public boolean verificarExistenciaAeropuerto() {
        return (aeropuertos.size() != 0);
    }

    public void registrarPais(Pais tmpPais) {
        
    }
}
