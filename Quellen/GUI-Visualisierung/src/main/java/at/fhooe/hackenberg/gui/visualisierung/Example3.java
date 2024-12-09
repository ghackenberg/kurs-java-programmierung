package at.fhooe.hackenberg.gui.visualisierung;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class Example3 {

	/**
	 * Erzeugt ein gestapeltes Flächendiagramm.
	 */
	public static Node create() {
		
		// Fläche
		Pane canvas = new Pane();
		canvas.setStyle("-fx-background-color: lightgray;");
		
		NumberBinding unit = Bindings.min(canvas.widthProperty(), canvas.heightProperty()).divide(10);
		
		// Linie
		Line line = new Line();
		
		line.setStroke(Color.GRAY);
		
		line.strokeWidthProperty().bind(unit.divide(2));
		
		line.startXProperty().bind(canvas.widthProperty().divide(4));
		line.startYProperty().bind(canvas.heightProperty().divide(4));
		
		line.endXProperty().bind(canvas.widthProperty().divide(4).multiply(3));
		line.endYProperty().bind(canvas.heightProperty().divide(4).multiply(3));
		
		// Kreis
		Circle circle = new Circle();
		
		circle.setFill(Color.GREEN);
		
		circle.centerXProperty().bind(canvas.widthProperty().divide(2));
		circle.centerYProperty().bind(canvas.heightProperty().divide(2));
		
		circle.radiusProperty().bind(unit.divide(2));
		
		// Rechteck
		Rectangle rectangle = new Rectangle();
		
		rectangle.setFill(Color.RED);
		
		rectangle.widthProperty().bind(unit);
		rectangle.heightProperty().bind(unit);
		
		rectangle.xProperty().bind(canvas.widthProperty().divide(4).subtract(unit.divide(2)));
		rectangle.yProperty().bind(canvas.heightProperty().divide(4).subtract(unit.divide(2)));
		
		// Abgerundetes Rechteck
		Rectangle arc = new Rectangle();
		
		arc.setFill(Color.BLUE);
		
		arc.widthProperty().bind(unit);
		arc.heightProperty().bind(unit);
		
		arc.arcWidthProperty().bind(unit.divide(4));
		arc.arcHeightProperty().bind(unit.divide(4));
		
		arc.xProperty().bind(canvas.widthProperty().divide(4).multiply(3).subtract(unit.divide(2)));
		arc.yProperty().bind(canvas.heightProperty().divide(4).multiply(3).subtract(unit.divide(2)));
		
		// Szene
		Group scene = new Group(line, circle, rectangle, arc);
		
		canvas.getChildren().add(scene);
		
		return canvas;
		
	}
}
