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
	<table class="table table-condensed">
		<tr>  <!-- session에있는 정보들을 가지고 오는 것!!, memberFile에 있는 것도 가지고 오고 싶으면 file도 session에 저장 or controller에서 file을 db에서조회해서 가져오기 -->
			<tr> <th>Num </th>  <td>${member.num}</td></tr>
			<tr> <th>ID </th>   <td>${member.id}</td> </tr>
			<tr> <th>Name </th> <td>${member.name}</td> </tr>
			<tr> <th>Email </th> <td>${member.email}</td></tr>
		</tr>
	
	</table>
	<div>
		<img alt="oriName" src="../resources/upload/member/${file.fileName}">
	</div>
	<a href="./memberUpdate" class="btn btn-primary">Update</a>
	<a href="./memberDelete" class="btn btn-danger">Delete</a>
</div>

</body>
</html>