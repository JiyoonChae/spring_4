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
	 <h1>Memo PAGE</h1>
	 <form action="./memoTest">
	 	<button id="btn" class="btn btn-danger">click</button>
	</form>
	</div>
	
	<script type="text/javascript">
		$("#btn").click(function() {
			location.href="./memoTest";
		})
	</script>
</body>
</html>