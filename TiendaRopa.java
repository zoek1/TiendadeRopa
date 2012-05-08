import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class TiendaRopa extends JFrame{
  public TiendaRopa(){
        ImageIcon icono = new ImageIcon("Emblemas/Faenza-rana.png");
	ImageIcon icono2 = new ImageIcon("Emblemas/rana.png");
	this.setIconImage(icono.getImage());
	JLabel Ranita = new JLabel(icono2);
	add(Ranita);
	addWindowListener((new WindowAdapter(){
	  
	  public void windowClosing(WindowEvent e){
	  setVisible(false);
	  dispose();
	  System.exit(0); } }));
      pack();
      setVisible(true);
  }
  
  public static void main(String [] Args){
    System.out.println("Tienda de ropa");
    System.out.println("Axel Frog");
    System.out.println("Iniciando sistema");
    new TiendaRopa();
  }
}