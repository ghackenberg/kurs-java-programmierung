package at.fhooe.hackenberg.gui.layouts.examples;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class Example1 {

	public static Node create() {
		HBox center = new HBox(new Label("Center"));
		HBox top = new HBox(new Label("Top"));
		HBox left = new HBox(new Label("Left"));
		HBox right = new HBox(new Label("Right"));
		HBox bottom = new HBox(new Label("Bottom"));
		
		center.setPadding(new Insets(10));
		top.setPadding(new Insets(10));
		left.setPadding(new Insets(10));
		right.setPadding(new Insets(10));
		bottom.setPadding(new Insets(10));
		
		center.setStyle("-fx-background-color: gray;");
		top.setStyle("-fx-background-color: gray;");
		left.setStyle("-fx-background-color: gray;");
		right.setStyle("-fx-background-color: gray;");
		bottom.setStyle("-fx-background-color: gray;");
		
		BorderPane.setMargin(center, new Insets(5));
		BorderPane.setMargin(top, new Insets(5));
		BorderPane.setMargin(left, new Insets(5));
		BorderPane.setMargin(right, new Insets(5));
		BorderPane.setMargin(bottom, new Insets(5));
		
		BorderPane pane = new BorderPane(center, top, right, bottom, left);
		
		pane.setPadding(new Insets(5));
		pane.setStyle("-fx-background-color: lightgray");
		
		return pane;
	}
	
}
