import com.eduardoquiros.tl.Gestor;

import java.io.BufferedReader;
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
                "\n Por favor registre uno.");
    }

    private static boolean verificarExistenciaAdmin() {
        return controlador.verirficarExistenciaAdmin();
    }
}
