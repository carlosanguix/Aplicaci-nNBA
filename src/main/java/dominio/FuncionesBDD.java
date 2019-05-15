package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;



public class FuncionesBDD {
	
	
	// TODO Para modificar un jugador probablemente tengamos que eliminar el seleccionado usando sus datos para eliminarlo y añadir uno nuevo con los datos modificados
	public static Connection conectar() {
		
		try {
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nba?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "daw", "daw");
			
			return con;
			
		} catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return null;
		
	}
	
	public static ResultSet consultaJugadores(int codigo, String nombre, String procedencia, String altura, int peso, String posicion, String equipo) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		
		String selectSQL = "SELECT * FROM jugadores WHERE codigo = ? and Nombre like ? and Procedencia like ? and Altura like ? and Peso = ? and Posicion like ? and Nombre_equipo like ?";

		try {
			dbConnection = conectar();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, codigo);
			preparedStatement.setString(2, nombre);
			preparedStatement.setString(3, procedencia);
			preparedStatement.setString(4, altura);
			preparedStatement.setInt(5, peso);
			preparedStatement.setString(6, posicion);
			preparedStatement.setString(7, equipo);

			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();
			
			return rs;
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			
		}
		return null;

	}
	
	public static ResultSet consultar(PreparedStatement pst) {
		
		try {
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nba", "daw", "daw");
			Statement st = con.createStatement();
			ResultSet rs = pst.executeQuery();
			
			return rs;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return null;
		
	}
	
	public static PreparedStatement insertJugador(int codigo, String nombre, String procedencia, String altura, int peso, String posicion, String equipo) {
		
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
