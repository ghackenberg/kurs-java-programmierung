# IP-Kommunikation mit Java

Moderne Softwreprodukte arbeiten in der Regel nicht mehr isoliert, sondern kommunizieren mit anderen Softwaresystemen weltweit.
Die Kommunikation erfolgt dabei typischerweise über das Internet Protokoll (IP), welches das die Adressierung und das Routing übernimmt.
Jedoch setzten Anwendungen normalerweise nicht direkt auf IP auf, sondern nutzen stattdessen eines der beiden folgenden Protokolle, welche auf IP aufbauen:

1. User Datagram Protokoll (UDP)
1. Transmission Control Protokoll (TCP)

## 1. User Datagram Protokoll (UDP)

Das folgende Diagramm zeigt die Klassen, welche Java für die Kommunikation mit dem User Datagram Protokoll bereitstellt.
Die für die Kommunikation benötigten IP-Adressen werden durch die Klasse `InetAddress` dargestellt.
Diese Klasse stellt insbesondere die einzelnen Bytes einer IP-Adresse bereit; die Anzahl der Bytes ist dabei abhängig von der IP-Version.
Ein UDP-Datagram wird hingegen durch die Klasse `DatagramPacket` dargestellt, welche die IP-Adresse, einen Port, und die Nutzdaten beinhaltet.
Schließlich kann die Klasse `DatagramSocket` verwendet werden, um UDP-Datagramme zu senden und zu empfangen.

![](../Grafiken/Net/UDP.svg)

### 1.1. UDP-Pakete senden

Das erste Beispiel zeigt, wie man mit den vorhin eingeführten Klassen ein UDP-Datagram an eine definierte IP-Adresse und einen definierten Port sendet.
Das Beispiel erzeugt zunächst eine Instanz der Klasse `DatagramPacket` und setzt die IP-Adresse und die Portnummer des Empfängers sowie die Nutzdaten.
Danach erzeugt das Beispiel eine Instanz der Klasse `DatagramSocket`, welches für das Senden des UDP-Datagramms verantwortlich ist.

```java
// IP-Adresse des Empfängers festlegen
InetAddress address = ...

// Portnummer des Empfängers festlegen
int port = ...

// Inhalt des UDP-Pakets festlegten
byte[] data = ...

// UDP-Paket erzeugen
DatagramPacket packet = new DatagramPacket()
packet.setAddress(address)
packet.setPort(port)
packet.setData(data)

// UDP-Paket senden
DatagramSocket socket = new DatagramSocket()
socket.send(packet)
```

### 1.2. UDP-Pakete empfangen

Das zweite Beipsiel zeigt, wie man mit den vorhin eingeführten Klassen ein UDP-Datagramm empfängt.
Das Programm legt zunächst eine Puffer an, um den Inhalt des Datenpakets im Hauptspeicher ablegen zu können.
Dann erzeugt das Programm eine leere Instanz der Klasse `DatagramPacket`, welcher der zuvor angelegte Puffer zugeordnet wird.
Schließlich erzeugt das Programm eine Instanz der Klasse `DatagramSocket` mit einer definierten Portnummer, über welche die eingehenden UDP-Datagramme empfangen werden sollen.
Schließlich blockiert das Programm beim Aufruf der Methode `receive(...)` solange, bis ein UDP-Datagramm empfangen wurde.

```java
// Portnummer für das Empfangen festlegen
int port = ...

// Größe des Buffer festlegen
int size = ...

// Buffer anlegen
byte[] buffer = new byte[size]

// Leeres UDP-Paket erzeugen
DatagramPacket packet = new DatagramPacket()
packet.setData(buffer)

// UDP-Paket empfangen und befüllen
DatagramSocket socket = new DatagramSocket(port)
socket.receive(packet)
```

## 2. Transmission Control Protokoll (TCP)

Das folgende Diagramm zeigt die Klassen, welche Java für die Kommunikation mit dem Transmission Control Protokoll (TCP) bereitstellt.
Die dafür notwendigen IP-Adressen der beiden Teilnehmer werden wieder über die Klasse `InetAddress` dargestellt, welche die einzelnen Adressbytes beinhaltet.
Eine TCP-Verbindung zwischen zwei Teilnehmern wird über die Klasse `Socket` dargestellt, welche einen Ein- und einen Ausgabestrom für die Kommunikation bereitstellt.
Beachte, dass bei einer bestehenden Verbindung sowohl der TCP-Server als auch der TCP-Client eine Instanz der Klasse `Socket` hat.
Die Ein- und Ausgabeströme dieser beiden Instanzen sind jeweils vertauscht, d.h. was beim Server ein Eingabestrom ist, ist beim Client ein Ausgabestrom, und umgekehrt.
Ein TCP-Server wird schließlich noch durch eine Instanz der Klasse `ServerSocket` dargestellt, über welche eingehende Verbindungen angenommen werden können.

