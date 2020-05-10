package Controllers;

import com.google.gson.*;
import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Administracion_json {
    
	private JsonParser parser;
	private FileReader tiposDeProyectos, postulantes;
	private FileWriter postulantes_w;
	private JsonElement datosJson_tiposDeProyectos, datosJson_herramientas;
	private Gson gson;
        Connection connection;
	
	public Administracion_json(Connection connection) {
                this.connection = connection;
		parser = new JsonParser();
		try { tiposDeProyectos = new FileReader("datos\\tiposDeProyectos.json"); } 
		catch (IOException e) { e.printStackTrace(); }
		datosJson_tiposDeProyectos = parser.parse(tiposDeProyectos);
		postulantes_w = null;
        }
        
        public void querySQL(){
            
            try {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `proyectos` (`idproyecto`, `nombre`, `categoria`) VALUES (NULL, ?, ?)");
                ps.setString(1, "Ruby");
                ps.setString(2, "Web");
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Administracion_json.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
	
	public String[] obtener_herramientas(String tipo){
    	String[] lista_herramientas;
    	int cont=0;
    	datosJson_herramientas = datosJson_tiposDeProyectos.getAsJsonObject().get(tipo);
    	JsonArray array = datosJson_herramientas.getAsJsonArray();
        lista_herramientas = new String [array.size()];
        java.util.Iterator<JsonElement> iter = array.iterator();
        while (iter.hasNext()) {
        	JsonElement entrada = iter.next();
        	lista_herramientas[cont++]=entrada.getAsString();;
        }
        return lista_herramientas;
    }
}