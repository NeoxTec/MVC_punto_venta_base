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
import models.modelLogin;
import views.viewLogin;

/**
 *
 * @author Diego
 */
public class controllerAdmin {
    public modelAdmin modelAdmin;
    public viewAdmin viewAdmin;
    public viewLogin viewLogin;
    
    /**
     * Objeto de tipo ActionListener para atrapar los eventos actionPerformed 
     */
    /**
     * Esta variable almacena el controllerAdmin para ser utilizado dentro del mismo JFrame
     */
     private Object controllers[];
     private controllerCatalogo controllerCatalogo;
    
    public controllerAdmin(modelAdmin modelAdmin, viewAdmin viewAdmin , Object[] controllers) {
        this.modelAdmin = modelAdmin;
        this.viewAdmin = viewAdmin;
        this.controllers = controllers;
        setControllers();
    }
    
    /**
     * Separa cada uno de los controlladores almacendados en controllers, de
     * esta forma se puede acceder a todas las variables y métodos publicos
     * de cada uno.
     */
    private void setControllers() {
        controllerCatalogo = (controllerCatalogo) controllers[0];
    }
    
    /*ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewAdmin.jb_empleados) {
                empleados_actionPerformed();
            } 
            else if (e.getSource() == viewAdmin.jb_catalogo){
                catalogo_actionPerformed();
            }

        }
    };
    

    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    /*private void setActionListener() {
        viewAdmin.jb_empleados.addActionListener(actionListener);
    }
    
    /**
     * Método que hara que se cambie al panel empleados
     */
    private void empleados_actionPerformed(){
        
    }
    
    /**
     * Método que hara que se cambie al panel empleados
     */
    private void catalogo_actionPerformed(){
        viewLogin.setContentPane(controllerCatalogo.viewCatalogo);
        viewLogin.revalidate();
        viewLogin.repaint();
        viewLogin.jmi_cambio.setVisible(false);
        viewLogin.jmi_cambio_validacion.setVisible(false);
        viewLogin.jmi_olvido.setVisible(false);
        
    }
 }

