package com.eduardoquiros.accesodatos;

import java.sql.SQLException;

public class Conector {
	private static AccesoBD conectorBD = null;
	
	public static AccesoBD getConector() throws SQLException,Exception{
		if(conectorBD == null){
			conectorBD = new AccesoBD("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost/apartados?","root","");
		}
		return conectorBD;
	}
}
