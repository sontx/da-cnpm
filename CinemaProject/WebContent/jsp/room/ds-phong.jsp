<%@page import="com.dutproject.cinemaproject.model.bean.Room"%>
<%@page import="java.util.ArrayList"%>

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
		List<Room> rooms = (List<Room>) request.getAttribute("rooms");
		if (rooms.size() > 0) {
	%>
	<a href="/room">Thêm Phòng</a>
	<center>
		<table border="1">
			<tr>
				<td>Id</td>
				<td>Stt</td>
				<td>Mã Phòng</td>
				<td>Tên Phòng</td>
				<td>Số Hàng</td>
				<td>Số Cột</td>
			</tr>
			<%
				for (Room room : rooms) {
			%>
			<tr>
				<td><%=room.getId()%></td>
				<td><%=room.getStt()%></td>
				<td><%=room.getMaPhong()%></td>
				<td><%=room.getTenPhong()%></td>
				<td><%=room.getSoHang()%></td>
				<td><%=room.getSoCot()%></td>

				<td><a href="/edit">sửa</a> <a href="/delete">xóa</a></td>

			</tr>
			<%
				}
			%>
		</table>
		<%
			} else {
		%>
		
		<%
			}
		%>
	</center>
</body>
</html>
