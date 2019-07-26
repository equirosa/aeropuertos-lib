package com.eduardoquiros.dl;

import com.eduardoquiros.bl.Admin;
import com.eduardoquiros.bl.Pais;

import java.io.*;
import java.util.ArrayList;

public class Logica {
    private double impuesto;
    private ArrayList<Pais> paises = new ArrayList<>();
    private ArrayList<Admin> administradores = new ArrayList<Admin>();
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

    public void guardar(Pais tmpPais){
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

    //Verifica si hay al menos una entrada en el ArrayList de administradores.
    public boolean verificarExistenciaAdmin() {
        if (administradores.size() != 0) {
            return true;
        }
        return false;
    }
}
