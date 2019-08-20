package com.eduardoquiros.bl.dao.pais;

import com.eduardoquiros.accesodatos.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlPaisDao implements IPaisDao{
	@Override
	public void insertar(String codigo, String nombre, String abreviatura) throws Exception {
		Conector.getConector().ejecutarSql("insert into paises(codigo,nombre,abreviatura) values('"+codigo+"','"+nombre+"','"+abreviatura+"');");
	}
	
	@Override
	public ArrayList<Pais> getPaises() throws Exception {
		ArrayList<Pais> paises = new ArrayList<>();
		ResultSet rs = Conector.getConector().ejecutarQuery("select codigo,nombre,abreviatura from paises;");
		while (rs.next()) {
			paises.add(new Pais(rs.getString("codigo"),rs.getString("nombre"),rs.getString("abreviatura")));
		}
		return paises;
	}
	
	@Override
	public void eliminar(String codigo) throws Exception {
	Conector.getConector().ejecutarSql("delete from paises where codigo='"+codigo+"';");
	}
	
	@Override
	public void modificar(String codigo, String nombre, String abreviatura) throws Exception {
	Conector.getConector().ejecutarSql("update paises set nombre='"+nombre+"',abreviatura='"+abreviatura+"';");
	}
	
	@Override
	public Pais buscarPorCodigo(String codigo) throws Exception {
		Pais tmpPais = new Pais();
		ResultSet rs =Conector.getConector().ejecutarQuery("select codigo,nombre,abreviatura from pais where codigo='"+codigo+"';");
		while (rs.next()) {
			tmpPais = new Pais(rs.getString("codigo"), rs.getString("nombre"), rs.getString("abreviatura"));
		}
		return tmpPais;
	}
}
