package de.asw.courses.web2016.demo.backend.servlet.forms;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {

	/**
	 * Called via HTTP GET with parameters passed in via URL.
	 * 
	 * @see http://localhost:8080/asw2016-demo-webapp/calculate?n1=10&n2=30&op=add
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) //
			throws ServletException, IOException {
		doPost(req, resp);
	}

	/**
	 * Called via HTTP POST with parameters passed in in the Request Body.
	 * 
	 * @see http://localhost:8080/asw2016-demo-webapp/calc.html
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) //
			throws ServletException, IOException {

		Integer n1 = Integer.valueOf(req.getParameter("n1"));
		Integer n2 = Integer.valueOf(req.getParameter("n2"));
		String op = req.getParameter("op");

		Integer result;

		switch (op) {
		case "add":
			result = n1 + n2;
			break;
		case "subtract":
			result = n1 - n2;
			break;
		default:
			result = null;
		}

		resp.getWriter().printf("%s(%s,%s) = %s", op, n1, n2, result);
	}
}
