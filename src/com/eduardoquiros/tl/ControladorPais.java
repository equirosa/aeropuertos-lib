package com.eduardoquiros.tl;

import com.eduardoquiros.bl.dao.factory.DaoFactory;
import com.eduardoquiros.bl.dao.pais.IPaisDao;
import com.eduardoquiros.bl.dao.pais.Pais;
import com.eduardoquiros.excepciones.OmniVuelosException;
import com.eduardoquiros.utils.Mensajes;

import java.sql.SQLException;

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
	
	public Pais buscarPorCodigo(String codigo){
		try {
			return daoObject.buscarPorCodigo(codigo);
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
}
