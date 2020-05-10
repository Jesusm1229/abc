package Database;

import java.sql.*;

public class DatabaseConnection {
	
	private static Connection connection;
	
	// Metodo para conectarnos a la base de datos.
	public DatabaseConnection() {
		connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/abcdatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
			
			if(connection != null)
				System.out.println("Conexion Establecida");
			
		} catch(Exception e) {
		        System.out.println("Error de Conexion " + e);
		}
	}
	
	// Metodo que nos retorna la conexion de la base de datos.
	public Connection getConnection() {
		return connection;
	}
	
	// Metodo para desconectarse de la base de datos.
	public void disconnect() {
		connection = null;
		
		if(connection == null)
			System.out.println("Conexion Desactivada");
	}
}