package at.fhooe.hackenberg.gui.collections.items;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ComplexItem {
	
	private StringProperty value1;
	private IntegerProperty value2;
	private BooleanProperty value3;
	
	public ComplexItem(String value1, int value2, boolean value3) {
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
