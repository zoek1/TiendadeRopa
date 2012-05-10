import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;

public class Cliente extends JFrame{
	
	///Labels a ocupar
	private JLabel labelSexo, labelNombre, labelEdad, labelDireccion;
	private JLabel labelTelefono, labelFechaNac;
	private JLabel labelFormaDePago,labelNoCliente,	labelFechaDeCompra;
	
	///Cajas de texto
	private JTextField campoNombre, campoEdad, campoDireccion;
	private JTextField campoTelefono, campoFechaNac;
	
	private JTextField campoFormaDePago,campoNoCliente,	campoFechaDeCompra;
	private JTextField campoAsociado;

	private JCheckBox Masculino, Femenino, Socio, NoSocio;
	
	DatCliente datos=new DatCliente();
	
	public Cliente(){
		
			super("Formulario del Cliente");
						
			//Constructores de las cajas de texto
			
			JPanel contenedorLabels = new JPanel();
			contenedorLabels.setLayout(new GridLayout(0,1));
			
			labelNombre= new JLabel("Nombre:");
			labelDireccion= new JLabel("Direccion:");
			labelFechaNac= new JLabel("Fecha de nacimiento:");
			labelEdad= new JLabel("Edad:");
			labelTelefono= new JLabel("Telefono: ");
			
			Socio= new JCheckBox("Asocioado");
			NoSocio=new JCheckBox("No Asociado");
			
			labelFormaDePago=new JLabel("Forma de pago:");
			labelFechaDeCompra= new JLabel("Fecha:");
			
		
			contenedorLabels.add(labelNombre);
			contenedorLabels.add(labelDireccion);
			contenedorLabels.add(labelFechaNac);
			contenedorLabels.add(labelEdad);
			contenedorLabels.add(labelTelefono);
			contenedorLabels.add(Socio);
			contenedorLabels.add(NoSocio);
			contenedorLabels.add(labelFormaDePago);
			contenedorLabels.add(labelFechaDeCompra);
		
		
		
			/*
			Masculino= new JCheckBox("Masculino");
			contenedorLabels.add(Masculino);
			
			Femenino=new JCheckBox("Femenino");
			contenedorLabels.add(Femenino);
			*/
			
			//Creacion del contenedor para los Campos de Texto
						

			JPanel contenedorTexto = new JPanel();
			contenedorTexto.setLayout(new GridLayout(0,1));
		
			campoNombre=new JTextField(40);
			campoDireccion=new JTextField(50);
			campoFechaNac=new JTextField(6);
			campoEdad=new JTextField(2);
			campoTelefono=new JTextField(15);
			campoAsociado =new JTextField("Escriba el numero de socio");
			   
			campoFormaDePago=new JTextField(40);
			campoFechaDeCompra=new JTextField(15);
						
			
			contenedorTexto.add(campoNombre);
			contenedorTexto.add(campoDireccion);
			contenedorTexto.add(campoFechaNac);
			contenedorTexto.add(campoEdad);
			contenedorTexto.add(campoTelefono);
			contenedorTexto.add(campoAsociado);
			contenedorTexto.add(campoFormaDePago);
			contenedorTexto.add(campoFechaDeCompra);
			
			
			JPanel contentPane = new JPanel();
			contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
			contentPane.setLayout(new BorderLayout());
			contentPane.add(contenedorLabels, BorderLayout.CENTER);
			contentPane.add(contenedorTexto, BorderLayout.EAST);

			setContentPane(contentPane);
			
			ManejadorCampoTexto manejador = new ManejadorCampoTexto(); 
			campoNombre.addActionListener(manejador);
			campoDireccion.addActionListener(manejador);
			campoFechaNac.addActionListener(manejador);
			campoEdad.addActionListener(manejador);
			campoTelefono.addActionListener(manejador);
			campoAsociado.addActionListener(manejador);
			campoFormaDePago.addActionListener(manejador);
			campoFechaDeCompra.addActionListener(manejador);
			
		setSize(700, 300);
		setVisible(true);
	}


 class ManejadorCampoTexto implements ActionListener{ 
      // procesar eventos de campo de texto 
      public void actionPerformed( ActionEvent evento ) 
      { 
         //String cadena="";
  
         
         if ( evento.getSource() == campoNombre )
            datos.set_Nombre(evento.getActionCommand());
         else if ( evento.getSource() == campoDireccion ) 
            datos.set_Direccion(evento.getActionCommand());
		 else if ( evento.getSource() == campoFechaNac ) 
            datos.set_FechaNac(Integer.parseInt(evento.getActionCommand()));
		 else if ( evento.getSource() == campoEdad)
            datos.set_Edad(Integer.parseInt(evento.getActionCommand()));
         else if ( evento.getSource() == campoTelefono )
            datos.set_Telefono(Integer.parseInt(evento.getActionCommand()));
         else if ( evento.getSource() == campoAsociado )
            datos.set_NoSocio(Integer.parseInt(evento.getActionCommand()));
         else if ( evento.getSource() == campoFormaDePago )
            datos.set_FormaDeCompra(evento.getActionCommand());
		 else if ( evento.getSource() == campoFechaDeCompra )
            datos.set_FechaDeCompra(evento.getActionCommand());
			
         System.out.println(datos.get_Nombre()); 
  
      } 
  
   }// fin del método actionPerformed 

public static void main (String args[]) {
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		Cliente nueva = new Cliente();
		
		nueva.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

class DatCliente implements Persona{
		
	/**Datos para la interfaz Persona**********************************/
	protected String Nombre;
	protected String Sexo;
	protected int Edad;
	protected String Direccion;
	protected int Telefono;
	protected int FechaNac;
	/******************************************************************/
	
	//Datos de la clase Cliente
	protected String FormaDeCompra;
	protected boolean Asociado;
	protected int NoCliente;
	protected int NoSocio;
	protected String FechaDeCompra;
		
	public DatCliente(){
		this.Nombre="";
		this.Sexo="";
		this.Edad=-1;
		this.Direccion="";
		this.Telefono=-1;
		this.FechaNac=-1;
		
		this.FormaDeCompra="";
		this.Asociado=false;
		this.NoSocio=-1;
		this.FechaDeCompra="";
	}
	
	/**Funciones heredadas de la interfaz Persona*********************/
	public String get_Sexo(){return Sexo;}
	public String get_Nombre(){return Nombre;}
	public int get_Edad(){return Edad;}
	public String get_Direccion(){return Direccion;}
	public int get_Telefono(){return Telefono;}
	public int get_FechaNac(){return FechaNac;}
	
	public void set_Sexo(String sex){this.Sexo=sex;}
	public void set_Nombre(String nom){this.Nombre=nom;}
	public void set_Edad(int edad){this.Edad=edad;}
	public void set_Direccion(String direc){this.Direccion=direc;}
	public void set_Telefono(int tel){this.Telefono=tel;}
	public void set_FechaNac(int nac){this.FechaNac=nac;}
	/****************************************************************/
	
	//Funciones del Cliente
	public String get_FormaDeCompra(){return this.FormaDeCompra;}
	public boolean get_Asociado(){return this.Asociado;}
	public int get_NoSocio(){return this.NoSocio;}
	public String get_Fecha(){return this.FechaDeCompra;}
		
	public void set_FormaDeCompra(String FormaCompra){this.FormaDeCompra=FormaCompra;}
	public void set_Asociado(boolean asociado){this.Asociado=asociado;}
	public void set_NoSocio(int socio){this.NoSocio=socio;}
	public void set_FechaDeCompra(String Fecha){this.FechaDeCompra=Fecha;}
}

	
}


