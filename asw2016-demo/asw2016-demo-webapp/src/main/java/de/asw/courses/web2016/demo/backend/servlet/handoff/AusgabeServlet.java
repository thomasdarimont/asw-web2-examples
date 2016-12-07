package de.asw.courses.web2016.demo.backend.servlet.handoff;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/handoff/ausgabe")
public class AusgabeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.printf("Running in %s%n", getClass().getSimpleName());
		
		Integer a = (Integer) req.getAttribute("a");
		Integer b = (Integer) req.getAttribute("b");
		Integer sum = (Integer) req.getAttribute("sum");

		//
		// %s Platzhalter für einen String
		// %n Platzhalter für newline
		resp.getWriter().printf("%s + %s = %s%n", a, b, sum);
	}
}
