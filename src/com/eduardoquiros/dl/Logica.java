package com.eduardoquiros.dl;

import com.eduardoquiros.bl.dao.admin.Admin;
import com.eduardoquiros.bl.Aeropuerto;
import com.eduardoquiros.bl.dao.pais.Pais;

import java.util.ArrayList;

public class Logica {
    private double impuesto;
    private ArrayList<Admin> administradores = new ArrayList<>();
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
        paises.add(tmpPais);
    }

//    Devuelve un Array de Strings basado en el ArrayList "paises".
    public String[] listarPaises() {
        String[] lista = new String[paises.size()];
        int contador = 0;

        for(Pais tmpPais : paises){
            lista[contador]=tmpPais.toString();
        }
        return lista;
    }

    //Retorna el pais cuyo codigo coincida con el presentado, o retorna "null".
    public Pais buscarPaisPorCodigo(String s) {
        for(Pais tmpPais : paises){
            if (tmpPais.getCodigo().equals(s)) return tmpPais;
        }
        return null;
    }

    //Devuelve "true" si ya hay admin con esa cedula.
    public boolean verificarDuplicidadAdmin(String s) {
        for (Admin tmpAdmin : administradores){
            if(tmpAdmin.getCedula().equals(s)) return true;
        }
        return false;
    }
}
