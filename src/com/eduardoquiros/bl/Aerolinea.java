package com.eduardoquiros.bl;

import com.eduardoquiros.bl.dao.pais.Pais;

import java.awt.image.BufferedImage;

public class Aerolinea {
    private String cedulaJuridica, nombreComercial,nombreEmpresaDuenna;
    private BufferedImage logo;
    private Pais pais;

    public Aerolinea() {
    }

    public Aerolinea(String cedulaJuridica, String nombreComercial, String nombreEmpresaDuenna, BufferedImage logo, Pais pais) {
        this.cedulaJuridica = cedulaJuridica;
        this.nombreComercial = nombreComercial;
        this.nombreEmpresaDuenna = nombreEmpresaDuenna;
        this.logo = logo;
        this.pais = pais;
    }

    public String getCedulaJuridica() {
        return cedulaJuridica;
    }

    public void setCedulaJuridica(String cedulaJuridica) {
        this.cedulaJuridica = cedulaJuridica;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getNombreEmpresaDuenna() {
        return nombreEmpresaDuenna;
    }

    public void setNombreEmpresaDuenna(String nombreEmpresaDuenna) {
        this.nombreEmpresaDuenna = nombreEmpresaDuenna;
    }

    public BufferedImage getLogo() {
        return logo;
    }

    public void setLogo(BufferedImage logo) {
        this.logo = logo;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aerolinea aerolinea = (Aerolinea) o;

        return getCedulaJuridica().equals(aerolinea.getCedulaJuridica());

    }

    @Override
    public String toString() {
        return "Aerolinea{" +
                "cedulaJuridica='" + cedulaJuridica + '\'' +
                ", nombreComercial='" + nombreComercial + '\'' +
                ", nombreEmpresaDuenna='" + nombreEmpresaDuenna + '\'' +
                ", logo=" + logo +
                ", pais=" + pais.toString() +
                '}';
    }
}
