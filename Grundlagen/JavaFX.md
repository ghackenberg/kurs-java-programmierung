# Grafische Benutzerschnittstellen mit JavaFX

Dieses Dokument erklärt die Grundlagen der Entwicklung von grafischen Benutzerschnittstellen mit JavaFX.
Im Kern biete JavaFX ein Objektmodell, mit welchem die grafische Benutzerschnittstelle beschrieben werden kann.
Das Objektmodelle besteht aus einer Reihe unterscheidlicher Klassen, welche verschiedene Funktionen übernehmen.
Zunächst solltest du die folgenden fünf Klassen kennenlernen, welche den Ausgangspunkt einer JavaFX-Objektstruktur bilden:

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

Starten wir mit den wichtigsten fünf Klassen einer JavaFX-Anwendung wie in folgender Grafik dargestellt.
Zunächst besteht jede JavaFX-Anwendung aus einer Instanz der abstrakten Klasse `Application`, von welcher wir eine konkrete Unterklasse ableiten müssen.
Diese Klasse bekommt zur Laufzeit wiederum Zugriff auf eine Instanz der Klasse `Stage`, welche ein Fenster zur Ausgabe von grafischen Inhalten repräsentiert.
Die Inhalt des Fensters werden wiederum durch eine Instanz der Klasse `Scene` dargestellt, welche außerdem die Lage und die Größe des Fensters bestimmt.
Der Inhalt der Szene wird schließlich durch Instanzen der Klasse `Node` bzw. der Unterklasse `Parent` beschrieben, welche letztlich baumartige Knotenstrukturen definieren.

![](../Grafiken/JavaFX/Stage.svg)

Wenn wir nun eine JavaFX-Anwendung erstellen wollen, müssen wir zunächst eine Klasse anlegen, welche von der abstrakten Basisklasse `Application` erbt.
Unsere Klasse sollte eine statische Hauptroutine beinhalten, welche bei Anwendungsstart zur Ausführung kommt und die statische Methode `launch(...)` aufruft.
Außerdem muss unsere Klasse die Objektmethode `start(...)` implementieren, welche implizit durch den Aufruf der statischen Methode `launch(...)` zur Ausführung kommt.
Der Objektmethode `start(...)` wird schließlich eine Instanz der Klasse `Stage` übergeben, welche wir zur Konfiguration der Fensterinhalte verwenden können.

```java
import javafx.application.Application;
import javafx.stage.Stage;

// Programmklasse
public class Program extends Application {

    // Hauptroutine
    public static void main(String[] args) {
        // Aufruf der statischen launch-Methode
        Application.launch(args);
    }

    // Startmethode
    @Override
    public void start(Stage primaryStage) {
        // Konfiguration der Fensterinhalte
        ...
    }

}
```

Innerhalb der Objektmethode `start(...)` müssen wir zunächst die Inhalte des Fensters in Form einer baumartigen Knotenstruktur erzeugen.
Wie jede baumartige Struktur benötigen auch diese Struktur zumindest einen Wurzelknoten, welcher von der Klasse `Parent` abgeleitet ist.
Welche Knotentypen sich in JavaFX konkret dafür eignen, werden wir im späteren Verlauf des Kurses noch genauer betrachten.

```java
import javafx.scene.Parent;

        ...
        // Inhalt erzeugen
        Parent root = ...
        ...
```

Sobald die Knotenstruktur erstellt wurde, kann diese in eine Szene eingefügt werden, welche durch die Klasse `Scene` repräsentiert wird.
Neben dem Wurzelknoten der Knotenstruktur muss die Szene noch die Breite und die Höhe des Fenster in Pixeln kennen.
Beachte, dass die Werte für die Höhe und die Breite des Fensters nur gelten, wenn das Fenster nicht im maximierten Zustand angezeigt wird.
Im maximierten Zustand bestimmen die Bildschirmauflösung sowie die vom Betriebssystem anzeigte Elemente (z.B. Menüband am unteren Rand) die tatsächliche Fenstergröße.

```java
import javafx.scene.Scene;

        ...
        // Höhe in Pixeln definieren
        int width = ...
        // Breite in Pixeln definieren
        int height = ...
        // Szene erzeugen
        Scene scene = new Scene(root, width, height) 
        ...
```

Schließlich können wir das Szenenobjekt an die Instanz der Klasse `Stage` übergeben.
Außerdem können wir den Titel des Festers über die Instanz der Klasse `Stage` konfigurieren.
Schließlich müssen wir auf derselben Instanz noch die Methode `show()` aufrufen, um das Fenster auch tatsächlich sichtbar zu machen.
Und schon haben wir eine erste JavaFX-Anwendung realisiert!

```java
// Stage konfigurieren und anzeigen
primaryStage.setTitle("My application");
primaryStage.setScene(scene);
primaryStage.show();
```

## 2. Farbfüllungen

TODO

![](../Grafiken/JavaFX/Paint.svg)

## 3. Schriftarten

TODO

![](../Grafiken/JavaFX/Font.svg)

## 4. Knoten

TODO

![](../Grafiken/JavaFX/Node.svg)

## 5. Elternknoten

TODO

![](../Grafiken/JavaFX/Parent.svg)

## 6. Regionen

TODO

![](../Grafiken/JavaFX/Region.svg)