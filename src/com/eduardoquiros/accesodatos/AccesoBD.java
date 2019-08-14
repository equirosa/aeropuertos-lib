package com.eduardoquiros.accesodatos;

import java.sql.*;

public class AccesoBD {
	private Connection conn;
	private Statement stmt;
	
	public AccesoBD(String driver, String strConnection) throws SQLException,Exception {
		//se registra el driver del motor de la base de datos
		Class.forName(driver);
		//inicializa la conexion, pasando el string de conexion al metodo getConnection del DriverManager.
		conn = DriverManager.getConnection(strConnection);
		//se inicializa el statement con la instancia de statement que retorna el metodo createStatement de la clase Connection.
		stmt=conn.createStatement();
	}
	
	public AccesoBD(String driver, String url, String user, String pswd) throws SQLException,Exception{
		Class.forName(driver);
		conn=DriverManager.getConnection(url,user,pswd);
		stmt=conn.createStatement();
	}
	
	//Para consultas tipo insert, delete, update.
	public void ejecutarSql(String query) throws SQLException {
		stmt.execute(query);
	}
	
	//para consultas "select".
	public ResultSet ejecutarQuery(String query) throws SQLException {
		return stmt.executeQuery(query);
	}
}
