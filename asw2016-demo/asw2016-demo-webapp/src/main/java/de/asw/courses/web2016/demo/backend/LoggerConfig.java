package de.asw.courses.web2016.demo.backend;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.jboss.logging.Logger;

public class LoggerConfig {

	@Produces
	Logger createLogger(InjectionPoint injectionPoint){
		return Logger.getLogger(injectionPoint.getBean().getBeanClass().getName()); 
	}
}
