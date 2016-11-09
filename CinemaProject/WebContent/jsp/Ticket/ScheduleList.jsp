<%@page import="com.dutproject.cinemaproject.model.bean.Movie"%>
<%@page import="java.util.List"%>
<%@page import="com.dutproject.cinemaproject.model.bean.Ticket"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Movies</title>
</head>
<center>
	<h1>Movies</h1>
</center>
<body>
	<%
		List<Movie> movies = (List<Movie>) request.getAttribute("movies");
		if (movies.size() > 0) {
	%>
	<div class="container">
		<center>
			<table class="table table-striped" border="1">
				<tr>
					<td>Schedule ID</td>
					<td>Name of movie</td>
					<td>Room ID</td>
					<td>Start Time</td>
					<td>End Time</td>
					<td>List of tickets</td>
				</tr>
				<%
					for (Movie movie : movies) {
				%>
				<tr>
					<td><%=movie.getScheduleId()%></td>
					<td><%=movie.getFilmName()%></td>
					<td><%=movie.getRoomId()%></td>
					<td><%=movie.getStartTime()%></td>
					<td><%=movie.getEndTime()%></td>
					<td><a href="TicketListServlet?id=<%=movie.getScheduleId()%>">view</a></td>
				</tr>
				<%
					}
				%>

			</table>
			<%
				} else {
			%>
			Nothing here
			<%
				}
			%>
		</center>
		<ul class="pager">
			<li><a href="#">Previous</a></li>
			<li><a href="#">Next</a></li>
		</ul>
	</div>

</body>
</html>