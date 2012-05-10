import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.awt.Container.*;
import java.io.*;

class ContraseniaGui{
  
  private String NameArchivo;

  public ContraseniaGui(String NameArchivo){


    this.NameArchivo = NameArchivo;
  }


      protected void NuevaContrasenia(){
	
       new NuevaContraseniaGui(NameArchivo);
    }


      protected void EliminarContrasenia(){
	new EliminarContraseniaGui(NameArchivo);
      }
  
  protected void VerifContraseniaGui(){
    new VerifContraseniaGui(new File(NameArchivo));
  }


  protected void CambiarContrasenia(){
    new CambiarContraseniaGui(NameArchivo);
  }

 }
