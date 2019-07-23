package com.eduardoquiros.dl;

import com.eduardoquiros.bl.Pais;
import com.eduardoquiros.bl.Persona;

import java.io.*;
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

    private void guardar(Pais tmpPais){
        try {
            crearArchivoPaises();
            BufferedWriter buffer = new BufferedWriter(new FileWriter(PAISES,true));

            buffer.write(tmpPais.stringToCSV());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void crearArchivoPaises() {
        File paises = new File(PAISES);
        try {
            paises.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
