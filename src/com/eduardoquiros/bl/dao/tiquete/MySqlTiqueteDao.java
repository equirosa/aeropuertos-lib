package com.eduardoquiros.bl.dao.tiquete;

import com.eduardoquiros.accesodatos.Conector;
import com.eduardoquiros.bl.dao.vuelo.MySqlVueloDao;
import com.eduardoquiros.bl.dao.vuelo.Vuelo;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlTiqueteDao implements ITiqueteDao{
	MySqlVueloDao vueloDao = new MySqlVueloDao();
	
	@Override
	public void insertar(String asiento, String tipoAsiento, double precio, Vuelo viaje) throws Exception {
		Conector.getConector().ejecutarSql("insert into tiquetes(asiento,tipo_asiento,precio,vuelo " +
				"values('"+asiento+"','"+tipoAsiento+"',"+precio+",'"+viaje.getNumero()+"');");
	}
	
	@Override
	public ArrayList<Tiquete> getTiquetes() throws Exception {
		ArrayList<Tiquete> tiquetes = new ArrayList<>();
		ResultSet rs = Conector.getConector().ejecutarQuery("select numero,asiento,tipo_asiento,precio,vuelo from tiquetes");
		while (rs.next()) {
			tiquetes.add(new Tiquete(rs.getString("numero"),rs.getString("asiento"),
					rs.getString("tipo_asiento"),rs.getDouble("precio"),
					vueloDao.buscarPorCodigo(rs.getString("vuelo"))));
		}
		return tiquetes;
	}
	
	@Override
	public void eliminar(String numero) throws Exception {
	Conector.getConector().ejecutarSql("delete from tiquetes where numero="+numero+";");
	}
	
	@Override
	public void modificar(String numero, String asiento, String tipoAsiento, double precio, Vuelo viaje) throws Exception {
	Conector.getConector().ejecutarSql("update tiquetes set asiento='"+asiento+"',tipo_asiento='"+tipoAsiento+
			"',precio="+precio+",vuelo='"+viaje+"' where numero="+numero+";");
	}
	
	@Override
	public Tiquete buscarPorCodigo(String numero) throws Exception {
		Tiquete tmpTiquete = new Tiquete();
		ResultSet rs = Conector.getConector().ejecutarQuery("select numero,asiento,tipo_asiento,precio,vuelo from tiquetes" +
				" where numero="+numero+";");
		while (rs.next()) {
			tmpTiquete.setAsiento(rs.getString("asiento"));
			tmpTiquete.setNumero(rs.getString("numero"));
			tmpTiquete.setPrecio(rs.getDouble("precio"));
			tmpTiquete.setTipoAsiento(rs.getString("tipo+asiento"));
			tmpTiquete.setViaje(vueloDao.buscarPorCodigo(rs.getString("vuelo")));
		}
		return tmpTiquete;
	}
}
