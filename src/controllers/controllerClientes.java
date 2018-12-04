
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.modelClientes;
import views.viewClientes;

public class controllerClientes implements ActionListener{
     modelClientes modelClientes;
     viewClientes viewCliente;

    public controllerClientes(modelClientes modelClientes, viewClientes viewClientes) {
        this.modelClientes = modelClientes;
        this.viewCliente = viewClientes;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewCliente.jb_Guardar_Cliente) {
                jb_insertar_cliente_actionPerformed();
            } else if (e.getSource() == viewCliente.jb_Nuevo_Cliente) {
                jb_nuevo_actionPerformed();
            } else if (e.getSource() == viewCliente.jb_Modificar_Cliente) {
                jb_modificar_actionPerformed();
            } else if (e.getSource() == viewCliente.jb_Eliminar_Cliente) {
                jb_eliminar_actionPerformed();   
            }
        

    };
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
    private void setActionListener() {
        ActionListener actionListener = null;
        viewCliente.jb_Guardar_Cliente.addActionListener(actionListener);
        viewCliente.jb_Nuevo_Cliente.addActionListener(actionListener);
        viewCliente.jb_Modificar_Cliente.addActionListener(actionListener);
        viewCliente.jb_Eliminar_Cliente.addActionListener(actionListener);
        
    }
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
    System.out.println("Action del boton jb_nuevo");
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
    }
    
    private void jb_modificar_actionPerformed(){
    System.out.println("Action del boton jbtn_modificar");
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
    }
    private void jb_eliminar_actionPerformed(){
    System.out.println("Action del boton jb_modificar");
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
    modelClientes.eliminar();
    }
    private void setValues() {
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
}


