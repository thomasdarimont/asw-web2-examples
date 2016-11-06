package de.asw.courses.web2016.demo.backend.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.jboss.logging.Logger;

//@WebFilter(urlPatterns = { "/*" })
public class ServletFilterExample implements Filter {

	private static final Logger log = Logger.getLogger(ServletFilterExample.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("init filter");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		long startTime = System.currentTimeMillis();

		try {
			log.info("## before");
			chain.doFilter(request, response);
		} finally {
			log.infof("## after. Took %s ms", System.currentTimeMillis() - startTime);
		}
	}

	@Override
	public void destroy() {
		log.info("destroy filter");
	}

}
