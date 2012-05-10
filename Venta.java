public abstract class Venta{
    protected ListaLigadaProducto Productos;
    protected Producto temp;
    protected Reloj tiempo;    
    protected String Hora;
    protected String Direccion_Tienda;
    
    public Venta(){
	tiempo = new Reloj();
	Productos = new ListaLigadaProducto();
	Hora = " ";
	Direccion_Tienda = "4 poniente #2334 ";
    }
  
  protected void EliminarProducto(Producto pro){
    Productos.EliminarProducto(pro.get_Marca(),pro.get_Talla(),pro.get_Modelo(),pro.get_Color(),pro.get_TipoTela(),pro.get_Precio(),pro.get_Descuento(),pro.getid());
  }
  
  public  String get_Hora(String formato){
    return tiempo.getTiempo(formato);
  }
  
    
    public String get_Direccion_Tienda(){
	return Direccion_Tienda;
    }
       
    protected void set_Direccion_Tienda(String DT){
	this.Direccion_Tienda = DT;
    }
 
    public void Agregar_Producto(Producto p){
	Productos.InsertarProducto(p);
    }
  
    public abstract void Suma_Total();
 
	
}