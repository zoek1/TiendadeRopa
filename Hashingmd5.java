import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.*;
import javax.swing.*;

class Hashingmd5{
  private static final char[] HEXADECIMAL = { '0', '1', '2', '3',
					      '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
  
  private String Hash;
  
  public Hashingmd5(String Hash){
    this.Hash = ObtenerHash(Hash);
  }

  protected void SetHashing(String Hash){
    this.Hash  = ObtenerHash(Hash);
  }

  protected String getHashing(){
    return this.Hash;
  }
  
  public  static String ObtenerHash(String stringToHash){
    if(stringToHash.length()>5) {
    try {
      MessageDigest md5 = MessageDigest.getInstance("MD5");
      byte[] bytes = md5.digest(stringToHash.getBytes());
      StringBuilder sb = new StringBuilder(2 * bytes.length);
      
      for (int i = 0; i < bytes.length; i++) {
	int low = bytes[i] & 0x0f;
	int high = (bytes[i] & 0xf0) >> 4;
	sb.append(HEXADECIMAL[high]);
	sb.append(HEXADECIMAL[low]);
      }
      
      return sb.toString();
      
    }catch (NoSuchAlgorithmException e) {
      // Manejo de Excepcion
      System.out.println("Excepción: No se pudo obtener la suma de verificación");
  return null;
    }
    }else{
      System.out.println("Se necesitan 5 caracteres como minimo para crear la suma");
      System.out.println("LA cedena devuelsa sera nula");
    }
    return null;
  }
}

