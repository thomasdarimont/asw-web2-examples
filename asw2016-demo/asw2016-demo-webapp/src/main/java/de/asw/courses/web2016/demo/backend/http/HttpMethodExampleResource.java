package de.asw.courses.web2016.demo.backend.http;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import org.jboss.logging.Logger;

import de.asw.courses.web2016.demo.backend.http.extensions.PATCH;

@Path("/http")
public class HttpMethodExampleResource {

	@Inject
	Logger log;

	/**
	 * <pre>
	 * {@code curl -v http://localhost:8080/asw2016-demo-webapp/resources/http }
	 * </pre>
	 * 
	 * @return
	 */
	@GET
	public String getMethod() {

		log.info("getMethod()");
		return "GET Executed";
	}

	/**
	 * <pre>
	 * {@code curl -v -d "post-body" http://localhost:8080/asw2016-demo-webapp/resources/http }
	 * </pre>
	 * 
	 * @param data
	 * @return
	 */
	@POST
	public String postMethod(String data) {

		log.infof("postMethod(%s)", data);
		return "POST Executed";
	}

	/**
	 * <pre>
	 * {@code curl -v -X PUT -d "post-body" http://localhost:8080/asw2016-demo-webapp/resources/http }
	 * </pre>
	 * 
	 * @param data
	 * @return
	 */
	@PUT
	public String putMethod(String data) {

		log.infof("putMethod(%s)", data);
		return "PUT Executed";
	}

	/**
	 * <pre>
	 * {@code curl -v -X DELETE http://localhost:8080/asw2016-demo-webapp/resources/http }
	 * </pre>
	 * 
	 * @return
	 */
	@DELETE
	public String deleteMethod() {

		System.out.println("HttpMethodExampleResource.deleteMethod()");
		return "DELETE Executed";
	}

	/**
	 * <pre>
	 * {@code curl -v -X PATCH -d "patch-data" http://localhost:8080/asw2016-demo-webapp/resources/http }
	 * </pre>
	 * 
	 * @param patch
	 * @return
	 */
	@PATCH // Custom Annotation since PATCH is not supported yet in JAX-RS 2
	public String patchMethod(String patch) {

		log.infof("patchMethod(%s)", patch);
		return "PATCH Executed";
	}
}
