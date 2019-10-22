package com.logintest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			//获取请求信息
			String uname = req.getParameter("uname");
			String pwd = req.getParameter("pwd");
			System.out.println(uname +":" + pwd);
			
			LoginService ls = new LoginServiceImpl();
			User u = ls.checkLoginService(uname, pwd);
			if(null != u) {
				resp.getWriter().write("login successuflly");
				resp.getWriter().write(uname +":" + pwd);
			}
			
			
		}
	
}
