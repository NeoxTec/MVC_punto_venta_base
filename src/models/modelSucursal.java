/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author oscar
 */
public class modelSucursal {

    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public PreparedStatement getPs() {
        return ps;
    }

    public void setPs(PreparedStatement ps) {
        this.ps = ps;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    private String id;
    private String calle;
    private String colonia;
    private String noexterior;
    private String nointerior;
    private String cp;
    private String telefono;


    //COMIENZA EL CODIGO A BASE DE DATOS Y TERMINAN SETTERS Y GETTERS 

    public String getNoexterior() {
        return noexterior;
    }

    public void setNoexterior(String noexterior) {
        this.noexterior = noexterior;
    }

    public String getNointerior() {
        return nointerior;
    }

    public void setNointerior(String nointerior) {
        this.nointerior = nointerior;
    }

    public void conectarDB() {
        try {
          //  conexion = ConnectDatabase.getConectar();
            conexion = DriverManager.getConnection("jdbc:mysql://tic41.ddns.net/quetzalstock", "quetzal", "quetzal.2018");
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT * FROM sucursal;");
            rs.next();
            id = rs.getString("id");
           
            calle=rs.getString("calle");
            colonia=rs.getString("colonia");
            noexterior=rs.getString("noexterior");
            nointerior=rs.getString("nointerior");
            cp=rs.getString("cp");
            telefono=rs.getString("telefono");
            
            
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelSucursal 001: " + err.getMessage());
       System.out.println(err.getMessage());
        }
    }
public void eliRegistro() {
        try {
            String sql = "DELETE FROM sucursal  WHERE id = '"+ id +"'; ";
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar este registro?", "Borrar", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                id = rs.getString("id");
                st.executeUpdate(sql);
                
                this.conectarDB();
                
            }
            else {
                this.conectarDB();
                
            }
        }
        catch(SQLException err) { 
            JOptionPane.showMessageDialog(null,"Error en metodo eliminar"+err.getMessage()); 
        }
    }
public void insertarRegistro() {
        
        try {
            
            String sql =  "INSERT INTO sucursal (id, calle, colonia, no_ext,no_int, cp, telefono)" + " VALUES ('"+ id +"','"+calle+"','"+colonia +"','"+ noexterior+"','"+ nointerior +"','"+ cp +"','"+ telefono +"');";
            System.out.println(sql);
            st.executeUpdate(sql);
            
            JOptionPane.showMessageDialog(null, "Felicidades registro guardado.");
            //this.conectarDB();
            
        }
        catch(SQLException err) { 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        }
        System.out.println("registro guardado");
    }

 public void modiRegistro() {
         System.out.println("registro modificado");

        try {
          String sql = "UPDATE sucursal SET calle = '"+ calle +"',colonia = '"+ colonia +"',noexterior = '"+ noexterior +"',nointerior = '"+ nointerior +"'cp = '"+ cp +"', telefono = '"+ telefono +"' WHERE id = '"+ id +"'; ";
            System.out.println(sql);
          st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Se modifico correctamente el registro.");
            this.conectarDB();
            
        }
        catch(SQLException err) { 
            JOptionPane.showMessageDialog(null,"Error al modificar registr9 "+err.getMessage()); 
        }
 }
}

