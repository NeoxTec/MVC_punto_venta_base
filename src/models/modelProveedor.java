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


import controllers.controllerProveedor;
import views.viewSucursal;
/**
 *
 * @author Abi Montes
 */
public class modelProveedor {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;

    private String rfc;
    private String nombre;
    private String calle;
    private String colonia;
    private String noext;
    private String cp;
    private String telefono;
    private String correo;



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

    public String getNoext() {
        return noext;
    }

    public void setNoext(String noext) {
        this.noext = noext;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void conectarDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/quetzalstock", "root", "");
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT * FROM proveedor;");
            rs.next();
            rfc = rs.getString("rfc");
            nombre = rs.getString("nombre");
            calle=rs.getString("calle");
            colonia=rs.getString("colonia");
            noext=rs.getString("noext");
            cp=rs.getString("cp");
            telefono=rs.getString("telefono");
            correo=rs.getString("correo");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelProveedor 001: " + err.getMessage());
        }
    }
     public void moverPrimerRegistro(){
        try {
            if (rs.isFirst() == false) {
                rs.first(); //Primer registro
                this.setRfc(rs.getString("rfc"));
                this.setNombre(rs.getString("nombre"));
                this.setCalle(rs.getString("calle"));
                this.setColonia(rs.getString("colonia"));
                this.setNoext(rs.getString("noext"));
                this.setCp(rs.getString("cp"));
                this.setTelefono(rs.getString("telefono"));
                this.setCorreo(rs.getString("Correo"));
                
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }
     public void moverAnteriorRegistro(){
        try {
            if (rs.isFirst() == false) {
                rs.previous(); //Registro anterior

                this.setRfc(rs.getString("rfc"));
                this.setNombre(rs.getString("nombre"));
                this.setCalle(rs.getString("calle"));
                this.setColonia(rs.getString("colonia"));
                this.setNoext(rs.getString("noext"));
                this.setCp(rs.getString("cp"));
                this.setTelefono(rs.getString("telefono"));
                this.setCorreo(rs.getString("Correo"));
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }
 public void moverSiguienteRegistro(){
        try{
            if(rs.isLast()==false) {
                rs.next(); // Siguiente registro 
                
                 this.setRfc(rs.getString("rfc"));
                this.setNombre(rs.getString("nombre"));
                this.setCalle(rs.getString("calle"));
                this.setColonia(rs.getString("colonia"));
                this.setNoext(rs.getString("noext"));
                this.setCp(rs.getString("cp"));
                this.setTelefono(rs.getString("telefono"));
                this.setCorreo(rs.getString("Correo"));
            }
        } catch(Exception err) {
            JOptionPane.showMessageDialog(null,"Error " + err.getMessage());
        }
    }
  public void moverUltimoRegistro(){
        try {
            if (rs.isLast() == false) {
                rs.last(); //Último registro

                this.setRfc(rs.getString("rfc"));
                this.setNombre(rs.getString("nombre"));
                this.setCalle(rs.getString("calle"));
                this.setColonia(rs.getString("colonia"));
                this.setNoext(rs.getString("noext"));
                this.setCp(rs.getString("cp"));
                this.setTelefono(rs.getString("telefono"));
                this.setCorreo(rs.getString("Correo"));
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }
   public void eliRegistro() {
        try {
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar este registro?", "Borrar", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                rfc = rs.getString("rfc");
                st.executeUpdate("DELETE FROM proveedor WHERE rfc = "+ rfc +"; ");
                
                this.conectarDB();
                this.moverUltimoRegistro();
            }
            else {
                this.conectarDB();
                this.moverUltimoRegistro();
            }
        }
        catch(SQLException err) { 
            JOptionPane.showMessageDialog(null,"Error en metodo eliminar"+err.getMessage()); 
        }
    }
    public void insertarRegistro() {
        try {
            rfc = this.getRfc();
            nombre = this.getNombre();
            calle=this.getCalle();
            colonia=this.getColonia();
            noext=this.getNoext();
            cp=this.getCp();
            telefono=this.getTelefono();
            correo=this.getCorreo();
            st.executeUpdate("INSERT INTO proveedor (rfc, nombre, calle,colonia, noext, cp, telefono,correo)" + " VALUES ('"+ rfc +"','"+nombre +"','"+calle +"','"+ colonia +"','"+ noext +"','"+ cp +"','"+ telefono +"','"+ correo +"');");
            JOptionPane.showMessageDialog(null, "Felicidades registro guardado.");
            this.conectarDB();
            this.moverUltimoRegistro();
        }
        catch(SQLException err) { 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        }
    }
     public void modiRegistro() {
        try {
            rfc = this.getRfc();
            nombre = this.getNombre();
            calle=this.getCalle();
            colonia=this.getColonia();
            noext=this.getNoext();
            cp=this.getCp();
            telefono=this.getTelefono();
            correo=this.getCorreo();
            st.executeUpdate("UPDATE proveedor SET nombre = '"+ nombre +"', calle = '"+ calle +"',colonia = '"+ colonia +"',noext = '"+ noext +"',cp = '"+ cp +"', telefono = '"+ telefono +"',correo = '"+ correo +"' WHERE rfc = "+ rfc +"; ");
            JOptionPane.showMessageDialog(null, "Se modifico correctamente el registro.");
            this.conectarDB();
            this.moverUltimoRegistro();
        }
        catch(SQLException err) { 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        }
    }
    
}
