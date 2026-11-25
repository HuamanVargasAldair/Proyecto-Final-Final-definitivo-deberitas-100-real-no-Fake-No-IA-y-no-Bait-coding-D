/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import controlador.ControladorTienda;
import controlador.GestorArchivos;

import javax.swing.JOptionPane;
import java.awt.Component;

public class VistaStock {
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
        String textoStock = JOptionPane.showInputDialog(parent, "Nuevo stock:");
        if (textoStock == null) {
            return;
        }
        try {
            int nuevoStock = Integer.parseInt(textoStock);
            if (controlador.getCatalogo().actualizarStock(codigo.trim(), nuevoStock)) {
                gestorArchivos.guardarInventario(controlador.getCatalogo());
                JOptionPane.showMessageDialog(parent, "Stock actualizado.");
            } else {
                JOptionPane.showMessageDialog(parent, "El stock no puede ser negativo.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(parent, "Stock invalido.");
        }
    }
}
