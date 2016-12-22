package de.asw.courses.web2016.student.playground.servlets;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Instructions:
 * <ul>
 * <li>Copy the contents of this file into a new file called: GuessMyNumberGame.java in the same package.</li>
 * <li>Make the servlet react to the /guess-my-number URI pattern.</li>
 * <li>Fill in the missing code marked with ????, follow the hints in the comments!</li>
 * </ul>
 */
@WebServlet("/guess-my-number")
public class GuessMyNumberGameServlet extends HttpServlet {

    //called for HTTP GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Random random = new Random();
        int max;
        try {
            max = Integer.valueOf(request.getParameter("max")); // YOURCODE use the request parameter max
        } catch (NumberFormatException nfe) {
            max = 100;
        }

        HttpSession session = request.getSession(true /* new session */);

        //YOURCODE set the session attributes correctly
        session.setAttribute("draw", random.nextInt(max));
        session.setAttribute("trailCounter", new AtomicInteger(0));
        session.setAttribute("gameOver", false);

        //YOURCODE set the request hint attribute correctly
        request.setAttribute("hint", "Try to guess my number!");

        forwardToGameJsp(request, response);
    }

    //called for HTTP POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();//YOURCODE access the HTTP SESSION from the request

        //YOURCODE extract the "gameOver" attribute from the HTTP SESSION
        if (session.getAttribute("gameOver") == null) {
            request.setAttribute("hint", "You need to start a new game first!");
            forwardToGameJsp(request, response);
            return;
        }

        //YOURCODE extract the "gameOver" attribute from the HTTP SESSION
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
            hint = String.format("Congratulations! You found: %s. <br/> It took you %s trials", guess, trials);
            session.setAttribute("gameOver", true);
        } else if (guess < draw) {
            hint = String.format("Your number %s is too low...", guess);
        } else {
            hint = String.format("Your number %s is too high...", guess);
        }
        //YOURCODE set "hint" request attribute to hint
        request.setAttribute("hint", hint);
        forwardToGameJsp(request, response);
    }

    void forwardToGameJsp(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //YOURCODE get requestDispatcher for game.jsp from request and forward the request/response
        RequestDispatcher rd = request.getRequestDispatcher("/game.jsp");
        rd.forward(request, response);
    }
}