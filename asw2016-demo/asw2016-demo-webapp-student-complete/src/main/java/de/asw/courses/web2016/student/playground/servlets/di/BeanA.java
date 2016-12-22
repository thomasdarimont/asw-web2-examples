package de.asw.courses.web2016.student.playground.servlets.di;

import javax.inject.Inject;

public class BeanA {

	private final BeanB beanB;

	@Inject
	public BeanA(BeanB beanB) {
		this.beanB = beanB;
	}

	public String getData() {
		return "A " + beanB.getData();
	}
}
