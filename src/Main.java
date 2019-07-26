import com.eduardoquiros.tl.Gestor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static PrintStream out = System.out;
    private static Gestor controlador;

    public static void main(String[] args){
        do {
            if (verificarExistenciaAdmin()) {

            }else{
                solicitarPrimerAdmin();
            }
        }while(!(verificarExistenciaAdmin()));
    }

    private static void solicitarPrimerAdmin() {
        out.println("El sistema, acutalmente, no tiene ningun administrador registrado. " +
                "\n Desea registrar uno? (Y/n)");
        try {
            if(in.readLine().toLowerCase().charAt(0) == 'y' || in.readLine().equals(null)){
                registrarAdmin();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void registrarAdmin() {
        String[] infoPersona = solicitarInfoPersona();
    }

    //Esta funcion le pide alusuario la informacion basica de toda Persona, exceptuando la contrasenna.
    private static String[] solicitarInfoPersona() {
        String[] infoPersona = new String[9];

        out.println("Ingrese el nombre.");
        out.println("Ingrese el primer apellido.");
        out.println("Ingrese el segundo apellido.");
        out.println("Ingrese la cedula.");
        out.println("Ingrese el email.");
        out.println("Ingrese el detalle de direccion.");
        out.println("Ingrese el anno de nacimiento.");
        out.println("Ingrese el mes de nacimiento.");
        out.println("Ingrese el dia de nacimiento.");
    }

    private static boolean verificarExistenciaAdmin() {
        return controlador.verirficarExistenciaAdmin();
    }
}
