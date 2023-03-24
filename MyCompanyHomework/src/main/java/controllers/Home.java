package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Home() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		
	    	String page = request.getParameter("page");
	    	switch(page) {
			case "about":
				getAboutPage(request,response);
				break;
			case "contacts":
				getContactsPage(request,response);
				break;		
			case "feedback":
				getFeedbackPage(request,response);
				break;
			default:
				case "default":
					get404Page(request,response);
					
	    	}
    	}catch(Exception ex) {
    		get400Page(request, response);
    	}
    		
    }
	private void getAboutPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "- About");
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/home/about.jsp");
		dispatcher.forward(request, response);
	}
	
	private void getContactsPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "- Contacts");
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/home/contacts.jsp");
		dispatcher.forward(request, response);
	}
	
	private void getFeedbackPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "- Feedback");
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/home/feedback.jsp");
		dispatcher.forward(request, response);
	}
	
	private void get400Page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "- 400 Bad request");
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/systempages/400.jsp");
		dispatcher.forward(request, response);
	}
	
	private void get404Page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "- 404 Not founded");
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/systempages/404.jsp");
		dispatcher.forward(request, response);
	}


}
