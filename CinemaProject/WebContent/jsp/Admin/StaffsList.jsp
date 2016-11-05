<%@page import="com.dutproject.cinemaproject.model.bean.Account"%>
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
	<a href="<%=request.getContextPath() + "/Admin/AddStaffForm"%>">Add...</a>
	<%
		List<Staff> staffs = (List<Staff>) request.getAttribute("staffs");
		if (staffs != null && staffs.size() > 0) {
	%>
	<center>
	<table border="1">
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
					String type = Account.getPermissionString(staff.getPermission());
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
			<td><a
				href="<%=request.getContextPath() + "/Admin/UpdateStaffForm?id=" + staff.getId()%>">Edit</a>
				<a onclick="return confirm('Are you sure?')"
				href="<%=request.getContextPath() + "/Admin/DeleteStaffAction?id=" + staff.getId()%>">Delete</a>
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
	</center>
</body>
</html>