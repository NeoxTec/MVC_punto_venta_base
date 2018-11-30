/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Diego
 */
public class modelVendedor {
    private String fecha;
    private int sucursal;
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }
    
}
