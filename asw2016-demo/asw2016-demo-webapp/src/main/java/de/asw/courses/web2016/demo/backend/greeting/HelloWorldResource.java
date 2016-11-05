package de.asw.courses.web2016.demo.backend.greeting;

import java.time.LocalDateTime;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/helloworld")
public class HelloWorldResource {

	/**
	 * <pre>
	 * {@code curl http://localhost:8080/asw2016-demo-webapp/resources/helloworld }
	 * </pre>
	 * 
	 * @return
	 */
	@GET
	public String getHelloWorld() {
		return "Hello World " + LocalDateTime.now();
	}
}
