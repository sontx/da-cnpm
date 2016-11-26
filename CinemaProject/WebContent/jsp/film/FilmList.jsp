<%@page import="org.apache.commons.lang3.StringEscapeUtils"%>
<%@page import="com.dutproject.cinemaproject.model.bean.Film"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<title>Films</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
</head>

<body>

	<jsp:include page="/jsp/navbar.jsp"></jsp:include>

	<%
		List<Film> films = (List<Film>) request.getAttribute("films");
		String lastKeyword = (String)request.getAttribute("keyword");
	%>

	<div class="container">
		<div class="form-horizontal">
			<div class="form-group">
				<div class="col-md-9">
					<a class="btn btn-primary"
						href="<%=request.getContextPath() + "/film/AddFilmForm"%>"> <span
						class="glyphicon glyphicon-plus"></span> Add...
					</a>
				</div>
				<form class="col-md-3" action="FilmList" method="get">
					<div class="input-group col-md-12">
						<input type="text" class="  search-query form-control"
							placeholder="Search" name="keyword" value="<%=lastKeyword%>"  /> <span class="input-group-btn">
							<button class="btn btn-info" type="submit">
								<span class=" glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
				</form>
			</div>
		</div>
		<%
			if (films != null && films.size() > 0) {
		%>
		<table class="table table-bordered">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Length</th>
				<th>Description</th>
				<th>Age Limited</th>
				<th></th>
			</tr>
			<%
				for (Film film : films) {
			%>
			<tr>
				<td><%=film.getFilmId()%></td>
				<td><%=film.getFilmName()%></td>
				<td><%=film.getLength() + " minutes"%></td>
				<td style="max-width: 150px;"><%=StringEscapeUtils.escapeHtml4(film.getDescription())%></td>
				<td class="text-center"
					style="white-space: nowrap; width: 1%; font-size: 20px;">
					<%
						if (film.getAgeLimithed() > 0) {
					%> <span class="label label-danger"><%=film.getAgeLimithed() + "+"%></span>
					<%
						} else {
					%> <span class="label label-info">No</span> <%
 	}
 %>
				</td>
				<td class="text-center" style="white-space: nowrap; width: 1%;"><a
					class="btn btn-info"
					href="<%=request.getContextPath() + "/film/UpdateFilmForm?id=" + film.getFilmId()%>">
						<span class="glyphicon glyphicon-edit"></span> Edit
				</a> <a class="btn btn-danger" onclick="return confirm('Are you sure?')"
					href="<%=request.getContextPath() + "/film/DeleteFilmAction?id=" + film.getFilmId()%>">
						<span class="glyphicon glyphicon-remove"></span> Delete
				</a></td>
			</tr>
			<%
				}
			%>
		</table>
		<!-- pagination -->
		<%
		    int pageNumber = (Integer)request.getAttribute("pageNumber");
		    int previousPage = pageNumber - 1;
		    if (previousPage <= 0) {
		    	previousPage = 1;
		    }
		    
		    int maxPageNumber = (Integer) request.getAttribute("maxPageNumber");
		    int nextPage = pageNumber + 1;
		    if (nextPage > maxPageNumber) {
		        nextPage = maxPageNumber;
		    }
	    %>
		<div class="text-center form-inline">
            <div class="pagination">
               <a href="<%=request.getContextPath() %>/film/FilmList?page=<%=previousPage %>" aria-label="Previous">
               <span aria-hidden="true">&laquo;Trước</span></a>
               <input class="form-control input-sm" id="pageNumber" type="text" name="pageNumber" value="<%=pageNumber %>" size="1" onkeydown="submitWhenEnter();">
               / <%=maxPageNumber %>
               <a href="<%=request.getContextPath() %>/film/FilmList?page=<%=nextPage %>" aria-label="Next">
               <span aria-hidden="true">Sau&raquo;</span></a>
            </div>
        </div>
		<%
			} else {
		%>
		You don't have any film.
		<%
			}
		%>
	</div>
	
	<script type="text/javascript">
		function submitWhenEnter() {
	        if (event.keyCode == 13) {
	            var pageNumber = document.getElementById("pageNumber").value;
	            var url = "<%=request.getContextPath() %>/film/FilmList?page=" + pageNumber;
	            window.location = url;
	            return false;
	        }
	    }
	</script>
</body>
</html>