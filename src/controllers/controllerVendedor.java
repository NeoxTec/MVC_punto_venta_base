/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.text.SimpleDateFormat;
import java.util.Date;
import views.viewVendedor;
import models.modelVendedor;
/**
 *
 * @author Diego
 */
public class controllerVendedor {
    public modelVendedor modelVendedor;
    public viewVendedor viewVendedor;
    Date fecha = new Date();
    
    
    public controllerVendedor(modelVendedor modelVendedor, viewVendedor viewVendedor) {
        this.modelVendedor = modelVendedor;
        this.viewVendedor = viewVendedor;
        fecha();
    }
    
    private void fecha(){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY/MM/dd");
        viewVendedor.jl_fecha.setText(formatoFecha.format(fecha));
        modelVendedor.setFecha(formatoFecha.format(fecha));
        System.out.println(modelVendedor.getFecha());
    }
}
