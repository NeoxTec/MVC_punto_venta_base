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

    public String getNo_ext() {
        return no_ext;
    }

    public void setNo_ext(String no_ext) {
        this.no_ext = no_ext;
    }

    public String getNo_int() {
        return no_int;
    }

    public void setNo_int(String no_int) {
        this.no_int = no_int;
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
    private String no_ext;
    private String no_int;
    private String cp;
    private String telefono;


    //COMIENZA EL CODIGO A BASE DE DATOS Y TERMINAN SETTERS Y GETTERS 

    public Connection ConectarBD() { //metodo para conexion a la base de datos 
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/quetzalstock", "quetzal", "quetzal.2018");
            actualizarSucursal();
            setValues();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en conexion" + e.getMessage());
        }
        return conexion;
    }

    public void actualizarSucursal() {
        try {
            String sql = "SELECT * FROM sucursal;";
            ps = conexion.prepareStatement(sql);
            System.out.println(sql);
            rs = ps.executeQuery(sql);
            rs.next();
            setValues();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error_Actualizar_tabla" + e.getMessage());
        }
    }

    public void setValues() {
        try {
            id = rs.getString("id");
            calle = rs.getString("calle");
            colonia = rs.getString("colonia");
            no_ext = rs.getString("no_ext");
            no_int = rs.getString("no_int");
            cp = rs.getString("cp");
            telefono = rs.getString("telefono");
            

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error model 102: " + e.getMessage());

        }
    }

    public void guardarRegistro( String calle, String colonia, String no_ext, String no_int, String cp, String telefono) {
        try {
            conexion = null;
            conexion = ConectarBD();
            ps = conexion.prepareStatement("INSERT INTO sucursal (calle, colonia, no_ext, no_int, cp,telefono) VALUES (?,?,?,?,?,?)");
            ps.setString(1, calle);
            ps.setString(2, colonia);
            ps.setString(3, no_ext);
            ps.setString(4, no_int);
            ps.setString(5, cp);
            ps.setString(6, telefono);
            int devuelto = ps.executeUpdate();
            if (devuelto > 0) {
                JOptionPane.showMessageDialog(null, "Datos guardados...");

                actualizarSucursal();

            } else {
                JOptionPane.showMessageDialog(null, "Datos NO registrados");
            }

        } catch (SQLException e) {
            Logger.getLogger(modelSucursal.class.getName()).log(Level.SEVERE, null, e);
        }
    }
public void guardarRegistro() {
         try {
            String sql =  "INSERT INTO sucursal (id, calle, colonia, no_ext,no_, cp, telefono)" + " VALUES ('"+ id +"','"+calle+"','"+colonia +"','"+ no_ext+"','"+ not +"','"+ cp +"','"+ telefono +"','"+ correo +"');";
            System.out.println(sql);
            st.executeUpdate(sql);
    
            JOptionPane.showMessageDialog(null, "Felicidades registro guardado.");
            this.conectarDB();
            
        }
        catch(SQLException err) { 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        }
    }
   

    public void eliminarRegistro() {
        try {
            String sql = "DELETE FROM sucursal WHERE id = "+ id +"; ";
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
     public void conectarDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/quetzalstock", "root", "");
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT * FROM sucursal;");
            rs.next();
            id = rs.getString("id");
            calle=rs.getString("calle");
            colonia=rs.getString("colonia");
            no_ext=rs.getString("no_ext");
           no_int = rs.getString("no_int");
            cp=rs.getString("cp");
            telefono=rs.getString("telefono");
            
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelSucursal 001: " + err.getMessage());
        }
    }
public void EditarRegistro() {
        try {
          String sql = "UPDATE sucursal SET calle = '"+ calle +"', colonia = '"+ colonia +"',no_ext = '"+ no_ext +"',no_int = '"+ no_int +"',cp = '"+ cp +"', telefono = '"+ telefono +"' WHERE id = "+ id +"; ";
            System.out.println(sql);
          st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Se modifico correctamente el registro.");
            this.conectarDB();
            
        }
        catch(SQLException err) { 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        }
    }
}

