/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import views.viewDetallecompra;
import models.modelDetalleCompra;
/**
 *
 * @author Diego
 */
public class controllerDetalleCompra {
    
    public modelDetalleCompra  modelDetalleCompra;
    public viewDetallecompra viewDetallecompra;
    
    public controllerDetalleCompra(modelDetalleCompra modelDetalleCompra, viewDetallecompra viewDetallecompra) {
        this.modelDetalleCompra = modelDetalleCompra;
        this.viewDetallecompra = viewDetallecompra;
    }
    
}
