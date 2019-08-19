package com.eduardoquiros.bl.dao.avion;

import com.eduardoquiros.accesodatos.Conector;
import com.eduardoquiros.bl.dao.aerolinea.Aerolinea;
import com.eduardoquiros.bl.dao.aerolinea.MySqlAerolineaDao;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlAvionDao implements IAvionDao{
	private MySqlAerolineaDao aerolineaDao = new MySqlAerolineaDao();
	
	@Override
	public void insertar(String placa, String marca, String modelo, int capacidad, Aerolinea propietaria) throws Exception {
		Conector.getConector().ejecutarSql("insert into aviones(marca,modelo,capacidad,aerolinea) values('"+marca+"','"+
				modelo+"',"+capacidad+",'"+propietaria.getCedulaJuridica()+"');");
	}
	
	@Override
	public ArrayList<Avion> getAviones() throws Exception {
		ResultSet rs = Conector.getConector().ejecutarQuery("select placa,marca,modelo,capacidad,aerolinea from " +
				"aviones;");
		ArrayList<Avion> aviones = new ArrayList<>();
		while (rs.next()) {
			aviones.add(new Avion(rs.getString("placa"),rs.getString("marca"),
					rs.getString("modelo"),rs.getInt("capacidad"),
					aerolineaDao.buscarPorCodigo(rs.getString("aerolinea"))));
		}
		return aviones;
	}
	
	@Override
	public void eliminar(String placa) throws Exception {
	Conector.getConector().ejecutarSql("delete from aviones where placa='"+placa+"';");
	}
	
	@Override
	public void modificar(String placa, String marca, String modelo, int capacidad, Aerolinea propietaria) throws Exception {
	Conector.getConector().ejecutarSql("update aviones set marca='"+marca+"',modelo='"+modelo+"',capacidad="+capacidad+
			",aerolinea='"+propietaria.getCedulaJuridica());
	}
	
	@Override
	public Avion buscarPorCodigo(String placa) throws Exception {
		ResultSet rs = Conector.getConector().ejecutarQuery("select placa,marca,modelo,capacidad,aerolinea from " +
				"aviones where placa='"+placa+"';");
		Avion tmpAvion = new Avion();
		while (rs.next()) {
			tmpAvion = new Avion(rs.getString("placa"),rs.getString("marca"),
					rs.getString("modelo"),rs.getInt("capacidad"),
					aerolineaDao.buscarPorCodigo(rs.getString("aerolinea")));
		}
		return tmpAvion;
	}
}
