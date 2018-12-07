
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import models.modelClientes;
import views.viewClientes;

public class controllerClientes {
     modelClientes modelClientes;
     viewClientes viewCliente;

    public controllerClientes(modelClientes modelClientes, viewClientes viewClientes) {
        this.modelClientes = modelClientes;
        this.viewCliente = viewClientes;
        this.viewCliente.jt_Tabla_Clientes.addMouseListener(ml);
        this.viewCliente.jtf_Buscar_Cliente.addKeyListener(kl);
        setActionlistener();       
        initComponents();
        
    }
    public void initComponents(){   
        modelClientes.conectarDB();
        modelClientes.setSentencia("SELECT * FROM cliente;");
        modelClientes.tabla();
        viewCliente.jt_Tabla_Clientes.setModel(modelClientes.getT_cliente());
        viewCliente.jb_Eliminar_Cliente.setEnabled(true);
        viewCliente.jb_Guardar_Cliente.setEnabled(false);
        viewCliente.jb_Modificar_Cliente.setEnabled(true);
        viewCliente.jb_Nuevo_Cliente.setEnabled(true);
        celda(false);
    }
    public void setActionlistener(){
        viewCliente.jb_Guardar_Cliente.addActionListener(actionListener);
        viewCliente.jb_Nuevo_Cliente.addActionListener(actionListener);
        viewCliente.jb_Modificar_Cliente.addActionListener(actionListener);
        viewCliente.jb_Eliminar_Cliente.addActionListener(actionListener);
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
        /**
      * Constructor que realiza las acciones del buscador
      */
     KeyListener kl = new KeyListener(){
         @Override
        public void keyTyped(KeyEvent e) {
        }
        @Override
        public void keyPressed(KeyEvent e) {
            jb_buscar_cliente_keypresseed();
        }
        @Override
        public void keyReleased(KeyEvent e) {
        }
     };
     
     MouseListener ml = new MouseListener(){
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource()== viewCliente.jt_Tabla_Clientes){
                jt_tabla_clientes_mouseClicked();
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
    
    private void jb_insertar_cliente_actionPerformed(){
    System.out.println("Action del boton jbtn_guardar");
   if(viewCliente.jtf_Interior_Cliente.getText().isEmpty())
            modelClientes.setNo_interior(0);
        if(viewCliente.jtf_Telefono_Cliente.getText().isEmpty())
            modelClientes.setTelefono("No hay Número Telefónico");
        if(viewCliente.jtf_Calle_Cliente.getText().isEmpty() || viewCliente.jtf_Colonia_Cliente.getText().isEmpty() || viewCliente.jtf_Codigo_Postal_Cliente.getText().isEmpty() || viewCliente.jtf_Exterior_Cliente.getText().isEmpty())
             JOptionPane.showMessageDialog(null, "Por favor de Ingresar los Datos de la Calle, Colonia, Código Postal y Número Exterior para Registrar al Cliente");
        else{
        modelClientes.setCalle(viewCliente.jtf_Calle_Cliente.getText()); 
        modelClientes.setColonia(viewCliente.jtf_Colonia_Cliente.getText());
        modelClientes.setNo_exterior(Integer.parseInt(viewCliente.jtf_Exterior_Cliente.getText()));
        modelClientes.setNo_interior(Integer.parseInt(viewCliente.jtf_Interior_Cliente.getText())); 
        modelClientes.setCp(viewCliente.jtf_Codigo_Postal_Cliente.getText()); 
        modelClientes.setTelefono(viewCliente.jtf_Telefono_Cliente.getText()); 
        if (modelClientes.getId() == 0)
            modelClientes.insertar(); 
        else
            modelClientes.modificar(); 
         eliminar();
         initComponents();
    }}   
    private void jb_nuevo_actionPerformed(){
     celda(true);
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
     modelClientes.setId(0);
    
     viewCliente.jb_Modificar_Cliente.setEnabled(false);
       viewCliente.jb_Eliminar_Cliente.setEnabled(false);
       viewCliente.jb_Guardar_Cliente.setEnabled(true);
       viewCliente.jb_Nuevo_Cliente.setEnabled(false);
    }
    
    private void jb_modificar_actionPerformed(){
        celda(true);
        viewCliente.jb_Nuevo_Cliente.setEnabled(false);
        viewCliente.jb_Modificar_Cliente.setEnabled(false);
        viewCliente.jb_Eliminar_Cliente.setEnabled(false);
        viewCliente.jb_Guardar_Cliente.setEnabled(true);
    }
    private void jb_eliminar_actionPerformed(){
    modelClientes.eliminar();
    celda(false);
    viewCliente.jb_Modificar_Cliente.setEnabled(true);
    viewCliente.jb_Eliminar_Cliente.setEnabled(true);
    viewCliente.jb_Guardar_Cliente.setEnabled(false);
    viewCliente.jb_Nuevo_Cliente.setEnabled(true);
    }
 
public void jt_tabla_clientes_mouseClicked(){
          int linea;
          linea = viewCliente.jt_Tabla_Clientes.getSelectedRow();
          modelClientes.setId((int) viewCliente.jt_Tabla_Clientes.getValueAt(linea, 0));
          modelClientes.dato();
          viewCliente.jtf_Nombre_Cliente.setText(modelClientes.getNombre());
          viewCliente.jtf_Ap_Paterno_Cliente.setText(modelClientes.getApe_p());
          viewCliente.jtf_Ap_Materno_Cliente.setText(modelClientes.getApe_m());
          viewCliente.jtf_Rfc_Cliente.setText(modelClientes.getRfc());
          viewCliente.jtf_Telefono_Cliente.setText(modelClientes.getTelefono());
          viewCliente.jtf_Correo_Cliente.setText(modelClientes.getCorreo());
          viewCliente.jtf_Calle_Cliente.setText(modelClientes.getCalle());
          viewCliente.jtf_Colonia_Cliente.setText(modelClientes.getColonia());
          viewCliente.jtf_Exterior_Cliente.setText(String.valueOf(modelClientes.getNo_exterior()));
          viewCliente.jtf_Interior_Cliente.setText(String.valueOf(modelClientes.getNo_interior()));
          viewCliente.jtf_Codigo_Postal_Cliente.setText(modelClientes.getCp());
}
     public void celda(boolean i){
         viewCliente.jtf_Nombre_Cliente.setEditable(i);
          viewCliente.jtf_Ap_Paterno_Cliente.setEditable(i);
          viewCliente.jtf_Ap_Materno_Cliente.setEditable(i);
          viewCliente.jtf_Rfc_Cliente.setEditable(i);
          viewCliente.jtf_Telefono_Cliente.setEditable(i);
          viewCliente.jtf_Correo_Cliente.setEditable(i);
          viewCliente.jtf_Calle_Cliente.setEditable(i);
          viewCliente.jtf_Colonia_Cliente.setEditable(i);
          viewCliente.jtf_Exterior_Cliente.setEditable(i);
          viewCliente.jtf_Interior_Cliente.setEditable(i);
          viewCliente.jtf_Codigo_Postal_Cliente.setEditable(i);
        
     } 
     
      /**
      * Metodo que elimina los registros de la tabla de Cliente.
      */
     public void eliminar(){
          for (int i = 0; i < viewCliente.jt_Tabla_Clientes.getRowCount(); i++) {
            modelClientes.getT_cliente().removeRow(i);
            i -= 1;
        }
     }
     
      /**
      * Metodo que vacia la tabla de la vista catalogo y la vuelve a llenar los datos que coincidan con el jtf_buscar.
      * Por cada tecla escrita en el jtf_buscar se repetira la accion. 
      */
     public void jb_buscar_cliente_keypresseed(){
         String sql = "SELECT * FROM cliente where calle like '"+viewCliente.jtf_Buscar_Cliente.getText()+"%' OR colonia like '"+viewCliente.jtf_Buscar_Cliente.getText()+"%'";
         modelClientes.setSentencia(sql);
         eliminar();
         modelClientes.tabla();
         viewCliente.jt_Tabla_Clientes.setModel(modelClientes.getT_cliente());
     }
}

  


