package src.com.logintest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logintest.pojo.User;
import com.logintest.service.LoginService;
import com.logintest.service.impl.LoginServiceImpl;

/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/ck")
public class CookieServlet extends HttpServlet {
	 @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 	req.setCharacterEncoding("utf-8");
		 	resp.setContentType("text/html;charset=utf-8"); 
		 	
		 	Cookie []cks = req.getCookies();
		 	if(null != cks) {
		 		String uid = "";
		 		for(Cookie c : cks) {
		 			if("uid".equals(c.getName())) {
		 				uid = c.getValue();
		 			}
		 		}
		 		if("".equals(uid)) {
		 			req.getRequestDispatcher("page").forward(req, resp); //请求转发
		 			return ;
		 		}else {
		 			LoginService ls = new LoginServiceImpl();
		 			User u = ls.checkUidService(uid);
		 			if(u != null) {
		 				resp.sendRedirect("main");
		 				return ;
		 			}else {
				 		req.getRequestDispatcher("page").forward(req, resp);
				 		return ;
		 			}
		 		}
		 		
		 	}else {
		 		req.getRequestDispatcher("page").forward(req, resp);
		 		return ;
		 	}
	 
	 
	 }

}
