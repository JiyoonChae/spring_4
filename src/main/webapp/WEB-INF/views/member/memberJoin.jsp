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
	  <form action="./memberJoin" method="post" id="frm" enctype="multipart/form-data">
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
	      <label for="pw2">Password:</label>
	      <input type="password" class="form-control" id="pw2" placeholder="Enter password" name="pw2">
	    	<div id="pwResult"></div>
	    </div>
	    
	    
	    <div class="form-group">
	      <label for="name">NAME:</label>
	      <input type="text" class="form-control empty" id="name" placeholder="Enter name" name="name">
	    	<div class="emptyResult"></div>
	    </div>
	    
	    <div class="form-group">
	      <label for="email">Email:</label>
	      <input type="email" class="form-control empty" id="email" placeholder="Enter email" name="email">
	    	<div class="emptyResult"></div>
	    </div>
	    
	        <div class="form-group">
	      <label for="photo">Photo:</label>
	      <input type="file" class="form-control" id="photo" name="photo">
	    
	    </div>
	    <input type="button" value="Join" class="btn btn-default" id="join">
    	<button>test join</button>
  </form>
</div>
	
	<script type="text/javascript">
	var idCheck = false;
	var pwCheck = false;
	var emptyCheckResult = true;
		$("#join").click(function(){
			emptyCheck()
			//중복체크했고, 사용가능한 id이면 - server로 보내기
			if(idCheck && pwCheck && emptyCheckResult){
				$("#frm").submit();
			}
			//else{
			//중복체크를 안했거나, 사용불가한 id이면
			//alert("no");
			//}
			
		})
	
	//****************Empty check : name, email.. etc
	function emptyCheck() {
			emptyCheckResult = true;
			$(".emptyResult").removeClass("idCheck0")
			$(".emptyResult").html('')  //input 비워주기
			$(".empty").each(function(){
				var data = $(this).val()
				
				if(data ==''){
					emptyCheckResult = false;
					$(this).next().html("필수 항목 입니다")
					$(".emptyResult").addClass("idCheck1")
				}
			});
			
		}
	
	
	//*******************pw check ********
	 $("#pw2").blur(function(){
		 var pw = $("#pw").val();
		 var pw2 = $(this).val();
		 pwCheck=false;
		 if(pw2==''){
			 $("#pwResult").html("Password를 입력하세요");
			 $("#pwResult").removeClass("idCheck0").addClass("idCheck1");
		 }else if(pw==pw2){
			 $("#pwResult").html("Password가 일치 합니다")
			 $("#pwResult").removeClass("idCheck1").addClass("idCheck0");
			 pwCheck = true;
		 }else{
			 $("#pwResult").html("Password가 일치하지 않습니다");
			 $("#pwResult").removeClass("idCheck0").addClass("idCheck1");
			 
		 }
		 
	 })
	
	
	//***********id check **********************	
		$("#id").blur(function(){		//포커스줬다가 뺄때 =blur
			var id = $(this).val();		//input태그에 입력한 값 가져오기
			//alert(id);
			if(id !=''){		
				$.ajax({
					url:"./memberCheck",
					type:"get",   //method
					data:{id:id},  //파라미터, 두개이상이면 ,로 연결 
					success:function(data){
						data=data.trim();			//빈칸이 있을 수도 있으니 사전작업해줌 
						var str = "중복된 id 입니다";  //js니까 var로 선언..! 
						if(data==0){				//db가서 테이블안에 id와 체크후 리턴값이 null이면 0, null이아니면 1
							str="사용 가능한 id입니다"	//null이면 기존에 생성된 id가 없으니까 사용가능.
							idCheck=true;
							//클래스명 추가, 제외
							$("#idResult").removeClass("idCheck1").addClass("idCheck0");
						}else{
							$("#idResult").addClass("idCheck1");
							idCheck=false;
						}
						$("#idResult").html(str);
					} //성공시 실행할 함수
				})
			}else{
				//아무것도 입력안하면 실행될 이벤트
				$("#idResult").html("id를 입력하세요");
				$("#idResult").addClass("idCheck1");
			}
		});
	
		
	</script>

</body>
</html>