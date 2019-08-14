package com.eduardoquiros.bl.dao.ubicacion;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IUbicacionDao {
	void insertar(String codigo, String nombre, String aeropuerto) throws Exception;
	ArrayList<Ubicacion> getUbicaciones() throws Exception;
}
