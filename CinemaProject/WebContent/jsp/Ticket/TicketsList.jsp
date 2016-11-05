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
<center>
	<h1>List tickets</h1>
</center>

<body>
	<center>
		<h2><%=request.getAttribute("nameOfMovie")%></h2>
	</center>
	<%
		List<Ticket> tickets = (List<Ticket>) request.getAttribute("tickets");
		if (tickets.size() > 0) {
	%>
	<center>
		<table border="1">
			<tr>
				<td>Id</td>
				<td>Seat Number</td>
				<td>State</td>
				<td>Date Time</td>
			</tr>
			<%
				for (Ticket ticket : tickets) {
			%>
			<tr>
				<td><%=ticket.getId()%></td>
				<td><%=ticket.getSeatNumber()%></td>
				<td><a
					href="TicketUpdateServlet?id=<%=ticket.getId()%>&state=<%=ticket.getState()%>"><%=ticket.getState()%></a></td>
				<td><%=ticket.getDateTime()%></td>

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