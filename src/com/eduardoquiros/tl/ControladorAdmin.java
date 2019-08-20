package com.eduardoquiros.tl;

import com.eduardoquiros.bl.dao.admin.Admin;
import com.eduardoquiros.bl.dao.admin.IAdminDao;
import com.eduardoquiros.bl.dao.factory.DaoFactory;
import com.eduardoquiros.bl.dao.pais.IPaisDao;
import com.eduardoquiros.excepciones.OmniVuelosException;
import com.eduardoquiros.utils.Mensajes;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class ControladorAdmin {
	DaoFactory factory;
	IAdminDao daoObject;
	IPaisDao daoPais;
	public ControladorAdmin() {
		factory = DaoFactory.getDaoFactory(DaoFactory.MySQL);
		daoObject = factory.getAdminDao();
		daoPais = factory.getPaisDao();
	}
	
	public String insertar(String nombre, String apellido1, String apellido2, String cedula, String email, String direccion,
	                       String nacionalidad, LocalDate fechaNacimiento, char genero){
		try {
			daoObject.insertar(nombre,apellido1,apellido2,cedula,email,direccion,daoPais.buscarPorCodigo(nacionalidad),fechaNacimiento,
					genero, Period.between(fechaNacimiento,LocalDate.now()).getYears());
		} catch (SQLException e) {
			return new OmniVuelosException(e.getErrorCode()).numeroToString();
		} catch (Exception e) {
			return new OmniVuelosException(e.getMessage()).numeroToString();
		}
		return Mensajes.MNSJ_EXITO;
	}
	
	public String buscarPorCodigo(String cedula){
		try {
			return daoObject.buscarPorCodigo(cedula).toString();
		} catch (SQLException e) {
			return new OmniVuelosException(e.getErrorCode()).numeroToString();
		} catch (Exception e) {
			return new OmniVuelosException(e.getMessage()).numeroToString();
		}
	}
	
	public String eliminar(String cedula){
		try{
			daoObject.eliminar(cedula);
		}catch (SQLException e){
			return new OmniVuelosException(e.getErrorCode()).numeroToString();
		} catch (Exception e) {
			return new OmniVuelosException(e.getMessage()).numeroToString();
		}
		return Mensajes.MNSJ_EXITO;
	}
	
	public String modificar(String nombre, String apellido1, String apellido2, String cedula, String email, String direccion,
	                        String nacionalidad, LocalDate fechaNacimiento, char genero){
		try {
			daoObject.modificar(nombre,apellido1,apellido2,cedula,email,direccion,daoPais.buscarPorCodigo(nacionalidad),
					fechaNacimiento,genero,Period.between(fechaNacimiento,LocalDate.now()).getYears());
		} catch (SQLException e) {
			return new OmniVuelosException(e.getErrorCode()).numeroToString();
		} catch (Exception e) {
			return new OmniVuelosException(e.getMessage()).numeroToString();
		}
		return Mensajes.MNSJ_EXITO;
	}
	public String[] listar(){
		String[] lista = new String[1];
		ArrayList<Admin> admins;
		try{
			admins = daoObject.getAdmins();
		}catch (SQLException e){
			lista[0] = new OmniVuelosException(e.getErrorCode()).numeroToString();
			return lista;
		} catch (Exception e) {
			lista[0] = new OmniVuelosException(e.getMessage()).numeroToString();
			return lista;
		}
		lista = new String[admins.size()];
		int posicion = 0;
		for(Admin tmpAdmin : admins){
			lista[posicion] = tmpAdmin.toString();
			posicion++;
		}
		return lista;
	}
	
	public boolean noAdmins() {
		try {
			return daoObject.noAdmins();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
