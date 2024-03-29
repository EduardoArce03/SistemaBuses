/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;

import controlador.ControladorBus;
import controlador.ControladorCliente;
import controlador.ControladorReserva;
import controlador.ControladorRuta;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Bus;
import modelo.Cliente;
import modelo.Reserva;
import modelo.Ruta;

/**
 *
 * @author eduar
 */
public class VistaReserva extends javax.swing.JInternalFrame {
    ControladorReserva controladorReserva;
    ControladorCliente controladorCliente;
    ControladorBus controladorBus;
    ControladorRuta controladorRuta;
    DefaultTableModel mdlReserva;
    DefaultComboBoxModel mdlCliente;
    DefaultComboBoxModel mdlBus;
    DefaultComboBoxModel mdlRuta;
    Reserva reserva;

    /**
     * Creates new form VistaReserva
     */
    public VistaReserva(ControladorReserva controladorReserva, ControladorCliente controladorCliente, ControladorBus controladorBus, ControladorRuta controladorRuta) {
        initComponents();
        this.controladorReserva = controladorReserva;
        this.controladorBus = controladorBus;
        this.controladorCliente = controladorCliente;
        this.controladorRuta = controladorRuta;
        this.mdlReserva = (DefaultTableModel) tblReserva.getModel();
        this.mdlBus = (DefaultComboBoxModel) cmbBus.getModel();
        this.mdlCliente = (DefaultComboBoxModel) cmbCliente.getModel();
        this.mdlRuta = (DefaultComboBoxModel) cmbRuta.getModel();
        tblReserva.getSelectionModel().addListSelectionListener((e) -> {
        });
        for(Bus bus : controladorBus.getListBus()){
            mdlBus.addElement(bus.getPlaca());
        }
       cargarTabla();
        sumar();
    }
    
    public void cargarTabla(){
        mdlReserva.setNumRows(0);
        for (Reserva reserva : controladorReserva.getListReserva()){
            Object [] fila = {controladorReserva.generarId(), reserva.getCliente(), reserva.getRuta(), reserva.getValor(), reserva.getBus()};
            mdlReserva.addRow(fila);
            
        }listarForm(-1);
    }
    
    public void listarForm(int posicion){
        if(posicion >= 0){
            reserva = controladorReserva.getListReserva().get(posicion);
            cmbBus.setSelectedItem(reserva.getBus().getPlaca());
            cmbCliente.setSelectedItem(reserva.getCliente().getNombre());
            cmbRuta.setSelectedItem(reserva.getRuta().getRuta());
            txtValor.setText(String.valueOf(reserva.getValor()));
        }else{
            reserva = null;
            txtValor.setText("");
            cmbBus.setSelectedItem(0);
            cmbCliente.setSelectedItem(0);
            cmbRuta.setSelectedItem(0);
        }
    }
    
    public void sumar(){
        
        double suma = 0;
        int tamFila = tblReserva.getRowCount();
        for (int i = 0; i < tamFila; i++) {
            suma += Double.parseDouble(tblReserva.getValueAt(i, 3).toString()); 

        }
        String cadena = Double.toString(suma*25);
 
        txtGanancia.setText(cadena);                    

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCliente = new javax.swing.JLabel();
        lblBus = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReserva = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        cmbCliente = new javax.swing.JComboBox<>();
        cmbBus = new javax.swing.JComboBox<>();
        lblRuta = new javax.swing.JLabel();
        cmbRuta = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        lblGanancia = new javax.swing.JLabel();
        txtGanancia = new javax.swing.JTextField();

        lblCliente.setText("Cliente:");

        lblBus.setText("Bus:");

        lblValor.setText("Horas Alquiladas:");

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
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

        tblReserva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Cliente", "Ruta", "Valor", "Bus"
            }
        ));
        jScrollPane1.setViewportView(tblReserva);

        jLabel4.setFont(new java.awt.Font("Lucida Bright", 0, 48)); // NOI18N
        jLabel4.setText("RESERVA DE BUSES");

        lblRuta.setText("Ruta:");

        jLabel6.setText("HORA DE ALQUILER: 25$");

        lblGanancia.setText("TOTAL GANANCIA:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCliente)
                                    .addComponent(lblBus))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cmbBus, 0, 146, Short.MAX_VALUE)
                                    .addComponent(cmbCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(70, 70, 70)
                                .addComponent(btnNuevo)
                                .addGap(39, 39, 39)
                                .addComponent(btnGuardar)
                                .addGap(26, 26, 26)
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblValor)
                                .addGap(28, 28, 28)
                                .addComponent(txtValor))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblRuta)
                                .addGap(31, 31, 31)
                                .addComponent(cmbRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblGanancia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtGanancia, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel4)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente)
                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBus)
                    .addComponent(cmbBus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRuta)
                    .addComponent(cmbRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValor)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGanancia)
                    .addComponent(txtGanancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        listarForm(-1);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int resultado = JOptionPane.showConfirmDialog(this, "Seguro de eliminar");
        if(resultado == 0){
            controladorReserva.eliminar(reserva);
            cargarTabla();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cmbBus;
    private javax.swing.JComboBox<String> cmbCliente;
    private javax.swing.JComboBox<String> cmbRuta;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBus;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblGanancia;
    private javax.swing.JLabel lblRuta;
    private javax.swing.JLabel lblValor;
    private javax.swing.JTable tblReserva;
    private javax.swing.JTextField txtGanancia;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
