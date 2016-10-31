<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tạo Lịch chiếu</title>
</head>
<body>

<jsp:include page="../navbar.jsp"></jsp:include>

<form action="<%=request.getContextPath() %>/CreateSchedule" method="post">
	Phim:
	<select name="filmId">
		<option value="-1" selected="selected">Chọn phim</option>
		<option value="1">Phim 1</option>
		<option value="2">Phim 2</option>
	</select>
	<br>
	Phòng chiếu:
	<select name="roomId">
		<option value="-1" selected="selected">Chọn phòng</option>
		<option value="1">Phòng 1</option>
		<option value="2">Phòng 2</option>
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