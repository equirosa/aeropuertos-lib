package com.eduardoquiros.bl.dao.admin;

import com.eduardoquiros.accesodatos.Conector;
import com.eduardoquiros.bl.Pais;

import java.time.LocalDate;
import java.util.ArrayList;

public class MySqlAdminDao implements IAdminDao{
	@Override
	public void insertar(String nombre, String apellido1, String apellido2, String cedula, String email, String direccion, Pais nacionalidad, LocalDate fechaNacimiento, char genero,int edad) throws Exception {
		Conector.getConector().ejecutarSql("insert into admin(cedula,nombre,apellido1,apellido2,email,direccion,fecha_nacimiento,nacionalidad,edad,genero " +
				"values('"+cedula+"','"+nombre+"','"+apellido1+"','"+apellido2+"','"+email+"','"+direccion+"',"+fechaNacimiento+",'"+nacionalidad.getCodigo()+"',"+edad+",'"+genero+"');");
	}
	
	@Override
	public ArrayList<Admin> getAdmins() throws Exception {
		return null;
	}
	
	@Override
	public void eliminar(String codigo) throws Exception {
	
	}
	
	@Override
	public void modificar(String nombre, String apellido1, String apellido2, String cedula, String email, String direccion, Pais nacionalidad, LocalDate fechaNacimiento, char genero) throws Exception {
	
	}
	
	@Override
	public Admin buscarPorCodigo(String codigo) throws Exception {
		return null;
	}
}
