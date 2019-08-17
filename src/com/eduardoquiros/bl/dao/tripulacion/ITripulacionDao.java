package com.eduardoquiros.bl.dao.tripulacion;

import java.util.ArrayList;

public interface ITripulacionDao {
	void insertar(String codigo, String nombre) throws Exception;
	ArrayList<Tripulacion> getTripulaciones() throws Exception;
	void eliminar(String codigo)throws Exception;
	void modificar(String codigo, String nombre) throws Exception;
	Tripulacion buscarPorCodigo(String codigo) throws Exception;
}
