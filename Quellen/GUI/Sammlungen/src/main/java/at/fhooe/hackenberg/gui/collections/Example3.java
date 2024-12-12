package at.fhooe.hackenberg.gui.collections;

import javafx.scene.Node;
import javafx.scene.control.TreeView;

public class Example3 {
	
	public static class Item {
		
	}

	public static Node create() {
		TreeView<Item> tree = new TreeView<>();
		
		return tree;
	}
	
}
