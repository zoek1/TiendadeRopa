import java.io.*;
import javax.swing.*;

class Main{
private File Existe;
    private ContraseniaGui nueva;
    public Main(){
	Existe = new File("Keyhash");

	if (Existe.exists() == true){
	    new login();
	}
	else
	    {
		JOptionPane.showMessageDialog(null,"Sistema nuevo");

		nueva = new ContraseniaGui(new File("Keyhash"));
		nueva.NuevaContrasenia();
		new TiendaRopa();
	    }
    }


    public static void main(String [] Args){
	new Main();
    }
}
