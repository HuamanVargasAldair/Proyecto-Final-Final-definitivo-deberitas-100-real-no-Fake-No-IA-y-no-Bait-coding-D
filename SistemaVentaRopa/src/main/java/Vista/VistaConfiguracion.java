/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import controlador.ControladorTienda;
import controlador.GestorArchivos;

import javax.swing.JOptionPane;
import java.awt.Component;

public class VistaConfiguracion {
    public static void mostrar(Component parent, ControladorTienda controlador,
                               GestorArchivos gestorArchivos) {
        String texto = JOptionPane.showInputDialog(parent, "Descuento global (%)",
                controlador.obtenerDescuentoGlobal());
        if (texto == null) {
            return;
        }
        try {
            double porcentaje = Double.parseDouble(texto);
            if (porcentaje < 0 || porcentaje > 100) {
                JOptionPane.showMessageDialog(parent, "El descuento debe estar entre 0 y 100.");
                return;
            }
            controlador.establecerDescuentoGlobal(porcentaje);
            gestorArchivos.guardarDescuento(porcentaje);
            JOptionPane.showMessageDialog(parent, "Descuento actualizado.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(parent, "Porcentaje invalido.");
        }
    }
}
