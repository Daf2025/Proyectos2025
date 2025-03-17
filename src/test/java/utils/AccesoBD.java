package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoBD {

	public static Connection abrirConexionBD(
		String server,
		String port,
		String dbName,
		String user,
		String password) throws ClassNotFoundException, SQLException {
		String dbUrl = "jdbc:mysql://" +
						server + ":" + port + "/" + dbName;
		
		System.out.println(dbUrl);
		
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(dbUrl, user, password);
		
		return con;
	}
	
	public static ResultSet ejecutarQuery(
			Connection con,
			String query) throws SQLException{
		
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		
		return rs;
		
	}
	
	public static void cerrarConexionBD(Connection con) throws SQLException{
		
	}
		
}
	

