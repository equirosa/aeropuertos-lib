package com.eduardoquiros.bl.dao.vuelo;

import com.eduardoquiros.bl.dao.aeropuerto.Aeropuerto;
import com.eduardoquiros.bl.dao.avion.Avion;
import com.eduardoquiros.bl.dao.puerta.Puerta;
import com.eduardoquiros.bl.dao.tripulacion.Tripulacion;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface IVueloDao {
	void insertar(String numero, String estado, LocalDateTime horaLlegada, LocalDateTime horaPartida, Avion nave,
	              Puerta sala, Aeropuerto lugarLlegada, Aeropuerto lugarPartida, Tripulacion equipo) throws Exception;
	ArrayList<Vuelo> getVuelos() throws Exception;
	void eliminar(String numero)throws Exception;
	void modificar(String numero, String estado, LocalDateTime horaLlegada, LocalDateTime horaPartida, Avion nave,
	               Puerta sala, Aeropuerto lugarLlegada, Aeropuerto lugarPartida, Tripulacion equipo) throws Exception;
	Vuelo buscarPorCodigo(String numero) throws Exception;
}
