<%@page import="com.dutproject.cinemaproject.model.bean.Film"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>

<head>
    <title>Films</title>
    
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
    <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
</head>

<body>

    <jsp:include page="/jsp/navbar.jsp"></jsp:include>

	<%
		List<Film> films = (List<Film>) request.getAttribute("films");
		if (films != null && films.size() > 0) {
	%>
	<div class="container" style="padding-top: 2%">
	    <div class="panel panel-default">
			<table class="table">
				<tr>
					<td>ID</td>
					<td>Name</td>
					<td>Length</td>
					<td>Description</td>
					<td>Age Limited</td>
				</tr>
				<% for (Film film : films) { %>
				<tr>
					<td><%=film.getFilmId()%></td>
					<td><%=film.getFilmName()%></td>
					<td><%=film.getLength()%></td>
					<td><%=film.getDescription()%></td>
					<td><%=film.getAgeLimithed()%></td>
				</tr>
				<% } %>
			</table>
		</div>
	</div>
	<%
		} else {
	%>
	<div class="container" style="padding-top: 2%">
	   <p>Can't not load films list.</p>
	</div>
	<%
		}
	%>
</body>
</html>