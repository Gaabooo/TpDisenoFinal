/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.CompetenciaAux;
import modelo.PartidoAux;
import modelo.RondaAux;

/**
 *
 * @author GabrielV
 */
public class MostrarFixture extends javax.swing.JPanel {
    
    CompetenciaAux compAux;
    ArrayList<RondaAux> rondas;
    
    /**
     * Creates new form MostrarFixture
     * @param param
     */
    public MostrarFixture(CompetenciaAux param) {
        compAux=param;
        
        //rondas=mostrarFixture();
        
        initComponents();
        
        verNombre();
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
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setLayout(null);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Participante 1", "Participante 2", "Resultado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(48, 182, 695, 290);

        jLabel4.setFont(new java.awt.Font("Agency FB", 0, 23)); // NOI18N
        jLabel4.setText("Competencia Seleccionada:");
        add(jLabel4);
        jLabel4.setBounds(55, 90, 190, 40);

        jLabel2.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Mostrar Fixture:");
        add(jLabel2);
        jLabel2.setBounds(0, 0, 800, 55);

        jButton4.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jButton4.setText("Menu P.");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4);
        jButton4.setBounds(48, 490, 90, 31);

        jButton5.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jButton5.setText("Gestionar Resultado");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        add(jButton5);
        jButton5.setBounds(563, 490, 180, 31);

        jButton1.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(150, 490, 90, 31);

        jLabel1.setFont(new java.awt.Font("Agency FB", 0, 23)); // NOI18N
        jLabel1.setText("Nombre Competencia");
        add(jLabel1);
        jLabel1.setBounds(240, 90, 480, 40);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sports logo released.png"))); // NOI18N
        jButton6.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sports logo pressed.png")));
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setFocusPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        add(jButton6);
        jButton6.setBounds(660, 539, 130, 50);

        jLabel5.setText("* no implementado");
        add(jLabel5);
        jLabel5.setBounds(544, 550, 110, 14);

        jLabel7.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        jLabel7.setText("Ronda");
        add(jLabel7);
        jLabel7.setBounds(55, 140, 50, 30);

        jSpinner1.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 6, 1));
        jSpinner1.setEditor(new javax.swing.JSpinner.NumberEditor(jSpinner1, ""));
        add(jSpinner1);
        jSpinner1.setBounds(110, 135, 40, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/img_general.jpg"))); // NOI18N
        add(jLabel3);
        jLabel3.setBounds(0, 0, 800, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        V.get().remove(this);
        V.get().verCompetenciaSalir();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(true){
            
            V.get().gestionarResultados(compAux, null, null);
            
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        V.get().remove(this);
        V.get().verCompetenciaVolver();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        V.get().integrantes(this);
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void verNombre(){
        jLabel1.setVisible(true);
        jLabel1.setText(compAux.getNombre());
    }
    
    private void llenarTabla(int ronda){
        

        // Se recuperan las competenciasAux de la base de datos
        
        // Eliminacion de la tabla actual
        DefaultTableModel modelo=(DefaultTableModel) jTable1.getModel();
        int filas=jTable1.getRowCount();
        int i;
        for (i=0;filas>i; i++) {
            modelo.removeRow(0);
        }
        
        // LLenado de la tabla actual
        
        RondaAux rondaActual=rondas.get(ronda-1);
        
        ArrayList<PartidoAux> listaPartidos=rondaActual.getPartidos();
        
        for(i=0;i < listaPartidos.size();i++){
            
            PartidoAux partAux=listaPartidos.get(i);
            
            String fila[]=new String[4];
            
            fila[0]= partAux.getFecha();
            fila[1]= partAux.getParticipante1();
            fila[2]= partAux.getParticipante2();
            fila[3]= partAux.getResultado();
            
            modelo.addRow(fila);
        }
        jTable1.setModel(modelo);
        
        if(jTable1.getRowCount()==0){
            JOptionPane.showMessageDialog(null,"No se han encontrado resultados.",
                    "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}
