package com.eduardoquiros.bl.dao.puerta;

public class Puerta {
	String codigo;
	
	public Puerta(String codigo) {
		this.codigo = codigo;
	}
	
	public Puerta() {
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		Puerta puerta = (Puerta) o;
		
		return getCodigo().equals(puerta.getCodigo());
		
	}
	
	@Override
	public String toString() {
		return "Puerta{" +
				"codigo='" + codigo + '\'' +
				'}';
	}
}
