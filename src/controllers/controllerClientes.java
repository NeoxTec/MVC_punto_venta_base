
package controllers;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import controllers.controllerClientes;
import models.modelClientes;
import views.viewClientes;

public class controllerClientes {
     modelClientes modelClientes;
     viewClientes viewCliente;

    public controllerClientes(modelClientes modelClientes, viewClientes viewClientes) {
        this.modelClientes = modelClientes;
        this.viewCliente = viewClientes;
        setActionListener();
        
        initComponents();
        initDB();
        
    }
    public void initComponents(){
        viewCliente.jtf_Nombre_Cliente.setEditable(true);
        viewCliente.jtf_Ap_Paterno_Cliente.setEditable(true);
        viewCliente.jtf_Ap_Materno_Cliente.setEditable(true);
        viewCliente.jtf_Rfc_Cliente.setEditable(true);
        viewCliente.jtf_Calle_Cliente.setEditable(true);
        viewCliente.jtf_Codigo_Postal_Cliente.setEditable(true);
        viewCliente.jtf_Colonia_Cliente.setEditable(true);
        viewCliente.jtf_Correo_Cliente.setEditable(true);
        viewCliente.jtf_Exterior_Cliente.setEditable(true);
        viewCliente.jtf_Interior_Cliente.setEditable(true);
        viewCliente.jtf_Telefono_Cliente.setEditable(true);
    }
    public void setActionListener(){
        viewCliente.jb_Guardar_Cliente.addActionListener(actionListener);
        viewCliente.jb_Nuevo_Cliente.addActionListener(actionListener);
        viewCliente.jb_Modificar_Cliente.addActionListener(actionListener);
        viewCliente.jb_Eliminar_Cliente.addActionListener(actionListener);
    }
    private void initDB() {
        modelClientes.conectarDB();
        viewCliente.jtf_Nombre_Cliente.setText(modelClientes.getNombre());
        viewCliente.jtf_Ap_Paterno_Cliente.setText(modelClientes.getApe_p());
        viewCliente.jtf_Ap_Materno_Cliente.setText(modelClientes.getApe_m());
        viewCliente.jtf_Telefono_Cliente.setText(modelClientes.getTelefono());
        viewCliente.jtf_Rfc_Cliente.setText(modelClientes.getRfc());
        viewCliente.jtf_Calle_Cliente.setText(modelClientes.getCalle());
        viewCliente.jtf_Colonia_Cliente.setText(modelClientes.getColonia());
        viewCliente.jtf_Exterior_Cliente.setText(modelClientes.getNo_exterior());
        viewCliente.jtf_Interior_Cliente.setText(modelClientes.getNo_interior());
        viewCliente.jtf_Codigo_Postal_Cliente.setText(modelClientes.getCp());
        viewCliente.jcb_Genero_Cliente.setSelectedItem(modelClientes.getGenero());
        viewCliente.jtf_Correo_Cliente.setText(modelClientes.getCorreo());
    }
        ActionListener actionListener = new ActionListener() {
    @Override   public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewCliente.jb_Guardar_Cliente) {
                jb_insertar_cliente_actionPerformed();
            } else if (e.getSource() == viewCliente.jb_Nuevo_Cliente) {
                jb_nuevo_actionPerformed();
            } else if (e.getSource() == viewCliente.jb_Modificar_Cliente) {
                jb_modificar_actionPerformed();
            } else if (e.getSource() == viewCliente.jb_Eliminar_Cliente) {
                jb_eliminar_actionPerformed();   
            }
        
    }
    };
    
    private void jb_insertar_cliente_actionPerformed(){
    System.out.println("Action del boton jbtn_guardar");
    modelClientes.setNombre(viewCliente.jtf_Nombre_Cliente.getText());
    modelClientes.setApe_p(viewCliente.jtf_Ap_Paterno_Cliente.getText());
    modelClientes.setApe_m(viewCliente.jtf_Ap_Materno_Cliente.getText());
    modelClientes.setTelefono(viewCliente.jtf_Telefono_Cliente.getText());
    modelClientes.setRfc(viewCliente.jtf_Rfc_Cliente.getText());
    modelClientes.setCalle(viewCliente.jtf_Calle_Cliente.getText());
    modelClientes.setColonia(viewCliente.jtf_Colonia_Cliente.getText());
    modelClientes.setNo_exterior(viewCliente.jtf_Exterior_Cliente.getText());
    modelClientes.setNo_interior(viewCliente.jtf_Interior_Cliente.getText());
    modelClientes.setCp(viewCliente.jtf_Codigo_Postal_Cliente.getText());
    modelClientes.setGenero((String) viewCliente.jcb_Genero_Cliente.getSelectedItem());
    modelClientes.setCorreo(viewCliente.jtf_Correo_Cliente.getText());
    modelClientes.insertar();
    }
    private void jb_nuevo_actionPerformed(){
    viewCliente.jtf_Nombre_Cliente.setText("");
    viewCliente.jtf_Ap_Paterno_Cliente.setText("");
    viewCliente.jtf_Ap_Materno_Cliente.setText("");
    viewCliente.jtf_Telefono_Cliente.setText("");
    viewCliente.jtf_Rfc_Cliente.setText("");
    viewCliente.jtf_Calle_Cliente.setText("");
    viewCliente.jtf_Colonia_Cliente.setText("");
    viewCliente.jtf_Exterior_Cliente.setText("");
    viewCliente.jtf_Interior_Cliente.setText("");
    viewCliente.jtf_Codigo_Postal_Cliente.setText("");
    viewCliente.jtf_Correo_Cliente.setText("");
    
     viewCliente.jb_Modificar_Cliente.setEnabled(false);
    }
    
    private void jb_modificar_actionPerformed(){
    modelClientes.setNombre(viewCliente.jtf_Nombre_Cliente.getText());
    modelClientes.setApe_p(viewCliente.jtf_Ap_Paterno_Cliente.getText());
    modelClientes.setApe_m(viewCliente.jtf_Ap_Materno_Cliente.getText());
    modelClientes.setTelefono(viewCliente.jtf_Telefono_Cliente.getText());
    modelClientes.setRfc(viewCliente.jtf_Rfc_Cliente.getText());
    modelClientes.setCalle(viewCliente.jtf_Calle_Cliente.getText());
    modelClientes.setColonia(viewCliente.jtf_Colonia_Cliente.getText());
    modelClientes.setNo_exterior(viewCliente.jtf_Exterior_Cliente.getText());
    modelClientes.setNo_interior(viewCliente.jtf_Interior_Cliente.getText());
    modelClientes.setCp(viewCliente.jtf_Codigo_Postal_Cliente.getText());
    modelClientes.setGenero((String) viewCliente.jcb_Genero_Cliente.getSelectedItem());
    modelClientes.setCorreo(viewCliente.jtf_Correo_Cliente.getText());
    modelClientes.modificar(); 
       viewCliente.jb_Eliminar_Cliente.setEnabled(false);
    }
    private void jb_eliminar_actionPerformed(){
    modelClientes.eliminar();
    viewCliente.jb_Modificar_Cliente.setEnabled(false);
    viewCliente.jb_Eliminar_Cliente.setEnabled(false);
    viewCliente.jb_Guardar_Cliente.setEnabled(false);
    }
     
}
  


