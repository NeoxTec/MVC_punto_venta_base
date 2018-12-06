/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import bd.ConnectDatabase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego
 */
public class modelUsuario {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    
    private String username;
    private Object tipo;
    private int sucursal;
    private String rfc_e;
    
    private String sentencia;
    private DefaultTableModel modelo = new DefaultTableModel();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Object getTipo() {
        return tipo;
    }

    public void setTipo(Object tipo) {
        this.tipo = tipo;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }

    public String getRfc_e() {
        return rfc_e;
    }

    public void setRfc_e(String rfc_e) {
        this.rfc_e = rfc_e;
    }

    public String getSentencia() {
        return sentencia;
    }

    public void setSentencia(String sentencia) {
        this.sentencia = sentencia;
    }
    
    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }
  /**
  * Metodo para crear una conexion a la base de datos y ver registros de la tabla catalogo.
  * Permite tener los valores del primer registro del catalogo.
  */
 public void conectarDB() {
        try {
           conexion = ConnectDatabase.getConectar();
           st = conexion.createStatement();
           rs = st.executeQuery("SELECT username,tipo,id_sucursal,rfc_e FROM usuario;");
           rs.next();
           setValues();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelUsuario001: " + err.getMessage());
            System.out.println(err.getMessage());
        }
    }
 
 /**
  * Metodo que llena la tabla con los registros existentes de la base de datos.
  */
         public void llenartabla(){
        rs = ConnectDatabase.getTabla(sentencia);
        modelo.setColumnIdentifiers(new Object[]{"Usename","Tipo", "Sucursal", "RFC"});
        try {
           while (rs.next()){
            modelo.addRow(new Object[]{
                rs.getString("username"), 
                rs.getString("tipo"), 
                rs.getInt("id_sucursal"),
                rs.getString("rfc_e")});
        }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error modelUsuario002 " + e.getMessage());
        }
    }
 
    /*
    * Método que     
    */
    public void setValues(){
        try{
            username = rs.getString("username");
            tipo = rs.getObject("tipo");
            sucursal = rs.getInt("id_sucursal");
            rfc_e = rs.getString("rfc_e");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error modelUsuario003" + e.getMessage());
        }
    }
    
    public void datos(){
        try{
            rs = st.executeQuery("SELECT username,tipo,id_sucursal,rfc_e FROM usuario WHERE username = '"+username+"';");
            rs.first();
            setValues();
        }catch(SQLException e){   
        }
        
    }
}
