import java.io.*;

class Contrasenia {
  private Archivos Archivokey;
  private int NumContraseñas;
  public Contrasenia(String CambioArchivo){
    Archivokey = new Archivos(CambioArchivo);
    NumContraseñas = 0;
  }

  public Contrasenia(File Archivo){
    Archivokey = new Archivos(Archivo);
  }

   public Contrasenia(Archivos Archivo){
    Archivokey = Archivo;
  }
  
  protected String Newhashing(String password){
    String hash = Hashingmd5.ObtenerHash(password);
    return hash;
  }

  protected boolean Agregarpassword(String Hashing){
    if(Hashing.length() > 5){
      try{
      if(VerificarPassword(Hashing)==false){
      String hash = Newhashing(Hashing);
      Archivokey.EscribirFinal(hash);
      NumContraseñas +=1;
      return true;
      }
    }catch(IOException e){
      System.out.println("No se puedo escribir Archivo Key");  
    }
    }
    return false;
  }

  protected boolean Agregarpassword(Hashingmd5 Hashing){
    if (Hashing.getHashing() != null){
      try{
      if (VerificarPassword(Hashing) == false){
	Archivokey.EscribirFinal(Hashing.getHashing());
	NumContraseñas +=1;
	return true;
      }
    }catch(IOException e){
      System.out.println("No se puedo escribir Archivo Key");  
    }
 }   return false;
  }

  protected boolean Eliminarpassword(String Hashing){
    Hashing = Newhashing(Hashing);
    boolean flag = false;
    if(NumContraseñas > 1){
    try{
      flag = Archivokey.EliminarLinea(Hashing);
      NumContraseñas -= 1;
    }catch(IOException e){
      System.out.println("No se pudo borrar Coincidencia en Key");
    }}else{
      System.out.println("Solo existe una contraseña no se puede eliminar");
    }
    return flag;
  }
  
  protected boolean Eliminarpassword(Hashingmd5 Hashing){
    boolean flag = false;
        if(NumContraseñas > 1){
    try{
      flag = Archivokey.EliminarLinea(Hashing.getHashing());
    }catch(IOException e){
      System.out.println("No se pudo borrar Coincidencia en Key");
    }
	}else{
      System.out.println("Solo existe una contraseña no se puede eliminar");
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
      System.out.println("No se pudo hacer comparacion key");
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
  
  protected int getNumContraseñas(){
    return NumContraseñas;
  }

}