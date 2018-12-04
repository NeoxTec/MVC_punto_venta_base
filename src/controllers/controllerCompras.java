/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import models.modelCompras;
import views.viewCompra;
/**
 *
 * @author Diego
 */
public class controllerCompras {
    public modelCompras modelCompras;
    public viewCompra viewCompra;
        
    public controllerCompras(modelCompras modelCompras, viewCompra viewCompra) {
        this.modelCompras = modelCompras;
        this.viewCompra = viewCompra;
        viewCompra.setVisible(true);
        modelCompras.llenarprov();
        viewCompra.jt_proveedor.setModel(modelCompras.getTable_prov());
        init();
    }
    
    public void init(){
    modelCompras.conectarDB();
    modelCompras.setSentencia("Select * from compra;");
    modelCompras.llenarcompras();
    viewCompra.jt_compra.setModel(modelCompras.getTable_compra());
    viewCompra.jcb_idsucursal.removeAllItems();
    modelCompras.sucursales_combobox();
    for(int x = 0; x < modelCompras.getSucursales().size(); x++){
        viewCompra.jcb_idsucursal.addItem((String) modelCompras.getSucursales().get(x));
    }
    };
    }
