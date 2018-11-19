
package models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ModelClientes {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;

    
    private String id;
    private String nombre;
    private String ape_p;
    private String ape_m;
    private String telefono;
    private String rfc;
    private String calle;
    private String colonia;
    private String no_exterior;
    private String no_interior;
    private String cp;
    private String genero;
    private String correo;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getNo_exterior() {
        return no_exterior;
    }

    public void setNo_exterior(String no_ext) {
        this.no_exterior = no_exterior;
    }

    public String getNo_interior() {
        return no_interior;
    }

    public void setNo_interior(String no_int) {
        this.no_interior = no_int;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public void conectarDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/quetzalstock", "quetzal", "quetzal.2018");
            st = conexion.createStatement();
            String sql = "SELECT * FROM cliente;";
            System.out.println(sql);
            rs = st.executeQuery(sql);
            rs.next();
            setValues();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelAgenda 001: " + err.getMessage());
        }
    }
    public void setValues() {
        try {
            nombre = rs.getString("nombre");
            ape_p = rs.getString("apellido_paterno");
            ape_m = rs.getString("apellido_materno");
            telefono = rs.getString("telefono");
            rfc = rs.getString("rfc");
            calle = rs.getString("calle");
            colonia = rs.getString("colonia");
            no_exterior = rs.getString("numero_exterior");
            no_interior = rs.getString("numero_interior");
            cp = rs.getString("codigo_postal");
            genero = (String) rs.getObject("genero");
            correo = rs.getString("coreo");
            
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error model 102: " + err.getMessage());

        }
    }
    public void guardar(){
        try {

            String sql = "INSERT INTO cliente (id, nombre, apellido_paterno, apellido_materno, telefono, rfc, calle, colonia, numero_exterior, numero_interior, codigo_postal, numero_compras, genero, correo)" + "values('"+nombre+"', '"+ape_p+"', '"+ape_m+"', , '"+telefono+"', '"+rfc+"', '"+calle+"', '"+colonia+"', '"+no_exterior+"', '"+no_interior+"', '"+cp+"', "+genero+", "+correo+");";
            System.out.println(sql);
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"¡Registro exitoso!");
            } catch (SQLException ex) {
           Logger.getLogger(ModelClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void modificar(){
        try {

            String sql = "UPDATE cliente set telefono = '"+telefono+"' where nombre = '"+nombre+"';";
            System.out.println(sql);
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"¡Registro Modificado!");
            } catch (SQLException ex) {
            Logger.getLogger(ModelClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
    public void eliminar(){
        try {
            String sql= "DELETE from cliente where nombre = '"+nombre+"' and telefono= '"+telefono+"';";
            System.out.println(sql);
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "¿Seguro que quiere Elminar el Cliente?");
            JOptionPane.showMessageDialog(null,"¡Registro eliminado!");
            } catch (SQLException ex) {
            Logger.getLogger(ModelClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
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
}
