package com.eduardoquiros.tl;

import com.eduardoquiros.bl.dao.cliente.IClienteDao;
import com.eduardoquiros.bl.dao.factory.DaoFactory;

public class ControladorCliente {
	IClienteDao daoObject;
	
	public ControladorCliente() {
		this.daoObject = DaoFactory.getDaoFactory(DaoFactory.MySQL).getClienteDao();
	}
}
