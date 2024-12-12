package at.fhooe.hackenberg.gui.collections.items;

public class SimpleItem {
	
	private String value;
	
	public SimpleItem(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}

}
