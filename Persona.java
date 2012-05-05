public class Persona {
	
	protected String Sexo;
	protected String Nombre;
	protected int Edad;
	protected String Direccion;
	protected int Telefono;
	protected int FechaNac;
	
	public Persona(String Sex, String Nom, int edad, String Direcc, int Tel, int nac){
	
			this.Sexo=Sex;
			this.Nombre=Nom;
			this.Edad=edad;
			this.Direccion=Direcc;
			this.Telefono=Tel;
			this.FechaNac=nac;
	}
	
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
	
}

