<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>


<body>
<table class="table table-border">
	<c:forEach items="${list}" var="dto" varStatus="vs">
		<tr>
			<td>${dto.num}</td>
			<td>${dto.contents}</td>
			<td>${dto.writer}</td>
			<td>${dto.regDate}</td>
			<td><button title="${dto.num}" class="btn btn-danger del">del</button></td>
		</tr>
	</c:forEach>
</table>

</body>
</html>