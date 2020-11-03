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
   	   <textarea class="form-control" rows="20" cols="20" id="contents" name="contents"></textarea>
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
		
		$('#contents').summernote({
				height: 300, // set editor height
				callbacks: {
					onImageUpload: function(files, editor) {
						//이미지를 bit로 바꿔서 올리면 너무큰 데이터가 만들어짐
						var formData = new FormData(); //form태그를 객체로 만들기?
								//ajax로 form태그안에있는 파일을 보내려고함. 가상으로. 
							formData.append('file',files[0]); //파라미터이름 file, 0번째꺼 꺼내서 파라미터로 ajax로 보내겠다~
							
							$.ajax({
								type:"post",
								url:"./summernote",
								data:formData,
								enctype:"multipart/form-data",
								cache: false,
								contentType:false,
								processData: false,
								success: function(data){
									data=data.trim();
									$("#contents").summernote('editor.insertImage', data);
									
								}
								
							})//upload end
					},
					onMediaDelete: function(files) {
						var fileName = $(files[0]).attr("src");
						//fileName에서 파일명만 구해오기
						fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
						alert(fileName);//ajax로 보내서 지우기
						$.ajax({
							type:"post",
							url:"./summernoteDelete",
							data:{file:fileName},
							success: function(data){
								alert(data);
							}//success
						})//ajax
					}//delete
				}
		});
	
	//get summernote : 쓴 내용을 가지고올때
	$("#btn").click(function(){
		var contents = $("#contents").summernote('code');
		alert(contents);
	})
	
	//set은 미리 textarea에 집어넣고 시작하고싶을 때.
	var markupStr = 'hello world';
	$('#contents').summernote('code', markupStr);
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