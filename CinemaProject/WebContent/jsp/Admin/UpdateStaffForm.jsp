<%@page import="com.dutproject.cinemaproject.model.bean.Account"%>
<%@page import="com.dutproject.cinemaproject.model.bean.AccountProfile"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update</title>
</head>
<body>
	<%
	AccountProfile staff = (AccountProfile) request.getAttribute("staff");
	%>
	<div align="center">
		<form action="UpdateStaffAction" method="post">
			<input type="hidden" name="id" value="<%=staff.getAccount().getId()%>">
			<table>
				<tr>
					<td>Code:</td>
					<td><input style="width: 100%" readonly="readonly" type="text" required="required"
						name="code" value="<%=staff.getId()%>"></td>
				</tr>
				<tr>
					<td>Full Name:</td>
					<td><input style="width: 100%" type="text" required="required"
						name="fullName" value="<%=staff.getFullName()%>"></td>
				</tr>
				<tr>
					<td>User Name:</td>
					<td><input style="width: 100%" type="text" required="required"
						name="userName" readonly="readonly"
						value="<%=staff.getAccount().getUsername()%>"></td>
				</tr>
				<tr>
					<td>New Password:</td>
					<td><input style="width: 100%" type="password" name="password"></td>
				</tr>
				<tr>
					<td>Birthday:</td>
					<td><input style="width: 100%" type="date" required="required"
						name="birthday" value="<%=staff.getBirthDay()%>"></td>
				</tr>
				<tr>
					<td>Phone Number</td>
					<td><input style="width: 100%" type="number"
						required="required" maxlength="11" name="phoneNumber"
						value="<%=staff.getPhoneNumber()%>"></td>
				</tr>
				<tr>
					<td>Identity Card:</td>
					<td><input style="width: 100%" type="number" readonly="readonly"
						required="required" maxlength="9" name="identityCard"
						value="<%=staff.getIdentityCard()%>"></td>
				</tr>
				<tr>
					<td>Type:</td>
					<td><select style="width: 100%" name="staffType">
							<option value="2"
								selected="<%=staff.getAccount().getPermission() == Account.FILM_MANAGER ? "selected" : ""%>">Film
								Manager</option>
							<option value="3"
								selected="<%=staff.getAccount().getPermission() == Account.ROOM_MANAGER ? "selected" : ""%>">Room
								Manager</option>
							<option value="4"
								selected="<%=staff.getAccount().getPermission() == Account.SCHEDULE_MANAGER ? "selected" : ""%>">Schedule
								Manager</option>
							<option value="5"
								selected="<%=staff.getAccount().getPermission() == Account.TICKET_MANAGER ? "selected" : ""%>">Ticket
								Manager</option>
					</select></td>
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