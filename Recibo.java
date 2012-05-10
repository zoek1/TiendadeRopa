import javax.swing.*;
public class Recibo extends Venta{
    protected float Total;
    protected float Subtotal;
    protected float Impuestos;
    
    public Recibo(){
	super();
	this.Total = Total;
	this.Subtotal = Subtotal;
	this.Impuestos = Impuestos;
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

    protected void set_Total(float Total){
	this.Total =  Total;
    }
    
    protected void set_Subtotal(float Subtotal){
	this.Subtotal =  Subtotal;
    }

    protected void set_Impuestos(float Impuestos){
	this.Impuestos =  Impuestos;
    }
    
    protected void Impuestos(){
	float IVA = 0.16f;
	this.Impuestos = this.Subtotal / IVA;
		
    }
    
    public float Suma_Total(){
	float suma=0;
	temp = Productos.get_cabecera();
	while(temp != null){
	    suma = suma + temp.get_Precio();
	    temp= temp.Siguiente;
	}
	this.Subtotal = suma;
	this.Total = this.Subtotal + this.Impuestos;
return Total;
    }


}
