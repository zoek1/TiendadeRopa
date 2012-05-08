public class ListaLigadaProducto{
    protected Producto cabecera;
    protected Producto actual;

    public ListaLigadaProducto(){
	cabecera = null;
	actual = null;
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

  
}
    
