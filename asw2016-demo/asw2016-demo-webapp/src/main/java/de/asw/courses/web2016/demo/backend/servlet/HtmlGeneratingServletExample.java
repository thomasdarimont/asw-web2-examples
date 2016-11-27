package de.asw.courses.web2016.demo.backend.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/html")
public class HtmlGeneratingServletExample extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		String data = request.getParameter("data");
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>HTML Servlet Example</title>");
		out.println("</head>");
		out.println("<body>");
		out.printf("Current Time: %s<br/>%n", LocalDateTime.now());
		if(data != null){
			out.printf("Got data: %s<br/>%n", data);	
		}
		out.println("</body>");
		out.println("</html>");
	}
}
