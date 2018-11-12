/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.modelLogin;
import views.*;

/**
 *
 * @author Diego
 */
public class controllerLogin {
     private final modelLogin modelLogin;
     private final viewLogin viewLogin;
     private final viewAdmin viewAdmin;
     private final viewEmpleado viewEmpleado;
     
     /**
     * Esta variable almacena el controllerAdmin para ser utilizado dentro del mismo JFrame
     */
     private Object controllers[];
     private controllerAdmin controllerAdmin;
     private controllerCatalogo controllerCatalogo;
     private controllerEmpleado controllerEmpleado;
     
     
     /**
     * Controlador principal del proyecto que une el modelLogin y viewLogin, ademas
     * recibe los controllers de las demás interfaces
     * dentro del arreglo controllers, con esto se puede tener acceso a toda la
     * programación desarrollada dentro de cada controller.
     * @param modelLogin 
     * @param viewLogin
     * @param viewAdmin
     * @param viewEmpleado
     * @param controllers arreglo con todos los controladores del proyecto. 
     */
    public controllerLogin(modelLogin modelLogin, viewLogin viewLogin, viewAdmin viewAdmin,viewEmpleado viewEmpleado, Object[] controllers) {
        this.modelLogin = modelLogin;
        this.viewLogin = viewLogin;
        this.viewAdmin = viewAdmin;
        this.viewEmpleado = viewEmpleado;
        this.controllers = controllers;
        setControllers();
        setActionListener();
        initComponets();
    }
    
    /**
     * Separa cada uno de los controlladores almacendados en controllers, de
     * esta forma se puede acceder a todas las variables y métodos publicos
     * de cada uno.
     */
    private void setControllers() {
        controllerAdmin = (controllerAdmin) controllers[0];
        controllerCatalogo = (controllerCatalogo) controllers[1];
        controllerEmpleado = (controllerEmpleado) controllers [2];
    }
    
    /**
     * Muesta la vista principal ViewLogin
     */
    private void initComponets() {
        viewLogin.setTitle("Ferretería ACME");
        viewLogin.setLocationRelativeTo(null);
        viewLogin.setVisible(true);
        viewLogin.jmi_cambio.setVisible(false);
        viewLogin.jmi_cambio_validacion.setVisible(false);
        viewLogin.jmi_volver.setVisible(false);
        viewLogin.jmi_cerrar.setVisible(false);
    }
    
    /**
     * Asigna el actionListener al botón entrar de 
     * viewLogin.
     */
    private void setActionListener() {
        viewLogin.jb_entrar.addActionListener(actionListener);
        viewAdmin.jb_catalogo.addActionListener(actionListener);
        viewLogin.jmi_volver.addActionListener(actionListener);
        viewAdmin.jb_empleados.addActionListener(actionListener);
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
            else if (e.getSource() == viewAdmin.jb_catalogo){
                catalogo_actionPerformed();        
            }
            else if(e.getSource() == viewLogin.jmi_volver){
                jb_entrar_actionPerformed();
            }
            else if(e.getSource() == viewAdmin.jb_empleados){
                 empleado_actionPerformed();
            }
        }
     };
    
    private void jb_entrar_actionPerformed(){
        viewLogin.setContentPane(controllerAdmin.viewAdmin);
        viewLogin.revalidate();
        viewLogin.repaint();
        viewLogin.jmi_cambio.setVisible(true);
        viewLogin.jmi_cambio_validacion.setVisible(true);
        viewLogin.jmi_olvido.setVisible(false);
        viewLogin.jmi_cerrar.setVisible(true);
        viewLogin.jmi_volver.setVisible(false);
    }
    
    /**
     * Método que hara que se cambie al panel catalogo
     */
    private void catalogo_actionPerformed(){
        viewLogin.setContentPane(controllerCatalogo.viewCatalogo);
        viewLogin.revalidate();
        viewLogin.repaint();
        viewLogin.jmi_cambio.setVisible(false);
        viewLogin.jmi_cambio_validacion.setVisible(false);
        viewLogin.jmi_olvido.setVisible(false);
        viewLogin.jmi_volver.setVisible(true);
        viewLogin.jmi_cerrar.setVisible(false);
        
    }
    
    /**
     * Método que hara que se cambie al panel catalogo
     */
    private void empleado_actionPerformed(){
        viewLogin.setContentPane(controllerEmpleado.viewEmpleado);
        viewLogin.revalidate();
        viewLogin.repaint();
        viewLogin.jmi_cambio.setVisible(false);
        viewLogin.jmi_cambio_validacion.setVisible(false);
        viewLogin.jmi_olvido.setVisible(false);
        viewLogin.jmi_volver.setVisible(true);
        viewLogin.jmi_cerrar.setVisible(false);
        
    }
    
    
} 
