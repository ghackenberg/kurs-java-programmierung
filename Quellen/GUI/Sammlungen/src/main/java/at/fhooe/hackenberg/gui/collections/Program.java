package at.fhooe.hackenberg.gui.collections;

import at.fhooe.hackenberg.gui.collections.examples.Example1;
import at.fhooe.hackenberg.gui.collections.examples.Example2;
import at.fhooe.hackenberg.gui.collections.examples.Example3;
import at.fhooe.hackenberg.gui.collections.examples.Example4;
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
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Menü definieren
		
		MenuBar menu = new MenuBar(
			new Menu("Datei", null,
				new MenuItem("Öffnen"),
				new MenuItem("Speichern"),
				new MenuItem("Speichern unter"),
				new MenuItem("Schließen")
			),
			new Menu("Bearbeiten"),
			new Menu("Hilfe")
		);
		
		// Rasterlayout definieren
		
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
		
		// Randlayout definieren
		
		BorderPane root = new BorderPane(grid, menu, null, null, null);
		
		// Szene defnieren
		
		Scene scene = new Scene(root, 640, 480);
		
		// Stage konfigurieren
		
		primaryStage.setTitle("GUI.Sammlungen");
		primaryStage.setScene(scene);
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
