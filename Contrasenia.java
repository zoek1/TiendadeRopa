import java.io.*;

class Contrasenia {
  private Archivos Archivokey;

  public Contrasenia(String CambioArchivo){
    Archivokey = new Archivos(CambioArchivo);
  }

  public Contrasenia(File Archivo){
    Archivokey = new Archivos(Archivo);
  }
  
  protected String Newhashing(String password){
    String hash = Hashingmd5.ObtenerHash(password);
    return hash;
  }

  protected void Agregarpassword(String Hashing){
    try{
      String hash = Newhashing(Hashing);
      Archivokey.EscribirFinal(hash);
    }catch(IOException e){
      System.out.println("No se puedo escribir Archivo Key");  
    }
  }

  protected void Agregarpassword(Hashingmd5 Hashing){
    try{
      Archivokey.EscribirFinal(Hashing.getHashing());
    }catch(IOException e){
      System.out.println("No se puedo escribir Archivo Key");  
    }
  }

  protected boolean Eliminarpassword(String Hashing){
    Hashing = Newhashing(Hashing);
    boolean flag = false;
    try{
      flag = Archivokey.EliminarLinea(Hashing);

    }catch(IOException e){
      System.out.println("No se pudo borrar Coincidencia en Key");
    }
    return flag;
  }
  
  protected boolean Eliminarpassword(Hashingmd5 Hashing){
    boolean flag = false;
    try{
      flag = Archivokey.EliminarLinea(Hashing.getHashing());
    }catch(IOException e){
      System.out.println("No se pudo borrar Coincidencia en Key");
    }
    return flag;
  }

  protected boolean VerificarPassword(String Hashing){
    Hashing = Newhashing(Hashing);
    String Cmp = null;
    try{
      Archivokey.ReiniciarLectura();
      while((Cmp = Archivokey.LeerLinea())!=null)
	if(Cmp.equals(Hashing))
	  return true;
    }catch(IOException e){
      System.out.println("No se puso hacer comparacion key");
    }
    return false;
  }


  protected boolean VerificarPassword(Hashingmd5 Hashing){
    String Cmp = null;
    try{
      Archivokey.ReiniciarLectura();
      while((Cmp = Archivokey.LeerLinea())!=null)
	if(Cmp.equals(Hashing.getHashing()))
	  return true;
    }catch(IOException e){
      System.out.println("No se puso hacer comparacion key");
    }
    return false;
  }
  
  protected boolean CambiarContraseña(String hash , String newhash){
        Hashingmd5 Hashing  = new Hashingmd5(hash);
	Hashingmd5 Newhash  = new Hashingmd5(newhash);
	boolean flag = false;
	System.out.println("Hashing antiguo: " + Hashing.getHashing());
	if((flag = Eliminarpassword(Hashing))==true){
	  Agregarpassword(Newhash);
	  System.out.println("Cambio de contraseña");
	  System.out.println("Nuevo Hash: " + Newhash.getHashing());
	}else{
	  	  System.out.println("Error: No se Cambio de contraseña");
	}
	return flag;
  }
  
}