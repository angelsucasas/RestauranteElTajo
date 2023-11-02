/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import Modelo.Categoria;

/**
 *
 * @author User
 * Plato == Comida
 */
public class Comida {
    private String Nombre;
    private int Codigo;
    private String descripcion;
    private String precio;
    private Categoria categoria;
    
    public Comida(String Nombre,int Codigo,String descripcion,String precio,Categoria categoria){
        this.Codigo=Codigo;
        this.Nombre=Nombre;
        this.categoria=categoria;
        this.precio=precio;
        this.descripcion=descripcion;    
    }

    public Comida(){}
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String conseguirNombreCategoria() {
        return categoria.getNombre();
    }

    public Categoria getCategoria() {
        return this.categoria;
    }  
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }         
}
