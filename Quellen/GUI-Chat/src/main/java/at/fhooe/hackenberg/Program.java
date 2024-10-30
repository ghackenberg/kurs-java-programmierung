package at.fhooe.hackenberg;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Program extends Application {

	public static void main(String[] args) {
		
		Program.launch(args);
		
	}
	
	private DatagramSocket socket;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Nutzernamen abfragen
		
		TextInputDialog nameInput = new TextInputDialog("Anonymous");
		nameInput.setTitle("Dein Name");
		nameInput.setHeaderText("Gib bitte deinen Namen ein.");
		nameInput.setContentText("Name:");
		nameInput.showAndWait();
		
		String name = nameInput.getResult();
		
		// Portnummer abfragen
		
		TextInputDialog ownPortInput = new TextInputDialog("4000");
		ownPortInput.setTitle("Dein Port zum Empfangen");
		ownPortInput.setHeaderText("Gib bitte deinen Port zum Empfangen von Nachrichten ein.");
		ownPortInput.setContentText("Port:");
		ownPortInput.showAndWait();
		
		int ownPort = Integer.parseInt(ownPortInput.getResult());
		
		// IP-Adresse abfragen
		
		TextInputDialog otherAddressInput = new TextInputDialog("localhost");
		otherAddressInput.setTitle("Die IP-Adresse zum Senden");
		otherAddressInput.setHeaderText("Gib bitte die IP-Addresse zum Senden von Nachrichten ein.");
		otherAddressInput.setContentText("IP-Adresse:");
		otherAddressInput.showAndWait();
		
		InetAddress otherAddress = InetAddress.getByName(otherAddressInput.getResult());
		
		// Portnummer abfragen
		
		TextInputDialog otherPortInput = new TextInputDialog("4000");
		otherPortInput.setTitle("Der Port zum Senden");
		otherPortInput.setHeaderText("Gib bitte den Port zum Senden von Nachrichten ein.");
		otherPortInput.setContentText("Port:");
		otherPortInput.showAndWait();
		
		int otherPort = Integer.parseInt(otherPortInput.getResult());
		
		// GUI erstellen
		
		VBox vertical = new VBox();
		vertical.setSpacing(10);
		vertical.setPadding(new Insets(10));
		
		ScrollPane scroll = new ScrollPane();
		scroll.setFitToWidth(true);
		scroll.setContent(vertical);
		
		TextField message = new TextField("Nachricht");
		
		Button send = new Button("Senden");
		send.setOnAction(event -> {
			try (DatagramSocket socket = new DatagramSocket()) {
				// Nachrichtentext erzeugen
				String data = name + ": " + message.getText();
				
				// Nachrichtentext umwandeln
				byte[] buffer = data.getBytes();

				// UDP-Paket erzeugen
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length, otherAddress, otherPort);

				// UDP-Paket senden				
				socket.send(packet);
				
				// Nachrichtentext in der Nachrichtenliste anzeigen
				Label label = new Label(data);
				label.setPadding(new Insets(10));
				label.setStyle("-fx-background-color: lightgreen; -fx-background-radius: 10;");
				label.setWrapText(true);
				
				HBox box = new HBox();
				box.setAlignment(Pos.CENTER_RIGHT);
				box.getChildren().add(label);
				
				vertical.getChildren().add(box);
				
				// Inhalt des Texteingabefeldes leeren
				message.setText("");
				
				// Fokus zurück auf das Texteingabefeld setzen
				message.requestFocus();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		BorderPane bottom = new BorderPane();
		bottom.setPadding(new Insets(10));
		bottom.setCenter(message);
		bottom.setRight(send);
		BorderPane.setMargin(send, new Insets(0, 0, 0, 10));
		
		BorderPane main = new BorderPane();
		main.setCenter(scroll);
		main.setBottom(bottom);
		
		Scene scene = new Scene(main, 640, 480);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("GUI-Chat");
		primaryStage.setOnCloseRequest(event -> {
			try {
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		primaryStage.show();
		
		// Thread zum Empfangen von Nachrichten starten
		
		Thread thread = new Thread(() -> {
			try {
				// UDP-Socket erzeugen
				socket = new DatagramSocket(ownPort);
				
				// Datenbuffer erzeugen
				byte[] buffer = new byte[1024];
				
				// UDP-Paket erzeugen
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				
				// UDP-Pakete in einer Schleife empfangen
				while (true) {
					// UDP-Paket empfangen
					socket.receive(packet);
					
					// Nachrichtentext auslesen 
					String data = new String(packet.getData(), packet.getOffset(), packet.getLength());
					
					// Nachrichtentext in der GUI anzeigen
					Platform.runLater(() -> {
						Label label = new Label(data);
						label.setPadding(new Insets(10));
						label.setStyle("-fx-background-color: lightblue; -fx-background-radius: 10;");
						label.setWrapText(true);
						
						HBox box = new HBox();
						box.getChildren().add(label);
						
						vertical.getChildren().add(box);
					});
				}
			} catch (IOException e) {
				// ignore
			}
		});
		thread.start();
		
	}

}
