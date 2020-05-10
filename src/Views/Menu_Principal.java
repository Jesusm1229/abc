/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Database.DatabaseConnection;
import java.awt.Color;
import javax.swing.BorderFactory;
import java.sql.Connection;

/**
 *
 * @author Jesus Gonzalez FINAL Y CORREGIDO
 */
public class Menu_Principal extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;
    private Formulario_Postulante_Info_Personal fp;
    InfoDialogs []infoD = new InfoDialogs[4];
    private DatabaseConnection dbconnection;
    
    Connection connection;
    /**
     * Creates new form MenuUI
     */
    public Menu_Principal(Connection connection) {
        
        initComponents();   
        dbconnection = new DatabaseConnection();
        
        // Conectando a la base de datos.
        this.connection = connection;
            
        setLocationRelativeTo(null);
        getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        
        infoD[0] = new InfoDialogs(1);
        infoD[1] = new InfoDialogs(2);
        infoD[2] = new InfoDialogs(3);
        infoD[3] = new InfoDialogs(4);
        
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel21 = new javax.swing.JLabel();
        jPanelPrincipal = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPIngresar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabelInfoIngresar = new javax.swing.JLabel();
        jPPerfil = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabelInfoPerfil = new javax.swing.JLabel();
        jPCandidatos = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabelInfoCandidatos = new javax.swing.JLabel();
        jPTest = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabelInfoEvaluacion = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanelLateral = new javax.swing.JPanel();
        jButtonClose = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanelSuperior = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        jLabel21.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Sistema de añadido, búsqueda y filtrado de perfiles profesionales para su posible ingreso en una empresa. ");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setName("FramePrincipal"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelPrincipal.setToolTipText("");
        jPanelPrincipal.setMaximumSize(new java.awt.Dimension(1000, 700));
        jPanelPrincipal.setMinimumSize(new java.awt.Dimension(1000, 700));
        jPanelPrincipal.setPreferredSize(new java.awt.Dimension(1000, 700));
        jPanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(155, 188, 192));
        jPanel3.setPreferredSize(new java.awt.Dimension(950, 300));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Inicio.mp4.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelPrincipal.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 950, 300));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setMaximumSize(new java.awt.Dimension(950, 370));
        jPanel4.setMinimumSize(new java.awt.Dimension(950, 370));
        jPanel4.setPreferredSize(new java.awt.Dimension(950, 370));

        jPanel5.setBackground(new java.awt.Color(0, 159, 137));
        jPanel5.setPreferredSize(new java.awt.Dimension(900, 60));

        jLabel5.setFont(new java.awt.Font("Qanelas Soft DEMO ExtraBold", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SERVICIOS");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_food_service_60px_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPIngresar.setBackground(new java.awt.Color(0, 159, 137));
        jPIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPIngresar.setMaximumSize(new java.awt.Dimension(220, 200));
        jPIngresar.setPreferredSize(new java.awt.Dimension(190, 200));
        jPIngresar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPIngresarMouseMoved(evt);
            }
        });
        jPIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPIngresarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPIngresarMouseExited(evt);
            }
        });
        jPIngresar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Dosis", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_submit_resume_120px_1.png"))); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INGRESAR CV", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dosis", 1, 23), new java.awt.Color(255, 255, 255))); // NOI18N
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel4.setMaximumSize(new java.awt.Dimension(200, 148));
        jLabel4.setMinimumSize(new java.awt.Dimension(200, 148));
        jLabel4.setPreferredSize(new java.awt.Dimension(200, 148));
        jLabel4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPIngresar.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 11, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_horizontal_line_100px.png"))); // NOI18N
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPIngresar.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, 36));

        jLabelInfoIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_help_30px.png"))); // NOI18N
        jLabelInfoIngresar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabelInfoIngresarMouseMoved(evt);
            }
        });
        jLabelInfoIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelInfoIngresarMouseExited(evt);
            }
        });
        jPIngresar.add(jLabelInfoIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 159, -1, 38));

        jPPerfil.setBackground(new java.awt.Color(0, 159, 137));
        jPPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPPerfil.setMaximumSize(new java.awt.Dimension(220, 200));
        jPPerfil.setPreferredSize(new java.awt.Dimension(221, 200));
        jPPerfil.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPPerfilMouseMoved(evt);
            }
        });
        jPPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPPerfilMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPPerfilMouseExited(evt);
            }
        });
        jPPerfil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Dosis", 1, 23)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_permanent_job_120px.png"))); // NOI18N
        jLabel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INGRESAR PERFIL", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dosis", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel10.setMaximumSize(new java.awt.Dimension(210, 148));
        jLabel10.setMinimumSize(new java.awt.Dimension(210, 148));
        jLabel10.setPreferredSize(new java.awt.Dimension(200, 148));
        jLabel10.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPPerfil.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 11, -1, -1));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_horizontal_line_100px.png"))); // NOI18N
        jLabel19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPPerfil.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 160, -1, 36));

        jLabelInfoPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_help_30px.png"))); // NOI18N
        jLabelInfoPerfil.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabelInfoPerfilMouseMoved(evt);
            }
        });
        jLabelInfoPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelInfoPerfilMouseExited(evt);
            }
        });
        jPPerfil.add(jLabelInfoPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 158, -1, 38));

        jPCandidatos.setBackground(new java.awt.Color(0, 159, 137));
        jPCandidatos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPCandidatos.setMaximumSize(new java.awt.Dimension(220, 200));
        jPCandidatos.setPreferredSize(new java.awt.Dimension(221, 200));
        jPCandidatos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPCandidatosMouseMoved(evt);
            }
        });
        jPCandidatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPCandidatosMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPCandidatosMouseExited(evt);
            }
        });
        jPCandidatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Dosis", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_search_property_120px_1.png"))); // NOI18N
        jLabel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CANDIDATOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dosis", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel13.setMaximumSize(new java.awt.Dimension(210, 148));
        jLabel13.setMinimumSize(new java.awt.Dimension(210, 148));
        jLabel13.setPreferredSize(new java.awt.Dimension(200, 148));
        jLabel13.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPCandidatos.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 11, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_horizontal_line_100px.png"))); // NOI18N
        jLabel17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPCandidatos.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 161, -1, 36));

        jLabelInfoCandidatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_help_30px.png"))); // NOI18N
        jLabelInfoCandidatos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabelInfoCandidatosMouseMoved(evt);
            }
        });
        jLabelInfoCandidatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelInfoCandidatosMouseExited(evt);
            }
        });
        jPCandidatos.add(jLabelInfoCandidatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 159, -1, 38));

        jPTest.setBackground(new java.awt.Color(0, 159, 137));
        jPTest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPTest.setMaximumSize(new java.awt.Dimension(220, 200));
        jPTest.setPreferredSize(new java.awt.Dimension(221, 200));
        jPTest.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPTestMouseMoved(evt);
            }
        });
        jPTest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPTestMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPTestMouseExited(evt);
            }
        });
        jPTest.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Dosis", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_scorecard_120px.png"))); // NOI18N
        jLabel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EVALUACIÓN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dosis", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel12.setMaximumSize(new java.awt.Dimension(210, 148));
        jLabel12.setMinimumSize(new java.awt.Dimension(210, 148));
        jLabel12.setPreferredSize(new java.awt.Dimension(200, 148));
        jLabel12.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPTest.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 11, -1, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_horizontal_line_100px.png"))); // NOI18N
        jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPTest.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 161, -1, 36));

        jLabelInfoEvaluacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_help_30px.png"))); // NOI18N
        jLabelInfoEvaluacion.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabelInfoEvaluacionMouseMoved(evt);
            }
        });
        jLabelInfoEvaluacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelInfoEvaluacionMouseExited(evt);
            }
        });
        jPTest.add(jLabelInfoEvaluacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 159, -1, 38));

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sistema de añadido, búsqueda y filtrado de perfiles profesionales para su posible ingreso en una empresa. ");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Desarrollado por: Lunar, Eduardo (C.I: 24.513.298) ||  González, Jesús (C.I: 23.733.841) ||  Medina, Jesús (C.I: 24.225.319)");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jPPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jPCandidatos, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jPTest, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPIngresar, jPPerfil});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPCandidatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(3, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPIngresar, jPPerfil});

        jPanelPrincipal.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));

        jPanelLateral.setBackground(new java.awt.Color(0, 51, 51));
        jPanelLateral.setPreferredSize(new java.awt.Dimension(50, 700));

        jButtonClose.setBackground(new java.awt.Color(0, 51, 51));
        jButtonClose.setForeground(new java.awt.Color(0, 51, 51));
        jButtonClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_close_window_70px.png"))); // NOI18N
        jButtonClose.setBorderPainted(false);
        jButtonClose.setContentAreaFilled(false);
        jButtonClose.setPreferredSize(new java.awt.Dimension(50, 50));
        jButtonClose.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_close_window_70px_1.png"))); // NOI18N
        jButtonClose.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_close_window_70px_1.png"))); // NOI18N
        jButtonClose.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_close_window_70px_1.png"))); // NOI18N
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Qanelas Soft DEMO ExtraBold", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("U");
        jLabel3.setAlignmentY(0.0F);
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel7.setFont(new java.awt.Font("Qanelas Soft DEMO ExtraBold", 0, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("D");
        jLabel7.setAlignmentY(0.0F);
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel8.setFont(new java.awt.Font("Qanelas Soft DEMO ExtraBold", 0, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("O");
        jLabel8.setAlignmentY(0.0F);
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanelLateralLayout = new javax.swing.GroupLayout(jPanelLateral);
        jPanelLateral.setLayout(jPanelLateralLayout);
        jPanelLateralLayout.setHorizontalGroup(
            jPanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelLateralLayout.setVerticalGroup(
            jPanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLateralLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addComponent(jLabel7)
                .addGap(0, 0, 0)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 432, Short.MAX_VALUE)
                .addComponent(jButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        jPanelPrincipal.add(jPanelLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 700));

        jPanelSuperior.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSuperior.setPreferredSize(new java.awt.Dimension(950, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_minimize_window_30px.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_minimize_window_30px_2.png"))); // NOI18N
        jButton1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_minimize_window_30px_2.png"))); // NOI18N
        jButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_minimize_window_30px_2.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSuperiorLayout = new javax.swing.GroupLayout(jPanelSuperior);
        jPanelSuperior.setLayout(jPanelSuperiorLayout);
        jPanelSuperiorLayout.setHorizontalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSuperiorLayout.createSequentialGroup()
                .addContainerGap(896, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(24, 24, 24))
        );
        jPanelSuperiorLayout.setVerticalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSuperiorLayout.createSequentialGroup()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelPrincipal.add(jPanelSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 950, 30));

        getContentPane().add(jPanelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPIngresarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPIngresarMouseMoved
        jPIngresar.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
    }//GEN-LAST:event_jPIngresarMouseMoved

    private void jPIngresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPIngresarMouseExited
        jPIngresar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,159,137)));
    }//GEN-LAST:event_jPIngresarMouseExited

    private void jPPerfilMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPPerfilMouseMoved
        jPPerfil.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
    }//GEN-LAST:event_jPPerfilMouseMoved

    private void jPCandidatosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPCandidatosMouseMoved
        jPCandidatos.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
    }//GEN-LAST:event_jPCandidatosMouseMoved

    private void jPTestMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPTestMouseMoved
        jPTest.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
    }//GEN-LAST:event_jPTestMouseMoved

    private void jPPerfilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPPerfilMouseExited
        jPPerfil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,159,137)));
    }//GEN-LAST:event_jPPerfilMouseExited

    private void jPCandidatosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPCandidatosMouseExited
        jPCandidatos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,159,137)));
    }//GEN-LAST:event_jPCandidatosMouseExited

    private void jPTestMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPTestMouseExited
       jPTest.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,159,137)));
    }//GEN-LAST:event_jPTestMouseExited

    private void jPIngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPIngresarMouseClicked
        if(dbconnection.getConnection() != null){
            fp = new Formulario_Postulante_Info_Personal(connection);
            fp.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jPIngresarMouseClicked

    private void jPPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPPerfilMouseClicked
        if(dbconnection.getConnection() != null){
            Formulario_Empleo_Informacion oe = new Formulario_Empleo_Informacion(connection);
            oe.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jPPerfilMouseClicked

    private void jPCandidatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPCandidatosMouseClicked
        if(dbconnection.getConnection() != null){
            OfertasEmpleoFiltradoFrame oef = new OfertasEmpleoFiltradoFrame(connection, this, 3);
            oef.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jPCandidatosMouseClicked

    private void jPTestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPTestMouseClicked
        if(dbconnection.getConnection() != null){ 
            OfertasEmpleoFiltradoFrame oef = new OfertasEmpleoFiltradoFrame(connection, this, 4);
            oef.setVisible(true);
            dispose(); 
        }
    }//GEN-LAST:event_jPTestMouseClicked

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        Dialogs d = new Dialogs(1);
        d.setVisible(true);
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jLabelInfoIngresarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelInfoIngresarMouseMoved
        
        infoD[0].setVisible(true);
    }//GEN-LAST:event_jLabelInfoIngresarMouseMoved

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setState(Formulario_Postulante_Info_Personal.ICONIFIED);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabelInfoIngresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelInfoIngresarMouseExited
        infoD[0].dispose();
    }//GEN-LAST:event_jLabelInfoIngresarMouseExited

    private void jLabelInfoPerfilMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelInfoPerfilMouseMoved
        infoD[1].setVisible(true);
    }//GEN-LAST:event_jLabelInfoPerfilMouseMoved

    private void jLabelInfoPerfilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelInfoPerfilMouseExited
        infoD[1].dispose();
    }//GEN-LAST:event_jLabelInfoPerfilMouseExited

    private void jLabelInfoCandidatosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelInfoCandidatosMouseMoved
        infoD[2].setVisible(true);
    }//GEN-LAST:event_jLabelInfoCandidatosMouseMoved

    private void jLabelInfoEvaluacionMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelInfoEvaluacionMouseMoved
        infoD[3].setVisible(true);
    }//GEN-LAST:event_jLabelInfoEvaluacionMouseMoved

    private void jLabelInfoCandidatosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelInfoCandidatosMouseExited
        infoD[2].dispose();
    }//GEN-LAST:event_jLabelInfoCandidatosMouseExited

    private void jLabelInfoEvaluacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelInfoEvaluacionMouseExited
        infoD[3].dispose();
    }//GEN-LAST:event_jLabelInfoEvaluacionMouseExited

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelInfoCandidatos;
    private javax.swing.JLabel jLabelInfoEvaluacion;
    private javax.swing.JLabel jLabelInfoIngresar;
    private javax.swing.JLabel jLabelInfoPerfil;
    private javax.swing.JPanel jPCandidatos;
    private javax.swing.JPanel jPIngresar;
    private javax.swing.JPanel jPPerfil;
    private javax.swing.JPanel jPTest;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelLateral;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JPanel jPanelSuperior;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
