<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
<style type="text/css">
	.idCheck0 {
		color : blue;
	}
	.idCheck1 {
		color : red;
	}
</style>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container">
	<h3>Member Join page</h3>
	  <form action="./memberJoin" method="post">
    	<div class="form-group">
     	 <label for="id">ID:</label>
         <input type="text" class="form-control" id="id" placeholder="Enter ID" name="id">
         <div id="idResult"></div>
   		 </div>
   		 
	   
	     <div class="form-group">
	      <label for="pw">Password:</label>
	      <input type="password" class="form-control" id="pw" placeholder="Enter password" name="pw">
	    </div>
	    
	    <div class="form-group">
	      <label for="name">NAME:</label>
	      <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
	    </div>
	    
	    <div class="form-group">
	      <label for="email">Email:</label>
	      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
	    </div>
	    
     <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
	
	<script type="text/javascript">
		$("#id").blur(function(){
			var id = $(this).val();
			alert(id);
			$.get("./memberCheck?id="+id, function(data){
				//a사용가능, b사용불가 =>알려줘야함 가능불가능을
				//true가오면 사용가능, false불가는
				//0 사용가능, 1 사용불가
				data=data.trim();
				var str = "중복된 id 입니다";  //js니까 var로 선언..
				if(data==0){
					str="사용 가능한 id입니다"
					//클래스명 추가, 제외
					$("#idResult").addClass("idCheck0");
				}else{
					$("#idResult").addClass("idCheck1");
				}
				$("#idResult").html(str);
			})
		
		})
	</script>

</body>
</html>