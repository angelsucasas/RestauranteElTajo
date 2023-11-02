/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author User
 */
public class Cajero extends Empleado {
 
 private String cod_Cajero;
 private String clave_Cajero;
 
    public Cajero(String Nombre,String Apellido,String cod_Cajero,String Clave,String Cargo, String Cedula){
       super(Cedula,Nombre,Apellido,Cargo);
       this.clave_Cajero=Clave;
       this.cod_Cajero=cod_Cajero;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
 


    public String getCod_Cajero() {
        return cod_Cajero;
    }

    public void setCod_Cajero(String cod_Cajero) {
        this.cod_Cajero = cod_Cajero;
    }

    public String getClave_Cajero() {
        return clave_Cajero;
    }

    public void setClave_Cajero(String clave_Cajero) {
        this.clave_Cajero = clave_Cajero;
    }

 
   
 
    
    
}
