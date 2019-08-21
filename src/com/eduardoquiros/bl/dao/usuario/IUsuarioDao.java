package com.eduardoquiros.bl.dao.usuario;

import com.eduardoquiros.bl.dao.pais.Pais;

import java.time.LocalDate;
import java.util.ArrayList;

public interface IUsuarioDao {
	void insertar(String nombre, String apellido1, String apellido2, String cedula, String email, String direccion, Pais nacionalidad, LocalDate fechaNacimiento) throws Exception;
	ArrayList<Usuario> getUsuarios() throws Exception;
	void eliminar(String codigo)throws Exception;
	void modificar(String nombre, String apellido1, String apellido2, String cedula, String email, String direccion, Pais nacionalidad, LocalDate fechaNacimiento) throws Exception;
	Usuario buscarPorCodigo(String codigo) throws Exception;
}