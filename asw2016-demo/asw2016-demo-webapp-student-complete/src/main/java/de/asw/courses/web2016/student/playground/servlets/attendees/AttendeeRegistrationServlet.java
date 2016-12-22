package de.asw.courses.web2016.student.playground.servlets.attendees;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registration")
public class AttendeeRegistrationServlet extends HttpServlet {

	private final Set<Attendee> attendees = Collections.synchronizedSet(new LinkedHashSet<>());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		printAttendeeListing(response.getWriter());
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");

		String name = request.getParameter("name");
		String email = request.getParameter("email");

		Attendee inputAttendee = new Attendee(name, email);
		boolean wasNew = attendees.add(inputAttendee);

		String status = wasNew ? " hinzugef&uuml;t" : "aktualisiert";

		PrintWriter out = response.getWriter();

		out.println(String.format("<h2>Teilnehmer %s %s</h2>", inputAttendee, status));
		
		printAttendeeListing(out);
	}

	private void printAttendeeListing(PrintWriter out) {
		out.println("<p>Neuen Teilnehmer <a href=\"registration.html\">registerien</a>?</p>");
		out.println(String.format("<h2>Anzahl Teilnehmer %s</h2>", attendees.size()));
		out.println("<h2>Liste der Teilnehmer</h2>");
		out.println("<ol>");
		for (Attendee attendee : attendees) {
			out.println(String.format("<li>Eintrag %s</li>", attendee));
		}
		out.println("</ol>");
	}
}
