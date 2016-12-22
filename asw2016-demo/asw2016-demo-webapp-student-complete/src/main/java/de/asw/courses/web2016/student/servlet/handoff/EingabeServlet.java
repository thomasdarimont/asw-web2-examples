package de.asw.courses.web2016.student.servlet.handoff;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/handoff/eingabe")
public class EingabeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.printf("Running in %s%n", getClass().getSimpleName());

		Integer a = Integer.valueOf(req.getParameter("a"));
		Integer b = Integer.valueOf(req.getParameter("b"));

		req.setAttribute("a", a);
		req.setAttribute("b", b);

		RequestDispatcher rd = req.getRequestDispatcher("/handoff/verarbeitung");
		rd.forward(req, resp);
	}
}
