<%@page import="com.dutproject.cinemaproject.model.bean.Account"%>
<%@page import="com.dutproject.cinemaproject.model.bean.AccountProfile"%>
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
		AccountProfile staff = (AccountProfile) request.getAttribute("staff");
	%>
	<div class="container">
		<form class="form-horizontal" action="UpdateStaffAction" method="post">
			<fieldset>
				<input type="hidden" name="id"
					value="<%=staff.getAccount().getId()%>">
				<!-- Form Name -->
				<legend>Add Staff</legend>

					<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="code">Code</label>
					<div class="col-md-4">
						<input id="code" name="code" type="text" value="<%=staff.getId()%>"
							class="form-control input-md" readonly="readonly">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="fullName">Full
						Name</label>
					<div class="col-md-4">
						<input id="fullName" name="fullName" type="text"
							value="<%=staff.getFullName()%>" class="form-control input-md"
							required="required">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="username">Username</label>
					<div class="col-md-4">
						<input id="username" name="userName" type="text"
							value="<%=staff.getAccount().getUsername()%>" class="form-control input-md" readonly="readonly">

					</div>
				</div>

				<!-- Password input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="password">New Password</label>
					<div class="col-md-4">
						<input id="password" name="password" type="password"
							placeholder="secret password" class="form-control input-md">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="birthday">Birthday</label>
					<div class="col-md-4">
						<input id="birthday" name="birthday" type="date"
							value="<%=staff.getBirthDay()%>" class="form-control input-md"
							required="required">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="phoneNumber">Phone
						Number</label>
					<div class="col-md-4">
						<input id="phoneNumber" name="phoneNumber" type="number"
							maxlength="11" value="<%=staff.getPhoneNumber()%>"
							class="form-control input-md" readonly="readonly">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="identityCard">Identity
						Card</label>
					<div class="col-md-4">
						<input id="identityCard" name="identityCard" type="number"
							maxlength="9" value="<%=staff.getIdentityCard()%>"
							class="form-control input-md" required="required">

					</div>
				</div>

				<!-- Select Basic -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="staffType">Permission</label>
					<div class="col-md-4">
						<select id="staffType" name="staffType" class="form-control">
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
						</select>
					</div>
				</div>

				<!-- Button (Double) -->
				<div class="form-group">
					<div class="col-md-8 text-right">
						<input type="submit" class="btn btn-success" value="Update" /> <input
							type="reset" class="btn btn-default" value="Reset" />
					</div>
				</div>

			</fieldset>
		</form>

	</div>
</body>
</html>