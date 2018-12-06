/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import models.modelUsuario;
import views.viewUsuario;
/**
 *
 * @author Diego
 */
public class controllerUsuario {
    public modelUsuario modelUsuario;
    public viewUsuario viewUsuario;
    
    public controllerUsuario(modelUsuario modelUsuario, viewUsuario viewUsuario) {
        this.modelUsuario = modelUsuario;
        this.viewUsuario = viewUsuario;
        initDB();
        setMouseListener();
        if(modelUsuario.isEliminar()){
            eliminar();
        }
            
    }
    
    /**
     * Metodo que hace la conexion a la base de datos, muestra los registros en la tabla y habilita o deshabilita los botones de la vista
     */
        public void initDB(){
        modelUsuario.conectarDB();
        modelUsuario.setSentencia("SELECT username,tipo,id_sucursal,rfc_e FROM usuario");
        modelUsuario.llenartabla();
        viewUsuario.jt_usuarios.setModel(modelUsuario.getModelo());
        
    }
        MouseListener ml = new MouseListener(){
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource() == viewUsuario.jt_usuarios){
                jt_usuarios_mouseClicked();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
            
        };
    
    
       /*
       * Metodo que permite mostrar los datos de la base de datos en los campos al seleccionar la tabla de la vista. 
       */ 
       private void jt_usuarios_mouseClicked(){
        int linea;
        linea = viewUsuario.jt_usuarios.getSelectedRow();
        modelUsuario.setUsername((String) viewUsuario.jt_usuarios.getValueAt(linea, 0));
        modelUsuario.datos();
        setValues();
    }
       /*
       * Método para agregar el mouselistener a algun componente
       */
       private void setMouseListener(){
           viewUsuario.jt_usuarios.addMouseListener(ml);
       }
       
       /*
       *Muestra los valores almacenados en el modelUsuario al viewUsuario
       */
       private void setValues(){
           viewUsuario.jtf_rfc.setText(modelUsuario.getRfc_e());
           viewUsuario.jtf_sucursal.setText(String.valueOf(modelUsuario.getSucursal()));
           viewUsuario.jcb_puesto.setSelectedItem(modelUsuario.getTipo());
       }
       
    /*
    * Método que va depurando la tabla a la hora de la busqueda
    */
    private void limpiar(){
        for (int i = 0; i < viewUsuario.jt_usuarios.getRowCount(); i++){
            modelUsuario.getModelo().removeRow(i);
            i -=1;
        }
    }
       /*
       * Método de actualización de la tabla al eliminar algun empleado
       */
       private void eliminar(){
           limpiar();
           initDB();
       }
}

