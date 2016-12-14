package de.asw.courses.web2016.demo.backend.http;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * <pre>
 * {@code curl default Accept: *\/*}
 * </pre>
 * 
 * <pre>
 * {@code curl -v http://localhost:8080/asw2016-demo-webapp/resources/content-negotiation }
 * </pre>
 *
 * Browser? Try with chrome...
 * 
 * @see http://localhost:8080/asw2016-demo-webapp/resources/content-negotiation
 * 
 * @author tom
 */
@Path("/content-negotiation")
public class ContentNegotiationExampleResource {

	/**
	 * <pre>
	 * {@code curl -v -H "Accept: application/xml" http://localhost:8080/asw2016-demo-webapp/resources/content-negotiation }
	 * </pre>
	 * 
	 * @return
	 */
	@GET
	@Produces("application/xml")
	public String getXml() {
		return "<xml/>";
	}

	/**
	 * <pre>
	 * {@code curl -v -H "Accept: application/json" http://localhost:8080/asw2016-demo-webapp/resources/content-negotiation }
	 * </pre>
	 * 
	 * @return
	 */
	@GET
	@Produces("application/json")
	public String getJson() {
		return "{\"json\":\"true\"}";
	}

	/**
	 * <pre>
	 * {@code curl -v -H "Content-Type: application/xml" -d "<data/>"  http://localhost:8080/asw2016-demo-webapp/resources/content-negotiation }
	 * </pre>
	 * 
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_HTML)
	public String consumeXml(String xml) {
		return "<pre>" + xml + "</pre>";
	}
}
