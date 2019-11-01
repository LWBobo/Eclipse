package com.logintest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.logintest.pojo.User;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/main")
public class MainServlet extends HttpServlet {
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
			
			HttpSession hs = req.getSession();
			User u = null;
			Object obj = hs.getAttribute("user");
			if(null != obj) {
				 u = (User) obj;
			
			resp.getWriter().write("<html>");
			resp.getWriter().write("<head>");
			resp.getWriter().write("</head>");
			resp.getWriter().write("<body>");
			resp.getWriter().write("<h3>欢迎"+u.getUname()+"访问尚学堂管理系统</h3>");
			resp.getWriter().write("<hr>");
			resp.getWriter().write("</body>");
			resp.getWriter().write("</html>");
			
			}
		}
}
