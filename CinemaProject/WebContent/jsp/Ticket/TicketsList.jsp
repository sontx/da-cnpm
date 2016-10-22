<%@page import="java.util.ArrayList"%>
<%@page import="com.dutproject.cinemaproject.model.bean.Ticket"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tickets</title>
</head>
<body>
	<%
		List<Ticket> tickets = (List<Ticket>) request.getAttribute("tickets");
		if (tickets.size() > 0) {
	%>
	<a href="/ticket">Add ticket</a>
	<center>
		<table border="1">
			<tr>
				<td>Id</td>
				<td>Seat Number</td>
				<td>State</td>
				<td>Date Time</td>
				<td>Action</td>
			</tr>
			<%
				for (Ticket ticket : tickets) {
			%>
			<tr>
				<td><%=ticket.getId()%></td>
				<td><%=ticket.getSeatNumber()%></td>
				<td><%=ticket.getState()%></td>
				<td><%=ticket.getDateTime()%></td>

				<td><a href="/edit">edit</a> <a href="/delete">delete</a></td>

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