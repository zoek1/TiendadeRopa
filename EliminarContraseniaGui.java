import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.awt.Container.*;
import java.io.*;

class EliminarContraseniaGui implements ActionListener{
  private static String fallo = "Contraseña Incorrecta";
  private static final String Ok = "Aceptar";
  private static final String Cancelar = "Cancelar";
  private static final String Eliminar = "Eliminar";
  
  private String NameArchivo;
  private Archivos Archivo;
  private boolean Flag;
private  JLabel label;
 private JPasswordField Contrasena;
 private JFrame Contenedor;
  
  public EliminarContraseniaGui(String NameArchivo){


    this.NameArchivo = NameArchivo;
  



  
  	Archivo = new Archivos(new File(NameArchivo));
      Flag = false;
      Contenedor = new JFrame(); 
      Contenedor.setLayout(new GridLayout(3,1));     
      
      ImageIcon icono = new ImageIcon("Emblemas/Quitar-48.png");

      JLabel  IconoSeguridad=new JLabel(new ImageIcon("Emblemas/Quitar-48.png"));
      JComponent Password = CrearPasswordGui("Ingresa la contraseña a eliminar");
      JComponent Botones = CrearPanelBotones("Eliminar","Cancelar");

      Contenedor.setIconImage(icono.getImage());
      Contenedor.add(IconoSeguridad);
      Contenedor.add(Password);
      Contenedor.add(Botones);
	
      Contenedor.pack();
      Contenedor.setVisible(true);
  		Contenedor.addWindowListener((new WindowAdapter(){
  		public void windowClosing(WindowEvent e){
  		    Contenedor.setVisible(false);
  		    Contenedor.dispose();
  		} })); 
  
    }
  
  private JComponent CrearPasswordGui(String Etiqueta){
    JPanel ContenedorContraseña = new JPanel(new GridLayout(0,2));
    JLabel Mensaje = new JLabel(Etiqueta);
    Contrasena = new JPasswordField();

    ContenedorContraseña.add(Mensaje);
    ContenedorContraseña.add(Contrasena);

    return ContenedorContraseña;
  }

  private JComponent CrearPanelBotones(String Aceptar, String Cancelar){
    JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JButton OkButton = new JButton(Aceptar);
    JButton CancelarButton = new JButton(Cancelar);

    OkButton.addActionListener(this);
    CancelarButton.addActionListener(this);

    p.add(OkButton);
    p.add(CancelarButton);
    p.setSize(50,30);

    return p;
  }

    
  public void actionPerformed(ActionEvent e){
    String cmd = e.getActionCommand();
    Contrasenia temporal = new Contrasenia(Archivo);
    
   if(Eliminar.equals(cmd)){ //Eliminar constraseña
      
      String Entrada;
      Entrada = Contrasena.getText();
      if((temporal.VerificarPassword(Entrada) == true)) {
	 if(temporal.getNumContraseñas() > 1) {
	   Contrasena = null;
	Flag = temporal.Eliminarpassword(Entrada);
	Entrada = null;
	  JOptionPane.showMessageDialog(null,"Contraseña eliminada satisfactoriamente");
	Exit(Contenedor);
}else{
	   JOptionPane.showMessageDialog(null,"Solo existe una contraseña no se puede eliminar");
	   Exit(Contenedor);
	 }}else{
	Flag = false;
	JOptionPane.showMessageDialog(null,"Constraseña no existe");
	Exit(Contenedor);}
      }else{ //The user has asked for help.
      System.out.println("Abandonando ventana de contraseña");
      Exit(Contenedor); 
    }
    }
  
   protected boolean getFlag(){
      return Flag;
    }
  
  private final void Exit(JFrame Frame) {
    Frame.setVisible(false);
    Frame.dispose();
    try{Archivo.Cerrar();
    }catch(IOException e)
      {
	System.out.println("Error: Ocurrio un error al cerrar archivo");
      }

 
  }

 }
