package de.asw.courses.web2016.demo.backend.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <pre>
 * {@code http://localhost:8080/asw2016-demo-webapp/session }
 * </pre>
 * 
 * <pre>
 * {@code http://localhost:8080/asw2016-demo-webapp/session?name=test }
 * </pre>
 * 
 * <pre>
 * {@code http://localhost:8080/asw2016-demo-webapp/session?kill }
 * </pre>
 * 
 * Chrome -> Developer Tools -> Application -> Cookies
 * 
 * @author tom
 *
 */
@WebServlet("/session")
public class HttpSessionServletExample extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		if (req.getParameterMap().containsKey("kill")) {
			if (session != null) {
				session.invalidate();
			}
			resp.getWriter().printf("Session removed!");
			return;
		}

		String name = req.getParameter("name");

		if (name == null) {
			name = (String) session.getAttribute("name");
		} else {
			session.setAttribute("name", name);
		}

		resp.getWriter().printf("Hello %s%n", name);
	}
}
