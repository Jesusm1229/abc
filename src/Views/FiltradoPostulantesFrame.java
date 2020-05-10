/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.Administracion_json;
import Controllers.Puntajes_EAP;
import Models.*;
import java.awt.Color;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;
import javax.swing.*;

/**
 *
 * @author Jesus Gonzalez
 */
public class FiltradoPostulantesFrame extends javax.swing.JFrame {
    
    public int id_ofertaEmpleo;
    public Connection connection;
    public Empleo empleo;
    public List<Integer> id_postulantes = new ArrayList();
    public List<String> postulantesSeleccionados = new ArrayList();
    public List<Integer> idpostulantesSeleccionados = new ArrayList();
    Menu_Principal menuframe;
    private int option;
  
        
    public FiltradoPostulantesFrame(Connection connection, Menu_Principal menuframe, int id_ofertaEmpleo, int option) {
               
        initComponents();  
        
        this.option = option;
        visualizarEvaluacionBoton(option);
        this.menuframe = menuframe;
        this.id_ofertaEmpleo = id_ofertaEmpleo;
        this.connection = connection;
               
        setLocationRelativeTo(null);
        getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        
        empleo = new Empleo();
        
        // Obteniendo toda la informacion correspondiente a la oferta de trabajo seleccionada.
        getInformacionEmpleo();
        getCertificacionesOfertaEmpleo();
        getEspecialidadesOfertaEmpleo();
        getHerramientasOfertaEmpleo();
        getNivelesAcademicosOfertaEmpleo();
        getProyectosOfertaEmpleo();
        getLenguajesOfertaEmpleo();
        
        // Enviando todos los postulantes y Empleo para ser puntuados.
        calcularPuntajePostulante();
        
        consultarFiltradosDatabase();
        
        consultarPostulantesSeleccionados();
        
        fijarPostulantesSeleccionados();
        
        habilitarInfoEvalBoton();
    }

    
    // Metodo para ocultar o mostrar el boton de evaluacion dependiendo de la opcion de filtrado o evaluacion.
    public void visualizarEvaluacionBoton(int option){
    
        switch(option){
            case 3:  jButtonEvaluacion.setVisible(false);
                     break;
            case 4:  jButtonEvaluacion.setVisible(true);
                     break;
        }
    }
    
    // Metodo para deshabilitar o no el boton de Ver Info, si esta vacia la lista o no.
    public void habilitarInfoEvalBoton(){
        if(idpostulantesSeleccionados.isEmpty()){
            jButtonDatos.setEnabled(false);
            jButtonEvaluacion.setEnabled(false);
        }
    }
    
