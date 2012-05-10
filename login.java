import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class login extends JFrame{
    private JPanel LoginParte1,LoginParte2,ContenedorBoton,ContenedorEtiqueta;
    private JLabel Rana,Mensaje;
    private JButton Ok,Cancel;
    private JPasswordField Contrasenia;

    public login(){
	super("Login - AxelDM");
	// Icono de ventana
	ImageIcon icono = new ImageIcon("Emblemas/Seguridad.png");
	
	this.setIconImage(icono.getImage());
	setLayout(new FlowLayout(FlowLayout.LEFT));
	
	ManejadorEventos Manejador = new ManejadorEventos();

	LoginParte1 = new JPanel();
	LoginParte1.setLayout(new GridLayout(2,0));

	LoginParte2 = new JPanel();
	LoginParte2.setLayout(new FlowLayout(FlowLayout.CENTER));
	ContenedorEtiqueta = new JPanel();
	ContenedorEtiqueta.setLayout(new GridLayout(2,0));
	Mensaje = new JLabel("Introduce la contraseña");
	ContenedorEtiqueta.add(Mensaje);

	Contrasenia = new JPasswordField();
	ContenedorEtiqueta.add(Contrasenia);
	Contrasenia.addActionListener(Manejador);
	
	ContenedorBoton = new JPanel();
	ContenedorBoton.setLayout(new FlowLayout(FlowLayout.CENTER));
	Ok = new JButton("Aceptar");
	Ok.addActionListener(Manejador);
	ContenedorBoton.add(Ok);

	Cancel = new JButton("Cancelar");
	Cancel.addActionListener(Manejador);
	ContenedorBoton.add(Cancel);
	LoginParte1.add(ContenedorEtiqueta);
	LoginParte1.add(ContenedorBoton);
	Rana = new JLabel(new ImageIcon("Emblemas/rana.png"));
	LoginParte2.add(Rana);
	add(LoginParte2);
	add(LoginParte1);
	pack();
	setVisible(true);
	
	addWindowListener((new WindowAdapter(){
		public void windowClosing(WindowEvent e){
		    setVisible(false);
		    dispose();
		} })); 
    }

    private class ManejadorEventos implements ActionListener{
	public void actionPerformed(ActionEvent evento){
	    if(evento.getSource() == Ok | evento.getSource()== Contrasenia ){
		String Entrada = Contrasenia.getText();
		Contrasenia temporal = new Contrasenia("Keyhash");
		if(temporal.VerificarPassword(Entrada) == true){
		    Contrasenia = null;
		    Entrada = null;
		    setVisible(false);
		    dispose();
		    JOptionPane.showMessageDialog(null,"Contraseña Correcta");
		    new TiendaRopa();
		}else{
		    Contrasenia.setText("");
		    JOptionPane.showMessageDialog(null,"Error: Contraseña Incorrecta");

		    Contrasenia.requestFocusInWindow();
		    
		}}

	    else if(evento.getSource() == Cancel){
		setVisible(false);
		dispose();
	    }

	}
    }
}

