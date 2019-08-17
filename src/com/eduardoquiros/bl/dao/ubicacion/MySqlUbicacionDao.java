package com.eduardoquiros.bl.dao.ubicacion;

import com.eduardoquiros.accesodatos.Conector;
import com.eduardoquiros.bl.dao.puerta.MySqlPuertaDao;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlUbicacionDao implements IUbicacionDao{
	private MySqlPuertaDao puertaDao = new MySqlPuertaDao();
	
	@Override
	public void insertar(String codigo, String nombre, String aeropuerto) throws Exception {
		String queryText = "insert into ubicacion(codigo,codigo_aeropuerto,nombre) values('"+codigo+"','"+aeropuerto+"','"+nombre+"')";
		Conector.getConector().ejecutarSql(queryText);
	}
	
	@Override
	public ArrayList<Ubicacion> getUbicaciones() throws Exception {
		ArrayList<Ubicacion> ubicaciones = new ArrayList<>();
		String queryText = "select codigo,codigo_aeropuerto,nombre from articulo";
		ResultSet rs = Conector.getConector().ejecutarQuery(queryText);
		while (rs.next()) {
			Ubicacion tmpUbicacion = new Ubicacion(rs.getString("codigo"),rs.getString("codigo_aeropuerto"),rs.getString("nombre"));
			ubicaciones.add(tmpUbicacion);
		}
		return ubicaciones;
	}
	
	@Override
	public void eliminar(String codigo) throws Exception {
	Conector.getConector().ejecutarSql("delete from ubicacion where codigo="+codigo);
	}
	
	@Override
	public void modificar(String codigo, String nombre, String aeropuerto) throws Exception {
	Conector.getConector().ejecutarSql("update ubicacion set codigo_aeropuerto='"+aeropuerto+"',nombre='"+nombre+"' where codigo='"+codigo+"';");
	}
	
	@Override
	public Ubicacion buscarPorCodigo(String codigo) throws Exception {
		ResultSet rs=Conector.getConector().ejecutarQuery("select codigo,codigo_aeropuerto,nombre from articulo where codigo='"+codigo+"';");
		return new Ubicacion(rs.getString("codigo"),rs.getString("nombre"),puertaDao.getPuertasPorUbicacion(codigo));
	}
}
