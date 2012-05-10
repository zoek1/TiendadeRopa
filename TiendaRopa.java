import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class TiendaRopa extends JFrame implements ActionListener{
  private JMenuBar MenuContenedor;
  private JMenu Productos;
  private JMenu Administración;
  private JButton Comprar;
  private JButton Cancelar;
  private JButton Agregar;
  private ImageIcon icono;
  private ImageIcon icono2;
  private ProductoGui listadeproductos;
  private final String NombreEmpresa = "Tienda de Ropa -  Axel Frog";
  private JLabel etiqueta;
  private JTextField identificador;
  private JTextArea lista;
  private JPanel panel1,panel2,panel3;

  
  private ListaLigadaProducto lp;
  private Recibo vendidos;
  private Producto pro;
  
  private static final String [] Menus = {"Productos","Clientes","Administración","Empleado"};
  private static final String [] MenuProducto = {"Agregar Producto","Eliminar Productos","Consultar producto"};

    private static final String [] MenuAdministración = {"Agregar Contraseña","Eliminar Contraseña","Cambiar Constraseña"};  


  
  public TiendaRopa(){
    setTitle(NombreEmpresa);
    lp = new ListaLigadaProducto();
    setLayout(new GridLayout(2,0));
    lp.LeerArchivoProducto();
    listadeproductos = new ProductoGui();
    listadeproductos.setListaProducto(lp);

    vendidos = new Recibo();
    panel1 = new JPanel();
    panel2 = new JPanel();
    panel3 = new JPanel();

     icono = new ImageIcon("Emblemas/Faenza-rana.png");

    icono2 = new ImageIcon("Emblemas/rana.png");

    // Menus
    MenuContenedor = new JMenuBar();
    Productos = new JMenu(Menus[0]);
    Administración = new JMenu(Menus[2]);

    JMenuItem Submenu1 = new JMenuItem(MenuProducto[0],new ImageIcon("Emblemas/Agregar.png"));

    JMenuItem Submenu2 = new JMenuItem(MenuProducto[1],new ImageIcon("Emblemas/Quitar.png"));
	Submenu2.addActionListener(this);
	JMenuItem Submenu3 = new JMenuItem(MenuProducto[2],new ImageIcon("Emblemas/Buscar.png"));
	
	JMenuItem Submenu10= new JMenuItem(MenuAdministración[0],new ImageIcon("Emblemas/Agregar.png"));
	JMenuItem Submenu11= new JMenuItem(MenuAdministración[1],new ImageIcon("Emblemas/Quitar.png"));
	JMenuItem Submenu12= new JMenuItem(MenuAdministración[2],new ImageIcon("Emblemas/Cambiar.png"));
    
	Submenu1.addActionListener(this);
        Submenu2.addActionListener(this);
	Submenu3.addActionListener(this);
     
	Submenu10.addActionListener(this);
	Submenu11.addActionListener(this);
	Submenu12.addActionListener(this);				    
	// Menu Producto
	Productos.add(Submenu1);
	Productos.add(Submenu2);
	Productos.add(Submenu3);
	Administración.add(Submenu10);
	Administración.add(Submenu11);
	Administración.add(Submenu12);
	
    MenuContenedor.add(Productos);
    MenuContenedor.add(Administración);
    //    add(MenuContenedor);
    setJMenuBar(MenuContenedor);


    Comprar = new JButton("Comprar");
    Cancelar = new JButton("Cancelar");
    Agregar = new JButton("Agregar a la lista");
    Comprar.addActionListener(this);
    Cancelar.addActionListener(this);
    Agregar.addActionListener(this);
    this.setIconImage(icono.getImage());
    JLabel Ranita = new JLabel(icono2);
    add(Ranita);
    addWindowListener((new WindowAdapter(){
	  
	public void windowClosing(WindowEvent e){
	  setVisible(false);
	  dispose();
	  System.exit(0); } }));

    etiqueta = new JLabel("Introduce el id del produco");
    panel1.add(etiqueta);
    identificador = new JTextField("Introduce el codigo aquí");
    identificador.addActionListener(this);
    panel1.add(identificador);
    lista = new JTextArea("");
    panel1.add(Agregar);
    // panel1.add(lista);
    panel2.add(Comprar);
    panel2.add(Cancelar);

    panel3.add(panel1);
    panel3.add(panel2);
    panel3.add(lista);
    

    add(panel3);
    pack();
      setVisible(true);
  }

  public void WindowVenta(){
    JFrame nuevo = new JFrame("Recibo");
    nuevo.setLayout(new GridLayout(0,1));
    String text = lista.getText();
    String [] ArrayString = text.split("\n");
    JLabel name =new  JLabel("Tienda de Ropa - Axel Frog");
    JLabel direccion =new JLabel(vendidos.get_Direccion_Tienda());
    JLabel hora = new  JLabel(vendidos.get_Hora("%A%M%h%m%s"));
    JTextArea productos = new JTextArea(text);
    String totl = Float.toString(vendidos.Suma_Total());
    JLabel total = new  JLabel("Total: " + totl);
    JLabel Gracias = new  JLabel("Gracias por su visita vuelva pronto");
    
    JLabel img = new JLabel(icono);
    nuevo.add(name);
    nuevo.add(direccion);
    nuevo.add(hora);
    nuevo.add(productos);
    nuevo.setVisible(true);
    nuevo.add(total);
    nuevo.add(Gracias);
    nuevo.add(img);
    nuevo.pack();
  }
  
  public void actionPerformed(ActionEvent e){
    String cmd = e.getActionCommand();
    if(MenuProducto[0].equals(cmd)){
      listadeproductos.NuevoProducto();
    }else if(MenuProducto[1].equals(cmd)){
      listadeproductos.EliminarProducto();
      }else if(MenuProducto[2].equals(cmd)){
      listadeproductos.EliminarProducto();
      listadeproductos.BusquedadeProductos();
	}else if(MenuAdministración[0].equals(cmd)){
      ContraseniaGui p = new ContraseniaGui("Keyhash");
      
      p.NuevaContrasenia();
    }else if(MenuAdministración[1].equals(cmd)){
      ContraseniaGui p  = new ContraseniaGui("Keyhash");
      p.EliminarContrasenia();
    }else if(MenuAdministración[2].equals(cmd)){
      ContraseniaGui p  = new ContraseniaGui("Keyhash");
      p.CambiarContrasenia();      
    }else if("Agregar a la lista".equals(cmd)){
      String tmp = identificador.getText();
      if (tmp!= null && tmp.length()>=4){
       pro = lp.Buscar(tmp);
       if(pro != null){
       vendidos.Agregar_Producto(pro);
       System.out.println("Producto Agregado: " + pro.get_Marca() + pro.get_Talla() + pro.get_Modelo() + pro.get_Color() + pro.get_TipoTela() + pro.get_Precio() + pro.get_Descuento() + pro.getid());
       lista.append(pro.get_Marca() + " - " + pro.get_Modelo() + "    " + pro.get_Precio() + "-" + pro.get_Descuento() + "\n");
       }else{
	 JOptionPane.showMessageDialog(null,"Identificador invalido");
       }
      }
    }else if("Cancelar".equals(cmd)){
      vendidos = new Recibo();
      lista = new JTextArea("");
      lista.setText("");
      identificador = new JTextField();
           identificador.setText("");
    }else if("Comprar".equals(cmd)){
      WindowVenta();
      vendidos = new Recibo();
      lista = new JTextArea("");
      identificador = new JTextField();
      identificador.setText("");
    }
  }
  
}
