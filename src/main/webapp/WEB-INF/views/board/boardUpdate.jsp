<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:import url="../template/bootStrap.jsp"></c:import>
	<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>


	<div class="container">
  	 <h2>${board} Update Form</h2>
  	 
  	  <form action="./${board}Update" method="post" id="frm">
  	  	<input type="hidden" name="num" value="${dto.num}">
	   	 <div class="form-group">
	      <label for="title">Title:</label>
	      <input type="text" class="form-control" value="${dto.title}" id="title" placeholder="Enter Title" name="title">
	     </div>
    
    	 <div class="form-group">
    	   <label for="writer">Writer:</label>
    	   <input type="text" class="form-control" readonly="readonly" value="${dto.writer}" id="writer" placeholder="Enter Writer" name="writer">
  	     </div>
    
    	<div class="form-group">
    	  <label for="contents">Contents:</label>
   	   <textarea class="form-control" rows="10" id="contents" name="contents">${dto.contents}</textarea>
    	</div>
    
   <!-- <input type="button" class="btn btn-primary" value="Update" id="btn">  -->
   <button type="submit" class="btn btn-default">Update</button> 
  </form>
</div>
	<script type="text/javascript" >
		//src="../resources/js/boardWrite.js" 하나라도없으면 글안써지게하는 기능,,
	 	$('#contents').summernote({
				height: 300,                 // set editor height
		});

		var markupStr = $('#contents').summernote('code');
		$('#contents').summernote('code', markupStr);
	</script>

</body>
</html>