# Grafische Benutzerschnittstellen mit JavaFX

Dieses Dokument beschreibt, wie man mittels JavaFX grafische Benutzerschnittstellen entwickelt.

* `Application` - Basisklasse einer JavaFX-Anwendung
* `Stage` - Fenster zur Darstellung von Inhalten
* `Scene` - Container für den Inhalt eines Festers
* `Parent` - Der eigentliche Inhalt des Fensters
* `Node` - Basisklasse für alle Arten von Inhalten

Nodes:

* `Canvas` - Durchführung von Zeichenoperationen
* `ImageView` - Anzeigen von Bildern
* `MediaView` - Abspielen von Videos und Sounds
* `SubScene` - *TODO*
* `Shape`- 2D-Formen wie Rechtecke und Kreise
* `Shape3D` - 3D-Formen wie Würfel und Kugeln
* `Camera` - Kameras für das Rendering von 3D-Formen

2D-Shapes:

* `Line` - *TODO*
* `Polyline` - *TODO*
* `Rectangle` - *TODO*
* `Polygon` - *TODO*
* `Circle` - *TODO*
* `Ellipse` - *TODO*
* `Text` - *TODO*

3D-Shapes:

* `Box` - Wurfel-Geometrie mit Länge, Höhe und Tiefe
* `Cylinder` - Zylinder-Geometrie mit Radius und Höhe
* `Sphere` - Kugel-Geometrie mit Radius
* `MeshView` - Beliebige Form bestehend aus Dreiecken

Cameras:

* `ParallelCamera` - Orthografische Projektion der Formen
* `PerspectiveCamera` - Perspektifische Projektion der Formen

Parents:

* `Group` - Gruppierung von Kindknoten
* `Region` - Gerahmte Fläche für Kindknoten
* `WebView` - Anzeige von HTML-Seiten

Regions:

* `Pane` - *TODO*
* `Chart` - *TODO*
* `Axis` - *TODO*
* `Control` - *TODO*

Panes:

* `BorderPane` - *TODO*
* `GridPane` - *TODO*
* `StackPane` - *TODO*
* `FlowPane` - *TODO*

Controls:

* `ScrollPane`, `SplitPane` und `TabPane`
* `MenuBar`, `ToolBar` und `ButtonBar`
* `ListView`, `TableView`, `TreeView` und `TreeTableView`
* `Label`, `Button`, `ToggleButton`, `MenuButton`, `Hyperlink` und `CheckBox`
* `Spinner`, `Slider`, `ProgressIndictor` und `ChoiceBox`

## 1. `Application`, `Stage`, `Scene`, `Parent` und `Node`

Das 

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

## 2. `Canvas`, `ImageView`, `MediaView`, `SubScene`, `Shape`, `Shape3D` und `Camera`

TODO

![](../Grafiken/JavaFX/Node.svg)

## 3. `Line`, `Polyline`, `Rectangle`, `Polygon`, `Circle`, `Ellipse` und `Text`

TODO

![](../Grafiken/JavaFX/Shape.svg)

## 4. `Box`, `Cylinder`, `Sphere` und `MeshView`

TODO

## 5. `ParallelCamera` und `PerspectiveCamera`

TODO

## 6. `Group`, `Region` und `WebView`

TODO

![](../Grafiken/JavaFX/Parent.svg)

TODO

![](../Grafiken/JavaFX/Paint.svg)

## 7. `Pane`, `Chart`, `Axis` und `Control`

TODO

![](../Grafiken/JavaFX/Region.svg)

## 8. Panes

TODO

![](../Grafiken/JavaFX/Pane.svg)

### 8.1. `BorderPane`

TODO

### 8.2. `GridPane`

TODO

### 8.3. `StackPane`

TODO

### 8.4. `FlowPane`

TODO

## 9. Controls

TODO

### 9.1. `ScrollPane`, `SplitPane` und `TabPane`

TODO

![](../Grafiken/JavaFX/Control.Pane.svg)

### 9.2. `MenuBar`, `ToolBar` und `ButtonBar`

TODO

![](../Grafiken/JavaFX/Control.Bar.svg)

### 9.3. `ListView`, `TableView`, `TreeView` und `TreeTableView`

TODO

![](../Grafiken/JavaFX/Control.View.svg)

### 9.4. `Label`, `Button`, `ToggleButton`, `MenuButton`, `Hyperlink` und `CheckBox`

TODO

![](../Grafiken/JavaFX/Control.Labeled.svg)

### 9.5. `Spinner`, `Slider`, `ProgressIndictor` und `ChoiceBox`

TODO

![](../Grafiken/JavaFX/Control.Other.svg)