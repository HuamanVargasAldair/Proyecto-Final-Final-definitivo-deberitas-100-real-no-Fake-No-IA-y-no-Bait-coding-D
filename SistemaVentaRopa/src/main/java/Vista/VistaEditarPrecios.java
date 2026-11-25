/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import controlador.ControladorTienda;
import controlador.GestorArchivos;

import javax.swing.JOptionPane;
import java.awt.Component;

public class VistaEditarPrecios {
    public static void mostrar(Component parent, ControladorTienda controlador,
                               GestorArchivos gestorArchivos) {
        String codigo = JOptionPane.showInputDialog(parent, "Codigo de la prenda:");
        if (codigo == null) {
            return;
        }
        if (controlador.getCatalogo().buscarPorCodigo(codigo.trim()) == null) {
            JOptionPane.showMessageDialog(parent, "No existe una prenda con ese codigo.");
            return;
        }
        String textoPrecio = JOptionPane.showInputDialog(parent, "Nuevo precio:");
        if (textoPrecio == null) {
            return;
        }
        try {
            double nuevoPrecio = Double.parseDouble(textoPrecio);
            if (controlador.getCatalogo().actualizarPrecio(codigo.trim(), nuevoPrecio)) {
                gestorArchivos.guardarInventario(controlador.getCatalogo());
                JOptionPane.showMessageDialog(parent, "Precio actualizado.");
            } else {
                JOptionPane.showMessageDialog(parent, "El precio debe ser mayor que cero.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(parent, "Precio invalido.");
        }
    }
}
