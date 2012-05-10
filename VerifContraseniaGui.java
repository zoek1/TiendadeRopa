import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.awt.Container.*;
import java.io.*;

class VerifContraseniaGui extends JFrame implements ActionListener{
  private static String fallo = "Contraseña Incorrecta";
  private static String Ok = "Ok";
  private static String Cancelar = "Cancelar";
    
  private JLabel label;
  private JPasswordField Contrasenia;
  private boolean flag;

  private File Archivo;
    
  public VerifContraseniaGui(File Archivo){
    super("Ingrese Contraseña");
    setLayout(new GridLayout(2,1));
    this.Archivo = Archivo;
    //setLayout(null);
    Contrasenia = new JPasswordField(15);
    Contrasenia.setActionCommand(Ok);
    Contrasenia.addActionListener(this);
    flag = false;
    JLabel etiqueta = new JLabel("Introduce la contraseña");
    etiqueta.setLabelFor(Contrasenia);

    // Icono del Frame
    ImageIcon icono = new ImageIcon("Emblemas/Seguridad.png");
    this.setIconImage(icono.getImage());

    // Creacion de Botones
    JComponent buttonPane = createButtonPanel();	

    // Ubicacion de los objetos dentro del frame
    JPanel ContSup = new JPanel(new GridLayout(0,2));
    JPanel textPane = new JPanel(new GridLayout(2,0));
    JLabel  boton1=new JLabel(new ImageIcon("Emblemas/Seguridad.png"));
   
    // Almacenar en contenedor inferior
    // textPane.setSize(70,30);
    textPane.add(etiqueta);
    textPane.add(Contrasenia);

    // Almacenar en contenedor superior
    ContSup.add(boton1);
    ContSup.add(textPane);
    
    add(ContSup);
    add(buttonPane);

    
    addWindowListener((new WindowAdapter(){
	public void windowClosing(WindowEvent e){
	  setVisible(false);
	  dispose();
      } })); 

    // Mostrar Pantalla.
    // setSize(350,100);
    pack();
      setVisible(true);

  }

  protected JComponent createButtonPanel(){
    JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JButton OkButton = new JButton("Ok");
    JButton CancelarButton = new JButton("Cancelarr");

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
    if(Ok.equals(cmd)){ //Procesar constraseña
      String Entrada;
      Entrada = Contrasenia.getText();
      if(temporal.VerificarPassword(Entrada) == true){
	flag = true;
	JOptionPane.showMessageDialog(null,"Contraseña Correcta");
      }else{
	flag = false;
	JOptionPane.showMessageDialog(null,fallo);
      }
      
      Contrasenia.selectAll();

      Entrada = null;
      Exit();
    } else { //The user has asked for help.
      Exit();
    }
  }

  private final void Exit(){
    setVisible(false);
    dispose();
  }

 }