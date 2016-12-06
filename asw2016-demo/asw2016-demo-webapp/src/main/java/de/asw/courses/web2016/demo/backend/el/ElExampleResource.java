package de.asw.courses.web2016.demo.backend.el;

import javax.el.ELContext;
import javax.el.ELManager;
import javax.el.ELProcessor;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/el")
public class ElExampleResource {

	@GET
	public String evaluatePath() {

		Person person = new Person("Luke", new Address("Tatooine Way", "133", "232423"));

		ELProcessor processor = new ELProcessor();

		ELContext context = processor.getELManager().getELContext();
		context.getVariableMapper().setVariable("person",
				ELManager.getExpressionFactory().createValueExpression(person, Person.class));
		
		Object address = processor.getValue("person.address.street", String.class);

		return address.toString();
	}

	public static class Person {
		String name;
		Address address;

		public Person(String name, Address address) {
			this.name = name;
			this.address = address;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

	public static class Address {
		String street;
		String houseNo;
		String zipCode;

		public Address(String street, String houseNo, String zipCode) {
			this.street = street;
			this.houseNo = houseNo;
			this.zipCode = zipCode;
		}

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getHouseNo() {
			return houseNo;
		}

		public void setHouseNo(String houseNo) {
			this.houseNo = houseNo;
		}

		public String getZipCode() {
			return zipCode;
		}

		public void setZipCode(String zipCode) {
			this.zipCode = zipCode;
		}
	}
}
