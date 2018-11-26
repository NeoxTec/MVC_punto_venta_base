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
    modelProveedor modelProveedor;
    viewProveedor viewProveedor;  
    public controllerProveedor(modelProveedor modelProveedor, viewProveedor viewProveedor) {
        this.modelProveedor = modelProveedor;
        this.viewProveedor = viewProveedor;
        setActionlistener();
        
        initComponents();
        initDB();
}
 public void initComponents() {

        viewProveedor.jtf_rfc.setEditable(true);
        viewProveedor.jtf_razons.setEditable(true);
        viewProveedor.jtf_calle.setEditable(true);
        viewProveedor.jtf_colonia.setEditable(true);
        viewProveedor.jtf_no_ext.setEditable(true);
        viewProveedor.jtf_cp.setEditable(true);
        viewProveedor.jtf_telefono.setEditable(true);
        viewProveedor.jtf_correo.setEditable(true);
       // viewProveedor.jb_modificar.setEnabled(false);
       // viewProveedor.jb_eliminar.setEnabled(false);
 }

public void setActionlistener() {
        viewProveedor.jb_modificar.addActionListener(actionListener);
        viewProveedor.jb_eliminar.addActionListener(actionListener);
        viewProveedor.jb_agregar.addActionListener(actionListener);
        viewProveedor.jb_guardar.addActionListener(actionListener);
        viewProveedor.jb_cancelar.addActionListener(actionListener);
         }
public void initDB(){
    modelProveedor.conectarDB();
    
    viewProveedor.jtf_rfc.setText(modelProveedor.getRfc());
    viewProveedor.jtf_razons.setText(modelProveedor.getRazons());
     viewProveedor.jtf_calle.setText(modelProveedor.getCalle());
      viewProveedor.jtf_colonia.setText(modelProveedor.getColonia());
       viewProveedor.jtf_no_ext.setText(modelProveedor.getNoext());
        viewProveedor.jtf_cp.setText(modelProveedor.getCp());
         viewProveedor.jtf_telefono.setText(modelProveedor.getTelefono());
          viewProveedor.jtf_correo.setText(modelProveedor.getCorreo());
}
    ActionListener actionListener = new ActionListener() {
        @Override        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewProveedor.jb_agregar) {

            jb_nuevo_actionPerformed();

            } else if (e.getSource() == viewProveedor.jb_modificar) {

             jb_modificar_actionPerformed();

            } else if (e.getSource() == viewProveedor.jb_eliminar) {

                jb_eliminar_actionPerformed();

            } else if (e.getSource() == viewProveedor.jb_guardar) {

               
               jb_insertar_actionPerformed();
               
               

            }
            else if (e.getSource() == viewProveedor.jb_cancelar) {

               
               
               jb_cancelar_actionPerformed();
               

            }
            
        }
    };
    

    public void jb_nuevo_actionPerformed() {
        viewProveedor.jtf_rfc.setText(""); 
        viewProveedor.jtf_razons.setText("");
        viewProveedor.jtf_calle.setText("");
        viewProveedor.jtf_colonia.setText("");
        viewProveedor.jtf_no_ext.setText("");
        
        viewProveedor.jtf_cp.setText("");
        viewProveedor.jtf_telefono.setText("");
        viewProveedor.jtf_correo.setText("");
        viewProveedor.jb_modificar.setEnabled(false);
       viewProveedor.jb_eliminar.setEnabled(false);
    }
    /**
     * Elimina un registro de la tabla contactos
     */
    public void jb_eliminar_actionPerformed() {
    modelProveedor.eliRegistro(); // Invoca metodo de eliminar 
    viewProveedor.jb_modificar.setEnabled(false);
       viewProveedor.jb_eliminar.setEnabled(false);
       viewProveedor.jb_agregar.setEnabled(false);
       modelProveedor.modiRegistro();
    }
 /**
     *Inserta registro en la tabla contactos
     */
    public void jb_insertar_actionPerformed() {
        modelProveedor.setRfc(viewProveedor.jtf_rfc.getText()); // Da el valor de nombre a la variable .
        modelProveedor.setCalle(viewProveedor.jtf_calle.getText()); 
        modelProveedor.setColonia(viewProveedor.jtf_colonia.getText());
        modelProveedor.setNoext(viewProveedor.jtf_no_ext.getText());
        modelProveedor.setRazons(viewProveedor.jtf_razons.getText()); 
        modelProveedor.setCp(viewProveedor.jtf_cp.getText()); 
        modelProveedor.setTelefono(viewProveedor.jtf_telefono.getText()); 
        modelProveedor.setCorreo(viewProveedor.jtf_correo.getText()); 
        
      //  viewProveedor.jb_agregar.setEnabled(false);
       // viewProveedor.jb_modificar.setEnabled(false);
      // viewProveedor.jb_eliminar.setEnabled(false);
       
        modelProveedor.insertarRegistro(); // Invoca  Insertar un nuevo registro.
    }   
    /**
     * Método para modificar registros
     */
    public void jb_modificar_actionPerformed() {

        modelProveedor.setRfc(viewProveedor.jtf_rfc.getText()); // Da el valor de nombre a la variable .
        modelProveedor.setCalle(viewProveedor.jtf_calle.getText()); 
        modelProveedor.setColonia(viewProveedor.jtf_colonia.getText());
        modelProveedor.setNoext(viewProveedor.jtf_no_ext.getText());
        modelProveedor.setRazons(viewProveedor.jtf_razons.getText()); 
        modelProveedor.setCp(viewProveedor.jtf_cp.getText()); 
        modelProveedor.setTelefono(viewProveedor.jtf_telefono.getText()); 
        modelProveedor.setCorreo(viewProveedor.jtf_correo.getText()); 
        
        
        viewProveedor.jb_agregar.setEnabled(false);
        
       viewProveedor.jb_eliminar.setEnabled(false);
        modelProveedor.modiRegistro(); // Invoca metodo de modificar .
    }
    public void jb_cancelar_actionPerformed() {
        System.out.println("registro cancelado");
        viewProveedor.jb_agregar.setEnabled(true);
        viewProveedor.jb_modificar.setEnabled(true);
       viewProveedor.jb_eliminar.setEnabled(true);
       viewProveedor.jb_guardar.setEnabled(true);
    }
}