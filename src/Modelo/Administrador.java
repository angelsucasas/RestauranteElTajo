/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author pc
 */
public class Administrador extends Empleado {
 
    private String Clave;
    
    public Administrador(String Nombre, String Apellido,String Clave,String Cargo, String Cedula){
        super(Cedula,Nombre,Apellido,Cargo);
        this.Clave=Clave;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

   
    
    
    
    
}
