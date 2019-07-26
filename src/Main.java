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
                        procesarOpcionPrincipal(opcionMenuPrincipal);
                    }while(opcionMenuPrincipal != 0);
                }else{
                    solicitarPrimerAeropuerto();
                }
            }else{
                solicitarPrimerAdmin();
            }
        }while(!(verificarExistenciaAdmin()));
    }

    //Procesa la opcion seleccionada en el menu principal.
    private static void procesarOpcionPrincipal(int opcionMenuPrincipal) {
        switch (opcionMenuPrincipal){
            default:
                 out.println("Opcion invalida");
                 break;
            case 0:
                out.println("Saliendo...");
                break;
            case 1:
                menuRegistrar();
                break:
            case 2:
                menuListar();
                break:
            case 3:
                menuModificar();
                break;
            case 4:
                menuBuscar();
                break;
            case 5:
                menuEliminar();
                break;
        }
    }

    private static void solicitarPrimerAeropuerto() {
        out.println("Actualmente, no hay nignun aeropuerto registrado.\n" +
                "Desea registrar uno?");
        try{
            if(in.readLine().toLowerCase().charAt(0) == 'y' || in.readLine().equals(null)){
                registrarAeropuerto();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int mostraMenuPrincipal() {
        out.println("Menu Principal \n" +
                "Seleccione una opcion... \n" +
                "1.Registrar\n" +
                "2.Listar\n" +
                "3.Modificar\n" +
                "4.Buscar\n" +
                "5.Eliminar");

        try {
            return Integer.parseInt(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    //Le notifica al usuario de la ausencia de administradores y pregunta si desea registrar uno.
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

        if (controlador.verificarDuplicidadAdmin(infoPersona[3])) {
            out.println("Ese administrador ya se encuentra registrado.");
        }else {
            controlador.registrarAdmin(infoPersona, infoAdmin);
        }
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
        String[] infoPersona = new String[10];

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
            listarPaises();
            out.println("Ingrese el codigo del pais de origen.");
            infoPersona[9] = in.readLine();
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

    //Solicita info del Pais y la envia a Gestor.
    private static void registrarPais(){
        try {
            String codigo, nombre, abreviacion;

            out.println("Introduzca el codigo del pais.");
            codigo = in.readLine();
            out.println("Introduzca el nombre del pais.");
            nombre = in.readLine();
            out.println("Introduzca la abreviacion del pais.");
            abreviacion = in.readLine();

            controlador.registrarPais(codigo,nombre,abreviacion);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Lista todos los paises que hay registrados.
    private static void listarPaises(){
        String[] lista = controlador.listarPaises();

        for(String info : lista){
            out.println(info);
        }
    }
}
