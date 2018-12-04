/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import bd.ConnectDatabase;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *metodo con las variables a utilizar para la interaccion de catalogo.
 * @author manl_
 */
public class modelCatalogo {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    
    private int id;
    private int codigo_barras;
    private String nombre;
    private Object iva;
    private String descripcion;
    private double precio_unitario;
    private double precio_mayoreo;
    private Object unidad_medida;
    private String sentencia;
    DefaultTableModel modelo = new DefaultTableModel();

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo_barras() {
        return codigo_barras;
    }

    public void setCodigo_barras(int codigo_barras) {
        this.codigo_barras = codigo_barras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Object getIva() {
        return iva;
    }

    public void setIva(Object iva) {
        this.iva = iva;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public double getPrecio_mayoreo() {
        return precio_mayoreo;
    }

    public void setPrecio_mayoreo(double precio_mayoreo) {
        this.precio_mayoreo = precio_mayoreo;
    }

     public Object getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(Object unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

 /**
  * Metodo para crear una conexion a la base de datos y ver registros de la tabla catalogo.
  * Permite tener los valores del primer registro del catalogo.
  */
 public void conectarDB() {
        try {
           conexion = ConnectDatabase.getConectar();
           st = conexion.createStatement();
           rs = st.executeQuery("SELECT * FROM catalogo;");
           rs.next();
           codigo_barras = rs.getInt("codigo_barras");
           nombre =rs.getString("nombre");
           descripcion = rs.getString("descripcion");
           precio_unitario =  rs.getDouble("precio");
           precio_mayoreo =  rs.getDouble("precio_mayoreo");
           unidad_medida = rs.getObject("unidad");
           iva = rs.getObject("iva");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelCatalogo001: " + err.getMessage());
            System.out.println(err.getMessage());
        }
    }
 
 /**
  * Metodo que llena la tabla con los registros existentes de la base de datos.
  */
         public void llenartabla(){
        rs = ConnectDatabase.getTabla(sentencia);
        modelo.setColumnIdentifiers(new Object[]{"Id","Nombre", "Precio unitario", "Precio mayoreo", "Unidad de medida"});
        try {
           while (rs.next()){
            modelo.addRow(new Object[]{
                rs.getInt("id"), 
                rs.getString("nombre"), 
                rs.getDouble("precio"),
                rs.getDouble("precio_mayoreo"),
                rs.getString("unidad")});
        }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error modelCatalogo002 " + e.getMessage());
        }
    }
         
         /**
          * Metodo que obtiene datos de un registro especifico de la base de datos.
          */
         public void datos(){
            try {
               rs = st.executeQuery("SELECT * FROM catalogo where id ="+id+";");
               rs.first();
               codigo_barras = rs.getInt("codigo_barras");
               nombre =rs.getString("nombre");
               descripcion = rs.getString("descripcion");
               precio_unitario =  rs.getDouble("precio");
               precio_mayoreo =  rs.getDouble("precio_mayoreo");
               unidad_medida = rs.getObject("unidad");
               iva = rs.getObject("iva");
               System.out.println(iva);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error modelCatalogo003 " + ex.getMessage());}
         }

    public String getSentencia() {
        return sentencia;
    }
    public void setSentencia(String sentencia) {
        this.sentencia = sentencia;
    }
    
    /**
     * Metodo que actualiza los datos un registro de la base de datos.
     */
    public void modificar(){
        try {
           String prueba=  "update catalogo set nombre ='"+nombre+"', descripcion = '"+descripcion+"', codigo_barras = "+codigo_barras+", precio = "+precio_unitario+", precio_mayoreo ="+precio_mayoreo+", unidad ='"+unidad_medida+"', iva ='"+iva+"' where id ="+id+";";
           st.executeUpdate(prueba);
           System.out.println(prueba);
            JOptionPane.showMessageDialog(null, "Producto actualizado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error modelCatalogo004" + ex.getMessage());
        }
    }
    /**
     * Metodo que ingresa un nuevo registro a la base de datos.
     */
    public void insertar(){
        try {
            String prueba = "Insert into catalogo(nombre, descripcion, codigo_barras,precio, precio_mayoreo,unidad,iva) values('"+nombre+"','"+descripcion+"',"+codigo_barras+","+precio_unitario+","+precio_mayoreo+",'"+unidad_medida+"','"+iva+"');";
            st.executeUpdate(prueba);
            System.out.println(prueba);
            JOptionPane.showMessageDialog(null, "Producto registrado");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error modelCatalogo005" + ex.getMessage());}
        }
    /**
     * Metodo que elimina un registro de la base de datos.
     */
    public void borrar(){
        int confirmado = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el producto?");
        if(JOptionPane.OK_OPTION == confirmado){
            try{
                st.executeUpdate("delete from catalogo where id = " + id + "; ");
                JOptionPane.showMessageDialog(null, "Lista de productos actualizada, el producto ha sido eliminado");
            }
            catch(SQLException err){
               JOptionPane.showMessageDialog(null, "Error modelCatalogo 006:" + err.getMessage()); }
        }
    }

    public void insertando(){
        ArrayList sucursales = new ArrayList();
        ArrayList productos = new ArrayList();
        try {
            rs = st.executeQuery("Select * from sucursal;");
            while (rs.next()){
                sucursales.add(rs.getInt("id"));
            }
            rs = st.executeQuery("Select * from catalogo;");
            while (rs.next()){
                  productos.add(rs.getInt("id"));
            }
            System.out.print(sucursales);
            System.out.print(productos);
            for (int x = 0; x < sucursales.size(); x++){
                for (int y = 0; y < productos.size(); y++){
            rs = st.executeQuery("Select * from inventario where id_sucursal = "+sucursales.get(x) +" and id_producto = "+ productos.get(y)+";");
            if (rs.wasNull() == false){
               st.executeUpdate("Insert into inventario(id_sucursal, id_producto,existencias) values ("+sucursales.get(x)+","+productos.get(y)+",0);");
            }
            } 
        }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    }
}
