package de.asw.courses.web2016.demo.backend.servlet.asyncproc;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/asyncproc/async", asyncSupported = true)
public class AsyncServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AsyncContext asyncContext = request.startAsync();
		asyncContext.start(new Runnable() {
			
			@Override
			public void run() {
				
				HttpServletRequest req = (HttpServletRequest) asyncContext.getRequest();
				String result = RequestProcessor.INSTANCE.process(req.getRequestURI());

				try {
					((HttpServletResponse) asyncContext.getResponse()).getWriter().println(result);
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
					asyncContext.complete();
				}
			}
		});
	}
}
