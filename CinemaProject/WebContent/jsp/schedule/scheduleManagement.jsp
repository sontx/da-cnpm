<%@page import="com.dutproject.cinemaproject.model.bo.schedule.RoomBO"%>
<%@page import="com.dutproject.cinemaproject.model.bo.schedule.FilmBO"%>
<%@page import="com.dutproject.cinemaproject.model.bean.schedule.Schedule"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách Lịch chiếu</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/schedule/scheduleManagement.css">

</head>
<body onload="showNotification()">

<script type="text/javascript">
function showNotification() {
	
}
</script>

<jsp:include page="/jsp/navbar.jsp"></jsp:include>

<br>

<!-- create and search schedule -->
<a href="<%=request.getContextPath() %>/CreateScheduleForm">Tạo lịch chiếu</a>
<input type="text">
<button>Tìm</button>

<br>

<!-- table schedules -->
<table>
	<tr> <!-- table header -->
		<th>#</th>
		<th>Phim</th>
		<th>Phòng chiếu</th>
		<th>Thời gian chiếu</th>
		<th></th>
	</tr>
	<%
	ArrayList<Schedule> listSchedules = (ArrayList<Schedule>)request.getAttribute("listSchedules");
	int index = 1;
	FilmBO filmBO = new FilmBO();
	RoomBO roomBO = new RoomBO();
	for (Schedule schedule : listSchedules) {
		%>
	<tr>
		<td><%=index++ %></td>
		<td><%=filmBO.getFilmById(schedule.getFilmId()).getFilmName() %></td>
		<td><%=roomBO.getRoomById(schedule.getRoomId()).getRoomName() %></td>
		<td><%=schedule.periodOfTimeToString() %></td>
		<td>
			<a href="<%=request.getContextPath() %>/EditScheduleForm?id=<%=schedule.getScheduleId() %>">Chỉnh sửa</a>
			<a href="<%=request.getContextPath() %>/DeleteSchedule?id=<%=schedule.getScheduleId() %>">Xóa</a>
		</td>
	</tr>
		<%
	}
	%>
	
</table>

<!-- pagination -->
<%
int pageNumber = (Integer)request.getAttribute("pageNumber");
int maxPageNumber = (Integer)request.getAttribute("maxPageNumber");
int previousPageNumber = pageNumber - 1;
if (previousPageNumber <= 0) {
	previousPageNumber = 1;
}
int nextPageNumber = pageNumber + 1;
if (nextPageNumber > maxPageNumber) {
	nextPageNumber = maxPageNumber;
}
%>
<a href="<%=request.getContextPath() %>/ScheduleManagement?pageNumber=<%=previousPageNumber %>">&lt;Trước</a>
<input type="text" value="<%=pageNumber %>" size="1">/<%=maxPageNumber %>
<a href="<%=request.getContextPath() %>/ScheduleManagement?pageNumber=<%=nextPageNumber %>">Sau&gt;</a>

</body>
</html>