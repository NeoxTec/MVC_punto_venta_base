/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import bd.ConnectDatabase;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private int iva;
    private String descripcion;
    private double precio_unitario;
    private double precio_mayoreo;
    private String unidad_medida;
    DefaultTableModel modelo = new DefaultTableModel();

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }
    
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

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
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

    
 public void conectarDB() {
        try {
           conexion = ConnectDatabase.getConectar();
           st = conexion.createStatement();
           rs = st.executeQuery("SELECT * FROM catalogo;");
           rs.next();
           codigo_barras = rs.getInt("codigo_barras");
           nombre =rs.getString("nombre");
           descripcion = rs.getString("descripcion");
           precio_unitario =  rs.getDouble("precio");
           precio_mayoreo =  rs.getDouble("precio_mayoreo");
           unidad_medida = rs.getString("unidad");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelCatalogo001: " + err.getMessage());
            System.out.println(err.getMessage());
        }
    }
         public void llenartabla(){
        rs = ConnectDatabase.getTabla("SELECT id,nombre,descripcion,iva,precio, precio_mayoreo,unidad FROM catalogo");
        modelo.setColumnIdentifiers(new Object[]{"Id","Nombre", "Precio unitario", "Precio mayoreo", "Unidad de medida", "Capacidad"});
        try {
           while (rs.next()){
            modelo.addRow(new Object[]{
                rs.getInt("id"), 
                rs.getString("nombre"), 
                rs.getString("descripcion"),
                rs.getString("iva"),
                rs.getDouble("precio"),
                rs.getDouble("precio_mayoreo"),
                rs.getString("unidad")});
        }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error modelCatalogo002 " + e.getMessage());
        }
    }
         public void datos(){
 
        try {
            rs = st.executeQuery("SELECT * FROM catalogo where id ="+id+";");
           rs.first();
           codigo_barras = rs.getInt("codigo_barras");
           nombre =rs.getString("nombre");
           descripcion = rs.getString("descripcion");
           precio_unitario =  rs.getDouble("precio");
           precio_mayoreo =  rs.getDouble("precio_mayoreo");
           unidad_medida = rs.getString("unidad");
            System.out.println(nombre);
        } catch (SQLException ex) {
            Logger.getLogger(modelCatalogo.class.getName()).log(Level.SEVERE, null, ex);}  
         }
}
