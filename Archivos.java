import java.io.*;

class Archivos {
    private File NombreArchivo;
    private PrintWriter ArchivoEscritura;
    private BufferedReader ArchivoLectura;
    private int NumeroLinea;
    private RandomAccessFile ArchivoRemplazo;
    private long PointerWrite = 0,PointerRead = 0;
  
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

      public Archivos(File N_archivo) {
	try{	
	  NombreArchivo = N_archivo;
	  
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

    public static String SustituirRegExp(String Line ,String regexp, String remplazar){
	String [] Arraycadena;
	int indice = 0;
	String Buffer = Line;
	Arraycadena = Line.split(regexp);
	while(indice + 1  < Arraycadena.length){
	    System.out.println("Array con indie No. " + indice + " tiene la frase: " + Arraycadena[indice]);
	    if( Arraycadena[indice] == "")
		Buffer = remplazar;
	    else
		Buffer = remplazar;

	    Buffer = Buffer + Arraycadena[indice];
	    indice++;
	}
	return Buffer; 
    }

    protected boolean EliminarLinea(String Line) throws IOException{
	String ReadLine = "";
	boolean flag,retorno=false;
	PointerRead = -1;
	PointerWrite = -1;
	ArchivoRemplazo = new RandomAccessFile(NombreArchivo,"rw");
	while((ReadLine = ArchivoRemplazo.readLine()) != null){
	    if(ReadLine.equals(Line))
		{
		    System.out.println("La cadena que se va a remplazar es " + ReadLine);
		    if(PointerWrite== -1){
		      retorno = true;
			PointerWrite = ArchivoRemplazo.getFilePointer() - ReadLine.length()-1;
			System.out.println("El puntero de escritura es: " + PointerWrite);
		    }

		    if(PointerWrite != -1){
			PointerRead = ArchivoRemplazo.getFilePointer();
		    
			System.out.println("El puntero de lectura esta en: " + PointerRead );
			ReadLine = null;
			if ((ReadLine = ArchivoRemplazo.readLine()) != null)
			    {
			      
			      if(ReadLine.equals(Line)){
				while((ReadLine = ArchivoRemplazo.readLine()).equals(Line));
				  if (ReadLine == null)
				    break;
				  }
			      ArchivoRemplazo.seek(PointerWrite);
			      System.out.println("Se imprimira la cadena:" + ReadLine + "En la posicion: " + ArchivoRemplazo.getFilePointer());
			      ArchivoRemplazo.write((ReadLine + "\n").getBytes());
			      PointerWrite = ArchivoRemplazo.getFilePointer();
			      ArchivoRemplazo.seek(PointerRead);
			    }
		    }
		}
	}
	ArchivoRemplazo.setLength(PointerWrite);
	ArchivoRemplazo.close();
	return retorno;
    }

    protected void Cerrar() throws IOException{
	if(ArchivoLectura != null)
	    ArchivoLectura.close();
	if(ArchivoEscritura != null)
	    ArchivoEscritura.close();
    }

}
