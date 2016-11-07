<%@page import="com.dutproject.cinemaproject.utils.Validate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Film</title>
</head>
<body>
	<div align="center">
		<form action="AddFilmAction" method="post">
			<table>
				<tr>
					<td>Full Name:</td>
					<td><input style="width: 100%" type="text" required="required"
						name="name"></td>
				</tr>
				<tr>
					<td>Duration</td>
					<td><input style="width: 100%" type="number"
						required="required" name="duration"></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><input style="width: 100%" required="required"
						name="description"></td>
				</tr>
				<tr>
					<td>Old Limited</td>
					<td><select style="width: 100%" name="oldLimited">
							<option value="2">16+</option>
							<option value="3">18+</option>
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