package example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Page3Servlet extends HttpServlet {

	@Override
	protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");
		final PrintWriter writer = resp.getWriter();
		writer.println("hello world");
	}
}
