package de.asw.courses.web2016.demo.backend.di;

import javax.inject.Inject;

public class BeanA {
	
	private BeanB beanB;
	
	@Inject
	public BeanA(BeanB beanB) {
		System.out.println("new BeanA()");
		this.beanB = beanB;
	}

	public String getData() {
		return "A" + " " + beanB.getData();
	}
}
