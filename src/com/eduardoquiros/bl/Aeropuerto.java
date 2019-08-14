package com.eduardoquiros.bl;

import com.eduardoquiros.bl.dao.admin.Admin;
import com.eduardoquiros.bl.dao.pais.Pais;
import com.eduardoquiros.bl.dao.ubicacion.Ubicacion;

import java.util.ArrayList;

public class Aeropuerto {
    private String codigo,nombre;
    private Pais lugar;
    private Admin supervisor;
    private ArrayList<Ubicacion> ubicaciones;

    public Aeropuerto(String codigo, String nombre, Pais lugar, Admin supervisor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.lugar = lugar;
        this.supervisor = supervisor;
        ubicaciones = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getLugar() {
        return lugar;
    }

    public void setLugar(Pais lugar) {
        this.lugar = lugar;
    }

    public Admin getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Admin supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aeropuerto that = (Aeropuerto) o;

        return getCodigo().equals(that.getCodigo());

    }

    @Override
    public String toString() {
        return "Aeropuerto{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", lugar=" + lugar +
                ", supervisor=" + supervisor +
                ", ubicaciones=" + ubicaciones+
                '}';
    }
}
