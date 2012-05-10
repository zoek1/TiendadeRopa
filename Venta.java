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
	Direccion_Tienda = " ";
    }
    
    public String get_Hora(){
	Hora = tiempo.getTiempo();
	return Hora;	
    }
    
    public String get_Direccion_Tienda(){
	return Direccion_Tienda;
    }

    public ListaLigadaProducto Detalle_Producto(){
	return Productos;
    }
       
    protected void set_Direccion_Tienda(String DT){
	this.Direccion_Tienda = DT;
    }
 
    public void Agregar_Producto(Producto p){
	Productos.InsertarProducto(p);
    }
    public abstract void Suma_Total();
 
	
}