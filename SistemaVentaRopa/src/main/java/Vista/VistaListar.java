/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import controlador.ControladorTienda;
import modelo.Prenda;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;

public class VistaListar {
    public static void mostrar(Component parent, ControladorTienda controlador) {
        Prenda[] prendas = controlador.getCatalogo().listarPrendas();
        String[] columnas = {"Codigo", "Nombre", "Marca", "Categoria", "Talla", "Color", "Precio", "Stock"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        for (Prenda prenda : prendas) {
            modelo.addRow(new Object[]{
                    prenda.getCodigo(), prenda.getNombre(), prenda.getMarca(),
                    prenda.getCategoria(), prenda.getTalla(), prenda.getColor(),
                    prenda.getPrecio(), prenda.getStock()
            });
        }

        JTable tabla = new JTable(modelo);
        tabla.setEnabled(false);
        JOptionPane.showMessageDialog(parent, new JScrollPane(tabla),
                "Inventario", JOptionPane.INFORMATION_MESSAGE);
    }
}
