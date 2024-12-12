package at.fhooe.hackenberg.gui.collections;

import javafx.scene.Node;
import javafx.scene.control.ListView;

public class Example1 {
	
	public static class Item {
		
		private String value;
		
		public Item(String value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return value;
		}
		
	}

	public static Node create() {
		ListView<Item> list = new ListView<>();
		
		list.getItems().add(new Item("Erste Zeile"));
		list.getItems().add(new Item("Zweite Zeile"));
		list.getItems().add(new Item("Dritte Zeile"));
		
		return list;
	}
	
}
