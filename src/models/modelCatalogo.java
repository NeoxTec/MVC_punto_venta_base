/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author manl_
 */
public class modelCatalogo {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    
    private int id;
    private int codigo_barras;
    private String nombre;
    private String iva;
    private String descripcion;
    private double precio_unitario;
    private double precio_mayoreo;
    private String unidad_medida;
    private double capacidad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo_barras() {
        return codigo_barras;
    }

    public void setCodigo_barras(int codigo_barras) {
        this.codigo_barras = codigo_barras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public double getPrecio_mayoreo() {
        return precio_mayoreo;
    }

    public void setPrecio_mayoreo(double precio_mayoreo) {
        this.precio_mayoreo = precio_mayoreo;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }
    
    
}
