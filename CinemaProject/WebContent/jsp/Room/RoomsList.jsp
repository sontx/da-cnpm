<%@page import="com.dutproject.cinemaproject.model.bean.Room"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rooms</title>
</head>
<body>
	<a href="<%=request.getContextPath() + "/Room/AddRoomForm"%>">Add...</a>
	<%
		List<Room> rooms = (List<Room>) request.getAttribute("rooms");
		if (rooms.size() > 0) {
	%>
	<h1 align="center">Room Manager</h1>
	<table border='1' align="center">
		<thead>
			<tr>
				<td align="center">ID</td>
				<td align="center">Name</td>
				<td align="center">Chairs</td>
				<td align="center">Status</td>
				<td></td>
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
					href="<%=request.getContextPath() + "/Admin/DeleteRoomAction?id=" + room.getId()%>">Delete</a>
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


</body>
</html>
