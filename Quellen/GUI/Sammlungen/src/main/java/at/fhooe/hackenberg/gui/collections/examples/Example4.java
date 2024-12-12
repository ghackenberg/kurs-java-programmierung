package at.fhooe.hackenberg.gui.collections.examples;

import at.fhooe.hackenberg.gui.collections.items.ComplexItem;
import javafx.scene.Node;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.CheckBoxTreeTableCell;

public class Example4 {

	public static Node create() {
		
		// Baumknoten definieren
		
		TreeItem<ComplexItem> root = new TreeItem<>(new ComplexItem("Wurzelknoten", 1, true));
		
		TreeItem<ComplexItem> child1 = new TreeItem<>(new ComplexItem("Kindknoten 1", 2, false));
		TreeItem<ComplexItem> child2 = new TreeItem<>(new ComplexItem("Kindknoten 2", 3, true));
		TreeItem<ComplexItem> child3 = new TreeItem<>(new ComplexItem("Kindknoten 3", 4, false));
		
		TreeItem<ComplexItem> subchild1 = new TreeItem<>(new ComplexItem("Unterknoten 1.1", 5, true));
		TreeItem<ComplexItem> subchild2 = new TreeItem<>(new ComplexItem("Unterknoten 1.2", 6, false));
		TreeItem<ComplexItem> subchild3 = new TreeItem<>(new ComplexItem("Unterknoten 1.3", 7, true));
		
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
		
		// Baumtabellenspalten definieren
		
		TreeTableColumn<ComplexItem, String> column1 = new TreeTableColumn<>("Wert 1");
		TreeTableColumn<ComplexItem, Number> column2 = new TreeTableColumn<>("Wert 2");
		TreeTableColumn<ComplexItem, Boolean> column3 = new TreeTableColumn<>("Wert 3");
		
		// Werte der Baumtabellenspalten definieren
		
		column1.setCellValueFactory(row -> row.getValue().getValue().value1Property());
		column2.setCellValueFactory(row -> row.getValue().getValue().value2Property());
		column3.setCellValueFactory(row -> row.getValue().getValue().value3Property());
		
		// Darstellung der Baumtabellenspalten definieren
		
		column3.setCellFactory(cell -> new CheckBoxTreeTableCell<>());
		
		// Baumtabellenansicht definieren
		
		TreeTableView<ComplexItem> treeTable = new TreeTableView<>();
		
		treeTable.getColumns().add(column1);
		treeTable.getColumns().add(column2);
		treeTable.getColumns().add(column3);
		
		treeTable.setRoot(root);
		
		// Baumtabellenansicht zurückgeben
		
		return treeTable;
		
	}

}
