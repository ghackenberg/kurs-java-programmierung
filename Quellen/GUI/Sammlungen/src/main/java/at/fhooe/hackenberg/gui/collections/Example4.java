package at.fhooe.hackenberg.gui.collections;

import javafx.scene.Node;
import javafx.scene.control.TreeTableView;

public class Example4 {
	
	public static class Item {
		
	}

	public static Node create() {
		TreeTableView<Item> treeTable = new TreeTableView<>();
		
		return treeTable;
	}

}
