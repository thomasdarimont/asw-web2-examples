package de.asw.courses.web2016.demo.backend.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/custom-status")
public class CustomResponseStatusResource {

	@GET
	@Path("/i-am-a-teapot")
	public Response getTeapot() {
		return Response.status(418).entity("Nerds...").build();
	}
	
	@GET
	@Path("/ok")
	public Response getOk() {
		return Response.ok("Response Body").build();
	}
}
