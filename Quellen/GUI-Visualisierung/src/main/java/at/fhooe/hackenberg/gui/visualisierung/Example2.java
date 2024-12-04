package at.fhooe.hackenberg.gui.visualisierung;

import javafx.scene.Node;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;

public class Example2 {

	/**
	 * Erzeugt ein Balkendiagramm.
	 */
	public static Node create() {
		
		// Erste Datenserie
		XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
		series1.setName("Name der Serie 1");
		series1.getData().add(new XYChart.Data<String, Number>("A", 1));
		series1.getData().add(new XYChart.Data<String, Number>("B", 2));
		series1.getData().add(new XYChart.Data<String, Number>("C", 3));
		
		// Zweite Datenserie
		XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>();
		series2.setName("Name der Serie 2");
		series2.getData().add(new XYChart.Data<String, Number>("A", 1));
		series2.getData().add(new XYChart.Data<String, Number>("B", 2));
		series2.getData().add(new XYChart.Data<String, Number>("C", 3));
		
		// X-Achse
		Axis<String> xAxis = new CategoryAxis();
		xAxis.setLabel("Name der X-Achse");
		
		// Y-Achse
		Axis<Number> yAxis = new NumberAxis();
		yAxis.setLabel("Name der Y-Achse");
		
		// Diagramm
		BarChart<String, Number> chart = new BarChart<>(xAxis, yAxis);
		chart.setTitle("Titel des Diagramms");
		chart.getData().add(series1);
		chart.getData().add(series2);
		
		// Hintergrund
		BorderPane pane = new BorderPane(chart);
		pane.setStyle("-fx-background-color: lightgray;");
		
		return pane;
		
	}

}
