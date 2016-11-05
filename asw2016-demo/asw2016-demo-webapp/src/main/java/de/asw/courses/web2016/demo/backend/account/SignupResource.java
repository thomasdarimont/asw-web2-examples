package de.asw.courses.web2016.demo.backend.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;

@Path("/signup")
public class SignupResource {

	@Context HttpServletRequest request;
	
	@Context HttpServletResponse response;
	
	@POST
	@Consumes("application/x-www-form-urlencoded")
	public void register(MultivaluedMap<String, String> formData) throws Exception {

		System.out.println("Register... " + formData);

		request.setAttribute("user", formData.getFirst("email"));
		request.getRequestDispatcher("/WEB-INF/pages/welcome.jsp").forward(request, response);
	}
}
