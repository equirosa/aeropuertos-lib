package com.eduardoquiros.excepciones;

public class OmniVuelosException extends Exception{
	private int numero;
	
	public OmniVuelosException() {
	}
	
	public OmniVuelosException(String message) {
		super(message);
	}
	
	public OmniVuelosException(int numero) {
		this.numero = numero;
	}
}
