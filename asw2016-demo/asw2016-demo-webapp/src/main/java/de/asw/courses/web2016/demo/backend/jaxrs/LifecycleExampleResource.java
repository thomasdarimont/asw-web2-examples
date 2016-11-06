package de.asw.courses.web2016.demo.backend.jaxrs;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.jboss.logging.Logger;

/**
 * <pre>
 * {@code curl -v http://localhost:8080/asw2016-demo-webapp/resources/lifecycle}
 * </pre>
 * 
 * @author tom
 */
@Path("/lifecycle")
public class LifecycleExampleResource {

	private static final Logger log = Logger.getLogger(LifecycleExampleResource.class);

	public LifecycleExampleResource() {
		log.info("new LifecycleExampleResource()");
	}

	@PostConstruct
	public void postConstruct() {
		log.info("postConstruct");
	}

	@PreDestroy
	public void preDestroy() {
		log.info("preDestory");
	}

	@GET
	public String getTime() {

		log.info("getTime");
		return LocalDateTime.now().toString();
	}
}
