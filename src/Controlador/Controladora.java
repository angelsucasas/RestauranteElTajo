/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.io.*;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Modelo.Cajero;
import Modelo.Categoria;
import Modelo.Combo;
import Modelo.Comida;
import Modelo.Menu_Dia;
import Modelo.Pedido;
import Modelo.Empleado;
import Modelo.Recibo;
import Modelo.Procesos;
import Modelo.Validacion;
import Modelo.Chef;
import Modelo.Mesero;
import Modelo.Venta;
import Modelo.Administrador;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import Vista.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *;//
 * @author pc
 */
public class Controladora {
    
    CobroOrden cobroOrden;//=new CobroOrden();
    CrearEmpleado crearEmpleado;//=new CrearEmpleado();
    CrearMenuDelDia crearMenuDia;//=new CrearMenuDelDia();
    ModificarEmpleado modificarEmpleado;//=new EliminarEmpleado();
    EliminarMenuDelDia eliminarMenuDia;//=new EliminarMenuDelDia();
    EliminarOrden eliminarOrden;//=new EliminarOrden();
    GenerarOrden generarOrden;//=new GenerarOrden();
    IngresoAdministrador ingresoAdmin;//=new IngresoAdministrador();
    IngresoCajero ingresoCajero;//=new IngresoCajero();
    IngresoChef ingresoChef;//=new IngresoChef();
    IngresoMesero ingresoMesero;//=new IngresoMesero();
    ListadoDeVentas listadoVentas;//=new ListadoDeVentas();
    ListadoEmpleado listadoEmpleado;//=new ListadoEmpleado();
    MenuPrincipal menuPrincipal;//=new MenuPrincipal();
    ModificarMenuDelDia modificarMenuDia;//=new ModificarMenuDelDia();
    RegistroCategoria registroCategoria;//=new RegistroCategoria();
    RegistroCombo registroCombo;//=new RegistroCombo();
    RegistroMenuDelDia registroMenuDia;//=new RegistroMenuDelDia();
    RegistroPlato registroPlato;//=new RegistroPlato();
    MenuEmpleados menuEmpleados;
    VisualizarVentas visualizarOrdenes;
    
    JTextField nombre,apellido,cedula,pass, clave;
    JComboBox<String> cargo;
    JFrame ventana;
    Procesos proceso=new Procesos();
      
    Administrador Admin;//=new Administrador("Marcello","Servitad","27474658");
    Cajero Cash;//=new Cajero("Orianna","Zorrillo","12345","2901");
    Cajero Cash2;//=new Cajero("Pedro","Lopez","123","290");
    Set <Administrador> administradores = new HashSet<Administrador>();
    Set <Cajero> cajeros = new HashSet<Cajero>();
    Set <Comida>  comidas = new HashSet<Comida>();
    Set <Categoria> categorias = new HashSet<Categoria>();
    Set <Chef> chefs = new HashSet<Chef>();
    Set <Mesero> meseros = new HashSet<Mesero>();
    Set <Venta>Ventas = new HashSet<Venta>();
    Set <Combo> combos = new HashSet<Combo>();
    Set <Menu_Dia> menus = new HashSet<Menu_Dia>();
    Set <Empleado> empleados = new HashSet<Empleado>();
    Set <Pedido> pedidos = new HashSet<Pedido>();
    
    String name;
    String password;    
    boolean Valid_Admin=false;
    boolean Valid_Cash=false;
    
    private String categoriaDataFileName = "categorias";
    private String comidaDataFileName = "comidas";
    private String comboDataFileName = "combos";
    private String menuDataFileName = "menus";
    private String empleadoDataFileName = "empleados";
    private String pedidosDataFileName = "pedidos";
    private String ventasDataFileName = "ventas";
    
    String[] cargos = {
        "Admistrador",
        "Cliente",
        "Cajero",
        "Chef",
        "Mesero"
    };
    
    String[] metodosDePago = {
        "Efectivo dolares",
        "Efectivo bolivares",
        "Punto de venta - tarjeta de credito",
        "Punto de venta - tarjeta de debito",
        "Punto de venta - tarjeta de credito Internacional",
        "Punto de venta - tarjeta de debito Internacional",
    };
    
    List<String> mesasDisponiblesEnSistema = new ArrayList<String>() {{
        add("1");
        add("2");
        add("3");
        add("4");
        add("5");
        add("6");
        add("7");
        add("8");
        add("9");
        add("10");
        add("11");
        add("12");
        add("13");
        add("14");
        add("15");
        add("16");
        add("17");
        add("18");
        add("19");
        add("20");
    }};
            
