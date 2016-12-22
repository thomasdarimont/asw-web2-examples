package de.asw.courses.web2016.student.playground.servlets;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msg = "Hello World! " + LocalDateTime.now();
		System.out.println(msg);
		response.getWriter().println(msg);
	}
}

/// **
// * <ol>
// * <li>Leiten Sie die Klasse {@link HelloWorldServlet} von der Klasse
// * {@link HttpServlet} ab.</li>
// * <li>Überschreiben Sie anschließend die Methode
// * {@link #doGet(HttpServletRequest, HttpServletResponse)}</li>
// * <li>Verwenden Sie das Response Writer Objekt der {@link
/// HttpServletResponse}
// * um mittels {@link PrintWriter#println()}
// * {@code "Hello World! " + LocalDateTime.now()} in der Response zu
/// senden.</li>
// * </ol>
// *
// * @author tom
// */
// public class HelloWorldServlet /* hier von Klasse erben */ {
//
// // Hier doGet implementieren
// }