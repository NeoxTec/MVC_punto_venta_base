/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import views.viewAdmin;
import models.modelAdmin;


/**
 *
 * @author Diego
 */
public class controllerAdmin {
    public modelAdmin modelAdmin;
    public viewAdmin viewAdmin;
    
    
    public controllerAdmin(modelAdmin modelAdmin, viewAdmin viewAdmin) {
        this.modelAdmin = modelAdmin;
        this.viewAdmin = viewAdmin;
    }
    
    
 }