    // Funcion para consultar mediante el id_ofertaEmpleo los seleccionados para el empleo.
    public void consultarFiltradosDatabase(){
    
        try{
            // Verificar si ya el postulante se encuentra filtrado con el empleo correspondiente.
            ResultSet rs_filtrado = connection.prepareStatement("SELECT * FROM filtrado_puntajes").executeQuery();
                    
                while(rs_filtrado.next())
                    if(rs_filtrado.getInt(6) == id_ofertaEmpleo)
                        id_postulantes.add(rs_filtrado.getInt(7));
                            
        }catch (SQLException ex) {
                Logger.getLogger(Formulario_Postulante_Conocimientos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Funcion para consultar los postulantes seleccionados en la base de datos.
    public void consultarPostulantesSeleccionados(){
    
        try{
            // Verificar si ya el postulante se encuentra filtrado con el empleo correspondiente.
            ResultSet rs_postulantes = connection.prepareStatement("SELECT * FROM postulantes").executeQuery();
                    
                while(rs_postulantes.next()){
                
                    for(int counter = 0; counter < id_postulantes.size(); counter++)
                        if(id_postulantes.get(counter) == rs_postulantes.getInt(1)){
                            postulantesSeleccionados.add(rs_postulantes.getString(2) + " " + rs_postulantes.getString(4));
                            idpostulantesSeleccionados.add(rs_postulantes.getInt(1));
                        }
                }
                            
        }catch (SQLException ex) {
                Logger.getLogger(Formulario_Postulante_Conocimientos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Metodo para fijar los postulantes que han sido seleccionados por empleo en la lista de la vista.
    public void fijarPostulantesSeleccionados(){
       DefaultListModel model = new DefaultListModel();
       
       for(int counter = 0; counter < postulantesSeleccionados.size(); counter++)
           model.addElement(postulantesSeleccionados.get(counter));
       
       seleccionados_list.setModel(model);
       
       if(!postulantesSeleccionados.isEmpty())
           seleccionados_list.setSelectedIndex(0);
       
   }
    
    // Funcion para calcular el puntaje dependiendo del postulante y el empleo.
    public void calcularPuntajePostulante(){
        
        boolean filtrado = false;
        
          try {
                ResultSet rs = connection.prepareStatement("SELECT * FROM postulantes").executeQuery();
                
                while(rs.next()){
                    
                    Postulante postulante = new Postulante();
                    
                    postulante.setIdentificador(Integer.parseInt(rs.getString(1)));
                    postulante.setNombres(rs.getString(2), rs.getString(3));
                    postulante.setApellidos(rs.getString(4), rs.getString(5));
                    postulante.setDNI(Integer.parseInt(rs.getString(6)));
                    postulante.setEdad(Integer.parseInt(rs.getString(7)));
                    postulante.setSexo(rs.getString(8));
                    postulante.setPais_origen(rs.getString(9));
                    postulante.setResidencia(rs.getString(10));
                    postulante.setTelefono(rs.getString(11));
                    postulante.setCorreo(rs.getString(12));
                    
                    // Verificar si ya el postulante se encuentra filtrado con el empleo correspondiente.
                    ResultSet rs_filtrado = connection.prepareStatement("SELECT * FROM filtrado_puntajes").executeQuery();
                    
                    while(rs_filtrado.next()){
                        
                        if(rs_filtrado.getInt(6) == id_ofertaEmpleo && rs_filtrado.getInt(7) == postulante.getIdentificador())
                            filtrado = true;
                    }
                    
                    if(!(verificarSexoPostulante(postulante) && verificarResidenciaPostulante(postulante) && verificarModalidadPostulante(postulante)) || filtrado){
                        filtrado = false;
                        continue;
                    }
                    
                    // Cargando al postulante su informacion del nivel academico.
                    ResultSet rs_academico = connection.prepareStatement("SELECT * FROM nivelacademico WHERE `idpostulante` = " + String.valueOf(postulante.getIdentificador())).executeQuery();
                    
                    while(rs_academico.next()){
                        postulante.setTitulo(rs_academico.getString(2));
                        postulante.setEspecialidad(rs_academico.getString(3));
                    }
                        
                    // Buscamos las herramientas del postulante. Bien sea, lenguajes de programacion que maneja en la base de datos.
                    ResultSet rs_tools = connection.prepareStatement("SELECT * FROM herramientas_manejadas WHERE `idpostulante` = " + String.valueOf(postulante.getIdentificador())).executeQuery();
                    
                    while(rs_tools.next())
                        postulante.agregarHerramienta(rs_tools.getString(2));
                    
                    // Buscamos todas las certificaciones del postulante en la base de datos.
                    ResultSet rs_certifieds = connection.prepareStatement("SELECT * FROM certificaciones WHERE `idpostulante` = " + String.valueOf(postulante.getIdentificador())).executeQuery();
                    
                    while(rs_certifieds.next())
                        postulante.agregarCertificacion(rs_certifieds.getString(2));
                    
                    //Buscamos todos los conocimientos generales del postulante en la base de datos.
                    ResultSet rs_knowledge = connection.prepareStatement("SELECT * FROM conocimientos_generales WHERE `idpostulante` = " + String.valueOf(postulante.getIdentificador())).executeQuery();
                    
                    while(rs_knowledge.next())
                        postulante.agregarConocimiento(rs_knowledge.getString(2));
                    
                    // Buscamos las experiencias laborales del postulante en la base de datos.
                    ResultSet rs_exp = connection.prepareStatement("SELECT * FROM experiencia_laboral WHERE `idpostulante` = " + String.valueOf(postulante.getIdentificador())).executeQuery();
                    
                    while(rs_exp.next()){
                        
                        Experiencia_Laboral experiencia = new Experiencia_Laboral();
                        
                        experiencia.setEmpresa(rs_exp.getString(2));
                        experiencia.setCargo(rs_exp.getString(3));
                        experiencia.setYear_ingreso(rs_exp.getInt(4));
                        experiencia.setYear_salida(rs_exp.getInt(5));
                        
                        postulante.agregarExperienciaLaboral(experiencia);
                    }
                    
                     // Buscamos los lenguajes del postulante en la base de datos.
                    ResultSet rs_lenguaje = connection.prepareStatement("SELECT * FROM lenguajes WHERE `idpostulante` = " + String.valueOf(postulante.getIdentificador())).executeQuery();
                    
                    while(rs_lenguaje.next())
                        postulante.agregarLenguaje(rs_lenguaje.getString(2));
                    
                    // Enviamos la informacion del Postulante y el Empleo.
                    Puntajes_EAP puntajes_eap = new Puntajes_EAP(postulante, empleo);
                    
                    // Realizando el llamado de los metodos de puntajes.
                    puntajes_eap.calcular_puntaje_pep();
                    puntajes_eap.calcular_puntaje_psa();
                    puntajes_eap.calcular_puntaje_pse();
                    
                    // Vamos a ingresar los postulantes filtrados a la base de datos si supera una puntuacion mayor e igual a 10 puntos en la filtracion.
                    if(((puntajes_eap.getPEP() + puntajes_eap.getPSA() + puntajes_eap.getPSE())/3) >= 10)
                        agregarFiltradoPostulante(postulante, puntajes_eap);
                    
                    System.out.println(postulante.getPrimerNombre() + " " + postulante.getPrimerApellido());
                    
                    puntajes_eap.getPEP();
                    puntajes_eap.getPSA();
                    puntajes_eap.getPSE();
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Formulario_Postulante_Conocimientos.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    // Funcion para guardar en la base de datos el filtrado de los postulantes.
    public void agregarFiltradoPostulante(Postulante postulante, Puntajes_EAP puntajes_eap){
    
         try {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `filtrado_puntajes` (`idfiltrado_puntajes`, `pse`, `psa`, `pep`, `total`, `idoferta_empleo`, `idpostulante`) VALUES (NULL, ?, ?, ?, ?, ?, ?)");
                
                ps.setFloat(1, puntajes_eap.getPSE());
                ps.setFloat(2, puntajes_eap.getPSA());
                ps.setFloat(3, puntajes_eap.getPEP());
                ps.setFloat(4, ((puntajes_eap.getPEP() + puntajes_eap.getPSA() + puntajes_eap.getPSE())/3));
                ps.setInt(5, id_ofertaEmpleo);
                ps.setInt(6, postulante.getIdentificador());
                
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Administracion_json.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    // Funcion para verificar si el postulante cumple con las condiciones de sexo por el empleo.
    public boolean verificarSexoPostulante(Postulante postulante){
    
        if(postulante.getSexo().equals(empleo.getSexo()) || empleo.getSexo().equals("Ambos"))
            return true;
        
        return false;
    }
    
    // Funcion para verificar si el postulante cumple con el domicilio para el empleo (Nacional, Internacional o ambos).
    public boolean verificarResidenciaPostulante(Postulante postulante){
    
        if(empleo.getDomicilio().equals("Ambos") || (postulante.getResidencia().equalsIgnoreCase(empleo.getNacionalidad()) && empleo.getDomicilio().equals("Nacional")) || ( !postulante.getResidencia().equalsIgnoreCase(empleo.getNacionalidad()) && empleo.getDomicilio().equals("Internacional")))                                                                                
            return true;
        
        return false;
    }
    
    // Funcion para verificar si el postulante cumple con la modalidad de empleo (Presencial, Remoto o Ambos)
    public boolean verificarModalidadPostulante(Postulante postulante){
    
        if(empleo.getModo().equals("Ambos") || (empleo.getModo().equals("Presencial") && postulante.getResidencia().equalsIgnoreCase(empleo.getNacionalidad())) || (empleo.getModo().equals("Remoto") && empleo.getDomicilio().equals("Internacional") && !postulante.getResidencia().equalsIgnoreCase(empleo.getNacionalidad())) || (empleo.getModo().equals("Remoto") && empleo.getDomicilio().equals("Nacional") && postulante.getResidencia().equalsIgnoreCase(empleo.getNacionalidad())))
            return true;
        
     return false;
    }
    
    // Obtener toda la informar referente al empleo el cual se realizan la filtracion de los postulantes aptos.
    public void getInformacionEmpleo(){
    
          try {
                ResultSet rs = connection.prepareStatement("SELECT * FROM oferta_empleo WHERE `idoferta_empleo` = " + String.valueOf(id_ofertaEmpleo)).executeQuery();
                
                while(rs.next()){
                    empleo.setNombreEmpresa(rs.getString(2));
                    empleo.setCodContrato(Integer.parseInt(rs.getString(3)));
                    empleo.setSexo(rs.getString(4));
                    empleo.setMenorEdad(Integer.parseInt(rs.getString(5)));
                    empleo.setMayorEdad(Integer.parseInt(rs.getString(6)));
                    empleo.setDomicilio(rs.getString(7));
                    empleo.setModo(rs.getString(8));
                    empleo.setNacionalidad(rs.getString(9));
                    empleo.setDescripcion(rs.getString(10));
                    empleo.setCorreo(rs.getString(11));
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Formulario_Postulante_Conocimientos.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    // Obtener las certificaciones sugeridas de la oferta de empleo seleccionada.
    public void getCertificacionesOfertaEmpleo(){
    
         try {
                ResultSet rs = connection.prepareStatement("SELECT * FROM certificaciones_ofertaempleo WHERE `idoferta_empleo` = " + String.valueOf(id_ofertaEmpleo)).executeQuery();
                
                while(rs.next())
                    empleo.setCertificacionesSugeridas(rs.getString(2));

            } catch (SQLException ex) {
                Logger.getLogger(Formulario_Postulante_Conocimientos.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    // Obtener las especialidades establecidad por la oferta de empleo seleccionada.
    public void getEspecialidadesOfertaEmpleo(){
         
         try {
                ResultSet rs = connection.prepareStatement("SELECT * FROM especialidades_ofertaempleo WHERE `idoferta_empleo` = " + String.valueOf(id_ofertaEmpleo)).executeQuery();
                
                while(rs.next())
                    empleo.setEspecialidades(rs.getString(2));

            } catch (SQLException ex) {
                Logger.getLogger(Formulario_Postulante_Conocimientos.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    // Obtener las herramientas establecidas por la oferta de empleo seleccionada.
    public void getHerramientasOfertaEmpleo(){
         
         try {
                ResultSet rs = connection.prepareStatement("SELECT * FROM herramientas_ofertaempleo WHERE `idoferta_empleo` = " + String.valueOf(id_ofertaEmpleo)).executeQuery();
                
                while(rs.next())
                    empleo.setHerramientasManejadas(rs.getString(2));

            } catch (SQLException ex) {
                Logger.getLogger(Formulario_Postulante_Conocimientos.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    // Obtener los niveles academicos establecidas por la oferta de empleo seleccionada.
    public void getNivelesAcademicosOfertaEmpleo(){
         
         try {
                ResultSet rs = connection.prepareStatement("SELECT * FROM nivelacademico_ofertaempleo WHERE `idoferta_empleo` = " + String.valueOf(id_ofertaEmpleo)).executeQuery();
                
                while(rs.next())
                    empleo.setNivelesAcademicos(rs.getString(2));

            } catch (SQLException ex) {
                Logger.getLogger(Formulario_Postulante_Conocimientos.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    // Obtener los tipos de proyectos establecidas por la oferta de empleo seleccionada.
    public void getProyectosOfertaEmpleo(){
         
         try {
                ResultSet rs = connection.prepareStatement("SELECT * FROM proyectos_ofertaempleo WHERE `idoferta_empleo` = " + String.valueOf(id_ofertaEmpleo)).executeQuery();
                
                while(rs.next())
                    empleo.setTipoProyectos(rs.getString(2));

            } catch (SQLException ex) {
                Logger.getLogger(Formulario_Postulante_Conocimientos.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    // Obtener los lenguajes establecidas por la oferta de empleo seleccionada.
    public void getLenguajesOfertaEmpleo(){
         
         try {
                ResultSet rs = connection.prepareStatement("SELECT * FROM lenguajes_ofertaempleo WHERE `idoferta_empleo` = " + String.valueOf(id_ofertaEmpleo)).executeQuery();
                
                while(rs.next())
                    empleo.setLenguajesManejados(rs.getString(2));

            } catch (SQLException ex) {
                Logger.getLogger(Formulario_Postulante_Conocimientos.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    // Funcion para saber si el postulante seleccionado ya ha realizado su evaluacion para una oferta de empleo en particular.
    public boolean postulanteEvaluado(int id_postulante){
    
        try {
                ResultSet rs = connection.prepareStatement("SELECT * FROM evaluaciongeneral WHERE `idoferta_empleo` = " + id_ofertaEmpleo + " AND " + "`idpostulante` = " + id_postulante).executeQuery();
                
                if(rs.first())
                   return true;
                    
            } catch (SQLException ex) {
                Logger.getLogger(Formulario_Postulante_Conocimientos.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return false;
    }
    
    // Metodo para mostrar los datos de un postulante segun el id.
    public void getDatosPostulante(int idpostulante){
        Dialogs d;
        try{
            ResultSet rs = connection.prepareStatement("SELECT * FROM postulantes WHERE idpostulante = " + idpostulante).executeQuery();
                    
                if(rs.first())
                {   
                    d = new Dialogs(rs.getString(2) + " " + rs.getString(3), rs.getString(4) + " " + rs.getString(5), rs.getLong(6), rs.getInt(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getLong(11),rs.getString(12));
                    d.setVisible(true);
                    
                }                
        }catch (SQLException ex) {
                Logger.getLogger(Formulario_Postulante_Conocimientos.class.getName()).log(Level.SEVERE, null, ex);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPIngreso = new javax.swing.JPanel();
        jPPage1 = new javax.swing.JPanel();
        jInfPersonal = new javax.swing.JLabel();
        jPanelOfertasEmpleo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        seleccionados_list = new javax.swing.JList<>();
        jButtonDatos = new javax.swing.JButton();
        jButtonEvaluacion = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
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
        jInfPersonal.setText("Filtrado de postulantes ");
        jPPage1.add(jInfPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, 60));

        jPanelOfertasEmpleo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "listado de postulantes", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Berlin Sans FB", 0, 24), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanelOfertasEmpleo.setOpaque(false);
        jPanelOfertasEmpleo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        seleccionados_list.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        seleccionados_list.setForeground(new java.awt.Color(0, 102, 102));
        jScrollPane1.setViewportView(seleccionados_list);

        jPanelOfertasEmpleo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 610, 250));

        jButtonDatos.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jButtonDatos.setForeground(new java.awt.Color(0, 102, 102));
        jButtonDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_resume_80px_1.png"))); // NOI18N
        jButtonDatos.setText("ver info");
        jButtonDatos.setBorderPainted(false);
        jButtonDatos.setContentAreaFilled(false);
        jButtonDatos.setFocusPainted(false);
        jButtonDatos.setFocusable(false);
        jButtonDatos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonDatos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_resume_80px.png"))); // NOI18N
        jButtonDatos.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_resume_80px.png"))); // NOI18N
        jButtonDatos.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_resume_80px.png"))); // NOI18N
        jButtonDatos.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButtonDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDatosActionPerformed(evt);
            }
        });
        jPanelOfertasEmpleo.add(jButtonDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 100, 100));

        jButtonEvaluacion.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jButtonEvaluacion.setForeground(new java.awt.Color(0, 102, 102));
        jButtonEvaluacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_test_passed_80px.png"))); // NOI18N
        jButtonEvaluacion.setText("evaluar");
        jButtonEvaluacion.setBorderPainted(false);
        jButtonEvaluacion.setContentAreaFilled(false);
        jButtonEvaluacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEvaluacion.setFocusPainted(false);
        jButtonEvaluacion.setFocusable(false);
        jButtonEvaluacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEvaluacion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_test_passed_80px_3.png"))); // NOI18N
        jButtonEvaluacion.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_test_passed_80px_3.png"))); // NOI18N
        jButtonEvaluacion.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_test_passed_80px_3.png"))); // NOI18N
        jButtonEvaluacion.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButtonEvaluacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEvaluacionActionPerformed(evt);
            }
        });
        jPanelOfertasEmpleo.add(jButtonEvaluacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, 100, 100));

        jButtonCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_circled_left_80px_1.png"))); // NOI18N
        jButtonCancel.setBorderPainted(false);
        jButtonCancel.setContentAreaFilled(false);
        jButtonCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCancel.setFocusPainted(false);
        jButtonCancel.setFocusable(false);
        jButtonCancel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_circled_left_80px.png"))); // NOI18N
        jButtonCancel.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_circled_left_80px.png"))); // NOI18N
        jButtonCancel.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_circled_left_80px.png"))); // NOI18N
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });
        jPanelOfertasEmpleo.add(jButtonCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 250, 80, 60));

        jPPage1.add(jPanelOfertasEmpleo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 770, 320));

        jPIngreso.add(jPPage1);
        jPPage1.setBounds(0, 0, 950, 670);

        jBackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bg3.gif"))); // NOI18N
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

    private void jButtonDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDatosActionPerformed
        getDatosPostulante(idpostulantesSeleccionados.get(seleccionados_list.getSelectedIndex()));
    }//GEN-LAST:event_jButtonDatosActionPerformed

    private void jButtonEvaluacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEvaluacionActionPerformed

        if(postulanteEvaluado(idpostulantesSeleccionados.get(seleccionados_list.getSelectedIndex()))){
            Dialogs d = new Dialogs(14);//YA HA SIDO EVALUADO
            d.setVisible(true);
            return;
        }

        for(int k = 0; k < postulantesSeleccionados.size(); k++)
        System.out.println(postulantesSeleccionados.get(k));

        if(postulantesSeleccionados.isEmpty()){
            System.out.println("No hubo nadie seleccionado.");
            return;
        }

        EvaluacionFrame ef = new EvaluacionFrame(id_ofertaEmpleo, idpostulantesSeleccionados.get(seleccionados_list.getSelectedIndex()), connection, this);
        ef.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonEvaluacionActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        OfertasEmpleoFiltradoFrame fpf = new OfertasEmpleoFiltradoFrame(connection, menuframe, option);
        fpf.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        Dialogs d = new Dialogs(1);
        d.setVisible(true);
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setState(Formulario_Postulante_Info_Personal.ICONIFIED);
    }//GEN-LAST:event_jButton1ActionPerformed

    

    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jBackGround;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonDatos;
    private javax.swing.JButton jButtonEvaluacion;
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
