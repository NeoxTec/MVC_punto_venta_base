/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego
 */
public class modelDetalleCompra {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    
    private String factura;
    private int producto;
    private double subtotal;
    private double total;
    private int cantidad;
    private double total_final;
    private String sentencia;
    DefaultTableModel productos = new DefaultTableModel();
    DefaultTableModel registros = new DefaultTableModel();
    ArrayList listar_reg = new ArrayList();

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal_final() {
        return total_final;
    }

    public void setTotal_final(double total_final) {
        this.total_final = total_final;
    }

    public String getSentencia() {
        return sentencia;
    }

    public void setSentencia(String sentencia) {
        this.sentencia = sentencia;
    }

    public DefaultTableModel getProductos() {
        return productos;
    }

    public void setProductos(DefaultTableModel productos) {
        this.productos = productos;
    }

    public DefaultTableModel getRegistros() {
        return registros;
    }

    public void setRegistros(DefaultTableModel registros) {
        this.registros = registros;
    }

    public ArrayList getListar_reg() {
        return listar_reg;
    }

    public void setListar_reg(ArrayList listar_reg) {
        this.listar_reg = listar_reg;
    }
}
