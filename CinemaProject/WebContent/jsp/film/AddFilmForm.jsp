<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Quản lý rạp chiếu phim</title>

<!-- Bootstrap Core CSS -->
<link
	href="<%=request.getContextPath()%>/jsp/Resources/startbootstrap-sb-admin-gh-pages/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="<%=request.getContextPath()%>/jsp/Resources/startbootstrap-sb-admin-gh-pages/css/sb-admin.css"
	rel="stylesheet">

<!-- Morris Charts CSS -->
<link
	href="<%=request.getContextPath()%>/jsp/Resources/startbootstrap-sb-admin-gh-pages/css/plugins/morris.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="<%=request.getContextPath()%>/jsp/Resources/startbootstrap-sb-admin-gh-pages/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html">Quản lý rạp chiếu phim</a>
			</div>
			<!-- Top Menu Items -->
			<ul class="nav navbar-right top-nav">


				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-user"></i> Tran Xuan Son
						<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
						</li>
						<li><a href="#"><i class="fa fa-fw fa-envelope"></i>
								Inbox</a></li>
						<li><a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
						</li>
						<li class="divider"></li>
						<li><a href="#"><i class="fa fa-fw fa-power-off"></i> Log
								Out</a></li>
					</ul></li>
			</ul>
			<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
					<li><a href="loginForm.jsp"><i
							class="glyphicon glyphicon-home"></i> Trang chủ</a></li>
					<li class="active"><a href="index.html" id="dropdownMenu1"
						data-toggle="dropdown"><i class="fa fa-fw fa-dashboard"></i>
							Quản lý vé<span class="caret"></span></a>


						<ul class="dropdown-menu" role="menu"
							aria-labelledby="dropdownMenu1">
							<li role="presentation"><a role="menuitem" tabindex="-1"
								href="#">Danh sách vé</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1"
								href="#">Tình trạng vé</a></li>
						</ul></li>
					<li class="active"><a href="/jsp/film/AddFilmForm.jsp" id="dropdownMenu1"
						data-toggle="dropdown"><i class="glyphicon glyphicon-film"></i>
							Quản lý phim<span class="caret"></span></a>


						<ul class="dropdown-menu" role="menu"
							aria-labelledby="dropdownMenu1">
							<li role="presentation"><a role="menuitem" tabindex="-1"
								href="#">Danh sách phim</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1"
								href="#">Thêm phim </a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1"
								href="#">Cập nhật phim</a></li>

							<li role="presentation"><a role="menuitem" tabindex="-1"
								href="#">Xóa phim</a></li>

						</ul></li>
					<li class="active"><a href="index.html" id="dropdownMenu1"
						data-toggle="dropdown"><i class="glyphicon glyphicon-list-alt"></i>
							Quản lý lịch chiếu<span class="caret"></span></a>


						<ul class="dropdown-menu" role="menu"
							aria-labelledby="dropdownMenu1">
							<li role="presentation"><a role="menuitem" tabindex="-1"
								href="#">Danh sách lịch chiếu</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1"
								href="#">Thêm lịch chiếu</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1"
								href="#">Cập nhật lịch chiếu</a></li>

							<li role="presentation"><a role="menuitem" tabindex="-1"
								href="#">Xóa lịch chiếu</a></li>

						</ul></li>
					<li class="active"><a href="index.html" id="dropdownMenu1"
						data-toggle="dropdown"><i class="glyphicon glyphicon-th-large"></i>
							Quản lý phòng chiếu<span class="caret"></span></a>


						<ul class="dropdown-menu" role="menu"
							aria-labelledby="dropdownMenu1">
							<li role="presentation"><a role="menuitem" tabindex="-1"
								href="#">Danh sách phòng chiếu</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1"
								href="#">Thêm phòng chiếu</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1"
								href="#">Cập nhật phòng chiếu</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1"
								href="#">Xóa phòng chiếu</a></li>

						</ul></li>
					<li><a href="bootstrap-elements.html"><i
							class="glyphicon glyphicon-user"></i> Quản lý nhân sự </a></li>
					<li><a href="bootstrap-elements.html"><i
							class="glyphicon glyphicon-earphone"></i> Liên hệ </a></li>

				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</nav>

	<div align="center">
		<form action="AddFilmAction" method="post">
			<table>
				<tr>
					<td>Full Name:</td>
					<td><input style="width: 100%" type="text" required="required"
						name="name"></td>
				</tr>
				<tr>
					<td>Duration</td>
					<td><input style="width: 100%" type="number"
						required="required" name="duration"></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><input style="width: 100%" required="required"
						name="description"></td>
				</tr>
				<tr>
					<td>Old Limited</td>
					<td><select style="width: 100%" name="oldLimited">
							<option value="2">16+</option>
							<option value="3">18+</option>
					</select></td>
				</tr>
				<tr align="right">
					<td></td>
					<td><input type="submit" value="Add"> <input
						type="button" value="Cancel"></td>
				</tr>
			</table>
		</form>
	</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Morris Charts JavaScript -->
	<script
		src="<%=request.getContextPath()%>/jsp/Resources/startbootstrap-sb-admin-gh-pages/js/plugins/morris/raphael.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/jsp/Resources/startbootstrap-sb-admin-gh-pages/js/plugins/morris/morris.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/jsp/Resources/startbootstrap-sb-admin-gh-pages/js/plugins/morris/morris-data.js"></script>

</body>

</html>
