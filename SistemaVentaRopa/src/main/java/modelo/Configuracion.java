/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author HuamanVargasAldair
 */

public class Configuracion{

    private double porcentajeDescuento;

    public Configuracion(){
        this.porcentajeDescuento = 0;
    }

    public Configuracion(double porcentajeDescuento){
        setPorcentajeDescuento(porcentajeDescuento);
    }

    public double getPorcentajeDescuento(){
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento){

        if (porcentajeDescuento >= 0 && porcentajeDescuento <= 100){
            this.porcentajeDescuento = porcentajeDescuento;
        }
    }
}
