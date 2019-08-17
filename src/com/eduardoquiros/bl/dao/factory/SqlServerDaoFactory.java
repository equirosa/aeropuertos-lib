package com.eduardoquiros.bl.dao.factory;

import com.eduardoquiros.bl.dao.admin.IAdminDao;
import com.eduardoquiros.bl.dao.pais.IPaisDao;
import com.eduardoquiros.bl.dao.ubicacion.IUbicacionDao;

public class SqlServerDaoFactory {
	public IAdminDao getAdminDao(){return new SqlServerAdminDao();}
	public IUbicacionDao getUbicacionDao(){return new SqlServerUbicacionDao();}
	public IPaisDao getPaisDao(){return new SqlServerPaisDao();}
}
