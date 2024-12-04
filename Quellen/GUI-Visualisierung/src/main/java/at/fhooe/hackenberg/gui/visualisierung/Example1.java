package at.fhooe.hackenberg.gui.visualisierung;

import javafx.scene.Node;
import javafx.scene.chart.PieChart;

public class Example1 {

	public static Node create() {
		
		PieChart chart = new PieChart();
		chart.setTitle("Titel des Diagramms");
		chart.getData().add(new PieChart.Data("A", 1));
		chart.getData().add(new PieChart.Data("B", 2));
		chart.getData().add(new PieChart.Data("C", 3));
		
		return chart;
		
	}
	
}
