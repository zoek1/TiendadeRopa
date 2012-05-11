import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Empleado extends JFrame implements ActionListener{
  private JButton Boton1, Boton2;
  
  	///Labels a ocupar
	private JLabel labelSexo, labelNombre, labelEdad, labelDireccion;
	private JLabel labelTelefono, labelFechaNac;
	private JLabel labelAntiguedad, labelPuesto, labelSalario, labelHorario;
	
	///Cajas de texto
	private JTextField campoSexo, campoNombre, campoEdad, campoDireccion;
	private JTextField campoTelefono, campoFechaNac;
	
	private JTextField campoAntiguedad,campoPuesto, campoSalario, campoHorario;
    
    DatEmpleado Objeto;
    
    ListaLigadaEmpleado ListaProducto;
    
    private String ProductoObjeto;
    
    public ProductoGui(){
	ListaProducto = new ListaLigadaProducto();
    }
  
  protected void setListaProducto(ListaLigadaProducto p){
    ListaProducto = p;
  }


  protected Producto BuscarporIdentificador(String id){
    return ListaProducto.Buscar(id);
  }


  protected void BusquedadeProductos()
    {

   JLabel campoTexto1, campoTexto2, campoTexto3, campoTexto4, campoTexto5, campoTexto6, campoTexto7,campoTexto8;
     JButton Boton1, Boton2;
   JLabel campo1, campo2, campo3, campo4, campo5, campo6, campo7,campo8;
   String tmpl = JOptionPane.showInputDialog(null,"introduce el identificadordel producto");
   if(tmpl.length()>4){
   Producto p = BuscarporIdentificador(tmpl);
     
   if (p==null){
     JOptionPane.showMessageDialog(null,"identidicador invalido");
     return; }
	setLayout(new GridLayout(9,2));
	campo1 = new JLabel ("Marca:");
	add(campo1);
	
	campoTexto1 = new JLabel(p.get_Marca());
	add(campoTexto1);

	campo2 = new JLabel ("Talla:");
	add(campo2);
	
	campoTexto2 = new JLabel(p.get_Talla());
	add(campoTexto2);

	campo3 = new JLabel ("Modelo:");
	add(campo3);
	
	campoTexto3 = new JLabel(p.get_Modelo());
	add(campoTexto3);

	campo4 = new JLabel ("Color:");
	add(campo4);
	
	campoTexto4 = new JLabel(p.get_Color());
	add(campoTexto4);

	campo5 = new JLabel ("Tipo de Tela:");
	add(campo5);
	
	campoTexto5 = new JLabel(p.get_TipoTela());
	add(campoTexto5);
	
	campo6 = new JLabel("Precio:");
	add(campo6);

	String flot = Float.toString(p.get_Precio()); 
	campoTexto6 = new JLabel(flot);
	add(campoTexto6);

	campo7 = new JLabel ("Descuento:");
	add(campo7);

	String tmp = Integer.toString(p.get_Descuento());
	campoTexto7 = new JLabel(tmp);
	add(campoTexto7);


	campo8 = new JLabel ("Introduce Identificador:");
	add(campo8);
	
	campoTexto8 = new JLabel(p.getid());
	add(campoTexto8);

	setSize(400,300);
	setVisible(true);
   }else{
     JOptionPane.showMessageDialog(null,"LA longitud minima del identificador\n es de 5 caracteres");
   }

    }


  protected void EliminarProducto()
    {
      String Eliminar;

      Eliminar = JOptionPane.showInputDialog(null,"Introduce el identificador\n del producto a eliminar");

      if (Eliminar!=null && Eliminar.length()>=4){
	Producto pro = BuscarporIdentificador(Eliminar);
	if(pro!=null){
	  ListaProducto.EliminarProducto(pro.get_Marca(),pro.get_Talla(),pro.get_Modelo(),pro.get_Color(),pro.get_TipoTela(),pro.get_Precio(),pro.get_Descuento(),pro.getid());
	  ListaProducto.EscribirListaArchivos();
	}else{
	  JOptionPane.showMessageDialog(null,"Identificador no valido");
	}
      }else{
	JOptionPane.showMessageDialog(null,"El id debe contener al menos 4 coracteres");
      }
    }
 

  protected void NuevoProducto()
    {

	setLayout(new GridLayout(9,2));
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


	campo8 = new JLabel ("Introduce Identificador:");
	add(campo8);
	
	campoTexto8 = new JTextField();
	add(campoTexto8);

	Boton1 = new JButton("Aceptar");
	add(Boton1);
	Boton1.addActionListener(this);

	Boton2 = new JButton("Cancelar");
	add(Boton2);
	Boton2.addActionListener(this);

	setSize(400,300);
	setVisible(true);
	

    }

    private String Aceptar(){
	String Cadena;
        Cadena = "";
	// Anterior bug
	Cadena = campoTexto1.getText();
	Cadena = Cadena + "," +campoTexto2.getText();
	Cadena = Cadena + "," +campoTexto3.getText();
	Cadena = Cadena + "," +campoTexto4.getText();
	Cadena = Cadena + "," +campoTexto5.getText();
	Cadena = Cadena + "," +campoTexto6.getText();
	Cadena = Cadena + "," +campoTexto7.getText();
	Cadena = Cadena + "," +campoTexto8.getText();
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

  protected void EscribirArchivolista() {
	String [] ArrayProducto;
    ArrayProducto = ProductoObjeto.split(",");
      System.out.println("Formato: " + ProductoObjeto);
    try{
      Objeto = new Producto(ArrayProducto[0],ArrayProducto[1],ArrayProducto[2],ArrayProducto[3],ArrayProducto[4],Float.valueOf(ArrayProducto[5]),Integer.valueOf(ArrayProducto[6]),ArrayProducto[7]);}
    catch(NumberFormatException ex){
      System.out.println("Error al leer numero en cadenas");
    }
    try{ 
	if(ListaProducto.Buscar(Objeto)== null){
	  ListaProducto.InsertarProducto(Objeto);


	  
	  Archivos p = new Archivos("Productos");
	  p.EscribirFinal(ArrayProducto[0] + "," + ArrayProducto[1] + "," +ArrayProducto[2] + "," + ArrayProducto[3] + "," + ArrayProducto[4] + "," + ArrayProducto[5] + "," + ArrayProducto[6] + "," + ArrayProducto[7]);}} 
	catch(IOException e){
	  System.out.println("No se puedo escribir a producto");
	}catch(NullPointerException ne){
      System.out.println("Error puntero nulo");
    }
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
	String cadena8= campoTexto8.getText();
       	       
	if ("Aceptar".equals(cmd)){
	    System.out.println("Boton Aceptar presionado");
			
	    if(( cadena1.length() > 3 ) && (cadena2.length() >  3) &&
	       (cadena3.length() >  3) && (cadena4.length() >  3) &&
	       (cadena5.length() >  3) && (cadena6.length() >= 1)  &&
	       (cadena7.length() >= 1) && (cadena8.length() > 4)){
		
		ProductoObjeto = Aceptar();
		System.out.println("Campos completos");
		System.out.println("1: " + campoTexto1.getText()
				   + "2: " + campoTexto2.getText()
				   + "3: " + campoTexto3.getText()
				   + "4: " + campoTexto4.getText()
				   + "5: " + campoTexto5.getText()
				   + "6: " + campoTexto6.getText()
				   + "7: " + campoTexto7.getText()
				   + "8: " + campoTexto8.getText());
		EscribirArchivolista();

	    }
	    else{
			    
		System.out.println("1: " + campoTexto1.getText()
				    + "2: " + campoTexto2.getText()
				    + "3: " + campoTexto3.getText()
				    + "4: " + campoTexto4.getText()
				    + "5: " + campoTexto5.getText()
				    + "6: " + campoTexto6.getText()
				    + "7: " + campoTexto7.getText()
				    + "8: " + campoTexto8.getText());
		
		System.out.println("Campos incompletos");
		JOptionPane.showMessageDialog(null,"Todos los campos deben \n  ser mayores a 4 digitos execepto los numericos");
			   
	    }
	}else if("Cancelar".equals(cmd)){

	  
	}
	else{
			    
		System.out.println("Boton Cancelar presionado : " + cmd);
		ProductoObjeto = Cancelar();
			    
	    }


		    
	System.out.println("Manejador de eventos");
    }
    
    


