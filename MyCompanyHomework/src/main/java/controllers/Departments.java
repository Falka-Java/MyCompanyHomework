package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.DepsService;

import java.io.IOException;

/**
 * Servlet implementation class Departments
 */
public class Departments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private DepsService depsService;
    public Departments() {
        super();
        depsService = new DepsService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		switch(page) {
		case "admin":
			getAdminPage(request,response);
			break;
		}
	}
	private void getAdminPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "- Departments");
		request.setAttribute("service", depsService);
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/deps/admin.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
