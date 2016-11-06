package de.asw.courses.web2016.demo.backend.di;

import javax.inject.Inject;

public class BeanA {
	
	private BeanB beanB;
	
	@Inject
	public BeanA(BeanB beanB) {
		this.beanB = beanB;
		System.out.println("new BeanA()");
	}

	public BeanB getBeanB() {
		return beanB;
	}

	public void setBeanB(BeanB beanB) {
		this.beanB = beanB;
	}

	public String getData() {
		return this + " " + beanB.getData();
	}
}
