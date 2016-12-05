package de.asw.courses.web2016.demo.backend.di;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/di")
public class DependencyInjectionExampleResource {

	@Inject BeanA beanA;
	
	public DependencyInjectionExampleResource() {
		System.out.println("new DependencyInjectionExampleResource()");
	}

	@GET
	public String getData(){
		System.out.println("DependencyInjectionExampleResource.getData()");
		return beanA.getData();
	}
}
