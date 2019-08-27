package com.eduardoquiros.tl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ControladorExcepciones {
	private static final String ERRLOG = "errorLog.txt";
	
	public ControladorExcepciones() {
			crearArchivo();
	}
	
	public static void crearArchivo() {
		File f=new File(ERRLOG);
		
		try {
			f.createNewFile();
		} catch (IOException e) {
			imprimirError(e.getMessage());
		}
	}
	
	public static void imprimirError(String message) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(ERRLOG,true));
			writer.write(message);
			writer.newLine();
			writer.close();
		} catch (IOException e) {
			imprimirError(e.getMessage());
		}
	}
	
	
}
