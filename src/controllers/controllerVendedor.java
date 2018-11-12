/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import views.viewVendedor;
import models.modelVendedor;
/**
 *
 * @author Diego
 */
public class controllerVendedor {
     public modelVendedor modelVendedor;
    public viewVendedor viewVendedor;
    
    
    public controllerVendedor(modelVendedor modelVendedor, viewVendedor viewVendedor) {
        this.modelVendedor = modelVendedor;
        this.viewVendedor = viewVendedor;
    }
}
