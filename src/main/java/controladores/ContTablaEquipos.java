package controladores;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dominio.Equipo;
import dominio.FuncionesBDD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ContTablaEquipos implements Initializable {
	
	// Consultas
    @FXML private TextField consNombre;
    @FXML private TextField consCiudad;
    @FXML private TextField consConferencia;
    @FXML private TextField consDivision;
    @FXML private Button botonRealizarConsulta;
	
    // Tabla
    @FXML
    private TableView<Equipo> tablaEquipos;
    @FXML private TableColumn<Equipo, String> nombreEquipo;
    @FXML private TableColumn<Equipo, String> ciudadEquipo;
    @FXML private TableColumn<Equipo, String> conferenciaEquipo;
    @FXML private TableColumn<Equipo, String> divisionEquipo;
	
    ObservableList<Equipo> tabla = FXCollections.observableArrayList();
    
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {

		pintarTablaConConsulta();
		
		nombreEquipo.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
		ciudadEquipo.setCellValueFactory(new PropertyValueFactory<>("Ciudad"));
		conferenciaEquipo.setCellValueFactory(new PropertyValueFactory<>("Conferencia"));
		divisionEquipo.setCellValueFactory(new PropertyValueFactory<>("Division"));
		tablaEquipos.setItems(tabla);
		
	}
	
	public void pintarTablaConConsulta() {
		
		try {
			
			ResultSet consulta = FuncionesBDD.conectarConsulta("select * from equipos;");
			
			while (consulta.next()) {
				
				String nombre = consulta.getString("Nombre");
				String ciudad = consulta.getString("Ciudad");
				String conferencia = consulta.getString("Conferencia");
				String division = consulta.getString("Division");
				
				Equipo equipo = new Equipo(nombre, ciudad, conferencia, division);
				tabla.add(equipo);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
			
		}
		
	}

}
