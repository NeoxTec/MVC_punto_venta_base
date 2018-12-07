 
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
import bd.ConnectDatabase;
import javax.swing.table.DefaultTableModel;
import models.modelClientes;
import views.viewClientes;


public class modelClientes {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private DefaultTableModel t_cliente = new DefaultTableModel();

    
    private int id;
    private String nombre;
    private String ape_p;
    private String ape_m;
    private String telefono;
    private String rfc;
    private String calle;
    private String colonia;
    private int no_exterior;
    private int no_interior;
    private String cp;
    private String genero;
    private String correo;
    private String no_compras;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public int getNo_interior() {
        return no_interior;
    }

    public void setNo_interior(int no_int) {
        this.no_interior = no_int;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNo_compras() {
        return no_compras;
    }

    public void setNo_compras(String no_compras) {
        this.no_compras = no_compras;
    }

    public void setSentencia(String select__id_nombre_apellido_paterno_apelli) {
    }

    public int getNo_exterior() {
         return no_exterior;
    }

    public void setNo_exterior(int no_exterior) {
        this.no_exterior = no_exterior;
    }

    public PreparedStatement getPs() {
        return ps;
    }

    public void setPs(PreparedStatement ps) {
        this.ps = ps;
    }

    public DefaultTableModel getT_cliente() {
        return t_cliente;
    }

    public void setT_cliente(DefaultTableModel t_cliente) {
        this.t_cliente = t_cliente;
    }

    public void conectarDB() {
        
        try {
            conexion = ConnectDatabase.getConectar();
            st = conexion.createStatement();
            rs= st.executeQuery("SELECT * FROM cliente;");
            rs.next();
            id= rs.getInt("id");
            nombre = rs.getString("nombre");
            ape_p = rs.getString("ape_p");
            ape_m = rs.getString("ape_m");
            telefono = rs.getString("telefono");
            rfc = rs.getString("rfc");
            calle = rs.getString("calle");
            colonia = rs.getString("colonia");
            no_exterior = rs.getInt("no_exterior");
            no_interior = rs.getInt("no_interior");
            cp = rs.getString("cp");
            genero = (String) rs.getObject("genero");
            correo = rs.getString("correo");
            no_compras= rs.getString("no_compras");
            
            
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error modelClientes 001: " + err.getMessage());
            System.out.println(err.getMessage());
        }
    }
    
    public void insertar(){
        try {

            String sql = "INSERT INTO cliente (nombre, ape_p, ape_m, telefono, rfc, calle, colonia, no_exterior, no_interior, cp, genero, correo)" + "VALUES( '"+nombre+"', '"+ape_p+"', '"+ape_m+"' , '"+telefono+"', '"+rfc+"', '"+calle+"', '"+colonia+"', '"+no_exterior+"', '"+no_interior+"', '"+cp+"', '"+genero+"', '"+correo+"');";
            System.out.println(sql);
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"¡Registro Guardado Exitosamente!");
            } catch (SQLException err) {
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
            }
        System.out.println("Registro Guardado");
    }
    
    public void modificar(){
         System.out.println("Registro Modificado");
        try {

            String sql = "UPDATE cliente SET nombre = '"+nombre+"', ape_p= '"+ape_p+"', ape_m= '"+ape_m+"', telefono= '"+telefono+"',  calle= '"+calle+"', colonia= '"+colonia+"', no_exterior=  '"+no_exterior+"', no_interior= '"+no_interior+"', cp= '"+cp+"', genero=  '"+genero+"', correo= '"+correo+"' WHERE rfc= '"+rfc+"';";
            System.out.println(sql);
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "¡Registro Modificado Correctamente!");
            this.conectarDB();
            
        }
        catch(SQLException err) { 
            JOptionPane.showMessageDialog(null,"Error al modificar "+err.getMessage()); 
            }
            }
    public void eliminar(){
        try {
            String sql= "DELETE FROM cliente WHERE rfc = '"+rfc+"'; ";
             int respuesta = JOptionPane.showConfirmDialog(null, "¿Está Seguro de Eliminar este Registro?", "Borrar", JOptionPane.YES_NO_OPTION);
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
    /**
  * Metodo que llena la tabla con los registros existentes de la base de datos.
  */
public void tabla(){
        rs = ConnectDatabase.getTabla(sentencia);
        t_cliente.setColumnIdentifiers(new Object[]{"id", "nombre", "ape_p", "ape_m", "telefono", "rfc", "calle", "colonia", "no_exterior", "no_interior", "cp", "genero", "correo", "no_compras"});
        try {
           while (rs.next()){
                 t_cliente.addRow(new Object[]{
                 rs.getInt("id"), 
                 rs.getString("nombre"), 
                 rs.getString("ape_p"),
                 rs.getString("ape_m"),
                 rs.getString("telefono"),
                 rs.getString("rfc"),
                 rs.getString("calle"), 
                 rs.getString("colonia"), 
                 rs.getInt("no_exterior"),
                 rs.getInt("no_interior"),
                 rs.getString("cp"),
                 rs.getString("genero"),
                 rs.getString("correo"), 
                 rs.getString("no_compras")});
        }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error modelClientes 010 " + e.getMessage());
        }
    }    
            public void dato(){
                try {
                         rs = st.executeQuery("SELECT * FROM cliente where id ="+id+";");
                         rs.first();
                         id= rs.getInt("id");
                        nombre = rs.getString("nombre");
                        ape_p = rs.getString("ape_p");
                        ape_m = rs.getString("ape_m");
                        telefono = rs.getString("telefono");
                        rfc = rs.getString("rfc");
                        calle = rs.getString("calle");
                        colonia = rs.getString("colonia");
                        no_exterior = rs.getInt("no_exterior");
                        no_interior = rs.getInt("no_interior");
                        cp = rs.getString("cp");
                        genero = (String) rs.getObject("genero");
                        correo = rs.getString("correo");
                        no_compras= rs.getString("no_compras");
                  } catch (SQLException ex) {
                      JOptionPane.showMessageDialog(null, "Error modelClientes 003 " + ex.getMessage());}
                   }
 
}
