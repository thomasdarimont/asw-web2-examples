package de.asw.courses.web2016.demo.backend.greeting;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/greeting")
public class GreetingResource {

	@Inject
	Logger log;

	/**
	 * <pre>
	 * {@code 
	 * curl -v http://localhost:8080/asw2016-demo-webapp/resources/greeting\?name=ASW
	 * }
	 * </pre>
	 * 
	 * @param name
	 * @return
	 */
	@GET
	public String greet(@QueryParam("name") String name) {

		if (name == null) {
			name = "World";
		}

		log.info("Greeting for " + name);

		return "Hello " + name + " (JAX-RS) " + LocalDateTime.now();
	}
}
