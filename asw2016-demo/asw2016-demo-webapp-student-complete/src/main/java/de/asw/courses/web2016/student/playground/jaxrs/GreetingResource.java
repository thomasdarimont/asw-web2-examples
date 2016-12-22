package de.asw.courses.web2016.student.playground.jaxrs;

import java.time.LocalDateTime;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/greeting")
public class GreetingResource {

	/**
	 * <pre>
	 * {@code 
	 * curl -v http://localhost:8080/asw2016-demo-webapp-student/resources/greeting\?name=ASW
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

		System.out.printf("Greeting for %s%n", name);

		return "Hello " + name + " (JAX-RS) " + LocalDateTime.now();
	}
}
