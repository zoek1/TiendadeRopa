import java.io.*;
import javax.swing.*;

class Main{
private File Existe;
    private ContraseniaGui nueva;
    public Main(){
	Existe = new File("Keyhash");

	if (Existe.exists() == true && Existe.length()>10){
	    new login();
	}
	else
	    {
		JOptionPane.showMessageDialog(null,"Sistema nuevo");

		nueva = new ContraseniaGui("Keyhash");
		nueva.NuevaContrasenia();
		new login();
	    }
    }


    public static void main(String [] Args){
	new Main();
    }
}
