import com.eduardoquiros.tl.ControladorPais;

public class Main {
public static ControladorPais gestorPais = new ControladorPais();
//public static ControladorAdmin gestorAdmin = new ControladorAdmin();

    public static void main(String[] args){
        System.out.println(gestorPais.insertar("123","Costa Rica","CRC"));
        System.out.println(gestorPais.insertar("456","Panama","PAN"));
        System.out.println(gestorPais.insertar("789","Nicaragua","NIC"));
        String[] lista = gestorPais.getPaises();
        for(String data:lista){
            System.out.println(data);
        }
    }
}
