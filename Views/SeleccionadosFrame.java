/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.Seleccionado;
import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
/**
 *
 * @author Jesus Gonzalez
 */
public class SeleccionadosFrame extends javax.swing.JFrame {

    Connection connection;
    OfertasEmpleoFiltradoFrame oeff;
    private List<Seleccionado> seleccionados;
    private int idoferta_empleo;
    
        
    public SeleccionadosFrame(OfertasEmpleoFiltradoFrame oeff, int idoferta_empleo, Connection connection) {
               
        initComponents();  
                       
        setLocationRelativeTo(null);
        getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        
        this.oeff = oeff;
        this.idoferta_empleo = idoferta_empleo;
        this.connection = connection;
        seleccionados = new ArrayList();
        getDescripcionEmpleo();
        
         // Obtenemos todos los postulantes seleccionados de las pruebas especificas de cada empleo segun el perfil donde resulto ganador y que el empleo lo requiere.
        getSeleccionados();
        
        if(!seleccionados.isEmpty())
            getPostulantesMayoriaPuntaje();
      
    }

        // Metodo para obtener todos los postulados seleccionados para la oferta de empleo.
    public void getSeleccionados(){
    
          try {
            ResultSet rs = connection.prepareStatement("SELECT * FROM evaluacionespecifica WHERE idoferta_empleo = " + idoferta_empleo).executeQuery();
                
            while(rs.next()){
                Seleccionado selec = new Seleccionado();
                
                if(rs.getInt(5) >= 50){
                    selec.setIDPostulante(rs.getInt(2));
                    selec.setIDCategoria(rs.getInt(4));
                    selec.setPuntaje(rs.getInt(5));
                    
                    seleccionados.add(selec);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Formulario_Postulante_Conocimientos.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        // Ahora ordenamos la lista de seleccionados para ser mostrada en el JList.
        Collections.sort(seleccionados);
    }
    
    // Metodo para saber cual o cuales postulantes tienen mayoria de puntaje para ser seleccionados y ocupar el cargo del empleo.
    public void getPostulantesMayoriaPuntaje(){
    
        DefaultListModel model = new DefaultListModel();
        List <Integer> categoriasEncontradas = new ArrayList();
        List<Seleccionado> candidatos = new ArrayList(); 
        
        // Los puntajes mas altos por categoria seran siempre los de arriba de la lista debido a la organizacion previa que se realizo con sort.
        for(int counter = seleccionados.size() - 1; counter >= 0; counter--)
            if(!categoriasEncontradas.contains(seleccionados.get(counter).getIDCategoria())){
                candidatos.add(seleccionados.get(counter));
                categoriasEncontradas.add(seleccionados.get(counter).getIDCategoria());
            }
        
        // En candidatos estaran los mas altos (Los ganadores), pero puede darse el caso en que hayan empates, entonces tomaremos en cuenta a esos concursantes.
        for(int counterI = candidatos.size() - 1; counterI >= 0; counterI--)
            for(int counterJ = 0; counterJ < seleccionados.size(); counterJ++)
                if(candidatos.get(counterI).getIDPostulante() != seleccionados.get(counterJ).getIDPostulante() && candidatos.get(counterI).getPuntaje() == seleccionados.get(counterJ).getPuntaje() && candidatos.get(counterI).getIDCategoria() == seleccionados.get(counterJ).getIDCategoria())
                    candidatos.add(seleccionados.get(counterJ));
        
        // Ya se tienen todos los ganadores, ahora se ingresan al JList de manera ordenada por categoria.
        for(int counterI = 1; counterI < 6; counterI++)
            for(int counterJ = 0; counterJ < candidatos.size(); counterJ++)
                if(candidatos.get(counterJ).getIDCategoria() == counterI)
                    model = fijarSeleccionados(getNombreCategoria(candidatos.get(counterJ).getIDCategoria()), candidatos.get(counterJ).getIDPostulante(), model, candidatos.get(counterJ).getPuntaje());
       
       seleccionados_list.setModel(model);
       
       if(!seleccionados.isEmpty())
           seleccionados_list.setSelectedIndex(0);
    }
    
    // Funcion para fijar los postulados seleccionados al modelo default que se enviara al JList de la vista.
    public DefaultListModel fijarSeleccionados(String nombreCategoria, int idpostulante, DefaultListModel model, int puntaje){
    
        try{
            // Verificar si ya el postulante se encuentra filtrado con el empleo correspondiente.
            ResultSet rs = connection.prepareStatement("SELECT * FROM postulantes WHERE idpostulante = " + idpostulante).executeQuery();
                    
                if(rs.first())
                    model.addElement(rs.getString(2) + " " + rs.getString(4) + " - " + rs.getInt(7) + " Años" + " - " + rs.getString(8) + " - " + rs.getString(10) + " - " + rs.getLong(11) + " - " + rs.getString(12) + " - " + "Seleccionado: " + nombreCategoria + " - " + " Puntaje: " + puntaje);
                            
        }catch (SQLException ex) {
                Logger.getLogger(Formulario_Postulante_Conocimientos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return model;
    }
    
    // Metodo para encontrar la descripcion del empleo.
    public void getDescripcionEmpleo(){
    
          Font font = new Font("Berlin Sans FB", Font.BOLD, 24);
        
                 
          try {
            ResultSet rs = connection.prepareStatement("SELECT * FROM oferta_empleo WHERE idoferta_empleo = " + idoferta_empleo).executeQuery();
                
            if(rs.first())
           jPanelOfertasEmpleo.setBorder(new TitledBorder(new LineBorder(new Color(0, 153, 240)), "empleo: " + rs.getString(10) , TitledBorder.LEADING,
           TitledBorder.TOP, font , new Color(0, 102, 102 ))); 
                        
                        
                
        } catch (SQLException ex) {
            Logger.getLogger(Formulario_Postulante_Conocimientos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Metodo que devuelve el tipo de categoria segun el indicador o identificador.
    public String getNombreCategoria(int categoria){
    
        switch(categoria){
            case 1: return "Backend";
            case 2: return "Frontend";
            case 3: return "DevOps";
            case 4: return "UIX";
            case 5: return "QA";
        }
        return "";
    }
    

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPIngreso = new javax.swing.JPanel();
        jPPage1 = new javax.swing.JPanel();
        jInfPersonal = new javax.swing.JLabel();
        jPanelOfertasEmpleo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        seleccionados_list = new javax.swing.JList<>();
        atras_button = new javax.swing.JButton();
        jBackGround = new javax.swing.JLabel();
        jPanelLateral = new javax.swing.JPanel();
        jButtonClose = new javax.swing.JButton();
        jPanelSuperior = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPIngreso.setBackground(new java.awt.Color(3, 153, 129));
        jPIngreso.setPreferredSize(new java.awt.Dimension(950, 670));
        jPIngreso.setLayout(null);

        jPPage1.setBackground(new java.awt.Color(255, 255, 255));
        jPPage1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPPage1.setOpaque(false);
        jPPage1.setPreferredSize(new java.awt.Dimension(950, 670));
        jPPage1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jInfPersonal.setFont(new java.awt.Font("Dosis", 1, 36)); // NOI18N
        jInfPersonal.setText("Seleccionados");
        jPPage1.add(jInfPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, -1, 60));

        jPanelOfertasEmpleo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Berlin Sans FB", 0, 24), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanelOfertasEmpleo.setOpaque(false);
        jPanelOfertasEmpleo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        seleccionados_list.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        seleccionados_list.setForeground(new java.awt.Color(0, 102, 102));
        jScrollPane1.setViewportView(seleccionados_list);

        jPanelOfertasEmpleo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 630, 260));

        atras_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_circled_left_80px_1.png"))); // NOI18N
        atras_button.setBorderPainted(false);
        atras_button.setContentAreaFilled(false);
        atras_button.setFocusPainted(false);
        atras_button.setFocusable(false);
        atras_button.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_circled_left_80px.png"))); // NOI18N
        atras_button.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_circled_left_80px.png"))); // NOI18N
        atras_button.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_circled_left_80px.png"))); // NOI18N
        atras_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atras_buttonActionPerformed(evt);
            }
        });
        jPanelOfertasEmpleo.add(atras_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 210, 70, -1));

        jPPage1.add(jPanelOfertasEmpleo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 770, 320));

