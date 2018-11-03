/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.viewAdmin;
import models.modelAdmin;
/**
 *
 * @author Diego
 */
public class controllerAdmin {
    public modelAdmin modelAdmin;
    public viewAdmin viewAdmin;
    
    /**
     * Objeto de tipo ActionListener para atrapar los eventos actionPerformed 
     */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewAdmin.jb_empleados) {
                empleados_actionPerformed();
            } 

        }
    };
    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    private void setActionListener() {
        viewAdmin.jb_empleados.addActionListener(actionListener);
    }
    
    /**
     * Constructor de Controlador para unir el modelAdmin y viewAdmin
     *
     * @param modelAdmin objeto de tipo modelAdmin
     * @param viewAdmin objeto de tipo viewAdmin
     */
    public controllerAdmin(modelAdmin modelAdmin, viewAdmin viewAdmin) {
        this.modelAdmin = modelAdmin;
        this.viewAdmin = viewAdmin;
        setActionListener();
    }
    
    /**
     * Método que hara que se cambie al panel empleados
     */
    private void empleados_actionPerformed(){
        
    }
}
