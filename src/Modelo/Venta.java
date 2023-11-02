/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDateTime;
import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author User
 */
public class Venta {
    private int codigo;
    private Pedido pedido;
    private String nombre_cliente;
    private double iva;
    private double precio_final;
    private String metodo_pago;
    private LocalDateTime fecha_venta;    
    
    public Venta(int codigo, Pedido pedido, String nombre_cliente, String metodo_pago, LocalDateTime fecha_venta){
        this.codigo = codigo;
        this.pedido = pedido;
        this.nombre_cliente = nombre_cliente;
        this.metodo_pago = metodo_pago;
        this.fecha_venta = fecha_venta;
        this.calcularPrecioFinal();
        this.pedido.setOrdenCobrada(true);
    }

    public Venta(){}
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getMetodoPago() {
        return this.metodo_pago;
    }

    public void setMetodoPago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public double getPrecioFinal() {
        calcularPrecioFinal();
        return this.precio_final;
    }

    public void setPrecioFinal(double precio_final) {
        this.precio_final = precio_final;
    }
    
    public LocalDateTime getFechaPedido() {
        return fecha_venta;
    }

    public void setFechaPedido(LocalDateTime fecha_venta) {
        this.fecha_venta = fecha_venta;
    }
    
    public void calcularIVAVenta(){
        //iva en venezuela es del 16%
        this.iva = this.pedido.calcularPrecioTotalPedido() * 0.16;
    }
    
    public void calcularPrecioFinal(){
        this.calcularIVAVenta();
        this.precio_final = this.pedido.calcularPrecioTotalPedido() + iva;
    }
   
    public String getNombreCompletoCliente() {
        return this.nombre_cliente;
    }

    public String setNombreCompletoCliente(String nombre_cliente) {
        return this.nombre_cliente = nombre_cliente;
    }
}
