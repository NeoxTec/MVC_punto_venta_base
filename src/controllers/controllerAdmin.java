/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import views.viewAdmin;
import models.modelAdmin;
import java.util.Date;
import java.text.SimpleDateFormat;


/**
 *
 * @author Diego
 */
public class controllerAdmin {
    public modelAdmin modelAdmin;
    public viewAdmin viewAdmin;
    Date fecha = new Date();
    
    
    public controllerAdmin(modelAdmin modelAdmin, viewAdmin viewAdmin) {
        this.modelAdmin = modelAdmin;
        this.viewAdmin = viewAdmin;
        fecha();
        modelAdmin.imprimir();
    }
    
    private void fecha(){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY/MM/dd");
        viewAdmin.jl_fecha.setText(formatoFecha.format(fecha));
        modelAdmin.setFecha(fecha);
    }
 }

