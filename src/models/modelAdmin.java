/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Diego
 */
public class modelAdmin {
    private String fecha;
    
   

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public void imprimir(){
        System.out.println(fecha);
    }

    
   
}
