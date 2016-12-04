package de.asw.courses.web2016.demo.backend.servlet.introspect;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/introspect/*")
public class HttpRequestIntrospectionServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String httpMethod = req.getMethod();
		String requestUri = req.getRequestURI();

		String queryString = req.getQueryString();

		PrintWriter out = resp.getWriter();

		out.println("Request");
		out.printf("%s %s?%s%n", httpMethod, requestUri, queryString);
		out.println();

		out.println("Headers");
		for (String headerName : Collections.list(req.getHeaderNames())) {
			String headerValue = req.getHeader(headerName);
			out.printf("%s %s%n", headerName, headerValue);
		}
		out.println();

		out.println("Parameters");
		for (String parameterName : Collections.list(req.getParameterNames())) { // req.getParameterMap()
			String parameterValue = Arrays.toString(req.getParameterValues(parameterName));
			out.printf("%s %s%n", parameterName, parameterValue);
		}
		out.println();

		out.println("Request Body");
		try (Scanner scanner = new Scanner(req.getReader())) {
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
		}
	}
}
