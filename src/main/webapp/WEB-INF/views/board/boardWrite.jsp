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
    .del {
        color: red;
        font-weight: bold;
    }
    
    #f{
    	display:none;
    }
    
    .del {
    	cursor: pointer;
    }
</style>
</head>

<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container">
  <h2>${board} Write Form</h2>
  	<form action="./${board}Write" method="post" id="frm" enctype="multipart/form-data">
   	 <div class="form-group">
      <label for="title">Title:</label>
      <input type="text" class="form-control" id="title" placeholder="Enter Title" name="title">
     </div>
    
    	<div class="form-group">
    	  <label for="writer">Writer:</label>
    	  <input type="text" class="form-control" readonly="readonly" value="${member.id}" id="writer" placeholder="Enter Writer" name="writer">
  	    </div>
    
    	<div class="form-group">
    	  <label for="contents">Contents:</label>
   	   <textarea class="form-control" rows="10" id="contents" name="contents"></textarea>
    	</div>
    	
    	<input type="button" value="FileAdd" class="btn btn-info" id="fileAdd">
    	<div id="files">
    	
    	</div>
    
    	<div class=form-group>
  		  <input type="button" class="btn btn-primary" value="Write" id="btn">
   		 <button type="submit" class="btn btn-default">Write</button>
  	    </div>
 
 	<div id = "f">
    		<div class="input-group">
      		  <input id="files" type="file" class="form-control" name="files">
      		  <span class="input-group-addon del">DEL</span>
     		 </div>
 	</div>
 	
  </form>
</div>

	<script type="text/javascript" > //제이쿼리쓰는거 -EVENT
		//src 경로써서 script파일 가져오기 src="../resources/js/boardWrite.js"
		
		var count=0;
		$("#fileAdd").click(function() {
			
			//$("#files").append(f);
			
			if(count<5) {
				var f = $("#f").html().trim();
				$("#files").append(f);
				count++;
			}else{
				alert("파일은 5개까지 가능합니다")
			}
			
		})
		
		$("#files").on("click", ".del", function(){
			alert("del");
			$(this).parent().remove();
			count--;	
		})
		
	</script>
</body>
</html>