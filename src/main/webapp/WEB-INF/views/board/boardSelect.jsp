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
	<h3 id="num">${dto.num}</h3>
		<h3>${dto.title}</h3>
		<h3>${dto.writer}</h3>
		<h3>${dto.contents}</h3>
		<h3>${dto.regDate}</h3>
		
		<div>
		<c:forEach items="${dto.boardfileDTOs}" var="file">
			<a href="./fileDown?fileName=${file.fileName}&oriName=${file.oriName}">${file.oriName}</a>
	
			<hr>
		</c:forEach>
		</div>
		
	<input type="button" id="update" value=Update class="btn btn-info">
	<input type="button" title="${dto.num}" value="Delete" id="del" class="btn btn-warning"}">
	
	<c:if test="${board ne 'notice'}">
	<a href="./${board}Reply?num=${dto.num}" class="btn btn-primary">Reply</a>
		</c:if>
	</div>
	
	<script type="text/javascript">
		$("#update").click(function() {
			location.href="./${board}Update?num=${dto.num}";
		})
		
		$("#del").click(function(){
			var num = $(this).attr("title");
			location.href="./${board}Delete?num="+num;
		})
	</script>
	
</body>
</html>