package de.asw.courses.web2016.demo.backend.servlet.forms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/processForm")
public class FormServlet extends HttpServlet {

	private List<User> users = new ArrayList<>();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");

		users.add(new User(firstname, lastname));
		req.setAttribute("users", users);

		RequestDispatcher rd = req.getRequestDispatcher("/form.jsp");
		rd.forward(req, resp);
	}

	public static class User {

		String firstname;
		String lastname;

		public User(String firstname, String lastname) {
			this.firstname = firstname;
			this.lastname = lastname;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getDisplayName() {
			return firstname + " " + lastname;
		}
	}
}
