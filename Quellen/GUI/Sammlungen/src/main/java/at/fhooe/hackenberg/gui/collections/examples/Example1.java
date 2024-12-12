package at.fhooe.hackenberg.gui.collections.examples;

import at.fhooe.hackenberg.gui.collections.items.SimpleItem;
import javafx.scene.Node;
import javafx.scene.control.ListView;

public class Example1 {

	public static Node create() {
		
		// Liste definieren
		
		ListView<SimpleItem> list = new ListView<>();
		
		// Listeninhalte hinzufügen
		
		list.getItems().add(new SimpleItem("Erste Zeile"));
		list.getItems().add(new SimpleItem("Zweite Zeile"));
		list.getItems().add(new SimpleItem("Dritte Zeile"));
		
		// Liste zurückgeben
		
		return list;
	}
	
}
