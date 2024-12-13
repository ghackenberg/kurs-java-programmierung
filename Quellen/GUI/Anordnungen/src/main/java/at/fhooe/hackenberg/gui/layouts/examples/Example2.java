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
		
		HBox top = new HBox(new Label("Top"));
		HBox left = new HBox(new Label("Left"));
		HBox right = new HBox(new Label("Right"));
		HBox bottom = new HBox(new Label("Bottom"));
		
		// Innere Randabstände setzen
		
		top.setPadding(new Insets(10));
		left.setPadding(new Insets(10));
		right.setPadding(new Insets(10));
		bottom.setPadding(new Insets(10));
		
		// Hintergrundfarben setzen
		
		top.setStyle("-fx-background-color: orange;");
		left.setStyle("-fx-background-color: orange;");
		right.setStyle("-fx-background-color: orange;");
		bottom.setStyle("-fx-background-color: orange;");
		
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
		
		pane.add(top, 0, 0, 2, 1);
		pane.add(left, 2, 0, 1, 1);
		pane.add(right, 0, 1, 1, 1);
		pane.add(bottom, 1, 1, 2, 1);

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
