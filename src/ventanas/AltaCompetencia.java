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

        jLabelNombreCompetencia = new javax.swing.JLabel();
        jTextFieldNombreCompetencia = new javax.swing.JTextField();
        jLabelErrorNombre = new javax.swing.JLabel();
        jComboBoxDeporte = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jTextAreaErrorDisponib = new javax.swing.JTextArea();
        jLabelLugar = new javax.swing.JLabel();
        jComboBoxLugares = new javax.swing.JComboBox();
        jLabelCantidad = new javax.swing.JLabel();
        jSpinnerCantidad = new javax.swing.JSpinner();
        jButtonAgregarDisponibilidad = new javax.swing.JButton();
        jComboBoxPuntuacion = new javax.swing.JComboBox();
        jComboBoxModalidad = new javax.swing.JComboBox();
        jLabelFormaPuntuacion = new javax.swing.JLabel();
        jSpinnerSets = new javax.swing.JSpinner();
        jSpinnerPuntuacion = new javax.swing.JSpinner();
        jLabelPtosGanado = new javax.swing.JLabel();
        jSpinnerPtosGanado = new javax.swing.JSpinner();
        jLabelPtosPresentarse = new javax.swing.JLabel();
        jSpinnerPtosPresentarse = new javax.swing.JSpinner();
        jLabelEmpate = new javax.swing.JLabel();
        jCheckBoxEmpate = new javax.swing.JCheckBox();
        jLabelPtosEmpate = new javax.swing.JLabel();
        jSpinnerPtosEmpate = new javax.swing.JSpinner();
        jLabelReglamento = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButtonAlta = new javax.swing.JButton();
        jButtonMenu = new javax.swing.JButton();
        jButtonAtras = new javax.swing.JButton();
        jButtonListarParticipantes = new javax.swing.JButton();
        jButtonIntegrantes = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(null);

        jLabelNombreCompetencia.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabelNombreCompetencia.setText("NOMBRE DE COMPETENCIA:");
        add(jLabelNombreCompetencia);
        jLabelNombreCompetencia.setBounds(40, 70, 180, 22);

        jTextFieldNombreCompetencia.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jTextFieldNombreCompetencia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNombreCompetenciaFocusGained(evt);
            }
        });
        add(jTextFieldNombreCompetencia);
        jTextFieldNombreCompetencia.setBounds(50, 100, 220, 28);
        jTextFieldNombreCompetencia.addKeyListener(new KeyAdapter() {

            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                    e.setKeyChar(Character.toUpperCase(keyChar));
                }
            }

        });

        jLabelErrorNombre.setText("* Nombre ya existente");
        jLabelErrorNombre.setVisible(false);
        add(jLabelErrorNombre);
        jLabelErrorNombre.setBounds(280, 100, 140, 20);

        String[] listaNombresDeportes = gestor.gestorCD.getListaDeportes();
        jComboBoxDeporte.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jComboBoxDeporte.setModel(new javax.swing.DefaultComboBoxModel(listaNombresDeportes));
        jComboBoxDeporte.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxDeporteItemStateChanged(evt);
            }
        });
        add(jComboBoxDeporte);
        jComboBoxDeporte.setBounds(50, 130, 138, 28);

        tablaDisp=new TablaDisponibilidad();
        jPanel1.add(tablaDisp);
        jPanel1.setToolTipText("");
        jPanel1.setFocusable(false);
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 260));
        add(jPanel1);
        jPanel1.setBounds(50, 230, 300, 270);
        revalidate();
        repaint();

        jTextAreaErrorDisponib.setEditable(false);
        jTextAreaErrorDisponib.setBackground(new Color(255,0,0,100));
        jTextAreaErrorDisponib.setColumns(10);
        jTextAreaErrorDisponib.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextAreaErrorDisponib.setForeground(new java.awt.Color(225, 0, 0));
        jTextAreaErrorDisponib.setText("* Debe asignar una\n   disponibilidad");
        jTextAreaErrorDisponib.setToolTipText("");
        jTextAreaErrorDisponib.setAutoscrolls(false);
        jTextAreaErrorDisponib.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextAreaErrorDisponib.setFocusable(false);
        jTextAreaErrorDisponib.setOpaque(false);
        jTextAreaErrorDisponib.setVisible(false);
        add(jTextAreaErrorDisponib);
        jTextAreaErrorDisponib.setBounds(358, 240, 110, 34);

        jLabelLugar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabelLugar.setText("Lugar:");
        add(jLabelLugar);
        jLabelLugar.setBounds(50, 160, 50, 30);

        String[] cadena3l = gestor.gestorCD.getListaLugares(jComboBoxDeporte.getSelectedItem().toString());
        jComboBoxLugares.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jComboBoxLugares.setModel(new javax.swing.DefaultComboBoxModel(cadena3l));
        jComboBoxLugares.setMinimumSize(new java.awt.Dimension(64, 20));
        add(jComboBoxLugares);
        jComboBoxLugares.setBounds(50, 190, 140, 30);

        jLabelCantidad.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabelCantidad.setText("Cant:");
        add(jLabelCantidad);
        jLabelCantidad.setBounds(200, 170, 30, 22);

        jSpinnerCantidad.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jSpinnerCantidad.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinnerCantidad.setMaximumSize(new java.awt.Dimension(29, 20));
        add(jSpinnerCantidad);
        jSpinnerCantidad.setBounds(200, 190, 50, 30);

        jButtonAgregarDisponibilidad.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jButtonAgregarDisponibilidad.setText("Agregar");
        jButtonAgregarDisponibilidad.setToolTipText("Agregar disponibilidad");
        jButtonAgregarDisponibilidad.setMaximumSize(new java.awt.Dimension(64, 20));
        jButtonAgregarDisponibilidad.setMinimumSize(new java.awt.Dimension(64, 20));
        jButtonAgregarDisponibilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarDisponibilidadActionPerformed(evt);
            }
        });
        add(jButtonAgregarDisponibilidad);
        jButtonAgregarDisponibilidad.setBounds(260, 190, 80, 31);

        // String[] cadena2= new String[] { "Puntuacion", "Sets", "Resultado Final" };
        String[] cadena2 = gestor.gestorCD.getListaPuntuaciones();
        jComboBoxPuntuacion.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jComboBoxPuntuacion.setModel(new javax.swing.DefaultComboBoxModel(cadena2));
        jComboBoxPuntuacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxPuntuacionItemStateChanged(evt);
            }
        });
        add(jComboBoxPuntuacion);
        jComboBoxPuntuacion.setBounds(500, 130, 190, 28);

        // String[] cadena= new String[] { "Liga", "Eliminacion Simple", "Eliminacion Doble" };
        String[] cadena = gestor.gestorCD.getListaModalidades();
        jComboBoxModalidad.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jComboBoxModalidad.setModel(new javax.swing.DefaultComboBoxModel(cadena));
        jComboBoxModalidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxModalidadItemStateChanged(evt);
            }
        });
        add(jComboBoxModalidad);
        jComboBoxModalidad.setBounds(500, 170, 190, 28);

        jLabelFormaPuntuacion.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabelFormaPuntuacion.setText("Cantidad de sets:");
        add(jLabelFormaPuntuacion);
        jLabelFormaPuntuacion.setBounds(500, 210, 160, 22);
        jLabelFormaPuntuacion.setVisible(true);

        jSpinnerSets.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jSpinnerSets.setModel(new javax.swing.SpinnerNumberModel(1, 1, 9, 2));
        jSpinnerSets.setEditor(new javax.swing.JSpinner.NumberEditor(jSpinnerSets, ""));
        ((NumberEditor)jSpinnerSets.getEditor()).getTextField().setEditable(false);
        jSpinnerSets.setMinimumSize(new java.awt.Dimension(50, 24));
        jSpinnerSets.setPreferredSize(new java.awt.Dimension(50, 24));
        add(jSpinnerSets);
        jSpinnerSets.setBounds(670, 210, 50, 24);
        jSpinnerSets.setVisible(true);

        jSpinnerPuntuacion.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jSpinnerPuntuacion.setModel(new javax.swing.SpinnerNumberModel(0, 0, 999, 1));
        add(jSpinnerPuntuacion);
        jSpinnerPuntuacion.setBounds(670, 210, 50, 24);
        jSpinnerPuntuacion.setVisible(false);

        jLabelPtosGanado.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabelPtosGanado.setText("Puntos por partidos ganados:");
        add(jLabelPtosGanado);
        jLabelPtosGanado.setBounds(500, 238, 160, 22);
        jLabelPtosGanado.setVisible(true);

        jSpinnerPtosGanado.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jSpinnerPtosGanado.setModel(new javax.swing.SpinnerNumberModel(3, 1, 999, 1));
        jSpinnerPtosGanado.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerPtosGanadoStateChanged(evt);
            }
        });
        add(jSpinnerPtosGanado);
        jSpinnerPtosGanado.setBounds(670, 240, 50, 24);
        jSpinnerPtosGanado.setVisible(true);

        jLabelPtosPresentarse.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabelPtosPresentarse.setText("Puntos por presentarse:");
        add(jLabelPtosPresentarse);
        jLabelPtosPresentarse.setBounds(500, 270, 160, 20);
        jLabelPtosPresentarse.setVisible(true);

        jSpinnerPtosPresentarse.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jSpinnerPtosPresentarse.setModel(new javax.swing.SpinnerNumberModel(0, 0, 998, 1));
        jSpinnerPtosPresentarse.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerPtosPresentarseStateChanged(evt);
            }
        });
        add(jSpinnerPtosPresentarse);
        jSpinnerPtosPresentarse.setBounds(670, 270, 50, 24);
        jSpinnerPtosPresentarse.setVisible(true);

        jLabelEmpate.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabelEmpate.setText("Permite empate?");
        add(jLabelEmpate);
        jLabelEmpate.setBounds(500, 300, 130, 22);
        jLabelEmpate.setVisible(true);

        jCheckBoxEmpate.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBoxEmpateStateChanged(evt);
            }
        });
        add(jCheckBoxEmpate);
        jCheckBoxEmpate.setBounds(680, 300, 20, 20);
        jCheckBoxEmpate.setVisible(true);

        jLabelPtosEmpate.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabelPtosEmpate.setText("Puntos por empate:");
        add(jLabelPtosEmpate);
        jLabelPtosEmpate.setBounds(500, 330, 150, 22);
        jLabelPtosEmpate.setVisible(false);

        jSpinnerPtosEmpate.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jSpinnerPtosEmpate.setModel(new javax.swing.SpinnerNumberModel(1, 0, 999, 1));
        jSpinnerPtosEmpate.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerPtosEmpateStateChanged(evt);
            }
        });
        add(jSpinnerPtosEmpate);
        jSpinnerPtosEmpate.setBounds(670, 330, 50, 24);
        jSpinnerPtosEmpate.setVisible(false);

        jLabelReglamento.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabelReglamento.setText("Reglamento (opcional):");
        add(jLabelReglamento);
        jLabelReglamento.setBounds(370, 350, 150, 22);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(6);
        jScrollPane2.setViewportView(jTextArea1);

        add(jScrollPane2);
        jScrollPane2.setBounds(370, 370, 340, 114);

        jButtonAlta.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jButtonAlta.setText("Dar de Alta Competencia Deportiva");
        jButtonAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAltaActionPerformed(evt);
            }
        });
        add(jButtonAlta);
        jButtonAlta.setBounds(505, 508, 220, 31);

        jButtonMenu.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jButtonMenu.setText("Menu P.");
        jButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuActionPerformed(evt);
            }
        });
        add(jButtonMenu);
        jButtonMenu.setBounds(69, 508, 90, 31);

        jButtonAtras.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jButtonAtras.setText("Atras");
        jButtonAtras.setMaximumSize(new java.awt.Dimension(73, 23));
        jButtonAtras.setMinimumSize(new java.awt.Dimension(73, 23));
        jButtonAtras.setPreferredSize(new java.awt.Dimension(73, 23));
        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrasActionPerformed(evt);
            }
        });
        add(jButtonAtras);
        jButtonAtras.setBounds(170, 508, 90, 30);

        jButtonListarParticipantes.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jButtonListarParticipantes.setText("Listar Participante de Competencia");
        jButtonListarParticipantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListarParticipantesActionPerformed(evt);
            }
        });
        add(jButtonListarParticipantes);
        jButtonListarParticipantes.setBounds(274, 508, 209, 31);

        jButtonIntegrantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sports logo released.png"))); // NOI18N
        jButtonIntegrantes.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sports logo pressed.png")));
        jButtonIntegrantes.setBorder(null);
        jButtonIntegrantes.setBorderPainted(false);
        jButtonIntegrantes.setContentAreaFilled(false);
        jButtonIntegrantes.setFocusPainted(false);
        jButtonIntegrantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIntegrantesActionPerformed(evt);
            }
        });
        add(jButtonIntegrantes);
        jButtonIntegrantes.setBounds(663, 543, 130, 50);

        jLabelTitulo.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Dar de Alta Competencia Deportiva");
        jLabelTitulo.setToolTipText("");
        add(jLabelTitulo);
        jLabelTitulo.setBounds(0, 0, 800, 60);

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/img_general.jpg"))); // NOI18N
        add(jLabelFondo);
        jLabelFondo.setBounds(0, 0, 800, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonListarParticipantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListarParticipantesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonListarParticipantesActionPerformed

    private void jButtonAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAltaActionPerformed
        // Verificar todos los campos
        
        // Verificar Nombre de la competencia
        boolean nomb, disp;
        nomb = verificarNombreCompetencia();
        disp = verificarDisponibilidades();
        if(nomb || disp){
            Thread thread = new Thread(alerta);
            thread.start();
        }
        else{
            // Se extraen todos los datos para pasar al gestor
            String nombreCompetencia = jTextFieldNombreCompetencia.getText().toString();
            String reglamento = jTextArea1.getText().toString();
            String deporte = jComboBoxDeporte.getSelectedItem().toString();
            String modalidad = jComboBoxModalidad.getSelectedItem().toString();
            String matriz[][] = tablaDisponibilidades();
            String puntuacion = jComboBoxPuntuacion.getSelectedItem().toString();
            int j2 = (int) jSpinnerSets.getValue();
            int j2b = (int) jSpinnerPuntuacion.getValue();
            int j4 = (int) jSpinnerPtosPresentarse.getValue();
            int j3 = (int) jSpinnerPtosGanado.getValue();
            boolean j5c = jCheckBoxEmpate.isSelected();
            int j5a = (int) jSpinnerPtosEmpate.getValue();
            
            gestor.gestorCD.darDeAltaCD(nombreCompetencia, reglamento, deporte, modalidad, matriz, puntuacion, j2, j2b, j3 , j4, j5c, j5a);
            JOptionPane.showMessageDialog(null, "Competencia creada exitosamente", "", JOptionPane.INFORMATION_MESSAGE);
            
            V.get().remove(this);
            V.get().listarCompetenciasVolver();
        }
    }//GEN-LAST:event_jButtonAltaActionPerformed

    private void jButtonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtrasActionPerformed
        V.get().remove(this);
        V.get().listarCompetenciasVolver();
    }//GEN-LAST:event_jButtonAtrasActionPerformed

    private void jComboBoxPuntuacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxPuntuacionItemStateChanged
        if(null != (String)jComboBoxPuntuacion.getSelectedItem())
            switch ((String)jComboBoxPuntuacion.getSelectedItem()) {
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
    }//GEN-LAST:event_jComboBoxPuntuacionItemStateChanged

    private void jCheckBoxEmpateStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBoxEmpateStateChanged
        if(jCheckBoxEmpate.isSelected()){
            jLabelPtosEmpate.setVisible(true);
            jSpinnerPtosEmpate.setVisible(true);
        }
        else {
            jLabelPtosEmpate.setVisible(false);
            jSpinnerPtosEmpate.setVisible(false);
        }
    }//GEN-LAST:event_jCheckBoxEmpateStateChanged

    private void jButtonAgregarDisponibilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarDisponibilidadActionPerformed
        int a= (int)jSpinnerCantidad.getValue();
        if (a>0 ){
            agregarATabla((String)jComboBoxLugares.getSelectedItem(),a);
            jTextAreaErrorDisponib.setVisible(false);
        }
    }//GEN-LAST:event_jButtonAgregarDisponibilidadActionPerformed

    private void jSpinnerPtosGanadoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerPtosGanadoStateChanged
        int value = (int)jSpinnerPtosGanado.getValue();
        
        if(value <= (int)jSpinnerPtosPresentarse.getValue())
            jSpinnerPtosPresentarse.setValue(value-1);
        if(value < (int)jSpinnerPtosEmpate.getValue())
            jSpinnerPtosEmpate.setValue(value);
        
    }//GEN-LAST:event_jSpinnerPtosGanadoStateChanged

    private void jSpinnerPtosPresentarseStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerPtosPresentarseStateChanged
        int value = (int)jSpinnerPtosPresentarse.getValue();
        
        if(value>=(int)jSpinnerPtosGanado.getValue()){
            jSpinnerPtosGanado.setValue(value+1);
        }
    }//GEN-LAST:event_jSpinnerPtosPresentarseStateChanged

    private void jSpinnerPtosEmpateStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerPtosEmpateStateChanged
        int value = (int)jSpinnerPtosEmpate.getValue();
        
        if(value>(int)jSpinnerPtosGanado.getValue()){
            jSpinnerPtosGanado.setValue(value);
        }
    }//GEN-LAST:event_jSpinnerPtosEmpateStateChanged

    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuActionPerformed
        V.get().remove(this);
        V.get().listarCompetenciasSalir();
    }//GEN-LAST:event_jButtonMenuActionPerformed

    private void jTextFieldNombreCompetenciaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNombreCompetenciaFocusGained
        jTextFieldNombreCompetencia.setBackground(Color.WHITE);
    }//GEN-LAST:event_jTextFieldNombreCompetenciaFocusGained

    private void jComboBoxModalidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxModalidadItemStateChanged
        if("Liga".equals((String)jComboBoxModalidad.getSelectedItem())){modalidadLiga();}
        else modalidadEliminatoria();
    }//GEN-LAST:event_jComboBoxModalidadItemStateChanged

    private void jComboBoxDeporteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxDeporteItemStateChanged
        // Cambiar los lugares de realizacion
        String[] lugares = gestor.gestorCD.getListaLugares(jComboBoxDeporte.getSelectedItem().toString());
        jComboBoxLugares.setModel(new javax.swing.DefaultComboBoxModel(lugares));
        
        // Modificar la tabla si un lugar de realizacion deja de estar disponible
        tablaDisp.verificarLugares(lugares);
    }//GEN-LAST:event_jComboBoxDeporteItemStateChanged

    private void jButtonIntegrantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIntegrantesActionPerformed
        V.get().integrantes(this);
    }//GEN-LAST:event_jButtonIntegrantesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarDisponibilidad;
    private javax.swing.JButton jButtonAlta;
    private javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonIntegrantes;
    private javax.swing.JButton jButtonListarParticipantes;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JCheckBox jCheckBoxEmpate;
    private javax.swing.JComboBox jComboBoxDeporte;
    private javax.swing.JComboBox jComboBoxLugares;
    private javax.swing.JComboBox jComboBoxModalidad;
    private javax.swing.JComboBox jComboBoxPuntuacion;
    private javax.swing.JLabel jLabelCantidad;
    private javax.swing.JLabel jLabelEmpate;
    private javax.swing.JLabel jLabelErrorNombre;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelFormaPuntuacion;
    private javax.swing.JLabel jLabelLugar;
    private javax.swing.JLabel jLabelNombreCompetencia;
    private javax.swing.JLabel jLabelPtosEmpate;
    private javax.swing.JLabel jLabelPtosGanado;
    private javax.swing.JLabel jLabelPtosPresentarse;
    private javax.swing.JLabel jLabelReglamento;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinnerCantidad;
    private javax.swing.JSpinner jSpinnerPtosEmpate;
    private javax.swing.JSpinner jSpinnerPtosGanado;
    private javax.swing.JSpinner jSpinnerPtosPresentarse;
    private javax.swing.JSpinner jSpinnerPuntuacion;
    private javax.swing.JSpinner jSpinnerSets;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextAreaErrorDisponib;
    private javax.swing.JTextField jTextFieldNombreCompetencia;
    // End of variables declaration//GEN-END:variables
    
    
    //(Des)habilitacion de botones dependiendo de los comboBox
    
    //Habilitacion de campos para la modalidad de liga
    private void modalidadLiga(){
        jSpinnerPtosGanado.setVisible(true);
        jSpinnerPtosPresentarse.setVisible(true);
        jCheckBoxEmpate.setVisible(true);
        jLabelPtosPresentarse.setVisible(true);
        jLabelPtosGanado.setVisible(true);
        jLabelEmpate.setVisible(true);
        verEmpate();
    }
    
    //Habilitacion de campos para modalidad de eliminatorias
    private void modalidadEliminatoria(){
        jSpinnerPtosGanado.setVisible(false);
        jSpinnerPtosPresentarse.setVisible(false);
        jSpinnerPtosEmpate.setVisible(false);
        jCheckBoxEmpate.setVisible(false);
        jLabelPtosPresentarse.setVisible(false);
        jLabelPtosEmpate.setVisible(false);
        jLabelPtosGanado.setVisible(false);
        jLabelEmpate.setVisible(false);
    }
    
    //Habilitacion de campos para forma de puntuacion, puntuacion
    private void formaPPuntuacion(){
        jLabelFormaPuntuacion.setVisible(true);
        jSpinnerPuntuacion.setVisible(true);
        jSpinnerSets.setVisible(false);
        jLabelFormaPuntuacion.setText("Tantos por no presentarse");
        repaint();
    }
    //Habilitacion de campos para forma de puntuacion, sets
    private void formaPSets(){
        jLabelFormaPuntuacion.setVisible(true);
        jSpinnerSets.setVisible(true);
        jSpinnerPuntuacion.setVisible(false);
        jLabelFormaPuntuacion.setText("Cant. max. de sets");
        repaint();
    }
    //Habilitacion de campos para forma de puntuacion, Resultado final
    private void formaPResultadoFinal(){
        jLabelFormaPuntuacion.setVisible(false);
        jSpinnerPuntuacion.setVisible(false);
        jSpinnerSets.setVisible(false);
        repaint();
    }
    
    //Verificacion del campo para ingresar tantos por empate
    private void verEmpate(){
        verCheckBoxEmpate();
    }
    // Habilitacion/deshabilitacion de los campos de empate
    private void verCheckBoxEmpate(){
        if(jCheckBoxEmpate.isSelected()){
            jLabelPtosEmpate.setVisible(true);
            jSpinnerPtosEmpate.setVisible(true);
        }
        else {
            jLabelPtosEmpate.setVisible(false);
            jSpinnerPtosEmpate.setVisible(false);
        }
    }
    
    
    private void agregarATabla(String lugar, int cantidad){
        tablaDisp.addFila(lugar, cantidad);
    }
    
    
    // Nombre de la competencia
    private boolean verificarNombreCompetencia(){
        
        String aux = jTextFieldNombreCompetencia.getText();
        
        // ELimina espacios al inicio y final
        aux = aux.trim();
        jTextFieldNombreCompetencia.setText(aux);
        
        if(aux.length() == 0 ){
            // El usuario no ingreso nombre de Competencia.
            jLabelErrorNombre.setText("* Ingrese un nombre");
            jLabelErrorNombre.setVisible(true);
            jTextFieldNombreCompetencia.setBackground(new Color(0xFF, 0x80, 0x80));
            return true;
        }
        else if (gestor.gestorCD.verificarNombre(aux)){
            // Nombre de competencia ya existe.
            jLabelErrorNombre.setText("* Nombre ya existente");
            jLabelErrorNombre.setVisible(true);
            jTextFieldNombreCompetencia.setBackground(new Color(0xFF, 0x80, 0x80));
            return true;
            }
        else {
            jLabelErrorNombre.setVisible(false);
            return false;
        }
    }
    
    private boolean verificarDisponibilidades(){
        if(tablaDisp.tieneDisponibilidades()){
            jTextAreaErrorDisponib.setVisible(false);
            return false;
        }
        else{
            jTextAreaErrorDisponib.setVisible(true);
            return true;
        }
    }
    
    private String[][] tablaDisponibilidades(){
        //Sacar de la tabla las dipsonibilidades establecidas
        String[][] nuevo;
        nuevo=tablaDisp.getContenido();
        
        return nuevo;
    }
    
    
}
