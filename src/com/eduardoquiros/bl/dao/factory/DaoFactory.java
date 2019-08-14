package com.eduardoquiros.bl.dao.factory;

import com.eduardoquiros.bl.dao.pais.IPaisDao;

public abstract class DaoFactory {
	public static final int MySQL = 1;
	public static final int SQL = 2;
	public static final int Oracle = 3;
	
	public static DaoFactory getDaoFactory(int whichFactory){
		switch(whichFactory) {
			case 1:
				return new MySqlDaoFactory();
			case 2:
//				return new SqlServerDaoFactory();
			break;
			case 3:
//				return new OracleDaoFactory();
			break;
		}
		return null;
	}
	public abstract IPaisDao getPaisDao();
}
