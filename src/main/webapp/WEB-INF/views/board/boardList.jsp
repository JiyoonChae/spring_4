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
  <h1>NOTICE LIST JSP PAGE</h1>
  <!-- ****************검색 search 기능 ***************** -->
   <div class="row">
  <div class="col-sm-5">
  <form action="./${board}List" id="frm">
  	<input type="hidden" name="curPage" id="curPage">
       <div class="input-group">
        <select class="form-control" id="kind" name="kind" >
    			<option value="tt">Title</option>
    			<option value="wr">Writer</option>
    			<option value="con">Contents</option>
   				 
  		</select>
        <span class="input-group-addon">Text</span>
        <input id="search" type="text" class="form-control" name="search" placeholder="Additional Info">
        <div class="input-group-btn">
              <button class="btn btn-default" type="submit">
            <i class="glyphicon glyphicon-search"></i>
              </button>
        </div>
      </div>
      
  </form>
  </div>
  </div>
  
  <table class="table table-hover">
  	<tr>
  		<td>Num</td>
  		<td>Title</td>
  		<td>Writer</td>
  		<td>Contents</td>
  		<td>Date</td>
  		<td>Hit</td>
  	</tr>
  	
  <c:forEach items="${list}" var="ar" varStatus="vs">
  <tr>
 	<td>${ar.num } : ${vs.first}</td>
  	<td>
  	<a href="./${board}Select?num=${ar.num}">
  	<c:forEach begin="1" end="${ar.depth}">--</c:forEach>
  	 ${ar.title }</a>
  	</td>
  	<td>${ar.writer }</td>
    <td>${ar.contents }</td>
  	<td>${ar.regDate }</td>
    <td>${ar.hit }</td>
  	</tr>
  </c:forEach>
  

 </table>
	
	<div>
	   <c:if test="${pager.beforeCheck }">
			<a href="./${board}List?curPage=${pager.startNum-1 }">[이전]</a>
		</c:if>
		
		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i"> 
		<a href="./${board}List?curPage=${i}"> ${i }</a> </c:forEach>
		
		<c:if test="${pager.nextCheck}">
		<a href="./${board}List?curPage=${pager.lastNum+1}"> [다음]</a> 
		</c:if>
	
	</div>
	
	
		
	
	
	<a href="./${board}Write" class="btn btn-danger">Write</a>

</div>
	
	
</body>
</html>