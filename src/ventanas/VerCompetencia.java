/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import javax.swing.JOptionPane;
import modelo.CompetenciaAux;

/**
 *
 * @author Martin
 */
public class VerCompetencia extends javax.swing.JPanel {

    CompetenciaAux compAux;
    String cadenaError;
    /**
     * Creates new form VerCompetencia
     * @param param
     */
    public VerCompetencia(CompetenciaAux param) {
        
        compAux=param;
        
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setLayout(null);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Participante 1", "Participante 2", "Club", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.setFocusable(false);

        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(49, 369, 700, 140);

        jButton1.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jButton1.setText("Menu Principal");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(285, 292, 246, 45);

        jButton2.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jButton2.setText("Mostrar Fixture");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(549, 250, 200, 45);

        jButton3.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jButton3.setText("Mostrar Tablas de Posiciones");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(67, 198, 200, 45);

        jButton4.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jButton4.setText("Listar Participantes");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4);
        jButton4.setBounds(67, 147, 200, 45);

        jButton5.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jButton5.setText("Modificar Competencia");
        add(jButton5);
        jButton5.setBounds(549, 147, 200, 45);

        jButton6.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jButton6.setText("Dar De Baja Competencia");
        add(jButton6);
        jButton6.setBounds(549, 198, 200, 45);

        jButton7.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jButton7.setText("Generar Fixture");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        add(jButton7);
        jButton7.setBounds(67, 250, 200, 45);

        jLabel1.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel1.setText("Deporte:");
        add(jLabel1);
        jLabel1.setBounds(73, 114, 43, 22);

        jLabel2.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel2.setText("Modalidad:");
        add(jLabel2);
        jLabel2.setBounds(285, 114, 52, 22);

        jLabel3.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel3.setText("Estado:");
        add(jLabel3);
        jLabel3.setBounds(516, 114, 37, 22);

        jLabel4.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel4.setText("COMPETENCIA DEPORTIVA:");
        add(jLabel4);
        jLabel4.setBounds(55, 70, 180, 40);

        jLabel5.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        jLabel5.setText("Nombre Competencia");
        add(jLabel5);
        jLabel5.setBounds(200, 70, 480, 40);

        jLabel6.setText("jLabel6");
        add(jLabel6);
        jLabel6.setBounds(122, 105, 140, 30);

        jLabel7.setText("jLabel7");
        add(jLabel7);
        jLabel7.setBounds(343, 100, 150, 40);

        jLabel8.setText("jLabel8");
        add(jLabel8);
        jLabel8.setBounds(559, 105, 170, 30);

        jButton8.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jButton8.setText("Atras");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        add(jButton8);
        jButton8.setBounds(48, 515, 90, 36);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sports logo mas chico1.png"))); // NOI18N
        jLabel9.setText("jLabel9");
        jLabel9.setMaximumSize(new java.awt.Dimension(636, 250));
        jLabel9.setMinimumSize(new java.awt.Dimension(636, 250));
        add(jLabel9);
        jLabel9.setBounds(285, 157, 246, 111);

        jLabel10.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Ver Competencia Deportiva");
        jLabel10.setToolTipText("");
        add(jLabel10);
        jLabel10.setBounds(0, 0, 800, 60);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sports logo released.png"))); // NOI18N
        jButton9.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sports logo pressed.png")));
        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);
        jButton9.setFocusPainted(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        add(jButton9);
        jButton9.setBounds(638, 530, 152, 59);

        jLabel12.setText("* no implementado");
        add(jLabel12);
        jLabel12.setBounds(534, 550, 120, 14);

        jLabel13.setText("*");
        add(jLabel13);
        jLabel13.setBounds(750, 150, 6, 14);

        jLabel15.setText("*");
        add(jLabel15);
        jLabel15.setBounds(750, 200, 6, 14);

        jLabel14.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel14.setText("Proximos Encuentros:");
        add(jLabel14);
        jLabel14.setBounds(50, 340, 140, 30);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/img_general.jpg"))); // NOI18N
        add(jLabel11);
        jLabel11.setBounds(0, 0, 800, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        V.get().remove(this);
        V.get().listarCompetenciasSalir();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        V.get().listarParticipantes(compAux);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        V.get().mostrarFixture(compAux);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        cadenaError="";
        // modalidad liga
        // disputa o finalizada
        boolean ml= modalidadLiga();
        boolean dop= disputaOFinalizada();
        if(ml || dop){
            JOptionPane.showMessageDialog(null,cadenaError,
                    "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            V.get().mostrarTablaPosiciones(compAux);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        V.get().remove(this);
        V.get().listarCompetenciasVolver();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if("Planificada".equals(compAux.getEstado()) || "Creada".equals(compAux.getEstado())){
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea generar el fixture?",
                    "Generar Fixture", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                // Generar el fixture
                gestor.GestorGestionarFixture.generarFixture(compAux);
                compAux.setEstado("Planificada");
                verNombre();
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "La competencia debe estar en estado Creada o Planificada",
                    "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        V.get().integrantes(this);
    }//GEN-LAST:event_jButton9ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
 
    private void verNombre(){
    
     jLabel5.setVisible(true);
     jLabel5.setText(compAux.getNombre());
     jLabel5.setFont(new java.awt.Font("Agency FB", 0, 24)); 
     
     jLabel6.setVisible(true);
     jLabel6.setText(compAux.getDeporte());
     jLabel6.setFont(new java.awt.Font("Agency FB", 0, 24)); 
     
     jLabel7.setVisible(true);
     jLabel7.setText(compAux.getModalidad());
     jLabel7.setFont(new java.awt.Font("Agency FB", 0, 24));
     
     jLabel8.setVisible(true);
     jLabel8.setText(compAux.getEstado());
     jLabel8.setFont(new java.awt.Font("Agency FB", 0, 24));
    
    }
    
    private boolean modalidadLiga(){
        if("Liga".equals(compAux.getModalidad())){
            return false;
        }
        else{
            cadenaError=cadenaError+"La competencia debe ser de modalidad liga.\n";
            return true;
        }
    }
    private boolean disputaOFinalizada(){
        if("EnDisputa".equals(compAux.getEstado()) || "Finalizada".equals(compAux.getEstado())){
            return false;
        }
        else{
            cadenaError=cadenaError+"La competencia debe estar en disputa o finalizada.";
            return true;
        }
    }
}

