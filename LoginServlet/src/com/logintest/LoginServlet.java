package com.logintest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.logintest.pojo.User;
import com.logintest.service.LoginService;
import com.logintest.service.impl.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//设置相应的编码格式
			resp.setContentType("text/html;charset=utf-8");
			/** post方式设置编码格式*/
			req.setCharacterEncoding("utf-8");
			//获取请求信息
			String uname = req.getParameter("uname");
		//	uname = new String(uname.getBytes("iso8859-1"),"utf-8");
			String pwd = req.getParameter("pwd");
			System.out.println(uname +":" + pwd);
			
			LoginService ls = new LoginServiceImpl();
			User u = ls.checkLoginService(uname, pwd); 
			if(null != u) {
				Cookie c = new Cookie("uid", u.getUid()+""); 
				c.setMaxAge(3600*24*3);
				c.setPath("/login/ck");
				resp.addCookie(c);
				HttpSession hs = req.getSession();
				hs.setAttribute("user", u);
				
				resp.sendRedirect("main");    //重定向
				return ;
			}else {
				req.setAttribute("str", "用户名或密码错误!");
				req.getRequestDispatcher("page").forward(req, resp);   //请求转发
				return ;
			}
			
			
		}
	
}
