package com.eduardoquiros.bl.dao.tripulante;

import com.eduardoquiros.bl.dao.tripulacion.Tripulacion;

import java.util.ArrayList;

public interface ITripulanteDao {
	void insertar(String codigo) throws Exception;
	ArrayList<Tripulante> getPuertas() throws Exception;
	void eliminar(String codigo)throws Exception;
	void modificar(String codigo) throws Exception;
	Tripulacion buscarPorCodigo(String codigo) throws Exception;
	ArrayList<Tripulante> getTripulantesPorTripulacion(String ubicacion) throws Exception;
}
