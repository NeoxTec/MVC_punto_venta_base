/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import views.viewEmpleado;
import models.modelEmpleado;

/**
 *
 * @author Diego
 */
public class controllerEmpleado {
    public viewEmpleado viewEmpleado;
    public modelEmpleado modelEmpleado;
    
    public controllerEmpleado(modelEmpleado modelEmpleado, viewEmpleado viewEmpleado) {
        this.modelEmpleado = modelEmpleado;
        this.viewEmpleado = viewEmpleado;
    }
}
