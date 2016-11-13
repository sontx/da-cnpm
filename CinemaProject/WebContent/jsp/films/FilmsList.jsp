<%@page import="com.dutproject.cinemaproject.model.bean.Film"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Films</title>
</head>
<body>
	<%
		List<Film> films = (List<Film>) request.getAttribute("films");
		if (films != null && films.size() > 0) {
	%>
	<table border="1">
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Length</td>
			<td>Description</td>
			<td>Age Limited</td>
		</tr>
		<%
			for (Film film : films) {
		%>
		<tr>
			<td><%=film.getFilmId()%></td>
			<td><%=film.getFilmName()%></td>
			<td><%=film.getLength()%></td>
			<td><%=film.getDescription()%></td>
			<td><%=film.getAgeLimithed()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<%
		} else {
	%>
	can't not load films list.
	<%
		}
	%>
</body>
</html>