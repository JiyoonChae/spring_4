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
	
	<div>
	    <div class="form-group">
    	  <label for="writer">Writer:</label>
    	  <input type="text" class="form-control" value="${member.id}" id="writer" placeholder="Enter Writer" name="writer">
  	    </div>
    
    	<div class="form-group">
    	  <label for="contents">Contents:</label>
   	   <textarea class="form-control" rows="10" id="contents" name="contents"></textarea>
    	</div>
    
    <button type="submit" class="btn btn-default" id="write">Write</button>
	</div>
	
	<div>	
		<table id="result" class="table table-border">
		
		</table>
	</div>
	<button class="btn btn-danger del" id="more">더보기</button>
	
</div>
	<script type="text/javascript">	
		var curPage=1;
		getList();
		
		//******************more
		$("#more").click(function(){
			curPage++;  //1씩 증가 
			getList();
		})
		
		//******************del *********
		$("#result").on("click", ".del", function() {
			var num = $(this).attr("title");
			alert(num);
			//ajax통해서 post 방식으로 처리
			$.post("./memoDelete", {num:num}, function(data){
				data=data.trim();
				if(data>0){
					$("#result").html('');
					curPage=1;
					getList();
				}else {
					alert("delete fail")
				}
				
			})
		});
		//************************************************
			$("#write").click(function() {
			var writer = $("#writer").val();
			var contents = $("#contents").val();
		
			$.ajax({
				url:"./memoWrite",
				type:"post",
				data:{writer:writer, contents:contents},
				success: function(result) {
					alert(result);
					$("#writer").val('');
					$("#contents").val('');
					$("#result").html('');
					curPage=1;
					getList();
				}
			})
			
			$.post("./memoWrite", {writer:writer, contents:contents},function(result) {
				alert(result);
				$("#writer").val('');
				$("#contents").val('');
				getList();
			})
			
		})
		
		//*************************************************
		function getList(){
			$.ajax({
				url:"./memoList",
				type:"get",
				data:{curPage:curPage},
				success:function(data){
					$("#result").append(data);
				}
			})
		}
		//*********************************************
	

	</script>
</body>
</html>