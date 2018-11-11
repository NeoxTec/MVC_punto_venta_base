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
        
        modelEmpleado modelEmpleado = new modelEmpleado();
        viewEmpleado viewEmpleado = new viewEmpleado();
        controllerEmpleado controllerEmpleado = new controllerEmpleado(modelEmpleado,viewEmpleado);
        modelCatalogo modelCatalogo = new modelCatalogo();
        viewCatalogo viewCatalogo = new viewCatalogo();
        controllerCatalogo controllerCatalogo =  new controllerCatalogo(modelCatalogo,viewCatalogo);
        
        modelAdmin modelAdmin = new modelAdmin();
        viewAdmin viewAdmin = new viewAdmin();
        controllerAdmin controllerAdmin = new controllerAdmin(modelAdmin, viewAdmin);
            
        Object[] controllers = new Object[3];
        controllers[0] = controllerAdmin;
        controllers[1] = controllerCatalogo;
        controllers[2] = controllerEmpleado;
         
        modelLogin modelLogin = new modelLogin();
        viewLogin viewLogin = new viewLogin();
        controllerLogin controllerLogin = new controllerLogin(modelLogin, viewLogin,viewAdmin,viewEmpleado,controllers);
    }
    
}
