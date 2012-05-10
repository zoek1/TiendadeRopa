import java.io.*;

class ClienteArchivos{
    public static void main(String [] Args) throws IOException {
	Archivos prueba = new Archivos("");
	prueba.EscribirFinal("Hola mundo");
	prueba.EscribirFinal("adios mundo");
	System.out.println("se escribio: " +  prueba.LeerLinea());
	prueba.ReiniciarLectura();
	System.out.println("se escribio: " +  prueba.LeerLinea());
	prueba.Set_Archivo("adiosmundo.enjava");
	prueba.EscribirFinal("Hola mundo");
	prueba.EscribirFinal("adios mundo");
	System.out.println("se escribio: " +  prueba.LeerLinea());
	System.out.println("se escribio: " +  prueba.LeerLinea());
       	prueba.EliminarLinea("adios mundo");
	// prueba.remplazar("hola","adios");
	prueba.Cerrar();
    }
}
