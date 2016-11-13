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

	<% Room room = (Room) request.getAttribute("room"); %>
	<div class="container">
		<form class="form-horizontal" action="UpdateRoomAction" method="post">
		<fieldset>
		
		<legend class="text-center">Update Room</legend>
		
        <div class="form-group">
          <label class="col-md-4 control-label">Id</label>  
          <div class="col-md-5">
	          <input name="id" type="text" value="<%=room.getId()%>"
	            class="form-control input-md" readonly="readonly" required>
          </div>
        </div>
        
        <div class="form-group">
          <label class="col-md-4 control-label">Room Name</label>  
          <div class="col-md-5">
              <input name="roomName" type="text" value="<%=room.getRoomName()%>"
                class="form-control input-md" required>
          </div>
        </div>
        
        <div class="form-group">
          <label class="col-md-4 control-label">Rows</label>  
          <div class="col-md-5">
              <input name="rows" type="number" value="<%=room.getRows()%>" maxlength="5"
                class="form-control input-md" required>
          </div>
        </div>
        
        <div class="form-group">
          <label class="col-md-4 control-label">Columns</label>  
          <div class="col-md-5">
              <input name="columns" type="number" value="<%=room.getColumns()%>" maxlength="5"
                class="form-control input-md" required>
          </div>
        </div>
        
        <div class="form-group">
          <label class="col-md-4 control-label">Available</label>  
          <div class="col-md-5">
              <input name="status" type="checkbox" <%=room.getStatus() != 0 ? "checked" : ""%>
                class="checkbox">
          </div>
        </div>
        
        <div class="form-group">
          <label class="col-md-4 control-label"></label>
          <div class="col-md-8">
            <button type="submit" class="btn btn-success">Update</button>
            <a class="btn btn-default" onclick="history.go(-1);">Cancel</a>
          </div>
        </div>
		</fieldset>
		</form>
	</div>
</body>
</html>
