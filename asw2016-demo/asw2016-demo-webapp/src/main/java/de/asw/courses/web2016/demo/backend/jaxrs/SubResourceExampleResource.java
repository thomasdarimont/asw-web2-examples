package de.asw.courses.web2016.demo.backend.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Path("/subResourceExample")
public class SubResourceExampleResource {

	@Context
	UriInfo uriInfo;
	
	@GET
	public String get(){
		return "GET /subResourceExample";
	}
	
	@GET
	@Path("/sub") // /example/sub
	public String getSubResource(){
		return "GET /subResourceExample/sub";
	}
	
	@GET
	@Path("/sub/sub") // /example/sub/sub
	public String getSubSubResource(){
		return "GET /subResourceExample/sub/sub";
	}
	
	@GET
	@Path("/pattern/{subResource:.*}") // /pattern/foo/bar/baz
	public String getWildcardPatternResource(){
		return "GET /pattern/* " + uriInfo.getRequestUri();
	}
}
