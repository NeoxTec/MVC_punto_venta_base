/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.modelSucursal;
import views.viewSucursal;
import java.sql.*;
/**
 *
 * @author abi
 */
public class controllerSucursal {
    modelSucursal modelSucursal;
    viewSucursal viewSucursal;  
    public controllerSucursal(modelSucursal modelSucursal, viewSucursal viewSucursal) {
        this.modelSucursal = modelSucursal;
        this.viewSucursal = viewSucursal;
        setActionlistener();
        
        initComponents();
        initDB();
}
 public void initComponents() {

        viewSucursal.jtf_id.setEditable(true);
        viewSucursal.jtf_calle.setEditable(true);
        viewSucursal.jtf_colonia.setEditable(true);
        viewSucursal.jtf_noexterior.setEditable(true);
        viewSucursal.jtf_nointerior.setEditable(true);
        viewSucursal.jtf_cp.setEditable(true);
        viewSucursal.jtf_telefono.setEditable(true);
        
       // viewProveedor.jb_modificar.setEnabled(false);
       // viewProveedor.jb_eliminar.setEnabled(false);
 }

public void setActionlistener() {
        viewSucursal.jb_modificar.addActionListener(actionListener);
        viewSucursal.jb_eliminar.addActionListener(actionListener);
        viewSucursal.jb_agregar.addActionListener(actionListener);
        viewSucursal.jb_guardar.addActionListener(actionListener);
        viewSucursal.jb_cancelar.addActionListener(actionListener);
         }
public void initDB(){
    modelSucursal.conectarDB();
    
    viewSucursal.jtf_id.setText(modelSucursal.getId());
     viewSucursal.jtf_calle.setText(modelSucursal.getCalle());
      viewSucursal.jtf_colonia.setText(modelSucursal.getColonia());
       viewSucursal.jtf_noexterior.setText(modelSucursal.getNoexterior());
        viewSucursal.jtf_nointerior.setText(modelSucursal.getNointerior());
        viewSucursal.jtf_cp.setText(modelSucursal.getCp());
         viewSucursal.jtf_telefono.setText(modelSucursal.getTelefono());
          
}
    ActionListener actionListener = new ActionListener() {
        @Override        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewSucursal.jb_agregar) {

            jb_nuevo_actionPerformed();

            } else if (e.getSource() == viewSucursal.jb_modificar) {

             jb_modificar_actionPerformed();

            } else if (e.getSource() == viewSucursal.jb_eliminar) {

                jb_eliminar_actionPerformed();

            } else if (e.getSource() == viewSucursal.jb_guardar) {

               
               jb_insertar_actionPerformed();
               
               

            }
            else if (e.getSource() == viewSucursal.jb_cancelar) {

               
               
               jb_cancelar_actionPerformed();
               
            }
            
        }
    };

    public void jb_nuevo_actionPerformed() {
        viewSucursal.jtf_id.setText(""); 
        
        viewSucursal.jtf_calle.setText("");
        viewSucursal.jtf_colonia.setText("");
        viewSucursal.jtf_noexterior.setText("");
        viewSucursal.jtf_nointerior.setText("");
        viewSucursal.jtf_cp.setText("");
        viewSucursal.jtf_telefono.setText("");
        
        viewSucursal.jb_modificar.setEnabled(false);
       viewSucursal.jb_eliminar.setEnabled(false);
       viewSucursal.jb_agregar.setEnabled(false);
    }
    /**
     * Elimina un registro de la tabla contactos
     */
    public void jb_eliminar_actionPerformed() {
    modelSucursal.eliRegistro(); // Invoca metodo de eliminar 
    viewSucursal.jb_modificar.setEnabled(false);
       viewSucursal.jb_eliminar.setEnabled(false);
       viewSucursal.jb_agregar.setEnabled(false);
       modelSucursal.modiRegistro();
    }
 /**
     *Inserta registro en la tabla contactos
     */
    public void jb_insertar_actionPerformed() {
        modelSucursal.setId(viewSucursal.jtf_id.getText()); // Da el valor de nombre a la variable .
        modelSucursal.setCalle(viewSucursal.jtf_calle.getText()); 
        modelSucursal.setColonia(viewSucursal.jtf_colonia.getText());
        modelSucursal.setNoexterior(viewSucursal.jtf_noexterior.getText());
        modelSucursal.setNointerior(viewSucursal.jtf_nointerior.getText()); 
        modelSucursal.setCp(viewSucursal.jtf_cp.getText()); 
        modelSucursal.setTelefono(viewSucursal.jtf_telefono.getText()); 
        
        
      //  viewProveedor.jb_agregar.setEnabled(false);
       // viewProveedor.jb_modificar.setEnabled(false);
      // viewProveedor.jb_eliminar.setEnabled(false);
       
        modelSucursal.insertarRegistro(); // Invoca  Insertar un nuevo registro.
    }   
    /**
     * Método para modificar registros
     */
    public void jb_modificar_actionPerformed() {

        modelSucursal.setId(viewSucursal.jtf_id.getText()); // Da el valor de nombre a la variable .
        modelSucursal.setCalle(viewSucursal.jtf_calle.getText()); 
        modelSucursal.setColonia(viewSucursal.jtf_colonia.getText());
        modelSucursal.setNoexterior(viewSucursal.jtf_noexterior.getText());
        modelSucursal.setNointerior(viewSucursal.jtf_nointerior.getText()); 
        modelSucursal.setCp(viewSucursal.jtf_cp.getText()); 
        modelSucursal.setTelefono(viewSucursal.jtf_telefono.getText()); 
        
        
        
        viewSucursal.jb_agregar.setEnabled(false);
        
       viewSucursal.jb_eliminar.setEnabled(false);
        modelSucursal.modiRegistro(); // Invoca metodo de modificar .
    }
    public void jb_cancelar_actionPerformed() {
        System.out.println("registro cancelado");
        viewSucursal.jb_agregar.setEnabled(true);
        viewSucursal.jb_modificar.setEnabled(true);
       viewSucursal.jb_eliminar.setEnabled(true);
       viewSucursal.jb_guardar.setEnabled(true);
    }
}