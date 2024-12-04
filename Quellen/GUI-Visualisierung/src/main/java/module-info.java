module hackenberg.gui.visualisierung {
	
	// Transitiv, weil eigene Klassen in der öffentlichen API deren Klassen verwenden
	requires javafx.graphics;
	
	// Nicht transitiv, weil eigene Klassen deren Klassen nur intern verwenden
	requires transitive javafx.controls;
	
	// Notwendig, damit Klassen von JavaFX auf eigene Klassen zugreifen können
	exports at.fhooe.hackenberg.gui.visualisierung;
	
}