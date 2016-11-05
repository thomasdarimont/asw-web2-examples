package de.asw.courses.web2016.demo.backend.greeting;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/greetingServlet")
public class GreetingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * <pre>
	 * {@code curl http://localhost:8080/asw2016-demo-webapp/greetingServlet\?name=Test }
	 * </pre>
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		if (name == null) {
			name = "World";
		}

		resp.getOutputStream().println("Hello " + name + " (HttpServlet) " + LocalDateTime.now());
	}
}
