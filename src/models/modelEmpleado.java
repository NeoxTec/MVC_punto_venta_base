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

/**
 *
 * @author Diego
 */
public class modelEmpleado {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    
    private String rfc;
    private String nombre;
    private String ape_p;
    private String ape_m;
    private String calle;
    private String colonia;
    private int no_ext;
    private int no_int;
    private String cp;
    private String telefono;
    private String correo;
    private String genero;
    private String fecha_n;

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe_p() {
        return ape_p;
    }

    public void setApe_p(String ape_p) {
        this.ape_p = ape_p;
    }

    public String getApe_m() {
        return ape_m;
    }

    public void setApe_m(String ape_m) {
        this.ape_m = ape_m;
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

    public int getNo_ext() {
        return no_ext;
    }

    public void setNo_ext(int no_ext) {
        this.no_ext = no_ext;
    }

    public int getNo_int() {
        return no_int;
    }

    public void setNo_int(int no_int) {
        this.no_int = no_int;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFecha_n() {
        return fecha_n;
    }

    public void setFecha_n(String fecha_n) {
        this.fecha_n = fecha_n;
    }
    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }
    
    /**
     * Método que realiza las siguietnes acciones: 
     * 1- Conecta con la base quetzalstock
     * 2- Consulta todo los registros de la tabla empleados
     * 3- Obtiene los valores de las variables globales.
     */
    public void conectarDB() {
        try {
            conexion = ConnectDatabase.getConectar();
            st = conexion.createStatement();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelCatalogo001: " + err.getMessage());
        }
    }
    
    /**
    * Lee los valores de algun registro obtenido de la consulta, normalmente el primero.
     */
    public void setValues() {
        try {
            rfc = rs.getString("rfc");
            nombre = rs.getString("nombre");
            ape_p = rs.getString("ape_p");
            ape_m = rs.getString("ape_m");
            calle = rs.getString("calle");
            colonia = rs.getString("colonia");
            no_ext = rs.getInt("no_exterior");
            no_int = rs.getInt("no_interior");
            cp = rs.getString("cp");
            telefono = rs.getString("telefono");
            correo = rs.getString("correo");
            genero = rs.getString("genero");
            fecha_n = rs.getString("fecha_nac");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error model 102: " + err.getMessage());

        }
    }
    /**
     * Método que realiza lo siguiente:
     * 1.- Inserta en la tabla un nuevo registro con los valores de las variables
     * 2.- Ejecuta una consulta de datos.
     */
    public void insertarRegistro(){
        try{
            String sql = "INSERT INTO empleado(rfc,nombre,ape_p,ape_m,calle,colonia,no_exterior,no_interior,cp,telefono,correo,genero,fecha_nac)" + "VALUES ('"+ rfc +"','"+ nombre +"','"+ ape_p +"','"+ ape_m +"','"+ calle +"','"+ colonia +"',"+ no_ext +","+ no_int +",'"+cp+"','"+telefono+"','"+correo+"','"+genero+"','"+fecha_n+"');";
            System.out.println(sql);
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Se ha insertado correctamente");
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, "Error ModelAgenda Inserción: " + err.getMessage());
        }
    }
    
    /**
     * Método que realiza lo siguiente:
     * 1.- Almacena un nuevo registro
     * 2.- Manda un mensaje de que se actualizo correctamente
     
    public void guardarRegistro(){
        try{
            String sql = "UPDATE contactos SET nombre ='" + nombre + "', email = '" + email + "', telefono = '" + telefono + "' where id_contacto = '" + id + "';";
            System.out.println(sql);
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente");
            rs = st.executeQuery("SELECT * FROM contactos;");
        }catch(SQLException err){
            
            JOptionPane.showMessageDialog(null, "Error ModelAgenda Actualizacion: " + err.getMessage());
        }
    }*/

    
}
