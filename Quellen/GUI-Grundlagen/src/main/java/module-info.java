module hackenberg.gui.grundlagen {
	
	// Exportiertes Paket, weile Programmkonstruktur für den Start sichtbar sein muss
	exports at.fhooe.hackenberg.gui.grundlagen;
	
	// Nicht-transitive Abhängigkeit, weil Klassen nur "intern" verwendet werden
	requires javafx.graphics;
	// Transitive Abhängigkeit, weil Klasse Stage in der öffentlichen API verwendet wird
	requires transitive javafx.controls;
	
}