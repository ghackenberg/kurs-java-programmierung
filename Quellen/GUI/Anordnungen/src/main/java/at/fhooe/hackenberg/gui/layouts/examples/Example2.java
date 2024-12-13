package at.fhooe.hackenberg.gui.layouts.examples;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class Example2 {

	public static Node create() {
		
		// Inhalte des Layouts erstellen
		
		HBox topLeft = new HBox(new Label("Oben-links"));
		HBox topRight = new HBox(new Label("Oben-rechts"));
		HBox bottomLeft = new HBox(new Label("Unten-links"));
		HBox bottomRight = new HBox(new Label("Unten-rechts"));
		
		// Innere Randabstände setzen
		
		topLeft.setPadding(new Insets(10));
		topRight.setPadding(new Insets(10));
		bottomLeft.setPadding(new Insets(10));
		bottomRight.setPadding(new Insets(10));
		
		// Hintergrundfarben setzen
		
		topLeft.setStyle("-fx-background-color: orange;");
		topRight.setStyle("-fx-background-color: orange;");
		bottomLeft.setStyle("-fx-background-color: orange;");
		bottomRight.setStyle("-fx-background-color: orange;");
		
		// Layout selbst erstellen
		
		GridPane pane = new GridPane(10, 10);
		
		pane.setPadding(new Insets(10));
		pane.setStyle("-fx-background-color: lightgray");
		
		// Spalten konfigurieren
		
		pane.getColumnConstraints().add(createColumnConstraints(100/3.));
		pane.getColumnConstraints().add(createColumnConstraints(100/3.));
		pane.getColumnConstraints().add(createColumnConstraints(100/3.));
		
		// Zeilen konfigurieren
		
		pane.getRowConstraints().add(createRowConstraints(100/2.));
		pane.getRowConstraints().add(createRowConstraints(100/2.));
		
		// Inhalte hinzufügen
		
		pane.add(topLeft, 0, 0, 2, 1);
		pane.add(topRight, 2, 0, 1, 1);
		pane.add(bottomLeft, 0, 1, 1, 1);
		pane.add(bottomRight, 1, 1, 2, 1);

		// Layout inklusive Inhalte zurückgeben
		
		return pane;
		
	}
	
	private static ColumnConstraints createColumnConstraints(double percent) {
		ColumnConstraints c = new ColumnConstraints();
		
		c.setFillWidth(true);
		c.setHgrow(Priority.ALWAYS);
		c.setPercentWidth(percent);
		
		return c;
	}
	
	private static RowConstraints createRowConstraints(double percent) {
		RowConstraints c = new RowConstraints();
		
		c.setFillHeight(true);
		c.setVgrow(Priority.ALWAYS);
		c.setPercentHeight(percent);
		
		return c;
	}
	
}
