package at.fhooe.hackenberg.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {
	
	// InputStream (d.h. System.in) in Reader umwandeln
	private static InputStreamReader reader = new InputStreamReader(System.in);
	
	// Reader in BufferedReader umwandeln
	private static BufferedReader buffered = new BufferedReader(reader);

	public static void main(String[] args) {
		
		try {
			
			double first = readDouble();
			double second = readDouble();
			
			String operation = readOperation();
			
			if (operation.equals("+")) {
				System.out.println(first + " + " + second + " = " + (first + second));
			}
			// TODO
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
	}
	
	private static double readDouble() throws IOException {
		while (true) {
			try {
				
				System.out.print("Bitte Zahl eingeben: ");
				
				return Double.parseDouble(buffered.readLine());
				
			} catch (NumberFormatException e) {
				
				System.out.println("Das ist keine Zahl!");
				
			}
		}
	}
	
	private static String readOperation() {
		return "+"; // TODO
	}

}
