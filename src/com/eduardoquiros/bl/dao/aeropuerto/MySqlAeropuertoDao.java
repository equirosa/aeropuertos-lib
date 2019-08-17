package com.eduardoquiros.bl.dao.aeropuerto;

import com.eduardoquiros.accesodatos.Conector;
import com.eduardoquiros.bl.dao.admin.Admin;
import com.eduardoquiros.bl.dao.admin.MySqlAdminDao;
import com.eduardoquiros.bl.dao.pais.MySqlPaisDao;
import com.eduardoquiros.bl.dao.pais.Pais;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlAeropuertoDao implements IAeropuertoDao{
	MySqlPaisDao paisDao;
	MySqlAdminDao adminDao;
	
	@Override
	public void insertar(String nombre, Pais nacionalidad, Admin supervisor) throws Exception {
		Conector.getConector().ejecutarSql("insert into aeropuertos(nombre,pais,admin) values('"+nombre+"','"+
				nacionalidad.getCodigo()+"','"+supervisor.getCedula()+"');");
	}
	
	@Override
	public ArrayList<Aeropuerto> getAdmins() throws Exception {
		ArrayList<Aeropuerto> aeropuertos = new ArrayList<>();
		ResultSet rs = Conector.getConector().ejecutarQuery("select codigo,nombre,nacionalidad,admin");
		while (rs.next()) {
			aeropuertos.add(new Aeropuerto(rs.getString("codigo"),rs.getString("nombre"),
					paisDao.buscarPorCodigo(rs.getString("nacionalidad")),
					adminDao.buscarPorCodigo(rs.getString("admin"))));
		}
		return aeropuertos;
	}
	
	@Override
	public void eliminar(String codigo) throws Exception {
	Conector.getConector().ejecutarSql("delete from aeropuertos where codigo="+codigo+";");
	}
	
	@Override
	public void modificar(String codigo, String nombre, Pais nacionalidad, Admin supervisor) throws Exception {
	Conector.getConector().ejecutarSql("update aeropuertos set nombre='"+nombre+"',pais='"+nacionalidad.getCodigo()+
			"',admin='"+supervisor.getCedula()+"' where codigo="+codigo+";");
	}
	
	@Override
	public Aeropuerto buscarPorCodigo(String codigo) throws Exception {
		Aeropuerto tmpAeropuerto = new Aeropuerto();
		ResultSet rs = Conector.getConector().ejecutarQuery("select codigo,nombre,pais,admin where codigo="+codigo+";");
		while (rs.next()) {
			tmpAeropuerto.setCodigo(rs.getString("codigo"));
			tmpAeropuerto.setNombre(rs.getString("nombre"));
			tmpAeropuerto.setLugar(paisDao.buscarPorCodigo(rs.getString("pais")));
			tmpAeropuerto.setSupervisor(adminDao.buscarPorCodigo(rs.getString("admin")));
		}
		return tmpAeropuerto;
	}
}
