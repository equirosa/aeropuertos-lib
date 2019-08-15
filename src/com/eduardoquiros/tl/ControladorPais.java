package com.eduardoquiros.tl;

import com.eduardoquiros.bl.dao.factory.DaoFactory;
import com.eduardoquiros.bl.dao.pais.IPaisDao;
import com.eduardoquiros.bl.dao.pais.Pais;
import com.eduardoquiros.excepciones.OmniVuelosException;
import com.eduardoquiros.utils.Mensajes;

import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorPais {
	DaoFactory factory;
	IPaisDao daoObject;
	
	public ControladorPais() {
		factory = DaoFactory.getDaoFactory(DaoFactory.MySQL);
		daoObject = factory.getPaisDao();
	}
	
	public String insertar(String codigo, String nombre, String abreviatura){
		try {
			daoObject.insertar(codigo,nombre,abreviatura);
		} catch (SQLException e) {
			int error = e.getErrorCode();
			OmniVuelosException exc = new OmniVuelosException(error);
			return exc.numeroToString();
		} catch (Exception e) {
			return new OmniVuelosException(e.getMessage()).numeroToString();
		}
		return null;
	}
	
	public String buscarPorCodigo(String codigo){
		try {
			return daoObject.buscarPorCodigo(codigo).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String eliminar(String codigo){
		try {
			daoObject.eliminar(codigo);
			return Mensajes.MNSJ_EXITO;
		} catch (SQLException e) {
			return new OmniVuelosException(e.getErrorCode()).numeroToString();
		} catch (Exception e) {
			return new OmniVuelosException(e.getMessage()).numeroToString();
		}
	}
	
	public String modificar(String codigo, String nombre, String abreviatura){
		try {
			daoObject.modificar(codigo,nombre,abreviatura);
			return Mensajes.MNSJ_EXITO;
		} catch (SQLException e) {
			return new OmniVuelosException(e.getErrorCode()).numeroToString();
		} catch (Exception e) {
			return new OmniVuelosException(e.getMessage()).numeroToString();
		}
	}
	
	public String[] getPaises(){
		String[] lista = new String[1];
		ArrayList<Pais> paises;
		try {
			paises = daoObject.getPaises();
		} catch (SQLException e) {
			lista[0] = new OmniVuelosException(e.getErrorCode()).numeroToString();
			return lista;
		} catch (Exception e) {
			lista[0] = new OmniVuelosException(e.getMessage()).numeroToString();
			return lista;
		}
		lista = new String[paises.size()];
		int posicion = 0;
		for (Pais tmpPais:paises){
			lista[posicion]=tmpPais.toString();
		}
		return lista;
	}
}
