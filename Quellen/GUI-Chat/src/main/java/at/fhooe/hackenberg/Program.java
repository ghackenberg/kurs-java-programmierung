package at.fhooe.hackenberg;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.channels.AsynchronousCloseException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
		
		TextInputDialog ownNameDialog = new TextInputDialog("Anonymous");
		ownNameDialog.setTitle("Dein Name");
		ownNameDialog.setHeaderText("Gib bitte deinen Namen zum Senden von Nachrichten ein.");
		ownNameDialog.setContentText("Name:");
		ownNameDialog.showAndWait();
		
		TextField ownNameField = new TextField(ownNameDialog.getResult());
		ownNameField.setDisable(true);
		
		// Portnummer abfragen
		
		TextInputDialog ownPortDialog = new TextInputDialog("4000");
		ownPortDialog.setTitle("Dein Port zum Empfangen");
		ownPortDialog.setHeaderText("Gib bitte deinen Port zum Empfangen von Nachrichten ein.");
		ownPortDialog.setContentText("Port:");
		ownPortDialog.showAndWait();
		
		Spinner<Integer> ownPortSpinner = new Spinner<Integer>(0, 65536, Integer.parseInt(ownPortDialog.getResult()));
		ownPortSpinner.setDisable(true);
		
		// IP-Adresse abfragen
		
		TextInputDialog otherHostDialog = new TextInputDialog("localhost");
		otherHostDialog.setTitle("Die IP-Adresse zum Senden");
		otherHostDialog.setHeaderText("Gib bitte die IP-Addresse zum Senden von Nachrichten ein.");
		otherHostDialog.setContentText("IP-Adresse:");
		otherHostDialog.showAndWait();
		
		TextField otherHostField = new TextField(otherHostDialog.getResult());
		otherHostField.setDisable(true);
		
		// Portnummer abfragen
		
		TextInputDialog otherPortDialog = new TextInputDialog("4000");
		otherPortDialog.setTitle("Der Port zum Senden");
		otherPortDialog.setHeaderText("Gib bitte den Port zum Senden von Nachrichten ein.");
		otherPortDialog.setContentText("Port:");
		otherPortDialog.showAndWait();
		
		Spinner<Integer> otherPortSpinner = new Spinner<Integer>(0, 65536, Integer.parseInt(otherPortDialog.getResult()));
		otherPortSpinner.setDisable(true);
		
		// GUI erstellen
		
		VBox receiveMessageList = new VBox();
		receiveMessageList.setSpacing(10);
		receiveMessageList.setPadding(new Insets(10));
		
		ScrollPane receiveScrollBar = new ScrollPane();
		receiveScrollBar.setFitToWidth(true);
		receiveScrollBar.setContent(receiveMessageList);
		// Auto-Scroll an das Listenende
		receiveScrollBar.vvalueProperty().bind(receiveMessageList.heightProperty());
		
		TextField sendMessageField = new TextField("Nachricht");
		
		Button sendButton = new Button("Senden");
		sendButton.setOnAction(event -> {
			try (DatagramSocket socket = new DatagramSocket()) {
				// Nachrichtentext erzeugen
				String data = ownNameField.getText() + ": " + sendMessageField.getText();
				
				// Nachrichtentext umwandeln
				byte[] buffer = data.getBytes();

				// UDP-Paket erzeugen
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(otherHostField.getText()), otherPortSpinner.getValue());

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
				
				receiveMessageList.getChildren().add(box);
				
				// Inhalt des Texteingabefeldes leeren
				sendMessageField.setText("");
				
				// Fokus zurück auf das Texteingabefeld setzen
				sendMessageField.requestFocus();
			} catch (IOException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Problem beim Senden");
				alert.setHeaderText("Es ist ein Problem beim Senden aufgetreten.");
				alert.setContentText(e.getLocalizedMessage());
				
				alert.showAndWait();
			}
		});
		
		GridPane receiveToolBar = new GridPane();
		receiveToolBar.setHgap(10);
		receiveToolBar.setPadding(new Insets(10));
		receiveToolBar.add(new Label("Port:"), 0, 0);
		receiveToolBar.add(ownPortSpinner, 1, 0);
		
		GridPane sendToolBar = new GridPane();
		sendToolBar.setHgap(10);
		sendToolBar.setPadding(new Insets(10, 10, 0, 10));
		sendToolBar.add(new Label("Name:"), 0, 0);
		sendToolBar.add(ownNameField, 1, 0);
		sendToolBar.add(new Label("Host:"), 2, 0);
		sendToolBar.add(otherHostField, 3, 0);
		sendToolBar.add(new Label("Port:"), 4, 0);
		sendToolBar.add(otherPortSpinner, 5, 0);
		
		BorderPane sendMessageBar = new BorderPane();
		sendMessageBar.setPadding(new Insets(10));
		sendMessageBar.setLeft(new Label("Nachricht:"));
		sendMessageBar.setCenter(sendMessageField);
		sendMessageBar.setRight(sendButton);
		BorderPane.setMargin(sendMessageField, new Insets(0, 10, 0, 10));
		
		VBox sendBar = new VBox();
		sendBar.getChildren().add(sendToolBar);
		sendBar.getChildren().add(sendMessageBar);
		
		BorderPane main = new BorderPane();
		main.setTop(receiveToolBar);
		main.setCenter(receiveScrollBar);
		main.setBottom(sendBar);
		
		Scene scene = new Scene(main, 640, 480);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("GUI-Chat");
		primaryStage.setOnCloseRequest(event -> {
			try {
				socket.close();
			} catch (Exception e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Problem beim Schließen");
				alert.setHeaderText("Es ist ein Problem beim Schließen des UDP-Socket aufgetreten.");
				alert.setContentText(e.getLocalizedMessage());
				
				alert.showAndWait();
			}
		});
		primaryStage.show();
		
		// Thread zum Empfangen von Nachrichten starten
		
		Thread thread = new Thread(() -> {
			try {
				// UDP-Socket erzeugen
				socket = new DatagramSocket(ownPortSpinner.getValue());
				
				// Datenbuffer erzeugen
				byte[] buffer = new byte[1024];
				
				// UDP-Paket erzeugen
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				
				// UDP-Pakete in einer Schleife empfangen
				while (true) {
					try {
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
							
							receiveMessageList.getChildren().add(box);
						});
					} catch (IOException e) {
						if (e instanceof SocketException && e.getCause() instanceof AsynchronousCloseException) {
							// Socket wurde geschlossen => Thread beenden
							return;
						} else {
							// Anderes Problem => Alert
							Platform.runLater(() -> {
								Alert alert = new Alert(AlertType.ERROR);
								alert.setTitle("Problem beim Empfangen");
								alert.setHeaderText("Es ist ein Problem beim Empfangen aufgetreten.");
								alert.setContentText(e.getLocalizedMessage());
								
								alert.showAndWait();
							});
						}
					}
				}
			} catch (SocketException e) {
				Platform.runLater(() -> {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Problem beim Empfangen");
					alert.setHeaderText("Es ist ein Problem beim Empfangen aufgetreten.");
					alert.setContentText(e.getLocalizedMessage());
					
					alert.showAndWait();
				});
			}
		});	
		thread.start();
		
	}

}
