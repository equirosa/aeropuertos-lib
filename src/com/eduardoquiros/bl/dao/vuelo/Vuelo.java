package com.eduardoquiros.bl.dao.vuelo;

import com.eduardoquiros.bl.dao.aeropuerto.Aeropuerto;
import com.eduardoquiros.bl.dao.avion.Avion;
import com.eduardoquiros.bl.dao.puerta.Puerta;
import com.eduardoquiros.bl.dao.tripulacion.Tripulacion;

import java.time.LocalDateTime;

public class Vuelo {
	private String numero,estado;
	private LocalDateTime horaLlegada, horaPartida;
	private Avion nave;
	private Puerta sala;
	private Aeropuerto lugarLlegada, lugarPartida;
	private Tripulacion equipo;
	
	public Vuelo() {
	}
	
	public Vuelo(String numero, String estado, LocalDateTime horaLlegada, LocalDateTime horaPartida, Avion nave,
	             Puerta sala, Aeropuerto lugarLlegada, Aeropuerto lugarPartida, Tripulacion equipo) {
		this.numero = numero;
		this.estado = estado;
		this.horaLlegada = horaLlegada;
		this.horaPartida = horaPartida;
		this.nave = nave;
		this.sala = sala;
		this.lugarLlegada = lugarLlegada;
		this.lugarPartida = lugarPartida;
		this.equipo = equipo;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public LocalDateTime getHoraLlegada() {
		return horaLlegada;
	}
	
	public void setHoraLlegada(LocalDateTime horaLlegada) {
		this.horaLlegada = horaLlegada;
	}
	
	public LocalDateTime getHoraPartida() {
		return horaPartida;
	}
	
	public void setHoraPartida(LocalDateTime horaPartida) {
		this.horaPartida = horaPartida;
	}
	
	public Avion getNave() {
		return nave;
	}
	
	public void setNave(Avion nave) {
		this.nave = nave;
	}
	
	public Puerta getSala() {
		return sala;
	}
	
	public void setSala(Puerta sala) {
		this.sala = sala;
	}
	
	public Aeropuerto getLugarLlegada() {
		return lugarLlegada;
	}
	
	public void setLugarLlegada(Aeropuerto lugarLlegada) {
		this.lugarLlegada = lugarLlegada;
	}
	
	public Aeropuerto getLugarPartida() {
		return lugarPartida;
	}
	
	public void setLugarPartida(Aeropuerto lugarPartida) {
		this.lugarPartida = lugarPartida;
	}
	
	public Tripulacion getEquipo() {
		return equipo;
	}
	
	public void setEquipo(Tripulacion equipo) {
		this.equipo = equipo;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		Vuelo vuelo = (Vuelo) o;
		
		return getNumero().equals(vuelo.getNumero());
		
	}
	
	@Override
	public String toString() {
		return "Vuelo{" +
				"numero='" + numero + '\'' +
				", estado='" + estado + '\'' +
				", horaLlegada=" + horaLlegada +
				", horaPartida=" + horaPartida +
				", nave=" + nave +
				", sala=" + sala +
				", lugarLlegada=" + lugarLlegada +
				", lugarPartida=" + lugarPartida +
				", equipo=" + equipo +
				'}';
	}
}
