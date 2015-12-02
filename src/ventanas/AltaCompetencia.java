/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.util.Vector;
import javax.swing.JSpinner.NumberEditor;
import modelo.*;
import java.util.ArrayList;
import DAO.*;
import gestor.*;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import sonidos.alertaSuave;
        

/**
 *
 * @author Martin
 */
public class AltaCompetencia extends javax.swing.JPanel {
    
    TablaDisponibilidad tablaDisp = new TablaDisponibilidad();
    alertaSuave alerta= new alertaSuave();
    // Analizar opcion de abajo, o alguna forma de que el primer sonido sea instantaneo
    //Thread thread = new Thread(new AlertaSuave());
    
    /**
     * Creates new form AltaCompetencia
     */
    public AltaCompetencia() {
        initComponents();
    }
    
    //private Vector< Vector<Object> > tabla;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        DeporteAsociado = new javax.swing.JComboBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        nombreComp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox();
        ACEPTAR = new javax.swing.JButton();
        ATRAS = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        ATRAS1 = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jSpinner2b = new javax.swing.JSpinner();
        jSpinner3 = new javax.swing.JSpinner();
        jSpinner4 = new javax.swing.JSpinner();
        jSpinner5 = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(null);

        tablaDisp=new TablaDisponibilidad();
        jPanel1.add(tablaDisp);
        jPanel1.setToolTipText("");
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 260));
        add(jPanel1);
        jPanel1.setBounds(50, 230, 300, 270);
        revalidate();
        repaint();

        jLabel7.setText("Puntos por presentarse:");
        add(jLabel7);
        jLabel7.setBounds(500, 270, 160, 14);
        jLabel7.setVisible(true);

        jLabel2.setText("NOMBRE DE COMPETENCIA");
        add(jLabel2);
        jLabel2.setBounds(40, 80, 180, 14);

        // String[] cadena2= new String[] { "Puntuacion", "Sets", "Resultado Final" };
        String[] cadena2 = gestor.gestorCD.getListaPuntuaciones();
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(cadena2));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        add(jComboBox1);
        jComboBox1.setBounds(500, 130, 190, 20);

        // String[] cadena= new String[] { "Liga", "Eliminacion Simple", "Eliminacion Doble" };
        String[] cadena = gestor.gestorCD.getListaModalidades();
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(cadena));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        add(jComboBox2);
        jComboBox2.setBounds(500, 170, 190, 20);

        String[] listaNombresDeportes = gestor.gestorCD.getListaDeportes();
        DeporteAsociado.setModel(new javax.swing.DefaultComboBoxModel(listaNombresDeportes));
        add(DeporteAsociado);
        DeporteAsociado.setBounds(50, 130, 138, 20);

        jCheckBox1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox1StateChanged(evt);
            }
        });
        add(jCheckBox1);
        jCheckBox1.setBounds(680, 300, 20, 20);
        jCheckBox1.setVisible(true);

        nombreComp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nombreCompFocusGained(evt);
            }
        });
        add(nombreComp);
        nombreComp.setBounds(50, 100, 220, 20);
        nombreComp.addKeyListener(new KeyAdapter() {

            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                    e.setKeyChar(Character.toUpperCase(keyChar));
                }
            }

        });

        jLabel3.setText("Lugar:");
        add(jLabel3);
        jLabel3.setBounds(50, 160, 50, 14);

        jLabel4.setText("Cant:");
        add(jLabel4);
        jLabel4.setBounds(200, 160, 30, 14);

        jButton1.setText("LISTAR PARTICPANTE DE COMPETENCIA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(305, 508, 231, 23);

        String[] cadena3l = gestor.gestorCD.getListaLugares();
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(cadena3l));
        jComboBox3.setMinimumSize(new java.awt.Dimension(64, 20));
        add(jComboBox3);
        jComboBox3.setBounds(52, 180, 140, 20);

        ACEPTAR.setText("DAR DE ALTA");
        ACEPTAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ACEPTARActionPerformed(evt);
            }
        });
        add(ACEPTAR);
        ACEPTAR.setBounds(554, 508, 114, 23);

        ATRAS.setText("ATRAS");
        ATRAS.setMaximumSize(new java.awt.Dimension(73, 23));
        ATRAS.setMinimumSize(new java.awt.Dimension(73, 23));
        ATRAS.setPreferredSize(new java.awt.Dimension(73, 23));
        ATRAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ATRASActionPerformed(evt);
            }
        });
        add(ATRAS);
        ATRAS.setBounds(170, 508, 90, 23);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Dar de Alta Competencia Deportiva");
        add(jLabel1);
        jLabel1.setBounds(220, 10, 350, 50);

        jLabel5.setText("Reglamento (opcional):");
        add(jLabel5);
        jLabel5.setBounds(370, 350, 150, 14);

        jLabel8.setText("Puntos por empate:");
        add(jLabel8);
        jLabel8.setBounds(500, 330, 150, 14);
        jLabel8.setVisible(false);

        jLabel9.setText("Puntos por partidos ganados:");
        jLabel9.setOpaque(true);
        add(jLabel9);
        jLabel9.setBounds(500, 240, 160, 14);
        jLabel9.setVisible(true);

        jLabel10.setText("Permite empate?");
        add(jLabel10);
        jLabel10.setBounds(500, 300, 130, 14);
        jLabel10.setVisible(true);

        jLabel11.setText("Cantidad de sets:");
        add(jLabel11);
        jLabel11.setBounds(500, 210, 160, 14);
        jLabel11.setVisible(true);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(6);
        jScrollPane2.setViewportView(jTextArea1);

        add(jScrollPane2);
        jScrollPane2.setBounds(370, 370, 340, 114);

        jButton3.setText("Agregar");
        jButton3.setToolTipText("Agregar disponibilidad");
        jButton3.setMaximumSize(new java.awt.Dimension(64, 20));
        jButton3.setMinimumSize(new java.awt.Dimension(64, 20));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(280, 180, 70, 23);

        ATRAS1.setText("MENU P.");
        ATRAS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ATRAS1ActionPerformed(evt);
            }
        });
        add(ATRAS1);
        ATRAS1.setBounds(69, 508, 90, 23);

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinner1.setMaximumSize(new java.awt.Dimension(29, 20));
        add(jSpinner1);
        jSpinner1.setBounds(200, 180, 70, 20);

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(1, 1, 9, 2));
        jSpinner2.setEditor(new javax.swing.JSpinner.NumberEditor(jSpinner2, ""));
        ((NumberEditor)jSpinner2.getEditor()).getTextField().setEditable(false);
        jSpinner2.setMinimumSize(new java.awt.Dimension(47, 20));
        jSpinner2.setPreferredSize(new java.awt.Dimension(47, 20));
        add(jSpinner2);
        jSpinner2.setBounds(670, 210, 47, 20);
        jSpinner2.setVisible(true);

        jSpinner2b.setModel(new javax.swing.SpinnerNumberModel(0, 0, 999, 1));
        add(jSpinner2b);
        jSpinner2b.setBounds(670, 210, 47, 20);
        jSpinner2b.setVisible(false);

        jSpinner3.setModel(new javax.swing.SpinnerNumberModel(3, 1, 999, 1));
        jSpinner3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner3StateChanged(evt);
            }
        });
        add(jSpinner3);
        jSpinner3.setBounds(670, 240, 47, 20);
        jSpinner3.setVisible(true);

        jSpinner4.setModel(new javax.swing.SpinnerNumberModel(0, 0, 998, 1));
        jSpinner4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner4StateChanged(evt);
            }
        });
        add(jSpinner4);
        jSpinner4.setBounds(670, 270, 47, 20);
        jSpinner4.setVisible(true);

        jSpinner5.setModel(new javax.swing.SpinnerNumberModel(1, 0, 999, 1));
        jSpinner5.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner5StateChanged(evt);
            }
        });
        add(jSpinner5);
        jSpinner5.setBounds(670, 330, 47, 20);
        jSpinner5.setVisible(false);

        jLabel12.setText("* Nombre ya existente");
        jLabel12.setVisible(false);
        add(jLabel12);
        jLabel12.setBounds(280, 100, 140, 20);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/img_general.jpg"))); // NOI18N
        add(jLabel6);
        jLabel6.setBounds(0, 0, 800, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ACEPTARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ACEPTARActionPerformed
        // Verificar todos los campos
        
        // Verificar Nombre de la competencia
        if(verificarNombreCompetencia()){
            jLabel12.setVisible(true);
            nombreComp.setBackground(new Color(0xFF, 0x80, 0x80));
            Thread thread = new Thread(alerta);
            thread.start();
        }
        else{
            //Llamada al Gestor
            String nombreCompetencia = nombreComp.getText().toString();
            String reglamento = jTextArea1.getText().toString();
            String deporte = DeporteAsociado.getSelectedItem().toString();
            String modalidad = jComboBox2.getSelectedItem().toString();
            // TODO: falta ver lo de levantar los datos de la tabla y ponerlos en matrizlugares
            String matriz[][] = tablaDisponibilidades();
            String puntuacion = jComboBox1.getSelectedItem().toString();
            int j2 = (int) jSpinner2.getValue();
            int j2b = (int) jSpinner2b.getValue();
            int j4 = (int) jSpinner4.getValue();
            int j3 = (int) jSpinner3.getValue();
            boolean j5c = jCheckBox1.isSelected();
            int j5a = (int) jSpinner5.getValue();
            
            gestor.gestorCD.darDeAltaCD(nombreCompetencia, reglamento, deporte, modalidad, matriz, puntuacion, j2, j2b, j3 , j4, j5c, j5a);
            JOptionPane.showMessageDialog(null, "Competencia creada exitosamente", "", JOptionPane.INFORMATION_MESSAGE);
            V.get().listarCDVolver();
        }
    }//GEN-LAST:event_ACEPTARActionPerformed

    private void ATRASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ATRASActionPerformed
        V.get().listarCDVolver();
    }//GEN-LAST:event_ATRASActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        if(null != (String)jComboBox1.getSelectedItem())
            switch ((String)jComboBox1.getSelectedItem()) {
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
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jCheckBox1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox1StateChanged
        if(jCheckBox1.isSelected()){
            jLabel8.setVisible(true);
            jSpinner5.setVisible(true);
        }
        else {
            jLabel8.setVisible(false);
            jSpinner5.setVisible(false);
        }
    }//GEN-LAST:event_jCheckBox1StateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int a= (int)jSpinner1.getValue();
        if (a>0 ){
            agregarATabla((String)jComboBox3.getSelectedItem(),a);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jSpinner3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner3StateChanged
        int value = (int)jSpinner3.getValue();
        
        if(value <= (int)jSpinner4.getValue())
            jSpinner4.setValue(value-1);
        if(value < (int)jSpinner5.getValue())
            jSpinner5.setValue(value);
        
    }//GEN-LAST:event_jSpinner3StateChanged

    private void jSpinner4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner4StateChanged
        int value = (int)jSpinner4.getValue();
        
        if(value>=(int)jSpinner3.getValue()){
            jSpinner3.setValue(value+1);
        }
    }//GEN-LAST:event_jSpinner4StateChanged

    private void jSpinner5StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner5StateChanged
        int value = (int)jSpinner5.getValue();
        
        if(value>(int)jSpinner3.getValue()){
            jSpinner3.setValue(value);
        }
    }//GEN-LAST:event_jSpinner5StateChanged

    private void ATRAS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ATRAS1ActionPerformed
        V.get().menuVolver();
    }//GEN-LAST:event_ATRAS1ActionPerformed

    private void nombreCompFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreCompFocusGained
        nombreComp.setBackground(Color.WHITE);
    }//GEN-LAST:event_nombreCompFocusGained

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        if("Liga".equals((String)jComboBox2.getSelectedItem())){modalidadLiga();}
        else modalidadEliminatoria();
    }//GEN-LAST:event_jComboBox2ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ACEPTAR;
    private javax.swing.JButton ATRAS;
    private javax.swing.JButton ATRAS1;
    private javax.swing.JComboBox DeporteAsociado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner2b;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JSpinner jSpinner5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField nombreComp;
    // End of variables declaration//GEN-END:variables
    
    
    //(Des)habilitacion de botones dependiendo de los comboBox
    
    //Habilitacion de campos para la modalidad de liga
    private void modalidadLiga(){
        jSpinner3.setVisible(true);
        jSpinner4.setVisible(true);
        jCheckBox1.setVisible(true);
        jLabel7.setVisible(true);
        jLabel9.setVisible(true);
        jLabel10.setVisible(true);
        verEmpate();
    }
    
    //Habilitacion de campos para modalidad de eliminatorias
    private void modalidadEliminatoria(){
        jSpinner3.setVisible(false);
        jSpinner4.setVisible(false);
        jSpinner5.setVisible(false);
        jCheckBox1.setVisible(false);
        jLabel7.setVisible(false);
        jLabel8.setVisible(false);
        jLabel9.setVisible(false);
        jLabel10.setVisible(false);
    }
    
    //Habilitacion de campos para forma de puntuacion, puntuacion
    private void formaPPuntuacion(){
        jLabel11.setVisible(true);
        jSpinner2b.setVisible(true);
        jSpinner2.setVisible(false);
        jLabel11.setText("Tantos por no presentarse");
        repaint();
    }
    //Habilitacion de campos para forma de puntuacion, sets
    private void formaPSets(){
        jLabel11.setVisible(true);
        jSpinner2.setVisible(true);
        jSpinner2b.setVisible(false);
        jLabel11.setText("Cant. max. de sets");
        repaint();
    }
    //Habilitacion de campos para forma de puntuacion, Resultado final
    private void formaPResultadoFinal(){
        jLabel11.setVisible(false);
        jSpinner2b.setVisible(false);
        jSpinner2.setVisible(false);
        repaint();
    }
    
    //Verificacion del campo para ingresar tantos por empate
    private void verEmpate(){
        verCheckBoxEmpate();
    }
    // Habilitacion/deshabilitacion de los campos de empate
    private void verCheckBoxEmpate(){
        if(jCheckBox1.isSelected()){
            jLabel8.setVisible(true);
            jSpinner5.setVisible(true);
        }
        else {
            jLabel8.setVisible(false);
            jSpinner5.setVisible(false);
        }
    }
    
    
    private void agregarATabla(String lugar, int cantidad){
        tablaDisp.addFila(lugar, cantidad);
    }
    
    
    // Nombre de la competencia
    private boolean verificarNombreCompetencia(){
        
        String aux = nombreComp.getText();
        
        // ELimina espacios al inicio y final
        aux = aux.trim();
        nombreComp.setText(aux);
        
        if(aux.length() == 0 ){
            // El usuario no ingreso nombre de Competencia.
            jLabel12.setText("* Ingrese un nombre");
            return true;
        }
        else if (gestor.gestorCD.verificarNombre(aux)){
            // Nombre de competencia ya existe.
            jLabel12.setText("* Nombre ya existente");
            return true;
            }
        else return false;
    }
    
    private String[][] tablaDisponibilidades(){
        //Sacar de la tabla las dipsonibilidades establecidas
        String[][] nuevo;
        nuevo=tablaDisp.getContenido();
        
        /*--FUNCIONA--
        System.out.println(nuevo.length);
        System.out.println(nuevo[0].length);*/
        
        return nuevo;
    }
    
    
}
