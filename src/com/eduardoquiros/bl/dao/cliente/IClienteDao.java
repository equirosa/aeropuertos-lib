package com.eduardoquiros.bl.dao.cliente;

import com.eduardoquiros.bl.dao.pais.Pais;

import java.time.LocalDate;
import java.util.ArrayList;

public interface IClienteDao {
	void insertar(String nombre, String apellido1, String apellido2, String cedula, String email,String contrasenna, String direccion, Pais nacionalidad, LocalDate fechaNacimiento) throws Exception;
	ArrayList<Cliente> getUsuarios() throws Exception;
	void eliminar(String codigo)throws Exception;
	void modificar(String nombre, String apellido1, String apellido2, String cedula, String email,String contrasenna, String direccion, Pais nacionalidad, LocalDate fechaNacimiento) throws Exception;
	Cliente buscarPorCodigo(String codigo) throws Exception;
}
