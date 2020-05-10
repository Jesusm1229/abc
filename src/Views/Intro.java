/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import javax.swing.BorderFactory;

/**
 *
 * @author Jesus Gonzalez FINAL Y CORREGIDO
 */

public class Intro extends javax.swing.JFrame {

    /**
     * Creates new form Intro
     */
    public Intro() {
        playMusic("src\\\\Music\\\\Liquid Sound 2.wav");
        initComponents();
        
        setLocationRelativeTo(null);
        getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelLogo = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("FrameLogo"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelLogo.setAlignmentX(0.0F);
        jPanelLogo.setAlignmentY(0.0F);
        jPanelLogo.setMaximumSize(new java.awt.Dimension(1000, 700));
        jPanelLogo.setMinimumSize(new java.awt.Dimension(1000, 700));
        jPanelLogo.setPreferredSize(new java.awt.Dimension(1000, 700));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo_UDO.mp4.gif"))); // NOI18N

        javax.swing.GroupLayout jPanelLogoLayout = new javax.swing.GroupLayout(jPanelLogo);
        jPanelLogo.setLayout(jPanelLogoLayout);
        jPanelLogoLayout.setHorizontalGroup(
            jPanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLogoLayout.createSequentialGroup()
                .addComponent(jLabel19)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelLogoLayout.setVerticalGroup(
            jPanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLogoLayout.createSequentialGroup()
                .addComponent(jLabel19)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

        public static void playMusic(String filepath)
    {
        InputStream music;
        try{
            music = new FileInputStream(new File(filepath));
            AudioStream audios = new AudioStream(music);
            AudioPlayer.player.start(audios);             
               
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"ERROR");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanelLogo;
    // End of variables declaration//GEN-END:variables
}


