/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import controlador.ControladorTienda;
import modelo.Prenda;

import javax.swing.JOptionPane;
import java.awt.Component;

public class VistaConsultar {
    public static void mostrar(Component parent, ControladorTienda controlador) {
        String codigo = JOptionPane.showInputDialog(parent, "Codigo de la prenda:");
        if (codigo == null) {
            return;
        }
        Prenda prenda = controlador.getCatalogo().buscarPorCodigo(codigo.trim());
        if (prenda == null) {
            JOptionPane.showMessageDialog(parent, "No existe una prenda con ese codigo.");
        } else {
            JOptionPane.showMessageDialog(parent, prenda.mostrarInformacion(),
                    "Consulta de prenda", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
