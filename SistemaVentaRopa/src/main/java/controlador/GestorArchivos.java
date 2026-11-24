/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import modelo.Prenda;
import modelo.Venta;
/**
 *
 * @author bet17
 */
public class GestorArchivos {
    private String archivoInventario = "inventario.txt";
    private String archivoDescuento = "descuento.txt";
    private String archivoVentas = "ventas.txt";

    public void guardarInventario(CatalogoPrendas catalogo) {
        Prenda[] prendas = catalogo.listarPrendas();
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivoInventario))) {
            for (int i = 0; i < prendas.length; i++) {
                Prenda p = prendas[i];
                pw.println(p.getCodigo() + ";" + p.getNombre() + ";" + p.getMarca() + ";"
                        + p.getCategoria() + ";" + p.getTalla() + ";" + p.getColor() + ";"
                        + p.getPrecio() + ";" + p.getStock());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar inventario: " + e.getMessage());
        }
    }

    public void cargarInventario(CatalogoPrendas catalogo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoInventario))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] d = linea.split(";");
                if (d.length == 8) {
                    Prenda p = new Prenda(
                            d[0], d[1], d[2], d[3], d[4], d[5],
                            Double.parseDouble(d[6]),
                            Integer.parseInt(d[7])
                    );
                    catalogo.agregarPrenda(p);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar inventario: " + e.getMessage());
        }
    }

    public void guardarDescuento(double porcentaje) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivoDescuento))) {
            pw.println(porcentaje);
        } catch (IOException e) {
            System.out.println("Error al guardar descuento: " + e.getMessage());
        }
    }

    public double cargarDescuento() {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoDescuento))) {
            String linea = br.readLine();
            if (linea != null) {
                return Double.parseDouble(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar descuento: " + e.getMessage());
        }
        return 0;
    }

    public void guardarVenta(Venta venta) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivoVentas, true))) {
            pw.println(venta.generarComprobante());
        } catch (IOException e) {
            System.out.println("Error al guardar venta: " + e.getMessage());
        }
    }   
}
