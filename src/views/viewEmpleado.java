/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

/**
 *
 * @author Diego
 */
public class viewEmpleado extends javax.swing.JPanel {

    /**
     * Creates new form viewEmpleado
     */
    public viewEmpleado() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jt_empleados = new javax.swing.JTable();
        jl_rfc = new javax.swing.JLabel();
        jl_calle = new javax.swing.JLabel();
        jtf_correo = new javax.swing.JTextField();
        jcb_genero = new javax.swing.JComboBox<>();
        jtf_nombre = new javax.swing.JTextField();
        jl_nombre = new javax.swing.JLabel();
        jl_ape_p = new javax.swing.JLabel();
        jtf_ape_p = new javax.swing.JTextField();
        jl_ape_m = new javax.swing.JLabel();
        jtf_ape_m = new javax.swing.JTextField();
        jl_telefono = new javax.swing.JLabel();
        jtf_telefono = new javax.swing.JTextField();
        jl_correo = new javax.swing.JLabel();
        jl_fecha = new javax.swing.JLabel();
        jtf_calle = new javax.swing.JTextField();
        jl_genero = new javax.swing.JLabel();
        jtf_colonia = new javax.swing.JTextField();
        jtf_no_ext = new javax.swing.JTextField();
        jl_colonia = new javax.swing.JLabel();
        jl_no_ext = new javax.swing.JLabel();
        jl_no_int = new javax.swing.JLabel();
        jtf_no_int = new javax.swing.JTextField();
        jl_cp = new javax.swing.JLabel();
        jtf_cp = new javax.swing.JTextField();
        jb_nuevo = new javax.swing.JButton();
        jb_guardar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
        jb_modificar = new javax.swing.JButton();
        jb_eliminar = new javax.swing.JButton();
        jl_titulo = new javax.swing.JLabel();
        jtf_buscar = new javax.swing.JTextField();
        jb_buscar = new javax.swing.JButton();
        jl_datos = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jtf_rfc = new javax.swing.JTextField();
        jl_datos1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jft_fecha = new javax.swing.JFormattedTextField();
        jl_fondo = new javax.swing.JLabel();

        setLayout(null);

