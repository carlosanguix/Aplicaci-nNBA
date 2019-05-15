package controladores;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.sun.javafx.image.impl.ByteIndexed.Getter;

import dominio.FuncionesBDD;
import dominio.Jugador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ContTablaJugadores implements Initializable {


	@FXML private Button botonNuevoJugador;

	// Consultas
	@FXML private TextField consCodigo;
	@FXML private TextField consNombre;
	@FXML private TextField consProcedencia;
	@FXML private TextField consAltura;
	@FXML private TextField consPeso;
	@FXML private TextField consPosicion;
	@FXML private TextField consEquipo;
	@FXML private Button botonRealizarConsulta;

	// TODO Cambiar codigo y peso por integer (no solo aqui....)
	// Tabla
	@FXML
	private TableView<Jugador> tablaJugadores;
	@FXML private TableColumn<Jugador, Integer> codigoJugador;
	@FXML private TableColumn<Jugador, String> nombreJugador;
	@FXML private TableColumn<Jugador, String> procedenciaJugador;
	@FXML private TableColumn<Jugador, String> alturaJugador;
	@FXML private TableColumn<Jugador, Integer> pesoJugador;
	@FXML private TableColumn<Jugador, String> posicionJugador;
	@FXML private TableColumn<Jugador, String> equipoJugador;

	ObservableList<Jugador> tabla = FXCollections.observableArrayList();

	Node nodeNuevoJugador;

	public ContTablaJugadores() {

		try {

			this.nodeNuevoJugador = FXMLLoader.load(getClass().getResource("/FXML/ventanaAñadirJugador.fxml"));

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		aplicarEstilos();

		pintarTablaConConsulta();

		codigoJugador.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		nombreJugador.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		procedenciaJugador.setCellValueFactory(new PropertyValueFactory<>("procedencia"));
		alturaJugador.setCellValueFactory(new PropertyValueFactory<>("altura"));
		pesoJugador.setCellValueFactory(new PropertyValueFactory<>("peso"));
		posicionJugador.setCellValueFactory(new PropertyValueFactory<>("posicion"));
		equipoJugador.setCellValueFactory(new PropertyValueFactory<>("nombreEquipo"));
		tablaJugadores.setItems(tabla);

		this.botonNuevoJugador.setOnAction(evento -> {

			abrirFormularioNuevoJugador();

		});

		this.botonRealizarConsulta.setOnAction(evento -> {

			realizarConsulta();

		});

	}

	public void realizarConsulta() {

		int codigo = 0;
		String nombre = "";
		String procedencia = "";
		String altura = "";
		int peso = 0;
		String posicion = "";
		String equipo = "";

		if (!consCodigo.getText().isEmpty()) {
			codigo = Integer.parseInt(consCodigo.getText().toString());
		}
		if (!consNombre.getText().isEmpty()) {
			nombre = consNombre.getText().toString();
		}
		if (!consProcedencia.getText().isEmpty()) {
			procedencia = consProcedencia.getText().toString();
		}
		if (!consAltura.getText().isEmpty()) {
			altura = consAltura.getText().toString();
		}
		if (!consPeso.getText().isEmpty()) {
			peso = Integer.parseInt(consPeso.getText().toString());
		}
		if (!consPosicion.getText().isEmpty()) {
			posicion = consPosicion.getText().toString();
		}
		if (!consEquipo.getText().isEmpty()) {
			equipo = consEquipo.getText().toString();
		}

		try {

			ResultSet consulta = FuncionesBDD.consultaJugadores(codigo, nombre, procedencia, altura, peso, posicion, equipo);

			while (consulta.next()) {

				codigo = consulta.getInt("codigo");
				nombre = consulta.getString("Nombre");
				procedencia = consulta.getString("Procedencia");
				altura = consulta.getString("Altura");
				peso = consulta.getInt("Peso");
				posicion = consulta.getString("Posicion");
				equipo = consulta.getString("Nombre_equipo");

				Jugador jugador = new Jugador(codigo, nombre, procedencia, altura, peso, posicion, equipo);
				tabla.clear();
				tabla.add(jugador);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public void pintarTablaConConsulta() {

		try {

			Connection con = FuncionesBDD.conectar();
			PreparedStatement pst = con.prepareStatement("Select * from jugadores;");
			ResultSet consulta = FuncionesBDD.consultar(pst);

			while (consulta.next()) {

				int codigo = consulta.getInt("codigo");
				String nombre = consulta.getString("Nombre");
				String procedencia = consulta.getString("Procedencia");
				String altura = consulta.getString("Altura");
				int peso = consulta.getInt("Peso");
				String posicion = consulta.getString("Posicion");
				String nombreEquipo = consulta.getString("Nombre_equipo");

				Jugador jugador = new Jugador(codigo, nombre, procedencia, altura, peso, posicion, nombreEquipo);
				tabla.add(jugador);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public void abrirFormularioNuevoJugador() {

		Parent root = null;

		try {

			root = FXMLLoader.load(getClass().getResource("/FXML/ventanaAñadirJugador.fxml"));

		} catch (IOException e) {

			e.printStackTrace();

		}

		Scene sc = new Scene(root);
		Stage st = new Stage();
		st.setTitle("Nuevo jugador");
		st.setScene(sc);
		st.setResizable(false);
		st.show();

	}


	public void aplicarEstilos() {

		URL rutaImg;
		Image imagenRecogida;
		ImageView imagen;

		rutaImg = getClass().getResource("/logosNba/logoAñadir.png");
		imagenRecogida = new Image(rutaImg.toString());
		imagen = new ImageView(imagenRecogida);
		imagen.setFitHeight(22);
		imagen.setFitWidth(22);
		this.botonNuevoJugador.setGraphic(imagen);

	}

}
