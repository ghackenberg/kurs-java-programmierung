package at.fhooe.hackenberg.gui.layouts.examples;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class Example3 {

	public static Node create() {
		
		// Inhalte des Layouts erstellen
		
		Label z0 = new Label("Das ist doch ein ziemlich breiter Text");
		Label z1 = new Label("Etwas Weniger Text");
		Label z2 = new Label("Text");
		
		// Innere Randabstände setzen
		
		z0.setPadding(new Insets(30));
		z1.setPadding(new Insets(20));
		z2.setPadding(new Insets(10));
		
		// Hintergrundfarben setzen
		
		z0.setStyle("-fx-background-color: yellow;");
		z1.setStyle("-fx-background-color: orange;");
		z2.setStyle("-fx-background-color: red;");
		
		// Layout selbst erstellen
		
		StackPane pane = new StackPane(z0, z1, z2);
		
		pane.setStyle("-fx-background-color: lightgray");
		
		// Layout inklusive Inhalte zurückgeben
		
		return pane;
		
	}
	
}
