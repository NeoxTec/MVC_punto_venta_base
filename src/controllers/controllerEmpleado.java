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
import views.viewEmpleado;
import models.modelEmpleado;

/**
 *
 * @author Diego
 */
public class controllerEmpleado {
    public viewEmpleado viewEmpleado;
    public modelEmpleado modelEmpleado;
    
    public controllerEmpleado(modelEmpleado modelEmpleado, viewEmpleado viewEmpleado) {
        this.modelEmpleado = modelEmpleado;
        this.viewEmpleado = viewEmpleado;
        initDB();
        setMouseListener();
        setKeyListener();
    }
    
    public void initDB(){
        modelEmpleado.conectarDB();
        modelEmpleado.setSentencia("SELECT * FROM empleado");
        modelEmpleado.llenarTabla();
        viewEmpleado.jt_empleados.setModel(modelEmpleado.getModelo());
    }
    
    /**
     * Método que modifica la propiedad editable a True de los JTextField 
     */
    private void editable(){
        viewEmpleado.jtf_rfc.setEditable(true);
        viewEmpleado.jtf_nombre.setEditable(true);
        viewEmpleado.jtf_ape_p.setEditable(true);
        viewEmpleado.jtf_ape_m.setEditable(true);
        viewEmpleado.jtf_telefono.setEditable(true);
        viewEmpleado.jtf_correo.setEditable(true);
        viewEmpleado.jft_fecha.setEditable(true);
        viewEmpleado.jcb_genero.setEnabled(true);
        viewEmpleado.jtf_calle.setEditable(true);
        viewEmpleado.jtf_colonia.setEditable(true);
        viewEmpleado.jtf_no_ext.setEditable(true);
        viewEmpleado.jtf_no_int.setEditable(true);
        viewEmpleado.jtf_cp.setEditable(true);
        
    }
    
    /**
     * Método que modifica la propiedad editable a False de los JTextField.
     */
    private void editableF(){
       viewEmpleado.jtf_rfc.setEditable(false);
        viewEmpleado.jtf_nombre.setEditable(false);
        viewEmpleado.jtf_ape_p.setEditable(false);
        viewEmpleado.jtf_ape_m.setEditable(false);
        viewEmpleado.jtf_telefono.setEditable(false);
        viewEmpleado.jtf_correo.setEditable(false);
        viewEmpleado.jft_fecha.setEditable(false);
        viewEmpleado.jft_fecha.setText("aaaa/mm/dd");
        viewEmpleado.jcb_genero.setEnabled(false);
        viewEmpleado.jtf_calle.setEditable(false);
        viewEmpleado.jtf_colonia.setEditable(false);
        viewEmpleado.jtf_no_ext.setEditable(false);
        viewEmpleado.jtf_no_int.setEditable(false);
        viewEmpleado.jtf_cp.setEditable(false);
    }
    
