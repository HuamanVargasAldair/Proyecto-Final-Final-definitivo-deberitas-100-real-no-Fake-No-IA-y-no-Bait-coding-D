/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.Configuracion;
import modelo.DetalleVenta;
import modelo.Prenda;
import modelo.Venta;
/**
 *
 * @author bet17
 */
public class ControladorTienda {
    private CatalogoPrendas catalogo;
    private Venta[] ventas;
    private int cantidadVentas;
    private int siguienteNumeroVenta;
    private Configuracion configuracion;

    public ControladorTienda() {
        this.catalogo = new CatalogoPrendas();
        this.ventas = new Venta[100];
        this.cantidadVentas = 0;
        this.siguienteNumeroVenta = 1;
        this.configuracion = new Configuracion();
    }

    public ControladorTienda(CatalogoPrendas catalogo, int capacidadVentas) {
        this.catalogo = (catalogo != null) ? catalogo : new CatalogoPrendas();
        this.ventas = (capacidadVentas > 0) ? new Venta[capacidadVentas] : new Venta[100];
        this.cantidadVentas = 0;
        this.siguienteNumeroVenta = 1;
        this.configuracion = new Configuracion();
    }

    public CatalogoPrendas getCatalogo() {
        return catalogo;
    }

    public Configuracion getConfiguracion() {
        return configuracion;
    }

    public void establecerDescuentoGlobal(double porcentaje) {
        configuracion.setPorcentajeDescuento(porcentaje);
    }

    public double obtenerDescuentoGlobal() {
        return configuracion.getPorcentajeDescuento();
    }

    public Venta crearVenta() {
        return new Venta(siguienteNumeroVenta);
    }

    public boolean agregarProductoAVenta(Venta venta, String codigoPrenda, int cantidad) {
        if (venta == null || cantidad <= 0) {
            return false;
        }

        Prenda prenda = catalogo.buscarPorCodigo(codigoPrenda);
        if (prenda == null || prenda.getStock() < cantidad) {
            return false;
        }

        DetalleVenta detalle = new DetalleVenta(prenda, cantidad);
        if (!venta.agregarDetalle(detalle)) {
            return false;
        }

        prenda.setStock(prenda.getStock() - cantidad);
        return true;
    }

    public String finalizarVenta(Venta venta) {
        if (venta == null || venta.getCantidadDetalles() == 0) {
            return null;
        }

        venta.calcularSubtotal();
        venta.calcularDescuento(configuracion.getPorcentajeDescuento());
        venta.calcularTotal();

        if (cantidadVentas < ventas.length) {
            ventas[cantidadVentas] = venta;
            cantidadVentas++;
        }
        siguienteNumeroVenta++;

        return venta.generarComprobante();
    }

    public Venta[] listarVentas() {
        Venta[] realizadas = new Venta[cantidadVentas];
        for (int i = 0; i < cantidadVentas; i++) {
            realizadas[i] = ventas[i];
        }
        return realizadas;
    }

    public int getCantidadVentas() {
        return cantidadVentas;
    }
}
