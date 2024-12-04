package at.fhooe.hackenberg.gui.visualisierung;

import javafx.geometry.Point3D;
import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.SubScene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Material;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Shape3D;
import javafx.scene.shape.Sphere;

public class Example4 {

	/**
	 * Erzeugt eine einfache 3D-Visualisierung.
	 */
	public static Node create() {
		
		// Kamera
		PerspectiveCamera camera = new PerspectiveCamera(true);
		camera.setTranslateZ(-10);
		camera.setNearClip(0);
		camera.setFarClip(20);
		
		// Umgebungslicht
		AmbientLight ambient = new AmbientLight(new Color(0.5, 0.5, 0.5, 1));
		
		// Punktlicht
		PointLight point = new PointLight(Color.WHITE);
		point.setTranslateX(10);
		point.setTranslateY(-10);
		point.setTranslateZ(-10);
		
		// Material
		Material red = new PhongMaterial(Color.RED);
		Material green = new PhongMaterial(Color.GREEN);
		Material blue = new PhongMaterial(Color.BLUE);
		
		// Kugel
		Shape3D shape1 = new Sphere(1);
		shape1.setMaterial(red);
		shape1.setTranslateX(-2);
		
		// Würfel
		Shape3D shape2 = new Box(1, 1, 1);
		shape2.setMaterial(green);
		shape2.setTranslateX(0);
		
		// Zylinder
		Shape3D shape3 = new Cylinder();
		shape3.setMaterial(blue);
		shape3.setTranslateX(2);
		
		// Rotation um die X-Achse
		Group x = new Group(shape1, shape2, shape3);
		x.setRotationAxis(new Point3D(1, 0, 0));
		x.setRotate(22.5);
		
		// Rotation um die Y-Achse
		Group y = new Group(x);
		y.setRotationAxis(new Point3D(0, 1, 0));
		y.setRotate(22.5);
		
		// Rotation um die Z-Achse
		Group z = new Group(y);
		z.setRotationAxis(new Point3D(0, 0, 1));
		z.setRotate(11.75);
		
		// Wurzelknoten
		Group root = new Group(camera, ambient, point, z);
		
		// Szene
		SubScene scene = new SubScene(root, 1, 1);
		scene.setCamera(camera);
		scene.setManaged(false);
		
		// Hintergrund
		BorderPane pane = new BorderPane(scene);
		pane.setStyle("-fx-background-color: lightgray;");
		
		scene.widthProperty().bind(pane.widthProperty());
		scene.heightProperty().bind(pane.heightProperty());
		
		return pane;
		
	}

}
