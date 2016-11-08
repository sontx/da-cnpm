<%@page import="com.dutproject.cinemaproject.model.bo.schedule.RoomBO"%>
<%@page import="com.dutproject.cinemaproject.model.bo.schedule.FilmBO"%>
<%@page import="com.dutproject.cinemaproject.model.bean.schedule.Schedule"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>

<head>
	<title>Danh sách Lịch chiếu</title>
	
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
	<script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
</head>

<body onload="showNotification()">

<script type="text/javascript">
	function showNotification() {
		
	}
	
	function submitWhenEnter() {
		if (event.keyCode == 13) {
		    var pageNumber = document.getElementById("pageNumber").value;
		    var url = "<%=request.getContextPath() %>/ScheduleManagement?pageNumber=" + pageNumber;
		    window.location = url;
			return false;
		}
	}
</script>

    <jsp:include page="/jsp/navbar.jsp"></jsp:include>

    <!-- create and search schedule -->
    <div class="container">
		<div class="row">
			<div class="col-lg-6">
				<a href="<%=request.getContextPath()%>/CreateScheduleForm">Tạo lịch chiếu</a>
			</div>
			<div class="col-lg-6">
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search for...">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">Tìm</button>
					</span>
				</div>
			</div>
		</div>
	</div>

    <!-- list chedules -->
    <div class="container" style="padding-top: 2%">
		<div class="panel panel-default">
			<!-- table schedules -->
			<table class="table">
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
					String filmName = filmBO.getFilmById(schedule.getFilmId()).getFilmName();
					String roomName = roomBO.getRoomById(schedule.getRoomId()).getRoomName();
					String time = schedule.periodOfTimeToString();
					String deleteConfirmMessage = String.format("Bạn có muốn xóa lịch chiếu %s tại %s lúc %s?", filmName, roomName, time);
					%>
				<tr>
					<th><%=index++ %></th>
					<td><%=filmName %></td>
					<td><%=roomName %></td>
					<td><%=time %></td>
					<td>
						<a href="<%=request.getContextPath() %>/EditScheduleForm?id=<%=schedule.getScheduleId() %> ">Chỉnh sửa</a> |
						<a href="<%=request.getContextPath() %>/DeleteSchedule?id=<%=schedule.getScheduleId() %>" onclick="return confirm('<%=deleteConfirmMessage %>')">Xóa</a>
					</td>
				</tr>
					<%
				}
				%>
			</table>
		</div>
	</div>

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
	<div class="container">
	   <div class="text-center form-inline">
            <div class="pagination">
               <a href="<%=request.getContextPath() %>/ScheduleManagement?pageNumber=<%=previousPageNumber %>" aria-label="Previous">
               <span aria-hidden="true">&laquo;Trước</span></a>
               <input class="form-control input-sm" id="pageNumber" type="text" name="pageNumber" value="<%=pageNumber %>" size="1" onkeydown="submitWhenEnter();">
               / <%=maxPageNumber %>
               <a href="<%=request.getContextPath() %>/ScheduleManagement?pageNumber=<%=nextPageNumber %>" aria-label="Next">
               <span aria-hidden="true">Sau&raquo;</span></a>
            </div>
        </div>
	</div>
</body>
</html>