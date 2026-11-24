/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author HuamanVargasAldair
 */

public class Venta{
    
    private LocalDate fecha;
    private DetalleVenta[] detalles;
    private int numeroVenta, cantidadDetalles;
    private double subtotal, descuento, total;

    public Venta(int numeroVenta){

        this.numeroVenta = numeroVenta;
        this.fecha = LocalDate.now();

        this.detalles = new DetalleVenta[20];
        this.cantidadDetalles = 0;

        this.subtotal = 0;
        this.descuento = 0;
        this.total = 0;
    }

    public boolean agregarDetalle(DetalleVenta detalle){

        if (detalle == null || cantidadDetalles >= detalles.length){
            return false;
        }

        detalles[cantidadDetalles] = detalle;
        cantidadDetalles++;

        return true;
    }

    public int getNumeroVenta(){
        return numeroVenta;
    }

    public LocalDate getFecha(){
        return fecha;
    }

    public int getCantidadDetalles(){
        return cantidadDetalles;
    }

    public double getSubtotal(){
        return subtotal;
    }

    public double getDescuento(){
        return descuento;
    }

    public double getTotal(){
        return total;
    }

    public double calcularSubtotal(){

        subtotal = 0;

        for (int i = 0; i < cantidadDetalles; i++){
            
            subtotal += detalles[i].calcularSubtotal();
        }

        return subtotal;
    }

    public double calcularDescuento(double porcentaje){

        if (porcentaje < 0 || porcentaje > 100){
            
            descuento = 0;
            return descuento;
        }

        descuento = calcularSubtotal() * porcentaje / 100;

        return descuento;
    }

    public double calcularTotal(){

        total = calcularSubtotal() - descuento;

        return total;
    }

    public String generarComprobante(){

        StringBuilder sb = new StringBuilder();

        sb.append("================================\n");
        sb.append("       TIENDA DE ROPA\n");
        sb.append("================================\n");

        sb.append("Número de venta: ").append(numeroVenta).append("\n");
        sb.append("Fecha: ").append(fecha).append("\n");

        sb.append("--------------------------------\n");
        sb.append("          PRODUCTOS\n");
        sb.append("--------------------------------\n");

        for (int i = 0; i < cantidadDetalles; i++){

            sb.append(detalles[i].mostrarDetalle());
            sb.append("\n");
        }

        sb.append("--------------------------------\n");

        sb.append("Subtotal: S/ ").append(calcularSubtotal()).append("\n");
        sb.append("Descuento: S/ ").append(descuento).append("\n");
        sb.append("TOTAL: S/ ").append(calcularTotal()).append("\n");

        sb.append("================================\n");
        sb.append("       GRACIAS POR SU COMPRA\n");
        sb.append("================================\n");

        return sb.toString();
    }
}
