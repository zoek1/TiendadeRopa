import java.io.*;
import java.util.Date;

class Reloj{
  private Date reloj;
  
  public Reloj(){
    reloj = new Date();
  }

  
  public int getHora(){
    return reloj.getHours();
  }

  public int getMinuto(){
    return reloj.getMinutes();
  }

  public int getSegundo(){
    return reloj.getSeconds();
  }

  public int getMes(){
    return reloj.getMonth();
  }

  public int getAnio(){
    return reloj.getYear();
  }

  public String getTiempo(){
    String tmp="";
    tmp = Integer.toString(getHora()) + ":"
      + Integer.toString(getMinuto()) + ":"
      + Integer.toString(getSegundo());
    return tmp;
  }

  public String getTiempo(String Formato){
    String tmp="";
    if (Formato!=null){
      String [] ArrayFormato = Formato.split("%");
      int indice=1;
    
      while(indice < ArrayFormato.length){
	char [] charArray = ArrayFormato[indice].toCharArray();
	switch(charArray[0]){
	case 'h':
	  tmp = tmp != "" ? tmp + ":" +Integer.toString(getHora())
			  : tmp + Integer.toString(getHora());
	  break;
	case 'm':
	  tmp = tmp != "" ? tmp + ":" +Integer.toString(getMinuto())
	                  : tmp + Integer.toString(getMinuto());
	  break;
	case 's':
	  tmp = tmp != "" ? tmp + ":" +Integer.toString(getSegundo())
	                  : tmp + Integer.toString(getSegundo());
	  break;
	case 'M':
	  tmp = tmp != "" ? tmp + ":" +Integer.toString(getMes())
			  : tmp + Integer.toString(getMes());
	  break;
	case 'A':
	  tmp = tmp != "" ? tmp + ":" +Integer.toString(getAnio())
			  : tmp + Integer.toString(getAnio());
	  break;
	default:
	  System.out.println("Opcion desconocida: " + ArrayFormato[indice]);
	}
	indice++;
      }
    }
    return tmp;
  }
}
