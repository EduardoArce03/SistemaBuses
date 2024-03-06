/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;

import controlador.ControladorCliente;
import controlador.ControladorPedido;
import controlador.ControladorRuta;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Ruta;

/**
 *
 * @author eduar
 */
public class VistaPedido extends javax.swing.JInternalFrame {
    ControladorPedido controladorPedido;
    ControladorCliente controladorCliente;
    ControladorRuta controladorRuta;
    DefaultTableModel mdlPedido;
    Pedido pedido;
    DefaultComboBoxModel mdlCliente;
    DefaultComboBoxModel mdlRuta;
    DefaultComboBoxModel mdlValor;
    private JDialog panelAsientos;
    boolean seleccionado = false;
    /**
     * Creates new form VistaPedido
     */
    public VistaPedido(ControladorPedido controladorPedido, ControladorCliente controladorCliente, ControladorRuta controladorRuta) {
        initComponents();
        this.controladorPedido = controladorPedido;
        this.controladorCliente = controladorCliente;
        this.controladorRuta = controladorRuta;
        this.mdlCliente = (DefaultComboBoxModel) cmbCliente.getModel();
        this.mdlRuta = (DefaultComboBoxModel) cmbRuta.getModel();
        this.mdlPedido = (DefaultTableModel) tblPedido.getModel();
        
        
        
        tblPedido.getSelectionModel().addListSelectionListener((e) -> {
        });
       cargarTabla();
        sumar();
        
    }

  
    
  private void inicializarAsientos() {
    panelAsientos = new JDialog();
    panelAsientos.setLayout(new GridLayout(15, 15, 5, 5));
    
    panelAsientos.setTitle("SELECCION DE ASIENTOS");
    for (int fila = 0; fila < 4; fila++) {
        for (int columna = 0; columna < 15; columna++) {
            JButton botonAsiento = new JButton();
            botonAsiento.setBackground(Color.green);
            botonAsiento.setText((fila * 15 + columna + 1) + "");
            botonAsiento.setText(botonAsiento.getText());
            botonAsiento.addActionListener(e -> {
                JOptionPane.showMessageDialog(null, "El asiento " + botonAsiento.getText() + " ha sido seleccionado");
                seleccionado = true;
                if (seleccionado == true) {
                    botonAsiento.setBackground(Color.red);
                    botonAsiento.setEnabled(false);
                    botonAsiento.setBackground(Color.red);
                }
            });
            panelAsientos.add(botonAsiento);
        }
    }
    panelAsientos.setLocationRelativeTo(null); // Centramos la ventana en la pantalla
    panelAsientos.setSize(1800, 1600);
    panelAsientos.setVisible(true); // Mostramos el diálogo
}

    public void cargarTabla(){
        mdlPedido.setNumRows(0);
        for(Pedido pedido : controladorPedido.getListPedido()){
            Object [] fila = {pedido.getId(), pedido.getCliente(), pedido.getFecha(), pedido.getHora(), pedido.getRuta(), pedido.getValor()};
            mdlPedido.addRow(fila);
        }listarForm(-1);
    }
    
    public void listarForm(int posicion){
        if (posicion >= 0){
            pedido = controladorPedido.getListPedido().get(posicion);
            txtFecha.setText(String.valueOf(pedido.getFecha()));
            txtHora.setText(String.valueOf(pedido.getHora()));
            txtValor.setText(String.valueOf(pedido.getValor()));
            cmbCliente.setSelectedItem(pedido.getCliente().getNombre());
            cmbRuta.setSelectedItem(pedido.getRuta().getRuta());
        }else{         
            pedido = null;
            txtFecha.setText("");
            txtHora.setText("");
            txtValor.setText("");
            cmbCliente.setSelectedIndex(0);
            cmbRuta.setSelectedIndex(0);
          
        }
    }
    
    public void sumar(){
             
        double suma = 0;
        
        int tamFila = tblPedido.getRowCount();
        for (int i = 0; i < tamFila; i++) {
            suma += Double.parseDouble(tblPedido.getValueAt(i, 6).toString()); 

        }
        String cadena = Double.toString(suma);
 
        txtGanancia.setText(cadena);                    

    }
    
    /*public void validarAsientos(){
                
        int tamFila = tblPedido.getRowCount();
        for (int i = 0; i < tamFila; i++) {
            if (tblPedido.getValueAt(i, 5).toString().equals(txtAsiento.getText())) {
                System.out.println("error");
                JOptionPane.showMessageDialog(null, closable);
                
            }
        }
    }*/
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        lblAsiento = new javax.swing.JLabel();
        lblRuta = new javax.swing.JLabel();
        cmbCliente = new javax.swing.JComboBox<>();
        cmbRuta = new javax.swing.JComboBox<>();
        lblValor = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPedido = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtGanancia = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        AsientoBtn = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 0, 48)); // NOI18N
        jLabel1.setText("BOLETO");

        lblCliente.setText("Cliente:");

        lblFecha.setText("Fecha:");

        lblHora.setText("Hora:");

        lblAsiento.setText("Asiento:");

        lblRuta.setText("Ruta:");

        lblValor.setText("Valor:");

        tblPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Cliente", "Fecha", "Hora", "Ruta", "Asiento", "Valor"
            }
        ));
        jScrollPane1.setViewportView(tblPedido);

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

        jLabel2.setText("VALOR GANADO:");

        AsientoBtn.setText("Seleccionar Asiento");
        AsientoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsientoBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFecha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFecha))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblHora)
                                .addGap(18, 18, 18)
                                .addComponent(txtHora))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblRuta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblValor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAsiento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AsientoBtn)))
                        .addGap(9, 9, 9)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnNuevo)
                        .addGap(36, 36, 36)
                        .addComponent(btnGuardar)
                        .addGap(34, 34, 34)
                        .addComponent(btnEliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGanancia, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente)
                    .addComponent(lblAsiento)
                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(AsientoBtn))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFecha)
                    .addComponent(lblRuta)
                    .addComponent(cmbRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHora)
                    .addComponent(lblValor)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtGanancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        listarForm(-1);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        controladorPedido.eliminar(pedido);
        cargarTabla();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void AsientoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsientoBtnActionPerformed
        System.out.println("INICIANDO METODO ASIENTOS");
    inicializarAsientos();
    System.out.println("DESPUES ASIENTOS");
    panelAsientos.setSize(new Dimension(500, 300)); // Configura el tamaño de la ventana emergente
    panelAsientos.setLocationRelativeTo(null); // Centra la ventana emergente en la pantalla
    panelAsientos.setVisible(true); // Muestra la ventana emergente
        
    }//GEN-LAST:event_AsientoBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AsientoBtn;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cmbCliente;
    private javax.swing.JComboBox<String> cmbRuta;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAsiento;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblRuta;
    private javax.swing.JLabel lblValor;
    private javax.swing.JTable tblPedido;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtGanancia;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
