package at.fhooe.hackenberg.gui.collections.examples;

import at.fhooe.hackenberg.gui.collections.items.SimpleItem;
import javafx.scene.Node;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class Example3 {

	public static Node create() {
		
		// Baumknoten definieren
		
		TreeItem<SimpleItem> root = new TreeItem<>(new SimpleItem("Wurzelknoten"));
		
		TreeItem<SimpleItem> child1 = new TreeItem<>(new SimpleItem("Kindknoten 1"));
		TreeItem<SimpleItem> child2 = new TreeItem<>(new SimpleItem("Kindknoten 2"));
		TreeItem<SimpleItem> child3 = new TreeItem<>(new SimpleItem("Kindknoten 3"));
		
		TreeItem<SimpleItem> subchild1 = new TreeItem<>(new SimpleItem("Unterknoten 1.1"));
		TreeItem<SimpleItem> subchild2 = new TreeItem<>(new SimpleItem("Unterknoten 1.2"));
		TreeItem<SimpleItem> subchild3 = new TreeItem<>(new SimpleItem("Unterknoten 1.3"));
		
		// Baumknoten verknüpfe
		
		root.getChildren().add(child1);
		root.getChildren().add(child2);
		root.getChildren().add(child3);
		
		child1.getChildren().add(subchild1);
		child1.getChildren().add(subchild2);
		child1.getChildren().add(subchild3);
		
		// Baumknoten expandieren
		
		root.setExpanded(true);
		
		child1.setExpanded(true);
		
		// Baumansicht definieren
		
		TreeView<SimpleItem> tree = new TreeView<>();
		
		tree.setRoot(root);
		
		// Baumansicht zurückgeben
		
		return tree;
		
	}
	
}
