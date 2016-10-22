<%@page
	import="com.dutproject.cinemaproject.model.bean.Account.Permission"%>
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
		if (staffs != null && staffs.size() > 0) {
	%>
	<table border="1" style="width:100%">
		<tr>
			<td>Id</td>
			<td>Full Name</td>
			<td>User Name</td>
			<td>Password</td>
			<td>Birthday</td>
			<td>Phone Number</td>
			<td>Identity Card</td>
			<td>Type</td>
			<td></td>
		</tr>
		<%
			for (Staff staff : staffs) {
					String type = "Unknown";
					if (staff.getPermission() == Permission.FILM_MANAGER)
						type = "Film Manager";
					else if (staff.getPermission() == Permission.ROOM_MANAGER)
						type = "Room Manager";
		%>
		<tr>
			<td><%=staff.getId()%></td>
			<td><%=staff.getFullName()%></td>
			<td><%=staff.getUserName()%></td>
			<td><%=staff.getPassword()%></td>
			<td><%=staff.getBirthDay()%></td>
			<td><%=staff.getPhoneNumber()%></td>
			<td><%=staff.getIdentityCard()%></td>
			<td><%=type%></td>
			<td>
				<a href="<%=request.getContextPath() + "/Admin/EditForm?id=" + staff.getId()%>">Edit</a>
				<a onclick="return confirm('Are you sure?')"
				 href="<%=request.getContextPath() + "/Admin/DeleteAction?id=" + staff.getId()%>">Delete</a>	
			</td>
		</tr>
		<%
			}
		%>
	</table>
	<%
		} else {
	%>
			You don't have any staff.
	<%
		}
	%>
</body>
</html>