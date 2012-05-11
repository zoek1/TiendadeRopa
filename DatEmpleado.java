public class DatEmpleado implements Persona{
		
	/**Datos para la interfaz Persona**********************************/
	protected String Nombre;
	protected String Sexo;
	protected int Edad;
	protected String Direccion;
	protected int Telefono;
	protected String FechaNac;
	/******************************************************************/
	
	//Datos de la clase Empleado
	protected int Antiguedad;
	protected String Puesto;
	protected float Salario;
	protected String Horario;
	protected String IE;
	protected DatEmpleado Siguiente;
	
	DatEmpleado(String Nombre, String Sexo, int Edad, String Direccion, int Telefono, String FechaNac, int Antiguedad, String Puesto, float Salario, String Horario, String IE){
		this.Nombre=Nombre;
		this.Sexo=Sexo;
		this.Edad=Edad;
		this.Direccion=Direccion;
		this.Telefono=Telefono;
		this.FechaNac=FechaNac;
		
		this.Antiguedad=Antiguedad;
		this.Puesto=Puesto;
		this.Salario=Salario;
		this.Horario=Horario;
		this.IE=IE;
	}
	
	public DatEmpleado(DatEmpleado copia){
		this.Nombre=copia.get_Nombre();
		this.Sexo=copia.get_Sexo();
		this.Edad=copia.get_Edad();
		this.Direccion=copia.get_Direccion();
		this.Telefono=copia.get_Telefono();
		this.FechaNac=copia.get_FechaNac();
		
		this.Antiguedad=copia.get_Antiguedad();
		this.Puesto=copia.get_Puesto();
		this.Salario=copia.get_Salario();
		this.Horario=copia.get_Horario();
		this.IE=copia.get_IE();
	}

	
	/**Funciones heredadas de la interfaz Persona**********************/
	public String get_Sexo(){return this.Sexo;}
	public String get_Nombre(){return this.Nombre;}
	public int get_Edad(){return this.Edad;}
	public String get_Direccion(){return this.Direccion;}
	public int get_Telefono(){return this.Telefono;}
	public String get_FechaNac(){return this.FechaNac;}
	
	
	public void set_Sexo(String Sexo){this.Sexo=Sexo;}
	public void set_Nombre(String Nombre){this.Nombre=Nombre;}
	public void set_Edad(int edad){this.Edad=edad;}
	public void set_Direccion(String direc){this.Direccion=direc;}
	public void set_Telefono(int tel){this.Telefono=tel;}
	public void set_FechaNac(String nac){this.FechaNac=nac;}
	
	/******************************************************************/
	
	//Funciones de la clase
	public int get_Antiguedad(){return this.Antiguedad;}
	public String get_Puesto(){return this.Puesto;}
	public float get_Salario(){return this.Salario;}
	public String get_Horario(){return this.Horario;}
	public String get_IE(){return this.IE;}
		
	public void set_Antiguedad(int Antiguedad){this.Antiguedad=Antiguedad;}
	public void set_Puesto(String puesto){this.Puesto=puesto;}
	public void set_Salario(float salario){this.Salario=salario;}
	public void set_Horario(String horario){this.Horario=horario;}
	public void set_IE(String IE){this.IE=IE;}
}

