package com.eduardoquiros.bl.dao.admin;

import com.eduardoquiros.bl.dao.pais.Pais;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Eduardo Quiros
 * @version 1.0
 * @since 2019-08-21
 */
public interface IAdminDao {
	/**
	 * Recibe datos de Admin para constructor.
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param cedula
	 * @param email
	 * @param direccion
	 * @param nacionalidad
	 * @param fechaNacimiento
	 * @param genero
	 * @param edad
	 * @throws Exception
	 */
	void insertar(String nombre, String apellido1, String apellido2, String cedula, String email, String direccion, Pais nacionalidad, LocalDate fechaNacimiento, char genero,int edad) throws Exception;
	
	/**
	 * @return Retorna un arraylist de Admins.
	 * @throws Exception
	 */
	ArrayList<Admin> getAdmins() throws Exception;
	
	/**
	 * Recibe la cedula del admin.
	 * @param codigo
	 * @throws Exception
	 */
	void eliminar(String codigo)throws Exception;
	
	/**
	 * Recibe los nuevos datos que deben modificar los valores de los atributos, asi como el identificador necesario para saber cual entrada de la base de datos modificar.
	 * @param nombre Es el nombre del Admin.
	 * @param apellido1 Es el primer apellido del Admin.
	 * @param apellido2 Es el segundo apellido del Admin.
	 * @param cedula Es el numero de identificacion del Admin.
	 * @param email Es la direccion de correo electronico del Admin.
	 * @param direccion Es el detalle de direccion de residencia del Admin.
	 * @param nacionalidad Es el pais en el que nacio el Admin.
	 * @param fechaNacimiento Es la fecha en la que nacio el Admin.
	 * @param genero Es el genero del Admin.
	 * @param edad Es la edad del Admin.
	 * @throws SQLException Puede haber errores al interactuar con la base de datos.
	 */
	void modificar(String nombre, String apellido1, String apellido2, String cedula, String email, String direccion, Pais nacionalidad, LocalDate fechaNacimiento, char genero,int edad) throws SQLException;
	
	/**
	 *
	 * @param codigo Es la cedula del admin que se desea buscar.
	 * @return Retorna un singular Admin cuya cedula coincida con el parametro.
	 * @throws SQLException Puede haber errores al interactuar con la base de datos.
	 */
	Admin buscarPorCodigo(String codigo) throws SQLException;
	
	/**
	 *
	 * @return Retorna un valor correspondiente con la existencia o ausencia de Admins(no hay admins = true).
	 * @throws SQLException Puede haber errores al interactuar con la base de datos.
	 */
	boolean noAdmins() throws SQLException;
}
