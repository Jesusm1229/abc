/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author Jesus Gonzalez
 */
public class Dialogs extends javax.swing.JDialog {

    boolean state = false;
    /**
     * Creates new form Dialogs
     */
    public Dialogs() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setModal(true);
        setLocationRelativeTo(null);
        
    }

        
    public Dialogs(int window){
        initComponents();        
        setFalseEverything();
               
        setBackground(new Color(0, 0, 0, 0));
        setModal(true);
        setLocationRelativeTo(null);        
        
        switch (window) {
            case 1:
                setPanelEnabled(jPanelSalir, true);
                jPanelSalir.setVisible(true);
                break;
                
            case 2:
                setPanelEnabled(jPanelCancelarInscripcion, true);
                jPanelCancelarInscripcion.setVisible(true);
                break;
            case 3:
                setPanelEnabled(jPanelYaRegistrado, true);
                jPanelYaRegistrado.setVisible(true);
                break;
                
            case 4:
                setPanelEnabled(jPanelInfoCorrecto, true);
                jPanelInfoCorrecto.setVisible(true);
                break;
            case 5:
                setPanelEnabled(jPanelError, true);
                jPanelError.setVisible(true);
                break;
            case 6:
                setPanelEnabled(jPanelIncompleto, true);
                jPanelIncompleto.setVisible(true);
                break;
            case 7:
                setPanelEnabled(jPanelConCorrecto, true);
                jPanelConCorrecto.setVisible(true);
                break; 
            case 8:
                setPanelEnabled(jPanelRangoEdad, true);
                jPanelRangoEdad.setVisible(true);
                break;
            case 9:
                setPanelEnabled(jPanelInfoEmpleoCorrecto, true);
                jPanelInfoEmpleoCorrecto.setVisible(true);
                break; 
            case 10:
                setPanelEnabled(jPaneConcEmpleoCorrecto, true);
                jPaneConcEmpleoCorrecto.setVisible(true);
                break;
             case 11:
                setPanelEnabled(jPanelEmpleoYaRegistrado, true);
                jPanelEmpleoYaRegistrado.setVisible(true);
                break;
            case 12:
                setPanelEnabled(jPaneNoHayPostulantes, true);
                jPaneNoHayPostulantes.setVisible(true);
                break; 
            case 13:
                setPanelEnabled(jPaneNoHanSidoEvaluados, true);
                jPaneNoHanSidoEvaluados.setVisible(true);
                break;
            case 14:
                setPanelEnabled(jPanelYaHaSidoEvaluado, true);
                jPanelYaHaSidoEvaluado.setVisible(true);
                break;
            case 15:
                setPanelEnabled(jPanelDebeSeleccionar, true);
                jPanelDebeSeleccionar.setVisible(true);
                break;
            case 16:
                setPanelEnabled(jPanelRespuestaCorrecta, true);
                jPanelRespuestaCorrecta.setVisible(true);
                break; 
            case 17:
                setPanelEnabled(jPanelRespuestaIncorrecta, true);
                jPanelRespuestaIncorrecta.setVisible(true);
                break;
            case 18:
                setPanelEnabled(jPanelNoHasCalifiacado, true);
                jPanelNoHasCalifiacado.setVisible(true);
                break;
            case 19:
                setPanelEnabled(jPanelAgregado, true);
                jPanelAgregado.setVisible(true);
                break;
            case 20:
                setPanelEnabled(jPanelDebeTerminar, true);
                jPanelDebeTerminar.setVisible(true);
                break;    
              
            default:                
                throw new AssertionError();
        }
    
    }
    
    public Dialogs(String nombre, String apellido, long DNI, int edad, String sexo, String pais, String residencia, long telefono, String correo){
        initComponents();        
        setFalseEverything();
               
        setBackground(new Color(0, 0, 0, 0));
        setModal(true);
        setLocationRelativeTo(null); 
        
        jLabelNombre.setText(nombre);
        jLabelApellido.setText(apellido);
        jLabelDNI.setText(Long.toString(DNI));
        jLabelEdad.setText(Integer.toString(edad));
        jLabelSexo.setText(Character.toString(sexo.charAt(0)));
        jLabelOrigen.setText(pais);
        jLabelResidencia.setText(residencia);
        jLabelTelefono.setText(Long.toString(telefono));
        jLabelCorreo.setText(correo);
        
        setPanelEnabled(jPanelPostulante, true);
        jPanelPostulante.setVisible(true);
        
        
    }
    
    public Dialogs(String categoria, String puntaje, int window){
        initComponents();        
        setFalseEverything();
               
        setBackground(new Color(0, 0, 0, 0));
        setModal(true);
        setLocationRelativeTo(null); 
        
        switch(window){
         
        case 1:    
            jlabelCategoria.setText(categoria);
            jLabelPts.setText(puntaje);

            setPanelEnabled(jPanelHasSidoAsignado, true);
            jPanelHasSidoAsignado.setVisible(true);
            break;
        case 2:
            jlabelCategoria1.setText(categoria);
            jLabelPts1.setText(puntaje);
        
            setPanelEnabled(jPanelNOHasSidoAsignado, true);
            jPanelNOHasSidoAsignado.setVisible(true);
            break;
            
        default:                
                throw new AssertionError();
        
        }
        
    }
    
    public Dialogs(int back, int front, int devops, int uix, int qa){
        initComponents();        
        setFalseEverything();
               
        setBackground(new Color(0, 0, 0, 0));
        setModal(true);
        setLocationRelativeTo(null); 
        
        jLabelBackend.setText(Integer.toString(back)+ " %");
        jLabelfrontend.setText(Integer.toString(front)+ " %");
        jLabeldevops.setText(Integer.toString(devops)+ " %");
        jLabeluix.setText(Integer.toString(uix)+ " %");
        jLabelqa.setText(Integer.toString(qa)+ " %");
        
        jPanelGeneral.setVisible(true);
    }
    
    public void setFalseEverything(){
        jPanelSalir.setVisible(false);
        jPanelCancelarInscripcion.setVisible(false);
        jPanelYaRegistrado.setVisible(false);
        jPanelInfoCorrecto.setVisible(false);
        jPanelError.setVisible(false);
        jPanelIncompleto.setVisible(false);
        jPanelConCorrecto.setVisible(false);
        jPanelRangoEdad.setVisible(false);
        jPanelInfoEmpleoCorrecto.setVisible(false);
        jPaneConcEmpleoCorrecto.setVisible(false);
        jPanelEmpleoYaRegistrado.setVisible(false);
        jPaneNoHayPostulantes.setVisible(false);
        jPaneNoHanSidoEvaluados.setVisible(false);
        jPanelYaHaSidoEvaluado.setVisible(false);
        jPanelDebeSeleccionar.setVisible(false);
        jPanelRespuestaCorrecta.setVisible(false);
        jPanelRespuestaIncorrecta.setVisible(false);
        jPanelPostulante.setVisible(false);
        jPanelNoHasCalifiacado.setVisible(false);
        jPanelHasSidoAsignado.setVisible(false);
        jPanelNOHasSidoAsignado.setVisible(false);
        jPanelAgregado.setVisible(false);
        jPanelDebeTerminar.setVisible(false);
        jPanelGeneral.setVisible(false);
    
    }
    
    
    
        //Método recursivo para deshabilitar los paneles en frame anterior
    private void setPanelEnabled(JPanel panel, Boolean isEnabled) {
    panel.setEnabled(isEnabled);

    Component[] components = panel.getComponents();

    for (Component component : components) {
        if (component instanceof JPanel) {
            setPanelEnabled((JPanel) component, isEnabled);
        }
        component.setEnabled(isEnabled);
    }
}
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        jPanelSalir = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jButtonSalir = new javax.swing.JButton();
        jButtonContinuar = new javax.swing.JButton();
        jLabelBGExit = new javax.swing.JLabel();
        jPanelCancelarInscripcion = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jButtonSi = new javax.swing.JButton();
        jButtonNo = new javax.swing.JButton();
        jLabelBGCancel = new javax.swing.JLabel();
        jPanelYaRegistrado = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jButtonAceptar = new javax.swing.JButton();
        jLabelBGYaRegistrado = new javax.swing.JLabel();
        jPanelEmpleoYaRegistrado = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jButtonAceptar8 = new javax.swing.JButton();
        jLabelBGYaRegistrado1 = new javax.swing.JLabel();
        jPanelError = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jButtonAceptar2 = new javax.swing.JButton();
        jLabelBGERROR = new javax.swing.JLabel();
        jPanelIncompleto = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jButtonAceptar3 = new javax.swing.JButton();
        jLabelBGIncompleto = new javax.swing.JLabel();
        jPanelRangoEdad = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jButtonAceptar5 = new javax.swing.JButton();
        jLabelBGEdad = new javax.swing.JLabel();
        jPanelInfoCorrecto = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jButtonAceptar1 = new javax.swing.JButton();
        jLabelBGCorrecto = new javax.swing.JLabel();
        jPanelConCorrecto = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jButtonAceptar4 = new javax.swing.JButton();
        jLabelBGCorrecto1 = new javax.swing.JLabel();
        jPanelInfoEmpleoCorrecto = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jButtonAceptar7 = new javax.swing.JButton();
        jLabelBGCorrecto3 = new javax.swing.JLabel();
        jPaneConcEmpleoCorrecto = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jButtonAceptar6 = new javax.swing.JButton();
        jLabelBGCorrecto2 = new javax.swing.JLabel();
        jPaneNoHayPostulantes = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jButtonAceptar9 = new javax.swing.JButton();
        jLabelBGNoHay = new javax.swing.JLabel();
        jPaneNoHanSidoEvaluados = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jButtonAceptar10 = new javax.swing.JButton();
        jLabelBGNoHanSido = new javax.swing.JLabel();
        jPanelYaHaSidoEvaluado = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jButtonAceptar11 = new javax.swing.JButton();
        jLabelBGYaEvaluado = new javax.swing.JLabel();
        jPanelDebeSeleccionar = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jButtonAceptar12 = new javax.swing.JButton();
        jLabelBGDebe = new javax.swing.JLabel();
        jPanelRespuestaCorrecta = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jButtonAceptar13 = new javax.swing.JButton();
        jLabelBGCorrecto4 = new javax.swing.JLabel();
        jPanelRespuestaIncorrecta = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jButtonAceptar14 = new javax.swing.JButton();
        jLabelBGCorrecto5 = new javax.swing.JLabel();
        jPanelNoHasCalifiacado = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jButtonAceptar16 = new javax.swing.JButton();
        jLabelBGNoHasCalificado = new javax.swing.JLabel();
        jPanelPostulante = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanelNombreDNI = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelApellido = new javax.swing.JLabel();
        jLabelDNI = new javax.swing.JLabel();
        jPanelEdad = new javax.swing.JPanel();
        jLabelEdad = new javax.swing.JLabel();
        jPanelSexo = new javax.swing.JPanel();
        jLabelSexo = new javax.swing.JLabel();
        jPanelResidencia = new javax.swing.JPanel();
        jLabelOrigen = new javax.swing.JLabel();
        jLabelResidencia = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanelTelCorreo = new javax.swing.JPanel();
        jLabelTelefono = new javax.swing.JLabel();
        jLabelCorreo = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jButtonAceptar15 = new javax.swing.JButton();
        jLabelBGCorrecto6 = new javax.swing.JLabel();
        jPanelAgregado = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jButtonAceptar19 = new javax.swing.JButton();
        jLabelBGCorrecto7 = new javax.swing.JLabel();
        jPanelGeneral = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanelbackend = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabelBackend = new javax.swing.JLabel();
        jPanelfrontend = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jLabelfrontend = new javax.swing.JLabel();
        jPaneldevops = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jLabeldevops = new javax.swing.JLabel();
        jPaneluix = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jLabeluix = new javax.swing.JLabel();
        jPanelqa = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jLabelqa = new javax.swing.JLabel();
        jButtonAceptar21 = new javax.swing.JButton();
        jLabelBGCorrecto8 = new javax.swing.JLabel();
        jPanelHasSidoAsignado = new javax.swing.JPanel();
        jLabelFelicitaciones = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabelPts = new javax.swing.JLabel();
        jlabelCategoria = new javax.swing.JLabel();
        jButtonAceptar17 = new javax.swing.JButton();
        jLabelBGDiploma = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabelBGHasSidoAsignado = new javax.swing.JLabel();
        jPanelNOHasSidoAsignado = new javax.swing.JPanel();
        jLabelLoSentimos = new javax.swing.JLabel();
        jLabelNoHasSido = new javax.swing.JLabel();
        jlabelCategoria1 = new javax.swing.JLabel();
        jLabelPts1 = new javax.swing.JLabel();
        jButtonAceptar18 = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jLabelBGHasSidoAsignado1 = new javax.swing.JLabel();
        jPanelDebeTerminar = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jButtonAceptar20 = new javax.swing.JButton();
        jLabelTerminar = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);

        jLayeredPane1.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.setAlignmentX(0.0F);
        jLayeredPane1.setAlignmentY(0.0F);
        jLayeredPane1.setPreferredSize(new java.awt.Dimension(420, 500));

        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelSalir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSalir.setEnabled(false);
        jPanelSalir.setOpaque(false);
        jPanelSalir.setPreferredSize(new java.awt.Dimension(400, 200));
        jPanelSalir.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("¿Desea salir de la aplicación?");
        jPanelSalir.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 290, 60));

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_exit_40px.png"))); // NOI18N
        jPanelSalir.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        jButtonSalir.setFont(new java.awt.Font("Dosis", 1, 24)); // NOI18N
        jButtonSalir.setForeground(new java.awt.Color(214, 35, 35));
        jButtonSalir.setText("SALIR");
        jButtonSalir.setBorder(null);
        jButtonSalir.setBorderPainted(false);
        jButtonSalir.setContentAreaFilled(false);
        jButtonSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSalir.setFocusPainted(false);
        jButtonSalir.setFocusable(false);
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        jPanelSalir.add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 80, 60));

        jButtonContinuar.setFont(new java.awt.Font("Dosis", 1, 24)); // NOI18N
        jButtonContinuar.setForeground(new java.awt.Color(0, 159, 137));
        jButtonContinuar.setText("CONTINUAR");
        jButtonContinuar.setBorder(null);
        jButtonContinuar.setBorderPainted(false);
        jButtonContinuar.setContentAreaFilled(false);
        jButtonContinuar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonContinuar.setFocusPainted(false);
        jButtonContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonContinuarActionPerformed(evt);
            }
        });
        jPanelSalir.add(jButtonContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 130, 40));

        jLabelBGExit.setForeground(new java.awt.Color(204, 204, 204));
        jLabelBGExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBGExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/whiteBackground.jpg"))); // NOI18N
        jLabelBGExit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanelSalir.add(jLabelBGExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 200));

        jPanel1.add(jPanelSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, -1, -1));

        jPanelCancelarInscripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelCancelarInscripcion.setEnabled(false);
        jPanelCancelarInscripcion.setOpaque(false);
        jPanelCancelarInscripcion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("¿Cancelar proceso de registro");
        jPanelCancelarInscripcion.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 300, 30));

        jLabel3.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("y volver al Menú Principal?");
        jPanelCancelarInscripcion.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 260, 30));

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_cancel_40px.png"))); // NOI18N
        jPanelCancelarInscripcion.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        jButtonSi.setFont(new java.awt.Font("Dosis", 1, 24)); // NOI18N
        jButtonSi.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSi.setText("Sí");
        jButtonSi.setBorder(null);
        jButtonSi.setBorderPainted(false);
        jButtonSi.setContentAreaFilled(false);
        jButtonSi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSi.setFocusPainted(false);
        jButtonSi.setFocusable(false);
        jButtonSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSiActionPerformed(evt);
            }
        });
        jPanelCancelarInscripcion.add(jButtonSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 60, 40));

        jButtonNo.setFont(new java.awt.Font("Dosis", 1, 24)); // NOI18N
        jButtonNo.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNo.setText("NO");
        jButtonNo.setBorder(null);
        jButtonNo.setBorderPainted(false);
        jButtonNo.setContentAreaFilled(false);
        jButtonNo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNo.setFocusPainted(false);
        jButtonNo.setFocusable(false);
        jButtonNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNoActionPerformed(evt);
            }
        });
        jPanelCancelarInscripcion.add(jButtonNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 60, 40));

        jLabelBGCancel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBGCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGred.jpg"))); // NOI18N
        jLabelBGCancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelCancelarInscripcion.add(jLabelBGCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 200));

        jPanel1.add(jPanelCancelarInscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, -1, -1));

        jPanelYaRegistrado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelYaRegistrado.setEnabled(false);
        jPanelYaRegistrado.setOpaque(false);
        jPanelYaRegistrado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("El postulante ya se encuentra");
        jPanelYaRegistrado.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 300, 30));

        jLabel5.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("registrado");
        jPanelYaRegistrado.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 110, 30));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_attention_40px.png"))); // NOI18N
        jPanelYaRegistrado.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        jButtonAceptar.setFont(new java.awt.Font("Dosis", 1, 24)); // NOI18N
        jButtonAceptar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAceptar.setText("ACEPTAR");
        jButtonAceptar.setBorder(null);
        jButtonAceptar.setBorderPainted(false);
        jButtonAceptar.setContentAreaFilled(false);
        jButtonAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptar.setFocusPainted(false);
        jButtonAceptar.setFocusable(false);
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });
        jPanelYaRegistrado.add(jButtonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 120, 30));

        jLabelBGYaRegistrado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBGYaRegistrado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGred3.jpg"))); // NOI18N
        jLabelBGYaRegistrado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelYaRegistrado.add(jLabelBGYaRegistrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 200));

        jPanel1.add(jPanelYaRegistrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, -1, -1));

        jPanelEmpleoYaRegistrado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelEmpleoYaRegistrado.setEnabled(false);
        jPanelEmpleoYaRegistrado.setOpaque(false);
        jPanelEmpleoYaRegistrado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("La oferta de  empleo ya se encuentra");
        jPanelEmpleoYaRegistrado.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 370, 30));

        jLabel18.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("registrada");
        jPanelEmpleoYaRegistrado.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 110, 30));

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_attention_40px.png"))); // NOI18N
        jPanelEmpleoYaRegistrado.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        jButtonAceptar8.setFont(new java.awt.Font("Dosis", 1, 24)); // NOI18N
        jButtonAceptar8.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAceptar8.setText("ACEPTAR");
        jButtonAceptar8.setBorder(null);
        jButtonAceptar8.setBorderPainted(false);
        jButtonAceptar8.setContentAreaFilled(false);
        jButtonAceptar8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptar8.setFocusPainted(false);
        jButtonAceptar8.setFocusable(false);
        jButtonAceptar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptar8ActionPerformed(evt);
            }
        });
        jPanelEmpleoYaRegistrado.add(jButtonAceptar8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 120, 30));

        jLabelBGYaRegistrado1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBGYaRegistrado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGred3.jpg"))); // NOI18N
        jLabelBGYaRegistrado1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelEmpleoYaRegistrado.add(jLabelBGYaRegistrado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 200));

        jPanel1.add(jPanelEmpleoYaRegistrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, -1, -1));

        jPanelError.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelError.setEnabled(false);
        jPanelError.setOpaque(false);
        jPanelError.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("HA OCURRIDO UN ERROR FATAL");
        jPanelError.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 320, 30));

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_error_40px.png"))); // NOI18N
        jPanelError.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        jButtonAceptar2.setFont(new java.awt.Font("Dosis", 1, 24)); // NOI18N
        jButtonAceptar2.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAceptar2.setText("ACEPTAR");
        jButtonAceptar2.setBorder(null);
        jButtonAceptar2.setBorderPainted(false);
        jButtonAceptar2.setContentAreaFilled(false);
        jButtonAceptar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptar2.setFocusPainted(false);
        jButtonAceptar2.setFocusable(false);
        jButtonAceptar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptar2ActionPerformed(evt);
            }
        });
        jPanelError.add(jButtonAceptar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 120, 30));

        jLabelBGERROR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBGERROR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGred2.jpg"))); // NOI18N
        jLabelBGERROR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelError.add(jLabelBGERROR, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 200));

        jPanel1.add(jPanelError, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 400, 200));

        jPanelIncompleto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelIncompleto.setEnabled(false);
        jPanelIncompleto.setOpaque(false);
        jPanelIncompleto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Complete todos los campos");
        jPanelIncompleto.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 270, 30));

        jLabel51.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Por favor,");
        jPanelIncompleto.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 100, 30));

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_brake_warning_40px.png"))); // NOI18N
        jPanelIncompleto.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        jButtonAceptar3.setFont(new java.awt.Font("Dosis", 1, 24)); // NOI18N
        jButtonAceptar3.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAceptar3.setText("ACEPTAR");
        jButtonAceptar3.setBorder(null);
        jButtonAceptar3.setBorderPainted(false);
        jButtonAceptar3.setContentAreaFilled(false);
        jButtonAceptar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptar3.setFocusPainted(false);
        jButtonAceptar3.setFocusable(false);
        jButtonAceptar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptar3ActionPerformed(evt);
            }
        });
        jPanelIncompleto.add(jButtonAceptar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 120, 30));

        jLabelBGIncompleto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBGIncompleto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGred4.jpg"))); // NOI18N
        jLabelBGIncompleto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelIncompleto.add(jLabelBGIncompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 200));

        jPanel1.add(jPanelIncompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 400, 200));

        jPanelRangoEdad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRangoEdad.setEnabled(false);
        jPanelRangoEdad.setOpaque(false);
        jPanelRangoEdad.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Inconsistencia en rango de fechas");
        jPanelRangoEdad.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 330, 30));

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_brake_warning_40px.png"))); // NOI18N
        jPanelRangoEdad.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        jButtonAceptar5.setFont(new java.awt.Font("Dosis", 1, 24)); // NOI18N
        jButtonAceptar5.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAceptar5.setText("ACEPTAR");
        jButtonAceptar5.setBorder(null);
        jButtonAceptar5.setBorderPainted(false);
        jButtonAceptar5.setContentAreaFilled(false);
        jButtonAceptar5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptar5.setFocusPainted(false);
        jButtonAceptar5.setFocusable(false);
        jButtonAceptar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptar5ActionPerformed(evt);
            }
        });
        jPanelRangoEdad.add(jButtonAceptar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 120, 30));

        jLabelBGEdad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBGEdad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGred4.jpg"))); // NOI18N
        jLabelBGEdad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRangoEdad.add(jLabelBGEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 200));

        jPanel1.add(jPanelRangoEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 400, 200));

        jPanelInfoCorrecto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelInfoCorrecto.setEnabled(false);
        jPanelInfoCorrecto.setOpaque(false);
        jPanelInfoCorrecto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Información personal del postulante");
        jPanelInfoCorrecto.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 360, 30));

        jLabel7.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("cargada correctamente");
        jPanelInfoCorrecto.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 230, 30));

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_good_quality_40px_1.png"))); // NOI18N
        jPanelInfoCorrecto.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        jButtonAceptar1.setFont(new java.awt.Font("Dosis", 1, 24)); // NOI18N
        jButtonAceptar1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAceptar1.setText("ACEPTAR");
        jButtonAceptar1.setBorder(null);
        jButtonAceptar1.setBorderPainted(false);
        jButtonAceptar1.setContentAreaFilled(false);
        jButtonAceptar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptar1.setFocusPainted(false);
        jButtonAceptar1.setFocusable(false);
        jButtonAceptar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptar1ActionPerformed(evt);
            }
        });
        jPanelInfoCorrecto.add(jButtonAceptar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 120, 30));

        jLabelBGCorrecto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBGCorrecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGblue2.jpg"))); // NOI18N
        jLabelBGCorrecto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelInfoCorrecto.add(jLabelBGCorrecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 200));

        jPanel1.add(jPanelInfoCorrecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 400, 200));

        jPanelConCorrecto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelConCorrecto.setEnabled(false);
        jPanelConCorrecto.setOpaque(false);
        jPanelConCorrecto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Conocimientos del postulante");
        jPanelConCorrecto.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 290, 30));

        jLabel11.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("cargados correctamente");
        jPanelConCorrecto.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 240, 30));

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_good_quality_40px_1.png"))); // NOI18N
        jPanelConCorrecto.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        jButtonAceptar4.setFont(new java.awt.Font("Dosis", 1, 24)); // NOI18N
        jButtonAceptar4.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAceptar4.setText("ACEPTAR");
        jButtonAceptar4.setBorder(null);
        jButtonAceptar4.setBorderPainted(false);
        jButtonAceptar4.setContentAreaFilled(false);
        jButtonAceptar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptar4.setFocusPainted(false);
        jButtonAceptar4.setFocusable(false);
        jButtonAceptar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptar4ActionPerformed(evt);
            }
        });
        jPanelConCorrecto.add(jButtonAceptar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 120, 30));

        jLabelBGCorrecto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBGCorrecto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGblue2.jpg"))); // NOI18N
        jLabelBGCorrecto1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelConCorrecto.add(jLabelBGCorrecto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 200));

        jPanel1.add(jPanelConCorrecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 400, 200));

        jPanelInfoEmpleoCorrecto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelInfoEmpleoCorrecto.setEnabled(false);
        jPanelInfoEmpleoCorrecto.setOpaque(false);
        jPanelInfoEmpleoCorrecto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Información del empleo");
        jPanelInfoEmpleoCorrecto.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 240, 30));

        jLabel16.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("cargada correctamente");
        jPanelInfoEmpleoCorrecto.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 230, 30));

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_good_quality_40px_1.png"))); // NOI18N
        jPanelInfoEmpleoCorrecto.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        jButtonAceptar7.setFont(new java.awt.Font("Dosis", 1, 24)); // NOI18N
        jButtonAceptar7.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAceptar7.setText("ACEPTAR");
        jButtonAceptar7.setBorder(null);
        jButtonAceptar7.setBorderPainted(false);
        jButtonAceptar7.setContentAreaFilled(false);
        jButtonAceptar7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptar7.setFocusPainted(false);
        jButtonAceptar7.setFocusable(false);
        jButtonAceptar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptar7ActionPerformed(evt);
            }
        });
        jPanelInfoEmpleoCorrecto.add(jButtonAceptar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 120, 30));

        jLabelBGCorrecto3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBGCorrecto3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGblue2.jpg"))); // NOI18N
        jLabelBGCorrecto3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelInfoEmpleoCorrecto.add(jLabelBGCorrecto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 200));

        jPanel1.add(jPanelInfoEmpleoCorrecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 400, 200));

        jPaneConcEmpleoCorrecto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPaneConcEmpleoCorrecto.setEnabled(false);
        jPaneConcEmpleoCorrecto.setOpaque(false);
        jPaneConcEmpleoCorrecto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Oferta de empleo cargada ");
        jPaneConcEmpleoCorrecto.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 270, 30));

        jLabel14.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("correctamente");
        jPaneConcEmpleoCorrecto.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 160, 30));

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_good_quality_40px_1.png"))); // NOI18N
        jPaneConcEmpleoCorrecto.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        jButtonAceptar6.setFont(new java.awt.Font("Dosis", 1, 24)); // NOI18N
        jButtonAceptar6.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAceptar6.setText("ACEPTAR");
        jButtonAceptar6.setBorder(null);
        jButtonAceptar6.setBorderPainted(false);
        jButtonAceptar6.setContentAreaFilled(false);
        jButtonAceptar6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptar6.setFocusPainted(false);
        jButtonAceptar6.setFocusable(false);
        jButtonAceptar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptar6ActionPerformed(evt);
            }
        });
        jPaneConcEmpleoCorrecto.add(jButtonAceptar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 120, 30));

        jLabelBGCorrecto2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBGCorrecto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGblue2.jpg"))); // NOI18N
        jLabelBGCorrecto2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPaneConcEmpleoCorrecto.add(jLabelBGCorrecto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 200));

        jPanel1.add(jPaneConcEmpleoCorrecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 400, 200));

        jPaneNoHayPostulantes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPaneNoHayPostulantes.setEnabled(false);
        jPaneNoHayPostulantes.setOpaque(false);
        jPaneNoHayPostulantes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("No hay postulantes registrados");
        jPaneNoHayPostulantes.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 300, 30));

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_attention_filled_40px.png"))); // NOI18N
        jPaneNoHayPostulantes.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        jButtonAceptar9.setFont(new java.awt.Font("Dosis", 1, 24)); // NOI18N
        jButtonAceptar9.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAceptar9.setText("ACEPTAR");
        jButtonAceptar9.setBorder(null);
        jButtonAceptar9.setBorderPainted(false);
        jButtonAceptar9.setContentAreaFilled(false);
        jButtonAceptar9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptar9.setFocusPainted(false);
        jButtonAceptar9.setFocusable(false);
        jButtonAceptar9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptar9ActionPerformed(evt);
            }
        });
        jPaneNoHayPostulantes.add(jButtonAceptar9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 120, 30));

        jLabelBGNoHay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBGNoHay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGYellow.jpg"))); // NOI18N
        jLabelBGNoHay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPaneNoHayPostulantes.add(jLabelBGNoHay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 200));

        jPanel1.add(jPaneNoHayPostulantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 400, 200));

        jPaneNoHanSidoEvaluados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPaneNoHanSidoEvaluados.setEnabled(false);
        jPaneNoHanSidoEvaluados.setOpaque(false);
        jPaneNoHanSidoEvaluados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("No han sido evaluados todos");
        jPaneNoHanSidoEvaluados.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 300, 30));

        jLabel21.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("los postulantes");
        jPaneNoHanSidoEvaluados.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 160, 30));

        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_attention_filled_40px.png"))); // NOI18N
        jPaneNoHanSidoEvaluados.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        jButtonAceptar10.setFont(new java.awt.Font("Dosis", 1, 24)); // NOI18N
        jButtonAceptar10.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAceptar10.setText("ACEPTAR");
        jButtonAceptar10.setBorder(null);
        jButtonAceptar10.setBorderPainted(false);
        jButtonAceptar10.setContentAreaFilled(false);
        jButtonAceptar10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptar10.setFocusPainted(false);
        jButtonAceptar10.setFocusable(false);
        jButtonAceptar10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptar10ActionPerformed(evt);
            }
        });
        jPaneNoHanSidoEvaluados.add(jButtonAceptar10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 120, 30));

        jLabelBGNoHanSido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBGNoHanSido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGYellow.jpg"))); // NOI18N
        jLabelBGNoHanSido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPaneNoHanSidoEvaluados.add(jLabelBGNoHanSido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 200));

        jPanel1.add(jPaneNoHanSidoEvaluados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 400, 200));

        jPanelYaHaSidoEvaluado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelYaHaSidoEvaluado.setEnabled(false);
        jPanelYaHaSidoEvaluado.setOpaque(false);
        jPanelYaHaSidoEvaluado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("El postulante ya ha sido evaluado ");
        jPanelYaHaSidoEvaluado.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 330, 30));

        jLabel23.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("para esta oferta");
        jPanelYaHaSidoEvaluado.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 160, 30));

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_attention_40px.png"))); // NOI18N
        jPanelYaHaSidoEvaluado.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        jButtonAceptar11.setFont(new java.awt.Font("Dosis", 1, 24)); // NOI18N
        jButtonAceptar11.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAceptar11.setText("ACEPTAR");
        jButtonAceptar11.setBorder(null);
        jButtonAceptar11.setBorderPainted(false);
        jButtonAceptar11.setContentAreaFilled(false);
        jButtonAceptar11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptar11.setFocusPainted(false);
        jButtonAceptar11.setFocusable(false);
        jButtonAceptar11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptar11ActionPerformed(evt);
            }
        });
        jPanelYaHaSidoEvaluado.add(jButtonAceptar11, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 120, 30));

        jLabelBGYaEvaluado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBGYaEvaluado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGred3.jpg"))); // NOI18N
        jLabelBGYaEvaluado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelYaHaSidoEvaluado.add(jLabelBGYaEvaluado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 200));

        jPanel1.add(jPanelYaHaSidoEvaluado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, -1, -1));

        jPanelDebeSeleccionar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelDebeSeleccionar.setEnabled(false);
        jPanelDebeSeleccionar.setOpaque(false);
        jPanelDebeSeleccionar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Debe seleccionar una respuesta");
        jPanelDebeSeleccionar.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 330, 30));

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_brake_warning_40px.png"))); // NOI18N
        jPanelDebeSeleccionar.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        jButtonAceptar12.setFont(new java.awt.Font("Dosis", 1, 24)); // NOI18N
        jButtonAceptar12.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAceptar12.setText("ACEPTAR");
        jButtonAceptar12.setBorder(null);
        jButtonAceptar12.setBorderPainted(false);
        jButtonAceptar12.setContentAreaFilled(false);
        jButtonAceptar12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptar12.setFocusPainted(false);
        jButtonAceptar12.setFocusable(false);
        jButtonAceptar12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptar12ActionPerformed(evt);
            }
        });
        jPanelDebeSeleccionar.add(jButtonAceptar12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 120, 30));

        jLabelBGDebe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBGDebe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGYellow.jpg"))); // NOI18N
        jLabelBGDebe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelDebeSeleccionar.add(jLabelBGDebe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 200));

        jPanel1.add(jPanelDebeSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 400, 200));

        jPanelRespuestaCorrecta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRespuestaCorrecta.setEnabled(false);
        jPanelRespuestaCorrecta.setOpaque(false);
        jPanelRespuestaCorrecta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Respuesta CORRECTA");
        jPanelRespuestaCorrecta.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 220, 30));

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_checkmark_50px_4.png"))); // NOI18N
        jPanelRespuestaCorrecta.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, -1, -1));

        jButtonAceptar13.setFont(new java.awt.Font("Dosis", 1, 24)); // NOI18N
        jButtonAceptar13.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAceptar13.setText("ACEPTAR");
        jButtonAceptar13.setBorder(null);
        jButtonAceptar13.setBorderPainted(false);
        jButtonAceptar13.setContentAreaFilled(false);
        jButtonAceptar13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptar13.setFocusPainted(false);
        jButtonAceptar13.setFocusable(false);
        jButtonAceptar13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptar13ActionPerformed(evt);
            }
        });
        jPanelRespuestaCorrecta.add(jButtonAceptar13, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 120, 30));

        jLabelBGCorrecto4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBGCorrecto4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bgGOOD.jpg"))); // NOI18N
        jLabelBGCorrecto4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRespuestaCorrecta.add(jLabelBGCorrecto4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 200));

        jPanel1.add(jPanelRespuestaCorrecta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 400, 200));

        jPanelRespuestaIncorrecta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRespuestaIncorrecta.setEnabled(false);
        jPanelRespuestaIncorrecta.setOpaque(false);
        jPanelRespuestaIncorrecta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Respuesta INCORRECTA");
        jPanelRespuestaIncorrecta.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 250, 30));

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_delete_sign_50px.png"))); // NOI18N
        jPanelRespuestaIncorrecta.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, -1, -1));

        jButtonAceptar14.setFont(new java.awt.Font("Dosis", 1, 24)); // NOI18N
        jButtonAceptar14.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAceptar14.setText("ACEPTAR");
        jButtonAceptar14.setBorder(null);
        jButtonAceptar14.setBorderPainted(false);
        jButtonAceptar14.setContentAreaFilled(false);
        jButtonAceptar14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptar14.setFocusPainted(false);
        jButtonAceptar14.setFocusable(false);
        jButtonAceptar14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptar14ActionPerformed(evt);
            }
        });
        jPanelRespuestaIncorrecta.add(jButtonAceptar14, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 120, 30));

        jLabelBGCorrecto5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBGCorrecto5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bgWRONG.jpg"))); // NOI18N
        jLabelBGCorrecto5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRespuestaIncorrecta.add(jLabelBGCorrecto5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 200));

        jPanel1.add(jPanelRespuestaIncorrecta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 400, 200));

        jPanelNoHasCalifiacado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelNoHasCalifiacado.setEnabled(false);
        jPanelNoHasCalifiacado.setOpaque(false);
        jPanelNoHasCalifiacado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("No has calificado para algún ");
        jPanelNoHasCalifiacado.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 270, 30));

        jLabel28.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("perfil del empleo");
        jPanelNoHasCalifiacado.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 170, 30));

        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_sad_40px.png"))); // NOI18N
        jPanelNoHasCalifiacado.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        jButtonAceptar16.setFont(new java.awt.Font("Dosis", 1, 24)); // NOI18N
        jButtonAceptar16.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAceptar16.setText("ACEPTAR");
        jButtonAceptar16.setBorder(null);
        jButtonAceptar16.setBorderPainted(false);
        jButtonAceptar16.setContentAreaFilled(false);
        jButtonAceptar16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptar16.setFocusPainted(false);
        jButtonAceptar16.setFocusable(false);
        jButtonAceptar16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptar16ActionPerformed(evt);
            }
        });
        jPanelNoHasCalifiacado.add(jButtonAceptar16, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 120, 30));

        jLabelBGNoHasCalificado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBGNoHasCalificado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGred3.jpg"))); // NOI18N
        jLabelBGNoHasCalificado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelNoHasCalifiacado.add(jLabelBGNoHasCalificado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 200));

        jPanel1.add(jPanelNoHasCalifiacado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 400, 200));

        jPanelPostulante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelPostulante.setEnabled(false);
        jPanelPostulante.setOpaque(false);
        jPanelPostulante.setPreferredSize(new java.awt.Dimension(400, 500));
        jPanelPostulante.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "POSTULANTE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dosis", 0, 36), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setMaximumSize(new java.awt.Dimension(360, 400));
        jPanel2.setMinimumSize(new java.awt.Dimension(360, 400));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(360, 400));

        jPanelNombreDNI.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "nombre ~ DNI ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dosis", 0, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanelNombreDNI.setForeground(new java.awt.Color(255, 255, 255));
        jPanelNombreDNI.setMaximumSize(new java.awt.Dimension(320, 112));
        jPanelNombreDNI.setMinimumSize(new java.awt.Dimension(320, 112));
        jPanelNombreDNI.setOpaque(false);
        jPanelNombreDNI.setPreferredSize(new java.awt.Dimension(320, 112));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_business_contact_70px.png"))); // NOI18N

        jLabelNombre.setFont(new java.awt.Font("Dosis", 0, 20)); // NOI18N
        jLabelNombre.setForeground(new java.awt.Color(255, 255, 255));

        jLabelApellido.setFont(new java.awt.Font("Dosis", 0, 20)); // NOI18N
        jLabelApellido.setForeground(new java.awt.Color(255, 255, 255));

        jLabelDNI.setFont(new java.awt.Font("Dosis", 0, 20)); // NOI18N
        jLabelDNI.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelNombreDNILayout = new javax.swing.GroupLayout(jPanelNombreDNI);
        jPanelNombreDNI.setLayout(jPanelNombreDNILayout);
        jPanelNombreDNILayout.setHorizontalGroup(
            jPanelNombreDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNombreDNILayout.createSequentialGroup()
                .addGroup(jPanelNombreDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelNombreDNILayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelDNI, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                        .addGap(57, 57, 57))
                    .addGroup(jPanelNombreDNILayout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelNombreDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(126, 126, 126))
        );
        jPanelNombreDNILayout.setVerticalGroup(
            jPanelNombreDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNombreDNILayout.createSequentialGroup()
                .addGroup(jPanelNombreDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelNombreDNILayout.createSequentialGroup()
                        .addComponent(jLabelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabelApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDNI)
                .addGap(5, 5, 5))
        );

        jPanelEdad.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "edad", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dosis", 0, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanelEdad.setOpaque(false);

        jLabelEdad.setFont(new java.awt.Font("Dosis", 0, 20)); // NOI18N
        jLabelEdad.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEdad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanelEdadLayout = new javax.swing.GroupLayout(jPanelEdad);
        jPanelEdad.setLayout(jPanelEdadLayout);
        jPanelEdadLayout.setHorizontalGroup(
            jPanelEdadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEdadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelEdad, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelEdadLayout.setVerticalGroup(
            jPanelEdadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelEdad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jPanelSexo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "sexo", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dosis", 0, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanelSexo.setOpaque(false);

        jLabelSexo.setFont(new java.awt.Font("Dosis", 0, 20)); // NOI18N
        jLabelSexo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSexo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSexo.setToolTipText("");

        javax.swing.GroupLayout jPanelSexoLayout = new javax.swing.GroupLayout(jPanelSexo);
        jPanelSexo.setLayout(jPanelSexoLayout);
        jPanelSexoLayout.setHorizontalGroup(
            jPanelSexoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSexoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelSexo, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelSexoLayout.setVerticalGroup(
            jPanelSexoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelSexo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelResidencia.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "país origen ~ residencia", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dosis", 0, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanelResidencia.setMaximumSize(new java.awt.Dimension(235, 116));
        jPanelResidencia.setMinimumSize(new java.awt.Dimension(235, 0));
        jPanelResidencia.setOpaque(false);

        jLabelOrigen.setFont(new java.awt.Font("Dosis", 0, 20)); // NOI18N
        jLabelOrigen.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOrigen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabelResidencia.setFont(new java.awt.Font("Dosis", 0, 20)); // NOI18N
        jLabelResidencia.setForeground(new java.awt.Color(255, 255, 255));
        jLabelResidencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_country_60px_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanelResidenciaLayout = new javax.swing.GroupLayout(jPanelResidencia);
        jPanelResidencia.setLayout(jPanelResidenciaLayout);
        jPanelResidenciaLayout.setHorizontalGroup(
            jPanelResidenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelResidenciaLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanelResidenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jLabelResidencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelResidenciaLayout.setVerticalGroup(
            jPanelResidenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelResidenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelResidenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addGroup(jPanelResidenciaLayout.createSequentialGroup()
                        .addComponent(jLabelOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelResidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTelCorreo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "teléfono ~ correo", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dosis", 0, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanelTelCorreo.setMaximumSize(new java.awt.Dimension(320, 94));
        jPanelTelCorreo.setOpaque(false);
        jPanelTelCorreo.setPreferredSize(new java.awt.Dimension(320, 94));

        jLabelTelefono.setFont(new java.awt.Font("Dosis", 0, 20)); // NOI18N
        jLabelTelefono.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTelefono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabelCorreo.setFont(new java.awt.Font("Dosis", 0, 18)); // NOI18N
        jLabelCorreo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCorreo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_email_document_60px.png"))); // NOI18N

        javax.swing.GroupLayout jPanelTelCorreoLayout = new javax.swing.GroupLayout(jPanelTelCorreo);
        jPanelTelCorreo.setLayout(jPanelTelCorreoLayout);
        jPanelTelCorreoLayout.setHorizontalGroup(
            jPanelTelCorreoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTelCorreoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTelCorreoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelTelCorreoLayout.setVerticalGroup(
            jPanelTelCorreoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTelCorreoLayout.createSequentialGroup()
                .addGroup(jPanelTelCorreoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTelCorreoLayout.createSequentialGroup()
                        .addComponent(jLabelTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelResidencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelNombreDNI, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelTelCorreo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(143, 143, 143))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanelNombreDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelResidencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jPanelEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelSexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelTelCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelPostulante.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 360, 400));

        jButtonAceptar15.setFont(new java.awt.Font("Dosis", 1, 24)); // NOI18N
        jButtonAceptar15.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAceptar15.setText("ACEPTAR");
        jButtonAceptar15.setBorder(null);
        jButtonAceptar15.setBorderPainted(false);
        jButtonAceptar15.setContentAreaFilled(false);
        jButtonAceptar15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptar15.setFocusPainted(false);
        jButtonAceptar15.setFocusable(false);
        jButtonAceptar15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptar15ActionPerformed(evt);
            }
        });
        jPanelPostulante.add(jButtonAceptar15, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 440, 120, 30));

        jLabelBGCorrecto6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBGCorrecto6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGblue - copia.jpg"))); // NOI18N
        jLabelBGCorrecto6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelBGCorrecto6.setPreferredSize(new java.awt.Dimension(400, 500));
        jPanelPostulante.add(jLabelBGCorrecto6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 500));

        jPanel1.add(jPanelPostulante, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 500));

        jPanelAgregado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelAgregado.setEnabled(false);
        jPanelAgregado.setOpaque(false);
        jPanelAgregado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel54.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Conocimiento agregado");
        jPanelAgregado.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 250, 30));

        jLabel55.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("correctamente");
        jPanelAgregado.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 150, 30));

        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_good_quality_40px_1.png"))); // NOI18N
        jPanelAgregado.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        jButtonAceptar19.setFont(new java.awt.Font("Dosis", 1, 24)); // NOI18N
        jButtonAceptar19.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAceptar19.setText("ACEPTAR");
        jButtonAceptar19.setBorder(null);
        jButtonAceptar19.setBorderPainted(false);
        jButtonAceptar19.setContentAreaFilled(false);
        jButtonAceptar19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptar19.setFocusPainted(false);
        jButtonAceptar19.setFocusable(false);
        jButtonAceptar19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptar19ActionPerformed(evt);
            }
        });
        jPanelAgregado.add(jButtonAceptar19, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 120, 30));

        jLabelBGCorrecto7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBGCorrecto7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGblue2.jpg"))); // NOI18N
        jLabelBGCorrecto7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelAgregado.add(jLabelBGCorrecto7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 200));

        jPanel1.add(jPanelAgregado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 400, 200));

        jPanelGeneral.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGeneral.setEnabled(false);
        jPanelGeneral.setMaximumSize(new java.awt.Dimension(400, 500));
        jPanelGeneral.setOpaque(false);
        jPanelGeneral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EVALUACIÓN GENERAL", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dosis", 0, 36), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setMaximumSize(new java.awt.Dimension(360, 400));
        jPanel3.setMinimumSize(new java.awt.Dimension(360, 400));
        jPanel3.setOpaque(false);

        jPanelbackend.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "backend", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dosis", 0, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanelbackend.setForeground(new java.awt.Color(255, 255, 255));
        jPanelbackend.setMaximumSize(new java.awt.Dimension(320, 112));
        jPanelbackend.setMinimumSize(new java.awt.Dimension(320, 112));
        jPanelbackend.setOpaque(false);
        jPanelbackend.setPreferredSize(new java.awt.Dimension(325, 70));

        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/backend (1).png"))); // NOI18N
        jLabel59.setPreferredSize(new java.awt.Dimension(60, 40));

        jLabelBackend.setFont(new java.awt.Font("Dosis", 0, 30)); // NOI18N
        jLabelBackend.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBackend.setToolTipText("");

        javax.swing.GroupLayout jPanelbackendLayout = new javax.swing.GroupLayout(jPanelbackend);
        jPanelbackend.setLayout(jPanelbackendLayout);
        jPanelbackendLayout.setHorizontalGroup(
            jPanelbackendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelbackendLayout.createSequentialGroup()
                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelBackend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelbackendLayout.setVerticalGroup(
            jPanelbackendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelbackendLayout.createSequentialGroup()
                .addGroup(jPanelbackendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelBackend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelfrontend.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "frontend", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dosis", 0, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanelfrontend.setForeground(new java.awt.Color(255, 255, 255));
        jPanelfrontend.setMaximumSize(new java.awt.Dimension(320, 112));
        jPanelfrontend.setMinimumSize(new java.awt.Dimension(320, 112));
        jPanelfrontend.setOpaque(false);
        jPanelfrontend.setPreferredSize(new java.awt.Dimension(325, 70));

        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/design(1).png"))); // NOI18N
        jLabel63.setPreferredSize(new java.awt.Dimension(60, 40));

        jLabelfrontend.setFont(new java.awt.Font("Dosis", 0, 30)); // NOI18N
        jLabelfrontend.setForeground(new java.awt.Color(255, 255, 255));
        jLabelfrontend.setToolTipText("");

        javax.swing.GroupLayout jPanelfrontendLayout = new javax.swing.GroupLayout(jPanelfrontend);
        jPanelfrontend.setLayout(jPanelfrontendLayout);
        jPanelfrontendLayout.setHorizontalGroup(
            jPanelfrontendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelfrontendLayout.createSequentialGroup()
                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelfrontend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelfrontendLayout.setVerticalGroup(
            jPanelfrontendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelfrontendLayout.createSequentialGroup()
                .addGroup(jPanelfrontendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelfrontend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPaneldevops.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "devops", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dosis", 0, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        jPaneldevops.setForeground(new java.awt.Color(255, 255, 255));
        jPaneldevops.setMaximumSize(new java.awt.Dimension(320, 112));
        jPaneldevops.setMinimumSize(new java.awt.Dimension(320, 112));
        jPaneldevops.setOpaque(false);
        jPaneldevops.setPreferredSize(new java.awt.Dimension(325, 70));

        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/strategy (1).png"))); // NOI18N
        jLabel64.setPreferredSize(new java.awt.Dimension(60, 40));

        jLabeldevops.setFont(new java.awt.Font("Dosis", 0, 30)); // NOI18N
        jLabeldevops.setForeground(new java.awt.Color(255, 255, 255));
        jLabeldevops.setToolTipText("");

        javax.swing.GroupLayout jPaneldevopsLayout = new javax.swing.GroupLayout(jPaneldevops);
        jPaneldevops.setLayout(jPaneldevopsLayout);
        jPaneldevopsLayout.setHorizontalGroup(
            jPaneldevopsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPaneldevopsLayout.createSequentialGroup()
                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabeldevops, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPaneldevopsLayout.setVerticalGroup(
            jPaneldevopsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneldevopsLayout.createSequentialGroup()
                .addGroup(jPaneldevopsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabeldevops, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPaneluix.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "UIX", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dosis", 0, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        jPaneluix.setForeground(new java.awt.Color(255, 255, 255));
        jPaneluix.setMaximumSize(new java.awt.Dimension(320, 112));
        jPaneluix.setMinimumSize(new java.awt.Dimension(320, 112));
        jPaneluix.setOpaque(false);
        jPaneluix.setPreferredSize(new java.awt.Dimension(325, 70));

        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ux.png"))); // NOI18N
        jLabel65.setPreferredSize(new java.awt.Dimension(60, 40));

        jLabeluix.setFont(new java.awt.Font("Dosis", 0, 30)); // NOI18N
        jLabeluix.setForeground(new java.awt.Color(255, 255, 255));
        jLabeluix.setToolTipText("");

        javax.swing.GroupLayout jPaneluixLayout = new javax.swing.GroupLayout(jPaneluix);
        jPaneluix.setLayout(jPaneluixLayout);
        jPaneluixLayout.setHorizontalGroup(
            jPaneluixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPaneluixLayout.createSequentialGroup()
                .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabeluix, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPaneluixLayout.setVerticalGroup(
            jPaneluixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneluixLayout.createSequentialGroup()
                .addGroup(jPaneluixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabeluix, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelqa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "QA", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dosis", 0, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanelqa.setForeground(new java.awt.Color(255, 255, 255));
        jPanelqa.setMaximumSize(new java.awt.Dimension(320, 112));
        jPanelqa.setMinimumSize(new java.awt.Dimension(320, 112));
        jPanelqa.setOpaque(false);
        jPanelqa.setPreferredSize(new java.awt.Dimension(325, 70));

        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/qa (2).png"))); // NOI18N
        jLabel66.setPreferredSize(new java.awt.Dimension(60, 40));

        jLabelqa.setFont(new java.awt.Font("Dosis", 0, 30)); // NOI18N
        jLabelqa.setForeground(new java.awt.Color(255, 255, 255));
        jLabelqa.setToolTipText("");

        javax.swing.GroupLayout jPanelqaLayout = new javax.swing.GroupLayout(jPanelqa);
        jPanelqa.setLayout(jPanelqaLayout);
        jPanelqaLayout.setHorizontalGroup(
            jPanelqaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelqaLayout.createSequentialGroup()
                .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelqa, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelqaLayout.setVerticalGroup(
            jPanelqaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelqaLayout.createSequentialGroup()
                .addGroup(jPanelqaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelqa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelqa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPaneluix, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPaneldevops, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelfrontend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelbackend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanelbackend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanelfrontend, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPaneldevops, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPaneluix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelqa, javax.swing.GroupLayout.PREFERRED_SIZE, 75, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelGeneral.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 360, 430));

        jButtonAceptar21.setFont(new java.awt.Font("Dosis", 1, 24)); // NOI18N
        jButtonAceptar21.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAceptar21.setText("ACEPTAR");
        jButtonAceptar21.setBorder(null);
        jButtonAceptar21.setBorderPainted(false);
        jButtonAceptar21.setContentAreaFilled(false);
        jButtonAceptar21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptar21.setFocusPainted(false);
        jButtonAceptar21.setFocusable(false);
        jButtonAceptar21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptar21ActionPerformed(evt);
            }
        });
        jPanelGeneral.add(jButtonAceptar21, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 460, 120, 30));

        jLabelBGCorrecto8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBGCorrecto8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BgBlueOther - copia.png"))); // NOI18N
        jLabelBGCorrecto8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelBGCorrecto8.setPreferredSize(new java.awt.Dimension(400, 500));
        jPanelGeneral.add(jLabelBGCorrecto8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, -1));

        jPanel1.add(jPanelGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, -1));

        jPanelHasSidoAsignado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHasSidoAsignado.setEnabled(false);
        jPanelHasSidoAsignado.setMinimumSize(new java.awt.Dimension(400, 300));
        jPanelHasSidoAsignado.setOpaque(false);
        jPanelHasSidoAsignado.setPreferredSize(new java.awt.Dimension(400, 300));
        jPanelHasSidoAsignado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelFelicitaciones.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabelFelicitaciones.setForeground(new java.awt.Color(255, 255, 0));
        jLabelFelicitaciones.setText("¡FELICITACIONES!");
        jPanelHasSidoAsignado.add(jLabelFelicitaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 180, 30));

        jLabel33.setFont(new java.awt.Font("Qanelas Soft DEMO ExtraBold", 0, 22)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Has sido asignado al perfil:");
        jLabel33.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanelHasSidoAsignado.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 280, 30));

        jLabelPts.setFont(new java.awt.Font("Qanelas Soft DEMO ExtraBold", 0, 22)); // NOI18N
        jLabelPts.setForeground(new java.awt.Color(236, 236, 84));
        jLabelPts.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanelHasSidoAsignado.add(jLabelPts, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 100, 30));

        jlabelCategoria.setFont(new java.awt.Font("Qanelas Soft DEMO ExtraBold", 0, 22)); // NOI18N
        jlabelCategoria.setForeground(new java.awt.Color(236, 236, 84));
        jlabelCategoria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanelHasSidoAsignado.add(jlabelCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 140, 30));

        jButtonAceptar17.setFont(new java.awt.Font("Dosis", 1, 24)); // NOI18N
        jButtonAceptar17.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAceptar17.setText("ACEPTAR");
        jButtonAceptar17.setBorder(null);
        jButtonAceptar17.setBorderPainted(false);
        jButtonAceptar17.setContentAreaFilled(false);
        jButtonAceptar17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptar17.setFocusPainted(false);
        jButtonAceptar17.setFocusable(false);
        jButtonAceptar17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptar17ActionPerformed(evt);
            }
        });
        jPanelHasSidoAsignado.add(jButtonAceptar17, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 120, 30));

        jLabelBGDiploma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBGDiploma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_prize_70px.png"))); // NOI18N
        jLabelBGDiploma.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelBGDiploma.setMaximumSize(new java.awt.Dimension(400, 300));
        jLabelBGDiploma.setMinimumSize(new java.awt.Dimension(400, 300));
        jLabelBGDiploma.setPreferredSize(new java.awt.Dimension(400, 300));
        jPanelHasSidoAsignado.add(jLabelBGDiploma, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 140, 70));

        jLabel47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(236, 236, 84)));
        jPanelHasSidoAsignado.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 360, 200));

        jLabelBGHasSidoAsignado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBGHasSidoAsignado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BgBlueOther.png"))); // NOI18N
        jLabelBGHasSidoAsignado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelBGHasSidoAsignado.setMaximumSize(new java.awt.Dimension(400, 300));
        jLabelBGHasSidoAsignado.setMinimumSize(new java.awt.Dimension(400, 300));
        jLabelBGHasSidoAsignado.setPreferredSize(new java.awt.Dimension(400, 300));
        jPanelHasSidoAsignado.add(jLabelBGHasSidoAsignado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        jPanel1.add(jPanelHasSidoAsignado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 400, 300));

        jPanelNOHasSidoAsignado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelNOHasSidoAsignado.setEnabled(false);
        jPanelNOHasSidoAsignado.setOpaque(false);
        jPanelNOHasSidoAsignado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelLoSentimos.setFont(new java.awt.Font("Qanelas Soft DEMO ExtraBold", 0, 24)); // NOI18N
        jLabelLoSentimos.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLoSentimos.setText("Lo sentimos");
        jPanelNOHasSidoAsignado.add(jLabelLoSentimos, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 130, 30));

        jLabelNoHasSido.setFont(new java.awt.Font("Qanelas Soft DEMO ExtraBold", 0, 22)); // NOI18N
        jLabelNoHasSido.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNoHasSido.setText("No has sido asignado al perfil:");
        jLabelNoHasSido.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanelNOHasSidoAsignado.add(jLabelNoHasSido, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 310, 30));

        jlabelCategoria1.setFont(new java.awt.Font("Qanelas Soft DEMO ExtraBold", 0, 22)); // NOI18N
        jlabelCategoria1.setForeground(new java.awt.Color(236, 236, 84));
        jlabelCategoria1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanelNOHasSidoAsignado.add(jlabelCategoria1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 140, 30));

        jLabelPts1.setFont(new java.awt.Font("Qanelas Soft DEMO ExtraBold", 0, 22)); // NOI18N
        jLabelPts1.setForeground(new java.awt.Color(236, 236, 84));
        jLabelPts1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanelNOHasSidoAsignado.add(jLabelPts1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 100, 30));

        jButtonAceptar18.setFont(new java.awt.Font("Dosis", 1, 24)); // NOI18N
        jButtonAceptar18.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAceptar18.setText("ACEPTAR");
        jButtonAceptar18.setBorder(null);
        jButtonAceptar18.setBorderPainted(false);
        jButtonAceptar18.setContentAreaFilled(false);
        jButtonAceptar18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptar18.setFocusPainted(false);
        jButtonAceptar18.setFocusable(false);
        jButtonAceptar18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptar18ActionPerformed(evt);
            }
        });
        jPanelNOHasSidoAsignado.add(jButtonAceptar18, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 120, 30));

        jLabel48.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanelNOHasSidoAsignado.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 360, 200));

        jLabelBGHasSidoAsignado1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBGHasSidoAsignado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bgRedSorry.png"))); // NOI18N
        jLabelBGHasSidoAsignado1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelBGHasSidoAsignado1.setMaximumSize(new java.awt.Dimension(400, 300));
        jLabelBGHasSidoAsignado1.setMinimumSize(new java.awt.Dimension(400, 300));
        jLabelBGHasSidoAsignado1.setPreferredSize(new java.awt.Dimension(400, 300));
        jPanelNOHasSidoAsignado.add(jLabelBGHasSidoAsignado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        jPanel1.add(jPanelNOHasSidoAsignado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 400, 300));

        jPanelDebeTerminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelDebeTerminar.setEnabled(false);
        jPanelDebeTerminar.setOpaque(false);
        jPanelDebeTerminar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel57.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("No permitido");
        jPanelDebeTerminar.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 130, 30));

        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_attention_filled_40px.png"))); // NOI18N
        jPanelDebeTerminar.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        jLabel58.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("debe realizar toda la evaluación");
        jPanelDebeTerminar.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 310, 30));

        jButtonAceptar20.setFont(new java.awt.Font("Dosis", 1, 24)); // NOI18N
        jButtonAceptar20.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAceptar20.setText("ACEPTAR");
        jButtonAceptar20.setBorder(null);
        jButtonAceptar20.setBorderPainted(false);
        jButtonAceptar20.setContentAreaFilled(false);
        jButtonAceptar20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptar20.setFocusPainted(false);
        jButtonAceptar20.setFocusable(false);
        jButtonAceptar20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptar20ActionPerformed(evt);
            }
        });
        jPanelDebeTerminar.add(jButtonAceptar20, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 120, 30));

        jLabelTerminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTerminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGYellow.jpg"))); // NOI18N
        jLabelTerminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelDebeTerminar.add(jLabelTerminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 200));

        jPanel1.add(jPanelDebeTerminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 400, 200));

        jLayeredPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonContinuarActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonContinuarActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSiActionPerformed
       state = true;
        dispose();
    }//GEN-LAST:event_jButtonSiActionPerformed

    private void jButtonNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNoActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonNoActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jButtonAceptar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptar1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonAceptar1ActionPerformed

    private void jButtonAceptar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptar2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonAceptar2ActionPerformed

    private void jButtonAceptar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptar3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonAceptar3ActionPerformed

    private void jButtonAceptar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptar4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonAceptar4ActionPerformed

    private void jButtonAceptar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptar5ActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonAceptar5ActionPerformed

    private void jButtonAceptar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptar6ActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonAceptar6ActionPerformed

    private void jButtonAceptar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptar7ActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonAceptar7ActionPerformed

    private void jButtonAceptar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptar8ActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonAceptar8ActionPerformed

    private void jButtonAceptar9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptar9ActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonAceptar9ActionPerformed

    private void jButtonAceptar10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptar10ActionPerformed
       dispose();
    }//GEN-LAST:event_jButtonAceptar10ActionPerformed

    private void jButtonAceptar11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptar11ActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonAceptar11ActionPerformed

    private void jButtonAceptar12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptar12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAceptar12ActionPerformed

    private void jButtonAceptar13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptar13ActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonAceptar13ActionPerformed

    private void jButtonAceptar14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptar14ActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonAceptar14ActionPerformed

    private void jButtonAceptar15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptar15ActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonAceptar15ActionPerformed

    private void jButtonAceptar16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptar16ActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonAceptar16ActionPerformed

    private void jButtonAceptar17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptar17ActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonAceptar17ActionPerformed

    private void jButtonAceptar18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptar18ActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonAceptar18ActionPerformed

    private void jButtonAceptar19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptar19ActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonAceptar19ActionPerformed

    private void jButtonAceptar20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptar20ActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonAceptar20ActionPerformed

    private void jButtonAceptar21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptar21ActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonAceptar21ActionPerformed

    public boolean getState()
    {
        return state;
    }
    
    
    /**
     * @param args the command line arguments
     */

    public static int getABORT() {
        return ABORT;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonAceptar1;
    private javax.swing.JButton jButtonAceptar10;
    private javax.swing.JButton jButtonAceptar11;
    private javax.swing.JButton jButtonAceptar12;
    private javax.swing.JButton jButtonAceptar13;
    private javax.swing.JButton jButtonAceptar14;
    private javax.swing.JButton jButtonAceptar15;
    private javax.swing.JButton jButtonAceptar16;
    private javax.swing.JButton jButtonAceptar17;
    private javax.swing.JButton jButtonAceptar18;
    private javax.swing.JButton jButtonAceptar19;
    private javax.swing.JButton jButtonAceptar2;
    private javax.swing.JButton jButtonAceptar20;
    private javax.swing.JButton jButtonAceptar21;
    private javax.swing.JButton jButtonAceptar3;
    private javax.swing.JButton jButtonAceptar4;
    private javax.swing.JButton jButtonAceptar5;
    private javax.swing.JButton jButtonAceptar6;
    private javax.swing.JButton jButtonAceptar7;
    private javax.swing.JButton jButtonAceptar8;
    private javax.swing.JButton jButtonAceptar9;
    private javax.swing.JButton jButtonContinuar;
    private javax.swing.JButton jButtonNo;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JButton jButtonSi;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelBGCancel;
    private javax.swing.JLabel jLabelBGCorrecto;
    private javax.swing.JLabel jLabelBGCorrecto1;
    private javax.swing.JLabel jLabelBGCorrecto2;
    private javax.swing.JLabel jLabelBGCorrecto3;
    private javax.swing.JLabel jLabelBGCorrecto4;
    private javax.swing.JLabel jLabelBGCorrecto5;
    private javax.swing.JLabel jLabelBGCorrecto6;
    private javax.swing.JLabel jLabelBGCorrecto7;
    private javax.swing.JLabel jLabelBGCorrecto8;
    private javax.swing.JLabel jLabelBGDebe;
    private javax.swing.JLabel jLabelBGDiploma;
    private javax.swing.JLabel jLabelBGERROR;
    private javax.swing.JLabel jLabelBGEdad;
    private javax.swing.JLabel jLabelBGExit;
    private javax.swing.JLabel jLabelBGHasSidoAsignado;
    private javax.swing.JLabel jLabelBGHasSidoAsignado1;
    private javax.swing.JLabel jLabelBGIncompleto;
    private javax.swing.JLabel jLabelBGNoHanSido;
    private javax.swing.JLabel jLabelBGNoHasCalificado;
    private javax.swing.JLabel jLabelBGNoHay;
    private javax.swing.JLabel jLabelBGYaEvaluado;
    private javax.swing.JLabel jLabelBGYaRegistrado;
    private javax.swing.JLabel jLabelBGYaRegistrado1;
    private javax.swing.JLabel jLabelBackend;
    private javax.swing.JLabel jLabelCorreo;
    private javax.swing.JLabel jLabelDNI;
    private javax.swing.JLabel jLabelEdad;
    private javax.swing.JLabel jLabelFelicitaciones;
    private javax.swing.JLabel jLabelLoSentimos;
    private javax.swing.JLabel jLabelNoHasSido;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelOrigen;
    private javax.swing.JLabel jLabelPts;
    private javax.swing.JLabel jLabelPts1;
    private javax.swing.JLabel jLabelResidencia;
    private javax.swing.JLabel jLabelSexo;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JLabel jLabelTerminar;
    private javax.swing.JLabel jLabeldevops;
    private javax.swing.JLabel jLabelfrontend;
    private javax.swing.JLabel jLabelqa;
    private javax.swing.JLabel jLabeluix;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPaneConcEmpleoCorrecto;
    private javax.swing.JPanel jPaneNoHanSidoEvaluados;
    private javax.swing.JPanel jPaneNoHayPostulantes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelAgregado;
    private javax.swing.JPanel jPanelCancelarInscripcion;
    private javax.swing.JPanel jPanelConCorrecto;
    private javax.swing.JPanel jPanelDebeSeleccionar;
    private javax.swing.JPanel jPanelDebeTerminar;
    private javax.swing.JPanel jPanelEdad;
    private javax.swing.JPanel jPanelEmpleoYaRegistrado;
    private javax.swing.JPanel jPanelError;
    private javax.swing.JPanel jPanelGeneral;
    private javax.swing.JPanel jPanelHasSidoAsignado;
    private javax.swing.JPanel jPanelIncompleto;
    private javax.swing.JPanel jPanelInfoCorrecto;
    private javax.swing.JPanel jPanelInfoEmpleoCorrecto;
    private javax.swing.JPanel jPanelNOHasSidoAsignado;
    private javax.swing.JPanel jPanelNoHasCalifiacado;
    private javax.swing.JPanel jPanelNombreDNI;
    private javax.swing.JPanel jPanelPostulante;
    private javax.swing.JPanel jPanelRangoEdad;
    private javax.swing.JPanel jPanelResidencia;
    private javax.swing.JPanel jPanelRespuestaCorrecta;
    private javax.swing.JPanel jPanelRespuestaIncorrecta;
    private javax.swing.JPanel jPanelSalir;
    private javax.swing.JPanel jPanelSexo;
    private javax.swing.JPanel jPanelTelCorreo;
    private javax.swing.JPanel jPanelYaHaSidoEvaluado;
    private javax.swing.JPanel jPanelYaRegistrado;
    private javax.swing.JPanel jPanelbackend;
    private javax.swing.JPanel jPaneldevops;
    private javax.swing.JPanel jPanelfrontend;
    private javax.swing.JPanel jPanelqa;
    private javax.swing.JPanel jPaneluix;
    private javax.swing.JLabel jlabelCategoria;
    private javax.swing.JLabel jlabelCategoria1;
    // End of variables declaration//GEN-END:variables
}
