package de.asw.courses.web2016.student.servlet.handoff;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/handoff/verarbeitung")
public class VerarbeitungsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.printf("Running in %s%n", getClass().getSimpleName());
		
		Integer a = (Integer)req.getAttribute("a");
		Integer b = (Integer)req.getAttribute("b");
		
		Integer sum = a+b;
		
		req.setAttribute("sum", sum);
		
		RequestDispatcher rd = req.getRequestDispatcher("/handoff/ausgabe");
		rd.forward(req, resp);
	}
}
