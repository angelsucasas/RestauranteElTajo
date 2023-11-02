/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author pc
 */
public class Empleado {
    
    protected String Nombre;
    protected String Apellido;
    protected String Cargo;
    protected String Cedula;
    
    public Empleado(){}
    
    public Empleado(String Cedula,String Nombre, String Apellido, String Cargo){
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Cargo = Cargo;
        this.Cedula = Cedula;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }
    
    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }
    
    public String conseguirNombreCompleto(){
        return this.Nombre + " " + this.Apellido;
    }
}
