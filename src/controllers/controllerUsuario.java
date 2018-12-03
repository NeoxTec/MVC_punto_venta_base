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
        initDB();
    }
    
    /**
     * Metodo que hace la conexion a la base de datos, muestra los registros en la tabla y habilita o deshabilita los botones de la vista
     */
        public void initDB(){
        modelUsuario.conectarDB();
        modelUsuario.setSentencia("SELECT username,tipo,id_sucursal,rfc_e FROM usuario");
        modelUsuario.llenartabla();
        viewUsuario.jt_usuarios.setModel(modelUsuario.getModelo());
    }
    
}
