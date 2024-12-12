module at.fhooe.hackenberg.gui.chat {
	
	// Transitiv, weil eigene Klassen in der öffentlichen API deren Klassen verwenden
	requires transitive javafx.graphics;
	
	// Nicht transitiv, weil eigene Klassen deren Klassen nur intern verwenden
	requires javafx.controls;
	
	// Notwendig, damit Klassen von JavaFX auf eigene Klassen zugreifen können
	exports at.fhooe.hackenberg.gui.chat;
	
}