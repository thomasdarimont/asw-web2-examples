package de.asw.courses.web2016.demo.backend.weblistener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.jboss.logging.Logger;

@WebListener
public class WebListenerExample implements ServletContextListener {

	Logger log = Logger.getLogger(WebListenerExample.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		log.info("Context Initalized");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		log.info("Context Destroyed");
	}
}
