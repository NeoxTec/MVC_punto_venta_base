/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class ConnectDatabase {
    public static Connection getConectar(){
        Connection conexion = null;
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/quetzalstock", "quetzal", "quetzal.2018");
        }catch(SQLException ex){
            System.out.println(String.valueOf(ex));
        }
        return conexion;
    }
    public static ResultSet getTabla(String consulta){
        Connection conexion = getConectar();
        Statement st;
        ResultSet datos=null;
        try{
            st=conexion.createStatement();
            datos = st.executeQuery(consulta);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error Connect 001" + ex.getMessage());
        }
        return datos;
    }
}
