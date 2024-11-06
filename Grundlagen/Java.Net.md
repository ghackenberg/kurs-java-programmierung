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

TODO

```java
import java.net.Socket;

// Host definieren
String host = ...

// Port definieren
int port = ...

// Socket erzeugen
Socket socket = new Socket(host, port);
```

TODO

```java
// Eingabestrom lesen
InputStream in = socket.getInputStream();
in.read();
in.read();
in.read();
```

TODO

```java
// Ausgabestrom schreiben
OutputStream out = socket.getOutputStream();
out.write(13);
out.write(72);
out.write(154);
```

TODO

```java
// Socket schließen
socket.close();
```

TODO

```java
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

TODO

```java
// Server
```