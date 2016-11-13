<%@page import="com.dutproject.cinemaproject.model.bean.Account"%>
<%@page import="com.dutproject.cinemaproject.model.bean.AccountProfile"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Cinema Management - Admin</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="../navbar.jsp"></jsp:include>

	<%
		List<AccountProfile> staffs = (List<AccountProfile>) request.getAttribute("staffs");
		if (staffs != null && staffs.size() > 0) {
	%>
	<div class="container">
		<div style="padding-bottom: 15px">
			<a class="btn btn-primary"
				href="<%=request.getContextPath() + "/Admin/AddStaffForm"%>"> <span
				class="glyphicon glyphicon-plus"></span> Add...
			</a>
		</div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Id</th>
					<th>Full Name</th>
					<th>User Name</th>
					<th>Birthday</th>
					<th>Phone Number</th>
					<th>Identity Card</th>
					<th>Type</th>
					<th></th>
				</tr>
			</thead>
			<%
				for (AccountProfile staff : staffs) {
						String type = Account.getPermissionString(staff.getAccount().getPermission());
			%>
			<tbody>
				<tr>
					<td><%=staff.getId()%></td>
					<td><%=staff.getFullName()%></td>
					<td><%=staff.getAccount().getUsername()%></td>
					<td><%=staff.getBirthDay()%></td>
					<td><%=staff.getPhoneNumber()%></td>
					<td><%=staff.getIdentityCard()%></td>
					<td><%=type%></td>
					<td class="text-center"><a class="btn btn-info"
						href="<%=request.getContextPath() + "/Admin/UpdateStaffForm?id=" + staff.getAccount().getId()%>">
							<span class="glyphicon glyphicon-edit"></span> Edit
					</a> <a class="btn btn-danger"
						onclick="return confirm('Are you sure?')"
						href="<%=request.getContextPath() + "/Admin/DeleteStaffAction?id=" + staff.getAccount().getId()%>">
							<span class="glyphicon glyphicon-remove"></span> Delete
					</a></td>
				</tr>
			</tbody>
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
	</div>
</body>
</html>