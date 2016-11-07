<%@page import="com.dutproject.cinemaproject.model.bean.Account"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Cinema Management</a>
		</div>
		<ul class="nav navbar-nav navbar-right">
			<%
				Object objPermission = request.getSession().getAttribute("permission");
				String spermission = objPermission != null ? objPermission.toString() : Account.NO_PERMISSION + "";
				int permission = Account.NO_PERMISSION;
				try {
					permission = Integer.parseInt(spermission);
				} catch (NumberFormatException ignored) {
				}
				if (permission != Account.NO_PERMISSION) {
			%>

			<li><a href="#"><span class="glyphicon glyphicon-user"></span>
					<%=request.getSession().getAttribute("username").toString()%></a></li>
			<li><a href="<%=request.getContextPath() %>/Logout"><span class="glyphicon glyphicon-log-out"></span>
					Logout</a></li>
			<%
				}
			%>
		</ul>
	</div>
</nav>