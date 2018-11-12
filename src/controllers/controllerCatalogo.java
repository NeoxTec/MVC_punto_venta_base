/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import views.viewCatalogo;
import models.modelCatalogo;
/**
 *
 * @author Diego
 */
public class controllerCatalogo {
    public viewCatalogo viewCatalogo;
    public modelCatalogo modelCatalogo;
    
    public controllerCatalogo(modelCatalogo modelCatalogo, viewCatalogo viewCatalogo) {
        this.modelCatalogo = modelCatalogo;
        this.viewCatalogo = viewCatalogo;
        this.viewCatalogo.jt_catalogo.addMouseListener(ml);
        initDB();
        viewCatalogo.setVisible(true);
    }
    
        public void initDB(){
        modelCatalogo.conectarDB();
        modelCatalogo.llenartabla();
        viewCatalogo.jt_catalogo.setModel(modelCatalogo.getModelo());
    }
     MouseListener ml = new MouseListener(){
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource()== viewCatalogo.jt_catalogo){
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    
    };
    }
