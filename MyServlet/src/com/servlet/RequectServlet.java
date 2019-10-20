package com.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequectServlet
 */
@WebServlet("/req")
public class RequectServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		System.out.println(method);
		
		StringBuffer url = req.getRequestURL();
		System.out.println(url.toString());
		
		String uri = req.getRequestURI();
		System.out.println(uri);
		
		String h = req.getScheme();
		System.out.println(h);
		
		
		Enumeration e = req.getHeaderNames();
		while(e.hasMoreElements()) {
			String head = (String)e.nextElement();
			String value = req.getHeader(head);
			
			System.out.println(head + " :" + value);
			
		}
		
		String name = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		System.out.println(name + " :" + pwd);
		
		
		String []favs = req.getParameterValues("fav");
		if(null != favs) {
			for(String s : favs) {
				System.out.println(s);
			}
		}
		
		Enumeration n =req.getParameterNames();
		while(n.hasMoreElements()) {
			System.out.println(n.nextElement());
		}
		
		
	}

}
