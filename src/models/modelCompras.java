/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import javax.swing.table.DefaultTableModel;
import bd.ConnectDatabase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class modelCompras {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    
    private String no_factura;
    private String rfc_prov;
    private String fecha;
    private Object forma_pago;
    private Object estado_factura;
    private double total;
    private int sucursal;
    private String tiendas;
    private String sentencia;
    private String sentencia_prov;
    private boolean validar;
    DefaultTableModel table_compra = new DefaultTableModel();
    DefaultTableModel table_prov = new DefaultTableModel();
    ArrayList sucursales = new ArrayList();

    public String getNo_factura() {
        return no_factura;
    }

    public void setNo_factura(String no_factura) {
        this.no_factura = no_factura;
    }

    public String getRfc_prov() {
        return rfc_prov;
    }

    public void setRfc_prov(String rfc_prov) {
        this.rfc_prov = rfc_prov;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Object getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(Object forma_pago) {
        this.forma_pago = forma_pago;
    }

    public Object getEstado_factura() {
        return estado_factura;
    }

    public void setEstado_factura(Object estado_factura) {
        this.estado_factura = estado_factura;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }

    public DefaultTableModel getTable_compra() {
        return table_compra;
    }

    public void setTable_compra(DefaultTableModel table_compra) {
        this.table_compra = table_compra;
    }

    public DefaultTableModel getTable_prov() {
        return table_prov;
    }

    public void setTable_prov(DefaultTableModel table_prov) {
        this.table_prov = table_prov;
    }
    
        public String getSentencia() {
        return sentencia;
    }

    public void setSentencia(String sentencia) {
        this.sentencia = sentencia;
    }

    public String getSentencia_prov() {
        return sentencia_prov;
    }

    public void setSentencia_prov(String sentencia_prov) {
        this.sentencia_prov = sentencia_prov;
    }
        public String getTiendas() {
        return tiendas;
    }

    public void setTiendas(String tiendas) {
        this.tiendas = tiendas;
    }
        public ArrayList getSucursales() {
        return sucursales;
    }

    public void setSucursales(ArrayList sucursales) {
        this.sucursales = sucursales;
    }
    
        public boolean isValidar() {
        return validar;
    }

    public void setValidar(boolean validar) {
        this.validar = validar;
    }
    
    
     public void conectarDB() {
        try {
           conexion = ConnectDatabase.getConectar();
           st = conexion.createStatement();
           rs = st.executeQuery("SELECT * FROM  compra;");
           rs.next();
           sucursal = rs.getInt("id_sucursal");
           no_factura =rs.getString("no_factura");
           rfc_prov = rs.getString("rfc_proveedor");
           fecha =  rs.getString("fecha");
           total =  rs.getDouble("total");
           forma_pago = rs.getObject("forma_pago");
           estado_factura = rs.getObject("estado_factura");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelCompra001: " + err.getMessage());
            System.out.println(err.getMessage());
        }
     }
     
       public void llenarcompras(){
        rs = ConnectDatabase.getTabla(sentencia);
        table_compra.setColumnIdentifiers(new Object[]{"Factura","Sucursal", "Fecha", "Forma de pago", "Estado de factura","RFC proveedor"});
        try {
           while (rs.next()){
            table_compra.addRow(new Object[]{
                rs.getString("no_factura"), 
                rs.getInt("id_sucursal"), 
                rs.getString("fecha"),
                rs.getObject("forma_pago"),
                rs.getObject("estado_factura"),
                rs.getString("rfc_proveedor")});
        }}catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error modelCompra002 " + e.getMessage());}
    }
       
       public void llenarprov(){
        rs = ConnectDatabase.getTabla("select * from proveedor;");
        table_prov.setColumnIdentifiers(new Object[]{"RFC","Razon social"});
        try {
           while (rs.next()){
            table_prov.addRow(new Object[]{
                rs.getString("rfc"), 
                rs.getString("razons")});
        } }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error modelCompra002-1 " + e.getMessage());}
    }
       
         public void datos_compra(){
            try {
               rs = st.executeQuery("SELECT * FROM compra where  no_factura ='"+no_factura+"';");
               rs.first();
               sucursal = rs.getInt("id_sucursal");
               no_factura =rs.getString("no_factura");
               rfc_prov = rs.getString("rfc_proveedor");
               fecha =  rs.getString("fecha");
               total =  rs.getDouble("total");
               forma_pago = rs.getObject("forma_pago");
               estado_factura = rs.getObject("estado_factura");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error modelCompra003 " + ex.getMessage());}
         }
                  
         public void sucursales_combobox(){
        try {
            rs = st.executeQuery("Select * from sucursal;");
            while(rs.next()){
                tiendas = (rs.getString("id")+" - "+rs.getString("calle"));
                sucursales.add(tiendas);
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error modelCombobox " + ex.getMessage());
        }

         }
         
 /**
 * Metodo que actualiza los datos un registro de la base de datos.
 */
    public void modificar(){
        try {
           String prueba=  "update compra set  rfc_proveedor = '"+rfc_prov+"', forma_pago = '"+forma_pago+"', estado_factura = '"+estado_factura+"' where no_factura = '"+no_factura+"';";
           st.executeUpdate(prueba);
           System.out.println(prueba);
            JOptionPane.showMessageDialog(null, "Producto actualizado");
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error modelCompra004" + ex.getMessage());
        }
    }
    /**
     * Metodo que ingresa un nuevo registro a la base de datos.
     */
    public void insertar(){
        try {
            String prueba = "Insert into compra(no_factura, id_sucursal, rfc_proveedor, total, fecha, forma_pago, estado_factura) values('"+no_factura+"',"+sucursal+",'"+rfc_prov+"', "+total+",'"+fecha+"' ,'"+forma_pago+"','"+estado_factura+"');";
            st.executeUpdate(prueba);
            System.out.println(prueba);
            JOptionPane.showMessageDialog(null, "Compra registrada, ingrese detalles");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error modelCompra005" + ex.getMessage());}
        }
    
    /**
     * Metodo que elimina un registro de la base de datos.
     */
    public void borrar(){
        try {
            rs = st.executeQuery("SELECT * FROM detalle_compra where no_factura = '"+no_factura+"';");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error modelCompra006" + ex.getMessage());
        }
        try {
            if(rs.first() == false){
                int confirmado = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la compra?","Eliminar",JOptionPane.YES_NO_OPTION);
                if(confirmado == JOptionPane.YES_OPTION){
                    st.executeUpdate("delete from compra where no_factura = '" + no_factura + "'; ");
                    JOptionPane.showMessageDialog(null, "Lista de productos actualizada, el producto ha sido eliminado");
                }
            }else{
                JOptionPane.showMessageDialog(null, "No se puede eliminar la compra, esta ya contiene datos usados");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error modelCompra006-1" + ex.getMessage());
        }
}


    }
