package Models;

public class Seleccionado implements Comparable<Seleccionado> {
    
    private int idpostulante, puntaje, idcategoria;
    
    public Seleccionado(){

    }
    
    public void setIDPostulante(int idpostulante){
        this.idpostulante = idpostulante;
    }
    
    public void setPuntaje(int puntaje){
        this.puntaje = puntaje;
    }
    
    public void setIDCategoria(int idcategoria){
        this.idcategoria = idcategoria;
    }
    
    public int getIDPostulante(){
        return idpostulante;
    }
    
    public int getPuntaje(){
        return puntaje;
    }
    
    public int getIDCategoria(){
        return idcategoria;
    }

    @Override
    public int compareTo(Seleccionado t) {
        return this.puntaje - t.getPuntaje();
    }
}