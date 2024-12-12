package at.fhooe.hackenberg.gui.visualizations;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
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
		
		grid.getColumnConstraints().add(createColumnConstraints());
		grid.getColumnConstraints().add(createColumnConstraints());
		
		grid.getRowConstraints().add(createRowConstraints());
		grid.getRowConstraints().add(createRowConstraints());
		
		grid.setPadding(new Insets(10));
		
		grid.setHgap(10);
		grid.setVgap(10);
		
		grid.add(Example1.create(), 0, 0);
		grid.add(Example2.create(), 1, 0);
		grid.add(Example3.create(), 0, 1);
		grid.add(Example4.create(), 1, 1);
		
		// Menu erstellen
		MenuBar menu = new MenuBar(
			new Menu("Datei", null,
				new MenuItem("Laden"),
				new MenuItem("Speichern"),
				new MenuItem("Schließen")
			),
			new Menu("Hilfe", null,
				new MenuItem("Über")
			)
	    );
		
		// Pane erstellen
		BorderPane pane = new BorderPane(grid, menu, null, null, null);
		
		// Szene erstellen
		Scene scene = new Scene(pane, 640, 480, true);
		
		// Stage konfigurieren und anzeigen
		primaryStage.setScene(scene);
		primaryStage.setTitle("GUI.Visualisierungen");
		primaryStage.show();
		
	}
	
	private static ColumnConstraints createColumnConstraints() {
		ColumnConstraints c = new ColumnConstraints();
		
		c.setFillWidth(true);
		c.setHgrow(Priority.ALWAYS);
		c.setPercentWidth(50);
		
		return c;
	}
	
	private static RowConstraints createRowConstraints() {
		RowConstraints c = new RowConstraints();
		
		c.setFillHeight(true);
		c.setVgrow(Priority.ALWAYS);
		c.setPercentHeight(50);
		
		return c;
	}

}
