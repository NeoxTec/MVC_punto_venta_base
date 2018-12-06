/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.modelLogin;
import views.*;

/**
 *
 * @author Diego
 */
public class controllerLogin {
     private final modelLogin modelLogin;
     private final viewLogin viewLogin;



     /**
     * Esta variable almacena los controllers para ser utilizados dentro del mismo JFrame
     */
     private Object controllers[];
     private controllerAdmin controllerAdmin;
     private controllerCatalogo controllerCatalogo;
     private controllerEmpleado controllerEmpleado;
     private controllerVendedor controllerVendedor;
     private controllerProveedor controllerProveedor;
     private controllerCompras controllerCompras;
     private controllerInicio controllerInicio;
     private controllerDetalleCompra controllerDetalleCompra;
     private controllerVentasConsulta controllerVentasConsulta;
     private controllerSucursal controllerSucursal;

     /*
     * Esta variable almacena los views para ser utilizados dentro del mismo JFrame
     */
     private Object views[];
     private  viewAdmin viewAdmin;
     private  viewCatalogo viewCatalogo;
     private  viewEmpleado viewEmpleado;
     private  viewVendedor viewVendedor;
     private  viewProveedor viewProveedor;
     private  viewCompra viewCompra;
     private  viewInicio viewInicio;
     private viewDetallecompra viewDetallecompra;
     private viewVentasConsulta viewVentasConsulta;
     private viewSucursal viewSucursal;
     /**
     * Controlador principal del proyecto que une el modelLogin y viewLogin, ademas
     * recibe los controllers de las demás interfaces
     * dentro del arreglo controllers, con esto se puede tener acceso a toda la
     * programación desarrollada dentro de cada controller.
     *
     * @param modelLogin
     * @param viewLogin
     * @param views arreglo con todas las vistas del proyecto.
     * @param controllers arreglo con todos los controladores del proyecto.
     */
    public controllerLogin(modelLogin modelLogin, viewLogin viewLogin, Object [] views, Object[] controllers) {
        this.modelLogin = modelLogin;
        this.viewLogin = viewLogin;
        this.views = views;
        this.controllers = controllers;
        setViews();
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
        controllerVendedor = (controllerVendedor) controllers [3];
        controllerProveedor = (controllerProveedor) controllers[4];
        controllerCompras = (controllerCompras) controllers [5];
        controllerInicio = (controllerInicio) controllers[6];
        controllerDetalleCompra = (controllerDetalleCompra) controllers[7];
        controllerVentasConsulta = (controllerVentasConsulta) controllers[8];
        controllerSucursal = (controllerSucursal) controllers[9];
    }
    /*
    * Separa cada uno de los views almacendados en views, de
     * esta forma se puede acceder a todas los objetos dentro de cada panel
    */
    private void setViews(){
        viewAdmin = (viewAdmin) views[0];
        viewCatalogo = (viewCatalogo) views[1];
        viewEmpleado = (viewEmpleado) views[2];
        viewVendedor  = (viewVendedor) views[3];
        viewProveedor = (viewProveedor) views[4];
        viewCompra = (viewCompra) views [5];
        viewInicio = (viewInicio) views[6];
        viewDetallecompra = (viewDetallecompra) views[7];
        viewVentasConsulta = (viewVentasConsulta) views[8];
        viewSucursal = (viewSucursal) views[9];
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
        inicio_actionPerformed();
        viewLogin.setVisible(true);
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
        viewCompra.jb_agregar_detalle.addActionListener(actionListener);
        viewDetallecompra.jb_finalizar.addActionListener(actionListener);
        viewAdmin.jb_ventas.addActionListener(actionListener);
        viewAdmin.jb_sucursales.addActionListener(actionListener);
    }

