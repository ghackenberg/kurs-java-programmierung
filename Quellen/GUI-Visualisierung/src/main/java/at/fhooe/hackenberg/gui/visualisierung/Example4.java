package at.fhooe.hackenberg.gui.visualisierung;

import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.SubScene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Material;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

public class Example4 {

	public static Node create() {
		
		// Kamera
		Camera camera = new PerspectiveCamera();
		
		// Licht
		PointLight light = new PointLight(Color.WHITE);
		light.setTranslateX(10);
		light.setTranslateY(10);
		light.setTranslateZ(10);
		
		// Material
		Material material = new PhongMaterial(Color.RED);
		
		// Box
		Box box = new Box(1, 1, 1);
		box.setMaterial(material);
		
		// Wurzelknoten
		Group root = new Group();
		root.getChildren().add(camera);
		root.getChildren().add(light);
		root.getChildren().add(box);
		
		// Szene
		SubScene subscene = new SubScene(root, 100, 100);
		subscene.setCamera(camera);
		
		return subscene;
		
	}

}
