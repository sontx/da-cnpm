<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Schedule Manager</title>
<style>
table {
    border-collapse: collapse;
}

table, th, td {
    border: 1px solid black;
}
</style>
</head>
<body>

<jsp:include page="../navbar.jsp"></jsp:include>

<br>

<!-- create new schedule -->
<a href="#">Tạo lịch chiếu</a>

<!-- searching fucntion -->
<input type="text" placeholder="search">
<button>Tìm</button>

<!-- table of schedules -->
<table>
	<!-- table header -->
	<tr>
		<th>#</th>
		<th>Phim</th>
		<th>Phòng chiếu</th>
		<th>Thời gian chiếu</th>
		<th></th>
	</tr>
	<!-- table data -->
	<tr>
		<td>1</td>
		<td>Phim A	</td>
		<td>Phòng 1</td>
		<td>10:00 - 12:00 01/01/2011</td>
		<td>
			<a href="#">Chỉnh sửa</a>
			<a href="#">Xóa</a>
		</td>
	</tr>
</table>

<!-- pagination -->
<a href="#">&lt; Trước</a> <input type="text" value="1" size="1">/1 <a href="#">Sau &gt;</a>

</body>
</html>