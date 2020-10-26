/**
 * comment
 */
 
 	$("#btn").click(function(){
			var t = $("#title").val();
			var w = $("#writer").val();
			var c = $("#contents").val();
			
			var ch1 = false;
			var ch2 = false;
			var ch3 = false;
			
			if(t != ''){
				ch1 = true;
			}
			
			if(w != ''){
				ch2 = true;
			}
			
			if(c != ''){
				ch3 = true;
			}
			
			if(ch1 && ch2 && ch3){
				alert("ok") //강제 form 태그의 submit이벤트 발생
				$("#frm").submit();
			}else {
				alert("fail")
			}
		});