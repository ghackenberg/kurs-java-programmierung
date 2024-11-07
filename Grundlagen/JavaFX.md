# Grafische Benutzerschnittstellen mit JavaFX

Dieses Dokument beschreibt, wie man mittels JavaFX grafische Benutzerschnittstellen entwickelt.

Grundelemente

* `Application` - Basisklasse einer JavaFX-Anwendung
* `Stage` - Fenster zur Darstellung von Inhalten
* `Scene` - Container für den Inhalt eines Festers
* `Parent` - Der eigentliche Inhalt des Fensters
* `Node` - Basisklasse für alle Arten von Inhalten

Hilfselemente

* `Paint` - Darstellung von Farben und Farbverläufen
* `Material` - Darstellung von visuellen Materialeigenschaften
* `Font` - Darstellung von Schriftarten und deren Eigenschaften

Knoten

* `Canvas` - Durchführung von Zeichenoperationen
* `ImageView` - Anzeigen von Bildern
* `MediaView` - Abspielen von Videos und Sounds
* `Shape`- 2D-Formen wie Rechtecke und Kreise
* `Shape3D` - 3D-Formen wie Würfel und Kugeln
* `Camera` - Kameras für das Rendering von 3D-Formen
* `LightBase` - Beleuchtung für 3D-Szenen
* `SubScene` - Container für 3D-Szenen mit Kamera

2D-Formen

* `Line` - Gerade Linie zwischen zwei Punkten
* `Polyline` - Linienzug zwischen zwei oder mehr Punkten
* `Rectangle` - Rechteckt definiert durch Höhe und Breite
* `Polygon` - Vieleck definiert durch eine Reihe von Punkten
* `Circle` - Kreis definiert durch Mittelpunkt und Radius
* `Ellipse` - Ellipse definiert durch Mittelpunkt und Radii
* `Text` - Text definiert durch Zeichenkette und Schriftart

3D-Formen

* `Box` - Wurfel-Geometrie mit Länge, Höhe und Tiefe
* `Cylinder` - Zylinder-Geometrie mit Radius und Höhe
* `Sphere` - Kugel-Geometrie mit Radius
* `MeshView` - Beliebige Form bestehend aus Dreiecken

Kameras

* `ParallelCamera` - Orthografische Projektion der Formen
* `PerspectiveCamera` - Perspektifische Projektion der Formen

Lichter

* `AmbientLight` - Umgebungslight ohne spezielle Richtung
* `PointLight` - Punktlicht ausgehend von einem Punkt im Raum

Eltern

* `Group` - Gruppierung von Kindknoten
* `Region` - Gerahmte Fläche für Kindknoten
* `WebView` - Anzeige von HTML-Seiten

Regionen

* `Pane` - Verschiedene Layouts für Kindelemente
* `Chart` - Kreis- und XY-Liniendiagramme
* `Axis` - Die beiden Axen von XY-Liniendiagrammen
* `Control` - Klassische Steuerelemente einer GUI-Anwendung

Anordnungen

* `BorderPane` - Rahmenlayout mit einem Flexiblem Zentralbereich
* `GridPane` - Rasterlayout mit definierten Spalten und Zeilen
* `StackPane` - Stapellayout mit einer definierten Stapelrichtung
* `FlowPane` - Flusslayout mit primärer und sekundärer Flussrichtung

Steuerelemente

* `ScrollPane`, `SplitPane`, `TabPane` und `Pagination`
* `MenuBar`, `ToolBar` und `ButtonBar`
* `ListView`, `TableView`, `TreeView` und `TreeTableView`
* `Label`, `Button`, `ToggleButton`, `MenuButton`, `Hyperlink` und `CheckBox`
* `TextField` und `TextArea`
* `ComboBox`, `DatePicker` und `ColorPicker`
* `Spinner`, `Slider`, `ProgressIndictor` und `ChoiceBox`

## 1. Grundelemente

TODO

![](../Grafiken/JavaFX/Stage.svg)

TODO

```java
import javafx.application.Application;
import javafx.stage.Stage;

// Programmklasse
public class Program extends Application {

    // Hauptroutine
    public static void main(String[] args) {
        Application.launch(args);
    }

    // Startmethode
    @Override
    public void start(Stage primaryStage) {
        ...
    }

}
```

TODO

```java
import javafx.scene.Parent;

// Inhalt erzeugen
Parent root = ...
```

TODO

```java
import javafx.scene.Scene;

// Höhe in Pixeln definieren
int width = ...

// Breite in Pixeln definieren
int height = ...

// Szene erzeugen
Scene scene = new Scene(root, width, height) 
```

TODO

```java
// Stage konfigurieren und anzeigen
primaryStage.setTitle("My application");
primaryStage.setScene(scene);
primaryStage.show();
```

## 2. Hilfselemente

TODO

![](../Grafiken/JavaFX/Paint.svg)

## 3. Knoten

TODO

![](../Grafiken/JavaFX/Node.svg)

## 4. 2D-Formen

TODO

![](../Grafiken/JavaFX/Shape.svg)

## 5. 3D-Formen

TODO

![](../Grafiken/JavaFX/Shape3D.svg)

## 6. Kameras

TODO

![](../Grafiken/JavaFX/Camera.svg)

## 7. Lichter

TODO

![](../Grafiken/JavaFX/Light.svg)

## 8. Eltern

TODO

![](../Grafiken/JavaFX/Parent.svg)

## 9. Regionen

TODO

![](../Grafiken/JavaFX/Region.svg)

## 10. Anordnungen

TODO

![](../Grafiken/JavaFX/Pane.svg)

### 10.1. `BorderPane`

TODO

### 10.2. `GridPane`

TODO

### 10.3. `StackPane`

TODO

### 10.4. `FlowPane`

TODO

## 11. Steuerelemente

TODO

### 11.1. `ScrollPane`, `SplitPane`, `TabPane` und `Pagination`

TODO

![](../Grafiken/JavaFX/Control.Pane.svg)

### 11.2. `MenuBar`, `ToolBar` und `ButtonBar`

TODO

![](../Grafiken/JavaFX/Control.Bar.svg)

### 11.3. `ListView`, `TableView`, `TreeView` und `TreeTableView`

TODO

![](../Grafiken/JavaFX/Control.View.svg)

### 11.4. `Label`, `Button`, `ToggleButton`, `MenuButton`, `Hyperlink` und `CheckBox`

TODO

![](../Grafiken/JavaFX/Control.Labeled.svg)

### 11.5. `TextField` und `TextArea`

TODO

![](../Grafiken/JavaFX/Control.TextInput.svg)

### 11.6. `ComboBox`, `DatePicker` und `ColorPicker`

TODO

![](../Grafiken/JavaFX/Control.ComboBox.svg)

### 11.7. `Spinner`, `Slider`, `ProgressIndictor` und `ChoiceBox`

TODO

![](../Grafiken/JavaFX/Control.Other.svg)