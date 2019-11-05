package com.login.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.pojo.User;
import com.login.service.LoginService;
import com.login.service.impl.LoginServiceImpl;

/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/ck")
public class CookieServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求编码格式
			req.setCharacterEncoding("utf-8");
		//设置响应编码格式
			resp.setContentType("text/html;charset=utf-8");
		//获取请求信息
			//获取Cookie信息
			Cookie[] cks=req.getCookies();
		//处理请求信息
			if(cks!=null){
				//遍历Cookie信息
					String uid="";
					for(Cookie c:cks){
						if("uid".equals(c.getName())){
							uid=c.getValue();
						}
					}
				//校验UID是否存在
					if("".equals(uid)){
						//请求转发
						req.getRequestDispatcher("page").forward(req, resp);
						return;
					}else{
						//校验UID用户信息
							//获取业务层对象
							LoginService ls=new LoginServiceImpl();
							User u=ls.checkUidService(uid);
							if(u!=null){
								//将用户数据存储到session对象中
								req.getSession().setAttribute("user",u);
								//网页计数器自增
									int nums=(int) this.getServletContext().getAttribute("nums");
									nums+=1;
									this.getServletContext().setAttribute("nums", nums);
								//重定向
								resp.sendRedirect("/login/main");
								return;
							}else{
								//请求转发
								req.getRequestDispatcher("page").forward(req, resp); 
								return;
							}
					}
				
			}else{
				//响应处理结果
					//请求转发
					req.getRequestDispatcher("page").forward(req, resp);
					return;
			}
	}

}
