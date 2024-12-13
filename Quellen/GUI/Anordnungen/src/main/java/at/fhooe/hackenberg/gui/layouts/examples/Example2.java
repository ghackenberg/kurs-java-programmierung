package at.fhooe.hackenberg.gui.layouts.examples;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class Example2 {

	public static Node create() {
		GridPane pane = new GridPane();
		
		pane.setStyle("-fx-background: lightgray");
		
		return pane;
	}
	
}
