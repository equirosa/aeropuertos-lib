import com.eduardoquiros.tl.ControladorPais;

public class Main {
public static ControladorPais gestorPais = new ControladorPais();

    public static void main(String[] args){
        System.out.println(gestorPais.insertar("123","Costa Rica","CRC"));
        System.out.println(gestorPais.buscarPorCodigo("123"));
    }
}