        jt_empleados.setFont(new java.awt.Font("AR DESTINE", 0, 14)); // NOI18N
        jt_empleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jt_empleados);

        add(jScrollPane1);
        jScrollPane1.setBounds(20, 100, 958, 186);

        jl_rfc.setFont(new java.awt.Font("AR DESTINE", 0, 14)); // NOI18N
        jl_rfc.setForeground(new java.awt.Color(255, 102, 0));
        jl_rfc.setText("RFC:");
        add(jl_rfc);
        jl_rfc.setBounds(20, 330, 40, 20);

        jl_calle.setFont(new java.awt.Font("AR DESTINE", 0, 14)); // NOI18N
        jl_calle.setForeground(new java.awt.Color(255, 102, 0));
        jl_calle.setText("Calle:");
        add(jl_calle);
        jl_calle.setBounds(20, 470, 40, 17);

        jtf_correo.setEditable(false);
        add(jtf_correo);
        jtf_correo.setBounds(20, 410, 160, 20);

        jcb_genero.setFont(new java.awt.Font("AR DESTINE", 0, 14)); // NOI18N
        jcb_genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "F", "M" }));
        jcb_genero.setEnabled(false);
        add(jcb_genero);
        jcb_genero.setBounds(370, 410, 50, 23);

        jtf_nombre.setEditable(false);
        add(jtf_nombre);
        jtf_nombre.setBounds(190, 350, 178, 20);

        jl_nombre.setFont(new java.awt.Font("AR DESTINE", 0, 14)); // NOI18N
        jl_nombre.setForeground(new java.awt.Color(255, 102, 0));
        jl_nombre.setText("Nombre:");
        add(jl_nombre);
        jl_nombre.setBounds(190, 330, 60, 20);

        jl_ape_p.setFont(new java.awt.Font("AR DESTINE", 0, 14)); // NOI18N
        jl_ape_p.setForeground(new java.awt.Color(255, 102, 0));
        jl_ape_p.setText("Apellido paterno:");
        add(jl_ape_p);
        jl_ape_p.setBounds(380, 330, 120, 20);

        jtf_ape_p.setEditable(false);
        add(jtf_ape_p);
        jtf_ape_p.setBounds(380, 350, 179, 20);

        jl_ape_m.setFont(new java.awt.Font("AR DESTINE", 0, 14)); // NOI18N
        jl_ape_m.setForeground(new java.awt.Color(255, 102, 0));
        jl_ape_m.setText("Apellido materno:");
        add(jl_ape_m);
        jl_ape_m.setBounds(570, 330, 130, 20);

        jtf_ape_m.setEditable(false);
        add(jtf_ape_m);
        jtf_ape_m.setBounds(570, 350, 179, 20);

        jl_telefono.setFont(new java.awt.Font("AR DESTINE", 0, 14)); // NOI18N
        jl_telefono.setForeground(new java.awt.Color(255, 102, 0));
        jl_telefono.setText("Teléfono:");
        add(jl_telefono);
        jl_telefono.setBounds(760, 330, 70, 20);

        jtf_telefono.setEditable(false);
        add(jtf_telefono);
        jtf_telefono.setBounds(760, 350, 150, 20);

        jl_correo.setFont(new java.awt.Font("AR DESTINE", 0, 14)); // NOI18N
        jl_correo.setForeground(new java.awt.Color(255, 102, 0));
        jl_correo.setText("Correo:");
        add(jl_correo);
        jl_correo.setBounds(20, 390, 50, 17);

        jl_fecha.setFont(new java.awt.Font("AR DESTINE", 0, 14)); // NOI18N
        jl_fecha.setForeground(new java.awt.Color(255, 102, 0));
        jl_fecha.setText("Fecha de nacimiento:");
        add(jl_fecha);
        jl_fecha.setBounds(190, 390, 150, 17);

        jtf_calle.setEditable(false);
        add(jtf_calle);
        jtf_calle.setBounds(20, 490, 165, 20);

        jl_genero.setFont(new java.awt.Font("AR DESTINE", 0, 14)); // NOI18N
        jl_genero.setForeground(new java.awt.Color(255, 102, 0));
        jl_genero.setText("Género:");
        add(jl_genero);
        jl_genero.setBounds(370, 390, 60, 20);

        jtf_colonia.setEditable(false);
        add(jtf_colonia);
        jtf_colonia.setBounds(190, 490, 165, 20);

        jtf_no_ext.setEditable(false);
        add(jtf_no_ext);
        jtf_no_ext.setBounds(370, 490, 90, 20);

        jl_colonia.setFont(new java.awt.Font("AR DESTINE", 0, 14)); // NOI18N
        jl_colonia.setForeground(new java.awt.Color(255, 102, 0));
        jl_colonia.setText("Colonia:");
        add(jl_colonia);
        jl_colonia.setBounds(190, 470, 60, 17);

        jl_no_ext.setFont(new java.awt.Font("AR DESTINE", 0, 14)); // NOI18N
        jl_no_ext.setForeground(new java.awt.Color(255, 102, 0));
        jl_no_ext.setText("No_exterior:");
        add(jl_no_ext);
        jl_no_ext.setBounds(370, 470, 90, 20);

        jl_no_int.setFont(new java.awt.Font("AR DESTINE", 0, 14)); // NOI18N
        jl_no_int.setForeground(new java.awt.Color(255, 102, 0));
        jl_no_int.setText("No_interior:");
        add(jl_no_int);
        jl_no_int.setBounds(470, 470, 90, 20);

        jtf_no_int.setEditable(false);
        add(jtf_no_int);
        jtf_no_int.setBounds(470, 490, 90, 20);

        jl_cp.setFont(new java.awt.Font("AR DESTINE", 0, 14)); // NOI18N
        jl_cp.setForeground(new java.awt.Color(255, 102, 0));
        jl_cp.setText("C.P:");
        add(jl_cp);
        jl_cp.setBounds(580, 470, 70, 20);

        jtf_cp.setEditable(false);
        add(jtf_cp);
        jtf_cp.setBounds(580, 490, 80, 20);

        jb_nuevo.setBackground(new java.awt.Color(255, 102, 0));
        jb_nuevo.setFont(new java.awt.Font("AR DESTINE", 0, 14)); // NOI18N
        jb_nuevo.setForeground(new java.awt.Color(255, 255, 255));
        jb_nuevo.setText("Nuevo");
        jb_nuevo.setBorder(null);
        add(jb_nuevo);
        jb_nuevo.setBounds(20, 530, 130, 40);

        jb_guardar.setBackground(new java.awt.Color(255, 102, 0));
        jb_guardar.setFont(new java.awt.Font("AR DESTINE", 0, 14)); // NOI18N
        jb_guardar.setForeground(new java.awt.Color(255, 255, 255));
        jb_guardar.setText("Guardar");
        jb_guardar.setBorder(null);
        add(jb_guardar);
        jb_guardar.setBounds(320, 530, 130, 40);

        jb_cancelar.setBackground(new java.awt.Color(255, 102, 0));
        jb_cancelar.setFont(new java.awt.Font("AR DESTINE", 0, 14)); // NOI18N
        jb_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        jb_cancelar.setText("Cancelar");
        jb_cancelar.setBorder(null);
        add(jb_cancelar);
        jb_cancelar.setBounds(610, 530, 130, 40);

        jb_modificar.setBackground(new java.awt.Color(255, 102, 0));
        jb_modificar.setFont(new java.awt.Font("AR DESTINE", 0, 14)); // NOI18N
        jb_modificar.setForeground(new java.awt.Color(255, 255, 255));
        jb_modificar.setText("Modificar");
        jb_modificar.setBorder(null);
        add(jb_modificar);
        jb_modificar.setBounds(170, 530, 130, 40);

        jb_eliminar.setBackground(new java.awt.Color(255, 102, 0));
        jb_eliminar.setFont(new java.awt.Font("AR DESTINE", 0, 14)); // NOI18N
        jb_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        jb_eliminar.setText("Eliminar");
        jb_eliminar.setBorder(null);
        add(jb_eliminar);
        jb_eliminar.setBounds(470, 530, 130, 40);

        jl_titulo.setFont(new java.awt.Font("AR DESTINE", 0, 48)); // NOI18N
        jl_titulo.setForeground(new java.awt.Color(255, 102, 0));
        jl_titulo.setText("Empleados");
        add(jl_titulo);
        jl_titulo.setBounds(380, 20, 250, 40);
        add(jtf_buscar);
        jtf_buscar.setBounds(210, 70, 380, 20);

        jb_buscar.setBackground(new java.awt.Color(255, 102, 0));
        jb_buscar.setForeground(new java.awt.Color(255, 255, 255));
        jb_buscar.setText("Buscar");
        jb_buscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(jb_buscar);
        jb_buscar.setBounds(600, 70, 80, 20);

        jl_datos.setFont(new java.awt.Font("AR DESTINE", 0, 18)); // NOI18N
        jl_datos.setForeground(new java.awt.Color(255, 102, 0));
        jl_datos.setText("Dirección");
        add(jl_datos);
        jl_datos.setBounds(20, 440, 160, 21);
        add(jSeparator1);
        jSeparator1.setBounds(20, 460, 950, 20);

        jtf_rfc.setEditable(false);
        add(jtf_rfc);
        jtf_rfc.setBounds(20, 350, 160, 20);

        jl_datos1.setFont(new java.awt.Font("AR DESTINE", 0, 18)); // NOI18N
        jl_datos1.setForeground(new java.awt.Color(255, 102, 0));
        jl_datos1.setText("Datos Personales");
        add(jl_datos1);
        jl_datos1.setBounds(20, 300, 160, 21);
        add(jSeparator2);
        jSeparator2.setBounds(20, 520, 950, 20);
        add(jSeparator3);
        jSeparator3.setBounds(20, 320, 950, 20);

        jft_fecha.setEditable(false);
        jft_fecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy/MM/dd"))));
        jft_fecha.setText("aaaa/mm/dd");
        add(jft_fecha);
        jft_fecha.setBounds(190, 410, 150, 20);

        jl_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo.jpg"))); // NOI18N
        add(jl_fondo);
        jl_fondo.setBounds(0, 0, 1140, 630);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton jb_buscar;
    public javax.swing.JButton jb_cancelar;
    public javax.swing.JButton jb_eliminar;
    public javax.swing.JButton jb_guardar;
    public javax.swing.JButton jb_modificar;
    public javax.swing.JButton jb_nuevo;
    public javax.swing.JComboBox<String> jcb_genero;
    public javax.swing.JFormattedTextField jft_fecha;
    private javax.swing.JLabel jl_ape_m;
    private javax.swing.JLabel jl_ape_p;
    private javax.swing.JLabel jl_calle;
    private javax.swing.JLabel jl_colonia;
    private javax.swing.JLabel jl_correo;
    private javax.swing.JLabel jl_cp;
    private javax.swing.JLabel jl_datos;
    private javax.swing.JLabel jl_datos1;
    private javax.swing.JLabel jl_fecha;
    private javax.swing.JLabel jl_fondo;
    private javax.swing.JLabel jl_genero;
    private javax.swing.JLabel jl_no_ext;
    private javax.swing.JLabel jl_no_int;
    private javax.swing.JLabel jl_nombre;
    private javax.swing.JLabel jl_rfc;
    private javax.swing.JLabel jl_telefono;
    private javax.swing.JLabel jl_titulo;
    private javax.swing.JTable jt_empleados;
    public javax.swing.JTextField jtf_ape_m;
    public javax.swing.JTextField jtf_ape_p;
    private javax.swing.JTextField jtf_buscar;
    public javax.swing.JTextField jtf_calle;
    public javax.swing.JTextField jtf_colonia;
    public javax.swing.JTextField jtf_correo;
    public javax.swing.JTextField jtf_cp;
    public javax.swing.JTextField jtf_no_ext;
    public javax.swing.JTextField jtf_no_int;
    public javax.swing.JTextField jtf_nombre;
    public javax.swing.JTextField jtf_rfc;
    public javax.swing.JTextField jtf_telefono;
    // End of variables declaration//GEN-END:variables
}
