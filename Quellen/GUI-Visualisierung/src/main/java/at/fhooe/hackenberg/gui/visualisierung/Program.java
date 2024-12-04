package at.fhooe.hackenberg.gui.visualisierung;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Program extends Application {

	/**
	 * Hauptroutine.
	 */
	public static void main(String[] args) {
		
		// Starten der JavaFX-GUI
		Application.launch(args);
		
	}

	/**
	 * Erstellung und Anzeige der GUI.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Grid erstellen
		GridPane grid = new GridPane();
		grid.add(Example1.create(), 0, 0);
		grid.add(Example2.create(), 1, 0);
		grid.add(Example3.create(), 0, 1);
		grid.add(Example4.create(), 1, 1);
		
		// Szene erstellen
		Scene scene = new Scene(grid, 640, 480);
		
		// Stage befüllen
		primaryStage.setScene(scene);
		primaryStage.setTitle("GUI-Visualisierung");
		primaryStage.show();
		
	}

}
