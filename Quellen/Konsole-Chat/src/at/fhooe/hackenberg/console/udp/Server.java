package at.fhooe.hackenberg.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class Server {

	public static void main(String[] args) {
		// Nachricht ausgeben
		System.out.println("Server started");
		// Socket öffnen
		try (DatagramSocket socket = new DatagramSocket(4000)) {
			// Buffer anlegen
			byte[] buffer = new byte[256];
			// Paket erzeugen
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			// Nachricht ausgeben
			System.out.println("Warte auf eingehendes UDP Datagram auf Port 4000");
			// Paket empfangen
			socket.receive(packet);
			// Client auslesen
			InetSocketAddress client = (InetSocketAddress) packet.getSocketAddress();
			// Clientdaten ausgeben
			System.out.println(client.getHostName());
			System.out.println(client.getAddress());
			System.out.println(client.getPort());
			// Paketdaten ausgeben
			System.out.println(packet.getOffset());
			System.out.println(packet.getLength());
			// Paketdaten umwandeln
			String message = new String(packet.getData(), packet.getOffset(), packet.getLength());
			System.out.println("Nachricht erhalten: " + message);
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Nachricht ausgeben
		System.out.println("Server terminated");
	}

}
