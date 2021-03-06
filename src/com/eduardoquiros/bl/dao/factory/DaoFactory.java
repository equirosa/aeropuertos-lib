package com.eduardoquiros.bl.dao.factory;

import com.eduardoquiros.bl.dao.admin.IAdminDao;
import com.eduardoquiros.bl.dao.aerolinea.IAerolineaDao;
import com.eduardoquiros.bl.dao.pais.IPaisDao;
import com.eduardoquiros.bl.dao.tripulante.ITripulanteDao;
import com.eduardoquiros.bl.dao.ubicacion.IUbicacionDao;
import com.eduardoquiros.bl.dao.cliente.IClienteDao;

public abstract class DaoFactory {
	public static final int MySQL = 1;
	public static final int SQL = 2;
	
	public static DaoFactory getDaoFactory(int whichFactory){
		switch(whichFactory) {
			case 1:
				return new MySqlDaoFactory();
			case 2:
//				return new SqlServerDaoFactory();
			break;
		}
		return null;
	}
	public abstract IPaisDao getPaisDao();
	public abstract IAdminDao getAdminDao();
	public abstract IUbicacionDao getUbicacionDao();
	public abstract IAerolineaDao getAerolineaDao();
	public abstract IClienteDao getClienteDao();
	public abstract ITripulanteDao getTripulanteDao();
}
