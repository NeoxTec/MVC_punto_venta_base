/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import controllers.*;
import models.*;
import views.*;

/**
 *
 * @author Salvador Hernández Mendoza
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        modelUsuario modelUsuario = new modelUsuario();
        viewUsuario viewUsuario = new viewUsuario();
        controllerUsuario controllerUsuario = new controllerUsuario(modelUsuario,viewUsuario);
        
        modelSucursal modelSucursal = new modelSucursal();
        viewSucursal viewSucursal = new viewSucursal();
        controllerSucursal controllerSucursal = new controllerSucursal(modelSucursal,viewSucursal);
        
        modelVentasConsulta modelVentasConsulta = new modelVentasConsulta();
        viewVentasConsulta viewVentasConsulta = new viewVentasConsulta();
        controllerVentasConsulta controllerVentasConsulta = new controllerVentasConsulta(modelVentasConsulta,viewVentasConsulta);
        
        modelDetalleCompra modelDetalleCompra = new modelDetalleCompra();
        viewDetallecompra viewDetallecompra = new viewDetallecompra();
        controllerDetalleCompra controllerDetalleCompra = new controllerDetalleCompra(modelDetalleCompra,viewDetallecompra);
        
        modelProveedor modelProveedor = new modelProveedor();
        viewProveedor viewProveedor = new viewProveedor();
        controllerProveedor controllerProveedor = new controllerProveedor(modelProveedor, viewProveedor);
        
        modelVendedor modelVendedor = new modelVendedor();
        viewVendedor viewVendedor = new viewVendedor();
        controllerVendedor controllerVendedor = new controllerVendedor(modelVendedor,viewVendedor );
        
        modelEmpleado modelEmpleado = new modelEmpleado();
        viewEmpleado viewEmpleado = new viewEmpleado();
        controllerEmpleado controllerEmpleado = new controllerEmpleado(modelEmpleado,viewEmpleado);
        
        modelCatalogo modelCatalogo = new modelCatalogo();
        viewCatalogo viewCatalogo = new viewCatalogo();
        controllerCatalogo controllerCatalogo =  new controllerCatalogo(modelCatalogo,viewCatalogo);
        
        
        modelAdmin modelAdmin = new modelAdmin();
        viewAdmin viewAdmin = new viewAdmin();
        controllerAdmin controllerAdmin = new controllerAdmin(modelAdmin, viewAdmin);
        
        
      //  modelSucursal modelSucursal = new modelSucursal();
        //viewSucursal viewSucursal = new viewSucursal();
        //controllerSucursal controllerSucursal = new controllerSucursal(modelSucursal, viewSucursal);
    
      
         modelInicio modelInicio = new modelInicio();
         viewInicio viewInicio = new viewInicio();
         controllerInicio controllerInicio = new controllerInicio(modelInicio,viewInicio);
         
         modelCompras modelCompras = new modelCompras();
         viewCompra viewCompra = new viewCompra();
         controllerCompras controllerCompras = new controllerCompras (modelCompras,viewCompra);
         
        Object[] controllers = new Object[11];
        controllers[0] = controllerAdmin;
        controllers[1] = controllerCatalogo;
        controllers[2] = controllerEmpleado;
        controllers[3] = controllerVendedor;
        controllers[4] = controllerProveedor;
        controllers [5] = controllerCompras;
        controllers[6] = controllerInicio;
        controllers[7] = controllerDetalleCompra;
        controllers[8] =  controllerVentasConsulta;
        controllers[9] = controllerSucursal;
        controllers[10] = controllerUsuario;
        
        Object[] views = new Object [11];
        views[0] = viewAdmin;
        views[1] = viewCatalogo;
        views[2] = viewEmpleado;
        views[3] = viewVendedor;
        views[4] = viewProveedor;
        views[5] = viewCompra;
        views[6] = viewInicio;
        views[7] = viewDetallecompra;
        views[8]  = viewVentasConsulta;
        views[9] = viewSucursal;
        views[10] =  viewUsuario;
        
         
        modelLogin modelLogin = new modelLogin();
        viewLogin viewLogin = new viewLogin();
        controllerLogin controllerLogin = new controllerLogin(modelLogin,viewLogin,views,controllers);
    }
    
}
