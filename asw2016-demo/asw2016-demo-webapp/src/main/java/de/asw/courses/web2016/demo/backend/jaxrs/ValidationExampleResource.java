package de.asw.courses.web2016.demo.backend.jaxrs;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

@Path("/validationExample")
public class ValidationExampleResource {

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
	 * @see http://localhost:8080/asw2016-demo-webapp/resources/validationExample/user
	 * @return
	 */
	@POST
	@Path("/user")
	@Produces(MediaType.APPLICATION_JSON)
	public User validate(@Valid User user) {
		return user;
	}

	@XmlRootElement
	public static class User {

		@NotNull
		String username;

		String password;

		@Min(18)
		int age;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
	}
}
