package de.asw.java.training2016.net;

import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UrlConnectionHttpPostRequestExample {

	public static void main(String[] args) throws Exception {

		HttpURLConnection urlConnection = (HttpURLConnection) new URL("https://httpbin.org/post").openConnection();
		urlConnection.setRequestProperty("Content-Type", "application/json");
		urlConnection.setDoOutput(true);
		urlConnection.setRequestMethod("POST");

		PrintStream requestBody = new PrintStream(urlConnection.getOutputStream());
		requestBody.print("{\"foo\":\"bar\"}");

		try (Scanner scanner = new Scanner(urlConnection.getInputStream())) {
			printResponseHeaders(urlConnection);
			printResponseBody(scanner);
		}

		urlConnection.disconnect();
	}

	private static void printResponseHeaders(URLConnection urlConnection) {
		for (Map.Entry<String, List<String>> header : urlConnection.getHeaderFields().entrySet()) {
			if (header.getKey() == null) {
				System.out.println(header.getValue().get(0));
				continue;
			}
			System.out.printf("%s: %s%n", header.getKey(), header.getValue());
		}
	}

	private static void printResponseBody(Scanner scanner) {
		while (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
	}
}