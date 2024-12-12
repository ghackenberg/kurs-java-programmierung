package at.fhooe.hackenberg.gui.collections;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;

public class Example2 {
	
	public static class Item {
		
		private StringProperty value1;
		private IntegerProperty value2;
		private BooleanProperty value3;
		
		public Item(String value1, int value2, boolean value3) {
			this.value1 = new SimpleStringProperty(value1);
			this.value2 = new SimpleIntegerProperty(value2);
			this.value3 = new SimpleBooleanProperty(value3);
		}
		
		public StringProperty value1Property() {
			return value1;
		}
		public IntegerProperty value2Property() {
			return value2;
		}
		public BooleanProperty value3Property() {
			return value3;
		}
		
	}

	public static Node create() {
		
		TableColumn<Item, String> column1 = new TableColumn<>("Wert 1");
		column1.setCellValueFactory(row -> row.getValue().value1Property());
		
		TableColumn<Item, Number> column2 = new TableColumn<>("Wert 2");
		column2.setCellValueFactory(row -> row.getValue().value2Property());
		
		TableColumn<Item, Boolean> column3 = new TableColumn<>("Wert 3");
		column3.setCellValueFactory(row -> row.getValue().value3Property());
		column3.setCellFactory(cell -> new CheckBoxTableCell<>());
		
		TableView<Item> table = new TableView<>();
		
		table.getColumns().add(column1);
		table.getColumns().add(column2);
		table.getColumns().add(column3);
		
		table.getItems().add(new Item("Erste Zeile", 1, true));
		table.getItems().add(new Item("Zweite Zeile", 2, false));
		table.getItems().add(new Item("Drittte Zeile", 3, true));
		
		return table;
		
	}

}
