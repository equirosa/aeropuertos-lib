package com.eduardoquiros.tl;

import com.eduardoquiros.bl.dao.admin.Admin;
import com.eduardoquiros.bl.Pais;
import com.eduardoquiros.dl.Logica;

import java.time.LocalDate;

public class Gestor {
    private Logica CL = new Logica();

    //Esta funcion le pregunta a la CL si existe algun administrador.
    public boolean verirficarExistenciaAdmin() {
        return CL.verificarExistenciaAdmin();
    }

    //Convierte los datos en Admin y envia a CL.
    public void registrarAdmin(String[] infoPersona, char infoAdmin) {
        Admin tmpAdmin = new Admin(infoPersona[0],infoPersona[1],infoPersona[2],infoPersona[3],infoPersona[4],
                infoPersona[5],CL.buscarPaisPorCodigo(infoPersona[9]), LocalDate.of((Integer.parseInt(infoPersona[6])),
                Integer.parseInt(infoPersona[7]),Integer.parseInt(infoPersona[8])), infoAdmin);
        CL.registrarAdmin(tmpAdmin);
    }

    public boolean verificarExistenciaAdmin() {
        return CL.verificarExistenciaAeropuerto();
    }

    public double getImpuesto() {
        return CL.getImpuesto();
    }

    public void setImpuesto(double impuesto) {
        CL.setImpuesto(impuesto);
    }

    //Genera nuevo Pais y lo envia a CL.
    public void registrarPais(String codigo, String nombre, String abreviacion) {
        Pais tmpPais = new Pais(codigo,nombre,abreviacion);
        CL.registrarPais(tmpPais);
    }

    //Pasa el Array desde la CL al Main
    public String[] listarPaises() {
        return CL.listarPaises();
    }

    public boolean verificarDuplicidadAdmin(String s) {
        return CL.verificarDuplicidadAdmin(s);
    }
}
