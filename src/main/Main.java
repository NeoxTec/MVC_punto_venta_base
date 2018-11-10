/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import controllers.controllerLogin;
import models.modelLogin;
import views.viewLogin;

import models.modelAdmin;
import views.viewAdmin;
import controllers.controllerAdmin;

import models.modelCatalogo;
import views.viewCatalogo;
import controllers.controllerCatalogo;
/**
 *
 * @author Salvador Hernández Mendoza
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        modelCatalogo modelCatalogo = new modelCatalogo();
        viewCatalogo viewCatalogo = new viewCatalogo();
        controllerCatalogo controllerCatalogo =  new controllerCatalogo(modelCatalogo,viewCatalogo);
        
        modelAdmin modelAdmin = new modelAdmin();
        viewAdmin viewAdmin = new viewAdmin();
        controllerAdmin controllerAdmin = new controllerAdmin(modelAdmin, viewAdmin);
            
        Object[] controllers = new Object[2];
        controllers[0] = controllerAdmin;
        controllers[1] = controllerCatalogo;
         
        modelLogin modelLogin = new modelLogin();
        viewLogin viewLogin = new viewLogin();
        controllerLogin controllerLogin = new controllerLogin(modelLogin, viewLogin,viewAdmin,controllers);
    }
    
}
