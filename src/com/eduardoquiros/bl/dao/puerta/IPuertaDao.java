package com.eduardoquiros.bl.dao.puerta;

import java.util.ArrayList;

public interface IPuertaDao {
	void insertar(String codigo) throws Exception;
	ArrayList<Puerta> getPuertas() throws Exception;
	void eliminar(String codigo)throws Exception;
	void modificar(String codigo) throws Exception;
	Puerta buscarPorCodigo(String codigo) throws Exception;
}
