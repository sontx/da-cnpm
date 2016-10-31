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
<title>Tạo Lịch chiếu</title>
</head>
<body>

<jsp:include page="/jsp/navbar.jsp"></jsp:include>

<form action="<%=request.getContextPath() %>/CreateSchedule" method="post">
	Phim:
	<select name="filmId">
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
	<br>
	Phòng chiếu:
	<select name="roomId">
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
	<br>
	Thời gian chiếu:<br>
	Ngày: <input type="text" name="date"><br>
	Bắt đầu: <input type="text" name="startTime"><br>
	Kết thúc: <input type="text" name="endTime">
	<br>
	<input type="submit" value="Tạo"> <a href="<%=request.getContextPath() %>/ScheduleManagement">Hủy</a>
</form>

</body>
</html>