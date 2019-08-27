package com.eduardoquiros.bl.dao.admin;

import com.eduardoquiros.accesodatos.Conector;
import com.eduardoquiros.bl.dao.pais.MySqlPaisDao;
import com.eduardoquiros.bl.dao.pais.Pais;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

public class MySqlAdminDao implements IAdminDao{
	private static MySqlPaisDao gestorPaises = new MySqlPaisDao();
	@Override
	public void insertar(String nombre, String apellido1, String apellido2, String cedula, String email,String contrasenna,
	                     String direccion,
	                     Pais nacionalidad, LocalDate fechaNacimiento, char genero,int edad) throws Exception {
		Conector.getConector().ejecutarSql("insert into admins values('"+cedula+"','"+nombre+"','"+apellido1+"','"+apellido2+
				"','"+email+"','"+contrasenna+"','"+direccion+"','"+fechaNacimiento+"','"+nacionalidad.getCodigo()+"',"
				+edad+",'"+genero+"');");
	}
	
	@Override
	public ArrayList<Admin> getAdmins() throws Exception {
		ArrayList<Admin> admins = new ArrayList<>();
		ResultSet rs = Conector.getConector().ejecutarQuery("select nombre,apellido1,apellido2,cedula,email,passwd,direccion," +
				"nacionalidad,fecha_nacimiento,edad,genero from admins");
		while (rs.next()) {
			Admin tmp = new Admin();
			tmp.setNombre(rs.getString("nombre"));
			tmp.setApellido1(rs.getString("apellido1"));
			tmp.setApellido2(rs.getString("apellido2"));
			tmp.setCedula(rs.getString("cedula"));
			tmp.setEmail(rs.getString("email"));
			tmp.setContrasenna(rs.getString("passwd"));
			tmp.setDireccion(rs.getString("direccion"));
			tmp.setNacionalidad(gestorPaises.buscarPorCodigo(rs.getString("nacionalidad")));
			tmp.setFechaNacimiento(LocalDate.parse(rs.getString("fecha_nacimiento")));
			tmp.setEdad(rs.getInt("edad"));
			tmp.setGenero(rs.getString("genero").charAt(0));
			admins.add(tmp);
		}
		return admins;
	}
	
	@Override
	public void eliminar(String codigo) throws Exception {
	Conector.getConector().ejecutarSql("delete from admins where cedula='"+codigo+"'");
	}
	
	@Override
	public void modificar(String nombre, String apellido1, String apellido2, String cedula, String email, String direccion,
	                      Pais nacionalidad, LocalDate fechaNacimiento, char genero,int edad) throws Exception {
	Conector.getConector().ejecutarSql("update admins set nombre='"+nombre+"',apellido1='"+apellido1+"',apellido2='"+apellido2+"'," +
			"email='"+email+"',direccion='"+direccion+"',nacionalidad='"+nacionalidad.getCodigo()+"',fecha_nacimiento='"+fechaNacimiento+"'," +
			"genero='"+genero+"',edad="+edad+" where cedula='"+cedula+"'");
	}
	
	@Override
	public Admin buscarPorCodigo(String codigo) throws Exception {
		ResultSet rs = Conector.getConector().ejecutarQuery("select cedula,nombre,apellido1,apellido2,email,passwd,direccion," +
				"nacionalidad,fecha_nacimiento,genero from admins where cedula='"+codigo+"'");
		Admin tmpAdmin = new Admin();
		while (rs.next()) {
			tmpAdmin = new Admin(rs.getString("nombre"), rs.getString("apellido1"),
					rs.getString("apellido2"), rs.getString("cedula"), rs.getString("email"),
					rs.getString("passwd"),
					rs.getString("direccion"), gestorPaises.buscarPorCodigo(rs.getString("nacionalidad")),
					LocalDate.parse(rs.getString("fecha_nacimiento")), rs.getInt("edad"),
					rs.getString("genero").charAt(0));
		}
		return tmpAdmin;
	}
	
	@Override
	public boolean noAdmins() throws Exception {
		ResultSet rs = Conector.getConector().ejecutarQuery("select * from admins");
		if (rs.next()){
			return false;
		}
		return true;
	}
}
