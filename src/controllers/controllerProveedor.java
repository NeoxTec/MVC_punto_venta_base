/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import controllers.controllerProveedor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import models.modelProveedor;
import models.modelSucursal;
import views.viewProveedor;
import views.viewSucursal;
/**
 *
 * @author Abi Montes
 */
public class controllerProveedor {
    modelProveedor modelProveedor;
    viewProveedor viewProveedor;  
    public controllerProveedor(modelProveedor modelProveedor, viewProveedor viewProveedor) {
        this.modelProveedor= modelProveedor;
        this.viewProveedor = viewProveedor;
        this.viewProveedor.jt_Proveedor.addMouseListener(ml);
        this.viewProveedor.jtf_buscar.addKeyListener(kl);
        viewProveedor.jtf_rfc.setEditable(false);
        setActionlistener();       
        initComponents();
}
 public void initComponents() {
        modelProveedor.conectarDB();
        modelProveedor.setSentencia("select * from proveedor;");
        modelProveedor.llenartabla();
        viewProveedor.jt_Proveedor.setModel(modelProveedor.getT_Proveedor());
        viewProveedor.jb_agregar.setEnabled(true);
        viewProveedor.jb_modificar.setEnabled(true);
        viewProveedor.jb_eliminar.setEnabled(true);
        viewProveedor.jb_guardar.setEnabled(false);
        viewProveedor.jb_cancelar.setEnabled(false);
        celdas(false);
 }

public void setActionlistener() {
        viewProveedor.jb_modificar.addActionListener(actionListener);
        viewProveedor.jb_eliminar.addActionListener(actionListener);
        viewProveedor.jb_agregar.addActionListener(actionListener);
        viewProveedor.jb_guardar.addActionListener(actionListener);
        viewProveedor.jb_cancelar.addActionListener(actionListener);
         }
    ActionListener actionListener = new ActionListener() {
        @Override        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewProveedor.jb_agregar) {

            jb_nuevo_actionPerformed();

            } else if (e.getSource() == viewProveedor.jb_modificar) {

             jb_modificar_actionPerformed();

            } else if (e.getSource() == viewProveedor.jb_eliminar) {

                jb_eliminar_actionPerformed();

            } else if (e.getSource() == viewProveedor.jb_guardar) {

               
               jb_guardar_actionPerformed();             

            }
            else if (e.getSource() == viewProveedor.jb_cancelar) {

               
               
               jb_cancelar_actionPerformed();
               
            }
            
        }
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
     
   MouseListener ml = new MouseListener(){
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource()== viewProveedor.jt_Proveedor){
                jt_Proveedor_mouseClicked();
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
    public void jb_nuevo_actionPerformed() {
        celdas(true);
        viewProveedor.jtf_rfc.setText(""); 
        viewProveedor.jtf_razons.setText("");
        viewProveedor.jtf_calle.setText("");
        viewProveedor.jtf_colonia.setText("");
        viewProveedor.jtf_no_ext.setText("");
        viewProveedor.jtf_cp.setText("");
        viewProveedor.jtf_telefono.setText("");
        viewProveedor.jtf_correo.setText("");
        modelProveedor.setRfc("0");
        
        viewProveedor.jb_modificar.setEnabled(false);
       viewProveedor.jb_eliminar.setEnabled(false);
       viewProveedor.jb_agregar.setEnabled(false);
       viewProveedor.jb_guardar.setEnabled(true);
       viewProveedor.jb_cancelar.setEnabled(true);
    }
    /**
     * Elimina un registro de la tabla contactos
     */
    public void jb_eliminar_actionPerformed() {
    modelProveedor.eliRegistro(); // Invoca metodo de eliminar 
        celdas(false);
       viewProveedor.jb_modificar.setEnabled(true);
       viewProveedor.jb_eliminar.setEnabled(true);
       viewProveedor.jb_agregar.setEnabled(true);
       viewProveedor.jb_cancelar.setEnabled(false);
       viewProveedor.jb_guardar.setEnabled(false);
    }
 /**
     *Inserta registro en la tabla contactos
     */
    public void jb_guardar_actionPerformed() {
        if(viewProveedor.jtf_no_ext.getText().isEmpty())
            modelProveedor.setNoext(0);
        if(viewProveedor.jtf_telefono.getText().isEmpty())
            modelProveedor.setTelefono("Sin numero telefónico");
        if(viewProveedor.jtf_calle.getText().isEmpty() || viewProveedor.jtf_colonia.getText().isEmpty() || viewProveedor.jtf_cp.getText().isEmpty() || viewProveedor.jtf_no_ext.getText().isEmpty())
             JOptionPane.showMessageDialog(null, "Ingrese valores de calle, colonia, código postal, y número exterior para poder registrar la sucursal");
        else{
            modelProveedor.setRazons(viewProveedor.jtf_razons.getText()); 
        modelProveedor.setCalle(viewProveedor.jtf_calle.getText()); 
        modelProveedor.setColonia(viewProveedor.jtf_colonia.getText());
        modelProveedor.setNoext(Integer.parseInt(viewProveedor.jtf_no_ext.getText()));
         modelProveedor.setCorreo(viewProveedor.jtf_correo.getText()); 
        modelProveedor.setCp(viewProveedor.jtf_cp.getText()); 
        modelProveedor.setTelefono(viewProveedor.jtf_telefono.getText()); 
          modelProveedor.setCorreo(viewProveedor.jtf_calle.getText()); 
        if (modelProveedor.getRfc() == "0")
            modelProveedor.insertarRegistro(); // Invoca  Insertar un nuevo registro. 
        else
            modelProveedor.modiRegistro(); // Invoca metodo de modificar .
         limpiar();
         initComponents();
    }}   
    /**
     * Método para modificar registros
     */
    public void jb_modificar_actionPerformed() {     
        celdas(true);
        viewProveedor.jb_agregar.setEnabled(false);
        viewProveedor.jb_modificar.setEnabled(false);
       viewProveedor.jb_eliminar.setEnabled(false);
       viewProveedor.jb_cancelar.setEnabled(true);
       viewProveedor.jb_guardar.setEnabled(true);
    }
    public void jb_cancelar_actionPerformed() {
        System.out.println("registro cancelado");
        celdas(false);
         viewProveedor.jtf_rfc.setText(""); 
        viewProveedor.jtf_razons.setText("");
        viewProveedor.jtf_calle.setText("");
        viewProveedor.jtf_colonia.setText("");
        viewProveedor.jtf_no_ext.setText("");
        viewProveedor.jtf_cp.setText("");
        viewProveedor.jtf_telefono.setText("");
        viewProveedor.jtf_correo.setText("");
        
       viewProveedor.jb_agregar.setEnabled(true);
        viewProveedor.jb_modificar.setEnabled(true);
       viewProveedor.jb_eliminar.setEnabled(true);
       viewProveedor.jb_guardar.setEnabled(false);
       viewProveedor.jb_cancelar.setEnabled(false);
    }
    
      /**
      * Metodo que permite mostrar los datos de la base de datos en los campos al seleccionar la tabla de la vista.
      */
     public void jt_Proveedor_mouseClicked(){
          int linea;
          linea = viewProveedor.jt_Proveedor.getSelectedRow();
          modelProveedor.setRfc((String) viewProveedor.jt_Proveedor.getValueAt(linea, 0));
          modelProveedor.datos();
          viewProveedor.jtf_rfc.setText(String.valueOf(modelProveedor.getRfc()));
          viewProveedor.jtf_razons.setText(modelProveedor.getRazons());
          viewProveedor.jtf_calle.setText(modelProveedor.getCalle());
          viewProveedor.jtf_colonia.setText(modelProveedor.getColonia());
          viewProveedor.jtf_cp.setText(modelProveedor.getCp());
          viewProveedor.jtf_no_ext.setText(String.valueOf(modelProveedor.getNoext()));
          viewProveedor.jtf_correo.setText(modelProveedor.getCorreo());
          viewProveedor.jtf_telefono.setText(modelProveedor.getTelefono());
}
     public void celdas(boolean i){
         viewProveedor.jtf_calle.setEditable(i);
         viewProveedor.jtf_colonia.setEditable(i);
         viewProveedor.jtf_cp.setEditable(i);
         viewProveedor.jtf_no_ext.setEditable(i);
         viewProveedor.jtf_razons.setEditable(i);
         viewProveedor.jtf_telefono.setEditable(i);
         viewProveedor.jtf_correo.setEditable(i);
     }
     
      /**
      * Metodo que elimina los registros de la tabla de catalogo.
      */
     public void limpiar(){
          for (int i = 0; i < viewProveedor.jt_Proveedor.getRowCount(); i++) {
            modelProveedor.getT_Proveedor().removeRow(i);
            i -= 1;
        }
     }
     
      /**
      * Metodo que vacia la tabla de la vista catalogo y la vuelve a llenar los datos que coincidan con el jtf_buscar.
      * Por cada tecla escrita en el jtf_buscar se repetira la accion. 
      */
     public void jb_buscar_keypresseed(){
         String sql = "SELECT * FROM proveedor where rfc like '"+viewProveedor.jtf_buscar.getText()+"%' OR colonia like '"+viewProveedor.jtf_buscar.getText()+"%'";
         modelProveedor.setSentencia(sql);
         limpiar();
         modelProveedor.llenartabla();
         viewProveedor.jt_Proveedor.setModel(modelProveedor.getT_Proveedor());
     }
}