    List<String> mesasOcupadas = new ArrayList<String>();
    
//     public Controladora( JFrame ventana/*, JTextField nombre,JTextField clave*/){
//        this.ventana=ventana;
//        this.nombre=nombre;
//         this.clave=clave;
//                 
//
//   }
    public Controladora(){}
     
     
    public void Iniciar() throws JsonProcessingException, IOException{
        CobroOrden cobroOrden=new CobroOrden();
        CrearEmpleado crearEmpleado=new CrearEmpleado();
        CrearMenuDelDia crearMenuDia=new CrearMenuDelDia();
        ModificarEmpleado eliminarEmpleado=new ModificarEmpleado();
        EliminarMenuDelDia eliminarMenuDia=new EliminarMenuDelDia();
        EliminarOrden eliminarOrden=new EliminarOrden();
        GenerarOrden generarOrden=new GenerarOrden();
        IngresoAdministrador ingresoAdmin=new IngresoAdministrador();
        IngresoCajero ingresoCajero=new IngresoCajero();
        IngresoChef ingresoChef=new IngresoChef();
        IngresoMesero ingresoMesero=new IngresoMesero();
        ListadoDeVentas listadoVentas=new ListadoDeVentas();
        ListadoEmpleado listadoEmpleado=new ListadoEmpleado();
        MenuPrincipal menuPrincipal=new MenuPrincipal();
        ModificarMenuDelDia modificarMenuDia=new ModificarMenuDelDia();
        RegistroCategoria registroCategoria=new RegistroCategoria();
        RegistroCombo registroCombo=new RegistroCombo();
        RegistroMenuDelDia registroMenuDia=new RegistroMenuDelDia();
        RegistroPlato registroPlato=new RegistroPlato();
        MenuEmpleados menuEmpleados=new MenuEmpleados();
        VisualizarVentas visualizarOrdenes = new VisualizarVentas();
            
        Controladora controller=new Controladora();


        menuPrincipal.setMicontrol(controller);
        cobroOrden.setMicontrol(controller);//=new CobroOrden();
        crearEmpleado.setMicontrol(controller);//=new CrearEmpleado();
        crearMenuDia.setMicontrol(controller);//=new CrearMenuDelDia();
        eliminarEmpleado.setMicontrol(controller);//=new EliminarEmpleado();
        eliminarMenuDia.setMicontrol(controller);//=new EliminarMenuDelDia();
        eliminarOrden.setMicontrol(controller);//=new EliminarOrden();
        generarOrden.setMicontrol(controller);//=new GenerarOrden();
        ingresoAdmin.setMicontrol(controller);//=new IngresoAdministrador();
        ingresoCajero.setMicontrol(controller);//=new IngresoCajero();
        ingresoChef.setMicontrol(controller);//=new IngresoChef();
        ingresoMesero.setMicontrol(controller);//=new IngresoMesero();
        listadoVentas.setMicontrol(controller);//=new ListadoDeVentas();
        listadoEmpleado.setMicontrol(controller);//=new ListadoEmplead
        modificarMenuDia.setMicontrol(controller);//=new ModificarMenuDelDia();
        registroCategoria.setMicontrol(controller);//=new RegistroCategoria();
        registroCombo.setMicontrol(controller);//=new RegistroCombo();
        registroMenuDia.setMicontrol(controller);//=new RegistroMenuDelDia();
        registroPlato.setMicontrol(controller);//=new RegistroPlato();
        menuEmpleados.setMicontrol(controller);
        visualizarOrdenes.setMicontrol(controller);

        controller.setAdmin(Admin);
        controller.setAdministradores(administradores);
        controller.setCobroOrden(cobroOrden);
        controller.setCrearEmpleado(crearEmpleado);
        controller.setCrearMenuDia(crearMenuDia);
        controller.setEliminarEmpleado(eliminarEmpleado);
        controller.setEliminarMenuDia(eliminarMenuDia);
        controller.setEliminarOrden(eliminarOrden);
        controller.setGenerarOrden(generarOrden);
        controller.setIngresoAdmin(ingresoAdmin);
        controller.setIngresoCajero(ingresoCajero);
        controller.setIngresoChef(ingresoChef);
        controller.setIngresoMesero(ingresoMesero);
        controller.setListadoVentas(listadoVentas);
        controller.setListadoEmpleado(listadoEmpleado);
        controller.setMenuEmpleados(menuEmpleados);
        controller.setMenuPrincipal(menuPrincipal);
        controller.setModificarMenuDia(modificarMenuDia);
        controller.setRegistroCategoria(registroCategoria);
        controller.setRegistroCombo(registroCombo);
        controller.setRegistroMenuDia(registroMenuDia);
        controller.setRegistroPlato(registroPlato);
        controller.setVisualizarOrdenes(visualizarOrdenes);
        
        controller.mostrarMenuPrincipal();                       
    }
     
    public static void main(String[] args) throws JsonProcessingException, IOException {
        // TODO code application logic here
        new Controladora().Iniciar();
    }
     
    public void mostrarMenuPrincipal(){ 
        menuPrincipal.setVisible(true);
    }
      
    public void mostrarIngresoAdministrador(){
        ingresoAdmin.setVisible(true);
    }
    public void mostrarIngresoCajero(){
        ingresoCajero.setVisible(true);
    }
    public void mostrarIngresoMesonero(){
        ingresoMesero.setVisible(true);
    }
    
    public void mostrarIngresoChef(){
        ingresoChef.setVisible(true);
    }
      
    public void mostrarMenuEmpleado(){
        menuEmpleados.setVisible(true);
    }
    
    public void mostrarVisualizarOrdenes(){
        this.empleados = (Set<Empleado>)this.loadDataFromJSONFormat( empleadoDataFileName, new TypeReference<Set<Empleado>>(){});
        this.categorias = (Set<Categoria>)this.loadDataFromJSONFormat( categoriaDataFileName, new TypeReference<Set<Categoria>>(){});
        this.comidas = (Set<Comida>)this.loadDataFromJSONFormat( comidaDataFileName, new TypeReference<Set<Comida>>(){});
        this.combos = (Set<Combo>)this.loadDataFromJSONFormat( comboDataFileName, new TypeReference<Set<Combo>>(){});
        //this.pedidos = (Set<Pedido>)this.loadDataFromJSONFormat( pedidosDataFileName, new TypeReference<Set<Pedido>>(){});
        visualizarOrdenes.setVisible(true);
        visualizarOrdenes.cargarVentas();
    }
          
    public void mostrarListadoEmpleados(){
        listadoEmpleado.setVisible(true);
        this.empleados = (Set<Empleado>)this.loadDataFromJSONFormat( empleadoDataFileName, new TypeReference<Set<Empleado>>(){});
        listadoEmpleado.cargarEmpleados();
    }
      
    public void mostrarCrearEmpleado(){
        crearEmpleado.setVisible(true);
        crearEmpleado.cargarCargos();
    }
      
    public void mostrarEliminarEmpleado(){
        modificarEmpleado.setVisible(true);
        this.empleados = (Set<Empleado>)this.loadDataFromJSONFormat( empleadoDataFileName, new TypeReference<Set<Empleado>>(){});
        modificarEmpleado.cargarCargos();
        modificarEmpleado.cargarEmpleados();
    }
      
