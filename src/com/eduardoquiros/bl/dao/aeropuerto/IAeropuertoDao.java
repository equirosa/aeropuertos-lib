package com.eduardoquiros.bl.dao.aeropuerto;

import com.eduardoquiros.bl.dao.admin.Admin;
import com.eduardoquiros.bl.dao.pais.Pais;

import java.util.ArrayList;

public interface IAeropuertoDao {
	void insertar(String nombre, Pais nacionalidad, Admin supervisor) throws Exception;
	ArrayList<Aeropuerto> getAdmins() throws Exception;
	void eliminar(String codigo)throws Exception;
	void modificar(String codigo,String nombre,Pais nacionalidad,Admin supervisor) throws Exception;
	Aeropuerto buscarPorCodigo(String codigo) throws Exception;
}
