package de.asw.courses.web2016.demo.backend.jaxrs;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * <pre>
 * {@code curl -v http://localhost:8080/asw2016-demo-webapp/resources/lifecycle}
 * </pre>
 * 
 * @author tom
 */
@Path("/lifecycle")
public class LifecycleExampleResource {

	public LifecycleExampleResource() {
		System.out.println("new LifecycleExampleResource()");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("postConstruct");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("preDestory");
	}

	@GET
	public String getTime() {
		System.out.println("getTime");
		return LocalDateTime.now().toString();
	}
}
