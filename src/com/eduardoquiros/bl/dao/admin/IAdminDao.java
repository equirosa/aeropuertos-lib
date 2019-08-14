package com.eduardoquiros.bl.dao.admin;

import com.eduardoquiros.bl.Pais;

import java.time.LocalDate;
import java.util.ArrayList;

public interface IAdminDao {
	void insertar(String nombre, String apellido1, String apellido2, String cedula, String email, String direccion,
	              Pais nacionalidad, LocalDate fechaNacimiento, char genero) throws Exception;
	ArrayList<Admin> getAdmins() throws Exception;
	void eliminar(String codigo)throws Exception;
	void modificar(String nombre, String apellido1, String apellido2, String cedula, String email, String direccion,
	               Pais nacionalidad, LocalDate fechaNacimiento, char genero) throws Exception;
	Admin buscarPorCodigo(String codigo) throws Exception;
}
