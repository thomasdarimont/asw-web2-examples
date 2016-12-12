package de.asw.courses.web2016.demo.backend.jaxrs;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;


/**
 * Example for processing form parameters in a JAX-RS resource 
 * 
 * @see comment.jsp
 * @author tom
 */
@Path("/simpleComment")
public class SimpleCommentResource {

	@POST
	public String newComment(@FormParam("email") String email, @FormParam("message") String message) {
		System.out.printf("New Comment from: %s message: %s%n", email, message);
		return "Thank you!";
	}
}