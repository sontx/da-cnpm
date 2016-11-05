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
	<%
		Room room = (Room) request.getAttribute("room");
	%>
	<div align="center">
		<form action="UpdateRoomAction" method="post">
			<table>
				<tr>
					<td>Id:</td>
					<td><input style="width: 100%" readonly="readonly" type="text"
						required="required" name="id" value="<%=room.getId()%>"></td>
				</tr>
				<tr>
					<td>Room Name:</td>
					<td><input style="width: 100%" type="text" required="required"
						name="roomName" value="<%=room.getRoomName()%>"></td>
				</tr>
				<tr>
					<td>Rows:</td>
					<td><input style="width: 100%" type="number"
						required="required" maxlength="5" name="rows" value="<%=room.getRows()%>"></td>
				</tr>
				<tr>
					<td>Columns:</td>
					<td><input style="width: 100%" type="number"
						required="required" maxlength="5" name="columns" value="<%=room.getColumns()%>"></td>
				</tr>
				<tr>
					<td>Available:</td>
					<td><input type="checkbox" style="width: 100%" name="status" <%=room.getStatus() != 0 ? "checked" : ""%>></td>
				</tr>
				<tr align="right">
					<td></td>
					<td><input type="submit" value="Update"> <input
						type="button" value="Cancel"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
