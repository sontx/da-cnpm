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
	<h1 align = "center">QUẢN LÝ PHÒNG CHIẾU</h1>
<table border = '1' align = "center">
<thead>
<tr>
<td align = "center">STT</td>
<td align = "center">Mã Phòng</td>
<td align = "center">Tên Phòng</td>
<td align = "center">Số Hàng</td>
<td align = "center">Số Cột</td>
</tr>
</thead>
<tbody>
<tr>
<td align = "center">1</td>
<td align = "center">SC1</td>
<td align = "center">3D</td>
<td align = "center">10</td>
<td align = "center">12</td>
</tr>
<tr>
<td align = "center">2</td>
<td align = "center">SC3</td>
<td align = "center">2D</td>
<td align = "center">14</td>
<td align = "center">20</td>
</tr>
<tr>
<td align = "center">3</td>
<td align = "center">SC5</td>
<td align = "center">4D</td>
<td align = "center">8</td>
<td align = "center">10</td>
</tr>
<tr>
<td align = "center">4</td>
<td align = "center">SC8</td>
<td align = "center">2D</td>
<td align = "center">14</td>
<td align = "center">10</td>
</tr>
</tbody>
</table>


<div style="margin-top:40px;margin-right:0px;margin-left:600px">
<button type="button">Thêm</button>
<button type="button">Sửa</button>
<button type="button">Xóa</button>
</div>

			<%
		}
			%>

	
		
		
</body>
</html>
