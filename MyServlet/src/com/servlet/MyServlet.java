package com.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

<<<<<<< HEAD
/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/first")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MyServlet() {
        // TODO Auto-generated constructor stub
    }

=======
public class MyServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.getWriter().write("this is my first servlet.");
		System.out.println("this is my first servlet..");
	
	
	}
>>>>>>> 9549d5cdfc4cbc4452a316b10b3cb7e610c397ed
}
