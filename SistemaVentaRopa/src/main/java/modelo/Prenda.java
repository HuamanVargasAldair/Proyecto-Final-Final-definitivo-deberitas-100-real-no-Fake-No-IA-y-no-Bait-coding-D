/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author HuamanVargasAldair
 */

public class Prenda{

    private String codigo, nombre, marca, categoria, talla, color;
    private double precio;
    private int stock;

    public Prenda(String codigo, String nombre, String marca,
                  String categoria, String talla, String color,
                  double precio, int stock){

        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.categoria = categoria;
        this.talla = talla;
        this.color = color;
        this.precio = precio;
        this.stock = stock;
    }
    
    public String getCodigo(){
        return codigo;
    }

    public String getNombre(){
        return nombre;
    }

    public String getMarca(){
        return marca;
    }

    public String getCategoria(){
        return categoria;
    }

    public String getTalla(){
        return talla;
    }

    public String getColor(){
        return color;
    }

    public double getPrecio(){
        return precio;
    }

    public int getStock(){
        return stock;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    public void setTalla(String talla){
        this.talla = talla;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setPrecio(double precio){
        
        if (precio > 0){
            this.precio = precio;
        }
    }

    public void setStock(int stock){
        
        if (stock >= 0){
            this.stock = stock;
        }
    }

    public String mostrarInformacion(){

        return "Código: " + codigo
                + "\nNombre: " + nombre
                + "\nMarca: " + marca
                + "\nCategoría: " + categoria
                + "\nTalla: " + talla
                + "\nColor: " + color
                + "\nPrecio: S/ " + precio
                + "\nStock: " + stock;
    }
}
