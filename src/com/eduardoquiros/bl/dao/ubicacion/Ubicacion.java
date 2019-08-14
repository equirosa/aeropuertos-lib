package com.eduardoquiros.bl.dao.ubicacion;

public class Ubicacion {
    private String codigo, nombre;

    public Ubicacion() {
    }

    public Ubicacion(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ubicacion ubicacion = (Ubicacion) o;

        return getCodigo().equals(ubicacion.getCodigo());

    }

    @Override
    public String toString() {
        return "Ubicacion{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
