package com.eduardoquiros.dl;

import com.eduardoquiros.bl.Pais;
import com.eduardoquiros.bl.Persona;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Logica {
    private double impuesto;
    private ArrayList<Pais> paises = new ArrayList<>();
    private final String PAISES = "Paises.txt";

    public Logica() {
        leerArchivos();
    }

    private void leerArchivos() {
        leerPaises();
    }

    private void leerPaises() {
        try{
            BufferedReader reader = new BufferedReader(new FileReader(PAISES));
            String datos;

            while ((datos = reader.readLine()) != null){
                String[] pais = datos.split(",");

                Pais tmpPais = new Pais(pais[0],pais[1],pais[2]);

                paises.add(tmpPais);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
