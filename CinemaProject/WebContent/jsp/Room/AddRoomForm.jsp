<%@page import="com.dutproject.cinemaproject.model.bean.Room"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>

<head>
    <title>Rooms</title>
    
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
    <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
</head>

<body>

    <jsp:include page="/jsp/navbar.jsp"></jsp:include>

	<div class="container">
		<form class="form-horizontal" action="UpdateRoomAction" method="post">
		<fieldset>
		
        <legend class="text-center">Add Room</legend>
        
        <div class="form-group">
          <label class="col-md-4 control-label">Room Name</label>  
          <div class="col-md-5">
              <input name="roomName" type="text" class="form-control input-md" required>
          </div>
        </div>
        
        <div class="form-group">
          <label class="col-md-4 control-label">Rows</label>  
          <div class="col-md-5">
              <input name="rows" type="number" maxlength="5" class="form-control input-md" required>
          </div>
        </div>
        
        <div class="form-group">
          <label class="col-md-4 control-label">Columns</label>  
          <div class="col-md-5">
              <input name="columns" type="number" maxlength="5" class="form-control input-md" required>
          </div>
        </div>
        
        <div class="form-group">
          <label class="col-md-4 control-label"></label>
          <div class="col-md-8">
            <button type="submit" class="btn btn-success">Add</button>
            <a class="btn btn-default" onclick="history.go(-1);">Cancel</a>
          </div>
        </div>
		</fieldset>
        </form>
	</div>
</body>
</html>
