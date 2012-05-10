import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class TiendaRopa extends JFrame implements ActionListener{
  private JMenuBar MenuContenedor;
  private JMenu Productos;
  private JMenu Clientes;
  private JMenu Administración;
  private JMenu Empleado;
  private ImageIcon icono;
  private ImageIcon icono2;
  private ProductoGui listadeproductos;
  private final String NombreEmpresa = "Tienda de Ropa -  Axel Frog";

  private static final String [] Menus = {"Productos","Clientes","Administración","Empleado"};
  private static final String [] MenuProducto = {"Agregar Producto","Eliminar Productos","Consultar producto"};

    private static final String [] MenuClientes = {"Agregar Cliente","Eliminar Cliente","Consulta de cliente"};

    private static final String [] MenuAdministración = {"Agregar Contraseña","Eliminar Contraseña","Cambiar Constraseña"};

  private static final String [] MenuEmpleado = {"Agregar Empleado","Despedir Empleado","Consulta de empleado"};
  
  public TiendaRopa(){
    setTitle(NombreEmpresa);
    ListaLigadaProducto lp = new ListaLigadaProducto();
    lp.LeerArchivoProducto();
    listadeproductos = new ProductoGui();
    listadeproductos.setListaProducto(lp);
    
    icono = new ImageIcon("Emblemas/Faenza-rana.png");
    icono2 = new ImageIcon("Emblemas/rana.png");

    // Menus
    MenuContenedor = new JMenuBar();
    Productos = new JMenu(Menus[0]);
    Clientes = new JMenu(Menus[1]);
    Administración = new JMenu(Menus[2]);
    Empleado = new JMenu(Menus[3]);

    JMenuItem Submenu1 = new JMenuItem(MenuProducto[0],new ImageIcon("Emblemas/Agregar.png"));

    JMenuItem Submenu2 = new JMenuItem(MenuProducto[1],new ImageIcon("Emblemas/Quitar.png"));
	Submenu2.addActionListener(this);
	JMenuItem Submenu3 = new JMenuItem(MenuProducto[2],new ImageIcon("Emblemas/Buscar.png"));
	JMenuItem Submenu4= new JMenuItem(MenuClientes[0],new ImageIcon("Emblemas/Agregar.png"));
	JMenuItem Submenu5= new JMenuItem(MenuClientes[1],new ImageIcon("Emblemas/Quitar.png"));
	JMenuItem Submenu6= new JMenuItem(MenuClientes[2],new ImageIcon("Emblemas/Buscar.png"));
	JMenuItem Submenu7= new JMenuItem(MenuEmpleado[0],new ImageIcon("Emblemas/Agregar.png"));
	JMenuItem Submenu8= new JMenuItem(MenuEmpleado[1],new ImageIcon("Emblemas/Quitar.png"));
	JMenuItem Submenu9= new JMenuItem(MenuEmpleado[2],new ImageIcon("Emblemas/Buscar.png"));
    

	JMenuItem Submenu10= new JMenuItem(MenuAdministración[0],new ImageIcon("Emblemas/Agregar.png"));
	JMenuItem Submenu11= new JMenuItem(MenuAdministración[1],new ImageIcon("Emblemas/Quitar.png"));
	JMenuItem Submenu12= new JMenuItem(MenuAdministración[2],new ImageIcon("Emblemas/Cambiar.png"));
    
	Submenu1.addActionListener(this);
        Submenu2.addActionListener(this);
	Submenu3.addActionListener(this);
	Submenu4.addActionListener(this);
	Submenu5.addActionListener(this);
	Submenu6.addActionListener(this);
	Submenu7.addActionListener(this);
	Submenu8.addActionListener(this);
	Submenu9.addActionListener(this);
	Submenu10.addActionListener(this);
	Submenu11.addActionListener(this);
	Submenu12.addActionListener(this);				    
	// Menu Producto
	Productos.add(Submenu1);
	Productos.add(Submenu2);
	Productos.add(Submenu3);
        Clientes.add(Submenu4);
	Clientes.add(Submenu5);
	Clientes.add(Submenu6);
	Administración.add(Submenu10);
	Administración.add(Submenu11);
	Administración.add(Submenu12);
	Empleado.add(Submenu7);
	Empleado.add(Submenu8);
	Empleado.add(Submenu9);
	
    MenuContenedor.add(Productos);
    MenuContenedor.add(Clientes);
    MenuContenedor.add(Administración);
    MenuContenedor.add(Empleado);
    //    add(MenuContenedor);
    setJMenuBar(MenuContenedor);
    
    this.setIconImage(icono.getImage());
    JLabel Ranita = new JLabel(icono2);
    add(Ranita);
    addWindowListener((new WindowAdapter(){
	  
	public void windowClosing(WindowEvent e){
	  setVisible(false);
	  dispose();
	  System.exit(0); } }));
      pack();
      setVisible(true);
  }

  public void actionPerformed(ActionEvent e){
    String cmd = e.getActionCommand();
    if(MenuProducto[0].equals(cmd)){
      listadeproductos.NuevoProducto();
    }else if(MenuProducto[1].equals(cmd)){
	
      }else if(MenuProducto[2].equals(cmd)){

      listadeproductos.BusquedadeProductos();
	}else if(MenuClientes[0].equals(cmd)){
	  
    }else if(MenuClientes[1].equals(cmd)){
      
    }else if(MenuClientes[2].equals(cmd)){
      
    }else if(MenuAdministración[0].equals(cmd)){
      ContraseniaGui p = new ContraseniaGui("Keyhash");
      
      p.NuevaContrasenia();
    }else if(MenuAdministración[1].equals(cmd)){
      ContraseniaGui p  = new ContraseniaGui("Keyhash");
      p.EliminarContrasenia();
    }else if(MenuAdministración[2].equals(cmd)){
      ContraseniaGui p  = new ContraseniaGui("Keyhash");
      p.CambiarContrasenia();      
    }else if(MenuEmpleado[0].equals(cmd)){

    }else if(MenuEmpleado[1].equals(cmd)){

    }else if(MenuEmpleado[2].equals(cmd)){
      
    }
  }
  
}