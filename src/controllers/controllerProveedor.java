/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import controllers.controllerProveedor;
import models.modelProveedor;
import views.viewProveedor;
/**
 *
 * @author Abi Montes
 */
public class controllerProveedor {
    modelProveedor ModelProveedor;
    viewProveedor viewProveedor;  
    public controllerProveedor(modelProveedor modelProveedor, viewProveedor viewProveedor) {
        this.ModelProveedor = modelProveedor;
        this.viewProveedor = viewProveedor;
        setActionlistener();
        
        initComponents();
}
 public void initComponents() {

        viewProveedor.jtf_rfc.setEditable(true);
        viewProveedor.jtf_razons.setEditable(true);
        viewProveedor.jtf_calle.setEditable(false);
        viewProveedor.jtf_calle.setEditable(false);
        viewProveedor.jtf_no_ext.setEditable(false);
        viewProveedor.jtf_cp.setEditable(false);
        viewProveedor.jtf_telefono.setEditable(false);
        viewProveedor.jtf_correo.setEditable(false);
        viewProveedor.jb_cancelar.setEnabled(false);
        viewProveedor.jb_guardar.setEnabled(false);
 }

public void setActionlistener() {
        viewProveedor.jb_modificar.addActionListener(actionListener);
        viewProveedor.jb_eliminar.addActionListener(actionListener);
        viewProveedor.jb_agregar.addActionListener(actionListener);
        viewProveedor.jb_guardar.addActionListener(actionListener);
        viewProveedor.jb_cancelar.addActionListener(actionListener);
        

    }
    ActionListener actionListener = new ActionListener() {
        @Override        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewProveedor.jb_agregar) {

             jb_insertar_actionPerformed();

            } else if (e.getSource() == viewProveedor.jb_modificar) {

             jb_modificar_actionPerformed();

            } else if (e.getSource() == viewProveedor.jb_eliminar) {

                jb_eliminar_actionPerformed();

            } else if (e.getSource() == viewProveedor.jb_guardar) {

               jb_nuevo_actionPerformed();
               
               
               

            }
        }
    };
    

    /**
     * Método para ver el registro anterior de la tabla contactos
     */
   
    /**
     * Método para ver el siguiente registro de la tabla contactos
     */
    
    
    /**
     * Método para ver el último registro de la tabla contactos
     */
    
    
    /**
     * Método para preparar la interfaz para colocar un nuevo registro en la tabla contactos
     */
    public void jb_nuevo_actionPerformed() {
        viewProveedor.jtf_rfc.setText(""); 
        viewProveedor.jtf_calle.setText("");
        viewProveedor.jtf_colonia.setText("");
        viewProveedor.jtf_no_ext.setText("");
        viewProveedor.jtf_razons.setText("");
        viewProveedor.jtf_cp.setText("");
        viewProveedor.jtf_telefono.setText("");
        viewProveedor.jtf_correo.setText("");
    }
    /**
     * Elimina un registro de la tabla contactos
     */
    public void jb_eliminar_actionPerformed() {
    ModelProveedor.eliRegistro(); // Invoca metodo de eliminar 
    }
 /**
     *Inserta registro en la tabla contactos
     */
    public void jb_insertar_actionPerformed() {
        ModelProveedor.setRfc(viewProveedor.jtf_rfc.getText()); // Da el valor de nombre a la variable .
        ModelProveedor.setNombre(viewProveedor.jtf_calle.getText()); 
        ModelProveedor.setCalle(viewProveedor.jtf_colonia.getText());
        ModelProveedor.setColonia(viewProveedor.jtf_no_ext.getText());
        ModelProveedor.setNoext(viewProveedor.jtf_razons.getText()); 
        ModelProveedor.setCp(viewProveedor.jtf_cp.getText()); 
        ModelProveedor.setTelefono(viewProveedor.jtf_telefono.getText()); 
        ModelProveedor.setCorreo(viewProveedor.jtf_correo.getText()); 
        
        
        
        ModelProveedor.insertarRegistro(); // Invoca  Insertar un nuevo registro.
    }   
    /**
     * Método para modificar registros
     */
    public void jb_modificar_actionPerformed() {

           ModelProveedor.setRfc(viewProveedor.jtf_rfc.getText()); // Da el valor de nombre a la variable .
        ModelProveedor.setNombre(viewProveedor.jtf_calle.getText()); 
        ModelProveedor.setCalle(viewProveedor.jtf_colonia.getText());
        ModelProveedor.setColonia(viewProveedor.jtf_no_ext.getText());
        ModelProveedor.setNoext(viewProveedor.jtf_razons.getText()); 
        ModelProveedor.setCp(viewProveedor.jtf_cp.getText()); 
        ModelProveedor.setTelefono(viewProveedor.jtf_telefono.getText()); 
        ModelProveedor.setCorreo(viewProveedor.jtf_correo.getText()); 
        
        ModelProveedor.modiRegistro(); // Invoca metodo de modificar .
    }
}