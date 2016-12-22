package de.asw.courses.web2016.student.playground.jsf;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import lombok.Data;

@Data
@Named
@SessionScoped
public class Person implements Serializable{

	String firstname;
	String lastname;

	public void printName() {
		System.out.println(firstname + " " + lastname);
	}
}
