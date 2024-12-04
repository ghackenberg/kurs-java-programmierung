package at.fhooe.hackenberg.gui.grundlagen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Program extends Application {
	
	/**
	 * Hauptroutine.
	 * 
	 * @param args Kommandozeilenparameter.
	 */
	public static void main(String[] args) {
		// Die Methode "launch" ist im Modul "javafx.graphics" implementiert und ruft den Konstruktur der Programmklasse per "Reflection" auf
		// Damit die Methode "launch" den Konstruktor der Programmklasse findet, muss das Paket, in dem sich die Programmklasse befindet, exportiert werden
		launch(args);
	}
	
	/**
	 * Programmkonstruktur.
	 * 
	 * Wurde nur für die Erklärung des Startprozesses hinzugefügt.
	 */
	public Program() {
		// Konstruktur muss parameterlos sein, sonst kann die Methode "launch" ihn nicht aufrufen
		System.out.println("Constructor called");
	}

	/**
	 * Startroutine.
	 * 
	 * Erzeugt die GUI-Objekte und zeigt sie an. Beinhaltet Ereignisroutinen.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// Erzeugung einer Hauptmenüstruktur
		
		MenuItem load = new MenuItem("Laden");
		load.setOnAction(event -> {
			// Ausgabe einer Meldung bei Menüauswahl
			Alert alert = new Alert(AlertType.WARNING);
			alert.setContentText("Not implemented yet!");
			alert.showAndWait();
		});
		
		Menu file = new Menu("Datei");
		file.getItems().add(load);
		file.getItems().add(new MenuItem("Speichern"));
		file.getItems().add(new MenuItem("Speichern unter"));
		file.getItems().add(new MenuItem("Schließen"));
		
		MenuBar bar = new MenuBar();
		bar.getMenus().add(file);
		bar.getMenus().add(new Menu("Bearbeiten"));
		bar.getMenus().add(new Menu("Hilfe"));
		
		// Anzeige der Hauptmenüstruktur
		
		BorderPane root = new BorderPane();
		root.setTop(bar);
		
		Scene scene = new Scene(root, 640, 480);
		
		primaryStage.setTitle("GUI-Grundlagen");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
