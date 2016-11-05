package de.asw.courses.web2016.demo.client;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class GreetingClient {

	public static void main(String[] args) {

		WebTarget webTarget = ClientBuilder.newClient().target("http://localhost:8080/asw2016-demo-webapp");

		String greetingJaxRs = "/resources/greeting";
		String greetingServlet = "/greetingServlet";

		String responseBody = webTarget.path( //
				// greetingJaxRs //
				greetingServlet //
		) //
				.queryParam("name", "ASW") //
				.request() //
				.get(String.class);

		System.out.println(responseBody);
	}

}
