package com.eduardoquiros.bl.dao.puerta;

import com.eduardoquiros.accesodatos.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlPuertaDao implements IPuertaDao{
	@Override
	public void insertar(String codigo) throws Exception {
		Conector.getConector().ejecutarSql("insert into puertas(ubicacion) values('"+codigo+"');");
	}
	
	@Override
	public ArrayList<Puerta> getPuertas() throws Exception {
		ResultSet rs = Conector.getConector().ejecutarQuery("select codigo,ubicacion from puertas");
		ArrayList<Puerta> puertas = new ArrayList<>();
		while (rs.next()) {
			puertas.add(new Puerta(rs.getString("ubicacion")+rs.getString("codigo")));
		}
		return puertas;
	}
	
	@Override
	public void eliminar(String codigo) throws Exception {
	Conector.getConector().ejecutarSql("delete from puertas where codigo="+codigo+";");
	}
	
	@Override
	public void modificar(String codigo) throws Exception {
	Conector.getConector().ejecutarSql("update puertas set codigo="+codigo+";");
	}
	
	@Override
	public Puerta buscarPorCodigo(String codigo) throws Exception {
		Puerta tmpPuerta = new Puerta();
		ResultSet rs = Conector.getConector().ejecutarQuery("select codigo from puertas where codigo="+codigo+";");
		while (rs.next()) {
			tmpPuerta = new Puerta(rs.getString("codigo"));
		}
		return tmpPuerta;
	}
	
	@Override
	public ArrayList<Puerta> getPuertasPorUbicacion(String ubicacion) throws Exception {
		ArrayList<Puerta> puertas = new ArrayList<>();
		ResultSet rs = Conector.getConector().ejecutarQuery("select codigo,ubicacion from puertas where ubicacion="+ubicacion+";");
		while (rs.next()) {
			puertas.add(new Puerta(rs.getString("ubicacion")+rs.getString("codigo")));
		}
		return puertas;
	}
}
