package de.asw.courses.web2016.student.playground.servlets;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/guess-my-number")
public class GuessMyNumberGameServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Random random = new Random();
		int max;
		try {
			max = Integer.valueOf(request.getParameter("max"));
		} catch (NumberFormatException nfe) {
			max = 100;
		}

		HttpSession session = request.getSession(true /* new session */);
		session.setAttribute("draw", random.nextInt(max));
		session.setAttribute("trailCounter", new AtomicInteger(0));
		session.setAttribute("gameOver", false);

		request.setAttribute("hint", "Try to guess my number!");

		forwardToGameJsp(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (session.getAttribute("gameOver") == null) {
			request.setAttribute("hint", "You need to start a new game first!");
			forwardToGameJsp(request, response);
			return;
		}

		boolean gameOver = Boolean.valueOf(String.valueOf(session.getAttribute("gameOver")));
		if (gameOver) {
			request.setAttribute("hint", "You already won! Start a new game :)");
			forwardToGameJsp(request, response);
			return;
		}

		int trials = ((AtomicInteger) session.getAttribute("trailCounter")).incrementAndGet();
		int guess = Integer.valueOf(request.getParameter("guess"));
		int draw = (Integer) session.getAttribute("draw");

		String hint;
		if (guess == draw) {
			hint = String.format("Congratulations! You found: %s. It took you %s trials", guess, trials);
			session.setAttribute("gameOver", true);
		} else if (guess < draw) {
			hint = String.format("Your number %s is too low...", guess);
		} else {
			hint = String.format("Your number %s is too high...", guess);
		}
		request.setAttribute("hint", hint);
		forwardToGameJsp(request, response);
	}

	void forwardToGameJsp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("game.jsp").forward(request, response);
	}
}