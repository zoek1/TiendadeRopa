import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class GuiEmpleado extends JFrame implements ActionListener{

  private JTextField campoTexto1, campoTexto2, campoTexto3, campoTexto4, campoTexto5, 
  campoTexto6, campoTexto7,campoTexto8, campoTexto9, campoTexto10, campoTexto11;  
  private JButton Boton1, Boton2;
  private JLabel campo1, campo2, campo3, campo4, campo5, campo6, campo7,campo8, campo9, campo10, campo11;  
  
  DatEmpleado Objeto;  
  ListaLigadaEmpleado ListaEmpleado;
  private String EmpleadoObjeto;
    
  public GuiEmpleado(){
	ListaEmpleado = new ListaLigadaEmpleado();
  }
  
  protected void setListaEmpleado(ListaLigadaEmpleado p){
    ListaEmpleado = p;
  }

  protected DatEmpleado BuscarporIdentificador(String IE){
    return ListaEmpleado.Buscar(IE);
  }

  protected void BusquedadeEmpleados(){

	JLabel campoTexto1, campoTexto2, campoTexto3, campoTexto4, campoTexto5, 
		   campoTexto6, campoTexto7,campoTexto8, campoTexto9, campoTexto10, campoTexto11;
	JButton Boton1, Boton2;
	JLabel campo1, campo2, campo3, campo4, campo5, campo6, campo7,campo8, campo9, campo10, campo11;
  
	String tmpl = JOptionPane.showInputDialog(null,"introduce el identificadordel Empleado");
	if(tmpl.length()>4){
		DatEmpleado p = BuscarporIdentificador(tmpl);
		String tmp;  
  
		if (p==null){
			JOptionPane.showMessageDialog(null,"identidicador invalido");
		return; 
	}
	
	setLayout(new GridLayout(12,2));
	campo1 = new JLabel ("Nombre:");
	add(campo1);
	campoTexto1 = new JLabel(p.get_Nombre());
	add(campoTexto1);

	campo2 = new JLabel ("Sexo:");
	add(campo2);
	campoTexto2 = new JLabel(p.get_Sexo());
	add(campoTexto2);

	campo3 = new JLabel ("Edad:");
	add(campo3);
	tmp = Integer.toString(p.get_Edad());
	campoTexto3 = new JLabel(tmp);
	add(campoTexto3);

	campo4 = new JLabel ("Direccion:");
	add(campo4);
	campoTexto4 = new JLabel(p.get_Direccion());
	add(campoTexto4);

	campo5 = new JLabel ("Telefono:");
	add(campo5);
	tmp = Integer.toString(p.get_Telefono());
	campoTexto5 = new JLabel(tmp);
	add(campoTexto5);
	
	campo6 = new JLabel("Fecha de nacimiento:");
	add(campo6);
	campoTexto6 = new JLabel(p.get_FechaNac());
	add(campoTexto6);

	campo7 = new JLabel ("Antiguedad:");
	add(campo7);
	tmp = Integer.toString(p.get_Antiguedad());
	campoTexto7 = new JLabel(tmp);
	add(campoTexto7);

	campo8 = new JLabel("Puesto:");
	add(campo8);
	campoTexto8 = new JLabel(p.get_Puesto());
	add(campoTexto8);

	campo9 = new JLabel("Salario:");
	add(campo9);
	String flot = Float.toString(p.get_Salario()); 
	campoTexto9 = new JLabel(tmp);
	add(campoTexto9);
	
	campo10 = new JLabel ("Horario:");
	add(campo10);
	campoTexto10 = new JLabel(p.get_Horario());
	add(campoTexto10);
	
	campo11 = new JLabel ("Introduce Identificador:");
	add(campo11);
	campoTexto11 = new JLabel(p.get_IE());
	add(campoTexto11);

	setSize(600,300);
	setVisible(true);
	
   }else{
     JOptionPane.showMessageDialog(null,"LA longitud minima del identificador\n es de 5 caracteres");
   }

 }

  protected void EliminarEmpleado(){
      String Eliminar;

      Eliminar = JOptionPane.showInputDialog(null,"Introduce el identificador\n del Empleado a eliminar");

      if (Eliminar!=null && Eliminar.length()>=4){
		DatEmpleado pro = BuscarporIdentificador(Eliminar);
		if(pro!=null){
			ListaEmpleado.EliminarEmpleado(pro.get_Nombre(), 
			pro.get_Sexo(),pro.get_Edad(),pro.get_Direccion(),
			pro.get_Telefono(),pro.get_FechaNac(),
			pro.get_Antiguedad(),pro.get_Puesto(),pro.get_Salario(),
			pro.get_Horario(),pro.get_IE());
	  
			ListaEmpleado.EscribirListaArchivos();
		}else{
			JOptionPane.showMessageDialog(null,"Identificador no valido");
		}
      }else{
		JOptionPane.showMessageDialog(null,"El id debe contener al menos 4 coracteres");
      }
  }
 
  protected void NuevoEmpleado(){

	setLayout(new GridLayout(12,2));
	campo1 = new JLabel ("Introduce Nombre:");
	add(campo1);
	campoTexto1 = new JTextField();
	add(campoTexto1);

	campo2 = new JLabel ("Introduce Sexo:");
	add(campo2);
	campoTexto2 = new JTextField();
	add(campoTexto2);

	campo3 = new JLabel ("Introduce Edad:");
	add(campo3);
	campoTexto3 = new JTextField();
	add(campoTexto3);

	campo4 = new JLabel ("Introduce Direccion:");
	add(campo4);
	campoTexto4 = new JTextField();
	add(campoTexto4);

	campo5 = new JLabel ("Introduce Telefono:");
	add(campo5);
	campoTexto5 = new JTextField();
	add(campoTexto5);
	
	campo6 = new JLabel ("Fecha de Nacimiento:");
	add(campo6);
	campoTexto6 = new JTextField();
	add(campoTexto6);

	campo7 = new JLabel ("Introduce Antiguedad:");
	add(campo7);
	campoTexto7 = new JTextField();
	add(campoTexto7);


	campo8 = new JLabel ("Introduce Puesto:");
	add(campo8);
	campoTexto8 = new JTextField();
	add(campoTexto8);

	campo9 = new JLabel ("Introduce Salario:");
	add(campo9);
	campoTexto9 = new JTextField();
	add(campoTexto9);
	
	campo10 = new JLabel ("Introduce Horario:");
	add(campo10);
	campoTexto8 = new JTextField();
	add(campoTexto10);
	
	campo11 = new JLabel ("Introduce Identificador:");
	add(campo11);
	campoTexto11 = new JTextField();
	add(campoTexto11);

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
	Cadena = Cadena + "," +campoTexto9.getText();
	Cadena = Cadena + "," +campoTexto10.getText();
	Cadena = Cadena + "," +campoTexto11.getText();
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
	return EmpleadoObjeto;
  }

  protected void EscribirArchivolista(){
	String [] ArrayEmpleado;
    ArrayEmpleado = EmpleadoObjeto.split(",");
      System.out.println("Formato: " + EmpleadoObjeto);
    try{
      Objeto = new DatEmpleado(
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
		    ArrayEmpleado[10]);
	}catch(NumberFormatException ex){
      System.out.println("Error al leer numero en cadenas");
    }
    try{ 
		if(ListaEmpleado.Buscar(Objeto)== null){
			ListaEmpleado.InsertarEmpleado(Objeto);
			Archivos p = new Archivos("Empleados");
			p.EscribirFinal(ArrayEmpleado[0] + "," + ArrayEmpleado[1] 
			+ "," +ArrayEmpleado[2] + "," + ArrayEmpleado[3] 
			+ "," + ArrayEmpleado[4] + "," + ArrayEmpleado[5] 
			+ "," + ArrayEmpleado[7] + "," + ArrayEmpleado[8]
			+ "," + ArrayEmpleado[9] + "," + ArrayEmpleado[10]
			+ "," + ArrayEmpleado[11]);
		}
	}catch(IOException e){
	  System.out.println("No se puedo escribir a Empleado");
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
	String cadena9= campoTexto9.getText();
	String cadena10= campoTexto10.getText();
	String cadena11= campoTexto11.getText();
       	       
	if ("Aceptar".equals(cmd)){
	    System.out.println("Boton Aceptar presionado");
			
	    if(( cadena1.length() > 3 ) && (cadena2.length() >  3) &&
	       (cadena3.length() >=  1) && (cadena4.length() >  3) &&
	       (cadena5.length() >=  1) && (cadena6.length() >= 3) &&
	       (cadena7.length() >=	 1) && (cadena8.length() >  4) &&
	       (cadena9.length() >=	 3) && (cadena10.length() > 4) &&
	       (cadena11.length() >= 4)){
		
			EmpleadoObjeto = Aceptar();
			System.out.println("Campos completos");
			System.out.println("1: " + campoTexto1.getText()
				   + "2: " + campoTexto2.getText()
				   + "3: " + campoTexto3.getText()
				   + "4: " + campoTexto4.getText()
				   + "5: " + campoTexto5.getText()
				   + "6: " + campoTexto6.getText()
				   + "7: " + campoTexto7.getText()
				   + "8: " + campoTexto8.getText()
				   + "9: " + campoTexto6.getText()
				   + "10: " + campoTexto7.getText()
				   + "11: " + campoTexto8.getText());
		EscribirArchivolista();
	    }else{	    
		System.out.println("1: " + campoTexto1.getText()
				    + "2: " + campoTexto2.getText()
				    + "3: " + campoTexto3.getText()
				    + "4: " + campoTexto4.getText()
				    + "5: " + campoTexto5.getText()
				    + "6: " + campoTexto6.getText()
				    + "7: " + campoTexto7.getText()
				    + "8: " + campoTexto8.getText()
				    + "9: " + campoTexto6.getText()
				    + "10: " + campoTexto7.getText()
				    + "11: " + campoTexto8.getText());
		
		System.out.println("Campos incompletos");
		JOptionPane.showMessageDialog(null,"Todos los campos deben \n  ser mayores a 4 digitos execepto los numericos"); 
	    }
	}else if("Cancelar".equals(cmd)){
		
	}
	else{
			    
		System.out.println("Boton Cancelar presionado : " + cmd);
		EmpleadoObjeto = Cancelar();
			    
	    }


		    
	System.out.println("Manejador de eventos");
    }
    
    
}
