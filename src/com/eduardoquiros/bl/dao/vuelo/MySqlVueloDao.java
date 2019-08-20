package com.eduardoquiros.bl.dao.vuelo;

import com.eduardoquiros.accesodatos.Conector;
import com.eduardoquiros.bl.dao.aeropuerto.Aeropuerto;
import com.eduardoquiros.bl.dao.aeropuerto.MySqlAeropuertoDao;
import com.eduardoquiros.bl.dao.avion.Avion;
import com.eduardoquiros.bl.dao.avion.MySqlAvionDao;
import com.eduardoquiros.bl.dao.puerta.MySqlPuertaDao;
import com.eduardoquiros.bl.dao.puerta.Puerta;
import com.eduardoquiros.bl.dao.tripulacion.MySqlTripulacionDao;
import com.eduardoquiros.bl.dao.tripulacion.Tripulacion;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MySqlVueloDao implements IVueloDao{
	private MySqlAeropuertoDao aeropuertoDao = new MySqlAeropuertoDao();
	private MySqlAvionDao avionDao = new MySqlAvionDao();
	private MySqlTripulacionDao tripulacionDao = new MySqlTripulacionDao();
	private MySqlPuertaDao puertaDao = new MySqlPuertaDao();
	@Override
	public void insertar(String numero, String estado, LocalDateTime horaLlegada, LocalDateTime horaPartida, Avion nave,
	                     Puerta sala, Aeropuerto lugarLlegada, Aeropuerto lugarPartida, Tripulacion equipo) throws Exception {
		Conector.getConector().ejecutarSql("insert into vuelos(estado,hora_llegada,hora_partida,avion,sala," +
				"lugar_llegada,lugar_partida,tripulacion) values('"+estado+"',"+horaLlegada+","+horaPartida+",'"+nave+
				"','"+sala+"','"+lugarLlegada+"','"+lugarPartida+"','"+equipo+"');");
	}
	
	@Override
	public ArrayList<Vuelo> getVuelos() throws Exception {
		ArrayList<Vuelo> vuelos = new ArrayList<>();
		ResultSet rs = Conector.getConector().ejecutarQuery("select numero,estado,hora_llegada,hora_partida,avion,sala," +
				"lugar_llegada,lugar_partida,tripulacion from vuelos;");
		while (rs.next()) {
			vuelos.add(new Vuelo(rs.getString("numero"),rs.getString("estado"),
					LocalDateTime.parse(rs.getString("hora_llegada")),
					LocalDateTime.parse(rs.getString("hora_partida")),
					avionDao.buscarPorCodigo(rs.getString("avion")),
					puertaDao.buscarPorCodigo(rs.getString("puerta")),
					aeropuertoDao.buscarPorCodigo(rs.getString("lugar_llegada")),
					aeropuertoDao.buscarPorCodigo(rs.getString("lugar_partida")),
					tripulacionDao.buscarPorCodigo(rs.getString("tripulacion"))));
		}
		return vuelos;
	}
	
	@Override
	public void eliminar(String numero) throws Exception {
	Conector.getConector().ejecutarSql("delete from vuelos where numero="+numero+";");
	}
	
	@Override
	public void modificar(String numero, String estado, LocalDateTime horaLlegada, LocalDateTime horaPartida, Avion nave
			, Puerta sala, Aeropuerto lugarLlegada, Aeropuerto lugarPartida, Tripulacion equipo) throws Exception {
	Conector.getConector().ejecutarSql("update vuelos set estado='"+estado+"',hora_llegada="+horaLlegada+
			",hora_partida="+horaPartida+",avion='"+nave+"',puerta='"+sala+"',lugar_llegada='"+lugarLlegada+
			"',lugar_partida='"+lugarPartida+"',tripulacion='"+equipo+"' where numero='"+numero+";");
	}
	
	@Override
	public Vuelo buscarPorCodigo(String numero) throws Exception {
		Vuelo tmpVuelo = new Vuelo();
		ResultSet rs = Conector.getConector().ejecutarQuery("select numero,estado,hora_llegada,hora_partida,avion,sala," +
				"lugar_llegada,lugar_partida,tripulacion from vuelos where numero="+numero+";");
		while (rs.next()) {
			tmpVuelo = new Vuelo(rs.getString("numero"),rs.getString("estado"),
					LocalDateTime.parse(rs.getString("hora_llegada")),
					LocalDateTime.parse(rs.getString("hora_partida")),
					avionDao.buscarPorCodigo(rs.getString("avion")),
					puertaDao.buscarPorCodigo(rs.getString("puerta")),
					aeropuertoDao.buscarPorCodigo(rs.getString("lugar_llegada")),
					aeropuertoDao.buscarPorCodigo(rs.getString("lugar_partida")),
					tripulacionDao.buscarPorCodigo(rs.getString("tripulacion")));
		}
		return tmpVuelo;
		
	}
}
