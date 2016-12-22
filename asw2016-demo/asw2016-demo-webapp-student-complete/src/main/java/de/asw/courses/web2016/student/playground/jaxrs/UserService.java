package de.asw.courses.web2016.student.playground.jaxrs;

public class UserService {

	public User process(User user){
		System.out.println("Got: " + user);
		user.setProcessed(true);
		return user;
	}
}
