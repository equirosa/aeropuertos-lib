package com.eduardoquiros.bl.dao.tripulacion;

import com.eduardoquiros.accesodatos.Conector;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlTripulacionDao implements ITripulacionDao{
	private MySqlTripulanteDao daoTripulante = new MySqlTripulanteDao();
	
	@Override
	public void insertar(String codigo, String nombre) throws Exception {
		Conector.getConector().ejecutarSql("insert into tripulaciones(codigo,nombre) values('"+codigo+"','"+nombre+"');");
	}
	
	@Override
	public ArrayList<Tripulacion> getTripulaciones() throws Exception {
		ArrayList<Tripulacion> tripulaciones = new ArrayList<>();
		ResultSet rs = Conector.getConector().ejecutarQuery("select codigo,nombre from tripulaciones");
		while (rs.next()) {
			tripulaciones.add(new Tripulacion(rs.getString("codigo"),rs.getString("nombre"),
					daoTripulante.buscarPorTripulacion(rs.getString("codigo"))));
		}
	}
	
	@Override
	public void eliminar(String codigo) throws Exception {
	Conector.getConector().ejecutarSql("delete from tripulaciones where codigo='"+codigo+"');");
	}
	
	@Override
	public void modificar(String codigo, String nombre) throws Exception {
	Conector.getConector().ejecutarSql("update tripulaciones set nombre='"+nombre+"' where codigo='"+codigo+"';");
	}
	
	@Override
	public Tripulacion buscarPorCodigo(String codigo) throws Exception {
		ResultSet rs = Conector.getConector().ejecutarQuery("select codigo,nombre from tripulaciones where codigo='"+codigo+"';");
		Tripulacion tmpTripulacion = new Tripulacion();
		while (rs.next()) {
			tmpTripulacion.setCodigo(rs.getString("codigo"));
			tmpTripulacion.setNombre("nombre");
			tmpTripulacion.setTripulantes(daoTripulante.buscarPorTripulacion(rs.getString("codigo")));
		}
		return tmpTripulacion;
	}
}
