
package Vista;

import controlador.ControladorTienda;
import controlador.GestorArchivos;
import modelo.Prenda;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class MenuPrincipal extends JFrame {
    private final ControladorTienda controlador;
    private final GestorArchivos gestorArchivos;

    public MenuPrincipal() {
        super("Sistema de Venta de Ropa");
        controlador = new ControladorTienda();
        gestorArchivos = new GestorArchivos();
        gestorArchivos.cargarInventario(controlador.getCatalogo());
        controlador.establecerDescuentoGlobal(gestorArchivos.cargarDescuento());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520, 360);
        setLocationRelativeTo(null);
        construirInterfaz();
    }

    private void construirInterfaz() {
        JLabel titulo = new JLabel("Administracion de tienda", JLabel.CENTER);
        JPanel opciones = new JPanel(new GridLayout(4, 2, 10, 10));

        opciones.add(crearBoton("Agregar prenda", event -> agregarPrenda()));
        opciones.add(crearBoton("Listar prendas", event -> VistaListar.mostrar(this, controlador)));
        opciones.add(crearBoton("Consultar prenda", event -> VistaConsultar.mostrar(this, controlador)));
        opciones.add(crearBoton("Editar precios", event -> VistaEditarPrecios.mostrar(this, controlador, gestorArchivos)));
        opciones.add(crearBoton("Actualizar stock", event -> VistaStock.mostrar(this, controlador, gestorArchivos)));
        opciones.add(crearBoton("Registrar venta", event -> VistaVentas.mostrar(this, controlador, gestorArchivos)));
        opciones.add(crearBoton("Configurar descuento", event -> VistaConfiguracion.mostrar(this, controlador, gestorArchivos)));
        opciones.add(crearBoton("Salir", event -> salir()));

        add(titulo, BorderLayout.NORTH);
        add(opciones, BorderLayout.CENTER);
    }

    private JButton crearBoton(String texto, java.awt.event.ActionListener listener) {
        JButton boton = new JButton(texto);
        boton.addActionListener(listener);
        return boton;
    }

    private void agregarPrenda() {
        String codigo = JOptionPane.showInputDialog(this, "Codigo:");
        if (codigo == null || codigo.trim().isEmpty()) {
            return;
        }
        String nombre = JOptionPane.showInputDialog(this, "Nombre:");
        String marca = JOptionPane.showInputDialog(this, "Marca:");
        String categoria = JOptionPane.showInputDialog(this, "Categoria:");
        String talla = JOptionPane.showInputDialog(this, "Talla:");
        String color = JOptionPane.showInputDialog(this, "Color:");
        String precioTexto = JOptionPane.showInputDialog(this, "Precio:");
        String stockTexto = JOptionPane.showInputDialog(this, "Stock:");

        if (nombre == null || marca == null || categoria == null || talla == null
                || color == null || precioTexto == null || stockTexto == null) {
            return;
        }

        try {
            double precio = Double.parseDouble(precioTexto);
            int stock = Integer.parseInt(stockTexto);
            Prenda prenda = new Prenda(codigo.trim(), nombre, marca, categoria, talla, color, precio, stock);
            if (precio <= 0 || stock < 0) {
                JOptionPane.showMessageDialog(this, "Precio y stock deben tener valores validos.");
                return;
            }
            if (controlador.getCatalogo().agregarPrenda(prenda)) {
                gestorArchivos.guardarInventario(controlador.getCatalogo());
                JOptionPane.showMessageDialog(this, "Prenda agregada.");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo agregar: codigo duplicado o catalogo lleno.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Precio o stock invalido.");
        }
    }

    private void salir() {
        gestorArchivos.guardarInventario(controlador.getCatalogo());
        gestorArchivos.guardarDescuento(controlador.obtenerDescuentoGlobal());
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuPrincipal().setVisible(true));
    }
}