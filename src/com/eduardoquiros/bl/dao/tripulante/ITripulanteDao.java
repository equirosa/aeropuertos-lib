package com.eduardoquiros.bl.dao.tripulante;

import com.eduardoquiros.bl.dao.pais.Pais;

import java.time.LocalDate;
import java.util.ArrayList;

public interface ITripulanteDao {
	void insertar(String cedula, String nombre, String apellido1, String apellido2, String email, String direccion,
	              LocalDate fechaNacimiento, Pais nacionalidad,char genero ,String numLicencia, String puesto, String telefono,
	              LocalDate fechaGraduacion, String codigoTripulacion) throws Exception;
	ArrayList<Tripulante> getTripulantes() throws Exception;
	void eliminar(String codigo)throws Exception;
	void modificar(String cedula, String nombre, String apellido1, String apellido2, String email, String direccion,
	               LocalDate fechaNacimiento, Pais nacionalidad,char genero,String numLicencia,String puesto,String telefono,
	               LocalDate fechaGraduacion, String codigoTripulacion) throws Exception;
	Tripulante buscarPorCodigo(String codigo) throws Exception;
	ArrayList<Tripulante> getTripulantesPorTripulacion(String codigoTripulacion) throws Exception;
}
