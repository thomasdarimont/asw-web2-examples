package de.asw.courses.web2016.student.playground.jaxrs;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/validationExample")
public class ValidationExampleResource {

	@Inject
	UserService userService;

	/**
	 * 
	 * <p>
	 * Example Payload bad
	 * </p>
	 * 
	 * <pre>
	 *      {
	 *      "username":"tester",
	 *      "password": "test1234",
	 *      "age": 17
	 *      }
	 * </pre>
	 * <p>
	 * Example Payload good
	 * </p>
	 * 
	 * <pre>
	 *      {
	 *      "username":"tester",
	 *      "password": "test1234",
	 *      "age": 18
	 *      }
	 * </pre>
	 * 
	 * @see http://localhost:8080/asw2016-demo-webapp-student/resources/validationExample/user
	 * @return
	 */
	@POST
	@Path("/user")
	@Produces(MediaType.APPLICATION_JSON)
	public User validate(@Valid User user) {
		return userService.process(user);
	}

}
