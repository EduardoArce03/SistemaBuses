
package vista;

import controlador.ControladorBus;
import controlador.ControladorChofer;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import modelo.Bus;
import modelo.Chofer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class VistaChofer extends javax.swing.JInternalFrame {
    ControladorChofer controladorChofer;
    ControladorBus controladorBus;
    DefaultTableModel mdlChofer;
    DefaultComboBoxModel mdlBus;
    Chofer chofer;

    /**
     * Creates new form VistaChofer
     */
    public VistaChofer(ControladorChofer controladorChofer, ControladorBus controladorBus) {
        initComponents();
        this.controladorBus = controladorBus;
        this.controladorChofer = controladorChofer;
        this.mdlChofer = (DefaultTableModel) tblChofer.getModel();
        
        tblChofer.getSelectionModel().addListSelectionListener((e) -> {
            rellenarCampos();
        });   
            
        cargarTabla();
        
    }
    
    public void cargarTabla(){
        mdlChofer.setNumRows(0);
        ResultSet resultado = controladorChofer.getListChofer();
        try {
            while (resultado.next()) {
                 Object fila[] = {resultado.getInt("chofer_id"), resultado.getString("cedula"), resultado.getString("domicilio"), resultado.getString("fechaNacimiento"), resultado.getString("nombre"), resultado.getString("apellido")};
                 mdlChofer.addRow(fila);
            }listarForm(-1);
        } catch (SQLException ex) {
            Logger.getLogger(VistaChofer.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public void listarForm(int posicion){
        if(posicion >= 0){
            txtCedula.setText(chofer.getCedula());
            txtDomicilio.setText(chofer.getDomicilio());
            txtFechaNacimiento.setText(String.valueOf(chofer.getFechaNacimiento()));
            txtNombre.setText(chofer.getNombre());
            txtTelefono.setText(chofer.getTelefono());
        }else{
            chofer = null;
            txtCedula.setText("");
            txtDomicilio.setText("");
            txtFechaNacimiento.setText("");
            txtNombre.setText("");
            txtTelefono.setText("");
            txtApellido.setText("");
            txtGrupo.setText("");
        }
    }
    
    public void rellenarCampos() {
    int seleccionado = tblChofer.getSelectedRow();
    System.out.println(seleccionado);
    if (seleccionado != -1) {
        int idChofer = (int) tblChofer.getValueAt(seleccionado, 0);
        System.out.println(idChofer);
        ResultSet rs = controladorChofer.llenarCampos(idChofer);
        System.out.println("HOLAA");   
        try {
            System.out.println("MMMM");
            System.out.println(rs.getString("nombre"));
            txtNombre.setText(rs.getString("nombre"));
            txtApellido.setText(rs.getString("apellido"));
            txtGrupo.setText(rs.getString("grupoSanguineo")); 
            txtCedula.setText(rs.getString("cedula")); 
            txtTelefono.setText(rs.getString("telefono")); 
            txtDomicilio.setText(rs.getString("domicilio")); 
            txtFechaNacimiento.setText(rs.getString("fechaNacimiento")); 
       
        } catch (SQLException ex) {
            Logger.getLogger(VistaChofer.class.getName()).log(Level.SEVERE, null, ex);
        }
               
    }
}
    
   
    




    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblBus = new javax.swing.JLabel();
        lblDomicilio = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblFechaNacimiento = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        txtDomicilio = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtFechaNacimiento = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChofer = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtGrupo = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 0, 48)); // NOI18N
        jLabel1.setText("Registro de Chofer");

        lblCedula.setText("Cedula:");

        lblNombre.setText("Nombre:");

        lblBus.setText("Apellido:");

        lblDomicilio.setText("Domicilio:");

        lblTelefono.setText("Telefono:");

        lblFechaNacimiento.setText("Fecha de Nacimiento:");

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Crear");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        tblChofer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Cedula", "Domicilio", "Fecha de Nacimiento", "Nombre", "Apellido"
            }
        ));
        jScrollPane1.setViewportView(tblChofer);

        jLabel2.setText("Grupo Sanguineo");

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBuscar)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(lblDomicilio)
                                                .addGap(43, 43, 43))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblBus)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lblCedula)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(lblNombre)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(40, 40, 40)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblTelefono)
                                                    .addComponent(jLabel2))))
                                        .addGap(41, 41, 41)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                            .addComponent(txtDomicilio, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                            .addComponent(txtGrupo)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(285, 285, 285)
                                        .addComponent(lblFechaNacimiento)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnNuevo)
                                        .addComponent(btnEliminar))
                                    .addComponent(btnListar))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnGuardar)
                                    .addComponent(btnActualizar)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(jLabel1)))
                .addGap(43, 81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblCedula)
                                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblTelefono)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(lblDomicilio)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblFechaNacimiento)
                                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblBus)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminar)
                            .addComponent(btnActualizar))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnListar)
                            .addComponent(btnBuscar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        listarForm(-1);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

            chofer = new Chofer();
            chofer.setCedula(txtCedula.getText());
            chofer.setNombre(txtNombre.getText());
            chofer.setDomicilio(txtDomicilio.getText());
            chofer.setTelefono(txtTelefono.getText());
            chofer.setApellido(txtApellido.getText());
            chofer.setGrupoSanguineo(txtGrupo.getText());
            String fechaNacimientoTexto = txtFechaNacimiento.getText();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaNacimiento;
        try {
            fechaNacimiento = formatoFecha.parse(fechaNacimientoTexto);
            chofer.setFechaNacimiento(fechaNacimiento);
        } catch (ParseException ex) {
            Logger.getLogger(VistaChofer.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            boolean resultado = controladorChofer.crear(chofer);
            if (resultado) {
                JOptionPane.showMessageDialog(null, "El chofer ha sido agregado ");
                cargarTabla();
        }else{
                JOptionPane.showMessageDialog(null, "Ha existido un error al agregar al chofer ");
            }
            
            
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int seleccionado = tblChofer.getSelectedRow();
        System.out.println(seleccionado);
        if (seleccionado != -1) {
            int idChofer = (int) tblChofer.getValueAt(seleccionado, 0);
            System.out.println(idChofer);
            boolean resultado = controladorChofer.eliminar(idChofer);
            if (resultado) {
                JOptionPane.showMessageDialog(null, "Eliminado correctamente ");
            }else{
                JOptionPane.showMessageDialog(null, "Ha ocurrido un erorr al eliminar ");
            }
        }
        cargarTabla();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String grupo = txtGrupo.getText();
        String cedula = txtCedula.getText();
        String direccion = txtDomicilio.getText();
        String telefono = txtTelefono.getText();
        String fechaNacimiento = txtFechaNacimiento.getText();
        String fechaNacimientoTexto = txtFechaNacimiento.getText();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimientoxd;
        try {
            int seleccionado = tblChofer.getSelectedRow();
            fechaNacimientoxd = formatoFecha.parse(fechaNacimientoTexto);
            if (seleccionado != -1) {
            int idChofer = (int) tblChofer.getValueAt(seleccionado, 0);
            controladorChofer.actualizar(idChofer, nombre, apellido, grupo, cedula, telefono, direccion, fechaNacimientoxd);
        }
        } catch (ParseException ex) {
            Logger.getLogger(VistaChofer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        cargarTabla();
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String cedula = txtCedula.getText();
        Chofer chofer = controladorChofer.buscarChofer(cedula);
        mdlChofer.setRowCount(0);
        if (chofer != null) {
            Object[]fila = {chofer.getId(), chofer.getApellido(), chofer.getCedula() , chofer.getDomicilio(), chofer.getFechaNacimiento(), chofer.getGrupoSanguineo(), 
                chofer.getNombre(), chofer.getTelefono()};
            mdlChofer.addRow(fila);
        } else {
            System.out.println("No se encontró ningún chofer con la cédula proporcionada.");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBus;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblDomicilio;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTable tblChofer;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDomicilio;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtGrupo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
