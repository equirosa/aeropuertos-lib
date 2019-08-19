package com.eduardoquiros.bl.dao.factura;

import com.eduardoquiros.accesodatos.Conector;
import com.eduardoquiros.bl.dao.persona.Persona;

import java.time.LocalDate;
import java.util.ArrayList;

public class MySqlFacturaDao implements IFacturaDao{
	
	@Override
	public void insertar(LocalDate fecha, Persona cliente) throws Exception {
	
	}
	
	@Override
	public ArrayList<Factura> getFacturas() throws Exception {
		return null;
	}
	
	@Override
	public void eliminar(String numero) throws Exception {
		Conector.getConector().ejecutarSql("delete from facturas where numero="+numero+";");
	}
	
	@Override
	public void modificar(String numero, LocalDate fecha, Persona cliente) throws Exception {
	
	}
	
	@Override
	public Factura buscarPorCodigo(String numero) throws Exception {
		return null;
	}
}
