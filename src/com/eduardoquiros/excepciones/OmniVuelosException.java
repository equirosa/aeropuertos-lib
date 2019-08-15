package com.eduardoquiros.excepciones;

import com.eduardoquiros.utils.Mensajes;

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
	
	public String numeroToString(){
		switch (numero){
			default: return Mensajes.MNSJ_NO_DEFINIDO;
			case 1062:
				return Mensajes.MNSJ_REG_REPETIDO;
			case 1064: return Mensajes.MNSJ_MALA_SINTAXIS;
		}
	}
}
