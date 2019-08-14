package com.eduardoquiros.tl;

import com.eduardoquiros.bl.dao.factory.DaoFactory;
import com.eduardoquiros.bl.dao.pais.IPaisDao;
import com.eduardoquiros.excepciones.OmniVuelosException;
import com.eduardoquiros.utils.Mensajes;

import java.sql.SQLException;

public class ControladorPais {
	DaoFactory factory;
	IPaisDao daoObject
	
	public ControladorPais() {
		factory = DaoFactory.getDaoFactory(DaoFactory.MySQL);
		daoObject = factory.getPaisDao();
	}
	
	public OmniVuelosException insertar(String codigo, String nombre, String abreviatura){
		try {
			daoObject.insertar(codigo,nombre,abreviatura);
		} catch (SQLException e) {
			int error = e.getErrorCode();
			OmniVuelosException exc = new OmniVuelosException(error);
			return exc;
		} catch (Exception e) {
			return new OmniVuelosException(e.getMessage());
		}
		return null;
	}
}
