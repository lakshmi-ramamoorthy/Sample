package com.test.servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String user = "Arul";
	private final String pwd = "1234";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		System.out.println("Request Entered" + request.getParameterNames());

		Enumeration<String> e = request.getParameterNames();

		while (e.hasMoreElements()) {
			System.out.println("Enumeration loop");
			String param = (String) e.nextElement();
			System.out.println(param);
		}
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println("User name ::" + userName);
		System.out.println("Password :: " + password);

		String cookieelogin = null;
		
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")&& cookie.getValue().equals(userName)) {
					cookieelogin = cookie.getValue();
					break;
				}
			}
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("JSESSIONID")) {
					System.out.println("JSESSION ID ::::::" + cookie.getValue());
					break;
				}
			}
		}

		if (cookieelogin != null) {
			response.sendRedirect("CookieeSuccess.jsp");
			return;
		}
		if (user.equals(userName) && pwd.equals(password)) {
			System.out.println("Condition Pass");
			Cookie cookie = new Cookie("username", userName);
			cookie.setMaxAge(60);

			response.addCookie(cookie);
			response.sendRedirect("LoginSuccess.jsp");

		} else {
			System.out.println("Condition Failed");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter writer = response.getWriter();
			writer.println("Error occurred in User name and Password is invalid");
			dispatcher.include(request, response);

		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("Get Method");
	}

}
