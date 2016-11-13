<%@page import="com.dutproject.cinemaproject.utils.Validate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>

<head>
    <title>Add Film</title>
    
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
    <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
</head>

<body>

    <jsp:include page="/jsp/navbar.jsp"></jsp:include>

	<div class="container">
		<form class="form-horizontal" action="AddFilmAction" method="post">
		<fieldset>
		
		<legend class="text-center">Add Film</legend>
		
		<div class="form-group">
		  <label class="col-md-4 control-label" for="name"> Full Name</label>  
		  <div class="col-md-5">
		  <input id="name" name="name" type="text" placeholder="" class="form-control input-md" required>
		  </div>
		</div>
		
		<div class="form-group">
		  <label class="col-md-4 control-label" for="duration">Duration</label>  
		  <div class="col-md-5">
		  <input id="duration" name="duration" type="text" placeholder="" class="form-control input-md" required>
		  </div>
		</div>
		
		<div class="form-group">
		  <label class="col-md-4 control-label" for="description">Description</label>
		  <div class="col-md-5">                     
		    <textarea class="form-control" id="description" name="description" required></textarea>
		  </div>
		</div>
		
		<div class="form-group">
		  <label class="col-md-4 control-label" for="oldLimited">Old Limited</label>
		  <div class="col-md-5">
		    <select id="oldLimited" name="oldLimited" class="form-control">
		      <option value="2">16+</option>
		      <option value="3">18+</option>
		    </select>
		  </div>
		</div>
		
		<div class="form-group">
		  <label class="col-md-4 control-label" for="button1id"></label>
		  <div class="col-md-8">
		    <button type="submit" class="btn btn-success">Add</button>
		    <a id="button2id" class="btn btn-default">Cancel</a>
		  </div>
		</div>
		
		</fieldset>
		</form>
	</div>
</body>
</html>