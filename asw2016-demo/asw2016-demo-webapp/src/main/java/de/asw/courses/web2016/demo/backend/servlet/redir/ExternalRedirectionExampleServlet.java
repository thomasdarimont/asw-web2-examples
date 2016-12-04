package de.asw.courses.web2016.demo.backend.servlet.redir;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * {@code http://localhost:8080/asw2016-demo-webapp/redirect?redirect_uri=http://www.google.de }
 * @author tom
 *
 */
@WebServlet("/redirect")
public class ExternalRedirectionExampleServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			String redirectUri = req.getParameter("redirect_uri");
			resp.sendRedirect(redirectUri); // sends a 302 Temporary Redirect
	}
}
