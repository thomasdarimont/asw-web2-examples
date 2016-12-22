package de.asw.courses.web2016.student.playground.jaxrs;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class User {

	@NotNull
	String username;

	String password;

	@Min(18)
	int age;
	
	boolean processed;

	// getter / setter
}