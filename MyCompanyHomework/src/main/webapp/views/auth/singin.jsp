<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<%@ include file="../layouts/head.jsp" %>
<style>

#singinForm{
			border: px solid silver;
			border-radius: 15px;
			width: 450px;
			padding: 20px 40px;
			padding-bottom: 30px;
			margin: 20px auto;
			text-align: left;
		}
		label{
			padding-bottom: 0px;
			color: navy;
			margin-top: 5px;
		}
		.my-btn{
			margin-top: 25px;
			margin-bottom: 10px;
			width: 150px;
			border-radius: 5px;
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
				<h2>Authorization</h2>
				<form id="singinForm" action="Auth?page=singin" method="post">
				<div class="form-group">
					<label for="login">Login:</label>
					<input type="text" id="login" name="login" class="form-control" required>
				</div>
				
				<div class="form-group">
					<label for="pass">Password:</label>
					<input type="password" id="pass" name="pass" class="form-control" required>
				</div>
				
				<div class="form-group">
					<label for="remember">Remember me</label>
					<input type="checkbox" id="remember" name="remember" class="form-control" value="yes">
				</div>
				
				<div class="form-group text-center">
					<input type="submit" id="submit" value="Send" class="btn btn-success my-btn">
					<input type="reset" value="Clean" class="btn btn-danger my-btn">
				</div>
				
				
				</form>
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