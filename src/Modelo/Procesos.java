/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import Controlador.Controladora;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JTextField;
/**
 *
 * @author User
 */
public class Procesos {
    
    JTextField nombre, apellido, cedula;
    
    
    private Controladora micontrolador;
    
    
    public void registroAdmin(Set <Administrador> Administradores,Administrador Admin){
    Administradores.add(Admin);
    
    
    }
    public void registroCajero(Set <Cajero> cajeros,Cajero cash){
    cajeros.add(cash);
        
    }
    
    public void Log_In( Set <Administrador> administradores,Set <Cajero> cajeros){
    
        
        Validacion cont=new Validacion();
        Scanner entrada=new Scanner(System.in);
        String  Nombre_Ingreso="";
        String Clave="";   
        int op=0;
        boolean valid=false;
        boolean vacio=false;
        boolean validacion_Admin=false;
        boolean valid_prog=false;
        boolean validacion_Cajero=false;
       
    
        while(valid_prog==false){
                        
                                    entrada.next();
            
            System.out.println("Ingrese sus datos");
            System.out.println("Nombre");
            Nombre_Ingreso=entrada.next();
       
            System.out.println("Clave");
            Clave=entrada.next();
            valid=cont.Validar_Numeros(Clave);
            
            validacion_Admin=validacion_Admin(administradores,Nombre_Ingreso,Clave);
            
            validacion_Cajero=validacion_Cajero(cajeros, Nombre_Ingreso,Clave);
           
            
            if(validacion_Admin==true ){
                    
                menuAdmin();
            
            }else{
            if( validacion_Cajero==true){
                menuCajero();
        
            }
            
                    
            
            }
             if(validacion_Cajero==false && validacion_Admin==false ){
            System.out.println("USTED NO SE ENCUENTRA REGISTRADO EN EL SISTEMA");}
                    
                    
                    
            
            
            entrada.next();
            System.out.println("Quiere probar otra vez? 1)si, 0)no");
            op=entrada.nextInt();
            if(op==0){
            valid_prog=true;
            
            } 
        
        }
    
    
    
    
    }
    
    public void registroComida(){
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }
    
    public void registroCategoria(){}
    
    public void registroVenta(){}
    
    
    
    
    
    

     
    public boolean validacion_Admin(Set <Administrador>administradores, String Nombre_Ingreso,String Clave){
             Iterator<Administrador> itAdmin=administradores.iterator();  
            
             boolean control=false;
        
             while(itAdmin.hasNext()){
                  Administrador usuario_Guardado=itAdmin.next();
                    
                   
               
                 
             if(usuario_Guardado.getNombre().equals(Nombre_Ingreso)){
                 if(usuario_Guardado.getClave().equals(Clave)){
                 control=true;}
                 
                 
             }
             }
                 
                 
             
                 
             
                 
            
             
        
        
        
        return control;}
    
    public boolean validacion_Cajero(Set <Cajero> cajeros, String Nombre_Ingreso,String Clave){
             Iterator<Cajero> itCash=cajeros.iterator();
             boolean control=false;   
              
                 while(itCash.hasNext()){
                 Cajero cajero_Guardado=itCash.next();
                 if(cajero_Guardado.getNombre().equals(Nombre_Ingreso)){
                     if(cajero_Guardado.getClave_Cajero().equals(Clave)){
                     control=true;}
                        }
                 }
            
             return control;}
    
    public void menuAdmin(){
                
                System.out.println("Bienvenido");
                 System.out.println("1)Administrar Cajeros");
                  System.out.println("2)Reporte de ventas");
                   System.out.println("3)Cambiar datos");
                    System.out.println("4)Administar menu del dia");
                    System.out.println("5)administrar comida");
                     System.out.println("6)administrar categorias");
                     System.out.println("0)Salir");
                    
     }
    
     
    public void administrarCajeros(String codigo_Cajero){
                System.out.println("1)Eliminar Cajero");
                 System.out.println("2)añadir cajero");
                 System.out.println("3)Cambiar dato cajero");
                  System.out.println("0)Salir");
                
     }
    