    public void mostrarCobrarOrden(){
        cobroOrden.setVisible(true);
        this.empleados = (Set<Empleado>)this.loadDataFromJSONFormat( empleadoDataFileName, new TypeReference<Set<Empleado>>(){});
        this.categorias = (Set<Categoria>)this.loadDataFromJSONFormat( categoriaDataFileName, new TypeReference<Set<Categoria>>(){});
        this.comidas = (Set<Comida>)this.loadDataFromJSONFormat( comidaDataFileName, new TypeReference<Set<Comida>>(){});
        this.combos = (Set<Combo>)this.loadDataFromJSONFormat( comboDataFileName, new TypeReference<Set<Combo>>(){});
        //this.pedidos = (Set<Pedido>)this.loadDataFromJSONFormat( pedidosDataFileName, new TypeReference<Set<Pedido>>(){});
        this.menus = (Set<Menu_Dia>)this.loadDataFromJSONFormat( menuDataFileName, new TypeReference<Set<Menu_Dia>>(){});
        cobroOrden.cargarOrdenes();
    }
      
    public void mostrarGenerarOrden(){
        generarOrden.setVisible(true);
        this.empleados = (Set<Empleado>)this.loadDataFromJSONFormat( empleadoDataFileName, new TypeReference<Set<Empleado>>(){});
        this.categorias = (Set<Categoria>)this.loadDataFromJSONFormat( categoriaDataFileName, new TypeReference<Set<Categoria>>(){});
        this.comidas = (Set<Comida>)this.loadDataFromJSONFormat( comidaDataFileName, new TypeReference<Set<Comida>>(){});
        this.combos = (Set<Combo>)this.loadDataFromJSONFormat( comboDataFileName, new TypeReference<Set<Combo>>(){});
        //this.pedidos = (Set<Pedido>)this.loadDataFromJSONFormat( pedidosDataFileName, new TypeReference<Set<Pedido>>(){});
        this.menus = (Set<Menu_Dia>)this.loadDataFromJSONFormat( menuDataFileName, new TypeReference<Set<Menu_Dia>>(){});
        generarOrden.cargarDatosRestaurante();
        generarOrden.cargarOrdenes();
    }
      
    public void mostrarMenuDia(){
        registroMenuDia.setVisible(true);        
        this.categorias = (Set<Categoria>)this.loadDataFromJSONFormat( categoriaDataFileName, new TypeReference<Set<Categoria>>(){});
        this.comidas = (Set<Comida>)this.loadDataFromJSONFormat( comidaDataFileName, new TypeReference<Set<Comida>>(){});
        this.combos = (Set<Combo>)this.loadDataFromJSONFormat( comboDataFileName, new TypeReference<Set<Combo>>(){});        
        this.menus = (Set<Menu_Dia>)this.loadDataFromJSONFormat( menuDataFileName, new TypeReference<Set<Menu_Dia>>(){});
        registroMenuDia.cargarMenu();
    }

    public void mostrarEliminarOrden(){
        eliminarOrden.setVisible(true);
        this.empleados = (Set<Empleado>)this.loadDataFromJSONFormat( empleadoDataFileName, new TypeReference<Set<Empleado>>(){});
        this.categorias = (Set<Categoria>)this.loadDataFromJSONFormat( categoriaDataFileName, new TypeReference<Set<Categoria>>(){});
        this.comidas = (Set<Comida>)this.loadDataFromJSONFormat( comidaDataFileName, new TypeReference<Set<Comida>>(){});
        this.combos = (Set<Combo>)this.loadDataFromJSONFormat( comboDataFileName, new TypeReference<Set<Combo>>(){});
        this.menus = (Set<Menu_Dia>)this.loadDataFromJSONFormat( menuDataFileName, new TypeReference<Set<Menu_Dia>>(){});
        //this.pedidos = (Set<Pedido>)this.loadDataFromJSONFormat( pedidosDataFileName, new TypeReference<Set<Pedido>>(){});
        eliminarOrden.cargarOrdenes();
    }

    public void mostrarPlato(){
      registroPlato.setVisible(true);
      this.categorias = (Set<Categoria>)this.loadDataFromJSONFormat( categoriaDataFileName, new TypeReference<Set<Categoria>>(){});
      this.comidas = (Set<Comida>)this.loadDataFromJSONFormat( comidaDataFileName, new TypeReference<Set<Comida>>(){});
      registroPlato.cargarCategorias();
      registroPlato.cargarComida();
    }

    public void mostrarCategoria(){
      registroCategoria.setVisible(true);
      this.categorias = (Set<Categoria>)this.loadDataFromJSONFormat( categoriaDataFileName, new TypeReference<Set<Categoria>>(){});     
      registroCategoria.cargarCategorias();       
    }
      
    public void mostrarCombo(){
      registroCombo.setVisible(true);
      this.categorias = (Set<Categoria>)this.loadDataFromJSONFormat( categoriaDataFileName, new TypeReference<Set<Categoria>>(){});
      this.comidas = (Set<Comida>)this.loadDataFromJSONFormat( comidaDataFileName, new TypeReference<Set<Comida>>(){});
      this.combos = (Set<Combo>)this.loadDataFromJSONFormat( comboDataFileName, new TypeReference<Set<Combo>>(){});
      registroCombo.cargarCombo();      
      registroCombo.cargarCategorias();
    }              
      
    public void cerrarCobroOrden(){
        cobroOrden.setVisible(false);      
    }
    
    public void cerrarVisualizarOrdenes(){
      visualizarOrdenes.setVisible(false);
    }
     
    public void cerrarCrearEmpleado(){
        crearEmpleado.setVisible(false);
    }            
                 
    public void cerrarEliminarEmpleado(){
        modificarEmpleado.setVisible(false);
        this.empleados = (Set<Empleado>)this.loadDataFromJSONFormat( empleadoDataFileName, new TypeReference<Set<Empleado>>(){});
        modificarEmpleado.cargarCargos();
        modificarEmpleado.cargarEmpleados();
    }
                       
    public void cerrarMenuDelDia(){
        registroMenuDia.setVisible(false);
    }                             
                                   
    public void cerrarGenerarOrden(){
        generarOrden.setVisible(true);
    }
     
