<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success</title>
</head>
<body>
	<h3>
		<%=request.getAttribute("message")%>
	</h3>
	<%
		if (request.getAttribute("page") != null) {
	%>
	<h5>
		<a href="<%=request.getAttribute("page")%>">OK</a>
	</h5>
	<%
		}
	%>
</body>
</html>