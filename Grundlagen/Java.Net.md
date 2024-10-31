# IP-Kommunikation mit Java

TODO

* User Datagram Protokoll (UDP)
* Transmission Control Protokoll (TCP)

## User Datagram Protokoll (UDP)

TODO

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

TODO

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

TODO

![](../Grafiken/Net/UDP.svg)

## Transmission Control Protokoll (TCP)

TODO

```java
// Client
```

TODO

```java
// Server
```

TODO

![](../Grafiken/Net/TCP.svg)