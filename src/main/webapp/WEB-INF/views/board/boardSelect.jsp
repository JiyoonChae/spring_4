<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>

</head>
<body>
<c:import url="../template/header.jsp"></c:import>

	<div class="container">
		<h3>${dto.title}</h3>
		<h3>${dto.writer}</h3>
		<h3>${dto.contents}</h3>
		<h3>${dto.regDate}</h3>
		
		
	<input type="button" title="${dto.num}" value="update" class="btn btn-info" id="update">
	<input type="button" title="${dto.num}" value="delete" class="btn btn-warning" id="del">
	<c:if test="${board ne 'notice'}">
	<a href="./${board}Reply?num=${dto.num }" class="btn btn-primary">Reply</a>
		</c:if>
	</div>

</body>
</html>