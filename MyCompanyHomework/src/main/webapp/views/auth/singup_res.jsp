<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<%@ include file="../layouts/head.jsp" %>

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
				<h2>Registration result</h2>
				<hr>
				<h3 style="color: ${color}">
					${message}
				</h3>
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