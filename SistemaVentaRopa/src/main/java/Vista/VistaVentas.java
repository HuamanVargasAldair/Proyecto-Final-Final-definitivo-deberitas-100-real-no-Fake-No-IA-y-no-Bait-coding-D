/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import controlador.ControladorTienda;
import controlador.GestorArchivos;
import modelo.Venta;

import javax.swing.JOptionPane;
import java.awt.Component;

public class VistaVentas {
    public static void mostrar(Component parent, ControladorTienda controlador,
                               GestorArchivos gestorArchivos) {
        Venta venta = controlador.crearVenta();

        while (true) {
            String codigo = JOptionPane.showInputDialog(parent, "Codigo de la prenda:");
            if (codigo == null) {
                return;
            }
            String textoCantidad = JOptionPane.showInputDialog(parent, "Cantidad:");
            if (textoCantidad == null) {
                return;
            }

            try {
                int cantidad = Integer.parseInt(textoCantidad);
                if (!controlador.agregarProductoAVenta(venta, codigo.trim(), cantidad)) {
                    JOptionPane.showMessageDialog(parent,
                            "No existe la prenda, la cantidad es invalida o no hay stock suficiente.");
                } else {
                    JOptionPane.showMessageDialog(parent, "Producto agregado.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(parent, "Cantidad invalida.");
                continue;
            }

            int continuar = JOptionPane.showConfirmDialog(parent,
                    "Agregar otro producto?", "Venta", JOptionPane.YES_NO_OPTION);
            if (continuar != JOptionPane.YES_OPTION) {
                break;
            }
        }

        String comprobante = controlador.finalizarVenta(venta);
        if (comprobante == null) {
            JOptionPane.showMessageDialog(parent, "La venta no contiene productos.");
            return;
        }
        gestorArchivos.guardarInventario(controlador.getCatalogo());
        Venta ultimaVenta = controlador.listarVentas()[controlador.getCantidadVentas() - 1];
        gestorArchivos.guardarVenta(ultimaVenta);
        JOptionPane.showMessageDialog(parent, comprobante,
                "Comprobante", JOptionPane.INFORMATION_MESSAGE);
    }
}
