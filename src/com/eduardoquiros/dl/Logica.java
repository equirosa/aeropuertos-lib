package com.eduardoquiros.dl;

import com.eduardoquiros.bl.Admin;

import java.util.ArrayList;

public class Logica {
    private double impuesto;
    private ArrayList<Admin> administradores = new ArrayList<Admin>();

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

    public boolean verificarExistenciaAeropuerto() {
    }
}
