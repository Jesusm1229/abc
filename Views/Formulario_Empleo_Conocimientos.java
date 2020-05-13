package Views;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import Controllers.Administracion_json;

public class Formulario_Empleo_Conocimientos extends javax.swing.JFrame {
        
    Connection connection;
    private int codContrato, id_ofertaempleo;
    private ArrayList<String> nivelesAcademicos = new ArrayList<String>();
    private ArrayList<String> especialidades = new ArrayList<String>();
    private ArrayList<String> tipoProyectos = new ArrayList<String>();
     
    public Formulario_Empleo_Conocimientos(int codContrato, Connection connection) {
        initComponents();
                
        setLocationRelativeTo(null);
        getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
                
        this.codContrato = codContrato;
        this.connection = connection;
        
        this.id_ofertaempleo = getIdOfertaTrabajoDatabase(codContrato);
        
        System.out.println("ID oferta de empleo: " + this.id_ofertaempleo);
        
        System.out.println(codContrato);
    }

    // Obtiene el id del postulante durante la aplicacion desde la base de datos.
    private int getIdOfertaTrabajoDatabase(int codContrato){
        
             int id_ofertatrabajo = 0;
              
             try {
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM oferta_empleo WHERE codcontrato = ?");
                
                ps.setInt(1, codContrato);
                
                ResultSet rs = ps.executeQuery();
                
                while(rs.next()){
                    id_ofertatrabajo = Integer.parseInt(rs.getString(1));
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Formulario_Postulante_Conocimientos.class.getName()).log(Level.SEVERE, null, ex);
            }
             
          return id_ofertatrabajo;
        }
          
        
    // Funcion para eliminar el empleo en la base de datos que no concluyo su registro.
        public void eliminarEmpleoDatabase(){
        
            // Vamos a eliminar toda la informacion referente al postulante que cancelo su registro.
            try {
                connection.prepareStatement("DELETE FROM `herramientas_ofertaempleo` WHERE `idoferta_empleo` = " + String.valueOf(id_ofertaempleo)).executeUpdate();
                
                connection.prepareStatement("DELETE FROM `certificaciones_ofertaempleo` WHERE `idoferta_empleo` = " + String.valueOf(id_ofertaempleo)).executeUpdate();
                
                connection.prepareStatement("DELETE FROM `lenguajes_ofertaempleo` WHERE `idoferta_empleo` = " + String.valueOf(id_ofertaempleo)).executeUpdate();
                
                connection.prepareStatement("DELETE FROM `oferta_empleo` WHERE `idoferta_empleo` = " + String.valueOf(id_ofertaempleo)).executeUpdate();
                
            } catch (SQLException ex) {
                Logger.getLogger(Administracion_json.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
      // Metodo para agregar los niveles academicos de la oferta de empleo.
      public void agregarNivelesAcademicos_OfertaEmpleo(){
    
        for(int counter = 0; counter < nivelesAcademicos.size(); counter++){
            try {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `nivelacademico_ofertaempleo` (`idnc_ofertaempleo`, `titulo`, `idoferta_empleo`) VALUES (NULL, ?, ?)");
                
                ps.setString(1, nivelesAcademicos.get(counter));
                ps.setInt(2, id_ofertaempleo);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Administracion_json.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
      
     // Metodo para agregar las especialidades de la oferta de empleo.
     public void agregarEspecialidades_OfertaEmpleo(){
    
        for(int counter = 0; counter < especialidades.size(); counter++){
            try {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `especialidades_ofertaempleo` (`id_especialidadoe`, `especialidad`, `idoferta_empleo`) VALUES (NULL, ?, ?)");
                
                ps.setString(1, especialidades.get(counter));
                ps.setInt(2, id_ofertaempleo);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Administracion_json.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     
    // Metodo para agregar los tipos de proyectos de la oferta de empleo.
    public void agregarTipoProyectos_OfertaEmpleo(){
    
         for(int counter = 0; counter < tipoProyectos.size(); counter++){
            try {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `proyectos_ofertaempleo` (`idproyecto`, `categoria`, `idoferta_empleo`) VALUES (NULL, ?, ?)");
                
                ps.setString(1, tipoProyectos.get(counter));
                ps.setInt(2, id_ofertaempleo);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Administracion_json.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void addHerramienta(String herramienta){
        jTextAreaHerramientas.setText(jTextAreaHerramientas.getText()+"\n"+herramienta);
    }
    
    public void addCertificacion(String certificacion){
        jTextAreaCertificaciones.setText(jTextAreaCertificaciones.getText()+"\n"+certificacion);
    }
        
    public void addCGeneral(String cgeneral){
        jTextAreaLenguaje.setText(jTextAreaLenguaje.getText()+"\n"+cgeneral);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GroupSexo = new javax.swing.ButtonGroup();
        GroupModalidad = new javax.swing.ButtonGroup();
        GroupDomicilio = new javax.swing.ButtonGroup();
        jPIngreso = new javax.swing.JPanel();
        jPPage1 = new javax.swing.JPanel();
        jInfPersonal = new javax.swing.JLabel();
        jPanelEspecialidad = new javax.swing.JPanel();
        jPanelComp = new javax.swing.JPanel();
        computacion = new javax.swing.JCheckBox();
        jPanelInfor = new javax.swing.JPanel();
        informatica = new javax.swing.JCheckBox();
        jPanelSistemas = new javax.swing.JPanel();
        sistemas = new javax.swing.JCheckBox();
        jPanelProyectoAcademico = new javax.swing.JPanel();
        jPanelNivel = new javax.swing.JPanel();
        jPanelBachiller = new javax.swing.JPanel();
        bachiller = new javax.swing.JCheckBox();
        jPanelLicenciado = new javax.swing.JPanel();
        licenciado = new javax.swing.JCheckBox();
        jPaneIngeniero = new javax.swing.JPanel();
        ingeniero = new javax.swing.JCheckBox();
        jPanelTSU = new javax.swing.JPanel();
        tsu = new javax.swing.JCheckBox();
        jPanelMagister = new javax.swing.JPanel();
        magister = new javax.swing.JCheckBox();
        jPanelDoctor = new javax.swing.JPanel();
        doctor = new javax.swing.JCheckBox();
        jPanelProyecto = new javax.swing.JPanel();
        jPanelBackend = new javax.swing.JPanel();
        backend = new javax.swing.JRadioButton();
        jPanelFrontend = new javax.swing.JPanel();
        frontend = new javax.swing.JRadioButton();
        jPanelQA = new javax.swing.JPanel();
        qa = new javax.swing.JRadioButton();
        jPanelUIX = new javax.swing.JPanel();
        uix = new javax.swing.JRadioButton();
        jPanelDev = new javax.swing.JPanel();
        devOps = new javax.swing.JRadioButton();
        jPanelHCL = new javax.swing.JPanel();
        jPanelHerramientas = new javax.swing.JPanel();
        jPanelCuadroHerramienta = new javax.swing.JPanel();
        jScrollPaneHerramientas = new javax.swing.JScrollPane();
        jTextAreaHerramientas = new javax.swing.JTextArea();
        AgregarHerramientas = new javax.swing.JButton();
        jPanelCertificaciones = new javax.swing.JPanel();
        jPanelCuadroCertificaciones = new javax.swing.JPanel();
        agregarCertificaciones1 = new javax.swing.JButton();
        jScrollPaneCertificaciones = new javax.swing.JScrollPane();
        jTextAreaCertificaciones = new javax.swing.JTextArea();
        jPanelLenguajes = new javax.swing.JPanel();
        jPanelCuadroLenguajes = new javax.swing.JPanel();
        jScrollPaneLenguajes = new javax.swing.JScrollPane();
        jTextAreaLenguaje = new javax.swing.JTextArea();
        agregarLenguajes = new javax.swing.JButton();
        jCancel = new javax.swing.JButton();
        jAcept = new javax.swing.JButton();
        jBackGround = new javax.swing.JLabel();
        jPanelSuperior = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanelLateral = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPIngreso.setBackground(new java.awt.Color(3, 153, 129));
        jPIngreso.setPreferredSize(new java.awt.Dimension(950, 670));
        jPIngreso.setLayout(null);

        jPPage1.setBackground(new java.awt.Color(255, 255, 255));
        jPPage1.setOpaque(false);
        jPPage1.setPreferredSize(new java.awt.Dimension(950, 670));
        jPPage1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jInfPersonal.setFont(new java.awt.Font("Dosis", 1, 36)); // NOI18N
        jInfPersonal.setText("Experiencia requerida");
        jPPage1.add(jInfPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, -1, 60));

        jPanelEspecialidad.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "especialidad", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanelEspecialidad.setOpaque(false);
        jPanelEspecialidad.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelComp.setMaximumSize(new java.awt.Dimension(80, 72));
        jPanelComp.setMinimumSize(new java.awt.Dimension(80, 72));
        jPanelComp.setOpaque(false);

        computacion.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        computacion.setForeground(new java.awt.Color(0, 153, 204));
        computacion.setText("Computacion");
        computacion.setBorder(null);
        computacion.setContentAreaFilled(false);
        computacion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        computacion.setFocusPainted(false);
        computacion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        computacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        computacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_workstation_50px_1.png"))); // NOI18N
        computacion.setMaximumSize(new java.awt.Dimension(80, 72));
        computacion.setMinimumSize(new java.awt.Dimension(80, 72));
        computacion.setPreferredSize(new java.awt.Dimension(80, 72));
        computacion.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_workstation_50px.png"))); // NOI18N
        computacion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        computacion.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                computacionMouseMoved(evt);
            }
        });
        computacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                computacionMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelCompLayout = new javax.swing.GroupLayout(jPanelComp);
        jPanelComp.setLayout(jPanelCompLayout);
        jPanelCompLayout.setHorizontalGroup(
            jPanelCompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
            .addGroup(jPanelCompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelCompLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(computacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanelCompLayout.setVerticalGroup(
            jPanelCompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 72, Short.MAX_VALUE)
            .addGroup(jPanelCompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelCompLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(computacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanelEspecialidad.add(jPanelComp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jPanelInfor.setMaximumSize(new java.awt.Dimension(80, 72));
        jPanelInfor.setMinimumSize(new java.awt.Dimension(80, 72));
        jPanelInfor.setOpaque(false);

        informatica.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        informatica.setForeground(new java.awt.Color(0, 153, 204));
        informatica.setText("Informática");
        informatica.setContentAreaFilled(false);
        informatica.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        informatica.setDoubleBuffered(true);
        informatica.setFocusPainted(false);
        informatica.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        informatica.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        informatica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_informatics_50px_1.png"))); // NOI18N
        informatica.setPreferredSize(new java.awt.Dimension(80, 72));
        informatica.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_informatics_50px_2.png"))); // NOI18N
        informatica.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        informatica.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                informaticaMouseMoved(evt);
            }
        });
        informatica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                informaticaMouseExited(evt);
            }
        });
        informatica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                informaticaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelInforLayout = new javax.swing.GroupLayout(jPanelInfor);
        jPanelInfor.setLayout(jPanelInforLayout);
        jPanelInforLayout.setHorizontalGroup(
            jPanelInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
            .addGroup(jPanelInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelInforLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(informatica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanelInforLayout.setVerticalGroup(
            jPanelInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 72, Short.MAX_VALUE)
            .addGroup(jPanelInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelInforLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(informatica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanelEspecialidad.add(jPanelInfor, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

        jPanelSistemas.setMaximumSize(new java.awt.Dimension(80, 72));
        jPanelSistemas.setMinimumSize(new java.awt.Dimension(80, 72));
        jPanelSistemas.setOpaque(false);

        sistemas.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        sistemas.setForeground(new java.awt.Color(0, 153, 204));
        sistemas.setText("Sistemas");
        sistemas.setContentAreaFilled(false);
        sistemas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sistemas.setDoubleBuffered(true);
        sistemas.setFocusPainted(false);
        sistemas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sistemas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sistemas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_working_with_a_laptop_50px_1.png"))); // NOI18N
        sistemas.setMaximumSize(new java.awt.Dimension(80, 72));
        sistemas.setMinimumSize(new java.awt.Dimension(80, 72));
        sistemas.setPreferredSize(new java.awt.Dimension(80, 72));
        sistemas.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_working_with_a_laptop_50px.png"))); // NOI18N
        sistemas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        sistemas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                sistemasMouseMoved(evt);
            }
        });
        sistemas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sistemasMouseExited(evt);
            }
        });
        sistemas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sistemasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSistemasLayout = new javax.swing.GroupLayout(jPanelSistemas);
        jPanelSistemas.setLayout(jPanelSistemasLayout);
        jPanelSistemasLayout.setHorizontalGroup(
            jPanelSistemasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
            .addGroup(jPanelSistemasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelSistemasLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(sistemas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanelSistemasLayout.setVerticalGroup(
            jPanelSistemasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 72, Short.MAX_VALUE)
            .addGroup(jPanelSistemasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelSistemasLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(sistemas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanelEspecialidad.add(jPanelSistemas, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        jPPage1.add(jPanelEspecialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 290, 110));

        jPanelProyectoAcademico.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanelProyectoAcademico.setOpaque(false);

        jPanelNivel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "nivel académico", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanelNivel.setOpaque(false);
        jPanelNivel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelBachiller.setAlignmentX(0.0F);
        jPanelBachiller.setAlignmentY(0.0F);
        jPanelBachiller.setMaximumSize(new java.awt.Dimension(80, 60));
        jPanelBachiller.setMinimumSize(new java.awt.Dimension(80, 60));
        jPanelBachiller.setOpaque(false);

        bachiller.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        bachiller.setForeground(new java.awt.Color(0, 153, 204));
        bachiller.setText("Bachiller");
        bachiller.setContentAreaFilled(false);
        bachiller.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bachiller.setDoubleBuffered(true);
        bachiller.setFocusPainted(false);
        bachiller.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bachiller.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bachiller.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/programmer.png"))); // NOI18N
        bachiller.setMaximumSize(new java.awt.Dimension(80, 60));
        bachiller.setMinimumSize(new java.awt.Dimension(80, 60));
        bachiller.setPreferredSize(new java.awt.Dimension(80, 60));
        bachiller.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/application.png"))); // NOI18N
        bachiller.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bachiller.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bachillerMouseMoved(evt);
            }
        });
        bachiller.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bachillerMouseExited(evt);
            }
        });
        bachiller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bachillerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBachillerLayout = new javax.swing.GroupLayout(jPanelBachiller);
        jPanelBachiller.setLayout(jPanelBachillerLayout);
        jPanelBachillerLayout.setHorizontalGroup(
            jPanelBachillerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
            .addGroup(jPanelBachillerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelBachillerLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(bachiller, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanelBachillerLayout.setVerticalGroup(
            jPanelBachillerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(jPanelBachillerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelBachillerLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(bachiller, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanelNivel.add(jPanelBachiller, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jPanelLicenciado.setAlignmentX(0.0F);
        jPanelLicenciado.setAlignmentY(0.0F);
        jPanelLicenciado.setMaximumSize(new java.awt.Dimension(80, 60));
        jPanelLicenciado.setMinimumSize(new java.awt.Dimension(80, 60));
        jPanelLicenciado.setOpaque(false);

        licenciado.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        licenciado.setForeground(new java.awt.Color(0, 153, 204));
        licenciado.setText("Licenciado");
        licenciado.setContentAreaFilled(false);
        licenciado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        licenciado.setDoubleBuffered(true);
        licenciado.setFocusPainted(false);
        licenciado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        licenciado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        licenciado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/student.png"))); // NOI18N
        licenciado.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/student (2).png"))); // NOI18N
        licenciado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        licenciado.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                licenciadoMouseMoved(evt);
            }
        });
        licenciado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                licenciadoMouseExited(evt);
            }
        });
        licenciado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                licenciadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLicenciadoLayout = new javax.swing.GroupLayout(jPanelLicenciado);
        jPanelLicenciado.setLayout(jPanelLicenciadoLayout);
        jPanelLicenciadoLayout.setHorizontalGroup(
            jPanelLicenciadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
            .addGroup(jPanelLicenciadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelLicenciadoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(licenciado, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanelLicenciadoLayout.setVerticalGroup(
            jPanelLicenciadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(jPanelLicenciadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelLicenciadoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(licenciado, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanelNivel.add(jPanelLicenciado, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        jPaneIngeniero.setAlignmentX(0.0F);
        jPaneIngeniero.setAlignmentY(0.0F);
        jPaneIngeniero.setMaximumSize(new java.awt.Dimension(80, 60));
        jPaneIngeniero.setMinimumSize(new java.awt.Dimension(80, 60));
        jPaneIngeniero.setOpaque(false);

        ingeniero.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        ingeniero.setForeground(new java.awt.Color(0, 153, 204));
        ingeniero.setText("Ingeniero");
        ingeniero.setContentAreaFilled(false);
        ingeniero.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ingeniero.setDoubleBuffered(true);
        ingeniero.setFocusPainted(false);
        ingeniero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ingeniero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ingeniero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/worker.png"))); // NOI18N
        ingeniero.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/worker (1).png"))); // NOI18N
        ingeniero.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ingeniero.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ingenieroMouseMoved(evt);
            }
        });
        ingeniero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ingenieroMouseExited(evt);
            }
        });
        ingeniero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingenieroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPaneIngenieroLayout = new javax.swing.GroupLayout(jPaneIngeniero);
        jPaneIngeniero.setLayout(jPaneIngenieroLayout);
        jPaneIngenieroLayout.setHorizontalGroup(
            jPaneIngenieroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
            .addGroup(jPaneIngenieroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPaneIngenieroLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(ingeniero, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPaneIngenieroLayout.setVerticalGroup(
            jPaneIngenieroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(jPaneIngenieroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPaneIngenieroLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(ingeniero, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanelNivel.add(jPaneIngeniero, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        jPanelTSU.setMaximumSize(new java.awt.Dimension(80, 60));
        jPanelTSU.setMinimumSize(new java.awt.Dimension(80, 60));
        jPanelTSU.setOpaque(false);

        tsu.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        tsu.setForeground(new java.awt.Color(0, 153, 204));
        tsu.setText("TSU");
        tsu.setContentAreaFilled(false);
        tsu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tsu.setDoubleBuffered(true);
        tsu.setFocusPainted(false);
        tsu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tsu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/professor.png"))); // NOI18N
        tsu.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/professor (1).png"))); // NOI18N
        tsu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tsu.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                tsuMouseMoved(evt);
            }
        });
        tsu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tsuMouseExited(evt);
            }
        });
        tsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tsuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTSULayout = new javax.swing.GroupLayout(jPanelTSU);
        jPanelTSU.setLayout(jPanelTSULayout);
        jPanelTSULayout.setHorizontalGroup(
            jPanelTSULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
            .addGroup(jPanelTSULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTSULayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(tsu, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanelTSULayout.setVerticalGroup(
            jPanelTSULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(jPanelTSULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTSULayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(tsu, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanelNivel.add(jPanelTSU, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jPanelMagister.setMaximumSize(new java.awt.Dimension(80, 60));
        jPanelMagister.setMinimumSize(new java.awt.Dimension(80, 60));
        jPanelMagister.setOpaque(false);

        magister.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        magister.setForeground(new java.awt.Color(0, 153, 204));
        magister.setText("Magister");
        magister.setContentAreaFilled(false);
        magister.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        magister.setDoubleBuffered(true);
        magister.setFocusPainted(false);
        magister.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        magister.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        magister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/technician.png"))); // NOI18N
        magister.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/professional.png"))); // NOI18N
        magister.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        magister.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                magisterMouseMoved(evt);
            }
        });
        magister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                magisterMouseExited(evt);
            }
        });
        magister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                magisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMagisterLayout = new javax.swing.GroupLayout(jPanelMagister);
        jPanelMagister.setLayout(jPanelMagisterLayout);
        jPanelMagisterLayout.setHorizontalGroup(
            jPanelMagisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
            .addGroup(jPanelMagisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelMagisterLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(magister, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanelMagisterLayout.setVerticalGroup(
            jPanelMagisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(jPanelMagisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelMagisterLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(magister, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanelNivel.add(jPanelMagister, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        jPanelDoctor.setMaximumSize(new java.awt.Dimension(80, 60));
        jPanelDoctor.setMinimumSize(new java.awt.Dimension(80, 60));
        jPanelDoctor.setOpaque(false);

        doctor.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        doctor.setForeground(new java.awt.Color(0, 153, 204));
        doctor.setText("Doctor");
        doctor.setContentAreaFilled(false);
        doctor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        doctor.setDoubleBuffered(true);
        doctor.setFocusPainted(false);
        doctor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        doctor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        doctor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/professor (2).png"))); // NOI18N
        doctor.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/professor (3).png"))); // NOI18N
        doctor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        doctor.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                doctorMouseMoved(evt);
            }
        });
        doctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                doctorMouseExited(evt);
            }
        });
        doctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDoctorLayout = new javax.swing.GroupLayout(jPanelDoctor);
        jPanelDoctor.setLayout(jPanelDoctorLayout);
        jPanelDoctorLayout.setHorizontalGroup(
            jPanelDoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
            .addGroup(jPanelDoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelDoctorLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(doctor, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanelDoctorLayout.setVerticalGroup(
            jPanelDoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(jPanelDoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelDoctorLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(doctor, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanelNivel.add(jPanelDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, -1, -1));

        jPanelProyecto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "tipo de proyecto", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanelProyecto.setOpaque(false);
        jPanelProyecto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelBackend.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelBackend.setOpaque(false);
        jPanelBackend.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanelBackendMouseMoved(evt);
            }
        });
        jPanelBackend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelBackendMouseExited(evt);
            }
        });

        backend.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        backend.setForeground(new java.awt.Color(0, 153, 204));
        backend.setText("Backend");
        backend.setContentAreaFilled(false);
        backend.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        backend.setDoubleBuffered(true);
        backend.setFocusPainted(false);
        backend.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backend.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        backend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/backend.png"))); // NOI18N
        backend.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/backend (1).png"))); // NOI18N
        backend.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        backend.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                backendMouseMoved(evt);
            }
        });
        backend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backendMouseExited(evt);
            }
        });
        backend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBackendLayout = new javax.swing.GroupLayout(jPanelBackend);
        jPanelBackend.setLayout(jPanelBackendLayout);
        jPanelBackendLayout.setHorizontalGroup(
            jPanelBackendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
            .addGroup(jPanelBackendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelBackendLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(backend, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanelBackendLayout.setVerticalGroup(
            jPanelBackendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(jPanelBackendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelBackendLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(backend, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanelProyecto.add(jPanelBackend, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, 60));

        jPanelFrontend.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelFrontend.setOpaque(false);
        jPanelFrontend.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanelFrontendMouseMoved(evt);
            }
        });
        jPanelFrontend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelFrontendMouseExited(evt);
            }
        });

        frontend.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        frontend.setForeground(new java.awt.Color(0, 153, 204));
        frontend.setText("Frontend");
        frontend.setContentAreaFilled(false);
        frontend.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        frontend.setDoubleBuffered(true);
        frontend.setFocusPainted(false);
        frontend.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        frontend.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        frontend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/design.png"))); // NOI18N
        frontend.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/design(1).png"))); // NOI18N
        frontend.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        frontend.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                frontendMouseMoved(evt);
            }
        });
        frontend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                frontendMouseExited(evt);
            }
        });
        frontend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frontendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFrontendLayout = new javax.swing.GroupLayout(jPanelFrontend);
        jPanelFrontend.setLayout(jPanelFrontendLayout);
        jPanelFrontendLayout.setHorizontalGroup(
            jPanelFrontendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
            .addGroup(jPanelFrontendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelFrontendLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(frontend, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanelFrontendLayout.setVerticalGroup(
            jPanelFrontendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(jPanelFrontendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelFrontendLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(frontend, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanelProyecto.add(jPanelFrontend, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 80, 60));

        jPanelQA.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelQA.setOpaque(false);
        jPanelQA.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanelQAMouseMoved(evt);
            }
        });
        jPanelQA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelQAMouseExited(evt);
            }
        });

        qa.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        qa.setForeground(new java.awt.Color(0, 153, 204));
        qa.setText("Q/A");
        qa.setContentAreaFilled(false);
        qa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        qa.setDoubleBuffered(true);
        qa.setFocusPainted(false);
        qa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        qa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        qa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/qa.png"))); // NOI18N
        qa.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/qa (2).png"))); // NOI18N
        qa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        qa.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                qaMouseMoved(evt);
            }
        });
        qa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                qaMouseExited(evt);
            }
        });
        qa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelQALayout = new javax.swing.GroupLayout(jPanelQA);
        jPanelQA.setLayout(jPanelQALayout);
        jPanelQALayout.setHorizontalGroup(
            jPanelQALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
            .addGroup(jPanelQALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelQALayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(qa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanelQALayout.setVerticalGroup(
            jPanelQALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(jPanelQALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelQALayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(qa, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanelProyecto.add(jPanelQA, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 80, 60));

        jPanelUIX.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelUIX.setOpaque(false);
        jPanelUIX.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanelUIXMouseMoved(evt);
            }
        });
        jPanelUIX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelUIXMouseExited(evt);
            }
        });

        uix.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        uix.setForeground(new java.awt.Color(0, 153, 204));
        uix.setText("UI-UX");
        uix.setContentAreaFilled(false);
        uix.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        uix.setDoubleBuffered(true);
        uix.setFocusPainted(false);
        uix.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        uix.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        uix.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ux (1).png"))); // NOI18N
        uix.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ux.png"))); // NOI18N
        uix.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        uix.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                uixMouseMoved(evt);
            }
        });
        uix.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                uixMouseExited(evt);
            }
        });
        uix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uixActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelUIXLayout = new javax.swing.GroupLayout(jPanelUIX);
        jPanelUIX.setLayout(jPanelUIXLayout);
        jPanelUIXLayout.setHorizontalGroup(
            jPanelUIXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
            .addGroup(jPanelUIXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelUIXLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(uix, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanelUIXLayout.setVerticalGroup(
            jPanelUIXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(jPanelUIXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelUIXLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(uix, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanelProyecto.add(jPanelUIX, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 80, 60));

        jPanelDev.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelDev.setOpaque(false);
        jPanelDev.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanelDevMouseMoved(evt);
            }
        });
        jPanelDev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelDevMouseExited(evt);
            }
        });

        devOps.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        devOps.setForeground(new java.awt.Color(0, 153, 204));
        devOps.setText("DevOps");
        devOps.setContentAreaFilled(false);
        devOps.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        devOps.setDoubleBuffered(true);
        devOps.setFocusPainted(false);
        devOps.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        devOps.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        devOps.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/strategy.png"))); // NOI18N
        devOps.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/strategy (1).png"))); // NOI18N
        devOps.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        devOps.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                devOpsMouseMoved(evt);
            }
        });
        devOps.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                devOpsMouseExited(evt);
            }
        });
        devOps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devOpsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDevLayout = new javax.swing.GroupLayout(jPanelDev);
        jPanelDev.setLayout(jPanelDevLayout);
        jPanelDevLayout.setHorizontalGroup(
            jPanelDevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
            .addGroup(jPanelDevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelDevLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(devOps, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanelDevLayout.setVerticalGroup(
            jPanelDevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(jPanelDevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelDevLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(devOps, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanelProyecto.add(jPanelDev, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 80, 60));

        javax.swing.GroupLayout jPanelProyectoAcademicoLayout = new javax.swing.GroupLayout(jPanelProyectoAcademico);
        jPanelProyectoAcademico.setLayout(jPanelProyectoAcademicoLayout);
        jPanelProyectoAcademicoLayout.setHorizontalGroup(
            jPanelProyectoAcademicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProyectoAcademicoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProyectoAcademicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelNivel, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .addComponent(jPanelProyecto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelProyectoAcademicoLayout.setVerticalGroup(
            jPanelProyectoAcademicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProyectoAcademicoLayout.createSequentialGroup()
                .addComponent(jPanelNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        jPPage1.add(jPanelProyectoAcademico, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 290, 340));

        jPanelHCL.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanelHCL.setOpaque(false);
        jPanelHCL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelHerramientas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "herramientas de programación", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanelHerramientas.setOpaque(false);

        jPanelCuadroHerramienta.setMaximumSize(new java.awt.Dimension(330, 100));
        jPanelCuadroHerramienta.setMinimumSize(new java.awt.Dimension(330, 100));
        jPanelCuadroHerramienta.setOpaque(false);

        jTextAreaHerramientas.setEditable(false);
        jTextAreaHerramientas.setColumns(20);
        jTextAreaHerramientas.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jTextAreaHerramientas.setForeground(new java.awt.Color(0, 153, 240));
        jTextAreaHerramientas.setRows(5);
        jTextAreaHerramientas.setAlignmentX(0.0F);
        jTextAreaHerramientas.setAlignmentY(0.0F);
        jTextAreaHerramientas.setMaximumSize(new java.awt.Dimension(250, 79));
        jTextAreaHerramientas.setMinimumSize(new java.awt.Dimension(244, 79));
        jScrollPaneHerramientas.setViewportView(jTextAreaHerramientas);

        AgregarHerramientas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_plus_50px.png"))); // NOI18N
        AgregarHerramientas.setBorder(null);
        AgregarHerramientas.setContentAreaFilled(false);
        AgregarHerramientas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AgregarHerramientas.setFocusPainted(false);
        AgregarHerramientas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_plus_2_math_50px.png"))); // NOI18N
        AgregarHerramientas.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_plus_2_math_50px.png"))); // NOI18N
        AgregarHerramientas.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_plus_2_math_50px.png"))); // NOI18N
        AgregarHerramientas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarHerramientasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCuadroHerramientaLayout = new javax.swing.GroupLayout(jPanelCuadroHerramienta);
        jPanelCuadroHerramienta.setLayout(jPanelCuadroHerramientaLayout);
        jPanelCuadroHerramientaLayout.setHorizontalGroup(
            jPanelCuadroHerramientaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCuadroHerramientaLayout.createSequentialGroup()
                .addComponent(jScrollPaneHerramientas, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AgregarHerramientas)
                .addContainerGap())
        );
        jPanelCuadroHerramientaLayout.setVerticalGroup(
            jPanelCuadroHerramientaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCuadroHerramientaLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(AgregarHerramientas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelCuadroHerramientaLayout.createSequentialGroup()
                .addComponent(jScrollPaneHerramientas, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelHerramientasLayout = new javax.swing.GroupLayout(jPanelHerramientas);
        jPanelHerramientas.setLayout(jPanelHerramientasLayout);
        jPanelHerramientasLayout.setHorizontalGroup(
            jPanelHerramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHerramientasLayout.createSequentialGroup()
                .addGap(0, 4, Short.MAX_VALUE)
                .addComponent(jPanelCuadroHerramienta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelHerramientasLayout.setVerticalGroup(
            jPanelHerramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHerramientasLayout.createSequentialGroup()
                .addComponent(jPanelCuadroHerramienta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jPanelHCL.add(jPanelHerramientas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 350, 140));

        jPanelCertificaciones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "certificaciones extras", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanelCertificaciones.setOpaque(false);
        jPanelCertificaciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelCuadroCertificaciones.setMaximumSize(new java.awt.Dimension(330, 100));
        jPanelCuadroCertificaciones.setMinimumSize(new java.awt.Dimension(330, 100));
        jPanelCuadroCertificaciones.setOpaque(false);

        agregarCertificaciones1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_plus_50px.png"))); // NOI18N
        agregarCertificaciones1.setToolTipText("");
        agregarCertificaciones1.setBorder(null);
        agregarCertificaciones1.setContentAreaFilled(false);
        agregarCertificaciones1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        agregarCertificaciones1.setFocusPainted(false);
        agregarCertificaciones1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_plus_2_math_50px.png"))); // NOI18N
        agregarCertificaciones1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_plus_2_math_50px.png"))); // NOI18N
        agregarCertificaciones1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_plus_2_math_50px.png"))); // NOI18N
        agregarCertificaciones1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarCertificaciones1ActionPerformed(evt);
            }
        });

        jScrollPaneCertificaciones.setAlignmentX(0.0F);
        jScrollPaneCertificaciones.setAlignmentY(0.0F);
        jScrollPaneCertificaciones.setMaximumSize(new java.awt.Dimension(244, 79));
        jScrollPaneCertificaciones.setMinimumSize(new java.awt.Dimension(244, 79));
        jScrollPaneCertificaciones.setPreferredSize(new java.awt.Dimension(244, 79));

        jTextAreaCertificaciones.setEditable(false);
        jTextAreaCertificaciones.setColumns(20);
        jTextAreaCertificaciones.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jTextAreaCertificaciones.setForeground(new java.awt.Color(0, 153, 240));
        jTextAreaCertificaciones.setRows(5);
        jTextAreaCertificaciones.setAlignmentX(0.0F);
        jTextAreaCertificaciones.setAlignmentY(0.0F);
        jTextAreaCertificaciones.setMaximumSize(new java.awt.Dimension(250, 79));
        jTextAreaCertificaciones.setMinimumSize(new java.awt.Dimension(244, 79));
        jScrollPaneCertificaciones.setViewportView(jTextAreaCertificaciones);

        javax.swing.GroupLayout jPanelCuadroCertificacionesLayout = new javax.swing.GroupLayout(jPanelCuadroCertificaciones);
        jPanelCuadroCertificaciones.setLayout(jPanelCuadroCertificacionesLayout);
        jPanelCuadroCertificacionesLayout.setHorizontalGroup(
            jPanelCuadroCertificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCuadroCertificacionesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPaneCertificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(agregarCertificaciones1)
                .addContainerGap())
        );
        jPanelCuadroCertificacionesLayout.setVerticalGroup(
            jPanelCuadroCertificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCuadroCertificacionesLayout.createSequentialGroup()
                .addGap(20, 30, Short.MAX_VALUE)
                .addComponent(agregarCertificaciones1)
                .addGap(30, 30, 30))
            .addComponent(jScrollPaneCertificaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelCertificaciones.add(jPanelCuadroCertificaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 110));

        jPanelHCL.add(jPanelCertificaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 350, 150));

        jPanelLenguajes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "lenguajes de programación", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanelLenguajes.setOpaque(false);
        jPanelLenguajes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelCuadroLenguajes.setMaximumSize(new java.awt.Dimension(330, 100));
        jPanelCuadroLenguajes.setMinimumSize(new java.awt.Dimension(330, 100));
        jPanelCuadroLenguajes.setOpaque(false);

        jScrollPaneLenguajes.setMaximumSize(new java.awt.Dimension(244, 79));
        jScrollPaneLenguajes.setMinimumSize(new java.awt.Dimension(244, 79));
        jScrollPaneLenguajes.setPreferredSize(new java.awt.Dimension(244, 79));

        jTextAreaLenguaje.setEditable(false);
        jTextAreaLenguaje.setColumns(20);
        jTextAreaLenguaje.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jTextAreaLenguaje.setForeground(new java.awt.Color(0, 153, 240));
        jTextAreaLenguaje.setRows(5);
        jTextAreaLenguaje.setAlignmentX(0.0F);
        jTextAreaLenguaje.setAlignmentY(0.0F);
        jTextAreaLenguaje.setMaximumSize(new java.awt.Dimension(250, 79));
        jTextAreaLenguaje.setMinimumSize(new java.awt.Dimension(244, 79));
        jScrollPaneLenguajes.setViewportView(jTextAreaLenguaje);

        agregarLenguajes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_plus_50px.png"))); // NOI18N
        agregarLenguajes.setToolTipText("");
        agregarLenguajes.setBorder(null);
        agregarLenguajes.setContentAreaFilled(false);
        agregarLenguajes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        agregarLenguajes.setFocusPainted(false);
        agregarLenguajes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_plus_2_math_50px.png"))); // NOI18N
        agregarLenguajes.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_plus_2_math_50px.png"))); // NOI18N
        agregarLenguajes.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_plus_2_math_50px.png"))); // NOI18N
        agregarLenguajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarLenguajesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCuadroLenguajesLayout = new javax.swing.GroupLayout(jPanelCuadroLenguajes);
        jPanelCuadroLenguajes.setLayout(jPanelCuadroLenguajesLayout);
        jPanelCuadroLenguajesLayout.setHorizontalGroup(
            jPanelCuadroLenguajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCuadroLenguajesLayout.createSequentialGroup()
                .addComponent(jScrollPaneLenguajes, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(agregarLenguajes)
                .addContainerGap())
        );
        jPanelCuadroLenguajesLayout.setVerticalGroup(
            jPanelCuadroLenguajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCuadroLenguajesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(agregarLenguajes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCuadroLenguajesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPaneLenguajes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelLenguajes.add(jPanelCuadroLenguajes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jPanelHCL.add(jPanelLenguajes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 350, 140));

        jPPage1.add(jPanelHCL, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 370, 450));

        jCancel.setBackground(new java.awt.Color(0, 51, 51));
        jCancel.setForeground(new java.awt.Color(0, 51, 51));
        jCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_unavailable_80px.png"))); // NOI18N
        jCancel.setBorder(null);
        jCancel.setBorderPainted(false);
        jCancel.setContentAreaFilled(false);
        jCancel.setPreferredSize(new java.awt.Dimension(40, 40));
        jCancel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_unavailable_80px_1.png"))); // NOI18N
        jCancel.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_unavailable_80px_1.png"))); // NOI18N
        jCancel.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_unavailable_80px_1.png"))); // NOI18N
        jCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelActionPerformed(evt);
            }
        });
        jPPage1.add(jCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 500, 60, 60));

        jAcept.setBackground(new java.awt.Color(0, 51, 51));
        jAcept.setForeground(new java.awt.Color(0, 51, 51));
        jAcept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_approval_80px.png"))); // NOI18N
        jAcept.setBorder(null);
        jAcept.setBorderPainted(false);
        jAcept.setContentAreaFilled(false);
        jAcept.setPreferredSize(new java.awt.Dimension(40, 40));
        jAcept.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_approval_80px_1.png"))); // NOI18N
        jAcept.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_approval_80px_1.png"))); // NOI18N
        jAcept.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_approval_80px_1.png"))); // NOI18N
        jAcept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAceptActionPerformed(evt);
            }
        });
        jPPage1.add(jAcept, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 420, 60, 60));

        jBackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bg2.gif"))); // NOI18N
        jPPage1.add(jBackGround, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPIngreso.add(jPPage1);
        jPPage1.setBounds(0, 0, 950, 670);

        getContentPane().add(jPIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 950, 670));

        jPanelSuperior.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSuperior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSuperior.setPreferredSize(new java.awt.Dimension(950, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_minimize_window_30px.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        jPanelLateral.setBackground(new java.awt.Color(0, 51, 51));
        jPanelLateral.setPreferredSize(new java.awt.Dimension(50, 700));

        javax.swing.GroupLayout jPanelLateralLayout = new javax.swing.GroupLayout(jPanelLateral);
        jPanelLateral.setLayout(jPanelLateralLayout);
        jPanelLateralLayout.setHorizontalGroup(
            jPanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanelLateralLayout.setVerticalGroup(
            jPanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setState(Formulario_Postulante_Info_Personal.ICONIFIED);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void computacionMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_computacionMouseMoved
        jPanelComp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,204)));
    }//GEN-LAST:event_computacionMouseMoved

    private void computacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_computacionMouseExited
        jPanelComp.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
    }//GEN-LAST:event_computacionMouseExited

    private void informaticaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_informaticaMouseMoved
        jPanelInfor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,204)));
    }//GEN-LAST:event_informaticaMouseMoved

    private void informaticaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_informaticaMouseExited
        jPanelInfor.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
    }//GEN-LAST:event_informaticaMouseExited

    private void informaticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informaticaActionPerformed

    }//GEN-LAST:event_informaticaActionPerformed

    private void sistemasMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sistemasMouseMoved
        jPanelSistemas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,204)));
    }//GEN-LAST:event_sistemasMouseMoved

    private void sistemasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sistemasMouseExited
        jPanelSistemas.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
    }//GEN-LAST:event_sistemasMouseExited

    private void sistemasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sistemasActionPerformed

    }//GEN-LAST:event_sistemasActionPerformed

    private void bachillerMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bachillerMouseMoved
        jPanelBachiller.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,204)));
    }//GEN-LAST:event_bachillerMouseMoved

    private void bachillerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bachillerMouseExited
        jPanelBachiller.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
    }//GEN-LAST:event_bachillerMouseExited

    private void bachillerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bachillerActionPerformed

    }//GEN-LAST:event_bachillerActionPerformed

    private void licenciadoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_licenciadoMouseMoved
        jPanelLicenciado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,204)));
    }//GEN-LAST:event_licenciadoMouseMoved

    private void licenciadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_licenciadoMouseExited
        jPanelLicenciado.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));        // TODO add your handling code here:
    }//GEN-LAST:event_licenciadoMouseExited

    private void licenciadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_licenciadoActionPerformed

    }//GEN-LAST:event_licenciadoActionPerformed

    private void ingenieroMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingenieroMouseMoved
        jPaneIngeniero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,204)));
    }//GEN-LAST:event_ingenieroMouseMoved

    private void ingenieroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingenieroMouseExited
        jPaneIngeniero.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
    }//GEN-LAST:event_ingenieroMouseExited

    private void ingenieroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingenieroActionPerformed

    }//GEN-LAST:event_ingenieroActionPerformed

    private void tsuMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tsuMouseMoved
        jPanelTSU.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,204)));
    }//GEN-LAST:event_tsuMouseMoved

    private void tsuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tsuMouseExited
        jPanelTSU.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
    }//GEN-LAST:event_tsuMouseExited

    private void tsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tsuActionPerformed

    }//GEN-LAST:event_tsuActionPerformed

    private void magisterMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_magisterMouseMoved
        jPanelMagister.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,204)));
    }//GEN-LAST:event_magisterMouseMoved

    private void magisterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_magisterMouseExited
        jPanelMagister.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
    }//GEN-LAST:event_magisterMouseExited

    private void magisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_magisterActionPerformed

    }//GEN-LAST:event_magisterActionPerformed

    private void doctorMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctorMouseMoved
        jPanelDoctor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,204)));
    }//GEN-LAST:event_doctorMouseMoved

    private void doctorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctorMouseExited
        jPanelDoctor.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
    }//GEN-LAST:event_doctorMouseExited

    private void doctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorActionPerformed

    }//GEN-LAST:event_doctorActionPerformed

    private void backendMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backendMouseMoved
        jPanelBackend.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,204)));
    }//GEN-LAST:event_backendMouseMoved

    private void backendMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backendMouseExited
        jPanelBackend.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
    }//GEN-LAST:event_backendMouseExited

    private void backendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backendActionPerformed

    }//GEN-LAST:event_backendActionPerformed

    private void jPanelBackendMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelBackendMouseMoved
        jPanelBackend.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,204)));
    }//GEN-LAST:event_jPanelBackendMouseMoved

    private void jPanelBackendMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelBackendMouseExited
        jPanelBackend.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
    }//GEN-LAST:event_jPanelBackendMouseExited

    private void frontendMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frontendMouseMoved
        jPanelFrontend.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,204)));
    }//GEN-LAST:event_frontendMouseMoved

    private void frontendMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frontendMouseExited
        jPanelFrontend.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
    }//GEN-LAST:event_frontendMouseExited

    private void frontendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frontendActionPerformed

    }//GEN-LAST:event_frontendActionPerformed

    private void jPanelFrontendMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelFrontendMouseMoved
        jPanelFrontend.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,204)));
    }//GEN-LAST:event_jPanelFrontendMouseMoved

    private void jPanelFrontendMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelFrontendMouseExited
        jPanelFrontend.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
    }//GEN-LAST:event_jPanelFrontendMouseExited

    private void qaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qaMouseMoved
        jPanelQA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,204)));
    }//GEN-LAST:event_qaMouseMoved

    private void qaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qaMouseExited
        jPanelQA.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
    }//GEN-LAST:event_qaMouseExited

    private void qaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qaActionPerformed

    }//GEN-LAST:event_qaActionPerformed

    private void jPanelQAMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelQAMouseMoved
        jPanelQA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,204)));
    }//GEN-LAST:event_jPanelQAMouseMoved

    private void jPanelQAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelQAMouseExited
        jPanelQA.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
    }//GEN-LAST:event_jPanelQAMouseExited

    private void uixMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uixMouseMoved
        jPanelUIX.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,204)));
    }//GEN-LAST:event_uixMouseMoved

    private void uixMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uixMouseExited
        jPanelUIX.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
    }//GEN-LAST:event_uixMouseExited

    private void uixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uixActionPerformed

    }//GEN-LAST:event_uixActionPerformed

    private void jPanelUIXMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelUIXMouseMoved
        jPanelUIX.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,204)));
    }//GEN-LAST:event_jPanelUIXMouseMoved

    private void jPanelUIXMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelUIXMouseExited
        jPanelUIX.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
    }//GEN-LAST:event_jPanelUIXMouseExited

    private void devOpsMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_devOpsMouseMoved
        jPanelDev.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,204)));
    }//GEN-LAST:event_devOpsMouseMoved

    private void devOpsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_devOpsMouseExited
        jPanelDev.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
    }//GEN-LAST:event_devOpsMouseExited

    private void devOpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devOpsActionPerformed

    }//GEN-LAST:event_devOpsActionPerformed

    private void jPanelDevMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelDevMouseMoved
        jPanelDev.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,204)));
    }//GEN-LAST:event_jPanelDevMouseMoved

    private void jPanelDevMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelDevMouseExited
        jPanelDev.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
    }//GEN-LAST:event_jPanelDevMouseExited

    private void AgregarHerramientasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarHerramientasActionPerformed
        ToSendDatabaseEmpleoFrame tsdf = new ToSendDatabaseEmpleoFrame(this, id_ofertaempleo, 1, connection);
        tsdf.setVisible(true);
    }//GEN-LAST:event_AgregarHerramientasActionPerformed

    private void agregarCertificaciones1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarCertificaciones1ActionPerformed
        ToSendDatabaseEmpleoFrame tsdf = new ToSendDatabaseEmpleoFrame(this, id_ofertaempleo, 2, connection);
        tsdf.setVisible(true);
    }//GEN-LAST:event_agregarCertificaciones1ActionPerformed

    private void agregarLenguajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarLenguajesActionPerformed
        // TODO add your handling code here:
        ToSendDatabaseEmpleoFrame tsdf = new ToSendDatabaseEmpleoFrame(this, id_ofertaempleo, 3, connection);
        tsdf.setVisible(true);
    }//GEN-LAST:event_agregarLenguajesActionPerformed

    private void jCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelActionPerformed
        Dialogs d = new Dialogs(2);
        d.setVisible(true);
   
        if(d.getState() == true)
        {   // Aca vamos a cancelar el Registro del Empleo y haremos una eliminacion de los datos ingresados previamente.
            eliminarEmpleoDatabase();   
            Menu_Principal mp = new Menu_Principal(connection);
            mp.setVisible(true);
        }
    }//GEN-LAST:event_jCancelActionPerformed

    private void jAceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAceptActionPerformed
        Dialogs d;
        // Niveles Academicos.
        if(bachiller.isSelected()) nivelesAcademicos.add("Bachiller");
        if(licenciado.isSelected()) nivelesAcademicos.add("Licenciado");
        if(ingeniero.isSelected()) nivelesAcademicos.add("Ingeniero");
        if(tsu.isSelected()) nivelesAcademicos.add("Tecnico Superior");
        if(magister.isSelected()) nivelesAcademicos.add("Magister");
        if(doctor.isSelected()) nivelesAcademicos.add("Doctor");

        //Especialidades.
        if(computacion.isSelected()) especialidades.add("Computacion");
        if(informatica.isSelected()) especialidades.add("Informatica");
        if(sistemas.isSelected()) especialidades.add("Sistemas");

        //Tipo de Proyecto.
        if(backend.isSelected()) tipoProyectos.add("Backend");
        if(frontend.isSelected()) tipoProyectos.add("Frontend");
        if(uix.isSelected()) tipoProyectos.add("UIX");
        if(devOps.isSelected()) tipoProyectos.add("DevOps");
        if(qa.isSelected()) tipoProyectos.add("Q/A");

        if(nivelesAcademicos.isEmpty() || especialidades.isEmpty() || tipoProyectos.isEmpty() || jTextAreaCertificaciones.getText().equals("") || jTextAreaHerramientas.getText().equals("") || jTextAreaLenguaje.getText().equals("")){
            nivelesAcademicos.clear();
            especialidades.clear();
            tipoProyectos.clear();
            d = new Dialogs(6); //FORMULARIO INCOMPLETO
            d.setVisible(true);
            return;
        }

        agregarNivelesAcademicos_OfertaEmpleo();
        agregarEspecialidades_OfertaEmpleo();
        agregarTipoProyectos_OfertaEmpleo();

        d = new Dialogs(10);//Oferta de empleo cargada Correctamente
        d.setVisible(true);

        
        Menu_Principal mp = new Menu_Principal(connection);
        mp.setVisible(true);
        dispose();
    }//GEN-LAST:event_jAceptActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarHerramientas;
    private javax.swing.ButtonGroup GroupDomicilio;
    private javax.swing.ButtonGroup GroupModalidad;
    private javax.swing.ButtonGroup GroupSexo;
    private javax.swing.JButton agregarCertificaciones1;
    private javax.swing.JButton agregarLenguajes;
    private javax.swing.JCheckBox bachiller;
    private javax.swing.JRadioButton backend;
    private javax.swing.JCheckBox computacion;
    private javax.swing.JRadioButton devOps;
    private javax.swing.JCheckBox doctor;
    private javax.swing.JRadioButton frontend;
    private javax.swing.JCheckBox informatica;
    private javax.swing.JCheckBox ingeniero;
    private javax.swing.JButton jAcept;
    private javax.swing.JLabel jBackGround;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jCancel;
    private javax.swing.JLabel jInfPersonal;
    private javax.swing.JPanel jPIngreso;
    private javax.swing.JPanel jPPage1;
    private javax.swing.JPanel jPaneIngeniero;
    private javax.swing.JPanel jPanelBachiller;
    private javax.swing.JPanel jPanelBackend;
    private javax.swing.JPanel jPanelCertificaciones;
    private javax.swing.JPanel jPanelComp;
    private javax.swing.JPanel jPanelCuadroCertificaciones;
    private javax.swing.JPanel jPanelCuadroHerramienta;
    private javax.swing.JPanel jPanelCuadroLenguajes;
    private javax.swing.JPanel jPanelDev;
    private javax.swing.JPanel jPanelDoctor;
    private javax.swing.JPanel jPanelEspecialidad;
    private javax.swing.JPanel jPanelFrontend;
    private javax.swing.JPanel jPanelHCL;
    private javax.swing.JPanel jPanelHerramientas;
    private javax.swing.JPanel jPanelInfor;
    private javax.swing.JPanel jPanelLateral;
    private javax.swing.JPanel jPanelLenguajes;
    private javax.swing.JPanel jPanelLicenciado;
    private javax.swing.JPanel jPanelMagister;
    private javax.swing.JPanel jPanelNivel;
    private javax.swing.JPanel jPanelProyecto;
    private javax.swing.JPanel jPanelProyectoAcademico;
    private javax.swing.JPanel jPanelQA;
    private javax.swing.JPanel jPanelSistemas;
    private javax.swing.JPanel jPanelSuperior;
    private javax.swing.JPanel jPanelTSU;
    private javax.swing.JPanel jPanelUIX;
    private javax.swing.JScrollPane jScrollPaneCertificaciones;
    private javax.swing.JScrollPane jScrollPaneHerramientas;
    private javax.swing.JScrollPane jScrollPaneLenguajes;
    private javax.swing.JTextArea jTextAreaCertificaciones;
    private javax.swing.JTextArea jTextAreaHerramientas;
    private javax.swing.JTextArea jTextAreaLenguaje;
    private javax.swing.JCheckBox licenciado;
    private javax.swing.JCheckBox magister;
    private javax.swing.JRadioButton qa;
    private javax.swing.JCheckBox sistemas;
    private javax.swing.JCheckBox tsu;
    private javax.swing.JRadioButton uix;
    // End of variables declaration//GEN-END:variables
}
