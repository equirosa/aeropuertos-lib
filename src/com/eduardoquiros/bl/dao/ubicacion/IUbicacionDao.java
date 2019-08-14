package com.eduardoquiros.bl.dao.ubicacion;

import java.util.ArrayList;

public interface IUbicacionDao {
	void insertar(String codigo, String nombre, String aeropuerto) throws Exception;
	ArrayList<Ubicacion> getUbicaciones() throws Exception;
	void eliminar(String codigo)throws Exception;
	void modificar(String codigo, String nombre, String aeropuerto) throws Exception;
	
}
