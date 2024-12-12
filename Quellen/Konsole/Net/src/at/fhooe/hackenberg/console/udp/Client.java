package at.fhooe.hackenberg.console.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

	public static void main(String[] args) {
		// Nachricht ausgeben
		System.out.println("Client started");
		// Socket öffnen
		try (DatagramSocket socket = new DatagramSocket()) {
			// InputStream in Reader umwandeln (byte -> char)
			InputStreamReader input = new InputStreamReader(System.in);
			// Reader in BufferedReader umwandeln (char -> line)
			BufferedReader buffered = new BufferedReader(input);
			// Eingabe auffordern
			System.out.print("Nachricht eingeben: ");
			// Ganze Zeile einlesen
			String line = buffered.readLine();
			// Buffer erzeugen
			byte[] buffer = line.getBytes();
			// Addresse erzeugen
			InetAddress address = InetAddress.getLocalHost();
			// Paket erzeugen
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 4000);
			// Paket senden
			socket.send(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Nachricht ausgeben
		System.out.println("Client terminated");
	}

}
