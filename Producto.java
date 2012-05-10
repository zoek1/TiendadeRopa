
public class Producto{
  protected String id;
   protected String Marca;
    protected String Talla;
    protected String Modelo;
    protected String Color;
    protected String TipoTela;
    protected float Precio;
    protected int Descuento;
    protected Producto Siguiente;
    
  public Producto(String Marca, String Talla, String Modelo, String Color, String TipoTela, float Precio, int Descuento,String id){
	this.Marca = Marca;
	this.Talla = Talla;
	this.Modelo = Modelo;
	this.Color = Color;
	this.TipoTela = TipoTela;
	this.Precio = Precio;
	this.Descuento = Descuento;
	this.id = id;
    }

    public Producto(Producto copia){
	this.Marca = copia.get_Marca();
	this.Talla = copia.get_Talla();
	this.Modelo = copia.get_Modelo();
	this.Color = copia.get_Color();
	this.TipoTela = copia.get_TipoTela();
	this.Precio = copia.get_Precio();
	this.Descuento = copia.get_Descuento();
	this.id = copia.getid();
    }
    
    public String get_Marca(){
	return Marca;
    }

    public String get_Talla(){
	return Talla;
    }

    public String get_Modelo(){
	return Modelo;
    }

    public String get_Color(){
	return Color;
    }

    public String get_TipoTela(){
	return TipoTela;
    }

    public float get_Precio(){
	return Precio;
    }

    public int get_Descuento(){
	return Descuento;
    }
    public String getid(){
	return id;
    }


    public void setid(String id){
      this.id = id;
    }
  
    protected void set_Marca(String Marca){
	this.Marca =  Marca;
    }

    protected void set_Talla(String Talla){
	this.Talla = Talla;
    }

    protected void set_Modelo(String Modelo){
	this.Modelo = Modelo;
    }

    protected void set_Color(String Color){
	this.Color = Color;
    }

    protected void set_TipoTela(String TipoTela){
	this.TipoTela = TipoTela;
    }

    protected void set_Precio(float Precio){
	this.Precio = Precio;
    }

    protected void set_Descuento(int Descuento){
	this.Descuento = Descuento;
    }
}