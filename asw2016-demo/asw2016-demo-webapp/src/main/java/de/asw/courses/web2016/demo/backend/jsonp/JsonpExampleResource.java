package de.asw.courses.web2016.demo.backend.jsonp;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * <pre>
 * {@code curl -v http://localhost:8080/asw2016-demo-webapp/resources/lifecycle}
 * </pre>
 */
@Path("/jsonp")
public class JsonpExampleResource {

	@GET
	@Path("/student")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject getExampleStudent() {

		JsonObject student = Json.createObjectBuilder() //
				.add("firstname", "Harry") //
				.add("lastname", "Potter") //
				.add("matriculationNo", "12432343") //
				.add("major", "Information Management") //
				.add("subjects",
						Json.createArrayBuilder() //
								.add(Json.createObjectBuilder().add("name", "Math 101")) //
								.add(Json.createObjectBuilder().add("name", "Intro to Web Applications")) //
				).build();

		System.out.println("Created json object");
		System.out.println(student);

		return student;
	}

	@GET
	@Path("/studentFromString")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject printJsonObjectString() throws Exception {

		StringReader reader = new StringReader( //
				"{\"firstname\":\"Harry\"" //
						+ ",\"lastname\":\"Potter\"" //
						+ ",\"matriculationNo\":\"12432343\"" //
						+ ",\"major\":\"Information Management\"" //
						+ ",\"subjects\":[{\"name\":\"Math 101\"}" //
						+ ",{\"name\":\"Intro to Web Applications\"}]}" //
		);

		JsonReader jsonReader = Json.createReader(reader);
		JsonObject student = jsonReader.readObject();

		return student;
	}
}
