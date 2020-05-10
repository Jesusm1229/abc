package Controllers;
import Models.Quiz;
import Views.Formulario_Postulante_Conocimientos;
import java.sql.*;
import java.util.*;
import java.util.logging.*;

public class Metodos_Sistema_Experto {
	
	private ArrayList<Quiz> listadoBackendEasy, listadoBackendHard;
	private ArrayList<Quiz> listadoFrontendEasy,listadoFrontendHard;
	private ArrayList<Quiz> listadoQAEasy, listadoQAHard;
	private ArrayList<Quiz> listadoDevOpsEasy, listadoDevOpsHard;
	private ArrayList<Quiz> listadoUIXEasy, listadoUIXHard;
        
        private ArrayList<Quiz> listadoEspecifico;
        
        private Connection connection;
	
	public Metodos_Sistema_Experto(Connection connection) {
                this.connection = connection;
                
		//crearListadoPreguntas();
                buscarpreguntasBackend();
                buscarpreguntasFrontend();
                buscarpreguntasDevOps();
                buscarpreguntasUIX();
                buscarpreguntasQA();
                
                // Metodo Aleatorio.
                crearListadoPreguntas();
	}
        
        public ArrayList<Quiz> aleatorio(ArrayList<Quiz> listado){
            
            ArrayList<Quiz>array= listado;
                
            Collections.shuffle(array);
            return array;
	}
        
        public void crearListadoPreguntas() {
		listadoBackendEasy = aleatorio(listadoBackendEasy);
		listadoBackendHard = aleatorio(listadoBackendHard);
                listadoFrontendEasy = aleatorio(listadoFrontendEasy);
                listadoFrontendHard = aleatorio(listadoFrontendHard);
                listadoDevOpsEasy = aleatorio(listadoDevOpsEasy);
                listadoDevOpsHard = aleatorio(listadoDevOpsHard);
                listadoUIXEasy = aleatorio(listadoUIXEasy);
                listadoUIXHard = aleatorio(listadoUIXHard);
                listadoQAEasy = aleatorio(listadoQAEasy);
                listadoQAHard = aleatorio(listadoQAHard);
	}
        
