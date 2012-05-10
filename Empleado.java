import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;

public class Empleado extends JFrame{
	
	///Labels a ocupar
	private JLabel labelSexo, labelNombre, labelEdad, labelDireccion;
	private JLabel labelTelefono, labelFechaNac;
	private JLabel labelAntiguedad, labelPuesto, labelSalario, labelHorario;
	
	///Cajas de texto
	private JTextField campoNombre, campoEdad, campoDireccion;
	private JTextField campoTelefono, campoFechaNac;
	
	private JTextField campoPuesto, campoSalario, campoHorario, campoAntiguedad;
	private JCheckBox Masculino, Femenino;
	
	DatEmpleado datos=new DatEmpleado();
	
	public Empleado(){
		
			super("Formulario de nuevo empleado");
						
			//Constructores de las cajas de texto
			
			JPanel contenedorLabels = new JPanel();
			contenedorLabels.setLayout(new GridLayout(0,1));
			
			labelNombre= new JLabel("Nombre:");
			labelDireccion= new JLabel("Direccion:");
			labelFechaNac= new JLabel("Fecha de nacimiento:");
			labelEdad= new JLabel("Edad");
			labelTelefono=new JLabel("Telefono:");
			
			labelAntiguedad= new JLabel("Antiguedad:");			
			labelHorario= new JLabel("Horario:");
			labelPuesto= new JLabel("Puesto:");
			labelSalario= new JLabel("Salario:");
			
			
			contenedorLabels.add(labelNombre);
			contenedorLabels.add(labelDireccion);
			contenedorLabels.add(labelFechaNac);
			contenedorLabels.add(labelEdad);
			contenedorLabels.add(labelTelefono);
						
			contenedorLabels.add(labelAntiguedad);
			contenedorLabels.add(labelHorario);
			contenedorLabels.add(labelPuesto);
			contenedorLabels.add(labelSalario);
			
		
		
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
			
			campoAntiguedad=new JTextField(2);
			campoHorario=new JTextField(40);
			campoPuesto=new JTextField(15);
			campoSalario=new JTextField(7);
			
			
			contenedorTexto.add(campoNombre);
			contenedorTexto.add(campoDireccion);
			contenedorTexto.add(campoFechaNac);
			contenedorTexto.add(campoEdad);
			contenedorTexto.add(campoTelefono);
			
			contenedorTexto.add(campoAntiguedad);
			contenedorTexto.add(campoHorario);
			contenedorTexto.add(campoPuesto);
			contenedorTexto.add(campoSalario);
			
			
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
			campoAntiguedad.addActionListener(manejador);
			campoHorario.addActionListener(manejador);
			campoPuesto.addActionListener(manejador);
			campoSalario.addActionListener(manejador);
			
			
		setSize(700, 300);
		setVisible(true);
	}


 class ManejadorCampoTexto implements ActionListener{ 
      // procesar eventos de campo de texto 
      public void actionPerformed( ActionEvent evento ) 
      { 
         String cadena="";
  
         
         if ( evento.getSource() == campoNombre )
            /*datos.set_Nombre*/cadena=evento.getActionCommand();
         else if ( evento.getSource() == campoAntiguedad ) 
            datos.set_Antiguedad(Integer.parseInt(evento.getActionCommand()));     
         else if ( evento.getSource() == campoDireccion ) 
            datos.set_Direccion(evento.getActionCommand());
		 else if ( evento.getSource() == campoEdad)
            datos.set_Edad(Integer.parseInt(evento.getActionCommand()));
         else if ( evento.getSource() == campoFechaNac ) 
            datos.set_FechaNac(Integer.parseInt(evento.getActionCommand()));
         else if ( evento.getSource() == campoHorario ) 
            datos.set_Horario(evento.getActionCommand());
         else if ( evento.getSource() == campoPuesto ) 
            datos.set_Puesto(evento.getActionCommand());
         else if ( evento.getSource() == campoSalario ) 
            datos.set_Salario(Integer.parseInt(evento.getActionCommand()));
         else if ( evento.getSource() == campoTelefono );
            datos.set_Telefono(Integer.parseInt(evento.getActionCommand()));
         
         JOptionPane.showMessageDialog( null, cadena,"Resultados",JOptionPane.CANCEL_OPTION);  
  
      } 
  
   }// fin del método actionPerformed 

public static void main (String args[]) {
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		Empleado nueva = new Empleado();
		
		nueva.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

class DatEmpleado implements Persona{
		
	/**Datos para la interfaz Persona**********************************/
	protected String Nombre;
	protected String Sexo;
	protected int Edad;
	protected String Direccion;
	protected int Telefono;
	protected int FechaNac;
	/******************************************************************/
	
	//Datos de la clase Empleado
	protected int Antiguedad;
	protected String Puesto;
	protected float Salario;
	protected String Horario;
	
	DatEmpleado(){
		this.Nombre="";
		this.Sexo="";
		this.Edad=-1;
		this.Direccion="";
		this.Telefono=-1;
		this.FechaNac=-1;
		
		this.Antiguedad=-1;
		this.Puesto="";
		this.Salario=-1;
		this.Horario="";
	}
	
	/**Funciones heredadas de la interfaz Persona**********************/
	public String get_Sexo(){return this.Sexo;}
	public String get_Nombre(){return this.Nombre;}
	public int get_Edad(){return this.Edad;}
	public String get_Direccion(){return this.Direccion;}
	public int get_Telefono(){return this.Telefono;}
	public int get_FechaNac(){return this.FechaNac;}
	
	public void set_Sexo(String sex){this.Sexo=sex;}
	public void set_Nombre(String nom){this.Nombre=nom;}
	public void set_Edad(int edad){this.Edad=edad;}
	public void set_Direccion(String direc){this.Direccion=direc;}
	public void set_Telefono(int tel){this.Telefono=tel;}
	public void set_FechaNac(int nac){this.FechaNac=nac;}
	/******************************************************************/
	
	//Funciones de la clase
	public int get_Antiguedad(){return this.Antiguedad;}
	public String get_Puesto(){return this.Puesto;}
	public float get_Salario(){return this.Salario;}
	public String get_Horario(){return this.Horario;}
		
	public void set_Antiguedad(int antiguedad){this.Antiguedad=antiguedad;}
	public void set_Puesto(String puesto){this.Puesto=puesto;}
	public void set_Salario(float salario){this.Salario=salario;}
	public void set_Horario(String horario){this.Horario=horario;}

}

	
}


