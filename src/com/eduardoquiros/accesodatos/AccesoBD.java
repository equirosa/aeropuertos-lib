package com.eduardoquiros.accesodatos;

import java.sql.*;

/**
 * @author Eduardo Quiros
 * @version 1.0
 * @since 2019-08-12
 */
public class AccesoBD {
	private Connection conn;
	private Statement stmt;
	
	/**
	 * Crea un statement de SQL para la base de datos.
	 * @author Eduardo Quiros
	 * @param driver
	 * @param strConnection
	 * @throws Exception
	 */
	public AccesoBD(String driver, String strConnection) throws Exception {
		//se registra el driver del motor de la base de datos
		Class.forName(driver);
		//inicializa la conexion, pasando el string de conexion al metodo getConnection del DriverManager.
		conn = DriverManager.getConnection(strConnection);
		//se inicializa el statement con la instancia de statement que retorna el metodo createStatement de la clase Connection.
		stmt=conn.createStatement();
	}
	
	/**
	 * Crea unstatement de SQL para la base de datos.
	 * @author Eduardo Quiros
	 * @param driver
	 * @param url
	 * @param user
	 * @param pswd
	 * @throws Exception
	 */
	public AccesoBD(String driver, String url, String user, String pswd) throws Exception{
		Class.forName(driver);
		conn=DriverManager.getConnection(url,user,pswd);
		stmt=conn.createStatement();
	}
	
	/**
	 * Ejecuta un statement de SQL tipo insert, delete, o update.
	 * @author Eduardo Quiros
	 * @param query
	 * @throws SQLException
	 */
	//Para consultas tipo insert, delete, update.
	public void ejecutarSql(String query) throws SQLException {
		stmt.execute(query);
	}
	
	/**
	 * Retorna un resultado de una solicitud a la base de datos.
	 * @author Eduardo Quiros
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	//para consultas "select".
	public ResultSet ejecutarQuery(String query) throws SQLException {
		return stmt.executeQuery(query);
	}
}
