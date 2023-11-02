/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.List;
import java.time.LocalDateTime; 
import java.io.*;
import java.util.*;
/**
 *
 * @author pc
 * Pedido == Orden
 */
public class Pedido {
    private int Codigo;
    private Hashtable<Comida, Integer> comidas_pedidas_y_su_cantidad;
    private Hashtable<Combo, Integer> combos_pedidos_y_su_cantidad;    
    private String mesa;
    private double precio_total_pedido;
    //private LocalDateTime fecha_del_pedido;
    private Empleado mesero;
    private boolean orden_cobrada;
    
    public Pedido(int Codigo, Integer precio_total_pedido, Hashtable<Comida, Integer> comidas_pedidas_y_su_cantidad, Hashtable<Combo, Integer> combos_pedidos_y_su_cantidad, String mesa/*, LocalDateTime fecha_del_pedido*/, Empleado mesero, boolean orden_cobrada){
        this.Codigo = Codigo;        
        this.comidas_pedidas_y_su_cantidad = comidas_pedidas_y_su_cantidad;
        this.combos_pedidos_y_su_cantidad = combos_pedidos_y_su_cantidad;
        //this.fecha_del_pedido = fecha_del_pedido;
        this.mesa = mesa;
        this.mesero = mesero;
        this.orden_cobrada = orden_cobrada;        
        this.precio_total_pedido = this.calcularPrecioTotalPedido();
    }
    
    public Pedido(){}

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }
    
    public boolean getOrdenCobrada() {
        return orden_cobrada;
    }

    public void setOrdenCobrada(boolean orden_cobrada) {
        this.orden_cobrada = orden_cobrada;
    }

    public double getPrecioTotal() {
        return precio_total_pedido;
    }

    public void setPrecioTotal(Integer precio_total_pedido) {
        this.precio_total_pedido = precio_total_pedido;
    }
    
    public Hashtable<Comida, Integer> getComidas() {
        return comidas_pedidas_y_su_cantidad;
    }

    public void setComidas(Hashtable<Comida, Integer> comidas_pedidas_y_su_cantidad) {
        this.comidas_pedidas_y_su_cantidad = comidas_pedidas_y_su_cantidad;
    }
    
    public Hashtable<Combo, Integer> getCombos() {
        return combos_pedidos_y_su_cantidad;
    }

    public void setCombos(Hashtable<Combo, Integer> combos_pedidos_y_su_cantidad) {
        this.combos_pedidos_y_su_cantidad = combos_pedidos_y_su_cantidad;
    }
    
    /*public LocalDateTime getFechaPedido() {
        return fecha_del_pedido;
    }

    public void setFechaPedido(LocalDateTime fecha_del_pedido) {
        this.fecha_del_pedido = fecha_del_pedido;
    }*/
    
    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }
    
    public Empleado getMesero() {
        return mesero;
    }

    public void setCodigo(Empleado mesero) {
        this.mesero = mesero;
    }
    
    public double calcularPrecioTotalPedido(){
        double precio_total_pedido = 0;
        for ( Map.Entry<Comida, Integer> comida_y_cantidad : comidas_pedidas_y_su_cantidad.entrySet()){
            double cantidad_solicitada_del_producto = comida_y_cantidad.getValue();
            double precio_del_producto = Integer.parseInt(comida_y_cantidad.getKey().getPrecio());
            precio_total_pedido += cantidad_solicitada_del_producto * precio_del_producto;
        }
        
        for ( Map.Entry<Combo, Integer> combo_y_cantidad : combos_pedidos_y_su_cantidad.entrySet()){
            double cantidad_solicitada_del_producto = combo_y_cantidad.getValue();
            double precio_del_producto = combo_y_cantidad.getKey().getPrecio();
            precio_total_pedido += cantidad_solicitada_del_producto * precio_del_producto;
        }
        
        return precio_total_pedido;
    }
}
