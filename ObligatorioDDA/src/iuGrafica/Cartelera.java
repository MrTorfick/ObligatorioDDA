/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package iuGrafica;

import controlador.ControladorCartelera;
import controlador.VistaCartelera;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.table.DefaultTableModel;
import logica.Parking;
import logica.Tarifa;

/**
 *
 * @author marcos
 */
public class Cartelera extends javax.swing.JDialog implements VistaCartelera {

    private ControladorCartelera controlador;
    DefaultTableModel modeloTabla1 = new DefaultTableModel();
    DefaultTableModel modeloTabla2 = new DefaultTableModel();

    public Cartelera(java.awt.Frame parent, Parking u) {
        super(parent);
        initComponents();
        setLocationRelativeTo(parent);
        controlador = new ControladorCartelera(this, u);
        modeloTabla1.setColumnIdentifiers(new Object[]{"Cocheras", "Disponibilidad"});
        modeloTabla2.setColumnIdentifiers(new Object[]{"Tipo de vehiculo", "Precio/<UT>"});
        tablaEtiquetas.setModel(modeloTabla1);
        tablaTipoVehiculo.setModel(modeloTabla2);
        //controlador
        setTitle("Cartelera electronica" + u.getNombre());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        totalDisponible = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEtiquetas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaTipoVehiculo = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Disponibilidad");

        jButton1.setText("Cerrar");

        tablaEtiquetas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaEtiquetas);

        tablaTipoVehiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaTipoVehiculo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(totalDisponible))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaEtiquetas;
    private javax.swing.JTable tablaTipoVehiculo;
    private javax.swing.JLabel totalDisponible;
    // End of variables declaration//GEN-END:variables

    @Override
    public void listarEtiquetas(ArrayList<Entry<String, Integer>> lista, int cantidadCocherasLibres) {
        totalDisponible.setText(cantidadCocherasLibres + "");

        limpiarListadoEtiquetas();

        for (Map.Entry<String, Integer> e : lista) {
            modeloTabla1.addRow(new Object[]{e.getKey(),
                e.getValue()});

        }

    }

    private void limpiarListadoEtiquetas() {
        int rowCount = modeloTabla1.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            modeloTabla1.removeRow(i);
        }
    }

    @Override
    public void listarTipoVehiculo(ArrayList<Tarifa> listaTarifas) {
        limpiarListadoTipoVehiculos();

        for (Tarifa t : listaTarifas) {
            modeloTabla2.addRow(new Object[]{t.getTipoVehiculo().getNombre(),
                t.getCosto()});
        }

    }

    private void limpiarListadoTipoVehiculos() {
        int rowCount = modeloTabla2.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            modeloTabla2.removeRow(i);
        }
    }
}
