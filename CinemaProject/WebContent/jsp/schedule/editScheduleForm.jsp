<%@page import="com.dutproject.cinemaproject.utils.schedule.Converter"%>
<%@page import="java.util.Date"%>
<%@page import="com.dutproject.cinemaproject.model.bean.schedule.Schedule"%>
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
    <title>Cập nhật lịch chiếu</title>
    
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
    <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
</head>

<body>

    <jsp:include page="/jsp/navbar.jsp"></jsp:include>

	<% Schedule schedule = (Schedule) request.getAttribute("schedule"); %>
	
	<!-- edit schedule form -->
	<div class="container">
	    <form class="form-horizontal" action="<%=request.getContextPath() %>/EditSchedule" method="post">
        <fieldset>
        
        <legend class="text-center">Cập nhật Lịch chiếu</legend>
        
        <input type="hidden" name="scheduleId" value="<%=schedule.getScheduleId() %>">
        
        <div class="form-group">
         <label class="col-md-4 control-label" for="Phim">Phim:</label>
         <div class="col-md-5">
           <select id="Phim" name="filmId" class="form-control">
             <%
             List<Film> listFilms = new FilmBO().searchFilmByName("", 3);
             for (Film film : listFilms) {
                 String selected = schedule.getFilmId() == film.getFilmId() ? "selected" : "";
             %>
             <option value="<%=film.getFilmId() %>" <%=selected %>><%=film.getFilmName() %></option>
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
              <%
              List<Room> listRooms = new RoomBO().getAllRooms();
              for (Room room : listRooms) {
                  String selected = schedule.getRoomId() == room.getRoomId() ? "selected" : "";
              %>
              <option value="<%=room.getRoomId() %>" <%=selected %>><%=room.getRoomName() %></option>
              <%
              }
              %>
            </select>
          </div>
        </div>
        
        <%
        Date startTime = Converter.intToDate(schedule.getStartTime());
        Date endTime = Converter.intToDate(schedule.getEndTime());
        %>
            
        <div class="form-group">
          <label class="col-md-4 control-label" for="textinput">Ngày:</label>  
          <div class="col-md-5">
            <input id="textinput" name="date" type="text" value="<%=Converter.toStringOnlyDate(startTime) %>"
                placeholder="" class="form-control input-md" required="">
          </div>
        </div>
        
        <div class="form-group">
          <label class="col-md-4 control-label" for="textinput">Bắt đầu</label>  
          <div class="col-md-5">
	         <input id="textinput" name="startTime" type="text" value="<%=Converter.toStringOnlyTime(startTime) %>"
	           placeholder="" class="form-control input-md" required="">
          </div>
        </div>
        
        <div class="form-group">
          <label class="col-md-4 control-label" for="textinput">Kết thúc</label>  
          <div class="col-md-5">
	          <input id="textinput" name="endTime" type="text" value="<%=Converter.toStringOnlyTime(endTime) %>"
	               placeholder="" class="form-control input-md" required="">
          </div>
        </div>
        
        <div class="form-group text-center">
          <label class="col-md-4 control-label" for="singlebutton"></label>
          <div class="col-md-4">
            <button type="submit" id="singlebutton" name="singlebutton" class="btn btn-success">Cập nhật</button>
            <a class="btn btn-default" href="<%=request.getContextPath() %>/ScheduleManagement">Hủy</a>
          </div>
        </div>
        
        </fieldset>
        </form>
    </div>
</body>
</html>