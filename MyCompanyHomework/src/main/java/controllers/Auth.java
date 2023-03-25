package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.UsersService;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Servlet implementation class Auth
 */
public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UsersService usersService;
	
    public Auth() {
        super();
        usersService = new UsersService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		switch(page) {
		case "singup":
			getSingupPage(request,response);
			break;
		case "signin":
			getSinginPage(request,response);
			break;
		case "signout":
			break;
		case "profile":
			break;
		case "confirm":
			break;
		
		}
	}


	private void getSingupPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "- Registration");
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/auth/singup.jsp");
		dispatcher.forward(request, response);
	}
	
	private void getSinginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "- Authorization");
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/auth/singin.jsp");
		dispatcher.forward(request, response);
		}
	
	/*===============================================*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		String page = request.getParameter("page");
		switch(page) {
			case "singup":
				handleSingUp(request, response);
				break;
			case "singin":
				handleSingIn(request, response);
				break;
				
		}
	}

	private String getMD5Hash(String initString) {
		String hashedString = "";
		
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(StandardCharsets.UTF_8.encode(hashedString));
			hashedString = String.format("%032x", new BigInteger(1, md5.digest()));
		}catch(NoSuchAlgorithmException ex) {
			System.out.println(ex.getMessage());
		}
		
		return hashedString;
	}
	
	private void handleSingUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Registration handler
		
		String inputLogin = request.getParameter("login");
		String inputPass1 = request.getParameter("pass1");
		String inputPass2 = request.getParameter("pass2");
		String inputEmail = request.getParameter("email");
		
		String passwordHash = getMD5Hash(inputPass1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String regdate = formatter.format(now);
		
		boolean resultSuccess = usersService.addUser(inputLogin, passwordHash, inputEmail, regdate, 1, 1);
		
		
		String color ="";
		String message = "";
		if(resultSuccess) {
			color="green";
			message = "Registration successfull!";
		}else {
			color="red";
			message="Registration failed";
		}
		
		
		request.setAttribute("title", "- Registration result");
		request.setAttribute("color", color);
		request.setAttribute("message", message);
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/auth/singup_res.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void handleSingIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
		//Login handler
	}
