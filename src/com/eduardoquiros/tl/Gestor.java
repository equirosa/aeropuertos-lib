package com.eduardoquiros.tl;

import com.eduardoquiros.bl.Admin;
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
                infoPersona[5], LocalDate.of((Integer.parseInt(infoPersona[6]),Integer.parseInt(infoPersona[7]),
                Integer.parseInt(infoPersona[8])), infoAdmin);
        CL.registrarAdmin(tmpAdmin);
    }

    public boolean verificarExistenciaAdmin() {
        return CL.verificarExistenciaAeropuerto();
    }
}
