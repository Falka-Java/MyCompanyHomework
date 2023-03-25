<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="models.Department"%>
<%@ page import="services.DepsService"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<%@ include file="../layouts/head.jsp" %>

	<style>
	/*Local stylesheet */
	
	#deps-table{
		width:60%;
		margin: 20px auto;
		margin-top: 30px;
	}
	#deps-table th,
	#deps-table td{
		padding: 5px;
		border: 1px solid silver;
	}
	#deps-table th{
		background-color: whitesmoke;
	}
	</style>

</head>
<body>
	<header>
		<%@ include file="../layouts/nav.jsp" %>
	</header>
	
	<main class="container">
		<div class="bg-light p-5 rounded text-center main-box">
			<div class="title-box">
				<h1>MyCompany</h1>
				<h3>MyCompany official site</h3>
			</div>
			<div class="content-box">
				<!-- Content placeholder -->
				<h2>Departments</h2>
				<p>
					<a href="Departments?page=create">Create a new department</a>
				</p>
				
				<%
				DepsService service = (DepsService)request.getAttribute("service");
				List<Department> deps = service.getAllDeps();
				%>
				
				<table id="deps-table">
					<thead>
						<tr>
						<th>ID</th>
						<th>Department name</th>
						<th>Data control</th>
						</tr>
					</thead>
					
					<tbody>
					
					<%for (Department dep :deps){ %>
					<tr>
						<td class="cell1"><%=dep.getId()%></td>
						<td class="cell2"><%=dep.getName()%></td>
						<td class="cell3">
							<a href="" class="btn btn-sm btn-primary">Details</a>
							<a href="" class="btn btn-sm btn-success">Edit</a>
							<a href="" class="btn btn-sm btn-danger">Delete</a>
						</td>
					</tr>
					<%} %>
					
					</tbody>
				</table>
				
				<!-- /Content placeholder -->
			</div>
		</div>
	</main>
	
	<footer class="container text-center">
		<%@ include file="../layouts/footer.jsp" %>
	</footer>
	
	
	<!-- Scripts -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>