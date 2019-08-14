package com.eduardoquiros.bl.dao.admin;

import com.eduardoquiros.accesodatos.Conector;
import com.eduardoquiros.bl.dao.pais.MySqlPaisDao;
import com.eduardoquiros.bl.dao.pais.Pais;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

public class MySqlAdminDao implements IAdminDao{
	private static MySqlPaisDao gestorPaises;
	@Override
	public void insertar(String nombre, String apellido1, String apellido2, String cedula, String email, String direccion,
	                     Pais nacionalidad, LocalDate fechaNacimiento, char genero,int edad) throws Exception {
		Conector.getConector().ejecutarSql("insert into admin(cedula,nombre,apellido1,apellido2,email,direccion," +
				"fecha_nacimiento,nacionalidad,edad,genero values('"+cedula+"','"+nombre+"','"+apellido1+"','"+apellido2+
				"','"+email+"','"+direccion+"',"+fechaNacimiento+",'"+nacionalidad.getCodigo()+"',"+edad+",'"+genero+"');");
	}
	
	@Override
	public ArrayList<Admin> getAdmins() throws Exception {
		ArrayList<Admin> admins = new ArrayList<>();
		ResultSet rs = Conector.getConector().ejecutarQuery("select cedula,nombre,apellido1,apellido2,email,direccion," +
				"fecha_nacimiento,nacionalidad,edad,genero from admin");
		while (rs.next()) {
		Admin tmpAdmin = new Admin(rs.getString("nombre"),rs.getString("apellido1"),
				rs.getString("apellido2"),rs.getString("cedula"),rs.getString("email"),
				rs.getString("direccion"), gestorPaises.buscarPorCodigo(rs.getString("nacionalidad")),
				LocalDate.parse(rs.getString("fecha_nacimiento")),rs.getInt("edad"),
				rs.getString("genero").charAt(0));
		admins.add(tmpAdmin);
		}
		return admins;
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
