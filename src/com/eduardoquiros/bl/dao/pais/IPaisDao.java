package com.eduardoquiros.bl.dao.pais;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IPaisDao {
	void insertar(String codigo, String nombre, String abreviatura) throws Exception;
	ArrayList<Pais> getPaises() throws Exception;
	void eliminar(String codigo)throws Exception;
	void modificar(String codigo, String nombre, String abreviatura) throws Exception;
	Pais buscarPorCodigo(String codigo) throws Exception;
}
