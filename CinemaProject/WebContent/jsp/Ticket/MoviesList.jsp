<%@page import="com.dutproject.cinemaproject.model.bean.Movie"%>
<%@page import="java.util.List"%>
<%@page import="com.dutproject.cinemaproject.model.bean.Ticket"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	<center>
		<table border="1">
			<tr>
				<td>Id</td>
				<td>Name of movie</td>
				<td>Schedule</td>
				<td>List of tickets</td>
			</tr>
			<%
				for (Movie movie : movies) {
			%>
			<tr>
				<td><%=movie.getId()%></td>
				<td><%=movie.getNameOfMovie()%></td>
				<td><%=movie.getSchedule()%></td>
				<td><a href="#">view</a></td>
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
</body>
</html>