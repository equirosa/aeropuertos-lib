package com.eduardoquiros.bl.dao.usuario;

import com.eduardoquiros.accesodatos.Conector;
import com.eduardoquiros.bl.dao.pais.MySqlPaisDao;
import com.eduardoquiros.bl.dao.pais.Pais;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class MySqlUsuarioDao implements IUsuarioDao {
	private MySqlPaisDao paisDao;
	@Override
	public void insertar(String nombre, String apellido1, String apellido2, String cedula, String email, String direccion,
	                     Pais nacionalidad, LocalDate fechaNacimiento) throws Exception {
		Conector.getConector().ejecutarSql("insert into usuarios(nombre,apellido1,apellido2,cedula,email,direccion," +
				"nacionalidad,fecha_nacimiento,edad values('"+nombre+"','"+apellido1+"','"+apellido2+"','"+cedula+"','"+
				email+"','"+direccion+"','"+nacionalidad.getCodigo()+"',"+fechaNacimiento+","+
				Period.between(fechaNacimiento,LocalDate.now()).getYears() +");");
	}
	
	@Override
	public ArrayList<Usuario> getAdmins() throws Exception {
		ArrayList<Usuario> usuarios = new ArrayList<>();
		ResultSet rs = Conector.getConector().ejecutarQuery("select nombre,apellido1,apellido2,cedula,email,direccion," +
				"nacionalidad,fecha_nacimiento,edad;");
		while (rs.next()) {
			usuarios.add(new Usuario(rs.getString("nombre"),rs.getString("apellido1"),
					rs.getString("apellido2"),rs.getString("cedula"),rs.getString("email"),
					rs.getString("direccion"),paisDao.buscarPorCodigo(rs.getString("nacionalidad")),
					LocalDate.parse(rs.getString("fecha_nacimiento")),rs.getInt("edad")));
		}
		return usuarios;
	}
	
	@Override
	public void eliminar(String codigo) throws Exception {
	Conector.getConector().ejecutarSql("delete from usuarios where cedula='"+codigo+"';");
	}
	
	@Override
	public void modificar(String nombre, String apellido1, String apellido2, String cedula, String email, String direccion,
	                      Pais nacionalidad, LocalDate fechaNacimiento) throws Exception {
		Conector.getConector().ejecutarSql("update usuarios set nombre='"+nombre+"',apellido1='"+apellido1+"',apellido2='"+
				apellido2+"',email='"+email+"',direccion='"+direccion+"',nacionalidad='"+nacionalidad.getCodigo()+"',fecha_nacimiento="+
				fechaNacimiento+";");
	}
	
	@Override
	public Usuario buscarPorCodigo(String codigo) throws Exception {
		Usuario tmpUsuario = new Usuario();
		ResultSet rs = Conector.getConector().ejecutarQuery("select nombre,apellido1,apellido2,cedula,email,direccion,nacionalidad" +
				",fecha_nacimiento,edad where cedula="+codigo+";");
		while (rs.next()) {
			tmpUsuario.setNombre(rs.getString("nombre"));
			tmpUsuario.setApellido1(rs.getString("apellido1"));
			tmpUsuario.setApellido2(rs.getString("apellido2"));
			tmpUsuario.setCedula(rs.getString("cedula"));
			tmpUsuario.setEmail(rs.getString("email"));
			tmpUsuario.setDireccion(rs.getString("direccion"));
			tmpUsuario.setNacionalidad(paisDao.buscarPorCodigo(rs.getString("nacionalidad")));
			tmpUsuario.setFechaNacimiento(LocalDate.parse(rs.getString("nacionalidad")));
			tmpUsuario.setEdad(rs.getInt("edad"));
		}
		return tmpUsuario;
	}
}
