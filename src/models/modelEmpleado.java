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
import java.sql.PreparedStatement;

/**
 *
 * @author Diego
 */
public class modelEmpleado {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    
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
    private Object genero;
    private String fecha_n;
    
    private String username;
    private String pass = "ferreteria";
    private String passh;
    private int validacion = 123;
    private Object sucursal;
    private Object puesto;
    private boolean eliminar = false;
    
    
    private String sentencia;
    DefaultTableModel modelo = new DefaultTableModel();

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

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

    public Object getGenero() {
        return genero;
    }

    public void setGenero(Object genero) {
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
    
     public String getSentencia() {
        return sentencia;
    }

    public void setSentencia(String sentencia) {
        this.sentencia = sentencia;
    }
    
    public Object getSucursal() {
        return sucursal;
    }

    public void setSucursal(Object sucursal) {
        this.sucursal = sucursal;
    }

    public Object getPuesto() {
        return puesto;
    }

    public void setPuesto(Object puesto) {
        this.puesto = puesto;
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
            rs = st.executeQuery("SELECT * FROM empleado;");
            rs.next();
            setValues();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelEmpleado01: " + err.getMessage());
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
            JOptionPane.showMessageDialog(null, "Error modelEmpleado002: " + err.getMessage());

        }
    }
    /*
    *Método para llenar la tabla jt_empleados 
    */
    public void llenarTabla(){
        rs =  ConnectDatabase.getTabla(sentencia);
        modelo.setColumnIdentifiers(new Object [] {"RFC","Nombre","Apellido paterno","Apellido materno","colonia","calle","no exterior","no interior","cp","telefono","correo","genero","fecha de nacimiento"});
        try{
            while(rs.next()){
                modelo.addRow(new Object[]{
                    rs.getString("rfc"),
                    rs.getString("nombre"),
                    rs.getString("ape_p"),
                    rs.getString("ape_m"),
                    rs.getString("calle"),
                    rs.getString("colonia"),
                    rs.getInt("no_exterior"),
                    rs.getInt("no_interior"),
                    rs.getString("cp"),
                    rs.getString("telefono"),
                    rs.getString("correo"),
                    rs.getString("genero"),
                    rs.getString("fecha_nac")});
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error modelEmpleado003 " + e.getMessage());
        }
    }
    public void datos(){
        try{
            rs = st.executeQuery("SELECT * FROM empleado WHERE rfc = '"+rfc+"';");
            rs.first();
            setValues();
        }catch(SQLException e){
            
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
            st.executeUpdate(sql);
            if (insertarUsuario() == true){
                JOptionPane.showMessageDialog(null, "Se ha insertado correctamente");
            }
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, "Error modelEmpleado Inserción: " + err.getMessage());
        }
    }
    
    
    
    private boolean insertarUsuario(){
        passh = hash.sha1(pass);
        String usuario = rfc.trim().substring(0,3);
        username = "FA"+usuario+ sucursal;
        try{
            String sql = "INSERT INTO usuario (username,pass,tipo,validacion,id_sucursal,rfc_e)" + "VALUES ('"+ username +"','"+ passh +"','"+ puesto + "'," + validacion +","+ sucursal + ",'"+rfc + "');";
            st.executeUpdate(sql);
            return true;
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, "Error modelEmpleado Inserción Usuario: " + err.getMessage());
        }
        return false;
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
    
    public void eliminarRegistro(){
        int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea eiminar el registro?");
        if (JOptionPane.OK_OPTION== confirmar){
            eliminar = true;
        try{
            String sql1 = "DELETE FROM usuario WHERE rfc_e = '" + rfc + "';";
            st.executeUpdate(sql1);
            String sql = "DELETE  FROM empleado WHERE rfc = '" + rfc + "';";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
        }catch(SQLException err){
            
            JOptionPane.showMessageDialog(null, "Error ModelAgenda Eliminar: " + err.getMessage());
        }
    }
   }

    public boolean isEliminar() {
        return eliminar;
    }

    public void setEliminar(boolean eliminar) {
        this.eliminar = eliminar;
    }

    
    
}
