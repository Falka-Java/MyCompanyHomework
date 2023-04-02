package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import services.EmailService;
import services.UsersService;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.mail.MessagingException;

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
			doSignOut(request, response);
			break;
		case "profile":
			break;
		case "confirm":
			String email = request.getParameter("email");
			//getConfirmPage(request, response, email);
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
	
	
	private void getConfirmPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "- Confirm");
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/auth/confirm.jsp");
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

	protected void doSignOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user = (String)session.getAttribute("user");
		if(user!=null) {
			session.invalidate();
		}
		// ->
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("user")) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
					break;
				}
			}
		}
		
		getSinginPage(request, response);
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
			
			ServletContext context = getServletContext();
			String user = context.getInitParameter("user");
			String pass = context.getInitParameter("pass");
			String host = context.getInitParameter("host");
			String port = context.getInitParameter("port");
			
			String address = inputEmail;
			String topic = "MyCompany - confirm registration";
			String confirmUrl = "http://localhost:8080/MyCompanyHomework/Auth?page=confirm&email="+inputEmail;
			
			String html ="<h2>Registration on MyCompany website successfull!</h2>";
			html += "<hr/><h3>To activate your account use this link:<br/></h3>";
			html += String.format("<a href=\"%s\">Confirm registraion</a></h3>", confirmUrl);
			
			
			try {
				EmailService.sendEmail(host, port, user, pass, address, topic, html);
				
			}catch(MessagingException ex) {
				System.out.println("Messaging Exception - " + ex.getMessage());
				color = "red";
				message = "Error sending confirmation emails";
			}
		}else {
			color="red";
			message="Registration failed";
		}
		
		
		request.setAttribute("title", "- Registration result");
		request.setAttribute("color", color);
		request.setAttribute("message", message);
		request.setAttribute("email", inputEmail);
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/auth/singup_res.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void handleSingIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String inputLogin = request.getParameter("login");
		String inputPass = request.getParameter("pass");
		String remember = request.getParameter("remember");
		
		String hashedPassword = getMD5Hash(inputPass);
		boolean resultSuccess = usersService.loginUser(inputLogin, hashedPassword);
		String color="";
		String message="";
		if(resultSuccess) {
			color="green";
			message = "Authorization successfull!";
			HttpSession session = request.getSession();
			session.setAttribute("user", inputLogin);
			
			// Save constant status
			if(remember != null && remember.equals("yes")) {
				Cookie cookie = new Cookie("user", inputLogin);
				cookie.setMaxAge(3600* 24);
				response.addCookie(cookie);
			}
			
		}else {
			color="red";
			message="Authorization failed!";
		}
		
		request.setAttribute("title", "- Authorization result");
		request.setAttribute(color, "color");
		request.setAttribute("message", message);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/auth/singin_res.jsp");
		dispatcher.forward(request, response);
		
	}

	
}
