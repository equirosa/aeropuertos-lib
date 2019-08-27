package com.eduardoquiros.accesodatos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Eduardo Quiros
 * @version 1.0
 * @since 2019-08-21
 */
public class Conector {
	private static AccesoBD conectorBD = null;
	private static final String CONEXION = "conexion.txt";
	
	/**
	 * Retorna un acceso a la base de datos basao en el String necesario.
	 * @return Retorna una conexion a la base de datos.
	 * @throws Exception Pueden haber errores al accesar la base de datos.
	 */
	public static AccesoBD getConector() throws Exception{
		String[] datos = separador(leerConfig());
		if(conectorBD == null){
//			conectorBD = new AccesoBD("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost/omnivuelos?","root","");
			conectorBD = new AccesoBD(datos[0],datos[1],datos[2],"");
		}
		return conectorBD;
	}
	
	private static String[] separador(String leerConfig) {
		return leerConfig.split(",");
	}
	
	private static String leerConfig() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(CONEXION));
		String datos = null;
		
		while ((datos = reader.readLine()) != null){
			return datos;
		}
		return datos;
	}
}
