package com.eduardoquiros.bl.dao.avion;

import com.eduardoquiros.bl.dao.aerolinea.Aerolinea;

import java.util.ArrayList;

public interface IAvionDao {
	void insertar(String placa, String marca, String modelo, int capacidad, Aerolinea propietaria) throws Exception;
	ArrayList<Avion> getAviones() throws Exception;
	void eliminar(String placa)throws Exception;
	void modificar(String placa, String marca, String modelo, int capacidad, Aerolinea propietaria) throws Exception;
	Avion buscarPorCodigo(String placa) throws Exception;
}
