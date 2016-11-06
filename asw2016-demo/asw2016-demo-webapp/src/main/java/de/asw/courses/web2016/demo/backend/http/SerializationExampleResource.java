package de.asw.courses.web2016.demo.backend.http;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;

import de.asw.courses.web2016.demo.backend.user.UserInfo;

@Path("/serial")
public class SerializationExampleResource {

	@Inject
	Logger log;

	/**
	 * <pre>
	 * {@code curl -v -H "Accept: application/xml" http://localhost:8080/asw2016-demo-webapp/resources/serial}
	 * </pre>
	 * 
	 * <pre>
	 * {@code curl -v -H "Accept: application/json" http://localhost:8080/asw2016-demo-webapp/resources/serial }
	 * </pre>
	 * 
	 * @return
	 */
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public UserInfo getUserInfoDefault() {

		log.info("getUserInfoDefault");

		UserInfo userInfo = new UserInfo("Theo", "Tester", "theo@example.org");
		
		return userInfo;
	}
}
