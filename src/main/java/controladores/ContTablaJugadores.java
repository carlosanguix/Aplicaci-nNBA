package controladores;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    @FXML private TableColumn<Jugador, String> codigoJugador;
    @FXML private TableColumn<Jugador, String> nombreJugador;
    @FXML private TableColumn<Jugador, String> procedenciaJugador;
    @FXML private TableColumn<Jugador, String> alturaJugador;
    @FXML private TableColumn<Jugador, String> pesoJugador;
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
		
	}
	
	public void pintarTablaConConsulta() {
		
		try {
			
			ResultSet consulta = FuncionesBDD.conectarConsulta("select * from jugadores;");
			
			while (consulta.next()) {
				
				String codigo = consulta.getString("codigo");
				String nombre = consulta.getString("Nombre");
				String procedencia = consulta.getString("Procedencia");
				String altura = consulta.getString("Altura");
				String peso = consulta.getString("Peso");
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
