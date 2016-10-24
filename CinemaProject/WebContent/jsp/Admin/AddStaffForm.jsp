<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Staff</title>
</head>
<body>
	<div align="center">
		<form action="Admin/AddStaff" method="post">
			<table>
				<tr>
					<td>Full Name:</td>
					<td><input style="width: 100%" type="text" required="required"
						name="fullName"></td>
				</tr>
				<tr>
					<td>User Name:</td>
					<td><input style="width: 100%" type="text" required="required"
						name="userName"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input style="width: 100%" type="password"
						required="required" name="password"></td>
				</tr>
				<tr>
					<td>Birthday:</td>
					<td><input style="width: 100%" type="date" required="required"
						name="birthday"></td>
				</tr>
				<tr>
					<td>Phone Number</td>
					<td><input style="width: 100%" type="number"
						required="required" maxlength="11" name="phoneNumber"></td>
				</tr>
				<tr>
					<td>Identity Card:</td>
					<td><input style="width: 100%" type="number"
						required="required" maxlength="9" name="phoneNumber"></td>
				</tr>
				<tr>
					<td>Type:</td>
					<td><select style="width: 100%">
							<option value="schduleManager">Schedule Manager</option>
							<option value="ticketManager">Ticket Manager</option>
							<option value="filmManager">Film Manager</option>
							<option value="roomManager">Room Manager</option>
					</select></td>
				</tr>
				<tr align="right">
					<td></td>
					<td><input type="submit" value="Add"> <input
						type="button" value="Cancel"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>