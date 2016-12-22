package de.asw.courses.web2016.student.playground.servlets;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.jboss.logging.Logger;

@WebListener
public class ServletContextListenerExample implements ServletContextListener {

	Logger log = Logger.getLogger(ServletContextListenerExample.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		log.info("Context Initalized: " + sce.getServletContext().getContextPath());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		log.info("Context Destroyed: " + sce.getServletContext().getContextPath());
	}
}
