package com.eduardoquiros.bl.dao.factory;

import com.eduardoquiros.bl.dao.admin.IAdminDao;
import com.eduardoquiros.bl.dao.admin.MySqlAdminDao;
import com.eduardoquiros.bl.dao.pais.IPaisDao;
import com.eduardoquiros.bl.dao.pais.MySqlPaisDao;

public class MySqlDaoFactory extends DaoFactory {
	public IPaisDao getPaisDao(){return new MySqlPaisDao();}
	
	public IAdminDao getAdminDao(){return new MySqlAdminDao();}
}
