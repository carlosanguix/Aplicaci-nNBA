package controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dominio.FuncionesBDD;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ContVentanaPrincipal implements Initializable{

	@FXML private VBox vboxIzq;
	@FXML private ImageView nbaLogo;
	@FXML private Button botonJugadores;
	@FXML private Button botonEquipos;
	@FXML private Button botonEstadisticas;

	@FXML private AnchorPane contenedorTablas;
    @FXML private ImageView fondo;

	Node nodeJugadores;
	Node nodeEquipos;
			
	public ContVentanaPrincipal() {

		try {
			this.nodeJugadores = FXMLLoader.load(getClass().getResource("/FXML/tablaJugadores.fxml"));
			this.nodeEquipos = FXMLLoader.load(getClass().getResource("/FXML/tablaEquipos.fxml"));
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}

	}

	public void initialize(URL location, ResourceBundle resources) {

		aplicarEstilos();

		botonEquipos.setOnAction(evento -> {

			mostrarTablaEquipos();

		});

		botonJugadores.setOnAction(evento -> {

			mostrarTablaJugadores();

		});

	}

	

	public void mostrarTablaJugadores() {

		// TODO cuando añadimos un jugador se ven las dos tablas a la vez
		try {

			this.nodeJugadores = FXMLLoader.load(getClass().getResource("/FXML/tablaJugadores.fxml"));
			this.nodeJugadores.setVisible(true);

		} catch (IOException e) {

			e.printStackTrace();

		}

		contenedorTablas.getChildren().clear();
		contenedorTablas.getChildren().add(this.nodeJugadores);

	}

	public void mostrarTablaEquipos() {
		
		try {
			
			this.nodeEquipos = FXMLLoader.load(getClass().getResource("/FXML/tablaEquipos.fxml"));
			this.nodeEquipos.setVisible(true);

		} catch (IOException e) {

			e.printStackTrace();

		}

		contenedorTablas.getChildren().clear();
		contenedorTablas.getChildren().add(this.nodeEquipos);

	}
	
	public void aplicarEstilos() {

		URL rutaImg;
		Image imagenRecogida;
		ImageView imagen;
		
//		rutaImg = getClass().getResource("/logosNba/AAnbaLogo.png");
//		imagenRecogida = new Image(rutaImg.toString());
//		fondo.setImage(imagenRecogida);

		rutaImg = getClass().getResource("/logosNba/AAnbaLogo.png");
		imagenRecogida = new Image(rutaImg.toString());
		nbaLogo.setImage(imagenRecogida);

		rutaImg = getClass().getResource("/logosNba/logoBotonJugadores.png");
		imagenRecogida = new Image(rutaImg.toString());
		imagen = new ImageView(imagenRecogida);
		imagen.setFitHeight(40);
		imagen.setFitWidth(40);
		botonJugadores.setGraphic(imagen);

		rutaImg = getClass().getResource("/logosNba/logoBotonEquipos.png");
		imagenRecogida = new Image(rutaImg.toString());
		imagen = new ImageView(imagenRecogida);
		imagen.setFitHeight(45);
		imagen.setFitWidth(40);
		botonEquipos.setGraphic(imagen);

		rutaImg = getClass().getResource("/logosNba/logoBotonEstadisticas.png");
		imagenRecogida = new Image(rutaImg.toString());
		imagen = new ImageView(imagenRecogida);
		imagen.setFitHeight(45);
		imagen.setFitWidth(40);
		botonEstadisticas.setGraphic(imagen);

	}

}