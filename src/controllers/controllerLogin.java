/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.viewLogin;
import models.modelLogin;
/**
 *
 * @author Diego
 */
public class controllerLogin {
     private modelLogin modelLogin;
     private viewLogin viewLogin;
     
     private Object controllers[];
     private controllerAdmin controllerAdmin;
     
     
     
     /**
     * Controlador principal del proyecto que une el modelLogin y viewLogin, ademas
     * recibe los controllers de las demás interfaces
     * dentro del arreglo controllers, con esto se puede tener acceso a toda la
     * programación desarrollada dentro de cada controller.
     * @param modelLogin 
     * @param viewLogin
     * @param controllers arreglo con todos los controladores del proyecto. 
     */
    public controllerLogin(modelLogin modelLogin, viewLogin viewLogin, Object[] controllers) {
        this.modelLogin = modelLogin;
        this.viewLogin = viewLogin;
        this.controllers = controllers;
        initComponets();
    }
    
    /**
     * Muesta la vista principal ViewMain.
     */
    private void initComponets() {
        viewLogin.setTitle("Login");
        viewLogin.setLocationRelativeTo(null);
        viewLogin.setVisible(true);
    }
    
    /**
     * Asigna el actionListener al botón entrar de 
     * viewLogin.
     */
    private void setActionListener() {
        viewLogin.jb_entrar.addActionListener(actionListener);
        
    }
    
    /**
     * Evalua el componente que genero el evento y llama a un método en particular.
     */
    private final ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewLogin.jb_entrar) {
                jb_entrar_actionPerformed();
            } 
        }
    };
    
    private void jb_entrar_actionPerformed(){
        viewLogin.setContentPane(controllerAdmin.viewAdmin);
        viewLogin.revalidate();
        viewLogin.repaint();
    }
}
