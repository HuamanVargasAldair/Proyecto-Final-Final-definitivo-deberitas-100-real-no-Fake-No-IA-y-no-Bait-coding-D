/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author HuamanVargasAldair
 */

public class DetalleVenta{

    private Prenda prenda;
    private int cantidad;
    private double precioUnitario;

    public DetalleVenta(Prenda prenda, int cantidad){

        this.prenda = prenda;
        this.cantidad = cantidad;
        this.precioUnitario = prenda.getPrecio();
    }

    public Prenda getPrenda(){
        return prenda;
    }

    public int getCantidad(){
        return cantidad;
    }

    public double getPrecioUnitario(){
        return precioUnitario;
    }

    public void setCantidad(int cantidad){
        
        if (cantidad > 0){
            this.cantidad = cantidad;
        }
    }

    public double calcularSubtotal(){
        return precioUnitario * cantidad;
    }

    public String mostrarDetalle(){

        return prenda.getNombre()
                + " | Marca: " + prenda.getMarca()
                + " | Cantidad: " + cantidad
                + " | Precio: S/ " + precioUnitario
                + " | Subtotal: S/ " + calcularSubtotal();
    }
}
