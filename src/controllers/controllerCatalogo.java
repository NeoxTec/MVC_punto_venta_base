/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import views.viewCatalogo;
import models.modelCatalogo;
/**
 *
 * @author Diego
 */
public class controllerCatalogo {
    public viewCatalogo viewCatalogo;
    public modelCatalogo modelCatalogo;
    
    public controllerCatalogo(modelCatalogo modelCatalogo, viewCatalogo viewCatalogo) {
        this.modelCatalogo = modelCatalogo;
        this.viewCatalogo = viewCatalogo;
    }
    
}
