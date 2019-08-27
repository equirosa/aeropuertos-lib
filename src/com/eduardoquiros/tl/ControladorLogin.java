package com.eduardoquiros.tl;

import com.eduardoquiros.bl.dao.admin.Admin;
import com.eduardoquiros.bl.dao.admin.IAdminDao;
import com.eduardoquiros.bl.dao.cliente.Cliente;
import com.eduardoquiros.bl.dao.factory.DaoFactory;
import com.eduardoquiros.bl.dao.persona.Persona;
import com.eduardoquiros.bl.dao.tripulante.ITripulanteDao;
import com.eduardoquiros.bl.dao.tripulante.Tripulante;
import com.eduardoquiros.bl.dao.cliente.IClienteDao;

import java.util.ArrayList;

public class ControladorLogin {
	DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.MySQL);
	IAdminDao daoAdmin;
	IClienteDao daoUsuario;
	ITripulanteDao daoTripulante;
	private ArrayList<Persona> loggedIn = new ArrayList<>();
	private String usuarioLoggeado = null;
	
	public ControladorLogin() {
		factory = DaoFactory.getDaoFactory(DaoFactory.MySQL);
		daoAdmin = factory.getAdminDao();
		daoTripulante=factory.getTripulanteDao();
		daoUsuario=factory.getClienteDao();
	}
	
	public boolean isNotLoggedIn() {
		return (loggedIn.isEmpty());
	}
	
	public void login(String cedula, String contrasenna) throws Exception {
		Persona usuario = new Persona();
		usuario.setCedula(cedula);
		usuario.setContrasenna(contrasenna);
		
		ArrayList<Admin> admins = daoAdmin.getAdmins();
		ArrayList<Tripulante> tripulantes = daoTripulante.getTripulantes();
		ArrayList<Cliente> clientes = daoUsuario.getUsuarios();
		
		for (Tripulante t : tripulantes){
			if(t.equals(usuario) && t.getContrasenna().equals(contrasenna)){
				loggedIn.add(t);
				usuarioLoggeado = "tripulante";
				break;
			}
		}
		for (Cliente u : clientes){
			if (u.equals(usuario) && u.getContrasenna().equals(contrasenna)){
				loggedIn.add(u);
				usuarioLoggeado="cliente";
				break;
			}
		}
		for (Admin a : admins){
			if (a.equals(usuario) && a.getContrasenna().equals(contrasenna)){
				loggedIn.add(a);
				usuarioLoggeado="admin";
				break;
			}
		}
	}
	
	public String getTipoUsuario() {
		return usuarioLoggeado;
	}
}
