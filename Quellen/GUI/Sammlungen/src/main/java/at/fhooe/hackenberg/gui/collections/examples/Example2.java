package at.fhooe.hackenberg.gui.collections.examples;

import at.fhooe.hackenberg.gui.collections.items.ComplexItem;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;

public class Example2 {

	public static Node create() {
		
		// Spalten definieren
		
		TableColumn<ComplexItem, String> column1 = new TableColumn<>("Wert 1");
		TableColumn<ComplexItem, Number> column2 = new TableColumn<>("Wert 2");
		TableColumn<ComplexItem, Boolean> column3 = new TableColumn<>("Wert 3");
		
		// Spaltenwerte definieren
		
		column1.setCellValueFactory(row -> row.getValue().value1Property());
		column2.setCellValueFactory(row -> row.getValue().value2Property());
		column3.setCellValueFactory(row -> row.getValue().value3Property());
		
		// Spaltendarstellung definieren
		
		column3.setCellFactory(cell -> new CheckBoxTableCell<>());
		
		// Tabelle definieren
		
		TableView<ComplexItem> table = new TableView<>();
		
		// Tabellenspalten hinzufügen
		
		table.getColumns().add(column1);
		table.getColumns().add(column2);
		table.getColumns().add(column3);
		
		// Tabelleninhalte hinzufügen
		
		table.getItems().add(new ComplexItem("Erste Zeile", 1, true));
		table.getItems().add(new ComplexItem("Zweite Zeile", 2, false));
		table.getItems().add(new ComplexItem("Drittte Zeile", 3, true));
		
		// Tabelle zurückgeben
		
		return table;
		
	}

}
