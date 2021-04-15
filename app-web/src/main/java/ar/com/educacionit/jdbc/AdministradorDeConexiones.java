package ar.com.educacionit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdministradorDeConexiones {
	
	public Connection obtenerConexion() throws Exception {
		String url = "jdbc:mysql://127.0.0.1:3306/jsweb-marzo/productos";
		String user = "root";
		String password = "root";
		
		String driverName = "com.mysql.cj.Driver";
		
		//crear una instancia para dicho driver
		try {
			Class.forName(driverName);
			Connection connection = DriverManager.getConnection(url,user,password);
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			throw e;
		}
	}
}
