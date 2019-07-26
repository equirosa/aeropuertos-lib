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
                if (controlador.verificarExistenciaAdmin()) {
                    int opcionMenuPrincipal;
                    do{
                        opcionMenuPrincipal = mostraMenuPrincipal();
                    }while(opcionMenuPrincipal != 0);
                }else{
                    solicitarPrimerAeropuerto();
                }
            }else{
                solicitarPrimerAdmin();
            }
        }while(!(verificarExistenciaAdmin()));
    }

    private static int mostraMenuPrincipal() {
        out.println("Menu Principal \n" +
                "Seleccione una opcion... \n" +
                "1.Registrar\n" +
                "2.Listar");
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

    //Envia la informacion del Admin al gestor.
    private static void registrarAdmin() {
        String[] infoPersona = solicitarInfoPersona();
        char infoAdmin = solicitarInfoAdmin();

        controlador.registrarAdmin(infoPersona,infoAdmin);
    }

    //Esta funcion solicita la informacion pertinente al usuario tipo Admin.
    private static char solicitarInfoAdmin() {
        char genero = 0;

        out.println("Ingrese el genero. (M/F/O)");
        try {
            genero = in.readLine().charAt(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return genero;
    }

    //Esta funcion le pide alusuario la informacion basica de toda Persona, exceptuando la contrasenna.
    private static String[] solicitarInfoPersona() {
        String[] infoPersona = new String[9];

        try{
            out.println("Ingrese el nombre.");
            infoPersona[0] = in.readLine().toUpperCase().charAt(0) + in.readLine().substring(1);
            out.println("Ingrese el primer apellido.");
            infoPersona[1] = in.readLine().toUpperCase().charAt(0) + in.readLine().substring(1);
            out.println("Ingrese el segundo apellido.");
            infoPersona[2] = in.readLine().toUpperCase().charAt(0) + in.readLine().substring(1);
            out.println("Ingrese la cedula.");
            infoPersona[3] = in.readLine();
            out.println("Ingrese el email.");
            infoPersona[4] = in.readLine();
            out.println("Ingrese el detalle de direccion.");
            infoPersona[5] = in.readLine();
            out.println("Ingrese el anno de nacimiento.");
            infoPersona[6] = in.readLine();
            out.println("Ingrese el mes de nacimiento.");
            infoPersona[7] = in.readLine();
            out.println("Ingrese el dia de nacimiento.");
            infoPersona[8] = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return infoPersona;
    }

    private static boolean verificarExistenciaAdmin() {
        return controlador.verirficarExistenciaAdmin();
    }

    private static void mostrarTasaImpuestos(){
        out.println(controlador.getImpuesto());
    }

    private static void setImpuesto(){
        out.println("La tasa de impuesto actual es...");
        mostrarTasaImpuestos();
        out.println("Ingrese la tasa nueva que desea configurar.");
        try {
            controlador.setImpuesto(Double.parseDouble(in.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        out.println("La nueva tasa de impuesto es...");
        mostrarTasaImpuestos();
    }
}