    public void cerrarIngresoAdministrador(){
        ingresoAdmin.setVisible(false);
    }
     
      
     public void cerrarIngresoCajero(){
     
     ingresoCajero.setVisible(false);
     
     }
       
    public void cerrarIngresoChef(){
        ingresoChef.setVisible(false);
    }
        
        
    public void cerrarIngresoMesero(){     
        ingresoMesero.setVisible(false);
    }
         
    public void cerrarListadoEmpleado(){}
               
    public void cerrarMenuEmpleados(){
        menuEmpleados.setVisible(true);
    }                 
         
    public void cerrarRegistroCategoria(){
        registroCategoria.setVisible(true);
    }
               
    public void cerrarRegistroCombo(){
        registroCombo.setVisible(true);
    }
           
    public void cerrarRegistroMenuDia(){     
        registroMenuDia.setVisible(false);
    }
           
      public void cerrarRegistroPlato(){
        registroPlato.setVisible(false);
     } 
      
     public void crearEmpleado(JTextField nombre,JTextField apellido ,JTextField cedula,JTextField pass ,JComboBox<String> cargo){
        proceso.anadirCajero(nombre,apellido,cedula,pass , cargo);
    }

    public void setCobroOrden(CobroOrden cobroOrden) {
        this.cobroOrden = cobroOrden;
    }

    public void setCrearEmpleado(CrearEmpleado crearEmpleado) {
        this.crearEmpleado = crearEmpleado;
    }

    public void setCrearMenuDia(CrearMenuDelDia crearMenuDia) {
        this.crearMenuDia = crearMenuDia;
    }

    public void setEliminarEmpleado(ModificarEmpleado modificarEmpleado) {
        this.modificarEmpleado = modificarEmpleado;
    }

    public void setEliminarMenuDia(EliminarMenuDelDia eliminarMenuDia) {
        this.eliminarMenuDia = eliminarMenuDia;
    }

    public void setEliminarOrden(EliminarOrden eliminarOrden) {
        this.eliminarOrden = eliminarOrden;
    }

    public void setGenerarOrden(GenerarOrden generarOrden) {
        this.generarOrden = generarOrden;
    }

    public void setIngresoAdmin(IngresoAdministrador ingresoAdmin) {
        this.ingresoAdmin = ingresoAdmin;
    }

    public void setIngresoCajero(IngresoCajero ingresoCajero) {
        this.ingresoCajero = ingresoCajero;
    }

    public void setIngresoChef(IngresoChef ingresoChef) {
        this.ingresoChef = ingresoChef;
    }

    public void setIngresoMesero(IngresoMesero ingresoMesero) {
        this.ingresoMesero = ingresoMesero;
    }

    public void setListadoVentas(ListadoDeVentas listadoVentas) {
        this.listadoVentas = listadoVentas;
    }

    public void setListadoEmpleado(ListadoEmpleado listadoEmpleado) {
        this.listadoEmpleado = listadoEmpleado;
    }

    public void setMenuPrincipal(MenuPrincipal menuPrincipal) {
        this.menuPrincipal = menuPrincipal;
    }

    public void setMenuEmpleados(MenuEmpleados menuEmpleados) {
        this.menuEmpleados = menuEmpleados;
    }

    
    public void setModificarMenuDia(ModificarMenuDelDia modificarMenuDia) {
        this.modificarMenuDia = modificarMenuDia;
    }

    public void setRegistroCategoria(RegistroCategoria registroCategoria) {
        this.registroCategoria = registroCategoria;
    }

    public void setRegistroCombo(RegistroCombo registroCombo) {
        this.registroCombo = registroCombo;
    }

    public void setRegistroMenuDia(RegistroMenuDelDia registroMenuDia) {
        this.registroMenuDia = registroMenuDia;
    }

    public void setRegistroPlato(RegistroPlato registroPlato) {
        this.registroPlato = registroPlato;
    }
    
    public void setVisualizarOrdenes(VisualizarVentas visualizarOrdenes){
        this.visualizarOrdenes = visualizarOrdenes;
    }

    public void setNombre(JTextField nombre) {
        this.nombre = nombre;
    }

    public void setClave(JTextField clave) {
        this.clave = clave;
    }

    public void setVentana(JFrame ventana) {
        this.ventana = ventana;
    }

    public void setProceso(Procesos proceso) {
        this.proceso = proceso;
    }

    public void setAdmin(Administrador Admin) {
        this.Admin = Admin;
    }

    public void setCash(Cajero Cash) {
        this.Cash = Cash;
    }

    public void setCash2(Cajero Cash2) {
        this.Cash2 = Cash2;
    }

    public void setAdministradores(Set<Administrador> administradores) {
        this.administradores = administradores;
    }

    public void setCajeros(Set<Cajero> cajeros) {
        this.cajeros = cajeros;
    }

