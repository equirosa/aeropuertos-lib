package com.eduardoquiros.accesodatos;

/**
 * @author Eduardo Quiros
 * @version 1.0
 * @since 2019-08-21
 */
public class Conector {
	private static AccesoBD conectorBD = null;
	
	/**
	 * Retorna un acceso a la base de datos basao en el String necesario.
	 * @return Retorna una conexion a la base de datos.
	 * @throws Exception Pueden haber errores al accesar la base de datos.
	 */
	public static AccesoBD getConector() throws Exception{
		if(conectorBD == null){
			conectorBD = new AccesoBD("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost/omnivuelos?","root","");
		}
		return conectorBD;
	}
}
