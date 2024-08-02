package chap09.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String entireUri = req.getRequestURI();
		String uri = entireUri.substring(req.getContextPath().length());
		String method = req.getMethod();
		
		String nextView = "";
		
		switch (method + ":" + uri) {
			case "GET:/include/":
				nextView = "/WEB-INF/views/include/index.jsp";
				break;
			case "GET:/include/jsp":
				nextView = "/WEB-INF/views/include/jsp_include/jsp_index.jsp";
				break;
			case "GET:/include/ex2":
				nextView = "/WEB-INF/views/include/jsp_include/ex2.jsp";
				break;
			case "GET:/include/file":
				nextView = "/WEB-INF/views/include/file_include/file_index.jsp";
				break;
		}
		
		System.out.println("nextView: " + nextView);
		
		req.getRequestDispatcher(nextView).forward(req, resp);
	}
}
