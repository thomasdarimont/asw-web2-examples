package de.asw.courses.web2016.demo.backend.managedbeans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import de.asw.courses.web2016.demo.backend.di.BeanA;

@Named("SimpleBean")
public class SimpleManagedBean {

	@Inject
	BeanA beanA;
	
	@PostConstruct
	void initialize(){
		System.out.println("initialize " + this);
	}
	
	@PreDestroy
	void destroy(){
		System.out.println("destroy " + this);
	}
}
