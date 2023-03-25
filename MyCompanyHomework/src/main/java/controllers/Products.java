package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.ProductsService;

import java.io.IOException;

public class Products extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProductsService productsService;
    public Products() {
        super();
        productsService = new ProductsService();
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
		request.setAttribute("title", "- Products");
		request.setAttribute("service", productsService);
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/products/admin.jsp");
		dispatcher.forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
