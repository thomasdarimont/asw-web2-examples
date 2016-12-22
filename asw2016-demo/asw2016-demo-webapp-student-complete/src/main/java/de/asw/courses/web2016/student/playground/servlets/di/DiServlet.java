package de.asw.courses.web2016.student.playground.servlets.di;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/diservlet")
public class DiServlet extends HttpServlet {

	@Inject
	BeanA beanA;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(beanA == null){
			resp.getWriter().println("You need to configure Dependency Injection!");
			return;
		}
		
		resp.getWriter().println("DiServlet " + beanA.getData());
	}
}
