package Views;

import javax.swing.JOptionPane;

import Controllers.Metodos_Sistema_Experto;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import Controllers.Administracion_json;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class EvaluacionFrame extends javax.swing.JFrame {

    Connection connection;
    private int id_ofertaEmpleo, idpostulante, posRespuestaCorrecta, opcionSeleccionada;
    Metodos_Sistema_Experto mse;
    private int counterPregunta = 9, categoriaP = 0, aciertoPregunta = -1, puntajeEspecifico = 0;
    private ButtonGroup respuestas;
    private List<Integer> puntajes;
    private boolean flag = false;
    FiltradoPostulantesFrame fpf;
        
    public EvaluacionFrame(int id_ofertaEmpleo, int idpostulante, Connection connection, FiltradoPostulantesFrame fpf) {
               
        initComponents();  
                       
        setLocationRelativeTo(null);
        getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        
        this.fpf = fpf;
      
        puntajes = inicializandoPuntajes();
        
        this.connection = connection;
        this.id_ofertaEmpleo = id_ofertaEmpleo;
        this.idpostulante = idpostulante;
        
        mse = new Metodos_Sistema_Experto(connection);
        sistemaEvaluacion(counterPregunta, categoriaP, aciertoPregunta);
    }

        // Metodo para inicializar los puntajes en cero para las cinco categorias.
    public List<Integer> inicializandoPuntajes(){
        
        List<Integer> puntajes = new ArrayList();
        
        for(int counter = 0,k = 0; k < 5; k++)
            puntajes.add(counter);
        
        return puntajes;
    }
    
    // Metodo para hacer reset a las opciones de los radio buttoms.
    public void resetRespuestasRadioButtons(){
        opcion1_radiobutton.setText("");
        opcion2_radiobutton.setText("");
        opcion3_radiobutton.setText("");
        opcion4_radiobutton.setText("");
    }
    
    // public void reset select radio buttons.
    public void resetSelectRadioButtons(){
        opcion1_radiobutton.setSelected(false);
        opcion2_radiobutton.setSelected(false);
        opcion3_radiobutton.setSelected(false);
        opcion4_radiobutton.setSelected(false);
    }
    
    // Sistema de Evaluacion General con Dificultades - 5 Categorias.
    public void sistemaEvaluacion(int contadorPregunta, int categoria, int acierto){
    
        titleEvaluacion.setText("Sistema de Evaluacion General");
        // Fijando la categoria en la label principal.
        fijarCategoriaEnCurso(categoria, contadorPregunta);
        
        resetRespuestasRadioButtons();
        
        Random rnd = new Random();
        
        switch(categoria){
            // Preguntas Categoria Backend
            case 0: 
                        // Inicio del Sistema de Evaluacion - Comienza con pregunta facil o cuando no acierta y viene una pregunta facil.
                        if(acierto == -1 || acierto == 0){
                            pregunta_label.setText("<html>"+mse.getListadoBackendEasy().get(contadorPregunta).getPregunta()+"<html>");

                            int posRespuestaCorrecta = rnd.nextInt(4);
                            fijarRespuestaCorrecta(posRespuestaCorrecta, mse.getListadoBackendEasy().get(contadorPregunta).getRespuesta());

                            // Ya se ha fijado la respuesta correcta. Ahora fijaremos las incorrectas donde no haya coincidencia con la correcta y que no se repitan las respuestas incorrectas.
                            List<String>respuestasIncorrectas = new ArrayList();
                            boolean flag = true;

                            while(flag){
                                int pos = rnd.nextInt(10);

                                    if(pos != contadorPregunta && !respuestasIncorrectas.contains(mse.getListadoBackendEasy().get(pos).getRespuesta()))
                                        respuestasIncorrectas.add(mse.getListadoBackendEasy().get(pos).getRespuesta());

                                    if(respuestasIncorrectas.size() == 3)
                                        flag = false;
                            }
                            
                            int counter = 0;

                            // Se envia la lista de respuestas incorrectas no repetidas a renderizarse en al vista.
                            while(counter != respuestasIncorrectas.size())
                                if(fijarRespuestasIncorrectas(respuestasIncorrectas.get(counter), posRespuestaCorrecta, rnd))
                                    counter++;
                        }
                        
                        // Para mostrar una pregunta dificil si acertaste la anterior.
                        if(acierto == 1){
                            pregunta_label.setText("<html>"+mse.getListadoBackendHard().get(contadorPregunta).getPregunta()+"<html>");

                            int posRespuestaCorrecta = rnd.nextInt(4);
                            fijarRespuestaCorrecta(posRespuestaCorrecta, mse.getListadoBackendHard().get(contadorPregunta).getRespuesta());

                            // Ya se ha fijado la respuesta correcta. Ahora fijaremos las incorrectas donde no haya coincidencia con la correcta y que no se repitan las respuestas incorrectas.
                            List<String> respuestasIncorrectas = new ArrayList();
                            boolean flag = true;

                            while(flag){
                                int pos = rnd.nextInt(10);

                                    if(pos != contadorPregunta && !respuestasIncorrectas.contains(mse.getListadoBackendHard().get(pos).getRespuesta()))
                                        respuestasIncorrectas.add(mse.getListadoBackendHard().get(pos).getRespuesta());

                                    if(respuestasIncorrectas.size() == 3)
                                        flag = false;
                            }
                            
                            int counter = 0;

                            // Se envia la lista de respuestas incorrectas no repetidas a renderizarse en al vista.
                            while(counter != respuestasIncorrectas.size())
                                if(fijarRespuestasIncorrectas(respuestasIncorrectas.get(counter), posRespuestaCorrecta, rnd))
                                    counter++;
                        }
                        
                        break;
            // Preguntas Categoria Frontend.
            case 1:    
                        // Inicio del Sistema de Evaluacion - Comienza con pregunta facil o cuando no acierta y viene una pregunta facil.
                        if(acierto == -1 || acierto == 0){
                            pregunta_label.setText("<html>"+mse.getListadoFrontendEasy().get(contadorPregunta).getPregunta()+"<html>");

                            int posRespuestaCorrecta = rnd.nextInt(4);
                            fijarRespuestaCorrecta(posRespuestaCorrecta, mse.getListadoFrontendEasy().get(contadorPregunta).getRespuesta());

                            // Ya se ha fijado la respuesta correcta. Ahora fijaremos las incorrectas donde no haya coincidencia con la correcta y que no se repitan las respuestas incorrectas.
                            List<String> respuestasIncorrectas = new ArrayList();
                            boolean flag = true;

                            while(flag){
                                int pos = rnd.nextInt(10);

                                    if(pos != contadorPregunta && !respuestasIncorrectas.contains(mse.getListadoFrontendEasy().get(pos).getRespuesta()))
                                        respuestasIncorrectas.add(mse.getListadoFrontendEasy().get(pos).getRespuesta());

                                    if(respuestasIncorrectas.size() == 3)
                                        flag = false;
                            }
                            
                            int counter = 0;

                            // Se envia la lista de respuestas incorrectas no repetidas a renderizarse en al vista.
                            while(counter != respuestasIncorrectas.size())
                                if(fijarRespuestasIncorrectas(respuestasIncorrectas.get(counter), posRespuestaCorrecta, rnd))
                                    counter++;
                        }
                        
                        // Para mostrar una pregunta dificil si acertaste la anterior.
                        if(acierto == 1){
                        
                             pregunta_label.setText("<html>"+mse.getListadoFrontendHard().get(contadorPregunta).getPregunta()+"<html>");

                            int posRespuestaCorrecta = rnd.nextInt(4);
                            fijarRespuestaCorrecta(posRespuestaCorrecta, mse.getListadoFrontendHard().get(contadorPregunta).getRespuesta());

                            // Ya se ha fijado la respuesta correcta. Ahora fijaremos las incorrectas donde no haya coincidencia con la correcta y que no se repitan las respuestas incorrectas.
                            List<String> respuestasIncorrectas = new ArrayList();
                            boolean flag = true;

                            while(flag){
                                int pos = rnd.nextInt(10);

                                    if(pos != contadorPregunta && !respuestasIncorrectas.contains(mse.getListadoFrontendHard().get(pos).getRespuesta()))
                                        respuestasIncorrectas.add(mse.getListadoFrontendHard().get(pos).getRespuesta());

                                    if(respuestasIncorrectas.size() == 3)
                                        flag = false;
                            }

                            int counter = 0;

                            // Se envia la lista de respuestas incorrectas no repetidas a renderizarse en al vista.
                            while(counter != respuestasIncorrectas.size())
                                if(fijarRespuestasIncorrectas(respuestasIncorrectas.get(counter), posRespuestaCorrecta, rnd))
                                    counter++;
                        }
                        
                        break;
            // Preguntas Categoria DevOps.
            case 2:     
                        // Inicio del Sistema de Evaluacion - Comienza con pregunta facil o cuando no acierta y viene una pregunta facil.
                        if(acierto == -1 || acierto == 0){
                            pregunta_label.setText("<html>"+mse.getListadoDevOpsEasy().get(contadorPregunta).getPregunta()+"<html>");

                            int posRespuestaCorrecta = rnd.nextInt(4);
                            fijarRespuestaCorrecta(posRespuestaCorrecta, mse.getListadoDevOpsEasy().get(contadorPregunta).getRespuesta());

                            // Ya se ha fijado la respuesta correcta. Ahora fijaremos las incorrectas donde no haya coincidencia con la correcta y que no se repitan las respuestas incorrectas.
                            List<String> respuestasIncorrectas = new ArrayList();
                            boolean flag = true;

                            while(flag){
                                int pos = rnd.nextInt(10);

                                    if(pos != contadorPregunta && !respuestasIncorrectas.contains(mse.getListadoDevOpsEasy().get(pos).getRespuesta()))
                                        respuestasIncorrectas.add(mse.getListadoDevOpsEasy().get(pos).getRespuesta());

                                    if(respuestasIncorrectas.size() == 3)
                                        flag = false;
                            }
                            
                            int counter = 0;

                            // Se envia la lista de respuestas incorrectas no repetidas a renderizarse en al vista.
                            while(counter != respuestasIncorrectas.size())
                                if(fijarRespuestasIncorrectas(respuestasIncorrectas.get(counter), posRespuestaCorrecta, rnd))
                                    counter++;
                        }
                        
                        // Para mostrar una pregunta dificil si acertaste la anterior.
                        if(acierto == 1){
                            pregunta_label.setText("<html>"+mse.getListadoDevOpsHard().get(contadorPregunta).getPregunta()+"<html>");

                            int posRespuestaCorrecta = rnd.nextInt(4);
                            fijarRespuestaCorrecta(posRespuestaCorrecta, mse.getListadoDevOpsHard().get(contadorPregunta).getRespuesta());

                            // Ya se ha fijado la respuesta correcta. Ahora fijaremos las incorrectas donde no haya coincidencia con la correcta y que no se repitan las respuestas incorrectas.
                            List<String> respuestasIncorrectas = new ArrayList();
                            boolean flag = true;

                            while(flag){
                                int pos = rnd.nextInt(10);

                                    if(pos != contadorPregunta && !respuestasIncorrectas.contains(mse.getListadoDevOpsHard().get(pos).getRespuesta()))
                                        respuestasIncorrectas.add(mse.getListadoDevOpsHard().get(pos).getRespuesta());

                                    if(respuestasIncorrectas.size() == 3)
                                        flag = false;
                            }
                            
                            int counter = 0;

                            // Se envia la lista de respuestas incorrectas no repetidas a renderizarse en al vista.
                            while(counter != respuestasIncorrectas.size())
                                if(fijarRespuestasIncorrectas(respuestasIncorrectas.get(counter), posRespuestaCorrecta, rnd))
                                    counter++;
                        }
                        
                        break;
            // Preguntas Categoria UIX
            case 3:
                        // Inicio del Sistema de Evaluacion - Comienza con pregunta facil o cuando no acierta y viene una pregunta facil.
                        if(acierto == -1 || acierto == 0){
                            pregunta_label.setText("<html>"+mse.getListadoUIXEasy().get(contadorPregunta).getPregunta()+"<html>");

                            int posRespuestaCorrecta = rnd.nextInt(4);
                            fijarRespuestaCorrecta(posRespuestaCorrecta, mse.getListadoUIXEasy().get(contadorPregunta).getRespuesta());

                            // Ya se ha fijado la respuesta correcta. Ahora fijaremos las incorrectas donde no haya coincidencia con la correcta y que no se repitan las respuestas incorrectas.
                            List<String> respuestasIncorrectas = new ArrayList();
                            boolean flag = true;

                            while(flag){
                                int pos = rnd.nextInt(10);

                                    if(pos != contadorPregunta && !respuestasIncorrectas.contains(mse.getListadoUIXEasy().get(pos).getRespuesta()))
                                        respuestasIncorrectas.add(mse.getListadoUIXEasy().get(pos).getRespuesta());

                                    if(respuestasIncorrectas.size() == 3)
                                        flag = false;
                            }

                            int counter = 0;

                            // Se envia la lista de respuestas incorrectas no repetidas a renderizarse en al vista.
                            while(counter != respuestasIncorrectas.size())
                                if(fijarRespuestasIncorrectas(respuestasIncorrectas.get(counter), posRespuestaCorrecta, rnd))
                                    counter++;
                        }
                        
                        // Para mostrar una pregunta dificil si acertaste la anterior.
                        if(acierto == 1){
                            pregunta_label.setText("<html>"+mse.getListadoUIXHard().get(contadorPregunta).getPregunta()+"<html>");

                            int posRespuestaCorrecta = rnd.nextInt(4);
                            fijarRespuestaCorrecta(posRespuestaCorrecta, mse.getListadoUIXHard().get(contadorPregunta).getRespuesta());

                            // Ya se ha fijado la respuesta correcta. Ahora fijaremos las incorrectas donde no haya coincidencia con la correcta y que no se repitan las respuestas incorrectas.
                            List<String> respuestasIncorrectas = new ArrayList();
                            boolean flag = true;

                            while(flag){
                                int pos = rnd.nextInt(10);

                                    if(pos != contadorPregunta && !respuestasIncorrectas.contains(mse.getListadoUIXHard().get(pos).getRespuesta()))
                                        respuestasIncorrectas.add(mse.getListadoUIXHard().get(pos).getRespuesta());

                                    if(respuestasIncorrectas.size() == 3)
                                        flag = false;
                            }
                            
                            int counter = 0;

                            // Se envia la lista de respuestas incorrectas no repetidas a renderizarse en al vista.
                            while(counter != respuestasIncorrectas.size())
                                if(fijarRespuestasIncorrectas(respuestasIncorrectas.get(counter), posRespuestaCorrecta, rnd))
                                    counter++;
                        }
                        
                        break;
            // Preguntas Categoria QA.
            case 4:
                        // Inicio del Sistema de Evaluacion - Comienza con pregunta facil o cuando no acierta y viene una pregunta facil.
                        if(acierto == -1 || acierto == 0){
                            pregunta_label.setText("<html>"+mse.getListadoQAEasy().get(contadorPregunta).getPregunta()+"<html>");

                            int posRespuestaCorrecta = rnd.nextInt(4);
                            fijarRespuestaCorrecta(posRespuestaCorrecta, mse.getListadoQAEasy().get(contadorPregunta).getRespuesta());

                            // Ya se ha fijado la respuesta correcta. Ahora fijaremos las incorrectas donde no haya coincidencia con la correcta y que no se repitan las respuestas incorrectas.
                            List<String> respuestasIncorrectas = new ArrayList();
                            boolean flag = true;

                            while(flag){
                                int pos = rnd.nextInt(10);

                                    if(pos != contadorPregunta && !respuestasIncorrectas.contains(mse.getListadoQAEasy().get(pos).getRespuesta()))
                                        respuestasIncorrectas.add(mse.getListadoQAEasy().get(pos).getRespuesta());

                                    if(respuestasIncorrectas.size() == 3)
                                        flag = false;
                            }

                            int counter = 0;

                            // Se envia la lista de respuestas incorrectas no repetidas a renderizarse en al vista.
                            while(counter != respuestasIncorrectas.size())
                                if(fijarRespuestasIncorrectas(respuestasIncorrectas.get(counter), posRespuestaCorrecta, rnd))
                                    counter++;
                        }
                        
                        // Para mostrar una pregunta dificil si acertaste la anterior.
                        if(acierto == 1){
                        
                            pregunta_label.setText("<html>"+mse.getListadoQAHard().get(contadorPregunta).getPregunta()+"<html>");

                            int posRespuestaCorrecta = rnd.nextInt(4);
                            fijarRespuestaCorrecta(posRespuestaCorrecta, mse.getListadoQAHard().get(contadorPregunta).getRespuesta());

                            // Ya se ha fijado la respuesta correcta. Ahora fijaremos las incorrectas donde no haya coincidencia con la correcta y que no se repitan las respuestas incorrectas.
                            List<String> respuestasIncorrectas = new ArrayList();
                            boolean flag = true;

                            while(flag){
                                int pos = rnd.nextInt(10);

                                    if(pos != contadorPregunta && !respuestasIncorrectas.contains(mse.getListadoQAHard().get(pos).getRespuesta()))
                                        respuestasIncorrectas.add(mse.getListadoQAHard().get(pos).getRespuesta());

                                    if(respuestasIncorrectas.size() == 3)
                                        flag = false;
                            }
                            
                            int counter = 0;

                            // Se envia la lista de respuestas incorrectas no repetidas a renderizarse en al vista.
                            while(counter != respuestasIncorrectas.size())
                                if(fijarRespuestasIncorrectas(respuestasIncorrectas.get(counter), posRespuestaCorrecta, rnd))
                                    counter++;
                        }
                        break;
        }
    }
    
    // Funcion para fijar respuestas incorrectas de manera aleatoria en los radio buttons restantes.
    public boolean fijarRespuestasIncorrectas(String respuestaIncorrecta, int posRespuestaCorrecta, Random rnd){
        
        int pos = rnd.nextInt(4);
                
            if(pos != posRespuestaCorrecta && verificarOpcionesRepuestas(pos)){
                fijarRespuestas(respuestaIncorrecta, pos);
                return true;
            }
        return false;
    }
    
    // Funcion para verificar si las opciones de radio buttons ya posee una respuesta incorporada.
    public boolean verificarOpcionesRepuestas(int pos){
    
        switch(pos){
            case 0: if(opcion1_radiobutton.getText().equals(""))
                        return true;
                    break;
            case 1: if(opcion2_radiobutton.getText().equals(""))
                        return true;
                    break;
            case 2: if(opcion3_radiobutton.getText().equals(""))
                        return true;
                    break;
            case 3: if(opcion4_radiobutton.getText().equals(""))
                        return true;
                    break;
        }
        return false;
    }
    
    // Funcion para fijar todas las respuestas incorrectas.
    public void fijarRespuestas(String respuestaIncorrecta, int pos){

        switch(pos){
            case 0: opcion1_radiobutton.setText(respuestaIncorrecta);
                    break;
            case 1: opcion2_radiobutton.setText(respuestaIncorrecta);
                    break;
            case 2: opcion3_radiobutton.setText(respuestaIncorrecta);
                    break;
            case 3: opcion4_radiobutton.setText(respuestaIncorrecta);   
                    break;
        }
    }
    
    // Funcion para fijar respuesta correcta de manera aleatoria en cualquiera de los 4 radio buttoms.
    public void fijarRespuestaCorrecta(int posRespCorrecta, String respuestaCorrecta){
        System.out.println(respuestaCorrecta);
        switch(posRespCorrecta){
            case 0:  opcion1_radiobutton.setText(respuestaCorrecta);
                     break;
            case 1:  opcion2_radiobutton.setText(respuestaCorrecta);
                     break;
            case 2:  opcion3_radiobutton.setText(respuestaCorrecta);
                     break;
            case 3:  opcion4_radiobutton.setText(respuestaCorrecta);   
                     break;
        }
        
        // Se almacena la posicion de la respuesta correcta.
        posRespuestaCorrecta = posRespCorrecta;
    }
    
    // Funcion para fijar la categoria de las preguntas en curso.
    public void fijarCategoriaEnCurso(int categoria, int numPregunta){
    Font font = new Font("Berlin Sans FB", Font.BOLD, 24);
    
        switch(categoria){
            case 0: 
                    jPanelPreguntas.setBorder(new TitledBorder(new LineBorder(new Color(0, 153, 240)), (numPregunta+1) + "- categoria Backend"  , TitledBorder.LEADING,
           TitledBorder.TOP, font , new Color(0, 102, 102 ))); 
                    break;
            case 1: jPanelPreguntas.setBorder(new TitledBorder(new LineBorder(new Color(0, 153, 240)),  (numPregunta+1) + "- categoria Frontend"  , TitledBorder.LEADING,
           TitledBorder.TOP, font , new Color(0, 102, 102 )));                    
                    break;
            case 2: jPanelPreguntas.setBorder(new TitledBorder(new LineBorder(new Color(0, 153, 240)),  (numPregunta+1) + "- categoria DevOps"  , TitledBorder.LEADING,
           TitledBorder.TOP, font , new Color(0, 102, 102 ))); 
                    break;
            case 3: jPanelPreguntas.setBorder(new TitledBorder(new LineBorder(new Color(0, 153, 240)), (numPregunta+1) + "- categoria UIX"   , TitledBorder.LEADING,
           TitledBorder.TOP, font , new Color(0, 102, 102 )));   
                    break;
            case 4: jPanelPreguntas.setBorder(new TitledBorder(new LineBorder(new Color(0, 153, 240)), (numPregunta+1) + "- categoria QA"  , TitledBorder.LEADING,
           TitledBorder.TOP, font , new Color(0, 102, 102 ))); 
                    break;
        }
    }
    
    // Funcion para cargar los resultados de la evaluacion general y verificar si el postulante es bueno en alguna categoria o cargo que busca la empresa.
    public void cargarResultadosEvaluacionGeneralDatabase(){
        Dialogs d;
        try {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `evaluaciongeneral` (`idevaluacion`, `idpostulante`, `idoferta_empleo`, `pB`, `pF`, `pDO`, `pUIX`, `pQA`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)");
                
                ps.setInt(1, idpostulante);
                ps.setInt(2, id_ofertaEmpleo);
                ps.setInt(3, puntajes.get(0));
                ps.setInt(4, puntajes.get(1));
                ps.setInt(5, puntajes.get(2));
                ps.setInt(6, puntajes.get(3));
                ps.setInt(7, puntajes.get(4));
                
                ps.executeUpdate();
                
            } catch (SQLException ex) {
                Logger.getLogger(Administracion_json.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        categoriaP = verificarResultadosOfertaEmpleo();
        
        // Ahora se verifica si en los resultados generales existe alguna categoria donde aprobo y la oferta de empleo la este buscando.
        if(categoriaP != -1){
            flag = true;
            mse.busquedaCategoriaEspecifica(categoriaP);
            
            // Comienza la prueba Especifica.
            sistemaEvaluacionEspecifico(counterPregunta);
        }
        else{
            d = new Dialogs(18);//NO HAS SIDO CALIFICADO PARA ALGÚN EMPLEO
            d.setVisible(true);
            fpf.setVisible(true);
            dispose();
        }
    }
    
    // Metodo para agregar los resultados de la evaluacion especifica para el postulante.
    public void cargarResultadosEvaluacionEspecificaDatabase(){
        Dialogs d;
        if(puntajeEspecifico >= 50){
            try {
                   PreparedStatement ps = connection.prepareStatement("INSERT INTO `evaluacionespecifica` (`idevaluacion`, `idpostulante`, `idoferta_empleo`, `idcategoria`, `puntaje`) VALUES (NULL, ?, ?, ?, ?)");

                   ps.setInt(1, idpostulante);
                   ps.setInt(2, id_ofertaEmpleo);
                   ps.setInt(3, categoriaP + 1);
                   ps.setInt(4, puntajeEspecifico);

                   ps.executeUpdate();

               } catch (SQLException ex) {
                   Logger.getLogger(Administracion_json.class.getName()).log(Level.SEVERE, null, ex);
               }
            d = new Dialogs(getCategoria(categoriaP), Integer.toString(puntajeEspecifico) + " Ptos", 1);
            d.setVisible(true);
        }
        else
        {
            d = new Dialogs(getCategoria(categoriaP), Integer.toString(puntajeEspecifico) + " Ptos", 2);
            d.setVisible(true);
        }
    }
    
    // Metodo que devuelve la categoria dependiendo del envio de su id.
    public String getCategoria(int categoriaP){
    
        switch(categoriaP){
            case 0: return "Backend";
            case 1: return "Frontend";
            case 2: return "DevOps";
            case 3: return "UIX";
            case 4: return "QA";
        }
       return "";
    }
    
    // Metodo para la evaluacion especifica del postulado.
    public void sistemaEvaluacionEspecifico(int contadorPregunta ){
    
         titleEvaluacion.setText("Sistema de Evaluacion Especifico");
         fijarCategoriaEnCurso(categoriaP, contadorPregunta);
        
         resetRespuestasRadioButtons();
         Random rnd = new Random();
         
         pregunta_label.setText("<html>"+mse.getListadoEspecifico().get(contadorPregunta).getPregunta()+"<html>");

         int posRespuestaCorrecta = rnd.nextInt(4);
         fijarRespuestaCorrecta(posRespuestaCorrecta, mse.getListadoEspecifico().get(contadorPregunta).getRespuesta());

         // Ya se ha fijado la respuesta correcta. Ahora fijaremos las incorrectas donde no haya coincidencia con la correcta y que no se repitan las respuestas incorrectas.
         List<String> respuestasIncorrectas = new ArrayList();
         boolean flag = true;

         while(flag){
            int pos = rnd.nextInt(10);

                if(pos != contadorPregunta && !respuestasIncorrectas.contains(mse.getListadoEspecifico().get(pos).getRespuesta()))
                    respuestasIncorrectas.add(mse.getListadoEspecifico().get(pos).getRespuesta());

                if(respuestasIncorrectas.size() == 3)
                    flag = false;
         }
                            
         int counter = 0;

         // Se envia la lista de respuestas incorrectas no repetidas a renderizarse en al vista.
         while(counter != respuestasIncorrectas.size())
            if(fijarRespuestasIncorrectas(respuestasIncorrectas.get(counter), posRespuestaCorrecta, rnd))
                counter++;
    }
    
    // Funcion para verificar los resultados y ver si existe alguna categoria donde aprobo y la oferta de empleo la este buscando.
    public int verificarResultadosOfertaEmpleo(){
    
        List<Integer> categoriasEmpleo = new ArrayList();
        
        // Vamos a traer las categorias del proyecto.
        try{
                ResultSet rs_categorias = connection.prepareStatement("SELECT * FROM proyectos_ofertaempleo WHERE `idoferta_empleo` = " + id_ofertaEmpleo).executeQuery();

                while(rs_categorias.next())
                   switch(rs_categorias.getString(2)){
                       case  "Backend":  categoriasEmpleo.add(0);
                                         break;
                       case "Frontend":  categoriasEmpleo.add(1);
                                         break;
                       case   "DevOps":  categoriasEmpleo.add(2);
                                         break;
                       case      "UIX":  categoriasEmpleo.add(3);
                                         break;
                       case       "QA":  categoriasEmpleo.add(4);
                                         break;
                   }
                
        }catch (SQLException ex) {
                    Logger.getLogger(Formulario_Postulante_Conocimientos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<Integer> categoriasSeleccionadas = new ArrayList();
        
        // Una vez que tengamos las categorias, vamos a compararla con alguna de las que resulto bueno por encima o igual del 50%.
        for(int counter = 0; counter < puntajes.size(); counter++)
            if(puntajes.get(counter) >= 50 && categoriasEmpleo.contains(counter))
                categoriasSeleccionadas.add(counter);
        
        List<Integer> categoriasRepetidas = new ArrayList();
        
        // Ya tenemos en la lista categoriasSeleccionadas, el numero de la categoria donde resulto con un puntaje mayor a 50 puntos, es decir, minimo 5 aciertos de 10.
        if(!categoriasSeleccionadas.isEmpty()){
            if(categoriasSeleccionadas.contains(puntajes.indexOf(Collections.max(puntajes)))){
        
                int position = puntajes.indexOf(Collections.max(puntajes));
                
                    for(int counter = 0; counter < puntajes.size(); counter++)
                         if(categoriasSeleccionadas.contains(counter) && puntajes.get(counter) == puntajes.get(position))
                             categoriasRepetidas.add(counter);
                    
                
                 if(categoriasRepetidas.size() > 1){
                    Random rnd = new Random();
                    return categoriasRepetidas.get(rnd.nextInt(categoriasRepetidas.size()));
                 }
                 else
                    return puntajes.indexOf(Collections.max(puntajes));
            }
        }
        return -1;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GroupOpciones = new javax.swing.ButtonGroup();
        jPIngreso = new javax.swing.JPanel();
        jPPage1 = new javax.swing.JPanel();
        titleEvaluacion = new javax.swing.JLabel();
        jPanelPreguntas = new javax.swing.JPanel();
        pregunta_label = new javax.swing.JLabel();
        opcion1_radiobutton = new javax.swing.JRadioButton();
        opcion2_radiobutton = new javax.swing.JRadioButton();
        opcion3_radiobutton = new javax.swing.JRadioButton();
        opcion4_radiobutton = new javax.swing.JRadioButton();
        elegir_button = new javax.swing.JButton();
        atras_button = new javax.swing.JButton();
        jBackGround = new javax.swing.JLabel();
        jPanelLateral = new javax.swing.JPanel();
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

        titleEvaluacion.setFont(new java.awt.Font("Dosis", 1, 36)); // NOI18N
        jPPage1.add(titleEvaluacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 500, 60));

        jPanelPreguntas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Berlin Sans FB", 0, 24), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanelPreguntas.setOpaque(false);
        jPanelPreguntas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pregunta_label.setFont(new java.awt.Font("Berlin Sans FB", 0, 22)); // NOI18N
        pregunta_label.setForeground(new java.awt.Color(0, 153, 240));
        pregunta_label.setToolTipText("");
        jPanelPreguntas.add(pregunta_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 610, 70));

        GroupOpciones.add(opcion1_radiobutton);
        opcion1_radiobutton.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        opcion1_radiobutton.setContentAreaFilled(false);
        opcion1_radiobutton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        opcion1_radiobutton.setFocusable(false);
        opcion1_radiobutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_circled_20px.png"))); // NOI18N
        opcion1_radiobutton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_bubble_20px_1.png"))); // NOI18N
        opcion1_radiobutton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                opcion1_radiobuttonMouseMoved(evt);
            }
        });
        opcion1_radiobutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion1_radiobuttonActionPerformed(evt);
            }
        });
        jPanelPreguntas.add(opcion1_radiobutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        GroupOpciones.add(opcion2_radiobutton);
        opcion2_radiobutton.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        opcion2_radiobutton.setContentAreaFilled(false);
        opcion2_radiobutton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        opcion2_radiobutton.setFocusable(false);
        opcion2_radiobutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_circled_20px.png"))); // NOI18N
        opcion2_radiobutton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_bubble_20px_1.png"))); // NOI18N
        opcion2_radiobutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion2_radiobuttonActionPerformed(evt);
            }
        });
        jPanelPreguntas.add(opcion2_radiobutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        GroupOpciones.add(opcion3_radiobutton);
        opcion3_radiobutton.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        opcion3_radiobutton.setContentAreaFilled(false);
        opcion3_radiobutton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        opcion3_radiobutton.setFocusable(false);
        opcion3_radiobutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_circled_20px.png"))); // NOI18N
        opcion3_radiobutton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_bubble_20px_1.png"))); // NOI18N
        opcion3_radiobutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion3_radiobuttonActionPerformed(evt);
            }
        });
        jPanelPreguntas.add(opcion3_radiobutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        GroupOpciones.add(opcion4_radiobutton);
        opcion4_radiobutton.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        opcion4_radiobutton.setContentAreaFilled(false);
        opcion4_radiobutton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        opcion4_radiobutton.setFocusable(false);
        opcion4_radiobutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_circled_20px.png"))); // NOI18N
        opcion4_radiobutton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_bubble_20px_1.png"))); // NOI18N
        opcion4_radiobutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion4_radiobuttonActionPerformed(evt);
            }
        });
        jPanelPreguntas.add(opcion4_radiobutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        elegir_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_checked_80px_2.png"))); // NOI18N
        elegir_button.setBorderPainted(false);
        elegir_button.setContentAreaFilled(false);
        elegir_button.setEnabled(false);
        elegir_button.setFocusPainted(false);
        elegir_button.setFocusable(false);
        elegir_button.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_checked_80px_1.png"))); // NOI18N
        elegir_button.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_checked_80px_1.png"))); // NOI18N
        elegir_button.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_checked_80px_1.png"))); // NOI18N
        elegir_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elegir_buttonActionPerformed(evt);
            }
        });
        jPanelPreguntas.add(elegir_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, 70, 60));

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
        jPanelPreguntas.add(atras_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 228, 70, 70));

        jPPage1.add(jPanelPreguntas, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 770, 320));

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atras_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atras_buttonActionPerformed
        Dialogs d = new Dialogs(20);
        d.setVisible(true);
    }//GEN-LAST:event_atras_buttonActionPerformed

    private void opcion4_radiobuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion4_radiobuttonActionPerformed
        this.opcionSeleccionada = 3;
        elegir_button.setEnabled(true);
    }//GEN-LAST:event_opcion4_radiobuttonActionPerformed

    private void opcion3_radiobuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion3_radiobuttonActionPerformed
        this.opcionSeleccionada = 2;
        elegir_button.setEnabled(true);
    }//GEN-LAST:event_opcion3_radiobuttonActionPerformed

    private void opcion2_radiobuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion2_radiobuttonActionPerformed
        this.opcionSeleccionada = 1;
        elegir_button.setEnabled(true);
    }//GEN-LAST:event_opcion2_radiobuttonActionPerformed

    private void opcion1_radiobuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion1_radiobuttonActionPerformed
        this.opcionSeleccionada = 0;
        elegir_button.setEnabled(true);        
    }//GEN-LAST:event_opcion1_radiobuttonActionPerformed

    private void elegir_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elegir_buttonActionPerformed
        Dialogs d;
        if(!opcion1_radiobutton.isSelected() && !opcion2_radiobutton.isSelected() && !opcion3_radiobutton.isSelected() && !opcion4_radiobutton.isSelected()){
            d = new Dialogs(15);//DEBE SELECCIONAR UNA RESPUESTA
            d.setVisible(true);
            return;
        }

        if(!flag){
            if(opcionSeleccionada == posRespuestaCorrecta){
                d = new Dialogs(16);// RESPUESTA CORRECTA
                d.setVisible(true);
                puntajes.set(categoriaP, puntajes.get(categoriaP) + 10);
                aciertoPregunta = 1;
            }
            else{
                d = new Dialogs(17);// RESPUESTA INCORRECTA
                d.setVisible(true);
                aciertoPregunta = 0;
            }
        }
        else{
            if(opcionSeleccionada == posRespuestaCorrecta){
                d = new Dialogs(16);//RESPUESTA CORRECTA
                d.setVisible(true);
                puntajeEspecifico += 10;
            }
            else{
            d = new Dialogs(17);// RESPUESTA INCORRECTA
            d.setVisible(true);
            }
        }

        System.out.println("\n Backend: " + puntajes.get(0) + "%" + "\n Frontend: " + puntajes.get(1) + "%" + "\n DevOps: " + puntajes.get(2) + "%" + "\n UIX: " + puntajes.get(3) + "%" + "\n QA: " + puntajes.get(4) + "%");

        counterPregunta--;

        if(counterPregunta == -1 && !flag){
            counterPregunta = 9;
            categoriaP++;
            aciertoPregunta = -1;
        }
        
        if(categoriaP > 4 && !flag){
            //RESULTADOS PRUEBA GENERAL
            d = new Dialogs(puntajes.get(0),puntajes.get(1),puntajes.get(2),puntajes.get(3),puntajes.get(4));
            d.setVisible(true);
            cargarResultadosEvaluacionGeneralDatabase();
        }

        if(!flag)
        sistemaEvaluacion(counterPregunta, categoriaP, aciertoPregunta);
        else if(flag && counterPregunta != -1)
        sistemaEvaluacionEspecifico(counterPregunta);
        else{
            cargarResultadosEvaluacionEspecificaDatabase();
            fpf.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_elegir_buttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setState(Formulario_Postulante_Info_Personal.ICONIFIED);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void opcion1_radiobuttonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcion1_radiobuttonMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_opcion1_radiobuttonMouseMoved

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GroupOpciones;
    private javax.swing.JButton atras_button;
    private javax.swing.JButton elegir_button;
    private javax.swing.JLabel jBackGround;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPIngreso;
    private javax.swing.JPanel jPPage1;
    private javax.swing.JPanel jPanelLateral;
    private javax.swing.JPanel jPanelPreguntas;
    private javax.swing.JPanel jPanelSuperior;
    private javax.swing.JRadioButton opcion1_radiobutton;
    private javax.swing.JRadioButton opcion2_radiobutton;
    private javax.swing.JRadioButton opcion3_radiobutton;
    private javax.swing.JRadioButton opcion4_radiobutton;
    private javax.swing.JLabel pregunta_label;
    private javax.swing.JLabel titleEvaluacion;
    // End of variables declaration//GEN-END:variables
}