    MouseListener ml = new MouseListener(){
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource()== viewEmpleado.jb_nuevo){
                editable();
            }
            else if(e.getSource() == viewEmpleado.jb_modificar){
                
            }
            else if(e.getSource() == viewEmpleado.jb_eliminar){
                eliminar();
            }
            else if(e.getSource() == viewEmpleado.jb_guardar){
                guardar();
            }
            else if(e.getSource() == viewEmpleado.jb_cancelar){
                limpiarcampos();
                editableF();
                
            }
            else if(e.getSource() == viewEmpleado.jt_empleados){
                jt_empleado_mouseClicked();
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
    
    KeyListener kl = new KeyListener(){
         @Override
        public void keyTyped(KeyEvent e) {
        }
        @Override
        public void keyPressed(KeyEvent e) {
            buscar_keypressed();
        }
        @Override
        public void keyReleased(KeyEvent e) {
        }
     };
    
    /**
     * Método para agregar el mouselistener a cada boton de la vista
     */
    private void setMouseListener() {
        viewEmpleado.jb_nuevo.addMouseListener(ml);
        viewEmpleado.jb_cancelar.addMouseListener(ml);
        viewEmpleado.jb_guardar.addMouseListener(ml);
        viewEmpleado.jt_empleados.addMouseListener(ml);
        viewEmpleado.jb_eliminar.addMouseListener(ml);
        
    }
    
    /**
     * Método para agregar el keylistener al jtf_buscar
     */
    private void setKeyListener(){
        viewEmpleado.jtf_buscar.addKeyListener(kl);
    }
    
    /**
      * Metodo que permite mostrar los datos de la base de datos en los campos al seleccionar la tabla de la vista.
    */
    private void jt_empleado_mouseClicked(){
        int linea;
        linea = viewEmpleado.jt_empleados.getSelectedRow();
        modelEmpleado.setRfc((String) viewEmpleado.jt_empleados.getValueAt(linea, 0));
        modelEmpleado.datos();
        setValues();
        
    }
    
    
    /*
    * Método que permite realizar la busqueda en el campo por medio de las teclas que se van tecleando
    */
    private void buscar_keypressed(){
        modelEmpleado.setSentencia("SELECT * FROM empleado where nombre like '%" + viewEmpleado.jtf_buscar.getText()+"%'");
        limpiar();
        modelEmpleado.llenarTabla();
        viewEmpleado.jt_empleados.setModel(modelEmpleado.getModelo());
    }
    
    /*
    * Método que va depurando la tabla a la hora de la busqueda
    */
    private void limpiar(){
        for (int i = 0; i < viewEmpleado.jt_empleados.getRowCount(); i++){
            modelEmpleado.getModelo().removeRow(i);
            i -=1;
        }
    }
    
    /**
     * Método que obtiene los valores de los JTextField los manda al modelEmpleado
     */
    private void obtener_Datos(){
        modelEmpleado.setRfc(viewEmpleado.jtf_rfc.getText());
        modelEmpleado.setNombre(viewEmpleado.jtf_nombre.getText());
        modelEmpleado.setApe_p(viewEmpleado.jtf_ape_p.getText());
        modelEmpleado.setApe_m(viewEmpleado.jtf_ape_m.getText());
        modelEmpleado.setCorreo(viewEmpleado.jtf_correo.getText());
        modelEmpleado.setTelefono(viewEmpleado.jtf_telefono.getText());
        modelEmpleado.setGenero(viewEmpleado.jcb_genero.getSelectedItem());
        modelEmpleado.setFecha_n(viewEmpleado.jft_fecha.getText());
        modelEmpleado.setCalle(viewEmpleado.jtf_calle.getText());
        modelEmpleado.setColonia(viewEmpleado.jtf_colonia.getText());
        modelEmpleado.setNo_ext(Integer.parseInt(viewEmpleado.jtf_no_ext.getText()));
        modelEmpleado.setCp(viewEmpleado.jtf_cp.getText());
        if (viewEmpleado.jtf_no_int.getText().isEmpty()){
            modelEmpleado.setNo_int(0);
        }
        else{
            modelEmpleado.setNo_int(Integer.parseInt(viewEmpleado.jtf_no_int.getText()));
        }
    }
    
    /*
    * Método para limpiar los campos
    */
    private void limpiarcampos(){
        viewEmpleado.jtf_rfc.setText(null);
        viewEmpleado.jtf_nombre.setText(null);
        viewEmpleado.jtf_ape_p.setText(null);
        viewEmpleado.jtf_ape_m.setText(null);
        viewEmpleado.jtf_telefono.setText(null);
        viewEmpleado.jtf_correo.setText(null);
        viewEmpleado.jft_fecha.setText("aaaa/mm/dd");
        viewEmpleado.jcb_genero.setSelectedIndex(0);
        viewEmpleado.jtf_calle.setText(null);
        viewEmpleado.jtf_colonia.setText(null);
        viewEmpleado.jtf_no_ext.setText(null);
        viewEmpleado.jtf_no_int.setText(null);
        viewEmpleado.jtf_cp.setText(null);
    }
    
    /*
    * Método para guardar los registros o modificaciones de los registros dentro de la tabla empleado.
    */
    public void guardar(){
        obtener_Datos();
        modelEmpleado.insertarRegistro();
        editableF();
        limpiar();
        initDB();
        limpiarcampos();
        
    }
    /*
    * Método para eliminar los registros dentro de la tabla empleado.
    */
    public void eliminar(){
        obtener_Datos();
        modelEmpleado.eliminarRegistro();
        limpiar();
        initDB();
        limpiarcampos();
    }
    /**
     * Muestra los valores almacenados en el modelEmpleado al viewEmpleado
     */
    private void setValues() {
        viewEmpleado.jtf_rfc.setText(modelEmpleado.getRfc());
        viewEmpleado.jtf_nombre.setText(modelEmpleado.getNombre());
        viewEmpleado.jtf_ape_p.setText(modelEmpleado.getApe_p());
        viewEmpleado.jtf_ape_m.setText(modelEmpleado.getApe_m());
        viewEmpleado.jtf_correo.setText(modelEmpleado.getCorreo());
        viewEmpleado.jtf_telefono.setText(modelEmpleado.getTelefono());
        viewEmpleado.jcb_genero.setSelectedItem(modelEmpleado.getGenero());
        viewEmpleado.jft_fecha.setText(modelEmpleado.getFecha_n());
        viewEmpleado.jtf_calle.setText(modelEmpleado.getCalle());
        viewEmpleado.jtf_colonia.setText(modelEmpleado.getColonia());
        viewEmpleado.jtf_no_ext.setText(String.valueOf(modelEmpleado.getNo_ext()));
        viewEmpleado.jtf_no_int.setText(String.valueOf(modelEmpleado.getNo_int()));
        viewEmpleado.jtf_cp.setText(modelEmpleado.getCp());
    }
}
