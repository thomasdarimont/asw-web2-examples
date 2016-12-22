package de.asw.courses.web2016.student.playground.servlets;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class CustomHttpSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("Session erzeugt: " + se.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("Session zerstört: " + se.getSession().getId());
	}
}
