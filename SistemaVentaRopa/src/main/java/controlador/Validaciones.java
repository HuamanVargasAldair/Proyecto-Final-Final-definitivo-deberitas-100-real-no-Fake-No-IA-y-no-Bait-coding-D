/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author bet17
 */
public class Validaciones {
    public boolean textoNoVacio(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    public boolean precioValido(double precio) {
        return precio > 0;
    }

    public boolean stockValido(int stock) {
        return stock >= 0;
    }

    public boolean cantidadValida(int cantidad) {
        return cantidad > 0;
    }

    public boolean descuentoValido(double porcentaje) {
        return porcentaje >= 0 && porcentaje <= 100;
    }
}

