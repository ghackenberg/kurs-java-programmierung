module at.fhooe.hackenberg.gui.menus {
	
	// Exportiertes Paket, weile Programmkonstruktur für den Start sichtbar sein muss
	exports at.fhooe.hackenberg.gui.menus;
	
	// Nicht-transitive Abhängigkeit, weil Klassen nur "intern" verwendet werden
	requires javafx.graphics;
	// Transitive Abhängigkeit, weil Klasse Stage in der öffentlichen API verwendet wird
	requires transitive javafx.controls;
	
}