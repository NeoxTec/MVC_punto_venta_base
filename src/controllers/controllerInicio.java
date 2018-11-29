/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import views.viewInicio;
import models.modelInicio;
/**
 *
 * @author Diego
 */
public class controllerInicio {
    public viewInicio viewInicio;
    public modelInicio modelInicio;
    
    public controllerInicio(modelInicio modelInicio, viewInicio viewInicio) {
        this.modelInicio = modelInicio;
        this.viewInicio = viewInicio;
    }
    
    public void Datos(){
        modelInicio.setUsername(viewInicio.jtf_usuario.getText());
        modelInicio.setPass(new String(viewInicio.jpf_password.getPassword()));
    }
    
    public void limpiar(){
        viewInicio.jtf_usuario.setText(null);
        viewInicio.jpf_password.setText(null);
    }
}
