package de.asw.courses.web2016.demo.backend.servlet.asyncproc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/asyncproc/sync")
public class SyncServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String result = RequestProcessor.INSTANCE.process(request.getRequestURI());
		
		response.getWriter().println(result);
	}
}
