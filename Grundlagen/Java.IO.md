# Dateneingabe und -ausgabe mit Java

Dateneingabe und -ausgabe sind zwei wichtige Funktionen, die alle Arten von Programmen unterstützen müssen.
Die Standardbibliothek der Java Laufzeitumgebung bietet einige grundlegende Elemente für Ein- und Ausgabe.
Im Folgenden betrachten wir diese beiden Aspekte:

1. **Ein- und Ausgabe von *Rohdaten***
   * Eingabe von Rohdaten (Konsole, Datei)
   * Ausgabe von Rohdaten (Konsole, Datei)
1. **Ein- und Ausgabe von *Zeichenketten***
   * Eingabe von Zeichenketten (Konsole, Datei)
   * Ausgabe von Zeichenketten (Konsole, Datei)

## 1. Ein- und Ausgabe von Rohdaten

### 1.1. Eingabe von Rohdaten

Die Eingabe von Rohdaten erfolgt grundsätzlich über sogenannte *Eingabeströme*, welche in Java durch die abstrakte Klasse `InputStream` repräsentiert werden.
In diesem ersten Abschnitt betrachten wir das Einlesen von Rohdaten von der Konsoleneingabe als auch von Dateien auf der Festplatte.
Die Konsoleneingabe wird durch das statische Feld `in` der Klasse `System` aus dem Paket `java.lang` ermöglicht.
Die Dateieingabe wird hingegen durch Instanzen der Klasse `FileInputStream` aus dem Paket `java.io` ermöglicht.
Diese Zusammenhänge sind noch einmal im folgenden Klassendiagramm dargestellt.

![](../Grafiken/IO/InputStream.svg)

#### 1.1.1. Konsoleneingabe von Rohdaten

Das erste Beispiel zeigt, wie man Rohdaten (d.h. einzelne Bytes) von der Konsoleneingabe liest.
Für das Lesen einzelner Bytes bietet die Klasse `InputStream` die Methode `read()`.
Die Methode liefert den Wert des jeweils nächsten Bytes aus dem Eingabestrom.
Wenn das Ende des Eingabestroms erreicht ist, liefert die Methode `read()` den Wert `-1`.

```java
import java.lang.System;

// Einzelne Bytes von Konsoleneingabe lesen
System.in.read()
System.in.read()
System.in.read()
```

#### 1.1.2. Dateieingabe von Rohdaten

Das zweite Beispiel zeigt, wie man Rohdaten von einer Datei auf der Festplatte liest.
Für das Auslesen einer Datei muss zunächst eine Instanz der Klasse `FileInputStream` erzeugt werden.
Dieser Instanz muss der Dateipfad übergeben werden, der gelesen werden soll.
Der Dateipad kann dabei entweder absolut oder relativ zur aktuellen Arbeitsverzeichnis sein.
Wenn die Datei nicht existiert, löst der Konstruktor eine Ausnahme vom Typ `FileNotFoundException` aus.
Wenn die Datei existiert, können danach einzelne Bytes mit der Methode `read()` ausgelesen werden.
Wenn die Eingabe beendet ist, muss der Eingabestrom mit der Methode `close()` geschlossen werden.

```java
import java.io.FileInputStream;

// Datei zum Lesen öffnen
FileInputStream in = new FileInputStream("pfad.ext");

// Einzelne Bytes aus Datei lesen
in.read();
in.read();
in.read();

// Datei wieder schließen
in.close();
```

### 1.2. Ausgabe von Rohdaten

Die Ausgabe von Rohdaten erfolgt grundsätzlich über sogenannte *Ausgabeströme*, welche in Java durch die abstrakte Klasse `OutputStream` repräsentiert werden.
In diesem ersten Abschnitt betrachten wir das Schreiben von Rohdaten in die Konsolenausgabe als auch in Dateien auf der Festplatte.
Die Konsolenausgabe wird durch das statische Feld `out` der Klasse `System` aus dem Paket `java.lang` ermöglicht.
Die Dateiausgabe wird hingegen durch Instanzen der Klasse `FileOutputStream` aus dem Paket `java.io` ermöglicht.
Diese Zusammenhänge sind noch einmal im folgenden Klassendiagramm dargestellt.

![](../Grafiken/IO/OutputStream.svg)

#### 1.2.1. Konsolenausgabe von Rohdaten

