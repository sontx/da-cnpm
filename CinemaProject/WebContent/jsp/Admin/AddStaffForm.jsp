<%@page import="com.dutproject.cinemaproject.utils.Validate"%>
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

	<div class="container">
		<form class="form-horizontal" action="AddStaffAction" method="post">
			<fieldset>

				<!-- Form Name -->
				<legend>Add Staff</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="code">Code</label>
					<div class="col-md-4">
						<input id="code" name="code" type="text" placeholder="NV1"
							class="form-control input-md" required="required">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="fullName">Full
						Name</label>
					<div class="col-md-4">
						<input id="fullName" name="fullName" type="text"
							placeholder="Tran xuan son" class="form-control input-md"
							required="required">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="username">Username</label>
					<div class="col-md-4">
						<input id="username" name="userName" type="text"
							placeholder="sontx" class="form-control input-md" required="required">

					</div>
				</div>

				<!-- Password input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="password">Password</label>
					<div class="col-md-4">
						<input id="password" name="password" type="password"
							placeholder="secret password" class="form-control input-md"
							required="required">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="birthday">Birthday</label>
					<div class="col-md-4">
						<input id="birthday" name="birthday" type="date"
							placeholder="03/03/1994" class="form-control input-md"
							required="required">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="phoneNumber">Phone
						Number</label>
					<div class="col-md-4">
						<input id="phoneNumber" name="phoneNumber" type="number"
							maxlength="11" placeholder="01647891437"
							class="form-control input-md" required="required">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="identityCard">Identity
						Card</label>
					<div class="col-md-4">
						<input id="identityCard" name="identityCard" type="number"
							maxlength="9" placeholder="241442636"
							class="form-control input-md" required="required">

					</div>
				</div>

				<!-- Select Basic -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="staffType">Permission</label>
					<div class="col-md-4">
						<select id="staffType" name="staffType" class="form-control">
							<option value="2">Film Manager</option>
							<option value="3">Room Manager</option>
							<option value="4">Schedule Manager</option>
							<option value="5">Ticket Manager</option>
						</select>
					</div>
				</div>

				<!-- Button (Double) -->
				<div class="form-group">
					<div class="col-md-8 text-right">
						<input type="submit" class="btn btn-success" value="Add" /> <input
							type="reset" class="btn btn-default" value="Reset" />
					</div>
				</div>

			</fieldset>
		</form>

	</div>
</body>
</html>