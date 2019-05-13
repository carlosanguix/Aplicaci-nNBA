package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class FuncionesBDD {
	
	
	// TODO Para modificar un jugador probablemente tengamos que eliminar el seleccionado usando sus datos para eliminarlo y añadir uno nuevo con los datos modificados
	public static ResultSet conectarConsulta(String consulta1) {
		
		try {
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nba", "daw", "daw");
			Statement st = con.createStatement();
			ResultSet consulta = st.executeQuery(consulta1);
			
			return consulta;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static PreparedStatement conectarInsertJugador(int codigo, String nombre, String procedencia, String altura, int peso, String posicion, String equipo) {
		
		Connection con;
		String querry = "insert into jugadores (codigo, Nombre, Procedencia, Altura, Peso, Posicion, Nombre_equipo)" + " values (?, ?, ?, ?, ?, ?, ?);";
		
		try {
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nba", "daw", "daw");
			PreparedStatement prepSt = con.prepareStatement(querry);
			prepSt.setInt(1, codigo);
			prepSt.setString(2, nombre);
			prepSt.setString(3, procedencia); 
			prepSt.setString(4, altura);
			prepSt.setInt(5, peso);
			prepSt.setString(6, posicion);
			prepSt.setString(7, equipo);
			
			prepSt.execute();
			
			return prepSt;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return null;
		
	}
	
}
