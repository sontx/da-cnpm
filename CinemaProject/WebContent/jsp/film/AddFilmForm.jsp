<%@page import="com.dutproject.cinemaproject.utils.Validate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<title>Add Film</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
</head>

<body>

	<jsp:include page="/jsp/navbar.jsp"></jsp:include>

	<div class="container">
		<form class="form-horizontal" action="AddFilmAction" method="post">
			<fieldset>

				<legend>Add Film</legend>

				<div class="form-group">
					<label class="col-md-4 control-label" for="name"> Full Name</label>
					<div class="col-md-4">
						<input id="name" name="fullName" type="text" placeholder=""
							class="form-control input-md" required>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="duration">Duration</label>
					<div class="col-md-4">
						<input id="duration" name="duration" type="text" placeholder=""
							class="form-control input-md" required>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="description">Description</label>
					<div class="col-md-4">
						<textarea class="form-control" id="description" name="description"
							required></textarea>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="ageLimited">Age Limited</label>
					<div class="col-md-4">
						<select id="oldLimited" name="ageLimited" class="form-control">
							<option value="0">No</option>
							<option value="22">22+</option>
							<option value="18">18+</option>
							<option value="16">16+</option>
						</select>
					</div>
				</div>

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