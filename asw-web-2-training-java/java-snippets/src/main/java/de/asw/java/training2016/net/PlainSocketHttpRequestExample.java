package de.asw.java.training2016.net;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class PlainSocketHttpRequestExample {

	public static void main(String[] args) throws Exception {
		// Open TCP Socket Connection
		try (Socket socket = new Socket("www.example.com", 80)) {

			// Send HTTP Request
			new PrintStream(socket.getOutputStream()) //
					.printf("GET /index.html HTTP/1.1%n") // HTTP Request Line
					.printf("Host: www.example.com%n") // HTTP Host Header to
														// select domain
					.println(); // empty line

			// Read HTTP Response (Status-Line + Header + Body)
			try (Scanner scanner = new Scanner(socket.getInputStream())) {
				while (scanner.hasNextLine()) {
					System.out.println(scanner.nextLine());
				}
			}
		}
	}
}
