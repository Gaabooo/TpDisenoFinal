/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

/**
 *
 * @author Martin
 */
public class Menu extends javax.swing.JPanel {

    /**
     * Creates new form MenuPrincipal
     */
    public Menu() {
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

        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setRequestFocusEnabled(false);
        setLayout(null);

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Mi Usuario");
        add(jLabel3);
        jLabel3.setBounds(-6, 249, 810, 22);

        jButton2.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jButton2.setText("Dar de Baja Usuario");
        add(jButton2);
        jButton2.setBounds(300, 318, 200, 31);

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Sistema");
        add(jLabel4);
        jLabel4.setBounds(-2, 367, 800, 22);

        jButton3.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jButton3.setText("Listar Lugares de Realizacion");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(300, 395, 200, 31);

        jButton4.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jButton4.setText("Listar Competencia Deportivas");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4);
        jButton4.setBounds(300, 436, 200, 31);

        jButton5.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jButton5.setText("Modificar Datos de Usuario");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        add(jButton5);
        jButton5.setBounds(300, 277, 200, 31);

        jLabel1.setText("*");
        add(jLabel1);
        jLabel1.setBounds(510, 284, 15, 10);

        jLabel5.setText("*");
        add(jLabel5);
        jLabel5.setBounds(510, 324, 15, 10);

        jLabel6.setText("*");
        add(jLabel6);
        jLabel6.setBounds(510, 404, 15, 10);

        jLabel7.setText("*: No implementado");
        add(jLabel7);
        jLabel7.setBounds(500, 570, 130, 14);

        jButton1.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(360, 490, 70, 30);

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
        jButton6.setBounds(663, 543, 130, 50);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/img_menu.jpg"))); // NOI18N
        add(jLabel9);
        jLabel9.setBounds(0, 0, 800, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        V.get().listarCompetencias();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        V.get().salir();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // Hacer que se muestre la ventana de Integrantes
        V.get().integrantes(this);
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