    /**
     * Evalua el componente que genero el evento y llama a un método en particular.
     */
    private final ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewInicio.jb_entrar) {
                login();
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
                viewLogin.jmi_olvido.setVisible(true);
                desocultar();
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
            else if(e.getSource() == viewCompra.jb_agregar_detalle){
                detalle_compras_actionPerformed();
            }
            else if(e.getSource() == viewDetallecompra.jb_finalizar){
                compras_actionPerformed();
            }
            else if(e.getSource() == viewAdmin.jb_ventas){
                venta_consulta_actionPerformed();
            }
            else if(e.getSource() == viewAdmin.jb_sucursales){
                sucursal_actionPerformed();
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
    /*
    *
    */
    private void login(){
        controllerInicio.Datos();
        modelLogin.setTipo(controllerInicio.modelInicio.getTipo());
        if(controllerInicio.modelInicio.LoginPass() == true && modelLogin.getTipo().equals("ADMIN")){
            controllerAdmin.viewAdmin.jl_tipo_user.setText("Administrador: "+controllerInicio.modelInicio.getUsername());
                admin_actionPerformed();
                controllerInicio.limpiar();
        }
        else if(controllerInicio.modelInicio.LoginPass() == true && modelLogin.getTipo().equals("VENDEDOR")){
            controllerVendedor.viewVendedor.jl_tipo_user.setText("Administrador: "+controllerInicio.modelInicio.getUsername());
            controllerVendedor.modelVendedor.setSucursal(controllerInicio.modelInicio.getId_sucursal());
            controllerVendedor.viewVendedor.jl_sucursal.setText("Sucursal: "+controllerVendedor.modelVendedor.getSucursal());
            vendedor_actionPerformed();
            controllerInicio.limpiar();
        }
        else {
               JOptionPane.showMessageDialog(null, "Ingrese datos validos");
               controllerInicio.limpiar();
        }

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
        if (controllerCompras.viewCompra.jt_compra.getRowSelectionAllowed()==true){
        controllerDetalleCompra.modelDetalleCompra.setFactura(controllerCompras.modelCompras.getNo_factura());
        System.out.println(controllerDetalleCompra.modelDetalleCompra.getFactura()+"impresion");}
        else
            controllerDetalleCompra.modelDetalleCompra.setFactura("0");
        System.out.println(controllerDetalleCompra.modelDetalleCompra.getFactura());
        viewLogin.setContentPane(controllerCompras.viewCompra);
        viewLogin.revalidate();
        viewLogin.repaint();
        viewLogin.jmi_cambio.setVisible(false);
        viewLogin.jmi_cambio_validacion.setVisible(false);
        viewLogin.jmi_olvido.setVisible(false);
        viewLogin.jmi_volver.setVisible(true);
        viewLogin.jmi_cerrar.setVisible(false);
    }

    /*
    * Método que hara que se cambie al panel de detalle compra
    */
     private void detalle_compras_actionPerformed(){
        viewLogin.setContentPane(controllerDetalleCompra.viewDetallecompra);
        viewLogin.revalidate();
        viewLogin.repaint();
        viewLogin.jmi_cambio.setVisible(false);
        viewLogin.jmi_cambio_validacion.setVisible(false);
        viewLogin.jmi_olvido.setVisible(false);
        viewLogin.jmi_volver.setVisible(false);
        viewLogin.jmi_cerrar.setVisible(false);
     }

     /*
     * Método que hara que se cambie al panel de Consulta de Ventas
     */
     private void venta_consulta_actionPerformed(){
        viewLogin.setContentPane(controllerVentasConsulta.viewVentasConsulta);
        viewLogin.revalidate();
        viewLogin.repaint();
        viewLogin.jmi_cambio.setVisible(false);
        viewLogin.jmi_cambio_validacion.setVisible(false);
        viewLogin.jmi_olvido.setVisible(false);
        viewLogin.jmi_volver.setVisible(true);
        viewLogin.jmi_cerrar.setVisible(false);
     }

     /*
     * Método que hara que se cambie al panel de Sucrusales
     */
     private void sucursal_actionPerformed(){
        viewLogin.setContentPane(controllerSucursal.viewSucursal);
        viewLogin.revalidate();
        viewLogin.repaint();
        viewLogin.jmi_cambio.setVisible(false);
        viewLogin.jmi_cambio_validacion.setVisible(false);
        viewLogin.jmi_olvido.setVisible(false);
        viewLogin.jmi_volver.setVisible(true);
        viewLogin.jmi_cerrar.setVisible(false);
     }
}
