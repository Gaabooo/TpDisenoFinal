/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import DAO.CompetenciaDaoJDBC;
import gestor.gestorCD;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.*;

/**
 *
 * @author Martin
 */
public class ListarParticipantes extends javax.swing.JPanel {
    CompetenciaAux compAux;
    /**
     * Creates new form ListarParticipantes
     */
    public ListarParticipantes(CompetenciaAux param) {
        compAux=param;
        
        initComponents();
        
        verNombre();
        llenarTabla();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setLayout(null);

        jButton1.setText("Agregar Participante");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(568, 510, 157, 23);

        jButton2.setText("Modificar Participante");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(333, 510, 157, 23);

        jButton3.setText("Eliminar Participante");
        jButton3.setMaximumSize(new java.awt.Dimension(150, 23));
        jButton3.setMinimumSize(new java.awt.Dimension(150, 23));
        jButton3.setPreferredSize(new java.awt.Dimension(150, 23));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(99, 510, 166, 23);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);

        add(jScrollPane1);
        jScrollPane1.setBounds(100, 140, 623, 355);

        jButton4.setText("Menu P.");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4);
        jButton4.setBounds(185, 536, 80, 23);

        jButton5.setText("ATRAS");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        add(jButton5);
        jButton5.setBounds(99, 536, 80, 23);

        jLabel1.setText("Competencia Seleccionada:");
        add(jLabel1);
        jLabel1.setBounds(99, 110, 131, 14);

        jLabel2.setText("CompetenciaDSeleccionada");
        add(jLabel2);
        jLabel2.setBounds(236, 104, 131, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/img_general.jpg"))); // NOI18N
        add(jLabel3);
        jLabel3.setBounds(0, 0, 800, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        V.get().altaParticipante(compAux);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        V.get().remove(this);
        V.get().verCompetenciaSalir();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        V.get().remove(this);
        V.get().verCompetenciaVolver();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

private void verNombre(){
    
     jLabel2.setVisible(true);
     jLabel2.setText(compAux.getNombre());
     jLabel2.setFont(new java.awt.Font("Tahoma", 0, 30)); 
    }
private void llenarTabla(){
    // Llamar a la funcion para rellenar la tabla (devuelve matriz)
            
        ArrayList<Participante> listap = gestorCD.listarParticipantes(jLabel2.getText());
        
        DefaultTableModel modelo=(DefaultTableModel) jTable1.getModel();
        int filas=jTable1.getRowCount();
        int i;
        for (i=0;filas>i; i++) {
            modelo.removeRow(0);
        }
            
        for(i=0;i < listap.size();i++){
        
            String fila[]=new String[2];
            
            fila[0]= listap.get(i).getNombre();
            fila[1]= listap.get(i).getCorreo();
        
            modelo.addRow(fila);
        }    
         jTable1.setModel(modelo); 
            
        
            // Asigna los valores de la matriz a la tabla
        }
}
