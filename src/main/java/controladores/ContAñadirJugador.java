package controladores;

import java.net.URL;
import java.util.ResourceBundle;

import dominio.FuncionesBDD;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ContAñadirJugador implements Initializable {

    @FXML private TextField codigo;
    @FXML private TextField nombre;
    @FXML private TextField procedencia;
    @FXML private TextField altura;
    @FXML private TextField peso;
    @FXML private TextField posicion;
    @FXML private TextField equipo; @FXML private ImageView ayuda;
    @FXML private Button guardar;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		aplicarEstilos();
		
		this.guardar.setOnAction(evento -> {
			
			insertJugador();
			
		});
		
	}
	
	public void aplicarEstilos() {
		
		URL ruta;
		Image img;
		
		ruta = getClass().getResource("/logosNba/iconoAyuda.png");
		img = new Image(ruta.toString());
		this.ayuda.setImage(img);
		Tooltip.install(this.ayuda, new Tooltip("Si el equipo no existe no se podrá añadir el jugador."));
		
	}
	
	// TODO necesito refrescar la tabla una vez añadido el jugador
	public void insertJugador() {
		
		try {
			
			int codigo = Integer.parseInt(this.codigo.getText());
			String nombre = this.nombre.getText();
			String procedencia = this.procedencia.getText();
			String altura = this.altura.getText();
			int peso = Integer.parseInt(this.peso.getText());
			String posicion = this.posicion.getText();
			String equipo = this.equipo.getText();
			
			FuncionesBDD.insertJugador(codigo, nombre, procedencia, altura, peso, posicion, equipo);
			
		} catch (NumberFormatException e) {
			
			System.out.println("Has intentado meter una letra en un integer");
			
		}
		
	}

}
