import java.io.*;

public class ListaLigadaEmpleado{
    protected DatEmpleado cabecera;
    protected DatEmpleado actual;

    public ListaLigadaEmpleado(){
	cabecera = null;
	actual = null;
    }

    public DatEmpleado get_cabecera(){
        return cabecera;
    }
    
  public void InsertarEmpleado(String Nombre, String Sexo, int Edad, String Direccion, int Telefono, String FechaNac, int Antiguedad, String Puesto, float Salario, String Horario, String IE){
    DatEmpleado temp = new DatEmpleado(Nombre, Sexo, Edad, Direccion, Telefono, FechaNac, Antiguedad, Puesto, Salario, Horario, IE);
	if(cabecera == null){
	    cabecera = temp;
	    actual = cabecera;
	}
	else{
	  if(Buscar(Nombre, Sexo, Edad, Direccion, Telefono, FechaNac, Antiguedad, Puesto, Salario, Horario, IE) == null){  
	    temp.Siguiente = cabecera;
	    cabecera = temp;
	  }
	}
    }

    public void InsertarEmpleado(DatEmpleado copia){
	DatEmpleado temp = new DatEmpleado(copia);
	if(cabecera == null){
	    cabecera = temp;
	    actual = cabecera;
	}
	else{
	    temp.Siguiente = cabecera;
	    cabecera = temp;
	}
    }

  public DatEmpleado Buscar(String Nombre, String Sexo, int Edad, String Direccion, int Telefono, String FechaNac, int Antiguedad, String Puesto, float Salario, String Horario, String IE){
      actual = cabecera;
      while(actual != null){
	if(actual.Nombre == Nombre  
	& actual.Sexo == Sexo 
	& actual.Edad == Edad 
	& actual.Direccion == Direccion 
	& actual.Telefono == Telefono 
	& actual.FechaNac == FechaNac 
	& actual.Antiguedad == Antiguedad 
	& actual.Puesto == Puesto 
	& actual.Salario == Salario 
	& actual.Horario == Horario
	& actual.IE == IE)
	  break;
	actual = actual.Siguiente;
      }
      return actual;
    }


      public DatEmpleado Buscar(DatEmpleado p){
      actual = cabecera;
      while(actual != null){
	if(actual == p)
	  break;
	actual = actual.Siguiente;
      }
      return actual;
    }



  protected DatEmpleado Buscar(String p){
      actual = cabecera;
      while(actual != null){
	System.out.println("actual IE:" + actual.get_IE());
	  if(actual.get_IE().equals(p))
	  break;
	actual = actual.Siguiente;
      }
      return actual;
    }

  public DatEmpleado BuscarAnterior(String Nombre, String Sexo,
   int Edad, String Direccion, int Telefono, String FechaNac,
   int Antiguedad, String Puesto, float Salario, String Horario, String IE){
	DatEmpleado actual;
      actual = cabecera;
      while(actual != null){
	if(actual.Siguiente.Nombre == Nombre  
	& actual.Siguiente.Sexo == Sexo 
	& actual.Siguiente.Edad == Edad 
	& actual.Siguiente.Direccion == Direccion 
	& actual.Siguiente.Telefono == Telefono 
	& actual.Siguiente.FechaNac == FechaNac 
	& actual.Siguiente.Antiguedad == Antiguedad 
	& actual.Siguiente.Puesto == Puesto 
	& actual.Siguiente.Salario == Salario
	& actual.Siguiente.Horario == Horario
	& actual.Siguiente.IE == IE)
	  break;
	actual = actual.Siguiente;
      }
      return actual;
    }
  
  public void EliminarEmpleado(String Nombre, String Sexo, int Edad, String Direccion, int Telefono, String FechaNac, int Antiguedad, String Puesto, float Salario, String Horario, String IE){
    DatEmpleado temp2, temp3;
    temp2 = Buscar(Nombre, Sexo, Edad, Direccion, Telefono, FechaNac, Antiguedad, Puesto, Salario, Horario, IE);
    if(temp2 != null){
      temp3 = BuscarAnterior(Nombre, Sexo, Edad, Direccion, Telefono, FechaNac, Antiguedad, Puesto, Salario, Horario, IE);
      temp3.Siguiente = temp2.Siguiente;
    }
      
  }

  
    public void EscribirListaArchivos(){
	DatEmpleado tmp = cabecera;
	String empleado;
	Archivos FileEmpleado = new Archivos("Empleados");
	boolean flag = false;
	try{
	while(tmp != null)
	    {
		empleado = tmp.get_Nombre() + ",";
		empleado = empleado + tmp.get_Sexo() + ",";
		empleado = empleado + tmp.get_Edad() + ",";
		empleado = empleado + tmp.get_Direccion() + ",";
		empleado = empleado + tmp.get_Telefono() + ",";
		empleado = empleado + tmp.get_FechaNac() + ",";
		empleado = empleado + tmp.get_Antiguedad() + ",";
		empleado = empleado + tmp.get_Puesto();
		empleado = empleado + tmp.get_Salario() + ",";
		empleado = empleado + tmp.get_Horario() + ",";
		empleado = empleado + tmp.get_IE() + ",";
		    if(flag==false){
		    FileEmpleado.SobreEscribir(empleado);
		    flag = true;
		    }else{
			FileEmpleado.EscribirFinal(empleado);
			}
	    }

	FileEmpleado.Cerrar();
	}catch(IOException e){
		    System.out.println("No se pudo escribir Archivos de los empleados");
		}
	    

    }

    protected void LeerArchivoEmpleado(){
	File empleado = new File("Empleados");
	Archivos FileEmpleado = new Archivos("Empleados"); 
	String LineaEmpleado;
	String [] ArrayEmpleado;
	if(empleado.exists()){
	    try{
		while((LineaEmpleado = FileEmpleado.LeerLinea()) != null) {
		    ArrayEmpleado = LineaEmpleado.split(",");
		    InsertarEmpleado(new DatEmpleado(
		    ArrayEmpleado[0],
		    ArrayEmpleado[1],
		    Integer.valueOf(ArrayEmpleado[2]),
		    ArrayEmpleado[3],
		    Integer.valueOf(ArrayEmpleado[4]),
		    ArrayEmpleado[5],
		    Integer.valueOf(ArrayEmpleado[6]),
		    ArrayEmpleado[7],
		    Float.valueOf(ArrayEmpleado[8]),
		    ArrayEmpleado[9],
		    ArrayEmpleado[10]));
	    }
	    FileEmpleado.Cerrar();
	    }catch(IOException e){
		System.out.println("No se pudo leer base de datos de Empleados");	
	    }   

	}
	
    }
}
    