    public void anadirCajero(JTextField nombre,JTextField apellido,JTextField cedula,JTextField Clave , JComboBox<String>  Cargo){
         Cajero nuevo_Caj=null;
                   String ced;
                   String   name;
                   String last;
                   String Carg;
                   String Clav;
         if (nombre.getText().isEmpty() || apellido.getText().isEmpty() ||cedula.getText().isEmpty()|| Clave.getText().isEmpty()  )
         JOptionPane.showMessageDialog(null,"Debe indicar todos los campos","Ha ocurrido un Error",ERROR_MESSAGE);
      else {    

                name= nombre.getText();
                last=apellido.getText();
                ced=cedula.getText();
                Clav=Clave.getText();
                Carg=Cargo.getSelectedItem().toString();
                //nuevo_Caj=new Cajero(name,last,ced,Clav,Carg);      
             
                
                System.out.println("nombre"+nuevo_Caj.getNombre());
                System.out.println("apellido"+nuevo_Caj.getApellido());
                System.out.println("cedula"+nuevo_Caj.getCod_Cajero());
                System.out.println("clave"+nuevo_Caj.getClave_Cajero());
                 System.out.println("cargo"+nuevo_Caj.getCargo());
                    
              }
        
      
//      Scanner entrada=new Scanner(System.in);
//      String Nombre,Apellido,Clave_Cajero,Codigo_Cajero;
//                
//                 System.out.println("Introduzca los datos del cajero a añadir");
//             
//                 System.out.println("Nombre");
//                 Nombre=entrada.next();
//                 System.out.println("Apellido");
//                 Apellido=entrada.next();
//                 System.out.println("Clave Cajero");
//                 Clave_Cajero=entrada.next();
//                 System.out.println("Codigo Cajero");
//                 Codigo_Cajero=entrada.next();
//                 
//                 nuevo_Caj=new Cajero(Nombre,Apellido,Codigo_Cajero,Clave_Cajero);
//                 
//                 
//                return nuevo_Caj;
    }
    
    
    public void eliminarCajero(Set <Cajero>cajeros,String Cod_Cajero){
    
                 
                 Iterator<Cajero> itCash=cajeros.iterator();
                
              
                 while(itCash.hasNext()){
                 
                 Cajero cash=itCash.next();
                 if(cash.getCod_Cajero().equals(Cod_Cajero)){
               
                     cajeros.remove(cash);
                     
                        }
                 }
    
    
    
    
    
    }
    
    
    public void modificarCajero(Set <Cajero>cajeros,String Cod_Cajero){
            
                
                Iterator<Cajero> itCash=cajeros.iterator();
                int op=0;
                Scanner entrada=new Scanner(System.in);
                String Nombre="";
                String Apellido="";
                String Clave_Cajero="";
                 while(itCash.hasNext()){
                        
                 Cajero cash=itCash.next();
                 if(cash.getCod_Cajero().equals(Cod_Cajero)){
                                     System.out.println("1)Cambiar Nombre y Apellido del cajero");
                                     System.out.println("2)Cambiar la Clave del cajero");
                                     System.out.println("0)Salir");
                                     op=entrada.nextInt();
                     if(op==1){
                          System.out.println("Ingrese el nuevo nombre y apellido del cajero");
                             Nombre=entrada.next();
                             System.out.println("Apellido");
                             Apellido=entrada.next();
                             cash.setNombre(Nombre);
                             cash.setApellido(Apellido);
                     
                     }
                     
                        }
                 }
    
    
    }
    
    public void imprimirChiquito(Set <Cajero>cajeros){
            
    
    Iterator<Cajero> itCash=cajeros.iterator();
                
              
                 while(itCash.hasNext()){
                 
                 Cajero cash=itCash.next();
                 
                 System.out.println(cash.Nombre);
                 System.out.println(cash.Apellido);
                 System.out.println(cash.getClave_Cajero());
                 System.out.println(cash.getCod_Cajero());
                
                 }
    
    
    }
    
    public void reporteVentas(){}
    
    
    public void modificarAdmin(){}
    
    
    public void administrarMenuDia(){}
    
    
    public void administrarComida(){}
    
    public void administrarCategoria(){}
    
    
    
    
    public void menuCajero(){
             System.out.println("Bienvenido");
                 System.out.println("1)Tomar Pedido");
                 System.out.println("2)Mostrar Menu Del Dia");
                 System.out.println("3)imprimir factura");
                  System.out.println("0)Salir");
        
    }
    
    public void pedido(){}
    
    
    public void mostrarMenuDia(){}
    
    public void factura(){}
    
    
    
   
    
    
    
    
}
