/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.List;
import java.util.Set;
/**
 *
 * @author User
 */
public class Combo {
    private String Nombre;
    private int Codigo;
    private List<Comida> comidas;
    private Integer precio;
    private Categoria categoria;
    
    public Combo(String Nombre,int Codigo,Integer precio,Categoria categoria, List<Comida> comidas){
        this.Codigo=Codigo;
        this.Nombre=Nombre;
        this.categoria=categoria;
        this.precio=precio;
        this.comidas = comidas;
    }

    public Combo(){}
    
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

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
    
    public List<Comida> getComidas() {
        return comidas;
    }

    public void setComidas(List<Comida> comida) {
        this.comidas = comida;
    }

    public String conseguirCategoriaNombre() {
        return categoria.getNombre();
    }

    public Categoria getCategoria() {
        return this.categoria ;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public String conseguirStringDeComidasPertenecientesAEsteCombo(){
        String comidas_de_este_combo = "";
        for(Comida comida:this.comidas){
            comidas_de_este_combo += comida.getNombre() + " ,";
        }
        return comidas_de_este_combo;   
     }
    
    public int conseguirCostoTotalCombo(){        
        return this.precio;
    }
}
