/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.Prenda;
/**
 *
 * @author bet17
 */
public class CatalogoPrendas {
    private Prenda[] prendas;
    private int cantidadPrendas;

    public CatalogoPrendas() {
        this.prendas = new Prenda[50];
        this.cantidadPrendas = 0;
    }

    public CatalogoPrendas(int capacidad) {
        if (capacidad > 0) {
            this.prendas = new Prenda[capacidad];
        } else {
            this.prendas = new Prenda[50];
        }
        this.cantidadPrendas = 0;
    }

    public boolean agregarPrenda(Prenda prenda) {
        if (prenda == null || cantidadPrendas >= prendas.length) {
            return false;
        }
        if (buscarPorCodigo(prenda.getCodigo()) != null) {
            return false;
        }
        prendas[cantidadPrendas] = prenda;
        cantidadPrendas++;
        return true;
    }

    public Prenda buscarPorCodigo(String codigo) {
        if (codigo == null) {
            return null;
        }
        for (int i = 0; i < cantidadPrendas; i++) {
            if (prendas[i].getCodigo().equalsIgnoreCase(codigo)) {
                return prendas[i];
            }
        }
        return null;
    }

    public boolean actualizarStock(String codigo, int nuevoStock) {
        Prenda prenda = buscarPorCodigo(codigo);
        if (prenda == null || nuevoStock < 0) {
            return false;
        }
        prenda.setStock(nuevoStock);
        return true;
    }

    public Prenda[] listarPrendas() {
        Prenda[] actuales = new Prenda[cantidadPrendas];
        for (int i = 0; i < cantidadPrendas; i++) {
            actuales[i] = prendas[i];
        }
        return actuales;
    }

    public int getCantidadPrendas() {
        return cantidadPrendas;
    }
}
