<%@page import="com.dutproject.cinemaproject.model.bean.Room"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<title>Rooms</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
</head>

<body>

	<jsp:include page="/jsp/navbar.jsp"></jsp:include>

	<div class="container">
		<h1 align="center">Room Manager</h1>
	</div>

	<%
		List<Room> rooms = (List<Room>) request.getAttribute("rooms");
	%>
	<div class="container">
		<div style="padding-bottom: 15px">
			<a class="btn btn-primary"
				href="<%=request.getContextPath() + "/Room/AddRoomForm"%>"> <span
				class="glyphicon glyphicon-plus"></span> Add...
			</a>
		</div>
		<%
			if (rooms.size() > 0) {
		%>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Chairs</th>
					<th>Status</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<%
					for (Room room : rooms) {
				%>
				<tr>
					<td><%=room.getId()%></td>
					<td><%=room.getRoomName()%></td>
					<td><%=room.getRows() * room.getColumns()%></td>
					<td><%=Room.getStatusString(room.getStatus())%></td>
					<td><a
						href="<%=request.getContextPath() + "/Room/UpdateRoomForm?id=" + room.getId()%>">Edit</a>
						<a onclick="return confirm('Are you sure?')"
						href="<%=request.getContextPath() + "/Room/DeleteRoomAction?id=" + room.getId()%>">Delete</a>
					</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<%
			} else {
		%>
		You don't have any room.
		<%
			}
		%>
	</div>

</body>
</html>
