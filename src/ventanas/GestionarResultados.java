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
public class GestionarResultados extends javax.swing.JPanel {
    CompetenciaAux compAux;
    /**
     * Creates new form GestionarResultados
     */
    public GestionarResultados(CompetenciaAux param) {
        compAux=param;
        
        initComponents();
        verNombre();
        crearYLlenarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setLayout(null);

        jLabel2.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Gestionar Resultados:");
        add(jLabel2);
        jLabel2.setBounds(0, 0, 800, 55);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Competidores", "1er Set", "2do Set", "3er Set", "4to Set", "5to Set", "6to Set", "7to Set", "8vo Set", "9no Set", "Asistencia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(47, 148, 720, 100);

        jButton1.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(675, 258, 90, 30);

        jButton2.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jButton2.setText("Atras");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(150, 258, 90, 30);

        jButton3.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jButton3.setText("Menu P.");
        add(jButton3);
        jButton3.setBounds(48, 258, 90, 30);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sports logo released.png"))); // NOI18N
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

        jLabel3.setFont(new java.awt.Font("Agency FB", 0, 23)); // NOI18N
        jLabel3.setText("Nombre Competencia");
        add(jLabel3);
        jLabel3.setBounds(240, 90, 480, 40);

        jLabel1.setFont(new java.awt.Font("Agency FB", 0, 23)); // NOI18N
        jLabel1.setText("Competencia Seleccionada:");
        add(jLabel1);
        jLabel1.setBounds(55, 90, 190, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/img_general.jpg"))); // NOI18N
        add(jLabel4);
        jLabel4.setBounds(0, 0, 800, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        V.get().integrantes(this);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void crearYLlenarTabla(){
        String formaPuntuacion = compAux.getFormaPuntuacion();

        switch (formaPuntuacion) {
        case "Puntuacion":
            formaPPuntuacion();
            break;
        case "Sets":
            formaPSets();
            break;
        default:
            formaPResultadoFinal();
            break;
        }
    }
    
    private void formaPPuntuacion(){
        // metodo que modifica y llena tabla
        repaint();
    }
    //Habilitacion de campos para forma de puntuacion, sets
    private void formaPSets(){
        // metodo que modifica y llena tabla
        repaint();
    }
    //Habilitacion de campos para forma de puntuacion, Resultado final
    private void formaPResultadoFinal(){
        // metodo que modifica y llena tabla
        repaint();
    }
    
    private void verNombre(){
    
     jLabel3.setVisible(true);
     jLabel3.setText(compAux.getNombre());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
