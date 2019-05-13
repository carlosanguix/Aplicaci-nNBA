package controladores;

import java.net.URL;
import java.util.ResourceBundle;

import dominio.Estadistica;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ContTablaEstadisticas implements Initializable {

    @FXML
    private TableView<Estadistica> tablaEquipos;
    @FXML private TableColumn<Estadistica, String> temporada;
    @FXML private TableColumn<Estadistica, String> jugadorEstadisticas;
    @FXML private TableColumn<Estadistica, String> puntosPartido;
    @FXML private TableColumn<Estadistica, String> asistenciasPartido;
    @FXML private TableColumn<Estadistica, String> taponesPartido;
    @FXML private TableColumn<Estadistica, String> rebotesPartido;
	
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		
    	
		
	}

}