        jPIngreso.add(jPPage1);
        jPPage1.setBounds(0, 0, 950, 670);

        jBackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bg4.gif"))); // NOI18N
        jBackGround.setMaximumSize(new java.awt.Dimension(950, 650));
        jBackGround.setMinimumSize(new java.awt.Dimension(950, 650));
        jBackGround.setPreferredSize(new java.awt.Dimension(950, 700));
        jPIngreso.add(jBackGround);
        jBackGround.setBounds(0, 0, 950, 670);

        getContentPane().add(jPIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 950, 670));

        jPanelLateral.setBackground(new java.awt.Color(0, 51, 51));
        jPanelLateral.setPreferredSize(new java.awt.Dimension(50, 700));

        jButtonClose.setBackground(new java.awt.Color(0, 51, 51));
        jButtonClose.setForeground(new java.awt.Color(0, 51, 51));
        jButtonClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_close_window_70px.png"))); // NOI18N
        jButtonClose.setBorder(null);
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

        javax.swing.GroupLayout jPanelLateralLayout = new javax.swing.GroupLayout(jPanelLateral);
        jPanelLateral.setLayout(jPanelLateralLayout);
        jPanelLateralLayout.setHorizontalGroup(
            jPanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLateralLayout.createSequentialGroup()
                .addComponent(jButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLateralLayout.setVerticalGroup(
            jPanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLateralLayout.createSequentialGroup()
                .addContainerGap(609, Short.MAX_VALUE)
                .addComponent(jButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        getContentPane().add(jPanelLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 700));

        jPanelSuperior.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSuperior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
                .addContainerGap(894, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(24, 24, 24))
        );
        jPanelSuperiorLayout.setVerticalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSuperiorLayout.createSequentialGroup()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 950, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atras_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atras_buttonActionPerformed
        oeff.setVisible(true);
        dispose();
    }//GEN-LAST:event_atras_buttonActionPerformed

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        Dialogs d = new Dialogs(1);
        d.setVisible(true);
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setState(Formulario_Postulante_Info_Personal.ICONIFIED);
    }//GEN-LAST:event_jButton1ActionPerformed

    

    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atras_button;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jBackGround;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JLabel jInfPersonal;
    private javax.swing.JPanel jPIngreso;
    private javax.swing.JPanel jPPage1;
    private javax.swing.JPanel jPanelLateral;
    private javax.swing.JPanel jPanelOfertasEmpleo;
    private javax.swing.JPanel jPanelSuperior;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> seleccionados_list;
    // End of variables declaration//GEN-END:variables
}
