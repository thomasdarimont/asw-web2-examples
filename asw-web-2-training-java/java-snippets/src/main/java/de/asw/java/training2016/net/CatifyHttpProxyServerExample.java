package de.asw.java.training2016.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

/**
 * Simple HTTP Proxy Server example which replaces all requested images with
 * random cat images.
 * <p>
 * Just run this program and configure your browser (e.g. firefox) to use
 * 127.0.0.1:9999 as a proxy server.
 * 
 * Then browse to a site like http://www.spiegel.de/
 * </p>
 * 
 */
public class CatifyHttpProxyServerExample {

	public static void main(String[] args) throws Exception {

		CatifyProxyServer server = new CatifyProxyServer();
		server.setPort(9999);
		server.setThreads(64);
		server.start();
	}

	static class CatifyProxyServer {

		private static final Pattern HTTP_METHODS_PATTERN = Pattern.compile("(GET|PUT|POST|DELETE|PATCH|HEAD).*");
		private static final Pattern IMAGE_REQUEST_LINE_PATTERN = Pattern.compile("^GET .*\\.(png|jpg|gif) HTTP/1.1$");
		private static final Pattern HOST_REQUEST_HEADER_PATTERN = Pattern.compile("Host: .*");

		private static final StringBuilder EMPTY_REQUEST_BUFFER = new StringBuilder();

		private int port;
		private int threads;

		void start() {

			ExecutorService es = Executors.newFixedThreadPool(threads);

			try (ServerSocket ss = new ServerSocket(port)) {

				while (true) {
					Socket clientSocket = ss.accept();
					handleClientConnection(es, clientSocket);
				}
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		}

		private void handleClientConnection(ExecutorService es, Socket clientSocket) {

			es.submit(() -> {

				try (Scanner scanner = new Scanner(clientSocket.getInputStream())) {

					String requestLine = scanner.nextLine();

					if (!isSupportedHttpMethod(requestLine)) {
						clientSocket.close();
						return;
					}

					String hostHeader;
					StringBuilder remainingRequestBuffer;
					if (IMAGE_REQUEST_LINE_PATTERN.matcher(requestLine).matches()) {

						// http://lorempixel.com/320/240/cats/
						requestLine = "GET /320/240/dogs/ HTTP/1.1";
						hostHeader = "Host: lorempixel.com";
						remainingRequestBuffer = EMPTY_REQUEST_BUFFER;
					} else {
						remainingRequestBuffer = new StringBuilder();
						hostHeader = readRequestHeadersAndReturnHostHeader(scanner, remainingRequestBuffer);
					}

					pipeProxiedRequest(requestLine, hostHeader, remainingRequestBuffer, clientSocket.getOutputStream());

				} catch (IOException ignore) {
					ignore.printStackTrace();
				}
			});
		}

		private String readRequestHeadersAndReturnHostHeader(Scanner scanner, StringBuilder remainingRequestFragment) {

			String hostHeader = null;
			while (scanner.hasNextLine()) {
				String headerLine = scanner.nextLine();

				if (isHostHeader(headerLine)) {
					hostHeader = headerLine;
					continue;
				}

				remainingRequestFragment.append(headerLine).append("\n");

				if (headerLine.trim().isEmpty()) {
					break;
				}
			}

			return hostHeader;
		}

		private boolean isHostHeader(String headerLine) {
			return HOST_REQUEST_HEADER_PATTERN.matcher(headerLine).matches();
		}

		private boolean isSupportedHttpMethod(String requestLine) {
			return HTTP_METHODS_PATTERN.matcher(requestLine).matches();
		}

		private void pipeProxiedRequest(String requestLine, String hostHeaderValue, CharSequence requestFragment,
				OutputStream proxiedOutputStream) throws IOException {

			// Open TCP Socket Connection
			String hostname = hostHeaderValue.substring("Host: ".length());
			try (Socket socket = new Socket(hostname, 80)) {

				// Send HTTP Request
				new PrintStream(socket.getOutputStream()) //
						.printf("%s%n", requestLine) // HTTP Request Line
						.printf("%s%n", hostHeaderValue) // HTTP Host Header
						.printf("%s%n", requestFragment) //
						.println(); // empty line

				pipeInputStreamToOutputStream(socket.getInputStream(), proxiedOutputStream);
			} catch (IOException ignore) {
				// ex.printStackTrace();
			}

		}

		private void pipeInputStreamToOutputStream(InputStream inputStream, OutputStream proxiedOutputStream)
				throws IOException {
			byte[] buffer = new byte[32 * 1024];
			int bytesRead = -1;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				proxiedOutputStream.write(buffer, 0, bytesRead);
			}
			proxiedOutputStream.flush();
		}

		public int getPort() {
			return port;
		}

		public void setPort(int port) {
			this.port = port;
		}

		public int getThreads() {
			return threads;
		}

		public void setThreads(int threads) {
			this.threads = threads;
		}
	}
}