        // Metodo para buscar las preguntas y respuestas de la categoria Backend.
        public void buscarpreguntasBackend(){
        
            listadoBackendEasy = new ArrayList();
            listadoBackendHard = new ArrayList();
            
            try{
            
                // Buscando las preguntas faciles.
                ResultSet rs_preguntaeasy = connection.prepareStatement("SELECT * FROM preguntas WHERE `idcategoria` = 1 AND `dificultad` = 0" ).executeQuery();

                while(rs_preguntaeasy.next()){

                    Quiz quiz = new Quiz();

                    quiz.setIDPregunta(rs_preguntaeasy.getInt(1));
                    quiz.setPregunta(rs_preguntaeasy.getString(2));
                    quiz.setDificultad(rs_preguntaeasy.getInt(3));
                    quiz.setCategoria(rs_preguntaeasy.getInt(4));
                    quiz.setIDRespuesta(rs_preguntaeasy.getInt(5));

                    // Buscando la respuesta de dicha pregunta en la base de datos.
                    ResultSet rs_respuesta = connection.prepareStatement("SELECT * FROM respuestas WHERE `idrespuesta` = " + rs_preguntaeasy.getInt(5) ).executeQuery();

                    if(rs_respuesta.next())
                        quiz.setRespuesta(rs_respuesta.getString(2));

                    listadoBackendEasy.add(quiz);
                }
                
                  // Buscando las preguntas dificiles.
                ResultSet rs_preguntahard = connection.prepareStatement("SELECT * FROM preguntas WHERE `idcategoria` = 1 AND `dificultad` = 1" ).executeQuery();

                while(rs_preguntahard.next()){

                    Quiz quiz = new Quiz();

                    quiz.setIDPregunta(rs_preguntahard.getInt(1));
                    quiz.setPregunta(rs_preguntahard.getString(2));
                    quiz.setDificultad(rs_preguntahard.getInt(3));
                    quiz.setCategoria(rs_preguntahard.getInt(4));
                    quiz.setIDRespuesta(rs_preguntahard.getInt(5));

                    // Buscando la respuesta de dicha pregunta en la base de datos.
                    ResultSet rs_respuesta = connection.prepareStatement("SELECT * FROM respuestas WHERE `idrespuesta` = " + rs_preguntahard.getInt(5) ).executeQuery();

                    if(rs_respuesta.next())
                        quiz.setRespuesta(rs_respuesta.getString(2));

                    listadoBackendHard.add(quiz);
                }
            
            }catch (SQLException ex) {
                    Logger.getLogger(Formulario_Postulante_Conocimientos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
          // Metodo para buscar las preguntas y respuestas de la categoria Frontend.
        public void buscarpreguntasFrontend(){
        
            listadoFrontendEasy = new ArrayList();
            listadoFrontendHard = new ArrayList();
            
            try{
            
                // Buscando las preguntas faciles.
                ResultSet rs_preguntaeasy = connection.prepareStatement("SELECT * FROM preguntas WHERE `idcategoria` = 2 AND `dificultad` = 0" ).executeQuery();

                while(rs_preguntaeasy.next()){

                    Quiz quiz = new Quiz();

                    quiz.setIDPregunta(rs_preguntaeasy.getInt(1));
                    quiz.setPregunta(rs_preguntaeasy.getString(2));
                    quiz.setDificultad(rs_preguntaeasy.getInt(3));
                    quiz.setCategoria(rs_preguntaeasy.getInt(4));
                    quiz.setIDRespuesta(rs_preguntaeasy.getInt(5));

                    // Buscando la respuesta de dicha pregunta en la base de datos.
                    ResultSet rs_respuesta = connection.prepareStatement("SELECT * FROM respuestas WHERE `idrespuesta` = " + rs_preguntaeasy.getInt(5) ).executeQuery();

                    if(rs_respuesta.next())
                        quiz.setRespuesta(rs_respuesta.getString(2));

                    listadoFrontendEasy.add(quiz);
                }
                
                  // Buscando las preguntas dificiles.
                ResultSet rs_preguntahard = connection.prepareStatement("SELECT * FROM preguntas WHERE `idcategoria` = 2 AND `dificultad` = 1" ).executeQuery();

                while(rs_preguntahard.next()){

                    Quiz quiz = new Quiz();

                    quiz.setIDPregunta(rs_preguntahard.getInt(1));
                    quiz.setPregunta(rs_preguntahard.getString(2));
                    quiz.setDificultad(rs_preguntahard.getInt(3));
                    quiz.setCategoria(rs_preguntahard.getInt(4));
                    quiz.setIDRespuesta(rs_preguntahard.getInt(5));

                    // Buscando la respuesta de dicha pregunta en la base de datos.
                    ResultSet rs_respuesta = connection.prepareStatement("SELECT * FROM respuestas WHERE `idrespuesta` = " + rs_preguntahard.getInt(5) ).executeQuery();

                    if(rs_respuesta.next())
                        quiz.setRespuesta(rs_respuesta.getString(2));

                    listadoFrontendHard.add(quiz);
                }
            
            }catch (SQLException ex) {
                    Logger.getLogger(Formulario_Postulante_Conocimientos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
          // Metodo para buscar las preguntas y respuestas de la categoria DevOps.
        public void buscarpreguntasDevOps(){
        
            listadoDevOpsEasy = new ArrayList();
            listadoDevOpsHard = new ArrayList();
            
            try{
            
                // Buscando las preguntas faciles.
                ResultSet rs_preguntaeasy = connection.prepareStatement("SELECT * FROM preguntas WHERE `idcategoria` = 3 AND `dificultad` = 0" ).executeQuery();

                while(rs_preguntaeasy.next()){

                    Quiz quiz = new Quiz();

                    quiz.setIDPregunta(rs_preguntaeasy.getInt(1));
                    quiz.setPregunta(rs_preguntaeasy.getString(2));
                    quiz.setDificultad(rs_preguntaeasy.getInt(3));
                    quiz.setCategoria(rs_preguntaeasy.getInt(4));
                    quiz.setIDRespuesta(rs_preguntaeasy.getInt(5));

                    // Buscando la respuesta de dicha pregunta en la base de datos.
                    ResultSet rs_respuesta = connection.prepareStatement("SELECT * FROM respuestas WHERE `idrespuesta` = " + rs_preguntaeasy.getInt(5) ).executeQuery();

                    if(rs_respuesta.next())
                        quiz.setRespuesta(rs_respuesta.getString(2));

                    listadoDevOpsEasy.add(quiz);
                }
                
                  // Buscando las preguntas dificiles.
                ResultSet rs_preguntahard = connection.prepareStatement("SELECT * FROM preguntas WHERE `idcategoria` = 3 AND `dificultad` = 1" ).executeQuery();

                while(rs_preguntahard.next()){

                    Quiz quiz = new Quiz();

                    quiz.setIDPregunta(rs_preguntahard.getInt(1));
                    quiz.setPregunta(rs_preguntahard.getString(2));
                    quiz.setDificultad(rs_preguntahard.getInt(3));
                    quiz.setCategoria(rs_preguntahard.getInt(4));
                    quiz.setIDRespuesta(rs_preguntahard.getInt(5));

                    // Buscando la respuesta de dicha pregunta en la base de datos.
                    ResultSet rs_respuesta = connection.prepareStatement("SELECT * FROM respuestas WHERE `idrespuesta` = " + rs_preguntahard.getInt(5) ).executeQuery();

                    if(rs_respuesta.next())
                        quiz.setRespuesta(rs_respuesta.getString(2));

                    listadoDevOpsHard.add(quiz);
                }
            
            }catch (SQLException ex) {
                    Logger.getLogger(Formulario_Postulante_Conocimientos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
           // Metodo para buscar las preguntas y respuestas de la categoria UIX.
        public void buscarpreguntasUIX(){
        
            listadoUIXEasy = new ArrayList();
            listadoUIXHard = new ArrayList();
            
            try{
            
                // Buscando las preguntas faciles.
                ResultSet rs_preguntaeasy = connection.prepareStatement("SELECT * FROM preguntas WHERE `idcategoria` = 4 AND `dificultad` = 0" ).executeQuery();

                while(rs_preguntaeasy.next()){

                    Quiz quiz = new Quiz();

                    quiz.setIDPregunta(rs_preguntaeasy.getInt(1));
                    quiz.setPregunta(rs_preguntaeasy.getString(2));
                    quiz.setDificultad(rs_preguntaeasy.getInt(3));
                    quiz.setCategoria(rs_preguntaeasy.getInt(4));
                    quiz.setIDRespuesta(rs_preguntaeasy.getInt(5));

                    // Buscando la respuesta de dicha pregunta en la base de datos.
                    ResultSet rs_respuesta = connection.prepareStatement("SELECT * FROM respuestas WHERE `idrespuesta` = " + rs_preguntaeasy.getInt(5) ).executeQuery();

                    if(rs_respuesta.next())
                        quiz.setRespuesta(rs_respuesta.getString(2));

                    listadoUIXEasy.add(quiz);
                }
                
                  // Buscando las preguntas dificiles.
                ResultSet rs_preguntahard = connection.prepareStatement("SELECT * FROM preguntas WHERE `idcategoria` = 4 AND `dificultad` = 1" ).executeQuery();

                while(rs_preguntahard.next()){

                    Quiz quiz = new Quiz();

                    quiz.setIDPregunta(rs_preguntahard.getInt(1));
                    quiz.setPregunta(rs_preguntahard.getString(2));
                    quiz.setDificultad(rs_preguntahard.getInt(3));
                    quiz.setCategoria(rs_preguntahard.getInt(4));
                    quiz.setIDRespuesta(rs_preguntahard.getInt(5));

                    // Buscando la respuesta de dicha pregunta en la base de datos.
                    ResultSet rs_respuesta = connection.prepareStatement("SELECT * FROM respuestas WHERE `idrespuesta` = " + rs_preguntahard.getInt(5) ).executeQuery();

                    if(rs_respuesta.next())
                        quiz.setRespuesta(rs_respuesta.getString(2));

                    listadoUIXHard.add(quiz);
                }
            
            }catch (SQLException ex) {
                    Logger.getLogger(Formulario_Postulante_Conocimientos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
          // Metodo para buscar las preguntas y respuestas de la categoria UIX.
        public void buscarpreguntasQA(){
        
            listadoQAEasy = new ArrayList();
            listadoQAHard = new ArrayList();
            
            try{
            
                // Buscando las preguntas faciles.
                ResultSet rs_preguntaeasy = connection.prepareStatement("SELECT * FROM preguntas WHERE `idcategoria` = 5 AND `dificultad` = 0" ).executeQuery();

                while(rs_preguntaeasy.next()){

                    Quiz quiz = new Quiz();

                    quiz.setIDPregunta(rs_preguntaeasy.getInt(1));
                    quiz.setPregunta(rs_preguntaeasy.getString(2));
                    quiz.setDificultad(rs_preguntaeasy.getInt(3));
                    quiz.setCategoria(rs_preguntaeasy.getInt(4));
                    quiz.setIDRespuesta(rs_preguntaeasy.getInt(5));

                    // Buscando la respuesta de dicha pregunta en la base de datos.
                    ResultSet rs_respuesta = connection.prepareStatement("SELECT * FROM respuestas WHERE `idrespuesta` = " + rs_preguntaeasy.getInt(5) ).executeQuery();

                    if(rs_respuesta.next())
                        quiz.setRespuesta(rs_respuesta.getString(2));

                    listadoQAEasy.add(quiz);
                }
                
                  // Buscando las preguntas dificiles.
                ResultSet rs_preguntahard = connection.prepareStatement("SELECT * FROM preguntas WHERE `idcategoria` = 5 AND `dificultad` = 1" ).executeQuery();

                while(rs_preguntahard.next()){

                    Quiz quiz = new Quiz();

                    quiz.setIDPregunta(rs_preguntahard.getInt(1));
                    quiz.setPregunta(rs_preguntahard.getString(2));
                    quiz.setDificultad(rs_preguntahard.getInt(3));
                    quiz.setCategoria(rs_preguntahard.getInt(4));
                    quiz.setIDRespuesta(rs_preguntahard.getInt(5));

                    // Buscando la respuesta de dicha pregunta en la base de datos.
                    ResultSet rs_respuesta = connection.prepareStatement("SELECT * FROM respuestas WHERE `idrespuesta` = " + rs_preguntahard.getInt(5) ).executeQuery();

                    if(rs_respuesta.next())
                        quiz.setRespuesta(rs_respuesta.getString(2));

                    listadoQAHard.add(quiz);
                }
            
            }catch (SQLException ex) {
                    Logger.getLogger(Formulario_Postulante_Conocimientos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        // Metodo para buscar preguntas y respuestas acerca de una categoria en especifico. Esto sera para la evaluacion especifica.
        public void busquedaCategoriaEspecifica(int categoria){
        
            listadoEspecifico = new ArrayList();
            
            try{
                  // Buscando las preguntas dificiles.
                ResultSet rs_preguntahard = connection.prepareStatement("SELECT * FROM preguntas WHERE `idcategoria` = " + (categoria + 1) + " AND `dificultad` = 1" ).executeQuery();

                while(rs_preguntahard.next()){

                    Quiz quiz = new Quiz();

                    quiz.setIDPregunta(rs_preguntahard.getInt(1));
                    quiz.setPregunta(rs_preguntahard.getString(2));
                    quiz.setDificultad(rs_preguntahard.getInt(3));
                    quiz.setCategoria(rs_preguntahard.getInt(4));
                    quiz.setIDRespuesta(rs_preguntahard.getInt(5));

                    // Buscando la respuesta de dicha pregunta en la base de datos.
                    ResultSet rs_respuesta = connection.prepareStatement("SELECT * FROM respuestas WHERE `idrespuesta` = " + rs_preguntahard.getInt(5) ).executeQuery();

                    if(rs_respuesta.next())
                        quiz.setRespuesta(rs_respuesta.getString(2));

                    listadoEspecifico.add(quiz);
                }
            
            }catch (SQLException ex) {
                    Logger.getLogger(Formulario_Postulante_Conocimientos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public ArrayList<Quiz> getListadoBackendEasy(){
            return listadoBackendEasy;
        }
        
        public ArrayList<Quiz> getListadoFrontendEasy(){
            return listadoFrontendEasy;
        }
        
        public ArrayList<Quiz> getListadoDevOpsEasy(){
            return listadoDevOpsEasy;
        }
        
        public ArrayList<Quiz> getListadoUIXEasy(){
            return listadoUIXEasy;
        }
        
        public ArrayList<Quiz> getListadoQAEasy(){
            return listadoQAEasy;
        }
        
        public ArrayList<Quiz> getListadoBackendHard(){
            return listadoBackendHard;
        }
        
        public ArrayList<Quiz> getListadoFrontendHard(){
            return listadoFrontendHard;
        }
        
        public ArrayList<Quiz> getListadoDevOpsHard(){
            return listadoDevOpsHard;
        }
        
        public ArrayList<Quiz> getListadoUIXHard(){
            return listadoUIXHard;
        }
        
        public ArrayList<Quiz> getListadoQAHard(){
            return listadoQAHard;
        }
        
        public ArrayList<Quiz> getListadoEspecifico(){
            return listadoEspecifico;
        }
        
	/*
	public int obtenerPreguntaBackend() {
		int preguntaB = listadoBackend.remove(indiceListBack);
		indiceListBack -= 1;
		return preguntaB;
	}
	
	public int obtenerPreguntaFrontend() {
		int preguntaF = listadoFrontend.remove(indiceListFront);
		indiceListFront -= 1;
		return preguntaF;
	}
	
	public int obtenerPreguntaQA() {
		int preguntaQA = listadoQA.remove(indiceListQA);
		indiceListQA -= 1;
		return preguntaQA;
	}
	
	public int obtenerPreguntaDewps() {
		int preguntaD = listadoDewps.remove(indiceListDewps);
		indiceListDewps -= 1;
		return preguntaD;
	}
	
	public int obtenerPreguntaUIX() {
		int preguntaUIX = listadoUIX.remove(indiceListUIX);
		indiceListUIX -= 1;
		return preguntaUIX;
	}*/
}
