package at.fhooe.hackenberg.gui.visualizations.examples;

import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.BorderPane;

public class Example1 {

	/**
	 * Erzeugt ein Tortendiagramm.
	 */
	public static Node create() {
		
		// Diagramm
		PieChart chart = new PieChart();
		chart.setTitle("Titel des Diagramms");
		chart.getData().add(new PieChart.Data("A", 1));
		chart.getData().add(new PieChart.Data("B", 2));
		chart.getData().add(new PieChart.Data("C", 3));
		
		// Hintergrund
		BorderPane pane = new BorderPane(chart);
		pane.setStyle("-fx-background-color: lightgray;");
		
		return pane;
		
	}
	
}
