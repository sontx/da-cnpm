<%@page import="com.dutproject.cinemaproject.model.bo.schedule.RoomBO"%>
<%@page import="com.dutproject.cinemaproject.model.bean.schedule.Room"%>
<%@page import="com.dutproject.cinemaproject.model.bo.schedule.FilmBO"%>
<%@page import="com.dutproject.cinemaproject.model.bean.schedule.Film"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>

<head>
    <title>Tạo Lịch chiếu</title>
    
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
    <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
</head>

<body>

    <jsp:include page="/jsp/navbar.jsp"></jsp:include>

    <!-- create schedule form -->
	<div class="container">
		<form class="form-horizontal" action="<%=request.getContextPath() %>/CreateSchedule" method="post">
		<fieldset>
		
		<legend class="text-center">Tạo Lịch chiếu</legend>
		
		<div class="form-group">
		 <label class="col-md-4 control-label" for="Phim">Phim:</label>
		 <div class="col-md-5">
		   <select id="Phim" name="filmId" class="form-control">
		     <option value="-1" selected="selected">Chọn phim</option>
             <%
             List<Film> listFilms = new FilmBO().searchFilmByName("", 3);
             for (Film film : listFilms) {
             %>
             <option value="<%=film.getFilmId() %>"><%=film.getFilmName() %></option>
             <%
             }
             %>
		   </select>
		 </div>
		</div>
		
		<div class="form-group">
		  <label class="col-md-4 control-label" for="selectbasic">Phòng chiếu:</label>
		  <div class="col-md-5">
		    <select id="selectbasic" name="roomId" class="form-control">
		      <option value="-1" selected="selected">Chọn phòng</option>
              <%
              List<Room> listRooms = new RoomBO().getAllRooms();
              for (Room room : listRooms) {
              %>
              <option value="<%=room.getRoomId() %>"><%=room.getRoomName() %></option>
              <%
              }
              %>
		    </select>
		  </div>
		</div>
		
		<div class="form-group">
		  <label class="col-md-4 control-label" for="textinput">Ngày:</label>  
		  <div class="col-md-5">
		  <input id="textinput" name="date" type="text" placeholder="" class="form-control input-md" required="">
		  </div>
		</div>
		
		<div class="form-group">
		  <label class="col-md-4 control-label" for="textinput">Bắt đầu</label>  
		  <div class="col-md-5">
		  <input id="textinput" name="startTime" type="text" placeholder="" class="form-control input-md" required="">
		    
		  </div>
		</div>
		
		<div class="form-group">
		  <label class="col-md-4 control-label" for="textinput">Kết thúc</label>  
		  <div class="col-md-5">
		  <input id="textinput" name="endTime" type="text" placeholder="" class="form-control input-md" required="">
		  </div>
		</div>
		
		<div class="form-group text-center">
		  <label class="col-md-4 control-label" for="singlebutton"></label>
		  <div class="col-md-4">
		    <button type="submit" id="singlebutton" name="singlebutton" class="btn btn-success">Tạo</button>
		    <a class="btn btn-default" href="<%=request.getContextPath() %>/ScheduleManagement">Hủy</a>
		  </div>
		</div>
		
		</fieldset>
		</form>
	</div>

</body>
</html>