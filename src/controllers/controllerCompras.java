/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import models.modelCompras;
import views.viewCompra;
/**
 * Metodo que realizara las interacciones entre modelo y vista.
 * @author Diego
 */
public class controllerCompras {
    public modelCompras modelCompras;
    public viewCompra viewCompra;
        
    /**
     * Procedimiento que permite interaccion entre la vista y el modelo y donde se registra la lista de acciones que este puede realizar.
     * @param modelCompras
     * @param viewCompra 
     */
    public controllerCompras(modelCompras modelCompras, viewCompra viewCompra) {
        this.modelCompras = modelCompras;
        this.viewCompra = viewCompra;
        viewCompra.jb_nueva_compra.addMouseListener(moul);
        viewCompra.jb_modificar_compra.addMouseListener(moul);
        viewCompra.jb_guardar_compra.addMouseListener(moul);
        viewCompra.jb_eliminar_compra.addMouseListener(moul);
        viewCompra.jb_cancelar_compra.addMouseListener(moul);
        viewCompra.jt_compra.addMouseListener(moul);
        viewCompra.jt_proveedor.addMouseListener(moul);
        viewCompra.setVisible(true);
        viewCompra.jtf_rfc_proveedor.setEditable(false);
        viewCompra.jtf_total.setEditable(false);
        modelCompras.llenarprov();
        viewCompra.jt_proveedor.setModel(modelCompras.getTable_prov());
        init();
    }
    /**
     * Metodo que hace la conexion con la base de datos y realiza el llenado de las tablas y el combobox con los registros que existen el la base de datos.
     */
    public void init(){
         inicio_b(true);
        acciones_b(false);
    modelCompras.conectarDB();
    modelCompras.setSentencia("Select * from compra;");
    modelCompras.llenarcompras();
    viewCompra.jt_compra.setModel(modelCompras.getTable_compra());
    viewCompra.jcb_idsucursal.removeAllItems();
    viewCompra.jb_agregar_detalle.setEnabled(false);
    viewCompra.jb_modificar_compra.setEnabled(false);
    modelCompras.sucursales_combobox();
    for(int x = 0; x < modelCompras.getSucursales().size(); x++){
        viewCompra.jcb_idsucursal.addItem((String) modelCompras.getSucursales().get(x));    }
};
    
