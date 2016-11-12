<%@page import="java.util.ArrayList"%>
<%@page import="com.dutproject.cinemaproject.model.bean.Ticket"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Tickets</title>
    
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
    <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
</head>

<body>

    <jsp:include page="/jsp/navbar.jsp"></jsp:include>

    <div class="container text-center">
        <h1>List tickets</h1>
    </div>
    
    <div class="container text-center">
		<h2>Film: <%=request.getAttribute("nameOfMovie")%></h2>
	</div>
	
	<!-- list tickets -->
	<%  List<Ticket> tickets = (List<Ticket>) request.getAttribute("tickets");
		if (tickets.size() > 0) { %>
	<div class="container">
	    <div class="panel panel-default">
			<table class="table">
				<tr>
					<th>Id</th>
					<th>Seat Number</th>
					<th>State</th>
					<th>Date Time</th>
				</tr>
				<% for (Ticket ticket : tickets) { %>
				<tr>
					<td><%=ticket.getId()%></td>
					<td><%=ticket.getSeatNumber()%></td>
					<td><a href="TicketUpdateServlet?id=<%=ticket.getId()%>&state=<%=ticket.getState()%>">
					       <%=ticket.getState()%></a></td>
					<td><%=ticket.getDateTime()%></td>
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