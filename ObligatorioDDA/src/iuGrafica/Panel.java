/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package iuGrafica;

import controlador.ControladorPanel;
import controlador.VistaPanel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.Anomalia;
import logica.Parking;

/**
 *
 * @author marcos
 */
public class Panel extends javax.swing.JFrame implements VistaPanel {

    /**
     * Creates new form PanelDeControl
     */
    private ControladorPanel controlador;
    DefaultTableModel modeloTabla1 = new DefaultTableModel();
    DefaultTableModel modeloTabla2 = new DefaultTableModel();

    public Panel() {
        initComponents();
        setLocationRelativeTo(null);
        modeloTabla1.setColumnIdentifiers(new Object[]{"Parking", "Ocupadas", "Libres", "Estado", "Factor demanda", "Estadias", "Multas", "Subtotal"});
        modeloTabla2.setColumnIdentifiers(new Object[]{"Fecha/Hora", "Propietario", "Codigo de anomalia", "Cochera"});
        tablaParkings.setModel(modeloTabla1);
        tablaAnomalia.setModel(modeloTabla2);
        controlador = new ControladorPanel(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        totalEstadias = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        totalFacturacion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaParkings = new javax.swing.JTable();
        botonPrecios = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaAnomalia = new javax.swing.JTable();
        jCheckBoxMonitorearAnomalias = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Estadias:");

        totalEstadias.setText("0");

        jLabel2.setText("Facturacion:");

        totalFacturacion.setText("0");

        tablaParkings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaParkings);

        botonPrecios.setText("Precios");
        botonPrecios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPreciosActionPerformed(evt);
            }
        });

        jButton2.setText("Cartelera");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tablaAnomalia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Fecha/Hora", "Propietario", "Codigo de anomalia", "Cochera"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaAnomalia);

        jCheckBoxMonitorearAnomalias.setText("Monitorear anomalias");
        jCheckBoxMonitorearAnomalias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMonitorearAnomaliasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(469, Short.MAX_VALUE)
                .addComponent(botonPrecios)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jCheckBoxMonitorearAnomalias)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalEstadias, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalFacturacion, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(totalEstadias)
                    .addComponent(jLabel2)
                    .addComponent(totalFacturacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonPrecios)
                    .addComponent(jButton2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jCheckBoxMonitorearAnomalias)))
                .addGap(164, 164, 164))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonPreciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPreciosActionPerformed

        String parkingSeleccionado = obtenerParking();
        if (parkingSeleccionado != null) {
            controlador.mostrarListaPrecios(parkingSeleccionado);
        }


    }//GEN-LAST:event_botonPreciosActionPerformed

    private void jCheckBoxMonitorearAnomaliasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMonitorearAnomaliasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxMonitorearAnomaliasActionPerformed

    private String obtenerParking() {

        int filaSeleccionada = tablaParkings.getSelectedRow();

        if (filaSeleccionada == -1) {
            mostrarMensaje("Debe seleccionar un parking");
        } else {
            String parkingSeleccionado = (String) modeloTabla1.getValueAt(filaSeleccionada, 0);
            return parkingSeleccionado;
        }
        return null;
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String parkingSeleccionado = obtenerParking();
        if (parkingSeleccionado != null) {
            controlador.mostrarCartelera(parkingSeleccionado);
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        controlador.salir();
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonPrecios;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBoxMonitorearAnomalias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaAnomalia;
    private javax.swing.JTable tablaParkings;
    private javax.swing.JLabel totalEstadias;
    private javax.swing.JLabel totalFacturacion;
    // End of variables declaration//GEN-END:variables

    @Override
    public void MostrarTotalEstadias(double t) {
        String total = t + "";
        totalEstadias.setText(total);
    }

    @Override
    public void mostrarTotalFacturado(double t) {
        String total = t + "";
        totalFacturacion.setText(total);
    }

    @Override
    public void listarParkings(ArrayList<Parking> listaParkings) {

        for (Parking p : listaParkings) {
            modeloTabla1.addRow(new Object[]{p.getNombre(),
                p.cantidadCocherasOcupadas(),
                p.cantidadCocherasLibres(),
                p.getTendenciaActual().getNombre(),
                p.getFactorDemanda(),
                p.totalEstadias(),
                p.totalMultas(),
                p.totalFacturado()});
        }

    }

    @Override
    public void listarAnomalias(ArrayList<Anomalia> listaAnomalias) {

        if (jCheckBoxMonitorearAnomalias.isSelected()) {

            for (Anomalia a : listaAnomalias) {

                if (a.getEstadia().getVehiculo() == null) {
                    modeloTabla2.addRow(new Object[]{a.getFecha(),
                        "No corresponde",
                        a.getError(), a.getEstadia().getCochera().getCodigo()});
                } else {
                    modeloTabla2.addRow(new Object[]{a.getFecha(),
                        a.getEstadia().getVehiculo().getPropietario().getCedula(),
                        a.getError(), a.getEstadia().getCochera().getCodigo()});
                }

            }
        }
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    @Override
    public void mostrarListaPrecios(Parking p) {
        new ListaPrecios(this, p).setVisible(true);
    }

    @Override
    public void mostrarCartelera(Parking p) {
        new Cartelera(this, p).setVisible(true);
    }

    @Override
    public void limpiarListadoParkings() {
        int rowCount = modeloTabla1.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            modeloTabla1.removeRow(i);
        }

    }

}
