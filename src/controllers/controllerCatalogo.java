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
    /**
     * Se crea el constructor del controlador que permite hacer las acciones de la vista y modelo del catalogo.
     * @param modelCatalogo
     * @param viewCatalogo 
     */
    public controllerCatalogo(modelCatalogo modelCatalogo, viewCatalogo viewCatalogo) {
        this.modelCatalogo = modelCatalogo;
        this.viewCatalogo = viewCatalogo;
        this.viewCatalogo.jt_catalogo.addMouseListener(ml);
        this.viewCatalogo.jb_nuevo.addMouseListener(ml);
        this.viewCatalogo.jb_modificar.addMouseListener(ml);
        this.viewCatalogo.jb_guardar.addMouseListener(ml);
        this.viewCatalogo.jb_eliminar.addMouseListener(ml);
        this.viewCatalogo.jb_cancelar.addMouseListener(ml);
        this.viewCatalogo.jb_actu_inv.addMouseListener(ml);
        this.viewCatalogo.jtf_buscar.addKeyListener(kl);
        initDB();
        viewCatalogo.setVisible(true);
    }
    
    /**
     * Metodo que hace la conexion a la base de datos, muestra los registros en la tabla y habilita o deshabilita los botones de la vista
     */
        public void initDB(){
        modelCatalogo.conectarDB();
        modelCatalogo.setSentencia("SELECT id,nombre,precio, precio_mayoreo,unidad FROM catalogo");
        modelCatalogo.llenartabla();
        viewCatalogo.jt_catalogo.setModel(modelCatalogo.getModelo());
        habilitar(false);
        botones_p(true);
    }
       /**
        * Constructor que permite realizar las acciones a los botones de la vista
        */ 
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
            }
            else if(e.getSource() == viewCatalogo.jb_modificar){
                botones_p(false);
                habilitar(true);
            }
            else if(e.getSource()== viewCatalogo.jb_actu_inv){
                actualizar_inventarios_mouseClicked()
            }
            else if(e.getSource()==viewCatalogo.jb_cancelar){
            botones_p(true);
            habilitar(false);
            limpiar_campos();
            }
            else if(e.getSource()==viewCatalogo.jb_guardar){
            jb_guardar_mouseClicked();
            limpiar_campos();
            }
            else if(e.getSource()==viewCatalogo.jb_eliminar){
                modelCatalogo.borrar();
                limpiar_campos();
                limpiar();
                initDB();
                
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
     /**
      * Constructor que realiza las acciones del buscador
      */
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
     
     /**
      * Metodo que permite mostrar los datos de la base de datos en los campos al seleccionar la tabla de la vista.
      */
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
}
     /**
      * Metodo que vacia la tabla de la vista catalogo y la vuelve a llenar los datos que coincidan con el jtf_buscar.
      * Por cada tecla escrita en el jtf_buscar se repetira la accion. 
      */
     public void jb_buscar_keypresseed(){
         modelCatalogo.setSentencia("SELECT id,nombre,precio, precio_mayoreo,unidad FROM catalogo where nombre like '%"+viewCatalogo.jtf_buscar.getText()+"%'");
         limpiar();
         modelCatalogo.llenartabla();
         viewCatalogo.jt_catalogo.setModel(modelCatalogo.getModelo());
     }
     
     /**
      * Metodo que habilita los campos de la vista y los botones para guardado de datos.
      * @param f variable boleana para habilirar o deshabilitar los campos y botones. 
      */
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
     
     /**
      * Metodo para habilitar o deshabilitar los botones de modificacion de registros de la base de datos.
      * @param p variable de habilitar o deshabilitar los botones de la vista.
      */
     public void botones_p(boolean p){
     viewCatalogo.jb_nuevo.setEnabled(p);
     viewCatalogo.jb_actu_inv.setEnabled(p);
     viewCatalogo.jb_eliminar.setEnabled(p);
     viewCatalogo.jb_modificar.setEnabled(p);
     }
     
     /**
      * Metodo que elimina los registros de la tabla de catalogo.
      */
     public void limpiar(){
          for (int i = 0; i < viewCatalogo.jt_catalogo.getRowCount(); i++) {
            modelCatalogo.getModelo().removeRow(i);
            i -= 1;
        }
     }
     /**
      * Metodo que vacia los campos da vista.
      */
     public void limpiar_campos(){
     viewCatalogo.jta_descripcion.setText(null);
     viewCatalogo.jtf_codigobarras.setText(null);
     viewCatalogo.jtf_nombre.setText(null);
     viewCatalogo.jtf_preciom.setText(null);
     viewCatalogo.jtf_preciou.setText(null);
     viewCatalogo.jcb_iva.setSelectedIndex(0);
     viewCatalogo.jcb_unidadmedida.setSelectedIndex(0);
     }
     
     /**
      * Metodo que verifica lo registrado en los campos y con ello permitira ingresar un nuevo dato a la base de datos o actualizar un registro de la base de datos.
      * Además deshabilita los botones secundarios y habilita los esenciales.
      * Metodo que vacia la tabla y muestra nuevamente todos los registros con los cambios tenidos desde la base de datos.
      */
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
     
     public void actualizar_inventarios_mouseClicked(){
         modelCatalogo.insertando();
     }
 }
