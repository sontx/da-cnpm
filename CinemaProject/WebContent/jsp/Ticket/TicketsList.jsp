<%@page import="java.util.ArrayList"%>
<%@page import="com.dutproject.cinemaproject.model.bean.Ticket"%>
<%@page import="java.util.List"%>
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
<title>Tickets</title>
</head>
<center>
	<h1>List tickets</h1>
</center>

<body>
	<jsp:include page="/jsp/navbar.jsp"></jsp:include>

	<%
		List<Ticket> tickets = (List<Ticket>) request.getAttribute("tickets");
		if (tickets.size() > 0) {
	%>
	<div class="container">
		<center>
			<table class="table table-striped" border="1">
				<tr>
					<td>Ticket ID</td>
					<td>Schedule ID</td>
					<td>Chair ID</td>
					<td>Price</td>
					<td>State</td>
				</tr>
				<%
					for (Ticket ticket : tickets) {
				%>
				<tr>
					<td><%=ticket.getTicketId()%></td>
					<td><%=ticket.getScheduleId()%></td>
					<td><%=ticket.getChairId()%></td>
					<td><%=ticket.getPrice()%></td>
					<td><a
						href="TicketUpdateServlet?id=<%=ticket.getTicketId()%>&state=<%=ticket.getState()%>&scheduleId=<%=ticket.getScheduleId()%>"
						class="btn btn-info" role="button"><%=ticket.getState()%></a></td>

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