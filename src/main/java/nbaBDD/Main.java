package nbaBDD;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static void main(String[] args) {
		
		launch(args);
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		
		Parent root = null;

		try {
			
			root = FXMLLoader.load(getClass().getResource("/FXML/ventanaTotal.fxml"));
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		Scene sc = new Scene(root);
		// TODO Añadir icono a la escena, junto al nombre del programa
		Image a = new Image("file:AAnbaLogo.png");
		primaryStage.getIcons().add(a);
		primaryStage.setTitle("Aplicacion NBA (v0.93.1)");
		primaryStage.setScene(sc);
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
	
}
