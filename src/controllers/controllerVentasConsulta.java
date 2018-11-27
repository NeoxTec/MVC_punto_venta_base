/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import models.modelVentasConsulta;
import views.viewVentasConsulta;
/**
 *
 * @author Diego
 */
public class controllerVentasConsulta {
    public modelVentasConsulta modelVentasConsulta;
    public viewVentasConsulta viewVentasConsulta;
    
    public controllerVentasConsulta(modelVentasConsulta modelVentasConsulta,viewVentasConsulta viewVentasConsulta) {
        this.modelVentasConsulta = modelVentasConsulta;
        this.viewVentasConsulta = viewVentasConsulta;
    }
    
}
