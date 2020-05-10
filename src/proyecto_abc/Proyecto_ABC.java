package proyecto_abc;

import Models.Postulante;
import Views.Menu_Principal;
import Database.DatabaseConnection;
import Views.Intro;

public class Proyecto_ABC {

    public static void main(String[] args) {
        
        // Conectando a la base de datos.
        DatabaseConnection connection = new DatabaseConnection();
        
        // Vista menu enviando como parametro la conexion para la base de datos.
        Menu_Principal menu = new Menu_Principal(connection.getConnection());
        
        
        // Haciendo visible el menu de opciones de la aplicacion.
        //Primero se muestra la intro, y pasado 5 seg se pasa al menú principal
        Intro intro = new Intro();
        intro.setVisible(true);
        
        new java.util.Timer().schedule( 
           new java.util.TimerTask() {            
                public void run() {        
                intro.setVisible(false);
                menu.setVisible(true);
            }
        }, 
        5000) ; 
        
        
        
       
    }
}