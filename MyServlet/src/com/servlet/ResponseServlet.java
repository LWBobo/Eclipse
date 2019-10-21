package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseServlet
 */
@WebServlet("/resp")
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//设置相应状态
		//resp.sendError(405, "sgfd dftghfthrft  rth rty ");
		//设置相应编码格式
		//resp.setHeader("content-type", "text/html;charset=utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		resp.getWriter().write("<b>this is my first test</b>");
		resp.getWriter().write("<b>今天天气真好!</b>");
		
		
	}

}
