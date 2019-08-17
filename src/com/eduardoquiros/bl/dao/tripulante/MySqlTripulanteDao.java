package com.eduardoquiros.bl.dao.tripulante;

import com.eduardoquiros.accesodatos.Conector;
import com.eduardoquiros.bl.dao.pais.MySqlPaisDao;
import com.eduardoquiros.bl.dao.pais.Pais;
import com.eduardoquiros.bl.dao.tripulacion.Tripulacion;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class MySqlTripulanteDao implements ITripulanteDao{
	private MySqlPaisDao paisDao = new MySqlPaisDao();
	
	@Override
	public void insertar(String cedula, String nombre, String apellido1, String apellido2, String email, String direccion,
	                     LocalDate fechaNacimiento, Pais nacionalidad,char genero, String numLicencia, String puesto, String telefono,
	                     LocalDate fechaGraduacion, String codigoTripulacion) throws Exception {
		Conector.getConector().ejecutarSql("insert into tripulantes(cedula,nombre,apellido1,apellido2,email,direccion," +
				"fecha_nacimiento,nacionalidad,genero,annos_experiencia,num_licencia,puesto,telefono,fecha_graduacion,tripulacion " +
				"values('"+cedula+"','"+nombre+"','"+apellido1+"','"+apellido2+"','"+email+"','"+direccion+"',"+fechaNacimiento+
				",'"+nacionalidad.getCodigo()+"','"+genero+"',"+ Period.between(fechaGraduacion,LocalDate.now()).getYears()
				+","+numLicencia+"','"+puesto+"','"+telefono+"',"+fechaGraduacion+ ",'"+codigoTripulacion);
	}
	
	@Override
	public ArrayList<Tripulante> getTripulantes() throws Exception {
		ArrayList<Tripulante> tripulantes = new ArrayList<>();
		ResultSet rs = Conector.getConector().ejecutarQuery("select cedula,nombre,apellido1,apellido2,email,direccion," +
				"fecha_nacimiento,nacionalidad,genero,annos_experiencia,num_licencia,puesto,telefono,fecha_graduacion" +
				" from tripulantes");
		while (rs.next()){
			tripulantes.add(new Tripulante(rs.getString("nombre"),rs.getString("apellido1"),
					rs.getString("apellido2"),rs.getString("cedula"),rs.getString("email"),
					rs.getString("direccion"),paisDao.buscarPorCodigo(rs.getString("nacionalidad")),
					LocalDate.parse(rs.getString("nacionalidad")),rs.getInt("annos_experiencia"),
					rs.getString("num_licencia"),rs.getString("puesto"),rs.getString("telefono"),
					LocalDate.parse(rs.getString("fecha_graduacion"))));
		}
		return tripulantes;
	}
	
	@Override
	public void eliminar(String codigo) throws Exception {
	Conector.getConector().ejecutarSql("delete from tripulantes where cedula='"+codigo+"';");
	}
	
	@Override
	public void modificar(String cedula, String nombre, String apellido1, String apellido2, String email, String direccion,
	                      LocalDate fechaNacimiento, Pais nacionalidad,char genero, String numLicencia, String puesto, String telefono,
	                      LocalDate fechaGraduacion, String codigoTripulacion) throws Exception {
	Conector.getConector().ejecutarSql("update tripulantes set nombre='"+nombre+"',apellido1='"+apellido1+
			"',apellido2='"+apellido2+"',email='"+email+"',direccion='"+direccion+"',fecha_nacimiento="+fechaNacimiento+
			",nacionalidad='"+nacionalidad.getCodigo()+"',");
	}
	
	@Override
	public Tripulacion buscarPorCodigo(String codigo) throws Exception {
		return null;
	}
	
	@Override
	public ArrayList<Tripulante> getTripulantesPorTripulacion(String codigoTripulacion) throws Exception {
		return null;
	}
}