    public void setComidas(Set<Comida> comidas) {
        this.comidas = comidas;
    }

    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
    }

    public void setChefs(Set<Chef> chefs) {
        this.chefs = chefs;
    }

    public void setMeseros(Set<Mesero> meseros) {
        this.meseros = meseros;
    }

    public void setVentas(Set<Venta> Ventas) {
        this.Ventas = Ventas;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setValid_Admin(boolean Valid_Admin) {
        this.Valid_Admin = Valid_Admin;
    }

    public void setValid_Cash(boolean Valid_Cash) {
        this.Valid_Cash = Valid_Cash;
    }
     
    public void ingresoLogIn(){     
        if (nombre.getText().isEmpty() || clave.getText().isEmpty() ){
            JOptionPane.showMessageDialog(null,"Debe indicar su nombre y clave","Ha ocurrido un Error",ERROR_MESSAGE);
        }else{
            name= nombre.getText();
            password=clave.getText();
            proceso.validacion_Admin(administradores, name, password);
            proceso.validacion_Cajero(cajeros, name, password);
        }
    }
     
    public void iniciaVentana(){
        // ImageIcon icono = new ImageIcon("src\\javaswing2\\icono.png");
        // ventana.setIconImage(icono.getImage()); 
        ventana.setLocationRelativeTo(null);  //para que este en la mitad
        ventana.setResizable(false);  // para que no se maximize
    }
    
    
    public boolean Validar_Numeros (String Dato) { //Valida que los datos sean numeros
        boolean isNumeric =  Dato.matches("[+-]?\\d*(\\.\\d+)?");

        return isNumeric;
    }
    
    
    public boolean ValidarNoVacios(String Dato){ //Valida que los campos no esten vacios
        if (Dato.isEmpty()){
            return true;
        }
        return false;
        
    }
    
     public boolean ValidarFloat (String Dato) {
        boolean resultado;
        try {
            Float.valueOf(Dato);//Valida que el dato sea double (Precio)              
            resultado = true;
        } catch (NumberFormatException e){           
            resultado = false;
        }
        return resultado;		
    }
     
     public boolean ValidarNombre(String Nombre,JButton boton) {	
        if(!ValidarNoVacios(Nombre)) {
            if(!Validar_Numeros(Nombre)) {
                return true;
            }
            else {
                JOptionPane.showMessageDialog(boton, "El Nombre solo puede tener caracteres Alfa", "Error: Formato invalido", JOptionPane.WARNING_MESSAGE, null);
                return false;
            }
        }
        else {
            JOptionPane.showMessageDialog(boton, "El campo Nombre es obligatorio", "Error: Campo Vacio", JOptionPane.WARNING_MESSAGE, null);
            return false;
        }
    }
     
     //este controlador enorme se debe segmentar en otros sub - controladores especificos
     //asi se mantiene un codigo mas organizado y limpio
     //este controlador quedaria como el controlador principal que le manda la informacion a los sub controladores y los llama cuando corresponda
     //pero no hay tiempo asi que...                   
     
     //Categorias
     public List<String> filtrarCategoriasPorNombre(){
        List<String> nombre_categorias = new ArrayList<>();
        if(this.categorias!=null){
            for(Categoria categoria:this.categorias){
                nombre_categorias.add(categoria.getNombre());
            }             
        }
        return nombre_categorias;
     }
     
     public List<Integer> getCategoriasPorCodigo(){
        List<Integer> codigo_categorias = new ArrayList<>();
        for(Categoria categoria:this.categorias){
            codigo_categorias.add(categoria.getCodigo());
        }
        return codigo_categorias;   
     }
     
     public Object filtrarCategoriaPorCodigo(Set<Categoria> categorias, int codigo_categoria){
         for(Categoria categoria:categorias){
             if(categoria.getCodigo() == codigo_categoria){
                 return categoria;
             }
         }
         return null;
     }
 
     public void crearCategoria(String nombre) throws JsonProcessingException, IOException{         
         Categoria nueva_Categoria = new Categoria(nombre, 1);
         nueva_Categoria.setCodigo(System.identityHashCode(nueva_Categoria));
         this.categorias.add(nueva_Categoria);
         
         saveDataToJSONFormat(this.categorias, categoriaDataFileName);
     }
     
     public void eliminarCategoria(int codigo_categoria){
         Categoria categoria_a_eliminar = (Categoria)filtrarCategoriaPorCodigo(this.categorias,codigo_categoria);
         if(categoria_a_eliminar != null){
            this.categorias.remove(categoria_a_eliminar);
         }         
         
        try {         
            saveDataToJSONFormat(this.categorias, categoriaDataFileName);
        } catch (IOException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
     
     public void modificarCategoria(String nombre, int codigo_categoria){
         Categoria categoria_a_modificar = (Categoria)filtrarCategoriaPorCodigo(this.categorias,codigo_categoria);
         if(categoria_a_modificar!= null){
            categoria_a_modificar.setNombre(nombre);
         }   
     }
     
     public Set<Categoria> getCategorias(){
         return this.categorias;
     }
     
     //Comida
     public void crearComida(String nombre, String descripcion, String precio, Categoria categoria){         
         Comida nueva_comida = new Comida(nombre, 1, descripcion, precio, categoria);
         nueva_comida.setCodigo(System.identityHashCode(nueva_comida));
         this.comidas.add(nueva_comida);
         
        try {         
            saveDataToJSONFormat(this.comidas, comidaDataFileName);
        } catch (IOException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void eliminarComida(int codigo_comida){
         Comida comida_a_eliminar = (Comida)filtrarComidaPorCodigo(codigo_comida);
         if(comida_a_eliminar != null){
            this.comidas.remove(comida_a_eliminar);
         }     
         
        try {         
            saveDataToJSONFormat(this.comidas, comidaDataFileName);
        } catch (IOException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void modificarComida(String nombre, String descripcion, String precio, Categoria categoria, int codigo_comida){
         Comida comida_a_modificar = (Comida)filtrarComidaPorCodigo(codigo_comida);
         if(comida_a_modificar!= null){
            comida_a_modificar.setNombre(nombre);
         }   
     }
     
     public Set<Comida> getComidas(){
         return this.comidas;
     }
     
     public List<Integer> getComidasPorCodigo(){
        List<Integer> codigo_categorias = new ArrayList<>();
        for(Comida comida:this.comidas){
            codigo_categorias.add(comida.getCodigo());
        }
        return codigo_categorias;   
     }
     
     public Object filtrarComidaPorCodigo( int codigo_comida){
         for(Comida comida:this.comidas){
             if(comida.getCodigo() == codigo_comida){
                 return comida;
             }
         }
         return null;
     }
     
     public List<String> filtrarComidasPorNombre(){
        List<String> nombre_comida = new ArrayList<>();
        if(this.categorias!=null){
            for(Comida comida:this.comidas){
                nombre_comida.add(comida.getNombre());
            }             
        }
        return nombre_comida;
     }
     
     public List<String> filtrarComidasPorPrecio(){
        List<String> precio_comidas = new ArrayList<>();
        if(this.categorias!=null){
            for(Comida comida:this.comidas){
                precio_comidas.add(comida.getPrecio());
            }             
        }
        return precio_comidas;
     }
     
     public List<String> filtrarComidasPorDescripcion(){
        List<String> descripcion_comida = new ArrayList<>();
        if(this.categorias!=null){
            for(Comida comida:this.comidas){
                descripcion_comida.add(comida.getDescripcion());
            }             
        }
        return descripcion_comida;
     }
     
     public List<String> filtrarComidasPorCategoria(){
        List<String> categoria_comida = new ArrayList<>();
        if(this.categorias!=null){
            for(Comida comida:this.comidas){
                categoria_comida.add(comida.conseguirNombreCategoria());
            }             
        }
        return categoria_comida;
     }
     
     //Combo     
     public void crearCombo(String nombre, Integer precio, Categoria categoria, List<Comida> comidas){         
         Combo nuevo_combo = new Combo(nombre, 1, precio, categoria, comidas);
         nuevo_combo.setCodigo(System.identityHashCode(nuevo_combo));
         this.combos.add(nuevo_combo);
         
        try {         
            saveDataToJSONFormat(this.combos, comboDataFileName);
        } catch (IOException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void eliminarCombo(int codigo_combo){
         Combo combo_a_eliminar = (Combo)filtrarComboPorCodigo(this.combos,codigo_combo);
         if(combo_a_eliminar != null){
            this.combos.remove(combo_a_eliminar);
         }    
         
        try {         
            saveDataToJSONFormat(this.combos, comboDataFileName);
        } catch (IOException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void modificarCombo(String nombre, Integer precio, Categoria categoria, List<Comida> comidas, int codigo_combo){
         Combo combo_a_modificar = (Combo)filtrarComboPorCodigo(this.combos, codigo_combo);
         if(combo_a_modificar!= null){
            combo_a_modificar.setNombre(nombre);
            combo_a_modificar.setPrecio(precio);
            combo_a_modificar.setCategoria(categoria);
            combo_a_modificar.setComidas(comidas);
         }   
     }
     
     public Set<Combo> getCombos(){
         return this.combos;
     }
     
     public List<Integer> getCombosPorCodigo(){
        List<Integer> codigo_combos = new ArrayList<>();
        for(Combo Combo:this.combos){
            codigo_combos.add(Combo.getCodigo());
        }
        return codigo_combos;   
     }
    
     public List<String> getStringDeComidasPertenecientesACadaCombo(){
         List<String> comida_de_cada_combo = new ArrayList<>();
         for(Combo particular_combo:this.combos){
             comida_de_cada_combo.add(particular_combo.conseguirStringDeComidasPertenecientesAEsteCombo());
         }
         return comida_de_cada_combo;
     }     
     
     public Object filtrarComboPorCodigo(Set<Combo> Combos, int codigo_combo){
         for(Combo combo:Combos){
             if(combo.getCodigo() == codigo_combo){
                 return combo;
             }
         }
         return null;
     }
     
     public List<String> filtrarCombosPorNombre(){
        List<String> nombre_combo = new ArrayList<>();
        if(this.categorias!=null){
            for(Combo combo:this.combos){
                nombre_combo.add(combo.getNombre());
            }             
        }
        return nombre_combo;
     }
     
     public List<String> filtrarCombosPorPrecio(){
        List<String> precio_combos = new ArrayList<>();
        if(this.categorias!=null){
            for(Combo Combo:this.combos){
                precio_combos.add(Combo.getPrecio().toString());
            }             
        }
        return precio_combos;
     }     
     
     public List<String> filtrarCombosPorCategoria(){
        List<String> categoria_combo = new ArrayList<>();
        if(this.categorias!=null){
            for(Combo Combo:this.combos){
                categoria_combo.add(Combo.conseguirCategoriaNombre());
            }             
        }
        return categoria_combo;
     }
     
     //Menu     
     public void crearMenu(String nombre, List<Comida> comidas, List<Combo> combos){         
         Menu_Dia nuevo_menu = new Menu_Dia(nombre, 1, comidas, combos);
         nuevo_menu.setCodigo(System.identityHashCode(nuevo_menu));
         this.menus.add(nuevo_menu);
         
         try {         
            saveDataToJSONFormat(this.menus, menuDataFileName);
        } catch (IOException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
     
     public void eliminarMenu(int codigo_menu){
         Menu_Dia menu_a_eliminar = (Menu_Dia)filtrarMenuPorCodigo(codigo_menu);
         if(menu_a_eliminar != null){
            this.menus.remove(menu_a_eliminar);
         }      
         
        try {         
            saveDataToJSONFormat(this.menus, menuDataFileName);
        } catch (IOException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public Set<Menu_Dia> getMenus(){
         return this.menus;
     }
     
     public List<String> filtrarMenuPorNombre(){
        List<String> nombre_menus = new ArrayList<>();        
        for(Menu_Dia menu:this.menus){
            nombre_menus.add(menu.getNombre());
        }             
        return nombre_menus;
     }
     
     public List<Integer> getMenuPorCodigo(){
        List<Integer> codigo_menus = new ArrayList<>();        
        for(Menu_Dia menu:this.menus){
            codigo_menus.add(menu.getCodigo());
        }             
        return codigo_menus;
     }
     
     public Object filtrarMenuPorCodigo(int codigo_menu_a_eliminar){
        for(Menu_Dia menu:this.menus){
             if(menu.getCodigo() == codigo_menu_a_eliminar){
                 return menu;
             }
         }
         return null;
     }
     
     public List<String> getComidasDelMenu(){
        List<String> comidas_de_cada_menu = new ArrayList<>();
        for(Menu_Dia menu:this.menus){
            comidas_de_cada_menu.add(menu.conseguirStringDeComidasDelMenu());
        }
        return comidas_de_cada_menu;
     }
     
     public List<String> getStringIndividualDeCadaComidaDelMenu(){
        List<String> comida_de_cada_menu = new ArrayList<>();
        for(Menu_Dia menu:this.menus){
            for(Comida comida: menu.getComidas()){
                comida_de_cada_menu.add(comida.getNombre());                
            }             
        }
        return comida_de_cada_menu;
     }
     
     public List<Integer> getIntegerIndividualDeCadaComidaDelMenu(){
        List<Integer> codigo_de_cada_comida_de_cada_menu = new ArrayList<>();
        for(Menu_Dia menu:this.menus){
            for(Comida comida: menu.getComidas()){
                codigo_de_cada_comida_de_cada_menu.add(comida.getCodigo());                
            }             
        }
        return codigo_de_cada_comida_de_cada_menu;
     }
     
     
     public List<List<Integer>> getCodigosDeLasComidasDelMenu(){
        List<List<Integer>> codigos_de_las_comidas_de_cada_menu = new ArrayList<>();
        List<Integer> lista_interna_de_los_codigos_de_las_comidas_de_cada_menu = new ArrayList<>();
        for(Menu_Dia menu:this.menus){
            for(Comida comida:menu.getComidas() ){
                lista_interna_de_los_codigos_de_las_comidas_de_cada_menu.add(comida.getCodigo());
            }
            codigos_de_las_comidas_de_cada_menu.add(lista_interna_de_los_codigos_de_las_comidas_de_cada_menu);
        }
        return codigos_de_las_comidas_de_cada_menu;
     }
     
     public List<String> getStringCombosDelMenu(){
        List<String> combos_de_cada_menu = new ArrayList<>();
        for(Menu_Dia menu:this.menus){
            combos_de_cada_menu.add(menu.conseguirStringDeCombossPertenecientesAEsteMenu());
        }
        return combos_de_cada_menu;
     }
     
     public List<String> getStringIndividualDeCadaCombosDelMenu(){
        List<String> combos_de_cada_menu = new ArrayList<>();
        for(Menu_Dia menu:this.menus){
            for(Combo combo: menu.getCombos()){
                combos_de_cada_menu.add(combo.getNombre());                
            }             
        }
        return combos_de_cada_menu;
     }
     
     public List<Integer> getCodigoIndividualDeCadaCombosDelMenu(){
        List<Integer> combos_de_cada_menu = new ArrayList<>();
        for(Menu_Dia menu:this.menus){
            for(Combo combo: menu.getCombos()){
                combos_de_cada_menu.add(combo.getCodigo());                
            }             
        }
        return combos_de_cada_menu;
     }
     
     public List<Combo> getCombosDelMenu(){
        List<Combo> combos_de_cada_menu = new ArrayList<>();
        for(Menu_Dia menu:this.menus){
            for(Combo combo: menu.getCombos()){
                combos_de_cada_menu.add(combo);
            }            
        }
        return combos_de_cada_menu;
     }
     
     public List<List<Integer>> getCodigosDeLosCombosDelMenu(){
        List<List<Integer>> codigos_de_los_combos_de_cada_menu = new ArrayList<>();
        List<Integer> lista_interna_de_los_codigos_de_los_combos_de_cada_menu = new ArrayList<>();
        for(Menu_Dia menu:this.menus){
            for(Combo combo:menu.getCombos()){
                lista_interna_de_los_codigos_de_los_combos_de_cada_menu.add(combo.getCodigo());
            }
            codigos_de_los_combos_de_cada_menu.add(lista_interna_de_los_codigos_de_los_combos_de_cada_menu);
        }
        return codigos_de_los_combos_de_cada_menu;
     }
     
    //administrador - empleados
     
     public void crearEmpleado(String nombre, String apellido, String cargo, String cedula){         
         Empleado nuevo_empleado = new Empleado(cedula,nombre, apellido, cargo);         
         this.empleados.add(nuevo_empleado);
         
        try {         
            saveDataToJSONFormat(this.empleados, empleadoDataFileName);
        } catch (IOException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void eliminarEmpleado(String codigo_empleado){
         Empleado empleado_a_eliminar = (Empleado)filtrarEmpleadoPorCedula(codigo_empleado);
         if(empleado_a_eliminar != null){
            this.empleados.remove(empleado_a_eliminar);
         }
         
         try {         
            saveDataToJSONFormat(this.empleados, empleadoDataFileName);
        } catch (IOException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
    public void modificarEmpleado(String cedula_nueva, String nombre, String apellido, String cargo, String cedula_vieja){
        Empleado empleado_a_modificar = (Empleado)filtrarEmpleadoPorCedula(cedula_vieja);
        if(empleado_a_modificar!= null){
            empleado_a_modificar.setNombre(nombre);
            empleado_a_modificar.setApellido(apellido);
            empleado_a_modificar.setCedula(cedula_nueva);
            empleado_a_modificar.setCargo(cargo);
        }
    }
     
     public Set<Empleado> getEmpleados(){
         return this.empleados;
     } 
     
     public Object filtrarEmpleadoPorCedula(String cedula_empleado_a_eliminar){
        for(Empleado empleado:this.empleados){
             if(empleado.getCedula().equals(cedula_empleado_a_eliminar)){
                 return empleado;
             }
         }
         return null;
     }
     
     public List<String> getCedulasPorEmpleado(){
        List<String> cedulas_por_empleado = new ArrayList<>();
        for(Empleado empleado:this.empleados){
             cedulas_por_empleado.add(empleado.getCedula());
        }
        return cedulas_por_empleado;
     } 
     
     public List<String> getNombrePorEmpleados(){
        List<String> nombre_completo_de_cada_empleado = new ArrayList<>();
        for(Empleado empleado:this.empleados){
             nombre_completo_de_cada_empleado.add(empleado.getNombre());
        }
        return nombre_completo_de_cada_empleado;
     }
     
     public List<String> getApellidoPorEmpleados(){
        List<String> nombre_completo_de_cada_empleado = new ArrayList<>();
        for(Empleado empleado:this.empleados){
             nombre_completo_de_cada_empleado.add( empleado.getApellido());
        }
        return nombre_completo_de_cada_empleado;
     }
     
     
     public List<String> getNombreCompletoPorEmpleados(){
        List<String> nombre_completo_de_cada_empleado = new ArrayList<>();
        for(Empleado empleado:this.empleados){
             nombre_completo_de_cada_empleado.add(empleado.getNombre() + " " + empleado.getApellido());
        }
        return nombre_completo_de_cada_empleado;
     }
     
     public List<String> getCargosPorEmpleados(){
        List<String> cargo_de_cada_empleado = new ArrayList<>();
        for(Empleado empleado:this.empleados){
             cargo_de_cada_empleado.add(empleado.getCargo());
        }
        return cargo_de_cada_empleado;
     }
     
     
    public String[] getCargos(){
        return this.cargos;
    }
    
    public List<Empleado> getTodosLosMeseros(){
        List<Empleado> meseros;
        meseros = new ArrayList<>();
        
        for(Empleado empleado:this.empleados){
            if(empleado.getCargo().equals(cargos[4])){
                meseros.add(empleado);
            }             
        }
        return meseros;
    }
    
    public List<String> getTodosLosLosMeseros(){
        List<String> meseros2;
        meseros2 = new ArrayList<>();
        
        for(Empleado empleado:this.empleados){
            if(empleado.getCargo().equals(cargos[4])){
                meseros2.add(empleado.conseguirNombreCompleto());
            }             
        }
        return meseros2;
    }
    
    public List<String> getMesasDisponibles(){
        return this.mesasDisponiblesEnSistema;
    }
    
    public List<String> getMesasOcupadas(){
        return this.mesasOcupadas;
    }
    
    public List<String> getMesasRegistradas(){
        List<String> mesasRegistradas = new ArrayList<String>();
        for(Pedido pedido:this.pedidos){
            mesasRegistradas.add(pedido.getMesa());
        }
        return mesasRegistradas;
    }
    
    //Pedido == Orden
    public void crearPedido(             
            Hashtable<Comida, Integer> comidas_pedidas_y_su_cantidad, 
            Hashtable<Combo, Integer> combos_pedidos_y_su_cantidad, 
            String mesa, 
            //LocalDateTime fecha_del_pedido,
            Empleado mesero
    ){         
        Pedido nuevo_pedido = new Pedido(1, 0, comidas_pedidas_y_su_cantidad, combos_pedidos_y_su_cantidad,mesa/*,fecha_del_pedido*/, mesero, false);
        nuevo_pedido.setCodigo(System.identityHashCode(nuevo_pedido));
        this.pedidos.add(nuevo_pedido);
        
        try {         
            saveDataToJSONFormat(this.pedidos, pedidosDataFileName);
        } catch (IOException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        mesasOcupadas.add(mesa);
        mesasDisponiblesEnSistema.remove(mesasDisponiblesEnSistema.indexOf(mesa));        
    }
     
    public void eliminarPedido(int codigo_pedido){
        Pedido pedido_a_eliminar = (Pedido)filtrarPedidoPorCodigo(this.pedidos,codigo_pedido);
        if(pedido_a_eliminar != null){
           this.pedidos.remove(pedido_a_eliminar);
           
           mesasOcupadas.remove(mesasOcupadas.indexOf(pedido_a_eliminar.getMesa()));  
           mesasDisponiblesEnSistema.add(pedido_a_eliminar.getMesa());
        }  
        
        try {         
            saveDataToJSONFormat(this.pedidos, pedidosDataFileName);
        } catch (IOException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public Object filtrarPedidoPorCodigo(Set<Pedido> lista_pedidos , int codigo_pedido){
         for(Pedido pedido:lista_pedidos){
             if(pedido.getCodigo() == codigo_pedido){
                 return pedido;
             }
         }
         return null;
     }
    
    public Set <Pedido> getPedidos(){
        return this.pedidos;
    }
    
    public Integer getNumeroOrdenes(){
        return this.pedidos.size();
    }
    
    //Ventas    
    public void crearVenta(Pedido pedido, String nombre_cliente, String metodo_pago, LocalDateTime fecha_venta){         
        Venta nuevo_venta = new Venta(1, pedido, nombre_cliente, metodo_pago, fecha_venta);
        nuevo_venta.setCodigo(System.identityHashCode(nuevo_venta));
        this.Ventas.add(nuevo_venta);
        
        try {
            saveDataToJSONFormat(this.Ventas, ventasDataFileName);
        } catch (IOException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        mesasOcupadas.remove(mesasOcupadas.indexOf(pedido.getMesa()));  
        mesasDisponiblesEnSistema.add(pedido.getMesa());
    }
     
    public void eliminarVenta(int codigo_venta){
        Pedido venta_a_eliminar = (Pedido)filtrarVentaPorCodigo(this.Ventas,codigo_venta);
        if(venta_a_eliminar != null){
           this.pedidos.remove(venta_a_eliminar);
        }    
        
        try {
            saveDataToJSONFormat(this.Ventas, ventasDataFileName);
        } catch (IOException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public Object filtrarVentaPorCodigo(Set<Venta> lista_ventas , int codigo_venta){
         for(Venta venta:lista_ventas){
             if(venta.getCodigo() == codigo_venta){
                 return venta;
             }
         }
         return null;
     }
    
    public Set <Venta> getVentas(){
        return this.Ventas;
    }
    
    public Integer getNumeroVentas(){
        return this.Ventas.size();
    }
    
    //metodo de pago
    
    public String[] getMetodosDePago(){
        return this.metodosDePago;
    }
    
    //JSON
    public void saveDataToJSONFormat(Object data, String saveFileName) throws JsonProcessingException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("./data_json/" + saveFileName + ".json") ,data);
    }
    
    public Object loadDataFromJSONFormat(String saveFileName, TypeReference referencia){
        ObjectMapper mapper = new ObjectMapper();
        
        Object testCategoria = new HashSet<Object>();
        
        Path filePath = Path.of("./data_json/" + saveFileName + ".json");

        String content;
        try {
            content = Files.readString(filePath);            
            File jsonFile = new File("./data_json/" + saveFileName + ".json");
            mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
            testCategoria = mapper.readValue(content,  referencia);            
        } catch (IOException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        return testCategoria;
    }
    
}
