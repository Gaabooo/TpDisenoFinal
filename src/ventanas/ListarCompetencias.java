
package ventanas;

import DAO.CompetenciaDaoJDBC;
import gestor.gestorCD;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.CompetenciaAux;

public class ListarCompetencias extends javax.swing.JPanel {

    /**
     * Creates new form Auxiliar
     */
    
    public ListarCompetencias() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SALIR = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(null);

        SALIR.setText("Atras");
        SALIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SALIRActionPerformed(evt);
            }
        });
        add(SALIR);
        SALIR.setBounds(260, 510, 90, 23);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros de búsqueda"));

        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre de la Competencia");

        String[] listaNombresDeportes = gestor.QueMasTeGuste.getListaDeportes();
        String[] listaND= new String[listaNombresDeportes.length+1];
        listaND[0]="";
        for(int j=0; j<listaNombresDeportes.length; j++){
            listaND[j+1]=listaNombresDeportes[j];
        }
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(listaND));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Creada", "Planificada", "EnDisputa", "Finalizada" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Liga", "Eliminatoria Simple", "Eliminatoria Doble" }));

        jLabel6.setText("Modalidad");

        jLabel4.setText("Estado");

        jLabel5.setText("Deporte");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(41, 41, 41))
        );

        jTextField1.addKeyListener(new KeyAdapter() {

            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                    e.setKeyChar(Character.toUpperCase(keyChar));
                }
            }

        });

        add(jPanel2);
        jPanel2.setBounds(28, 77, 197, 418);
        jPanel2.getAccessibleContext().setAccessibleName("");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Deporte", "Modalidad", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setFocusable(false);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(261, 85, 504, 410);

        jButton3.setText("Crear Competencia");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(460, 510, 150, 23);

        jButton4.setText("Ver Competencia");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4);
        jButton4.setBounds(630, 510, 140, 23);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/img_general.jpg"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void SALIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SALIRActionPerformed
        V.get().menu();
    }//GEN-LAST:event_SALIRActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jComboBox2.getSelectedIndex()==0 && jComboBox3.getSelectedIndex()==0 &&
                jComboBox1.getSelectedIndex()==0 && jTextField1.getText().isEmpty()){
            errorFiltros();
        }
        else{
            
            // Llamar a la funcion para rellenar la tabla (devuelve matriz)
            Object estado = jComboBox1.getSelectedItem(); 
            String textEstado = String.valueOf(estado);
            Object deporte = jComboBox2.getSelectedItem(); 
            String textDeporte= String.valueOf(deporte);
            Object modalidad = jComboBox3.getSelectedItem(); 
            String textModalidad= String.valueOf(modalidad);
            
            String nombre=jTextField1.getText();
            
            if("".equals(textDeporte)){textDeporte=null;}
            if("".equals(textEstado)){textEstado=null;}
            if("".equals(textModalidad)){textModalidad=null;}
            
            if("".equals(jTextField1.getText())){
                nombre=null;
            }
            
            // Se recuperan las competenciasAux de la base de datos
            ArrayList<CompetenciaAux> listaprueba = gestorCD.listarCD(nombre, textDeporte,textModalidad,textEstado);
            
            
            // Eliminacion de la tabla actual
            DefaultTableModel modelo=(DefaultTableModel) jTable1.getModel();
            int filas=jTable1.getRowCount();
            int i;
            for (i=0;filas>i; i++) {
                modelo.removeRow(0);
            }
            
            // Se le asignan las competencias recuperadas
            for(i=0;i < listaprueba.size();i++){
                
                CompetenciaAux elem=listaprueba.get(i);
                
                String fila[]=new String[4];
                
                fila[0]= elem.getNombre();
                fila[1]= elem.getDeporte();
                fila[2]= elem.getModalidad();
                fila[3]= elem.getEstado();
                
                modelo.addRow(fila);
            }
            jTable1.setModel(modelo);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        V.get().altaCompetencia();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        int row = jTable1.getSelectedRow();
        
        if(row == -1){
            JOptionPane.showMessageDialog(null,"Debe seleccionar una competencia",
                    "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        
        else{
            
            String nombre=jTable1.getValueAt(row, 0).toString();
            String deporte=jTable1.getValueAt(row, 1).toString();
            String modalidad=jTable1.getValueAt(row, 2).toString();
            String estado=jTable1.getValueAt(row, 3).toString(); 
            
            int idComp=gestorCD.obtenerIdCD(nombre);
            
            CompetenciaAux compAux= new CompetenciaAux(estado, deporte, modalidad, nombre, idComp);
            
            V.get().verCompetencia(compAux);
        }
    
    
    }//GEN-LAST:event_jButton4ActionPerformed

    private void errorFiltros(){
        JOptionPane.showMessageDialog(null, "Ingrese un filtro de busqueda", "", JOptionPane.INFORMATION_MESSAGE);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SALIR;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
