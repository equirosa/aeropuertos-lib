package com.eduardoquiros.bl.dao.tiquete;

import com.eduardoquiros.bl.dao.vuelo.Vuelo;

import java.util.ArrayList;

public interface ITiqueteDao {
	void insertar(String asiento, String tipoAsiento, double precio, Vuelo viaje) throws Exception;
	ArrayList<Tiquete> getTiquetes() throws Exception;
	void eliminar(String numero)throws Exception;
	void modificar(String numero,String asiento, String tipoAsiento, double precio, Vuelo viaje) throws Exception;
	Tiquete buscarPorCodigo(String numero) throws Exception;
}
