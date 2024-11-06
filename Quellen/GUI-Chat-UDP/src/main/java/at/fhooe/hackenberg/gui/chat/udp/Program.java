package at.fhooe.hackenberg.gui.chat.udp;

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
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Program extends Application {

	/**
	 * Hauptroutine.
	 */
	public static void main(String[] args) {
		
		// Starten der JavaFX-GUI
		Application.launch(args);
		
	}
	
	private final boolean DEBUG = false;

	private Spinner<Integer> receivePort;
	private DatagramSocket receiveSocket;
	private VBox receiveMessages;
	
	private TextField sendName;
	private TextField sendHost;
	private Spinner<Integer> sendPort;
	private TextField sendMessage;
	
	/**
	 * Senden einer Nachricht an den anderen Teilnehmer.
	 */
	private void send() {
		// UDP-Socket zum Senden erstellen und am Ende implizit wieder schließen
		try (DatagramSocket sendSocket = new DatagramSocket()) {
			
			// Prüfe den Nachrichteninhalt
			if (sendMessage.getText().trim().length() == 0) {
				throw new IOException("Bitte gib eine Nachricht ein.");
			}
			
			// Nachrichtentext erzeugen
			String data = sendName.getText() + ": " + sendMessage.getText();
			
			// Nachrichtentext umwandeln
			byte[] buffer = data.getBytes();

			// UDP-Paket erzeugen
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(sendHost.getText()), sendPort.getValue());

			// UDP-Paket senden				
			sendSocket.send(packet);
			
			// Nachrichtentext in der Nachrichtenliste anzeigen
			Label label = new Label(data);
			label.setPadding(new Insets(10));
			label.setStyle("-fx-background-color: lightgreen; -fx-background-radius: 10;");
			label.setWrapText(true);
			
			HBox box = new HBox();
			box.setAlignment(Pos.CENTER_RIGHT);
			box.getChildren().add(label);
			
			receiveMessages.getChildren().add(box);
			
			// Inhalt des Texteingabefeldes leeren
			sendMessage.setText("");
			
			// Fokus zurück auf das Texteingabefeld setzen
			sendMessage.requestFocus();
			
		} catch (IOException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Problem beim Senden");
			alert.setHeaderText("Es ist ein Problem beim Senden aufgetreten.");
			alert.setContentText(e.getLocalizedMessage());
			
			alert.showAndWait();
		}
	}
	
	/**
	 * Empfangen von Nachrichten vom anderen Teilnehmer.
	 */
	private void receive() {
		try {
			
			// UDP-Socket erzeugen
			receiveSocket = new DatagramSocket(receivePort.getValue());
			
			// Datenbuffer erzeugen
			byte[] buffer = new byte[1024];
			
			// UDP-Paket erzeugen
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			
			// UDP-Pakete in einer Schleife empfangen
			while (true) {
				try {
					
					// UDP-Paket empfangen
					receiveSocket.receive(packet);
					
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
						
						receiveMessages.getChildren().add(box);
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
	}

	/**
	 * Erstellung und Anzeige der GUI.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Nutzernamen abfragen
		
		TextInputDialog ownNameDialog = new TextInputDialog("Anonymous");
		ownNameDialog.setTitle("Dein Name");
		ownNameDialog.setHeaderText("Gib bitte deinen Namen zum Senden von Nachrichten ein.");
		ownNameDialog.setContentText("Name:");
		ownNameDialog.showAndWait();
		
		// Portnummer abfragen
		
		TextInputDialog ownPortDialog = new TextInputDialog("4000");
		ownPortDialog.setTitle("Dein Port zum Empfangen");
		ownPortDialog.setHeaderText("Gib bitte deinen Port zum Empfangen von Nachrichten ein.");
		ownPortDialog.setContentText("Port:");
		ownPortDialog.showAndWait();
		
		// IP-Adresse abfragen
		
		TextInputDialog otherHostDialog = new TextInputDialog("127.0.0.1");
		otherHostDialog.setTitle("Die IP-Adresse zum Senden");
		otherHostDialog.setHeaderText("Gib bitte die IP-Addresse zum Senden von Nachrichten ein.");
		otherHostDialog.setContentText("IP-Adresse:");
		otherHostDialog.showAndWait();
		
		// Portnummer abfragen
		
		TextInputDialog otherPortDialog = new TextInputDialog("4000");
		otherPortDialog.setTitle("Der Port zum Senden");
		otherPortDialog.setHeaderText("Gib bitte den Port zum Senden von Nachrichten ein.");
		otherPortDialog.setContentText("Port:");
		otherPortDialog.showAndWait();
		
		// Private GUI-Elemente erstellen
		
		receivePort = new Spinner<Integer>(0, 65536, Integer.parseInt(ownPortDialog.getResult()));
		receivePort.setDisable(true);
		receivePort.setPrefWidth(75);
		
		receiveMessages = new VBox();
		receiveMessages.getStyleClass().add("vbox");
		receiveMessages.setSpacing(10);
		receiveMessages.setPadding(new Insets(10));
		
		sendPort = new Spinner<Integer>(0, 65536, Integer.parseInt(otherPortDialog.getResult()));
		sendPort.setDisable(true);
		sendPort.setPrefWidth(75);
		
		sendHost = new TextField(otherHostDialog.getResult());
		sendHost.setDisable(true);
		sendHost.setPrefWidth(75);
		
		sendName = new TextField(ownNameDialog.getResult());
		sendName.setDisable(true);
		
		sendMessage = new TextField("Nachricht");
		sendMessage.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.ENTER) {
				send();
			}
		});
		
		// Lokale GUI-Element erstellen
		
		ImageView sendImage = new ImageView("send.png");
		sendImage.getStyleClass().add("image-view");
		sendImage.setFitWidth(16);
		sendImage.setFitHeight(16);
		
		ImageView receiveImage = new ImageView("receive.png");
		receiveImage.getStyleClass().add("image-view");
		receiveImage.setFitWidth(16);
		receiveImage.setFitHeight(16);
		
		Label sendLabel = new Label("Senden");
		sendLabel.setStyle("-fx-font-weight: bold;");
		
		Label receiveLabel = new Label("Empfangen");
		receiveLabel.setStyle("-fx-font-weight: bold;");
		
		ScrollPane receivePane = new ScrollPane();
		receivePane.setFitToWidth(true);
		receivePane.setContent(receiveMessages);
		// Auto-Scroll an das Listenende
		receivePane.vvalueProperty().bind(receiveMessages.heightProperty());
		
		Button sendButton = new Button("Senden");
		sendButton.setOnAction(event -> {
			send();
		});
		
		GridPane settingsBar = new GridPane();
		settingsBar.getStyleClass().add("grid-pane");
		settingsBar.setHgap(10);
		settingsBar.setVgap(10);
		settingsBar.setPadding(new Insets(10));
		settingsBar.add(receiveImage, 0, 0);
		settingsBar.add(receiveLabel, 1, 0);
		settingsBar.add(new Label("Port:"), 2, 0);
		settingsBar.add(receivePort, 3, 0);
		settingsBar.add(sendImage, 0, 1);
		settingsBar.add(sendLabel, 1, 1);
		settingsBar.add(new Label("Port:"), 2, 1);
		settingsBar.add(sendPort, 3, 1);
		settingsBar.add(new Label("Host:"), 4, 1);
		settingsBar.add(sendHost, 5, 1);
		settingsBar.add(new Label("Name:"), 6, 1);
		settingsBar.add(sendName, 7, 1);
		
		BorderPane sendPane = new BorderPane();
		sendPane.getStyleClass().add("border-pane");
		sendPane.setPadding(new Insets(10));
		sendPane.setCenter(sendMessage);
		sendPane.setRight(sendButton);
		BorderPane.setMargin(sendButton, new Insets(0, 0, 0, 10));
		
		BorderPane rootPane = new BorderPane();
		rootPane.getStyleClass().add("border-pane");
		rootPane.setTop(settingsBar);
		rootPane.setCenter(receivePane);
		rootPane.setBottom(sendPane);
		
		// Szene erstellen
		
		Scene scene = new Scene(rootPane, 640, 480);
		scene.getStylesheets().add("default.css");
		if (DEBUG) {
			scene.getStylesheets().add("debug.css");
		}
		
		// Stage befüllen
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("GUI-Chat");
		primaryStage.setOnCloseRequest(event -> {
			try {
				
				// UDP-Socket schließen (sonst terminiert Java-Programm nicht wirklich)
				receiveSocket.close();
				
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
		
		new Thread(this::receive).start();
		
	}

}