Das erste Beispiel zeigt zunächst wieder, wie man einzelne Bytes auf die Konsolenausgabe schreibt.
Die Konsolenausgabe kann über einen Ausgabestrom zugegriffen, der von der Klasse `System` aus dem Paket `java.lang` bereitgestellt wird.
Der Ausgabestrom implementiert die Schnittstelle `OutputStream`, welche wiederum die Methode `write(int value)` anbietet. 

```java
import java.lang.System;

// Einzelne Bytes in Konsolenausgabe schreiben
System.out.write(10);
System.out.write(31);
System.out.write(96);
```

#### 1.2.2. Dateiausgabe von Rohdaten

Das zweite Beispiel zeigt hingegen, wie man einzelne Bytes in eine Datei auf der Festplatte schreiben kann.
Für die Dateiausgabe bietet Java die Klasse `FileOutputStream` im Paket `java.io` an.
Wenn man eine Instanz dieser Klasse erzeugt, kann man den Dateipfad angeben, der zum Schreiben geöffnet werden soll.
Der Konstruktor kann prinzipiell eine `FileNotFoundException` werfen, wenn z.B. ein Order des Dateipfads nicht existiert.
Nachdem der Ausgabestrom erfolgreich erzeugt wurde, können wieder einzelne Bytes in die Datei geschrieben werden.
Wenn die Ausgabe beendet ist, sollte der Strom mit der Methode `close()` wieder geschlossen werden.

```java
import java.io.FileOutputStream;

// Datei zum Schreiben öffnen
FileOutputStream out = new FileOutputStream("pfad.ext");

// Einzelne Bytes in Datei schreiben
out.write(1);
out.write(25);
out.write(125);

// Datei wieder schließen
out.close();
```

## 2. Ein- und Ausgabe von Zeichenketten

### 2.1. Eingabe von Zeichenketten

Viele Anwendungen möchten Bytes ein- und ausgeben, sondern möchten stattdessen Zeichenketten verarbeiten.
Wie du bereits wissen solltest, benötigt man für die Umwandlung von Bytes in Zeichenketten eine zugehörige Zeichencode-Tabelle (z.B. ASCII oder UTF-8).
Des Weiteren sollte das Programm, das die Daten schreibt, mit derselben Zeichencode-Tabelle arbeiten wie das Programm, das die Daten wieder einliest.
Java bietet für die Ein- und Ausgabe von Zeichenketten das Konzept der `Reader` und `Writer` im Paket `java.io` an, welches technisch auf dem Konzept der Eingabe- und Ausgabeströme basiert.

![](../Grafiken/IO/Reader.svg)

#### 2.1.1. Konsoleneingabe von Zeichenketten

Das erste Beispiel zeigt, wie man den Eingabestrom für die Konsoleneingabe in einer `Reader` verwandelt und dann einzelne Zeichen einließt.
Für die Konsoleneinhabe ist nicht standardmäßig festgelegt, dass Zeichenketten eingelesen werden.
Vielmehr kann bzw. muss das jede Anwendung für sich selbst entscheiden.

```java
import java.lang.System;
import java.io.InputStreamReader;

// InputStream in Reader konvertieren
InputStreamReader reader = new InputStreamReader(System.in);

// Einzelne Zeichen aus Konsole lesen
reader.read();
reader.read();
reader.read();
```

Das zweite Beispiel zeigt, wie man einzelne Zeilen nacheinander von der Konsoleneingabe einließt.
Dazu muss zunächst der Eingabestrom der Konsoleneingabe in einen `Reader` verwandelt werden.
Danach muss dieser `Reader` in einen `BufferedReader` umgewandelt werden.
Der `BufferedReader` bietet schließlich die Methode `readLine()`.

```java
import java.lang.System;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// InputStream in Reader konvertieren
InputStreamReader reader = new InputStreamReader(System.in);

// Reader in BufferedReader konvertieren
BufferedReader buffered = new BufferedReader(reader);

// Einzelne Zeilen aus Konsole lesen
buffered.readLine();
buffered.readLine();
buffered.readLine();
```

#### 2.1.2. Dateieingabe von Zeichenketten

