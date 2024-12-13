# Grafische Benutzerschnittstellen mit JavaFX

Dieses Dokument erklärt die Grundlagen der Entwicklung von grafischen Benutzerschnittstellen mit JavaFX.
Im Kern biete JavaFX ein Objektmodell, mit welchem die grafische Benutzerschnittstelle beschrieben werden kann.
Das Objektmodelle besteht aus einer Reihe unterscheidlicher Klassen, welche verschiedene Funktionen übernehmen.
Zunächst musst die die folgenden fünf Klassen kennenlernen, welche den Ausgangspunkt einer JavaFX-Objektstruktur bilden:

* `Application` - Basisklasse einer JavaFX-Anwendung
* `Stage` - Fenster zur Darstellung von Inhalten
* `Scene` - Container für den Inhalt eines Festers
* `Node` - Basisklasse für alle Arten von Inhalten
* `Parent` - Basisklasse für Inhalte mit Kindinhalten

Danach lernen wir ein paar Hilfsklassen kennen, die wir an der einen oder anderen Stelle später wieder benötigen.
Die Hilfsklassen sind dafür dar, verschiedene Farbfüllungen von einfachen Volltonfarben bis komplexeren Farbverläufen zu beschreiben.

* `Paint` - Basisklasse für alle Arten von Farbfüllungen
* `Color` - Darstellung von einfachen Volltonfarben
* `LinearGradient` - Darstellung von linenförmigen Farbverläufen
* `RadialGradient` - Darstellung von kreisförmigen und elliptischen Farbverläufen

Des Weiteren brauchen wir eine Möglichkeit, Schriftarten und weitere Schrifteigenschaften wie die Schriftgröße und die Schriftdicke zu spezifizieren.
Dafür bietet JavaFX die folgende Klasse an:

* `Font` - Darstellung von Schriftarten und deren Eigenschaften

Nach der Einführung der vorigen Basis- und Hilfsklassen können wir uns mit den unterschiedlichen Knotentypen beschäftigen, welche JavaFX bereitstellt.
Die einfachsten Knotentypen sind für die Darstellung von Bildern, Videos, und Sounds gedacht:

* `ImageView` - Anzeigen von Bildern
* `MediaView` - Abspielen von Videos und Sounds

Wenn die Anzeige von Bildern und anderen Medien nicht ausreicht, bietet JavaFX eine Reihe weiterer Knotentypen mit unterschiedlichen Eigenschaften an.
Konkret unterscheidet JavaFX auf dieser Ebene zwischen Regionen und der Anzeige von Webseiten:

* `Region` - Gerahmte Fläche mit Kindknoten als Inhalt
* `WebView` - Anzeige von Webseiten und Ausführung von JavaScript

Bei gerahmten Flächen unterscheidet JavaFX des Weiteren zwischen Anordnungen (sogenannten *Panes*) mit integrierten Anordungensverfahren und Steuerelementen (sogenannten *Controls*) mit Interaktionsmöglichkeiten:

* `Pane` - Verschiedene Anordnungen für Kindelemente
* `Control` - Steuerbare Inhalte wie Texteingaben und Knöpfe

Im Folgenden beschreiben wir die vorigen Konzepte genauer.
Insbesondere gehen wir auf die Vererbungsstruktur der Klassen, welche die Gemeinsamkeiten und Unterschiede der einzelnen Konzepte gut erklärt.

## 1. Anwendungen

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

## 2. Farben

TODO

![](../Grafiken/JavaFX/Paint.svg)

## 3. Schriftarten

TODO

![](../Grafiken/JavaFX/Font.svg)

## 4. Knoten

TODO

![](../Grafiken/JavaFX/Node.svg)

## 5. Eltern

TODO

![](../Grafiken/JavaFX/Parent.svg)

## 6. Regionen

TODO

![](../Grafiken/JavaFX/Region.svg)