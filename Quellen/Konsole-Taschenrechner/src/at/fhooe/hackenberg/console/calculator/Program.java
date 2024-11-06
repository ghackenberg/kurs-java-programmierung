package at.fhooe.hackenberg.console.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {
	
	// InputStream (d.h. System.in) in Reader umwandeln (=> Chars statt Bytes)
	private static InputStreamReader reader = new InputStreamReader(System.in);
	
	// Reader in BufferedReader umwandeln (=> Ganze Zeilen einlesen)
	private static BufferedReader buffered = new BufferedReader(reader);

	// Hauptfunktion, die bei Programmstart ausgeführt wird
	public static void main(String[] args) {
		
		try {
			
			// Erste Zahl einlesen
			double first = readDouble();
			// Zweite Zahl einlesen
			double second = readDouble();
			
			// Operation einlesen
			String operation = readOperation();
			
			// Berechnung durchführen und Ergebnis ausgeben
			if (operation.equals("+")) {
				System.out.println(first + " + " + second + " = " + (first + second));
			} else if (operation.equals("-")) {
				System.out.println(first + " - " + second + " = " + (first - second));
			} else if (operation.equals("*")) {
				System.out.println(first + " * " + second + " = " + (first * second));
			} else if (operation.equals("/")) {
				System.out.println(first + " / " + second + " = " + (first / second));
			}
			
		} catch (IOException e) {
			
			// IO-Fehler abfangen und ausgeben sowie Programm beenden
			e.printStackTrace();
			
		}
	}
	
	// Eine Zahl über die Standardeingabe einlesen
	private static double readDouble() throws IOException {
		
		while (true) {
			try {
				
				// Nutzer zu Eingabe einer Zahl auffordern
				System.out.print("Bitte Zahl eingeben: ");
				
				// Zeichenkette in Zahl umwandeln und Ergebnis zurückgeben
				return Double.parseDouble(buffered.readLine());
				
			} catch (NumberFormatException e) {
				
				// Fehleingaben abfangen und Fehlermeldung ausgeben
				System.out.println("Das ist keine Zahl!");
				
			}
		}
		
	}
	
	// Eine Operation (+, -, *, /) über die Standardeingabe einlesen
	private static String readOperation() throws IOException {
		
		while (true) {
			
			// Nutzer zu Eingabe einer Operation auffordern
			System.out.print("Bitte Operation eingeben: ");
			
			// Operation einlesen
			String operation = buffered.readLine();
			
			// Eingabe überprüfen
			if (operation.matches("\\+|\\-|\\*|\\/")) {
				
				// Korrekte Eingabe zurückgeben
				return operation;
				
			} else {
				
				// Fehlermeldung ausgeben (und Eingabe wiederholen)
				System.out.println("Das ist keine Operation!");
				
			}
		}
		
	}

}