Das erste Beispiel zeigt, wie man einen Dateipfad zum Lesen von Zeichenketten öffnet.
Java bietet dafür die Klasse `FileReader`, deren Konstruktur den Dateipfad übergeben bekommt.
Der Konstruktor kann außerdem eine `FileNotFoundException` werfen, wenn der Dateipfad nicht existiert.
Wenn die Datei existiert, können einzelne Zeichen aus der Datei mit der Methode `read` gelesen werden.
Schlließlich muss der `FileReader` wieder mit der Methode `close()` geschlossen werden.

```java
import java.io.FileReader;

// Datei zum Lesen öffnen
FileReader reader = new FileReader("pfad.ext");

// Einzelne Zeichen aus Datei lesen
reader.read();
reader.read();
reader.read();

// Datei schließen
reader.close();
```

Das zweite Beispiel zeigt, wie man einzelne Textzeilen aus einer Datei einlesen kann.
Dazu muss zunächst die Datei lesend geöffnet werden, was eine `FileNotFoundException` auslösen kann.
Danach muss der `FileReader` in einen `BufferedReader` verwandelt werden.
Schließlich kann die Methode `readLine()` der Klasse `BufferedReader` verwendet werden, um einzelne Zeilen einzulesen.
Die Methode `readLine()` liefert denn Wert `null` zurück, wenn das Ende der Datei erreicht ist.
Nachdem die Eingabe beendet ist, muss der `Reader` noch mit der Methode `close()` geschlossen werden.

```java
import java.io.FileReader;
import java.io.BufferedReader;

// Datei zum Lesen öffnen
FileReader reader = new FileReader("pfad.ext");

// Reader in BufferedReader konvertieren
BufferedReader buffered = new BufferedReader(reader);

// Einzelne Zeilen aus Datei lesen
buffered.readLine();
buffered.readLine();
buffered.readLine();

// Datei schließen
buffered.close();
```

### 2.2. Ausgabe von Zeichenketten

Nun stellt sich abschließend noch die Frage, wie man Zeichenketten auf die Konsole oder in Dateien ausgeben kann.
Java bietet für die Ausgabe von Zeichenketten das Konzept der `Writer` an, welche die Methode `write(...)` zum schreiben einer Zeichenketten implementieren.
Von der abstrakten Klasse `Writer` gibt es wiederum einige konkrete Implementierungen, welche unterschiedliche Ziele verfolgen.
Die Klasse `OutputStreamWriter` ermöglicht beispielsweise die Umwandung eines Ausgabestroms für Rohdaten in einen `Writer` für Zeichenketten mit einer definierten Zeichencode-Tabelle.
Die Klasse `PrintWriter` ermöglicht hingegen die Ausgabe inklusive impliziter Umwandlung verschiedener Datentypen wie `boolean` oder `int` in Zeichenketten. 

![](../Grafiken/IO/Writer.svg)

#### 2.2.1. Konsolenausgabe von Zeichenketten

Das erste Beipsiel zeigt, wie man einzelne Zeichenketten auf der Konsole ausgeben kann.
Der Ausgabestrom `out` der Klasse `System` aus dem Paket `java.lang` implementiert dafür bereits die Klasse `PrintWriter`.
Somit können auf der Konsole einfach alle unterschiedlichen Datentypen ausgegeben werden, während der `PrintWriter` sich um die Typumwandlung kümmert.

```java
import java.lang.System;

// Einzelne Zeichenketten in Konsole schreiben
System.out.print("String");
System.out.print("String");
System.out.print("String");
```

#### 2.2.2. Dateiausgabe von Zeichenketten

Das folgende Beispiel zeigt, wie man einzelne Zeichenketten in eine Datei ausgegeben kann.
Dazu muss zunächst ein `FileWriter` für den gewünschten Dateipfad erzeugt werden.
Der Konstruktor dieser Klasse kann eine `FileNotFoundException` auslösen, wenn der Dateipfad nicht zum Schreiben geöffnet werden kann.
Nachdem die Datei erfolgreich geöffnet wurde, können mit der Methode `write(...)` einzelne Zeichenketten in die Datei geschrieben werden.
Wenn die Dateiausgabe beendet ist, muss der `FileWriter` noch mit der Methode `close()` geschlossen werden.

```java
import java.io.FileWriter;

// Datei zum Schreiben öffnen
FileWriter writer = new FileWriter("pfad.ext");

// Einzelne Zeichenketten in Datei schreiben
writer.write("String");
writer.write("String");
writer.write("String");

// Datei schließen
writer.close();
```