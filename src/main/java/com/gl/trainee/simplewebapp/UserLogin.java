package com.gl.trainee.simplewebapp;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Map<String, String> map = new java.util.concurrent.ConcurrentHashMap<>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLogin() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String user = request.getParameter("user");
		String pass = request.getParameter("pass");

		if (request.getParameter("submit") != null) {
			if (map.containsKey(user) && map.get(user).equals(pass))
				response.sendRedirect("success.jsp");
			else {
				response.sendRedirect("submitfailure.jsp");
			}
		} else if (request.getParameter("register") != null) {
			if (map.containsKey(user) && map.get(user).equals(pass)) {
				response.sendRedirect("failure.jsp");
			} else {
				map.put(user, pass);
				response.sendRedirect("success.jsp");
			}
		}

		// PrintWriter writer = response.getWriter();
		// Enumeration<String> parameterNames = request.getParameterNames();
		// while (parameterNames.hasMoreElements()) {
		// String string = (String) parameterNames.nextElement();
		// writer.println(string + ": " + request.getParameter(string) +
		// "</br>");
		// }
		// writer.close();
	}
}
