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
     private final viewInicio viewInicio;
     private final viewAdmin viewAdmin;
     private final viewEmpleado viewEmpleado;
     private final viewVendedor viewVendedor;
     private final viewProveedor viewProveedor;
     private final viewCompra viewCompra;
     
     
     /**
     * Esta variable almacena el controllerAdmin para ser utilizado dentro del mismo JFrame
     */
     private Object controllers[];
     private controllerInicio controllerInicio;
     private controllerAdmin controllerAdmin;
     private controllerCatalogo controllerCatalogo;
     private controllerEmpleado controllerEmpleado;
     private controllerVendedor controllerVendedor;
     private controllerProveedor controllerProveedor;
     private controllerCompras controllerCompras;
     
     
     /**
     * Controlador principal del proyecto que une el modelLogin y viewLogin, ademas
     * recibe los controllers de las demás interfaces
     * dentro del arreglo controllers, con esto se puede tener acceso a toda la
     * programación desarrollada dentro de cada controller.
     * @param modelLogin 
     * @param viewLogin
     * @param viewInicio
     * @param viewAdmin
     * @param viewEmpleado
     * @param viewVendedor
     * @param viewProveedor
     * @param controllers arreglo con todos los controladores del proyecto. 
     */
    public controllerLogin(modelLogin modelLogin, viewLogin viewLogin,viewInicio viewInicio, viewAdmin viewAdmin,viewEmpleado viewEmpleado,viewVendedor viewVendedor,viewProveedor viewProveedor, viewCompra viewCompra, Object[] controllers) {
        this.modelLogin = modelLogin;
        this.viewInicio = viewInicio;
        this.viewLogin = viewLogin;
        this.viewAdmin = viewAdmin;
        this.viewEmpleado = viewEmpleado;
        this.viewVendedor = viewVendedor;
        this.viewProveedor = viewProveedor;
        this.viewCompra = viewCompra;
        this.controllers = controllers;
        setControllers();
        setActionListener();
        initComponets();
        inicio_actionPerformed();
    }

    
    /**
     * Separa cada uno de los controlladores almacendados en controllers, de
     * esta forma se puede acceder a todas las variables y métodos publicos
     * de cada uno.
     */
    private void setControllers() {
        controllerInicio = (controllerInicio) controllers[0];
        controllerAdmin = (controllerAdmin) controllers[1];
        controllerCatalogo = (controllerCatalogo) controllers[2];
        controllerEmpleado = (controllerEmpleado) controllers [3];
        controllerVendedor = (controllerVendedor) controllers [4];
        controllerProveedor = (controllerProveedor) controllers[5];
        controllerCompras = (controllerCompras) controllers [6];
    }
    /*
    * Método que oculta el JMenu al iniciar el JFrame
    */
    private void ocultar(){
        viewLogin.jm_opciones.setVisible(false);
    }
    /*
    * Método para descoltar el JMenu 
    */
    private void desocultar(){
        viewLogin.jm_opciones.setVisible(true);
    }
    /**
     * Muesta la vista principal ViewLogin
     */
    private void initComponets() {
        viewLogin.setTitle("Ferretería ACME");
        viewLogin.setLocationRelativeTo(null);
        viewLogin.setVisible(true);
        ocultar();
    }
    
    /**
     * Asigna el actionListener al botón entrar de 
     * viewLogin.
     */
    private void setActionListener() {
        viewLogin.jmi_cerrar.addActionListener(actionListener);
        viewInicio.jb_entrar.addActionListener(actionListener);
        viewAdmin.jb_catalogo.addActionListener(actionListener);
        viewLogin.jmi_volver.addActionListener(actionListener);
        viewAdmin.jb_empleados.addActionListener(actionListener);
        viewLogin.jb_admin.addActionListener(actionListener);
        viewLogin.jb_vendedor.addActionListener(actionListener);
        viewAdmin.jb_proovedores.addActionListener(actionListener);
        viewAdmin.jb_compras.addActionListener(actionListener);
    }
    
    /**
     * Evalua el componente que genero el evento y llama a un método en particular.
     */
    private final ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewInicio.jb_entrar) {
                
            } 
            else if (e.getSource() == viewAdmin.jb_catalogo){
                catalogo_actionPerformed();        
            }
            else if(e.getSource() == viewLogin.jmi_volver){
                admin_actionPerformed();
            }
            else if(e.getSource() == viewAdmin.jb_empleados){
                 empleado_actionPerformed();
            }
            else if(e.getSource() == viewAdmin.jb_proovedores){
                proveedor_actionPerformed();
            }
            else if(e.getSource() == viewLogin.jmi_cerrar){
                inicio_actionPerformed();
            }
            else if (e.getSource() == viewLogin.jb_admin){
                admin_actionPerformed();
                desocultar();
             }
            else if (e.getSource() == viewLogin.jb_vendedor) {
                vendedor_actionPerformed();
                desocultar();
            }
            else if(e.getSource() == viewAdmin.jb_compras){
                compras_actionPerformed();
            }
        }
     };
    
    /**
     * Método para iniciar el frame con el panel Inicio y al momento de cerrar sesión
     */
    private void inicio_actionPerformed(){
        viewLogin.setContentPane(controllerInicio.viewInicio);
        viewLogin.revalidate();
        viewLogin.repaint();
        viewLogin.jmi_cambio.setVisible(false);
        viewLogin.jmi_cambio_validacion.setVisible(false);
        viewLogin.jmi_volver.setVisible(false);
        viewLogin.jmi_cerrar.setVisible(false);
    }
    /**
     * Método para hacer cambio al panel Admin
     */
    private void admin_actionPerformed(){
        viewLogin.setContentPane(controllerAdmin.viewAdmin);
        viewLogin.revalidate();
        viewLogin.repaint();
        viewLogin.jmi_cambio.setVisible(true);
        viewLogin.jmi_cambio_validacion.setVisible(true);
        viewLogin.jmi_olvido.setVisible(false);
        viewLogin.jmi_cerrar.setVisible(true);
        viewLogin.jmi_volver.setVisible(false);
    }
    /*
    * Método para hacer cambio al panel Vendedor
    */
    private void vendedor_actionPerformed(){
        viewLogin.setContentPane(controllerVendedor.viewVendedor);
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
     * Método que hara que se cambie al panel empleado
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
    
    /**
     * Método que hara que se cambie al panel proveedor
     */
    private void proveedor_actionPerformed(){
        viewLogin.setContentPane(controllerProveedor.viewProveedor);
        viewLogin.revalidate();
        viewLogin.repaint();
        viewLogin.jmi_cambio.setVisible(false);
        viewLogin.jmi_cambio_validacion.setVisible(false);
        viewLogin.jmi_olvido.setVisible(false);
        viewLogin.jmi_volver.setVisible(true);
        viewLogin.jmi_cerrar.setVisible(false);
    }
    
    /**
     * Método que hara que se cambie al panel compras
     */
    
    private void compras_actionPerformed(){
        viewLogin.setContentPane(controllerCompras.viewCompra);
        viewLogin.revalidate();
        viewLogin.repaint();
        viewLogin.jmi_cambio.setVisible(false);
        viewLogin.jmi_cambio_validacion.setVisible(false);
        viewLogin.jmi_olvido.setVisible(false);
        viewLogin.jmi_volver.setVisible(true);
        viewLogin.jmi_cerrar.setVisible(false);
    }
    
    
} 
