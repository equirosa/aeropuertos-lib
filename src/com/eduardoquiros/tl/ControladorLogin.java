package com.eduardoquiros.tl;

import com.eduardoquiros.bl.dao.persona.Persona;

public class ControladorLogin {
	private Persona usuarioLogged = null;
	
	public boolean isNotLoggedIn() {
		return (usuarioLogged==null);
	}
	
}
