
public class Venta{
    protected String TipoRecibo;
    protected float Total;
    protected float Subtotal;
    protected float Impuestos;

    public Venta(String TipoRecibo, float Total, float Subtotal, float Impuestos){
	this.TipoRecibo = TipoRecibo;	this.Total = Total;
	this.Subtotal = Subtotal;
	this.Impuestos = Impuestos;
    }

    public String get_TipoRecibo(){
	return TipoRecibo;
    }

    public float get_Total(){
	return Total;
    }

    public float get_Subtotal(){
	return Subtotal;
    }

    public float get_Impuestos(){
	return Impuestos;
    }

    public void set_TipoRecibo(String TipoRecibo){
	this.TipoRecibo = TipoRecibo;
    }

    public void set_Total(float Total){
	this.Total =  Total;
    }
    
    public void set_Subtotal(float Subtotal){
	this.Subtotal =  Subtotal;
    }

    public void set_Impuestos(float Impuestos){
	this.Impuestos =  Impuestos;
    }    

	
}