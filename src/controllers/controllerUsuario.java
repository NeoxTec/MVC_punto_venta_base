/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import models.modelUsuario;
import views.viewUsuario;
/**
 *
 * @author Diego
 */
public class controllerUsuario {
    public modelUsuario modelUsuario;
    public viewUsuario viewUsuario;
    public controllerUsuario(modelUsuario modelUsuario, viewUsuario viewUsuario) {
        this.modelUsuario = modelUsuario;
        this.viewUsuario = viewUsuario;
    }
    
}
