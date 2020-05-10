package Models;

public class Quiz {

    private String pregunta, respuesta;
    private int categoria, idpregunta, idrespuesta, dificultad;

    public Quiz() {
        
    }
    
    public void setPregunta(String pregunta){
        this.pregunta = pregunta;
    }
    
    public void setRespuesta(String respuesta){
        this.respuesta = respuesta;
    }
    
    public void setCategoria(int categoria){
        this.categoria = categoria;
    }
    
    public void setIDPregunta(int idpregunta){
        this.idpregunta = idpregunta;
    }
    
    public void setIDRespuesta(int idrespuesta){
        this.idrespuesta = idrespuesta;
    }
    
    public void setDificultad(int dificultad){
        this.dificultad = dificultad;
    }
    
    public String getPregunta(){
        return pregunta;
    }
    
    public String getRespuesta(){
        return respuesta;
    }
    
    public int setCategoria(){
        return categoria;
    }
    
    public int setIDPregunta(){
        return idpregunta;
    }
    
    public int setIDRespuesta(){
        return idrespuesta;
    }
    
    public int setDificultad(){
        return dificultad;
    }
}