![](../Grafiken/Net/TCP.svg)

### 2.1. TCP-Client erstellen

Das erste Beispiel zeigt, wie man einen TCP-Client in Java programmiert.
Das Beispiel importiert zunächst die Klasse `Socket` aus dem Paket `java.net`, welche TCP-Verbindungen auf Client- und Server-Seite repräsentiert.
Dann definiert das Beispiel den Host und den Port des Servers, mit welchem eine TCP-Verbindung aufgebaut werden soll.
Schließlich erzeugt das Beispiel eine Instanz der Klasse `Socket` mit dem zuvor definierten Host und der zuvor definierten Portnummer.

```java
import java.net.Socket;

// Host definieren
String host = ...

// Port definieren
int port = ...

// Socket erzeugen
Socket socket = new Socket(host, port);
```

Der Aufruf des Konstruktors der Klasse `Socket` führt dazu, dass das Java-Programm versucht eine TCP-Verbindung mit dem Zielrechner aufzubauen (siehe 3-Way-Handshake).
Sobald die Verbindung aufgebaut wurde, kann der eigentliche Austausch von Daten zwischen Client und Server beginnen.
Das folgende Beispiel zeigt, wie der Client vom Server gesendete Daten empfangen kann.
Für das Empfangen von Daten bietet ein `Socket` den Zugriff auf einen `InputStream` (siehe [Daten lesen und schreiben mit `java.io`](Java.IO.md)).

```java
import java.io.InputStream;

// Eingabestrom lesen
InputStream in = socket.getInputStream();
in.read();
in.read();
in.read();
```

Ähnlich zum Empfangen von Daten können auch Daten an den Server gesendet werden.
Der `Socket` bietet für das Senden von Daten den Zugriff auf einen entsprechenden `OutputStream`.
Über diesen Ausgabestrom können wie bereits bekannt Rohdaten (d.h. einzelne Bytes) verschickt werden.
Alternativ können natürlich auch Zeichenketten mit einer entsprechenden Codierung auf einen Ausgabestrom geschrieben werden.

```java
import java.io.OutputStream;

// Ausgabestrom schreiben
OutputStream out = socket.getOutputStream();
out.write(13);
out.write(72);
out.write(154);
```

Wenn der Client die TCP-Verbindung beenden will, kann er die Methode `close()` der Klasse `Socket` aufrufen.
Der Aufruf dieser Methode führt dazu, dass sofern noch nicht geschehen die notwendigen TCP-Pakete für das Schließen der TCP-Verbindung zwischen Client und Server ausgetauscht werden.
Außerdem sorgt der Aufruf dafür, dass die vom Client zufällig gewählte Portnummer freigegebn wird und anderen Applikation damit wieder zur Verfügung steht.

```java
// Socket schließen
socket.close();
```

Während der Nutzung einer TCP-Verbindung können prinzipiell Ausnahmen ausgelöst werden, welche dazu führen, dass die TCP-Verbindung nicht ordnungsgemäß beendet wird.
Falls ein solcher Systemzustand eintrifft, kann das dazu führen, dass die reservierten Ressourcen auf Betriebssystemebene auch nicht wieder freigegeben werden.
Um einen solchen Zustand zu verhindern, ist es generell empfehlenswert die Verbindung mit `try-with-resources` aufzubauen, wie in folgendem Beispiel gezeigt.

```java
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

// Host definieren
String host = ...

// Port definieren
int port = ...

// Socket erzeugen und am Ende implizit wieder schließen
try (Socket socket = new Socket(host, port)) {

    // Eingabestrom lesen
    InputStream in = socket.getInputStream();
    in.read();
    in.read();
    in.read();

    // Ausgabestrom schreiben
    OutputStream out = socket.getOutputStream();
    out.write(13);
    out.write(72);
    out.write(154);

} catch (IOException e) {

    // Fehler auf der Konsole ausgeben
    e.printStackTrace();

}
```

### 2.2. TCP-Server erstellen

Das zweite Beispiel zeigt, wie man in Java einen TCP-Server startet und eingehende Verbindungen entgegennimmt bzw. verarbeitet.
Dazu importieren wir zunächst die Klasse `ServerSocket` aus dem Paket `java.net` und definieren die Portnummer, auf der wir eingehende Verbindungen erwarten.
Dann erzeugen wir eine Instanz der Klasse `ServerSocket`, der wir die Portnummer übergeben und welche das Java-Programm im Betriebssystem für die Portnummer registriert.

```java
import java.net.ServerSocket;

// Port definieren
int port = ...

// Server starten
ServerSocket server = new ServerSocket(port);
```

