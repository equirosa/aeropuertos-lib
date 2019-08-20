package com.eduardoquiros.bl.dao.factura;

import com.eduardoquiros.bl.dao.persona.Persona;

import java.time.LocalDate;
import java.util.ArrayList;

public interface IFacturaDao {
	void insertar(LocalDate fecha, Persona cliente) throws Exception;
	ArrayList<Factura> getFacturas() throws Exception;
	void eliminar(String numero) throws Exception;
	void modificar(String numero,LocalDate fecha,Persona cliente) throws Exception;
	Factura buscarPorCodigo(String numero) throws Exception;
}