    /**
     * metodo que tiene todas las accionde de los botones y las tablas de la vista.
     * Acorde a la accion tomada se realizaran algunos procesos con la base de datos.
     */
    MouseListener moul = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource()== viewCompra.jt_compra)
                jt_compras_mouseClicked();
            else if(e.getSource()==viewCompra.jt_proveedor)
                jt_proveedor_mouseClicked();
            else if (e.getSource()==viewCompra.jb_nueva_compra)
                jb_nueva_mouseClicked();
            else if(e.getSource()==viewCompra.jb_cancelar_compra)
                jb_cancelar_mouseClicked();
            else if(e.getSource()==viewCompra.jb_modificar_compra)
                jb_modificar_mouseClicked();
            else if(e.getSource()==viewCompra.jb_eliminar_compra)
                jb_eliminar_mouseClicked();
            else if(e.getSource()==viewCompra.jb_guardar_compra)
                jb_guardar_mouseClicked();
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {    }

        @Override
        public void mouseExited(MouseEvent e) {        }
    };
    
    /**
     * Metodo que toma un registro de la tabla de comras y permite la visualizacion de los datos en los campos de la vista.
     * Los botones de agregar_detalle y modificar_compra son permitidos su aceso una vez quelos campos esten llenos. 
     */
    public void jt_compras_mouseClicked(){
        int linea;
        String fecha;
          linea = viewCompra.jt_compra.getSelectedRow();
          modelCompras.setNo_factura((String) viewCompra.jt_compra.getValueAt(linea, 0));
          modelCompras.datos_compra();
          System.out.println(modelCompras.getNo_factura());
          viewCompra.jtf_nofactura.setText(modelCompras.getNo_factura());
          viewCompra.jtf_rfc_proveedor.setText(modelCompras.getRfc_prov());
          viewCompra.jtf_total.setText(String.valueOf(modelCompras.getTotal()));
          fecha = modelCompras.getFecha();
          viewCompra.jtf_anio.setText(fecha.substring(0, 4));
          viewCompra.jtf_mes.setText(fecha.substring(5,7));
          viewCompra.jtf_dia.setText(fecha.substring(8,fecha.length()));
          viewCompra.jcb_estado_factura.setSelectedItem(modelCompras.getEstado_factura());
          viewCompra.jcb_forma_pago.setSelectedItem(modelCompras.getForma_pago());
          viewCompra.jcb_idsucursal.setSelectedIndex(modelCompras.getSucursal()-1);
          viewCompra.jb_agregar_detalle.setEnabled(true);
          viewCompra.jb_modificar_compra.setEnabled(true);
    }
    
    /**
     *Metodo que toma el rfc de los provedoores para poder registrar una compra, mostrando el dato en el jtf_provedor. 
     */
    public void jt_proveedor_mouseClicked(){
        try{
            viewCompra.jtf_rfc_proveedor.setText(null);
            int linea;
            linea = viewCompra.jt_proveedor.getSelectedRow();
            modelCompras.setRfc_prov((String) viewCompra.jt_proveedor.getValueAt(linea, 0));
            System.out.println(modelCompras.getRfc_prov());
            viewCompra.jtf_rfc_proveedor.setText(modelCompras.getRfc_prov());
        }catch(Exception err){}
    }
    
    /**
     * Método que vacia los datos de los campos , Inhabilita los botones de procesos y habilita los de guardado o cancelacion.
     * Se habilita el acceso a los proveedores para asignarlo a una compra, ingresa un dato para la comprobacion a la hora de solicitar el guardado del registro.
     */
    public void jb_nueva_mouseClicked(){
        viewCompra.jb_agregar_detalle.setEnabled(false);
        viewCompra.jb_modificar_compra.setEnabled(false);
        modelCompras.setValidar(true);
        campos_vacios();
        inicio_b(false);
        acciones_b(true);
        jt_proveedor_mouseClicked();
    }
    
    /**
     * Metodo que vacia los campos e inhabilita los botones para guardado de registros.
     * Habilita los botones para eliminacion o agregacion.
     */
    public void jb_cancelar_mouseClicked(){
            campos_vacios();
            inicio_b(true);
            acciones_b(false);
            viewCompra.jb_modificar_compra.setEnabled(false);
    }
    
    /**
     * Metodo que habilita algunos campos que pueden ser cambiados por error, 
     * asigna un valor al momento de querer guardar el cambio y haci verificar dicho cambio.
     */
    public void jb_modificar_mouseClicked(){
            viewCompra.jb_agregar_detalle.setEnabled(false);
            modelCompras.setValidar(false);
            viewCompra.jb_modificar_compra.setEnabled(false);
            inicio_b(false);
            acciones_b(true);
            viewCompra.jtf_nofactura.setEditable(false);
            viewCompra.jcb_idsucursal.setEnabled(false);
            viewCompra.jtf_anio.setEditable(false);
    }
    
    /**
     * Método que valida si los campos del registro estan vacios, de ser asi se mostrara un mensaje de peticion.
     * Una vez ingresado los datos concatena la fecha y verifica la validacion para conocer si un registro tiene un cambio o es un nuevo registro.
     * 
     * Al realizar el proceso correspondiente actualiza la tabla de la vista y los campos de la vista seran limpiados.
     */
    public void jb_guardar_mouseClicked(){
            String fecha;
            if (viewCompra.jtf_total.getText().isEmpty())
                modelCompras.setTotal(0);
            if (viewCompra.jtf_anio.getText().isEmpty() || viewCompra.jtf_dia.getText().isEmpty() || viewCompra.jtf_mes.getText().isEmpty() || viewCompra.jtf_nofactura.getText().isEmpty() || viewCompra.jtf_rfc_proveedor.getText().isEmpty())
                JOptionPane.showMessageDialog(null, "Ingrese datos para guardar cambios");
            else{
                fecha = (viewCompra.jtf_anio.getText()+'-'+viewCompra.jtf_mes.getText()+'-'+viewCompra.jtf_dia.getText());
                System.out.println(fecha);
                modelCompras.setEstado_factura(viewCompra.jcb_estado_factura.getSelectedItem());
                modelCompras.setFecha(fecha);
                modelCompras.setForma_pago(viewCompra.jcb_forma_pago.getSelectedItem());
                modelCompras.setNo_factura(viewCompra.jtf_nofactura.getText());
                modelCompras.setRfc_prov(viewCompra.jtf_rfc_proveedor.getText());
                modelCompras.setSucursal(viewCompra.jcb_idsucursal.getSelectedIndex()+1);
             if (modelCompras.isValidar()== true)
                 modelCompras.insertar();
             else
                 modelCompras.modificar();
            }
            limpiar_tabla();
            campos_vacios();
            init();
    }
    
    /**
     * Este metodo permitira la eliminacion de un dato registrado en la base de datos.
     * Al realizar la accion se hara una limpieza en la tabla y los campos de la vista.
     */
    public void jb_eliminar_mouseClicked(){
            viewCompra.jb_agregar_detalle.setEnabled(false);
            modelCompras.borrar();
            limpiar_tabla();
            campos_vacios();
            init();
    }
    
    /**
     * Metodo que limpia la tabla de los registros existentes
     */
  public void limpiar_tabla(){
          for (int i = 0; i < viewCompra.jt_compra.getRowCount(); i++) {
            modelCompras.getTable_compra().removeRow(i);
            i -= 1;
        }
     }
    
  /**
   * Metodo que habilita o deshabilita los botones de nuevo y eliminar una compra.
   * @param r variable para determinar la habilitacion de los botones.
   */
    public void inicio_b(boolean r){
          viewCompra.jb_nueva_compra.setEnabled(r);
          viewCompra.jb_eliminar_compra.setEnabled(r);
    }
    
    /**
     * Metodo que habilita o deshabiita los campos de la vista, los botones de guardar o cancelar y la visualizacion de proveedores.
     * @param s Variable que determinara si se puede on no usar los campos, botones y tabla.
     */
    public void acciones_b(boolean s){
            viewCompra.jcb_idsucursal.setEnabled(s);
            viewCompra.jcb_estado_factura.setEnabled(s);
            viewCompra.jcb_forma_pago.setEnabled(s);
            viewCompra.jtf_anio.setEditable(s);
            viewCompra.jtf_dia.setEditable(s);
            viewCompra.jtf_mes.setEditable(s);
            viewCompra.jtf_nofactura.setEditable(s);
            viewCompra.jb_guardar_compra.setEnabled(s);
            viewCompra.jb_cancelar_compra.setEnabled(s);
            viewCompra.jt_proveedor.setVisible(s);
    }
    
    /**
     * Metodo que vacia los campos de la vista.
     */
    public void campos_vacios(){
         viewCompra.jtf_anio.setText(null);
         viewCompra.jtf_dia.setText(null);
         viewCompra.jtf_mes.setText(null);
         viewCompra.jtf_nofactura.setText(null);
         viewCompra.jtf_rfc_proveedor.setText(null);
         viewCompra.jtf_total.setText(null);
         viewCompra.jcb_estado_factura.setSelectedIndex(0);
         viewCompra.jcb_forma_pago.setSelectedIndex(0);
         viewCompra.jcb_idsucursal.setSelectedIndex(0);
    }
}
