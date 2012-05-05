import java.io.*;

class Archivos {
    protected File NombreArchivo;
    protected PrintWriter ArchivoEscritura;
    protected BufferedReader ArchivoLectura;
    protected int NumeroLinea;

    public Archivos(String N_archivo) {
	try{	
	NombreArchivo = new File(N_archivo);

	if(!NombreArchivo.exists())
	    NombreArchivo.createNewFile();
	
	if(NombreArchivo.canRead()){
	    ArchivoLectura = new BufferedReader(new FileReader(NombreArchivo));
	}else{
	    NombreArchivo = null;
	    System.out.println("Error: El Archivo no puede ser leído");
	}
	}catch(IOException e){
	    System.out.println("Archivo no puede ser creado - nombre Invalido");
	}
	NumeroLinea = 0;
    }

    protected void Set_Archivo(String N_archivo) throws IOException{
	if(ArchivoLectura != null)
	    ArchivoLectura.close();
	
	if(ArchivoEscritura != null)
	    ArchivoEscritura.close();
	
	NombreArchivo = new File(N_archivo);

	if(!NombreArchivo.exists())
	    NombreArchivo.createNewFile();
	
	if(NombreArchivo.canRead()){
	    ArchivoLectura = new BufferedReader(new FileReader(NombreArchivo));
	}else{
	    NombreArchivo = null;
	    System.out.println("Error: El Archivo no puede ser leído");
	}

	NumeroLinea = 0;	
    }

    
    protected void EscribirFinal(String Line) throws IOException{
	if(NombreArchivo != null){
	    if(NombreArchivo.canWrite()){
	    	ArchivoEscritura = new PrintWriter(new FileWriter(NombreArchivo,true));
		ArchivoEscritura.println(Line);
		ArchivoEscritura.close();
	    }else
		System.out.println("Error: Faltan permisos, el archivo no puede ser escrito");
	}else
	    System.out.println("Error: Error en la apertura del fichero");
    }

    protected void SobreEscribir(String Line) throws IOException{
	if(NombreArchivo != null){
	    if(NombreArchivo.canWrite()){
	    	ArchivoEscritura = new PrintWriter(new FileWriter(NombreArchivo));
		ArchivoEscritura.println(Line);
		ArchivoEscritura.close();
	    }else
		System.out.println("Error: El Archivo no puede ser escrito");
	}else
	    System.out.println("Error: Error en apertura del fichero");
    }

    protected String LeerLinea() throws IOException{
	String Line = null;
	if(NombreArchivo != null){
	    if(NombreArchivo.canRead()){
		NumeroLinea = NumeroLinea + 1;
		Line = ArchivoLectura.readLine();

		if(Line == null)
		    System.out.println("Función: LeerLinea\n\t Fin de Archivo");
		else
		    System.out.println("Función: LeerLinea\n\t Contenido de Linea: " + Line + " - En linea: # " + NumeroLinea);

	    }else
		System.out.println("Error: Error en la apertura del fichero");
	}else
	    System.out.println("Error: Error en apertura del fichero, no puede ser leído");

	return Line;
    }

    protected void ReiniciarLectura() throws IOException{
	if(NombreArchivo != null){
	    if(ArchivoLectura!=null)
		ArchivoLectura.close();

	    if(NombreArchivo.canWrite()){
		ArchivoLectura = new BufferedReader(new FileReader(NombreArchivo));
		NumeroLinea = 0;
	    }else
		System.out.println("Error: El Archivo no puede ser leído");
	}else
	    System.out.println("Error: Error en apertura del fichero, no puede ser leído");	
    }


    protected void Cerrar() throws IOException{
	if(ArchivoLectura != null)
	    ArchivoLectura.close();
	
	if(ArchivoEscritura != null)
	    ArchivoEscritura.close();
    }

}
