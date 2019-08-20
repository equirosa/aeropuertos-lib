package com.eduardoquiros.tl;

import com.eduardoquiros.bl.dao.admin.MySqlAdminDao;

import java.sql.SQLException;

public class ControladorLogin {
private MySqlAdminDao adminDao;

	public boolean checkAdmins(){
		try {
			return adminDao.getAdmins().equals(null);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
