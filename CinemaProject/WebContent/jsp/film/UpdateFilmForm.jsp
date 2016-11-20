<%@page import="org.apache.commons.lang3.StringEscapeUtils"%>
<%@page import="com.dutproject.cinemaproject.model.bean.Film"%>
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
	<% Film film = (Film) request.getAttribute("film"); %>
	<div class="container">
		<form class="form-horizontal" action="UpdateFilmAction" method="post">
			<fieldset>

				<legend>Update Film: <%= film.getFilmName() %></legend>
				
				<input type="hidden" name="id" value="<%=film.getFilmId() %> %>" />
				
				<div class="form-group">
					<label class="col-md-4 control-label" for="name"> Full Name</label>
					<div class="col-md-4">
						<input id="name" name="fullName" type="text" placeholder=""
							class="form-control input-md" value="<%=film.getFilmName() %>" required>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="duration">Duration</label>
					<div class="col-md-4">
						<input id="duration" name="duration" type="text" placeholder=""
							class="form-control input-md" value="<%=film.getLength() %>" required>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="description">Description</label>
					<div class="col-md-4">
						<textarea class="form-control" id="description" name="description"
							required><%=StringEscapeUtils.escapeHtml4(film.getDescription())%></textarea>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="ageLimited">Age Limited</label>
					<div class="col-md-4">
						<select id="oldLimited" name="ageLimited" class="form-control">
							<option value="0" selected="<%= film.getAgeLimithed() == 0 ? "selected" : ""%>">No</option>
							<option value="22" selected="<%= film.getAgeLimithed() == 22 ? "selected" : ""%>">22+</option>
							<option value="18" selected="<%= film.getAgeLimithed() == 18 ? "selected" : ""%>">18+</option>
							<option value="16" selected="<%= film.getAgeLimithed() == 16 ? "selected" : ""%>">16+</option>
						</select>
					</div>
				</div>

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