package com.eduardoquiros.bl.dao.factura;

import com.eduardoquiros.bl.dao.persona.Persona;
import com.eduardoquiros.bl.dao.tiquete.Tiquete;

import java.time.LocalDate;
import java.util.ArrayList;

public class Factura {
	private String numero;
	private LocalDate fecha;
	private Persona cliente;
	private ArrayList<Tiquete> tiquetes;
	
	public Factura() {
	}
	
	public Factura(String numero, LocalDate fecha, Persona cliente, ArrayList<Tiquete> tiquetes) {
		this.numero = numero;
		this.fecha = fecha;
		this.cliente = cliente;
		this.tiquetes = tiquetes;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public Persona getCliente() {
		return cliente;
	}
	
	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}
	
	public ArrayList<Tiquete> getTiquetes() {
		return tiquetes;
	}
	
	public void setTiquetes(ArrayList<Tiquete> tiquetes) {
		this.tiquetes = tiquetes;
	}
	
	public void addTiquete(Tiquete tmpTiquete){
		tiquetes.add(tmpTiquete);
	}
	
	public void deleteTquete(Tiquete tmpTiquete){
		tiquetes.remove(tmpTiquete);
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		Factura factura = (Factura) o;
		
		return getNumero().equals(factura.getNumero());
		
	}
	
	@Override
	public String toString() {
		return "Factura{" +
				"numero='" + numero + '\'' +
				", fecha=" + fecha +
				", cliente=" + cliente +
				", tiquetes=" + tiquetes +
				'}';
	}
}
