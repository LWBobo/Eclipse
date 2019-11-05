package com.login.servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class NumServlet
 */
@WebServlet("/num")
public class NumServlet extends HttpServlet {
	
	@Override
		public void init() throws ServletException {
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/info/nums.txt");
		System.out.println("读取位置:" + path);
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			int nums = 0;
			String s = br.readLine();
			if(null == s) {
				
			}else {	
				System.out.println("读取的信息:" + s);
				nums = Integer.parseInt(s);
			}
			this.getServletContext().setAttribute("nums", nums);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		}
	
	
	
	
	@Override
	public void destroy() {
		int num = (int) this.getServletContext().getAttribute("nums");
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/info/nums.txt");
		System.out.println("写入文件位置:" + path); 
		System.out.println("被写入信息:" + num);
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter(path);
			bw = new BufferedWriter(fw);
			bw.write(num + ""); 
			bw.flush();	
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {	
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
	}

}
