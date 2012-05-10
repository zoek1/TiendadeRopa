import java.io.*;

public class ListaLigadaProducto{
    protected Producto cabecera;
    protected Producto actual;

    public ListaLigadaProducto(){
	cabecera = null;
	actual = null;
    }

    public Producto get_cabecera(){
        return cabecera;
    }
    
    public void InsertarProducto(String Marca, String Talla, String Modelo, String Color, String TipoTela, float Precio, int Descuento){
	Producto temp = new Producto(Marca, Talla, Modelo, Color, TipoTela, Precio, Descuento);
	if(cabecera == null){
	    cabecera = temp;
	    actual = cabecera;
	}
	else{
	  if(Buscar(Marca, Talla, Modelo, Color, TipoTela, Precio, Descuento) == null){  
	    temp.Siguiente = cabecera;
	    cabecera = temp;
	  }
	}
    }

    public void InsertarProducto(Producto copia){
	Producto temp = new Producto(copia);
	if(cabecera == null){
	    cabecera = temp;
	    actual = cabecera;
	}
	else{
	    temp.Siguiente = cabecera;
	    cabecera = temp;
	}
    }

    public Producto Buscar(String Marca, String Talla, String Modelo, String Color, String TipoTela, float Precio, int Descuento){
      actual = cabecera;
      while(actual != null){
	if(actual.Marca == Marca  & actual.Talla == Talla & actual.Modelo == Modelo & actual.Color == Color & actual.TipoTela == TipoTela & actual.Precio == Precio & actual.Descuento == Descuento)
	  break;
	actual = actual.Siguiente;
      }
      return actual;
    }


      public Producto Buscar(Producto p){
      actual = cabecera;
      while(actual != null){
	if(actual == p)
	  break;
	actual = actual.Siguiente;
      }
      return actual;
    }
  
      public Producto BuscarAnterior(String Marca, String Talla, String Modelo, String Color, String TipoTela, float Precio, int Descuento){
	Producto actual;
      actual = cabecera;
      while(actual != null){
	if(actual.Siguiente.Marca == Marca  & actual.Siguiente.Talla == Talla & actual.Siguiente.Modelo == Modelo & actual.Siguiente.Color == Color & actual.Siguiente.TipoTela == TipoTela & actual.Siguiente.Precio == Precio & actual.Siguiente.Descuento == Descuento)
	  break;
	actual = actual.Siguiente;
      }
      return actual;
    }
  
  public void EliminarProducto(String Marca, String Talla, String Modelo, String Color, String TipoTela, float Precio, int Descuento){
    Producto temp2, temp3;
    temp2 = Buscar(Marca, Talla, Modelo, Color, TipoTela, Precio, Descuento);
    if(temp2 != null){
      temp3 = BuscarAnterior(Marca, Talla, Modelo, Color, TipoTela, Precio, Descuento);
      temp3.Siguiente = temp2.Siguiente;
    }
      
  }

  
    public void EscribirListaArchivos(){
	Producto tmp = cabecera;
	String producto;
	Archivos FileProduto = new Archivos("Productos");
	boolean flag = false;
	try{
	while(tmp != null)
	    {
		producto = tmp.get_Marca() + ",";
		producto = producto + tmp.get_Talla() + ",";
		producto = producto + tmp.get_Modelo() + ",";
		producto = producto + tmp.get_Color() + ",";
		producto = producto + tmp.get_TipoTela() + ",";
		producto = producto + tmp.get_Precio() + ",";
		producto = producto + tmp.get_Precio() + ",";
		producto = producto + tmp.get_Descuento() + ",";
		
		    if(flag==false){
		    FileProduto.SobreEscribir(producto);
		    flag = true;
		    }else{
			FileProduto.EscribirFinal(producto);
			}
	    }

	FileProduto.Cerrar();
	}catch(IOException e){
		    System.out.println("No se pudo escribir Archivos de producto");
		}
	    

    }

    protected void LeerArchivoProducto(){
	File producto = new File("Productos");
	Archivos FileProducto = new Archivos("Productos"); 
	String LineaProducto;
	String [] ArrayProducto;
	if(producto.exists()){
	    try{
		while((LineaProducto = FileProducto.LeerLinea()) != null) {
		    ArrayProducto = LineaProducto.split(",");
		    InsertarProducto(new Producto(ArrayProducto[0],ArrayProducto[1],ArrayProducto[2],ArrayProducto[3],ArrayProducto[4],Float.valueOf(ArrayProducto[5]),Integer.valueOf(ArrayProducto[6])));
	    }
	    FileProducto.Cerrar();
	    }catch(IOException e){
		System.out.println("No se pudo leer base de datos Productos");	
	    }   

	}
	
    }
}
    
