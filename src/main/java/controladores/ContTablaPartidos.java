package controladores;

import java.net.URL;
import java.util.ResourceBundle;

import dominio.Partido;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ContTablaPartidos implements Initializable {

	@FXML
	private TableView<Partido> tablaPartidos;
	@FXML private TableColumn<Partido, String> codigoPartido;
	@FXML private TableColumn<Partido, String> equipoLocal;
	@FXML private TableColumn<Partido, String> equipoVisitante;
	@FXML private TableColumn<Partido, String> puntosLocal;
	@FXML private TableColumn<Partido, String> puntosVisitante;
	@FXML private TableColumn<Partido, String> temporada;

	@Override
	public void initialize(URL location, ResourceBundle resources) {



	}

}
