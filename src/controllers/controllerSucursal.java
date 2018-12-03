/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import models.modelSucursal;
import views.viewSucursal;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
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
        this.viewSucursal.jt_sucursales.addMouseListener(ml);
        this.viewSucursal.jtf_buscar.addKeyListener(kl);
        viewSucursal.jtf_id.setEditable(false);
        setActionlistener();       
        initComponents();
}
 public void initComponents() {
        modelSucursal.conectarDB();
        modelSucursal.setSentencia("select * from sucursal;");
        modelSucursal.llenartabla();
        viewSucursal.jt_sucursales.setModel(modelSucursal.getT_sucursal());
        viewSucursal.jb_agregar.setEnabled(true);
        viewSucursal.jb_modificar.setEnabled(true);
        viewSucursal.jb_eliminar.setEnabled(true);
        viewSucursal.jb_guardar.setEnabled(false);
        viewSucursal.jb_cancelar.setEnabled(false);
        celdas(false);
 }

public void setActionlistener() {
        viewSucursal.jb_modificar.addActionListener(actionListener);
        viewSucursal.jb_eliminar.addActionListener(actionListener);
        viewSucursal.jb_agregar.addActionListener(actionListener);
        viewSucursal.jb_guardar.addActionListener(actionListener);
        viewSucursal.jb_cancelar.addActionListener(actionListener);
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

               
               jb_guardar_actionPerformed();             

            }
            else if (e.getSource() == viewSucursal.jb_cancelar) {

               
               
               jb_cancelar_actionPerformed();
               
            }
            
        }
    };

     /**
      * Constructor que realiza las acciones del buscador
      */
     KeyListener kl = new KeyListener(){
         @Override
        public void keyTyped(KeyEvent e) {
        }
        @Override
        public void keyPressed(KeyEvent e) {
            jb_buscar_keypresseed();
        }
        @Override
        public void keyReleased(KeyEvent e) {
        }
     };
     
   MouseListener ml = new MouseListener(){
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource()== viewSucursal.jt_sucursales){
                jt_sucursales_mouseClicked();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) { }

        @Override
        public void mouseReleased(MouseEvent e) { }

        @Override
        public void mouseEntered(MouseEvent e) { }

        @Override
        public void mouseExited(MouseEvent e) { }
    };
    public void jb_nuevo_actionPerformed() {
        celdas(true);
        viewSucursal.jtf_id.setText(""); 
        viewSucursal.jtf_calle.setText("");
        viewSucursal.jtf_colonia.setText("");
        viewSucursal.jtf_noexterior.setText("");
        viewSucursal.jtf_nointerior.setText("");
        viewSucursal.jtf_cp.setText("");
        viewSucursal.jtf_telefono.setText("");
        modelSucursal.setId(0);
        
        viewSucursal.jb_modificar.setEnabled(false);
       viewSucursal.jb_eliminar.setEnabled(false);
       viewSucursal.jb_agregar.setEnabled(false);
       viewSucursal.jb_guardar.setEnabled(true);
       viewSucursal.jb_cancelar.setEnabled(true);
    }
    /**
     * Elimina un registro de la tabla contactos
     */
    public void jb_eliminar_actionPerformed() {
    modelSucursal.eliRegistro(); // Invoca metodo de eliminar 
        celdas(false);
       viewSucursal.jb_modificar.setEnabled(true);
       viewSucursal.jb_eliminar.setEnabled(true);
       viewSucursal.jb_agregar.setEnabled(true);
       viewSucursal.jb_cancelar.setEnabled(false);
       viewSucursal.jb_guardar.setEnabled(false);
    }
 /**
     *Inserta registro en la tabla contactos
     */
    public void jb_guardar_actionPerformed() {
        if(viewSucursal.jtf_nointerior.getText().isEmpty())
            modelSucursal.setNointerior(0);
        if(viewSucursal.jtf_telefono.getText().isEmpty())
            modelSucursal.setTelefono("Sin numero telefónico");
        if(viewSucursal.jtf_calle.getText().isEmpty() || viewSucursal.jtf_colonia.getText().isEmpty() || viewSucursal.jtf_cp.getText().isEmpty() || viewSucursal.jtf_noexterior.getText().isEmpty())
             JOptionPane.showMessageDialog(null, "Ingrese valores de calle, colonia, código postal, y número exterior para poder registrar la sucursal");
        else{
        modelSucursal.setCalle(viewSucursal.jtf_calle.getText()); 
        modelSucursal.setColonia(viewSucursal.jtf_colonia.getText());
        modelSucursal.setNoexterior(Integer.parseInt(viewSucursal.jtf_noexterior.getText()));
        modelSucursal.setNointerior(Integer.parseInt(viewSucursal.jtf_nointerior.getText())); 
        modelSucursal.setCp(viewSucursal.jtf_cp.getText()); 
        modelSucursal.setTelefono(viewSucursal.jtf_telefono.getText()); 
        if (modelSucursal.getId() == 0)
            modelSucursal.insertarRegistro(); // Invoca  Insertar un nuevo registro. 
        else
            modelSucursal.modiRegistro(); // Invoca metodo de modificar .
         limpiar();
         initComponents();
    }}   
    /**
     * Método para modificar registros
     */
    public void jb_modificar_actionPerformed() {     
        celdas(true);
        viewSucursal.jb_agregar.setEnabled(false);
        viewSucursal.jb_modificar.setEnabled(false);
       viewSucursal.jb_eliminar.setEnabled(false);
       viewSucursal.jb_cancelar.setEnabled(true);
       viewSucursal.jb_guardar.setEnabled(true);
    }
    public void jb_cancelar_actionPerformed() {
        System.out.println("registro cancelado");
        celdas(false);
        viewSucursal.jtf_id.setText(""); 
        viewSucursal.jtf_calle.setText("");
        viewSucursal.jtf_colonia.setText("");
        viewSucursal.jtf_noexterior.setText("");
        viewSucursal.jtf_nointerior.setText("");
        viewSucursal.jtf_cp.setText("");
        viewSucursal.jtf_telefono.setText("");
        
       viewSucursal.jb_agregar.setEnabled(true);
        viewSucursal.jb_modificar.setEnabled(true);
       viewSucursal.jb_eliminar.setEnabled(true);
       viewSucursal.jb_guardar.setEnabled(false);
       viewSucursal.jb_cancelar.setEnabled(false);
    }
    
      /**
      * Metodo que permite mostrar los datos de la base de datos en los campos al seleccionar la tabla de la vista.
      */
     public void jt_sucursales_mouseClicked(){
          int linea;
          linea = viewSucursal.jt_sucursales.getSelectedRow();
          modelSucursal.setId((int) viewSucursal.jt_sucursales.getValueAt(linea, 0));
          modelSucursal.datos();
          viewSucursal.jtf_id.setText(String.valueOf(modelSucursal.getId()));
          viewSucursal.jtf_calle.setText(modelSucursal.getCalle());
          viewSucursal.jtf_colonia.setText(modelSucursal.getColonia());
          viewSucursal.jtf_cp.setText(modelSucursal.getCp());
          viewSucursal.jtf_noexterior.setText(String.valueOf(modelSucursal.getNoexterior()));
          viewSucursal.jtf_nointerior.setText(String.valueOf(modelSucursal.getNointerior()));
          viewSucursal.jtf_telefono.setText(modelSucursal.getTelefono());
}
     public void celdas(boolean i){
         viewSucursal.jtf_calle.setEditable(i);
         viewSucursal.jtf_colonia.setEditable(i);
         viewSucursal.jtf_cp.setEditable(i);
         viewSucursal.jtf_noexterior.setEditable(i);
         viewSucursal.jtf_nointerior.setEditable(i);
         viewSucursal.jtf_telefono.setEditable(i);
     }
     
      /**
      * Metodo que elimina los registros de la tabla de catalogo.
      */
     public void limpiar(){
          for (int i = 0; i < viewSucursal.jt_sucursales.getRowCount(); i++) {
            modelSucursal.getT_sucursal().removeRow(i);
            i -= 1;
        }
     }
     
      /**
      * Metodo que vacia la tabla de la vista catalogo y la vuelve a llenar los datos que coincidan con el jtf_buscar.
      * Por cada tecla escrita en el jtf_buscar se repetira la accion. 
      */
     public void jb_buscar_keypresseed(){
         String sql = "SELECT * FROM sucursal where calle like '"+viewSucursal.jtf_buscar.getText()+"%' OR colonia like '"+viewSucursal.jtf_buscar.getText()+"%'";
         modelSucursal.setSentencia(sql);
         limpiar();
         modelSucursal.llenartabla();
         viewSucursal.jt_sucursales.setModel(modelSucursal.getT_sucursal());
     }
}