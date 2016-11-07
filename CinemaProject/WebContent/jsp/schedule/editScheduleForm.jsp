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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cập nhật lịch chiếu</title>
</head>
<body>

<jsp:include page="/jsp/navbar.jsp"></jsp:include>

<%
Schedule schedule = (Schedule) request.getAttribute("schedule");
%>
<form action="<%=request.getContextPath() %>/EditSchedule" method="post">
	<input type="hidden" name="scheduleId" value="<%=schedule.getScheduleId() %>">
	Phim:
	<select name="filmId">
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
	<br>
	Phòng chiếu:
	<select name="roomId">
		<option value="-1" selected="selected">Chọn phòng</option>
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
	<br>
	<%
	Date startTime = Converter.intToDate(schedule.getStartTime());
	Date endTime = Converter.intToDate(schedule.getEndTime());
	%>
	Thời gian chiếu:<br>
	Ngày: <input type="text" name="date" value="<%=Converter.toStringOnlyDate(startTime) %>"><br>
	Bắt đầu: <input type="text" name="startTime" value="<%=Converter.toStringOnlyTime(startTime) %>"><br>
	Kết thúc: <input type="text" name="endTime" value="<%=Converter.toStringOnlyTime(endTime) %>">
	<br>
	<input type="submit" value="Cập nhật"> <a href="<%=request.getContextPath() %>/ScheduleManagement">Hủy</a>
</form>

</body>
</html>