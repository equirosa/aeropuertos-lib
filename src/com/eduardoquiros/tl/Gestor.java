package com.eduardoquiros.tl;

import com.eduardoquiros.bl.Pais;
import com.eduardoquiros.dl.Logica;

public class Gestor {
    private Logica CL = new Logica();

    private void guardarPais(String codigo, String nombre, String abreviatura){
        Pais tmpPais = new Pais(codigo,nombre,abreviatura);
        CL.guardar(tmpPais);
    }
}
