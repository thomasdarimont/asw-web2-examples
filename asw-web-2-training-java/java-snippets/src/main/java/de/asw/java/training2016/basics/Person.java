package de.asw.java.training2016.basics;

public class Person {
	
	//field firstname
	String firstname; 
	
	String lastname;

	//Bean property Firstname (accessor / getter)
	public String getFirstname() {
		return firstname;
	}

	// Bean property Firstname (mutator / setter)
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

//	public Person() { //implizit immer da (wenn kein anderer Konstruktor da ist
//	}
	
	
}
