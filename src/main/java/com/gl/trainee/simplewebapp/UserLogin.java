package com.gl.trainee.simplewebapp;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
	
	private static final String CONF2 = "conf";
	private static final String PASS2 = "pass";
	private static final String USER2 = "user";

	private static final long serialVersionUID = 1L;

	private Map<String, String> map = new java.util.concurrent.ConcurrentHashMap<>();
	
	private static MessageDigest digester;
	
	static {
        try {
            digester = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
	
	public static String crypt(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("String to encript cannot be null or zero length");
        }

        digester.update(str.getBytes());
        byte[] hash = digester.digest();
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            if ((0xff & hash[i]) < 0x10) {
                hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
            }
            else {
                hexString.append(Integer.toHexString(0xFF & hash[i]));
            }
        }
        return hexString.toString();
    }

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

		String user = request.getParameter(USER2);
		String pass = request.getParameter(PASS2);
		String conf = request.getParameter(CONF2);

		if (request.getParameter("submit") != null) {
			if (map.containsKey(user) && map.get(user).equals(crypt(pass)))
				response.sendRedirect("success.jsp");
			else {
				response.sendRedirect("submitfailure.jsp");
			}
		} else if (request.getParameter("register") != null) {
			if (map.containsKey(user)) {
				response.sendRedirect("failure.jsp");
			} else if (!pass.equals(conf)) {
				response.sendRedirect("failure.jsp");
			} else {
				map.put(user, crypt(pass));
				response.sendRedirect("success.jsp");
			}
		}
	}
}
