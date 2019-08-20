import com.eduardoquiros.tl.ControladorAdmin;
import com.eduardoquiros.tl.ControladorLogin;
import com.eduardoquiros.tl.ControladorPais;

import static java.lang.System.out;

public class Main {
	public static ControladorLogin gestorLogin = new ControladorLogin();
	public static ControladorPais gestorPais = new ControladorPais();
	public static ControladorAdmin gestorAdmin = new ControladorAdmin();
	
	public static void main(String[] args){
		out.println(gestorLogin.isNotLoggedIn());
		out.println(gestorAdmin.noAdmins());
	}
}
