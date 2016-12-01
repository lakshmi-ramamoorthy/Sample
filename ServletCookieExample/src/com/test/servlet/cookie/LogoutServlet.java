package com.test.servlet.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

@WebServlet("/logoutServlet")
public class LogoutServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
			resp.setContentType("text/html");
			System.out.println("Logout Servlet called !!!");
			Cookie loginCookie = null;
			
			Cookie[] cookies= req.getCookies();
			
			if(cookies != null){
				for (Cookie cookie : cookies) {
					
					if(cookie.getName().equals("username")){
						loginCookie =cookie;
						break;
					}
					
				}
			}
			
			resp.sendRedirect("login.html");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
