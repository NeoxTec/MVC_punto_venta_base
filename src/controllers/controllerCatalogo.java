/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
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
        this.viewCatalogo.jb_nuevo.addMouseListener(ml);
        this.viewCatalogo.jb_modificar.addMouseListener(ml);
        this.viewCatalogo.jb_guardar.addMouseListener(ml);
        this.viewCatalogo.jb_eliminar.addMouseListener(ml);
        this.viewCatalogo.jb_cancelar.addMouseListener(ml);
        this.viewCatalogo.jtf_buscar.addKeyListener(kl);
        initDB();
        viewCatalogo.setVisible(true);
    }
    
        public void initDB(){
        modelCatalogo.conectarDB();
        modelCatalogo.setSentencia("SELECT id,nombre,precio, precio_mayoreo,unidad FROM catalogo");
        modelCatalogo.llenartabla();
        viewCatalogo.jt_catalogo.setModel(modelCatalogo.getModelo());
        habilitar(false);
        botones_p(true);
    }
     MouseListener ml = new MouseListener(){
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource()== viewCatalogo.jt_catalogo){
                jt_catalogo_mouseClicked();
            }
            else if(e.getSource()== viewCatalogo.jb_nuevo){
                botones_p(false);
                habilitar(true);
                modelCatalogo.setId(0);
                limpiar_campos();
                System.out.println(modelCatalogo.getId());
            }
            else if(e.getSource() == viewCatalogo.jb_modificar){
                botones_p(false);
                habilitar(true);
            }
            else if(e.getSource()==viewCatalogo.jb_cancelar){
            botones_p(true);
            habilitar(false);
            limpiar_campos();
            }
            else if(e.getSource()==viewCatalogo.jb_guardar){
            jb_guardar_mouseClicked();
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
     
     KeyListener kl = new KeyListener(){
         @Override
        public void keyTyped(KeyEvent e) {
        }
        @Override
        public void keyPressed(KeyEvent e) {
            jb_buscar_keypresseed();
        }
        @Override
        public void keyReleased(KeyEvent e) {
        }
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
          viewCatalogo.jcb_unidadmedida.setSelectedItem(modelCatalogo.getUnidad_medida());
          viewCatalogo.jcb_iva.setSelectedItem(modelCatalogo.getIva());
          System.out.println(modelCatalogo.getIva());
}
     public void jb_buscar_keypresseed(){
         modelCatalogo.setSentencia("SELECT id,nombre,precio, precio_mayoreo,unidad FROM catalogo where nombre like '%"+viewCatalogo.jtf_buscar.getText()+"%'");
         limpiar();
         modelCatalogo.llenartabla();
         viewCatalogo.jt_catalogo.setModel(modelCatalogo.getModelo());
     }
     public void habilitar(boolean f){
     viewCatalogo.jta_descripcion.setEditable(f);
     viewCatalogo.jtf_codigobarras.setEditable(f);
     viewCatalogo.jtf_nombre.setEditable(f);
     viewCatalogo.jtf_preciom.setEditable(f);
     viewCatalogo.jtf_preciou.setEditable(f);
     viewCatalogo.jcb_iva.setEnabled(f);
     viewCatalogo.jcb_unidadmedida.setEnabled(f);
     viewCatalogo.jb_guardar.setEnabled(f);
     viewCatalogo.jb_cancelar.setEnabled(f);
     }
     public void botones_p(boolean p){
     viewCatalogo.jb_nuevo.setEnabled(p);
     viewCatalogo.jb_eliminar.setEnabled(p);
     viewCatalogo.jb_modificar.setEnabled(p);
     }
     public void limpiar(){
          for (int i = 0; i < viewCatalogo.jt_catalogo.getRowCount(); i++) {
            modelCatalogo.getModelo().removeRow(i);
            i -= 1;
        }
     }
     public void limpiar_campos(){
     viewCatalogo.jta_descripcion.setText(null);
     viewCatalogo.jtf_codigobarras.setText(null);
     viewCatalogo.jtf_nombre.setText(null);
     viewCatalogo.jtf_preciom.setText(null);
     viewCatalogo.jtf_preciou.setText(null);
     viewCatalogo.jcb_iva.setSelectedIndex(0);
     viewCatalogo.jcb_unidadmedida.setSelectedIndex(0);
     }
     
     public void jb_guardar_mouseClicked(){
         if (viewCatalogo.jtf_codigobarras.getText().isEmpty())
             modelCatalogo.setCodigo_barras(0);
         else
                modelCatalogo.setCodigo_barras(Integer.parseInt(viewCatalogo.jtf_codigobarras.getText()));
         if (viewCatalogo.jtf_preciom.getText().isEmpty())
                 modelCatalogo.setPrecio_mayoreo(0);
         else
                  modelCatalogo.setPrecio_mayoreo(Double.parseDouble(viewCatalogo.jtf_preciom.getText()));
         if (viewCatalogo.jtf_nombre.getText().isEmpty() || viewCatalogo.jta_descripcion.getText().isEmpty() || viewCatalogo.jtf_preciou.getText().isEmpty())
              JOptionPane.showMessageDialog(null, "Ingrese valores en nombre, descripcion y precio unitario como minimo para poder agregar producto");
         else{
         modelCatalogo.setDescripcion(viewCatalogo.jta_descripcion.getText());
         modelCatalogo.setIva(viewCatalogo.jcb_iva.getSelectedItem());
         modelCatalogo.setNombre(viewCatalogo.jtf_nombre.getText());
         modelCatalogo.setPrecio_unitario(Double.parseDouble(viewCatalogo.jtf_preciou.getText()));
         modelCatalogo.setUnidad_medida(viewCatalogo.jcb_unidadmedida.getSelectedItem());
         if (modelCatalogo.getId() > 0)
              modelCatalogo.modificar();
          else
              modelCatalogo.insertar();
         }
          botones_p(true);
          habilitar(false);
          limpiar();
          initDB();
     }
 }
