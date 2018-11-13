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
                jt_catalogo_mouseClicked();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) { }

        @Override
        public void mouseReleased(MouseEvent e) { }

        @Override
        public void mouseEntered(MouseEvent e) { }

        @Override
        public void mouseExited(MouseEvent e) { }
    };
     public void jt_catalogo_mouseClicked(){
          int linea;
          linea = viewCatalogo.jt_catalogo.getSelectedRow();
          modelCatalogo.setId((int) viewCatalogo.jt_catalogo.getValueAt(linea, 0));
          modelCatalogo.datos();
          System.out.println(modelCatalogo.getId());
          viewCatalogo.jtf_nombre.setText(modelCatalogo.getNombre());
          viewCatalogo.jtf_codigobarras.setText(String.valueOf(modelCatalogo.getCodigo_barras()));
          viewCatalogo.jtf_preciom.setText(String.valueOf(modelCatalogo.getPrecio_mayoreo()));
          viewCatalogo.jtf_preciou.setText(String.valueOf(modelCatalogo.getPrecio_unitario()));
          viewCatalogo.jta_descripcion.setText(modelCatalogo.getDescripcion());
          
          
}
 }
