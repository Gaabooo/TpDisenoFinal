/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import modelo.CompetenciaAux;

/**
 *
 * @author GabrielV
 */
public class Integrantes extends javax.swing.JPanel {
    
    
    /**
     * Creates new form AltaParticipante
     */
    public Integrantes() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel1.setText("Nombre y Apellido: Jorge Ramirez");
        add(jLabel1);
        jLabel1.setBounds(350, 162, 270, 20);

        jLabel2.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel2.setText("Correo Electrónico: jrjjorge@hotmail.com");
        add(jLabel2);
        jLabel2.setBounds(350, 190, 240, 20);

        jButton2.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jButton2.setText("Atras");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(46, 530, 130, 31);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/img_avatar.jpg"))); // NOI18N
        add(jLabel3);
        jLabel3.setBounds(40, 80, 290, 290);

        jLabel5.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Integrantes");
        add(jLabel5);
        jLabel5.setBounds(1, 2, 800, 60);

        jLabel6.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel6.setText("Nombre y Apellido: Martin Figueroa");
        add(jLabel6);
        jLabel6.setBounds(350, 92, 200, 20);

        jLabel7.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel7.setText("Correo Electrónico: martin2217@gmail.com");
        add(jLabel7);
        jLabel7.setBounds(350, 120, 230, 20);

        jLabel8.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel8.setText("Nombre y Apellido: Alejandro Schneider.");
        add(jLabel8);
        jLabel8.setBounds(350, 232, 270, 20);

        jLabel9.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel9.setText("Correo Electrónico: schneideralejandro@outlook.com");
        add(jLabel9);
        jLabel9.setBounds(350, 260, 300, 20);

        jLabel10.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel10.setText("Nombre y Apellido: Gabriel Vargas.");
        add(jLabel10);
        jLabel10.setBounds(350, 300, 210, 22);

        jLabel11.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel11.setText("Correo Electrónico: gabrielvargas94@outlook.com");
        add(jLabel11);
        jLabel11.setBounds(350, 330, 270, 20);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sports logo2.png"))); // NOI18N
        add(jLabel12);
        jLabel12.setBounds(240, 364, 560, 240);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/img_general.jpg"))); // NOI18N
        add(jLabel4);
        jLabel4.setBounds(0, 0, 800, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        V.get().integrantesVolver();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
