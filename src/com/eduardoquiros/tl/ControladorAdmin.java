package com.eduardoquiros.tl;

import com.eduardoquiros.bl.dao.admin.Admin;
import com.eduardoquiros.bl.dao.admin.IAdminDao;
import com.eduardoquiros.bl.dao.factory.DaoFactory;
import com.eduardoquiros.bl.dao.pais.IPaisDao;

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
	
	public void insertar(String nombre, String apellido1, String apellido2, String cedula, String email,String contrasenna, String direccion,
	                     String nacionalidad, LocalDate fechaNacimiento, char genero) throws Exception {
			daoObject.insertar(nombre,apellido1,apellido2,cedula,email,contrasenna,direccion,daoPais.buscarPorCodigo(nacionalidad)
					,fechaNacimiento,
					genero, Period.between(fechaNacimiento,LocalDate.now()).getYears());
	}
	
	public String buscarPorCodigo(String cedula) throws Exception {
			return daoObject.buscarPorCodigo(cedula).toString();
	}
	
	public void eliminar(String cedula) throws Exception {
			daoObject.eliminar(cedula);
	}
	
	public void modificar(String nombre, String apellido1, String apellido2, String cedula, String email, String direccion,
	                        String nacionalidad, LocalDate fechaNacimiento, char genero) throws Exception {
			daoObject.modificar(nombre,apellido1,apellido2,cedula,email,direccion,daoPais.buscarPorCodigo(nacionalidad),
					fechaNacimiento,genero,Period.between(fechaNacimiento,LocalDate.now()).getYears());
	}
	public String[] listar() throws Exception {
		String[] lista;
		ArrayList<Admin> admins;
			admins = daoObject.getAdmins();
		lista = new String[admins.size()];
		int posicion = 0;
		for(Admin tmpAdmin : admins){
			lista[posicion] = tmpAdmin.toString();
			posicion++;
		}
		return lista;
	}
	
	public boolean noAdmins() throws Exception {
		return daoObject.noAdmins();
	}
}
