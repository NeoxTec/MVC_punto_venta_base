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
         
        Object[] controllers = new Object[6];
        controllers[0] = controllerInicio;
        controllers[1] = controllerAdmin;
        controllers[2] = controllerCatalogo;
        controllers[3] = controllerEmpleado;
        controllers[4] = controllerVendedor;
        controllers[5] = controllerProveedor;
        
         
        modelLogin modelLogin = new modelLogin();
        viewLogin viewLogin = new viewLogin();
        controllerLogin controllerLogin = new controllerLogin(modelLogin,viewLogin,viewInicio,viewAdmin,viewEmpleado,viewVendedor,viewProveedor,controllers);
    }
    
}
