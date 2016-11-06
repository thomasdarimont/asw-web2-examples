package de.asw.courses.web2016.demo.backend.di;

import java.time.LocalDateTime;

public class BeanB {

	public BeanB() {
		System.out.println("new BeanB()");
	}

	public String getData() {
		return this + " " + LocalDateTime.now().toString();
	}

}
