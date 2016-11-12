<%@page import="com.dutproject.cinemaproject.model.bean.Movie"%>
<%@page import="java.util.List"%>
<%@page import="com.dutproject.cinemaproject.model.bean.Ticket"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Movies</title>
    
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
    <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
</head>

<body>

    <jsp:include page="/jsp/navbar.jsp"></jsp:include>

    <div class="container text-center">
        <h1>Movies</h1>
    </div>
    
	<%
		List<Movie> movies = (List<Movie>) request.getAttribute("movies");
		if (movies.size() > 0) {
	%>
	<div class="container">
        <div class="panel panel-default">
			<table class="table">
				<tr>
					<th>Id</th>
					<th>Name of movie</th>
					<th>Schedule</th>
					<th>List of tickets</th>
				</tr>
				<% for (Movie movie : movies) { %>
				<tr>
					<td><%=movie.getId()%></td>
					<td><%=movie.getNameOfMovie()%></td>
					<td><%=movie.getSchedule()%></td>
					<td><a href="TicketListServlet?id=<%=movie.getId()%>">View</a></td>
				</tr>
				<% } %>
			</table>
		<% } else { %>
		Nothing here
		<% } %>
		</div>
	</div>
</body>
</html>