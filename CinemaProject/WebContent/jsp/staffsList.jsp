<%@page import="com.dutproject.cinemaproject.model.bean.Staff"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Staffs</title>
</head>
<body>
	<%
		List<Staff> staffs = (List<Staff>) request.getAttribute("staffs");
		if (staffs.size() > 0) {
	%>
	<table>
		<tr>
			<td>Id</td>
			<td>Full Name</td>
			<td>User Name</td>
			<td>Password</td>
			<td>Birthday</td>
			<td>Phone Number</td>
			<td>Identity Card</td>
			<td>Type</td>
		</tr>
		<%
			for (Staff staff : staffs) {
		%>
		<tr>
			<td><%=staff.getId()%></td>
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
</body>
</html>