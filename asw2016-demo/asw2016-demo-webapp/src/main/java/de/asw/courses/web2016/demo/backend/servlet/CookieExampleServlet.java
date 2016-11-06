package de.asw.courses.web2016.demo.backend.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @see http://localhost:8080/asw2016-demo-webapp/cookie
 * @see http://localhost:8080/asw2016-demo-webapp/cookie?name=test
 * @author tom
 *
 */
@WebServlet("/cookie")
public class CookieExampleServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		if (name != null) {
			resp.addCookie(new Cookie("name", name));
		} else {
			for (Cookie cookie : req.getCookies()) {
				if (cookie.getName().equals("name")) {
					name = cookie.getValue();
					break;
				}
			}
		}

		resp.getWriter().printf("Hello %s%n", name);
	}
}
