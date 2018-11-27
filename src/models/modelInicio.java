/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import bd.ConnectDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class modelInicio {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    
    
    private String username;
    private String pass;
    private String tipo;
    private int validacion;
    private int id_sucursal;
    private String rfc_e;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getValidacion() {
        return validacion;
    }

    public void setValidacion(int validacion) {
        this.validacion = validacion;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public String getRfc_e() {
        return rfc_e;
    }

    public void setRfc_e(String rfc_e) {
        this.rfc_e = rfc_e;
    }
    public void conectarDB() {
        try {
           conexion = ConnectDatabase.getConectar();
           st = conexion.createStatement();
           rs = st.executeQuery("SELECT tipo FROM usuario;");
           rs.next();
           tipo = rs.getString("tipo");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelCatalogo001: " + err.getMessage());
            System.out.println(err.getMessage());
        }
    }
    public int Login(){
        
        ConnectDatabase.getConectar();
        String sql = "SELECT username,pass  FROM usuario WHERE username = ? AND password = ?";
        try{
               ps = conexion.prepareStatement(sql);
               ps.setString(1,username);
               ps.setString(2,pass);
               rs = ps.executeQuery();
               
               if(rs.next()){
                   return rs.getInt(1);  
               } 
                   return 1;
               
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Error inicio_sesión: " + ex.getMessage());
               return 1;
           }
    } 
}
