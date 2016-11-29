package de.asw.courses.web2016.demo.backend.account;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;

import org.jboss.logging.Logger;

@Path("/signup")
public class SignupResource {
	

	@Inject Logger log;

	@Context HttpServletRequest request;
	
	@Context HttpServletResponse response;
	
	@POST
	@Consumes("application/x-www-form-urlencoded")
	public void register(MultivaluedMap<String, String> formData) throws Exception {

		log.infof("Register... %s", formData);

		request.setAttribute("user", formData.getFirst("email"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/welcome.jsp");
		dispatcher.forward(request, response);
	}
}
