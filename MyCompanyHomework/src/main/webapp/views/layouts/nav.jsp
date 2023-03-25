<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">MyCompany</a>
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
    
    <ul class="navbar-nav ml-auto">
    	<li class="nav-item">
    		<a class="nav-link" href="#" style="margin-right: 75px">
    			<span style="color:bisque">Hello, Guest!</span>
    		</a>
    	</li>
    	
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
    </ul>
    
  </div>
</nav>