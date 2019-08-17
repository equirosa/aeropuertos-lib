package com.eduardoquiros.bl.dao.aerolinea;

import com.eduardoquiros.accesodatos.Conector;
import com.eduardoquiros.bl.dao.pais.MySqlPaisDao;
import com.eduardoquiros.bl.dao.pais.Pais;

import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlAerolineaDao implements IAerolineaDao{
	private static MySqlPaisDao gestorPaises = new MySqlPaisDao();
	
	@Override
	public void insertar(String cedulaJuridica, String nombreComercial, String nombreEmpresaDuenna, BufferedImage logo,
	                     Pais localidad) throws Exception {
		Conector.getConector().ejecutarSql("insert into aerolinea(cedula,nombre,empresa_duenna,localidad,logo) " +
				"values('"+cedulaJuridica+"','"+nombreComercial+"','"+nombreEmpresaDuenna+"','"+localidad.getCodigo()+
				"',"+logo+";");
	}
	
	@Override
	public ArrayList<Aerolinea> getAerolineas() throws Exception {
		ArrayList<Aerolinea> aerolineas = new ArrayList<>();
		ResultSet rs = Conector.getConector().ejecutarQuery("select cedula,nombre,empresa_duenna,localidad,logo");
		while (rs.next()){
			aerolineas.add(new Aerolinea(rs.getString("cedula"),rs.getString("nombre"),
					rs.getString("empresa_duenna"), (BufferedImage) rs.getBlob("logo"),
					gestorPaises.buscarPorCodigo(rs.getString("localidad"))));
		}
		return aerolineas;
	}
	
	@Override
	public void eliminar(String cedulaJuridica) throws Exception {
		Conector.getConector().ejecutarSql("delete from aerolinea where cedula="+cedulaJuridica+";");
	}
	
	@Override
	public void modificar(String cedulaJuridica, String nombreComercial, String nombreEmpresaDuenna, BufferedImage logo, Pais localidad) throws Exception {
	Conector.getConector().ejecutarSql("update aerolinea set nombre="+nombreComercial+",empresa_duenna="+nombreEmpresaDuenna+
			",localidad="+localidad.getCodigo()+",logo="+logo+";");
	}
	
	@Override
	public Aerolinea buscarPorCodigo(String cedulaJuridica) throws Exception {
		ResultSet rs = Conector.getConector().ejecutarQuery("select cedula,nombre,empresa_duenna,localidad,logo from aerolinea " +
				"where cedula="+cedulaJuridica+";");
		Aerolinea tmpAerolinea = new Aerolinea();
		while (rs.next()){
			tmpAerolinea = new Aerolinea(rs.getString("cedula"),rs.getString("nombre"),
					rs.getString("empresa_duenna"), (BufferedImage) rs.getBlob("logo"),
					gestorPaises.buscarPorCodigo(rs.getString("localidad")));
		}
	}
}
