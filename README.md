# Kurs in Java Programmierung

![](./Grafiken/Social-Preview.png)

Dieses Repository enthält Unterlagen zum Kurs in Java-Programmierung, welcher an der [Fakultät für Technik und angewandte Naturwissenschaften](https://fh-ooe.at/campus-wels) (*engl.* School of Engineering) der [Fachhochschule Oberösterreich](https://fh-ooe.at/) unterrichtet wird.

*Beachte, dass sich der Kurs an Personen richtet, die bereits mit einer anderen objektorientierten Programmiersprache wie C# oder C++ umgehen können.*
*Deshalb verzichten wir auf die Einführung grundlegender Elemente von (objektorientierten) Programmiersprachen wie Datentypen, Operatoren, Literale, Variablen, Zuweisungen, Verzweigungen, Schleifen, Funktionen, Klassen, Methoden und Namensräume.*

Im Folgenden findest du **Grundlagen** der Java-Programmierung mit unterschiedlichen Standardbibliotheken, konkrete **Anwendungen** inklusive vollständigem Quelltext, und **Regelungen** zur Nutzung dieses Repositories.

## Grundlagen

Je nach konkreter Anwendungen kommen in der Regel verschiedene Bibliotheken und Frameworks zum Einsatz.
Im Rahmen dieses Kurses werden die folgenden Themen betrachtet:

* [Dateneingabe und -ausgabe mit `java.io`](./Grundlagen/Java.IO.md)
* [Netzwerk-Kommunikation mit `java.net`](./Grundlagen/Java.Net.md)
* [Grafische Benutzerschnittstellen mit `javafx`](./Grundlagen/JavaFX.md)
  * [*Vertiefung 1:* Steuerelemente](./Grundlagen/JavaFX-Controls.md)
  * [*Vertiefung 2:* 2D-Visualisierungen](./Grundlagen/JavaFX-2D.md)
  * [*Vertiefung 3:* 3D-Visualisierungen](./Grundlagen/JavaFX-3D.md)

## Anwendungen

*Mit konkreten Beispielen lernt man doch am besten!*
Das Repository bietet dir einfache Beispiele, um die Entwicklung von Anwendungen mit der Programmiersprache Java zu erlernen.
Im folgenden unterscheiden wir zwischen Konsolenanwendungen, welche typischerweise im Hintergrund laufen, sowie grafischen Anwendungen, mit denen die Benutzer direkt interagieren.

### Konsolenanwendungen

Dieser Abschnitt führt dich in die Entwicklung von Konsolenanwendungen mit der Programmiersprache Java ein und beinhaltet die folgenden Beispiele:

- Das erste Beispiel fokussiert sich auf die Eingabe und Ausgabe von Daten über die Konsole sowie die Umwandlung von Rohdaten und Zeichenketten.
- Das zweite Beispiel betrachtet hingegen die Kommunikation von Anwendungen über das IP-Netzwerke und das User Datagram Protocol.

#### 💻 [Konsole.IO](./Quellen/Konsole/IO/)

Die erste Anwendung ist ein einfacher Taschenrechner, der die Grundrechenarten beherrscht.
Das Programm ließt vom Benutzer nacheinander zwei Zahlen und einen Rechenoperator ein.
Danach führt das Programm die gewünschte Berechnung durch und gibt das Ergebnis aus.
Zudem prüft das Programm die Gültigkeit der Eingaben, um die korrekte Funktion zu gewährleisten.
Bei ungültigen Eingaben gibt das Programm eine Fehlermeldung aus und wiederholt die Eingabe.

![](./Quellen/Konsole/IO/Screenshot.png)

Die folgende Grafik zeigt den technischen Aufbau der Taschenrechneranwendung.
Die Anwendung besteht aus einer Programmklasse mit einer Hauptroutine sowie weiteren Klassen für die Datenein- und -ausgabe.
Die Dateneingabe erfolgt über einen `BufferedReader`, mit dem ganze Zeilen eingelesen werden können.
Die Zeileneingabe basiert wiederum auf einem `InputStreamReader`, welche Eingaberohdaten in Zeichen mit einer Zeichenkodierung (z.B. UTF-8) verwandelt.
Die Zeicheneingabe nutzt schließlich die Standardeingabe, welche die notwendigen Rohdaten liefert.
Die Ausgabe erfolgt ebenso über die Standardausgabe der Konsolenanwendung, welche sowohl Rohdaten als auch Zeichenketten verarbeiten kann.

![](./Quellen/Konsole/IO/Architecture.svg)

#### 💻 [Konsole.Net](./Quellen/Konsole/Net/)

Die zweite Anwendung zeigt das Senden und Empfangen von UDP-Paketen.
Die Anwendung umfasst eine Client- und eine Serveranwendung, die separat gestartet werden müssen.
Die Clientanwendung fragt zunächst eine Eingabe vom Benutzer über die Konsole ab.
Danach erstellt die Anwendung ein UDP-Paket mit der Eingabe als Inhalt.
Schließlich sendet das Programm das Paket an eine vordefinierte IP-Adresse und eine vordefinierte Portnummer.

![](./Quellen/Konsole/Net/Screenshot-Client.png)

Die Serveranwendung wartet hingegen auf eingehende UDP-Pakete auf einer vordefinierten Portnummer.
Sobald ein UDP-Paket eingegangen ist, werden die Paketinformation auf der Konsole ausgegeben.
Die Paketinformationen beinhalten die IP-Adresse und die Portnummer des Paketsenders.
Des weiteren beinhalten die Paketinformationen den eigenliche Nutzinhalt sowie dessen Zeichenlänge.
Nachdem die Informationen ausgegeben wurden, terminiert die Anwendung.

![](./Quellen/Konsole/Net/Screenshot-Server.png)

Die folgende Grafik zeigt den technischen Aufbau der Anwendung bestehend aus einem Client und einem Server.
Sowohl der Client als auch der Server werden durch eine Programmklasse mit einer Hauptroutine dargestellt.
Beide Programmklassen nutzen wiederum die Klassen `DatagramSocket` zum Senden und Empfangen sowie `DatagramPacket` zur Darstellung von Datenpaketen.
Auf Clientseite enthält das Datenpaket die Adresse des Servers, auf Serverseite hingegen die Adresse des Clients.

![](./Quellen/Konsole/Net/Architecture.svg)

### Grafische Anwendungen (GUIs)

Dieser zweite Abschnitt beschäftigt sich mit der Entwicklung von grafischen Benutzerschnittstellen und Anwendungen mit der Programmiersprache Java und enthält die folgenden Beispiele:

- Das erste Beispieö betrachtet die Erstellung von klassischen Menüstrukturen sowie die Registrierung von Ereignisroutinen.
- Das zweite Beispiel fokussiert die Darstellung und Bearbeitung von Datensammlungen mit Listen und Tabellen.
- Das dritte Beispiel erklärt die Erstellung von Datenvisualisierungen mit Diagrammen und anderen Grafikelementen.
- Und das vierte Beispiel zeigt die Entwicklung einer Chat-Anwendung basierend auf dem User Datagram Protocol.

#### 💻 [GUI.Menüs](./Quellen/GUI/Menüs/)

Die dritte Anwendung dient der Einführung in die Entwicklung grafischer Benutzerschnittstellen mit dem JavaFX Framework. Dazu benötigen wir unter Anderem Apache Maven für die Projektverwaltung. Insbesondere ermöglich Apache Maven die deklarative Beschreibung von Abhängigkeiten zu anderen Bibliotheken (in diesem konkreten Fall OpenJFX), die nicht standardmäßig mit der Java Laufzeitumgebung ausgeliefert werden.

![](./Quellen/GUI/Menüs/Screenshot.png)

Die folgende Grafik zeigt die zugrunde liegende Objektstruktur der grafischen Anwendung.
An oberster Stelle der Struktur findet wir ein Randlayout, welches ein Menüband als Kindknoten enthält.
Das Menüband wiederum enthält drei verschiedene Menüs, welche aus unterschiedlichen Menüelementen bestehen.
Die Menüelemente verweisen schließlich auf Ereignisroutinen, welche bei deren Auswahl ausgeführt werden.
In den Ereignisroutinen kann man folglich die individuelle Funktionsweise der Menüelemente definieren.

![](./Quellen/GUI/Menüs/Scene.svg)

#### 💻 [GUI.Visualisierungen](./Quellen/GUI/Visualisierungen/)

Die vierte Anwendung zeigt Möglichkeiten auf, wie man in JavaFX Visualisierungen integrieren kann. Standardmäßig bietet JavaFX die Möglichkeit, einfache Diagrammvisualisierungen in Anwendungen zu integrieren. Darüber hinaus bietet JavaFX auch die Möglichkeit, eingene 2D- und 3D-Visualiserungen zu programmieren. Für eigene Visualisierungen steht ein entsprechendes Objektmodell bestehend aus 2D-Formen (Linien, Kreise, usw.) und 3D-Formen (Kugeln, Würfel, usw.) zur Verfügung.

![](./Quellen/GUI/Visualisierungen/Screenshot.png)

Die folgende Grafik zeigt die zugrunde liegende Objektstruktur dieses Beispiels.
Der oberste Knoten der Objektstruktur ist ein Rasterlayout, welches vier Kindknoten beinhaltet.
Der erste Kindknoten ist das Tortendiagramm, welches in der linken oberen Rasterzelle zu sehen ist.
Der zweite Kindknoten ist das Balkendiagramm, welches in der rechten oberen Rasterzelle zu sehen ist.
Der dritte Kindknoten ist die 2D-Visualisierung, welche in der linken unteren Zelle zu sehen ist.
Und der vierte Kindknoten ist die 3D-Visualisierung, welche in der rechten unteren Zelle zu sehen ist.

![](./Quellen/GUI/Visualisierungen/Scene.svg)

#### 💻 [GUI.Chat](./Quellen/GUI/Chat/)

Die fünfte Anwendung erweitert das vorige Beispiel zum Senden und Empfangen von UDP-Paketen um eine grafische Benutzerschnittstelle.
Die grafische Benutzerschnittstelle fragt zunächst den Namen des Nutzers, die gewünschte Portnummer für das Empfangen von Nachrichten, sowie die IP-Adresse und die Portnummer für das Senden von Nachrichten ab.
Danach kann der Benutzer Nachrichten eingeben und versenden.
Außerdem bekommt der Benutzer versendete und empfangene Nachrichten angezeigt.

![](./Quellen/GUI/Chat/Screenshot-Default.png)

Der folgende Screenshot zeigt den Aufbau der grafischen Benutzerschnittstelle bestehend aus einer Szene mit sogenannten Knoten.
JavaFX unterscheidet verschiedene Knotentypen wie Buttons, Texteingabefelder, Zahleneingabefelder und Beschriftungen (*rote* Kästen).
Des Weiteren bietet JavaFX bestimmte Knotentypen für das Layout von Kindelememten wie die Klassen `BorderPane`, `GridPane`, `ScrollPane` und `VBox` (*grüne* Kästen).
Beachte, dass der Stil jedes Knotens individuell konfiguriert werden kann.

![](./Quellen/GUI/Chat/Screenshot-Debug.png)

Die folgende Grafik zeigt den schematischen Aufbau der grafischen Benutzeroberfläche als Knotenbaum.
Die Wurzel des Knotenbaums ist eine Instanz der Klasse `Stage`, welche das gesamte Fenster repräsentiert.
Eine `Stage` enthält wiederum genau eine Instanz der Klasse `Scene`, welche den Inhalt des Fensters darstellt.
Die `Scene` enthält schließlich genau ein Wurzelelement, welches in diesem konkreten Fall eine Instanz der Klasse `BorderPane` ist.
Das Wurzelelemnt kann dann weitere Knoten beinhalten.

![](./Quellen/GUI/Chat/Scene.svg)

## Regelungen

Die Unterlagen für diesen Kurs sind grundsätzlich quelloffen.
Im Folgenden findest du weitere Informationen zur Nutzung der Unterlagen sowie zur Weiterentwicklung des Materials:

* [LICENSE](./LICENSE.md)
* [CHANGELOG](./CHANGELOG.md)
* [CONTRIBUTING](./CONTRIBUTING.md)