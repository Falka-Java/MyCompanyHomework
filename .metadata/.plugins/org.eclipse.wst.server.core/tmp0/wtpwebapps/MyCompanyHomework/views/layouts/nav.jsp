<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">MyComp	any</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Home?page=about">About</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="News?page=list">News</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Products?page=catalog">Products</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="Home?page=contacts">Contacts</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Home?page=feedback">Feedback</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Admin
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="Departments?page=admin">Departments</a>
          <a class="dropdown-item" href="Employes?page=admin">Employees</a>
          <a class="dropdown-item" href="Users?page=admin">Users</a>
        </div>
      </li>
    </ul>
    
    <%
   	String user = (String)request.getSession().getAttribute("user");
    if(user==null){
    	Cookie[] cookies = request.getCookies();
    	if(cookies != null){
    		for(Cookie cookie : cookies){
    			if(cookie.getName().equals("user")){
    				user = cookie.getValue();
    				break;
    			}
    		}
    	}
    }
    pageContext.setAttribute("user", user);
    
    %>
    
    <ul class="navbar-nav ml-auto">
    	<li class="nav-item">
    		<a class="nav-link" href="#" style="margin-right: 75px">
    			Hello, 
    			
    			<c:if test="${user != null}">
    				<span style="color:lime">
    					<c:out value="${user}"/>!
    				</span>
    			</c:if>
    			
    			<c:if test="${user == null}">
    				<span style="color:bisque">
    					Guest!
    				</span>
    			</c:if>
    		</a>
    	</li>
    	<c:if test="${user==null}">
    	<li class="nav-item">
    		<a class="nav-link" href="Auth?page=signin">
    			Login
    		</a>
    	</li>
    	<li class="nav-item">
    		<a class="nav-link" href="Auth?page=singup">
    			Registration
    		</a>
    	</li>
    	</c:if>
    	
  	    	<c:if test="${user!=null}">
  	    	
  	    	<li class="nav-item">
    		<a class="nav-link" href="Auth?page=profile">
    			Profile
    		</a>
    	</li>
    	<li class="nav-item">
    		<a class="nav-link" href="Auth?page=signout">
    			Logout
    		</a>
    	</li>
    	</c:if>
    </ul>
    
  </div>
</nav>