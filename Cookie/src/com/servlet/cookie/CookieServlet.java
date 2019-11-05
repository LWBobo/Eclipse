package com.servlet.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/ck")
public class CookieServlet extends HttpServlet {
			@Override
			protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				req.setCharacterEncoding("utf-8");
				resp.setContentType("text/html;charset=utf-8");
				
				Cookie c =  new Cookie("mouse", "logie");
				Cookie c2 = new Cookie("key","cherry");
				c2.setMaxAge(3600*24*3);
				c2.setPath("/cookie/gc");
				
				
				
				resp.addCookie(c);
				resp.addCookie(c2);
				resp.getWriter().write("Cookie学习!");
				
				
				
				
				
				
				
			}
}
