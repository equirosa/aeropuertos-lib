package com.eduardoquiros.bl.dao.tripulante;

import com.eduardoquiros.accesodatos.Conector;
import com.eduardoquiros.bl.dao.pais.MySqlPaisDao;
import com.eduardoquiros.bl.dao.pais.Pais;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class MySqlTripulanteDao implements ITripulanteDao{
	private MySqlPaisDao paisDao = new MySqlPaisDao();
	
	@Override
	public void insertar(String cedula, String nombre, String apellido1, String apellido2, String email,String contrasenna, String direccion,
	                     LocalDate fechaNacimiento, Pais nacionalidad,char genero, String numLicencia, String puesto, String telefono,
	                     LocalDate fechaGraduacion, String codigoTripulacion) throws Exception {
		Conector.getConector().ejecutarSql("insert into tripulantes(cedula,nombre,apellido1,apellido2,email,passwd,direccion," +
				"fecha_nacimiento,nacionalidad,genero,annos_experiencia,licencia,puesto,telefono,fecha_graduacion,tripulacion " +
				"values('"+cedula+"','"+nombre+"','"+apellido1+"','"+apellido2+"','"+email+"','"+contrasenna+"','"+direccion+"',"+fechaNacimiento+
				",'"+nacionalidad.getCodigo()+"','"+genero+"',"+ Period.between(fechaGraduacion,LocalDate.now()).getYears()
				+","+numLicencia+"','"+puesto+"','"+telefono+"','"+fechaGraduacion+ "','"+codigoTripulacion+"'");
	}
	
	@Override
	public ArrayList<Tripulante> getTripulantes() throws Exception {
		ArrayList<Tripulante> tripulantes = new ArrayList<>();
		ResultSet rs = Conector.getConector().ejecutarQuery("select cedula,nombre,apellido1,apellido2,email,passwd,direccion," +
				"fecha_nacimiento,nacionalidad,genero,annos_experiencia,licencia,puesto,telefono,fecha_graduacion" +
				" from tripulantes");
		while (rs.next()){
			tripulantes.add(new Tripulante(rs.getString("nombre"),rs.getString("apellido1"),
					rs.getString("apellido2"),rs.getString("cedula"),rs.getString("email"),
					rs.getString("passwd"),
					rs.getString("direccion"),paisDao.buscarPorCodigo(rs.getString("nacionalidad")),
					rs.getString("genero").charAt(0),
					LocalDate.parse(rs.getString("fecha_nacimiento")),rs.getInt("annos_experiencia"),
					rs.getString("licencia"),rs.getString("puesto"),rs.getString("telefono"),
					LocalDate.parse(rs.getString("fecha_graduacion"))));
		}
		return tripulantes;
	}
	
	@Override
	public void eliminar(String codigo) throws Exception {
	Conector.getConector().ejecutarSql("delete from tripulantes where cedula='"+codigo+"';");
	}
	
	@Override
	public void modificar(String cedula, String nombre, String apellido1, String apellido2, String email, String contrasenna,String direccion,
	                      LocalDate fechaNacimiento, Pais nacionalidad,char genero, String numLicencia, String puesto, String telefono,
	                      LocalDate fechaGraduacion, String codigoTripulacion) throws Exception {
	Conector.getConector().ejecutarSql("update tripulantes set nombre='"+nombre+"',apellido1='"+apellido1+
			"',apellido2='"+apellido2+"',email='"+email+"',direccion='"+direccion+"',fecha_nacimiento='"+fechaNacimiento+
			"',nacionalidad='"+nacionalidad.getCodigo()+"',genero='"+genero+"',licencia='"+numLicencia+"',puesto='"+puesto+
			"',telefono='"+telefono+"',fecha_graduacion='"+fechaGraduacion+"',tripulacion='"+codigoTripulacion+"',annos_experiencia="+
			Period.between(fechaGraduacion,LocalDate.now()).getYears()+");");
	}
	
	@Override
	public Tripulante buscarPorCodigo(String codigo) throws Exception {
		ResultSet rs = Conector.getConector().ejecutarQuery("select cedula,nombre,apellido1,apellido2,email,passwd,direccion," +
				"fecha_nacimiento,nacionalidad,genero,annos_experiencia,licencia,puesto,telefono,fecha_graduacion" +
				" from tripulantes where cedula='"+codigo+"';");
		Tripulante tmpTripulante = new Tripulante();
		while (rs.next()) {
			tmpTripulante.setCedula(rs.getString("cedula"));
			tmpTripulante.setNombre(rs.getString("nombre"));
			tmpTripulante.setApellido1(rs.getString("apellido1"));
			tmpTripulante.setApellido2(rs.getString("apellido2"));
			tmpTripulante.setEmail(rs.getString("email"));
			tmpTripulante.setContrasenna(rs.getString("passwd"));
			tmpTripulante.setDireccion(rs.getString("direccion"));
			tmpTripulante.setFechaNacimiento(LocalDate.parse(rs.getString("fecha_nacimiento")));
			tmpTripulante.setNacionalidad(paisDao.buscarPorCodigo(rs.getString("nacionalidad")));
			tmpTripulante.setGenero(rs.getString("genero").charAt(0));
			tmpTripulante.setAnnosExp(rs.getInt("annos_experiencia"));
			tmpTripulante.setNumLicencia(rs.getString("licencia"));
			tmpTripulante.setPuesto(rs.getString("puesto"));
			tmpTripulante.setTelefono(rs.getString("telefono"));
			tmpTripulante.setFechaGraduacion(LocalDate.parse(rs.getString("fecha_graduacion")));
		}
		return tmpTripulante;
	}
	
	@Override
	public ArrayList<Tripulante> getTripulantesPorTripulacion(String codigoTripulacion) throws Exception {
		ResultSet rs = Conector.getConector().ejecutarQuery("select cedula,nombre,apellido1,apellido2,email,passwd,direccion," +
				"fecha_nacimiento,nacionalidad,genero,annos_experiencia,licencia,puesto,telefono,fecha_graduacion" +
				" from tripulantes where tripulacion='"+codigoTripulacion+"';");
		Tripulante tmpTripulante = new Tripulante();
		ArrayList<Tripulante> tripulantes = new ArrayList<>();
		while (rs.next()) {
			tmpTripulante.setCedula(rs.getString("cedula"));
			tmpTripulante.setNombre(rs.getString("nombre"));
			tmpTripulante.setApellido1(rs.getString("apellido1"));
			tmpTripulante.setApellido2(rs.getString("apellido2"));
			tmpTripulante.setEmail(rs.getString("email"));
			tmpTripulante.setContrasenna(rs.getString("passwd"));
			tmpTripulante.setDireccion(rs.getString("direccion"));
			tmpTripulante.setFechaNacimiento(LocalDate.parse(rs.getString("fecha_nacimiento")));
			tmpTripulante.setNacionalidad(paisDao.buscarPorCodigo(rs.getString("nacionalidad")));
			tmpTripulante.setGenero(rs.getString("genero").charAt(0));
			tmpTripulante.setAnnosExp(rs.getInt("annos_experiencia"));
			tmpTripulante.setNumLicencia(rs.getString("licencia"));
			tmpTripulante.setPuesto(rs.getString("puesto"));
			tmpTripulante.setTelefono(rs.getString("telefono"));
			tmpTripulante.setFechaGraduacion(LocalDate.parse(rs.getString("fecha_graduacion")));
			tripulantes.add(tmpTripulante);
		}
		return tripulantes;
	}
}
