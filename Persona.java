import java.util.*;

public interface Persona {
		
	String get_Sexo();
	String get_Nombre();
	int get_Edad();
	String get_Direccion();
	int get_Telefono();
	int get_FechaNac();
	
	void set_Sexo(String sex);
	void set_Nombre(String nom);
	void set_Edad(int edad);
	void set_Direccion(String direc);
	void set_Telefono(int tel);
	void set_FechaNac(int nac);
	
}

