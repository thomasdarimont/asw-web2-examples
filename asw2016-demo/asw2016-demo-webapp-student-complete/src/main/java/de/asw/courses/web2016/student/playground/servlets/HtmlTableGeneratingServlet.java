package de.asw.courses.web2016.student.playground.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dynamic-table")
public class HtmlTableGeneratingServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		int columns = getIntParameterWithFallback("cols", 2, request);
		int rows = getIntParameterWithFallback("rows", 3, request);

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML>");
		out.println("<html>");
		out.println("<head><title>Dynamische Tabelle</title></head>");
		out.println("<body>");
		out.println("<h2>Dynamische Tabelle</h2>");
		out.println("<p>Zur&uuml;ck zum <a href=\"index.html\">Index</a>");
		out.println(String.format("<h3>Dynamische Tabelle mit %s Spalten und %s Zeilen</h3>", columns, rows));
		out.println("<table>");
		out.println("<thead>");
		for (int i = 0; i < columns; i++) {
			out.println(String.format("<th>Spalte %s</th>", i));
		}
		out.println("</thead>");
		out.println("<tbody>");
		Random random = new Random();
		for (int row = 0; row < rows; row++) {
			out.println("<tr>");
			for (int column = 0; column < columns; column++) {
				out.println(String.format("<td>%s</td>", random.nextInt(1024)));
			}
			out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	private int getIntParameterWithFallback(String name, int fallbackValue, HttpServletRequest request) {
		try {
			return Integer.valueOf(request.getParameter(name));
		} catch (NumberFormatException ignored) {
			return fallbackValue;
		}
	}
}