import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ProductoGui extends JFrame implements ActionListener{
    private JTextField campoTexto1, campoTexto2, campoTexto3, campoTexto4, campoTexto5, campoTexto6, campoTexto7;
    private JButton Boton1, Boton2;
    private JLabel campo1, campo2, campo3, campo4, campo5, campo6, campo7;
    Producto Objeto;
    
    ListaLigadaProducto ListaProducto;
    private String ProductoObjeto;
    
    public ProductoGui(){
	ListaProducto = new ListaLigadaProducto();
    }

    protected void NuevoProducto()
    {
	String [] ArrayProducto;
	setLayout(new GridLayout(8,2));
	campo1 = new JLabel ("Introduce Marca:");
	add(campo1);
	
	campoTexto1 = new JTextField();
	add(campoTexto1);

	campo2 = new JLabel ("Introduce Talla:");
	add(campo2);
	
	campoTexto2 = new JTextField();
	add(campoTexto2);

	campo3 = new JLabel ("Introduce Modelo:");
	add(campo3);
	
	campoTexto3 = new JTextField();
	add(campoTexto3);

	campo4 = new JLabel ("Introduce Color:");
	add(campo4);
	
	campoTexto4 = new JTextField();
	add(campoTexto4);

	campo5 = new JLabel ("Introduce Tipo de Tela:");
	add(campo5);
	
	campoTexto5 = new JTextField();
	add(campoTexto5);
	
	campo6 = new JLabel ("Introduce Precio:");
	add(campo6);
	
	campoTexto6 = new JTextField();
	add(campoTexto6);

	campo7 = new JLabel ("Introduce Descuento:");
	add(campo7);
	
	campoTexto7 = new JTextField();
	add(campoTexto7);

	Boton1 = new JButton("Aceptar");
	add(Boton1);
	Boton1.addActionListener(this);

	Boton2 = new JButton("Cancelar");
	add(Boton2);
	Boton2.addActionListener(this);

	setSize(400,300);
	setVisible(true);
	ArrayProducto = ProductoObjeto.split(",");
	
	Objeto = new Producto(ArrayProducto[0],ArrayProducto[1],ArrayProducto[2],ArrayProducto[3],ArrayProducto[4],Float.valueOf(ArrayProducto[5]),Integer.valueOf(ArrayProducto[6]));

	ListaProducto.InsertarProducto(Objeto);
    }

    private String Aceptar(){
	String Cadena;
        Cadena = "";
	Cadena = Cadena + "," +campoTexto1.getText();
	Cadena = Cadena + "," +campoTexto2.getText();
	Cadena = Cadena + "," +campoTexto3.getText();
	Cadena = Cadena + "," +campoTexto4.getText();
	Cadena = Cadena + "," +campoTexto5.getText();
	Cadena = Cadena + "," +campoTexto6.getText();
	Cadena = Cadena + "," +campoTexto7.getText();
	setVisible(false);
	dispose();
	return Cadena;
    }

    private String Cancelar(){
	String Cadena = "";
	setVisible(false);
	dispose();
	return Cadena;
    }

    public String getCadena(){
	return ProductoObjeto;
    }


    public void actionPerformed(ActionEvent evento){
	String cmd = evento.getActionCommand();
	System.out.println("Campos completos");
	String cadena1= campoTexto1.getText();
	String cadena2= campoTexto2.getText();
	String cadena3= campoTexto3.getText();
	String cadena4= campoTexto4.getText();
	String cadena5= campoTexto5.getText();
	String cadena6= campoTexto6.getText();
	String cadena7= campoTexto7.getText();
       	       
	if ("Aceptar".equals(cmd)){
	    System.out.println("Boton Aceptar presionado");
			
	    if(( cadena1.length() > 3 ) && (cadena2.length() >  3) &&
	       (cadena3.length() >  3) && (cadena4.length() >  3) &&
	       (cadena5.length() >  3) && (cadena6.length() > 3)  &&
	       (cadena7.length() > 3)){
		
		ProductoObjeto = Aceptar();
		System.out.println("Campos completos");
		System.out.println("1: " + campoTexto1.getText()
				   + "2: " + campoTexto2.getText()
				   + "3: " + campoTexto3.getText()
				   + "4: " + campoTexto4.getText()
				   + "5: " + campoTexto5.getText()
				   + "6: " + campoTexto6.getText()
				   + "7: " + campoTexto7.getText());
	    }
	    else{
			    
		System.out.println("1: " + campoTexto1.getText()
				    + "2: " + campoTexto2.getText()
				    + "3: " + campoTexto3.getText()
				    + "4: " + campoTexto4.getText()
				    + "5: " + campoTexto5.getText()
				    + "6: " + campoTexto6.getText()
				    + "7: " + campoTexto7.getText());
		
		System.out.println("Campos incompletos");
		JOptionPane.showMessageDialog(null,"Todos los campos deben estar llenos");
			   
	    }
	}else
	    {
			    
		System.out.println("Boton Cancelar presionado : " + cmd);
		ProductoObjeto = Cancelar();
			    
	    }
		    
	System.out.println("Manejador de eventos");
    }
    
    public static void main(String []args){
	ProductoGui p = new ProductoGui();
	p.NuevoProducto();
	System.out.println(p.getCadena());
    }
    
}
