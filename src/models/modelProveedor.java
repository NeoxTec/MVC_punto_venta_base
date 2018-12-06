/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import bd.ConnectDatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


import controllers.controllerProveedor;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import views.viewSucursal;
import views.viewProveedor;
/**
 *
 * @author Abi Montes
 */
public class modelProveedor {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;

    public PreparedStatement getPs() {
        return ps;
    }

    public void setPs(PreparedStatement ps) {
        this.ps = ps;
    }

    public DefaultTableModel getT_Proveedor() {
        return t_proveedor;
    }

    public void setT_sucursal(DefaultTableModel t_proveedor) {
        this.t_proveedor = t_proveedor;
    }
private PreparedStatement ps;
    private DefaultTableModel t_proveedor = new DefaultTableModel();

    private String rfc;
    private String calle;
    private String colonia;
    private int noext;
    private String cp;
    private String telefono;
    private String correo;
    private String razons;

    public String getSentencia() {
        return sentencia;
    }

    public void setSentencia(String sentencia) {
        this.sentencia = sentencia;
    }
    private String sentencia;
    
    
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

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
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

    public int getNoext() {
        return noext;
    }

    public void setNoext(int noext) {
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

    public String getRazons() {
        return razons;
    }

    public void setRazons(String razons) {
        this.razons = razons;
    }



  
    public void conectarDB() {
        try {
          //  conexion = ConnectDatabase.getConectar();
            conexion = DriverManager.getConnection("jdbc:mysql://tic41.ddns.net/quetzalstock", "quetzal", "quetzal.2018");
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT * FROM proveedor;");
            rs.next();
            rfc = rs.getString("rfc");
            razons = rs.getString("razons");
            calle=rs.getString("calle");
            colonia=rs.getString("colonia");
            noext=rs.getInt("no_exterior");
            cp=rs.getString("cp");
            telefono=rs.getString("telefono");
            correo=rs.getString("correo");
            
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelSucursal 001: " + err.getMessage());
       System.out.println(err.getMessage());
        }
    }
   public void eliRegistro() {
        try {
            String sql = "DELETE FROM proveedor  WHERE rfc = '"+ rfc +"'; ";
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar este registro?", "Borrar", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                rfc = rs.getString("rfc");
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
            
            String sql =  "INSERT INTO proveedor (rfc, razons, calle,colonia, no_exterior, Cp, telefono,correo)" + " VALUES ('"+ rfc +"','"+razons +"','"+calle +"','"+ colonia +"','"+ noext +"','"+ cp +"','"+ telefono +"','"+ correo +"');";
            System.out.println(sql);
            st.executeUpdate(sql);
            
            JOptionPane.showMessageDialog(null, "Felicidades registro guardado.");
            //this.conectarDB();
            
        }
        catch(SQLException err) { 
            JOptionPane.showMessageDialog(null,"Error al guardar registro "+err.getMessage()); 
        }
        System.out.println("registro guardado");
    }
     public void modiRegistro() {
         System.out.println("registro modificado");
        try {
          String sql = "UPDATE proveedor SET razons = '"+ razons +"', calle = '"+ calle +"',colonia = '"+ colonia +"',no_exterior = '"+ noext +"',cp = '"+ cp +"', telefono = '"+ telefono +"',correo = '"+ correo +"' WHERE rfc = '"+ rfc +"'; ";
            System.out.println(sql);
          st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Se modifico correctamente el registro.");
            this.conectarDB();
            
        }
        catch(SQLException err) { 
            JOptionPane.showMessageDialog(null,"Error1 "+err.getMessage()); 
        }
    }
    
/**
  * Metodo que llena la tabla con los registros existentes de la base de datos.
  */
public void llenartabla(){
        rs = ConnectDatabase.getTabla(sentencia);
        t_proveedor.setColumnIdentifiers(new Object[]{"rfc","razons","Calle", "Colonia", "No_exterior","Código Postal", "Teléfono", "correo"});
        try {
           while (rs.next()){
                 t_proveedor.addRow(new Object[]{
                 rs.getString("rfc"),
                     rs.getString("razons"),
                rs.getString("calle"), 
                rs.getString("colonia"),
                rs.getInt("no_exterior"),
                rs.getString("correo"),
                rs.getString("cp"),
                rs.getString("telefono")});
                
        }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error modelSucursal010 " + e.getMessage());
        }
    }    

 /**
* Metodo que obtiene datos de un registro especifico de la base de datos.
*/
public void datos(){
      try {
               rs = st.executeQuery("SELECT * FROM proveedor where rfc ='"+rfc+"';");
               rs.first();
               rfc = rs.getString("rfc");
            razons = rs.getString("razons");
            calle=rs.getString("calle");
            colonia=rs.getString("colonia");
            noext=rs.getInt("no_exterior");
            cp=rs.getString("cp");
            telefono=rs.getString("telefono");
            correo=rs.getString("correo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error modelProveedor003 " + ex.getMessage());}
         } 
}

