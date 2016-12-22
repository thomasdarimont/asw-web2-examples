package de.asw.courses.web2016.student.playground.servlets;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = { "/*" })
public class ServletFilterExample implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init filter");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		long startTime = System.currentTimeMillis();
		try {
			System.out.println("## before");
			chain.doFilter(request, response);
		} finally {
			System.out.printf("## after. Took %s ms (%s) %n", System.currentTimeMillis() - startTime, LocalDateTime.now());
		}
	}

	public void destroy() {
		System.out.println("destroy filter");
	}
}
