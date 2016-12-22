package de.asw.courses.web2016.student.playground.servlets;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirect")
public class RedirectExampleServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String redirectUri = req.getParameter("redirect_uri");
		
		if(redirectUri == null){
			System.out.println("redirect_uri fehlt!");
			return;
		}
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Weiterleitung zu: " + redirectUri);
		resp.sendRedirect(redirectUri);
	}
}
