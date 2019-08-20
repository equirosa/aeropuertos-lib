package com.eduardoquiros.bl.dao.aerolinea;

import com.eduardoquiros.bl.dao.pais.Pais;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public interface IAerolineaDao {
	void insertar(String cedulaJuridica, String nombreComercial, String nombreEmpresaDuenna, BufferedImage logo, Pais localidad) throws Exception;
	ArrayList<Aerolinea> getAerolineas()throws Exception;
	void eliminar(String cedulaJuridica)throws Exception;
	void modificar(String cedulaJuridica, String nombreComercial, String nombreEmpresaDuenna, BufferedImage logo, Pais localidad) throws Exception;
	Aerolinea buscarPorCodigo(String cedulaJuridica) throws Exception;
}