Sobald die Instanz der Klasse `ServerSocket` erstellt wurde und die Portnummer nicht von einem anderen Programm belegt war, können wir eingehende Verbindungen entgegennehmen.
Für das Entgegennehmen von TCP-Verbindungen bietet die Klasse `ServerSocket` die Methode `accept()`, welche solange blockiert bis eine neue Verbindung zu einem Client aufgebaut wurde.
Die Methode `accept()` liefert eine Instanz der Klasse `Socket` aus dem Paket `java.net`, welche auch auf Server-Seite die TCP-Verbindung zwischen Client und Server repräsentiert.

```java
import java.net.Socket;

// TCP-Verbindung annehmen
Socket socket = server.accept();
```

Nachdem die TCP-Verbindung aufgebaut wurde, können Server und Client bidirektional Daten über die Verbindung austauschen.
Für das Empfangen von Daten bietet die Klasse `Socket` auch auf Server-Seite Zugriff auf einen `InputStream`, welcher zum Lesen von Rohdaten (d.h. Bytes) verwendet werden kann.
Das folgende Beispiel zeigt, wie man hintereinander drei einzelne Bytes aus dem Eingabestrom ließt.
Die Aufrufe der Methode `read()` blockieren ebenfalls solange, bis die Daten tatsächlich vom Server empfangen wurden.

```java
import java.io.InputStream;

// Eingabestrom lesen
InputStream in = socket.getInputStream();
in.read();
in.read();
in.read();
```

Genauso wie Emfangen von Daten kann der Server auch Daten an den Client senden.
Für das Senden von Daten bietet die Klasse `Socket` Zugriff auf einen entsprechenden `OutputStream`.
Über den Ausgabestrom können wieder Rohdaten (d.h. einzelne Bytes) an den Client gesendet werden.
Dabei ist zu beachten, dass in der Regel nicht jedes einzelne Byte über ein eigenes TCP-Segment versendet wird.
Stattdessen werden typischerweise mehrere Bytes zusammengefasst und gemeinsam über ein einzelnes Segment versendet.

```java
import java.io.OutputStream;

// Ausgabestrom schreiben
OutputStream out = socket.getOutputStream();
out.write(13);
out.write(72);
out.write(154);
```

Wenn die TCP-Verbindung zwischen Client und Server nicht mehr benötigt wird, kann diese geschlossen werden.
Zum Schließen der TCP-Verbindung bietet die Klasse `Socket` wieder die Methode `close()` an.
Wenn die Methode `close()` aufgerufen wird, führt das dazu, dass - sofern noch nicht geschehen - die notwendigen TCP-Pakete zum Schließen der Verbindung ausgetauscht werden.
Außerdem werden reservierte Ressourcen auf Betriebssystemebene wieder freigegeben.

```java
// Socket schließen
socket.close();
```

Nachdem eine TCP-Verbindung zu einem bestimmten Client geschlossen wurde, kann der Server jedoch weiter TCP-Verbindungen zu demselben oder anderen Clients annehmen und verarbeiten.
Wenn das Serverprogramm jedoch keine weiteren TCP-Verbindungen annehmen will, muss es auch den zugehörigen `ServerSocket` über die Methode `close()` beenden.
Der Aufruf dieser Methode hat zur Folge, dass im Betriebssystem die Zuordnung zwischen Portnummer und dem Serverprogramm wieder gelöst wird und somit keine TCP-Verbindungen für diese Portnummer mehr an das Java-Programm weitergeleitet werden.

```java
// Server beenden
server.close();
```

Schließlich kann es auch bei der Verarbeitung von TCP-Verbindungen zu Ausnahmen kommen, welche die ordentliche Schließung eines `Socket` und/oder eines `ServerSocket` umgehen.
Um einen solchen Systemzustand zu vermeiden, wird daher auch in diesem Fall die Verwendung von `try-with-resources` empfohlen.
Das folgende Beispiel zeigt, wie man sowohl den `ServerSocket` als auch die angenommenen TCP-Verbindungen über dieses Mittel sauber absichert.

```java
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// Port definieren
int port = ...

// Server starten und implizit am Ende beenden
try (ServerSocket server = new ServerSocket(port)) {

    // Verbindung annehmen und implizit am Ende schließen
    try (Socket socket = server.accept()) {

        // Eingabestrom lesen
        InputStream in = socket.getInputStream();
        in.read();
        in.read();
        in.read();

        // Ausgabestrom schreiben
        OutputStream out = socket.getOutputStream();
        out.write(13);
        out.write(72);
        out.write(154);

    } catch (IOException e) {

        // Fehler auf der Konsole ausgeben
        e.printStackTrace();

    }

} catch (IOException e) {

    // Fehler auf der Konsole ausgeben
    e.printStrackTrace();

}
```