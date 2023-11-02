/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class Menu_Dia {    
    private String Nombre;
    private int Codigo;
    private List<Comida> comidas;
    private List<Combo> combos;
    
    public Menu_Dia(String Nombre,int Codigo, List<Comida> comidas, List<Combo> combos){
        this.Codigo=Codigo;
        this.Nombre=Nombre;
        this.comidas = comidas;
        this.combos = combos;
    }
    
    public Menu_Dia(){}

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

    public List<Combo> getCombos() {
        return this.combos;
    }

    public void setCombos(List<Combo> combos) {
        this.combos = combos;
    }
    
    public List<Comida> getComidas() {
        return comidas;
    }

    public void setComidas(List<Comida> comida) {
        this.comidas = comida;
    }
    
    public List<String> conseguirListaDeComidasPertenecientesACadaComboDeEsteMenu(){        
        List<String> comidas_por_combo = new ArrayList<>();
        for(Combo combo:this.combos){
            comidas_por_combo.add(combo.conseguirStringDeComidasPertenecientesAEsteCombo());
        }
        return comidas_por_combo;   
     }
    
    public String conseguirStringDeComidasDelMenu(){        
        String comidas_por_menu = "";
        for(Comida comida:this.comidas){
            comidas_por_menu += comida.getNombre() + " ,";
        }
        return comidas_por_menu;      
     }
    
     public String conseguirStringDeCombossPertenecientesAEsteMenu(){
        String combos_de_este_menu = "";
        for(Combo combo:this.combos){
            combos_de_este_menu += combo.getNombre() + " ,";
        }
        return combos_de_este_menu;   
     }
}
