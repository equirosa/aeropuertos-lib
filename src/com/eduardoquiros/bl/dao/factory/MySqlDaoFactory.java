package com.eduardoquiros.bl.dao.factory;

import com.eduardoquiros.bl.dao.admin.IAdminDao;
import com.eduardoquiros.bl.dao.admin.MySqlAdminDao;
import com.eduardoquiros.bl.dao.aerolinea.IAerolineaDao;
import com.eduardoquiros.bl.dao.aerolinea.MySqlAerolineaDao;
import com.eduardoquiros.bl.dao.cliente.IClienteDao;
import com.eduardoquiros.bl.dao.cliente.MySqlClienteDao;
import com.eduardoquiros.bl.dao.pais.IPaisDao;
import com.eduardoquiros.bl.dao.pais.MySqlPaisDao;
import com.eduardoquiros.bl.dao.tripulante.ITripulanteDao;
import com.eduardoquiros.bl.dao.tripulante.MySqlTripulanteDao;
import com.eduardoquiros.bl.dao.ubicacion.IUbicacionDao;
import com.eduardoquiros.bl.dao.ubicacion.MySqlUbicacionDao;

public class MySqlDaoFactory extends DaoFactory {
	public IPaisDao getPaisDao(){return new MySqlPaisDao();}
	public IUbicacionDao getUbicacionDao(){return new MySqlUbicacionDao();}
	public IAerolineaDao getAerolineaDao() {return new MySqlAerolineaDao();}
	
	@Override
	public IClienteDao getClienteDao() {
		return new MySqlClienteDao();
	}
	
	
	@Override
	public ITripulanteDao getTripulanteDao() {
		return new MySqlTripulanteDao();
	}
	
	public IAdminDao getAdminDao(){return new MySqlAdminDao();}
}
