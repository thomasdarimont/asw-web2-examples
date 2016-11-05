package de.asw.courses.web2016.demo.backend;

import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class LoggerConfig {

	@Produces
	Logger createLogger(InjectionPoint injectionPoint){
		return Logger.getLogger(injectionPoint.getBean().getBeanClass().getName()); 
	}
}
