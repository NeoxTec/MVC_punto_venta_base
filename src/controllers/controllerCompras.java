/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import models.modelCompras;
import views.viewCompra;
/**
 *
 * @author Diego
 */
public class controllerCompras {
    public modelCompras modelCompras;
    public viewCompra viewCompra;
        
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
        modelCompras.llenarprov();
        viewCompra.jt_proveedor.setModel(modelCompras.getTable_prov());
        init();
    }
    
    public void init(){
    modelCompras.conectarDB();
    modelCompras.setSentencia("Select * from compra;");
    modelCompras.llenarcompras();
    viewCompra.jt_compra.setModel(modelCompras.getTable_compra());
    viewCompra.jcb_idsucursal.removeAllItems();
    modelCompras.sucursales_combobox();
    for(int x = 0; x < modelCompras.getSucursales().size(); x++){
        viewCompra.jcb_idsucursal.addItem((String) modelCompras.getSucursales().get(x));    }
};
    
    MouseListener moul = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource()== viewCompra.jt_compra)
                jt_compras_mouseClicked();
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
    }
}
