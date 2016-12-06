package de.asw.courses.web2016.demo.backend.di;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/di")
public class DependencyInjectionExampleResource {

	@Inject
	BeanA beanA;

	@Inject
	RequestScopedBean requestScopedBean;

	@Inject
	SingletonScopedBean singletonScopedBean;

	public DependencyInjectionExampleResource() {
		System.out.println("new DependencyInjectionExampleResource()");
	}

	/**
	 * @see http://localhost:8080/asw2016-demo-webapp/resources/di
	 */
	@GET
	public String getData() {
		System.out.println("DependencyInjectionExampleResource.getData()");
		return beanA.getData();
	}

	/**
	 * @see http://localhost:8080/asw2016-demo-webapp/resources/di/scopes
	 */
	@GET
	@Path("/scopes")
	@Produces(MediaType.TEXT_HTML)
	public String getDataFromScopedBeans() {
		return "<b>requestScopedBean:</b> " + requestScopedBean.toString() + "<br> " + //
				"<b>singletonScopedBean:</b> " + singletonScopedBean.toString();
	}
}
