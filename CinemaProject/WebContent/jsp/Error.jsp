<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Cinema Management</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container">
		<div class="alert alert-danger">
			<strong>Success!</strong>
			<%=request.getAttribute("message")%>
			<%
				if (request.getAttribute("page") != null) {
			%>
			<div class="text-right">
				<a class="btn btn-info" href="<%=request.getAttribute("page")%>">OK</a>
			</div>
			<%
				}
			%>
		</div>

	</div>
</body>
</html>