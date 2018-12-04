/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import javax.swing.table.DefaultTableModel;
import bd.ConnectDatabase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class modelCompras {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    
    private String no_factura;
    private String rfc_prov;
    private String fecha;
    private Object forma_pago;
    private Object estado_factura;
    private double total;
    private int sucursal;
    DefaultTableModel table_compra = new DefaultTableModel();
    DefaultTableModel table_prov = new DefaultTableModel();

    public String getNo_factura() {
        return no_factura;
    }

    public void setNo_factura(String no_factura) {
        this.no_factura = no_factura;
    }

    public String getRfc_prov() {
        return rfc_prov;
    }

    public void setRfc_prov(String rfc_prov) {
        this.rfc_prov = rfc_prov;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Object getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(Object forma_pago) {
        this.forma_pago = forma_pago;
    }

    public Object getEstado_factura() {
        return estado_factura;
    }

    public void setEstado_factura(Object estado_factura) {
        this.estado_factura = estado_factura;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }

    public DefaultTableModel getTable_compra() {
        return table_compra;
    }

    public void setTable_compra(DefaultTableModel table_compra) {
        this.table_compra = table_compra;
    }

    public DefaultTableModel getTable_prov() {
        return table_prov;
    }

    public void setTable_prov(DefaultTableModel table_prov) {
        this.table_prov = table_prov;
    }
    
    
     public void conectarDB() {
        try {
           conexion = ConnectDatabase.getConectar();
           st = conexion.createStatement();
           rs = st.executeQuery("SELECT * FROM  compra;");
           rs.next();
           sucursal = rs.getInt("id_sucursal");
           no_factura =rs.getString("no_factura");
           rfc_prov = rs.getString("rfc_proveedor");
           fecha =  rs.getString("fecha");
           total =  rs.getDouble("total");
           forma_pago = rs.getObject("forma_pago");
           estado_factura = rs.getObject("estado_factura");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelCompra001: " + err.getMessage());
            System.out.println(err.getMessage());
        }
    }
}
