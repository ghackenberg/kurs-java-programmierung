package at.fhooe.hackenberg.gui.layouts.examples;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

public class Example4 {

	public static Node create() {
		
		// Layout erstellen
		
		FlowPane pane = new FlowPane();

		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setStyle("-fx-background-color: lightgray");
		
		// Inhalte hinzufügen
		
		pane.getChildren().add(create("Text"));
		pane.getChildren().add(create("Etwas längerer Text"));
		pane.getChildren().add(create("Kurztext"));
		pane.getChildren().add(create("Mehr Text"));
		pane.getChildren().add(create("Wirklich langer Text"));
		pane.getChildren().add(create("Text"));
		pane.getChildren().add(create("Buchstaben"));
		pane.getChildren().add(create("Zeichenketten"));
		pane.getChildren().add(create("X"));
		
		// Layout inklusive Inhalte zurückgeben
		
		return pane;
		
	}
	
	private static Label create(String text) {
		Label l = new Label(text);
		
		l.setPadding(new Insets(10));
		l.setStyle("-fx-background-color: orange;");
		
		return l;
	}
	
}
