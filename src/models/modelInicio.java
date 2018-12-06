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
    private String passh;
    private String pass1;
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
    
    public int LoginUser(){
        conexion = ConnectDatabase.getConectar();
        String sql = "SELECT count(username) FROM usuario WHERE username = ?";
        try{
               ps = conexion.prepareStatement(sql);
               ps.setString(1,username);
               rs = ps.executeQuery();
               
               if(rs.next()){
                   return rs.getInt(1);  
               } 
                   return 1;
               
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Error inicio_sesión001: " + ex.getMessage());
               return 0;
           }
    } 
    
    public boolean LoginPass(){
        if (LoginUser() == 1){
        conexion = ConnectDatabase.getConectar();
        String sql = "SELECT pass FROM usuario WHERE username = ?";
        try{
            ps = conexion.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            rs.next();
            pass1 = rs.getString("pass");
            passh = hash.sha1(pass);
            if (pass1.equals(passh)){
                 return true;
            }      
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error inicio_sesión002: " + ex.getMessage());
        }
        
      }
        return false;
    }
    
    public void consulta(){
        conexion = ConnectDatabase.getConectar();
        String sql = "SELECT tipo,id_sucursal FROM usuario WHERE username = ?";
        try{
           ps = conexion.prepareStatement(sql);
           ps.setString(1,username);
           rs = ps.executeQuery();
           rs.next();
           tipo = rs.getString("tipo"); 
           id_sucursal =rs.getInt("id_sucursal");
        }catch(SQLException ex){
            
        }
    }
}
