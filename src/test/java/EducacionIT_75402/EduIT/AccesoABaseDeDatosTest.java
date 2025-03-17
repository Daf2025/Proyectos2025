package EducacionIT_75402.EduIT;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.testng.annotations.Test;

import utils.AccesoBD;

public class AccesoABaseDeDatosTest {

	@Test
	public void testBaseDeDatos() throws ClassNotFoundException, SQLException{
		
		Connection con = AccesoBD.abrirConexionBD(
				"localhost", 
				"3306", 
				"db", 
				"root", 
				"root");
		
		String query = "select * from empleados;";
		
		ResultSet rs = AccesoBD.ejecutarQuery(con, query);
		
		while (rs.next()) {
			String myID = rs.getString(1);
			String myName = rs.getString(2);
			String myAge = rs.getString(3);
			System.out.println(myID + " " + myName + " " + myAge);
			
		}
		
		System.out.println("Resultados de la Consulta a la Base de Datos");
		System.out.println("Prueba exitosa!");
	}
	
}
