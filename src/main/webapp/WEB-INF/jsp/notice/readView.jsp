<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.oriImg{width:900px;height:400px;}
		</style>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
	<!-- 합쳐지고 최소화된 최신 CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<!-- 부가적인 테마 -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
		
<title>Insert title here</title>
</head>

<script type="text/javascript">
$(document).ready(function() {
		
		// 수정 
		var formObj = $("form[name='readForm']");
		$(".update_btn").on("click", function() {
			formObj.attr("action", "/notice/modifyView");
			formObj.attr("method", "get");
			formObj.submit();
		})
		

		// 삭제
		$(".delete_btn").on("click", function() {
			
			  formObj.attr("action", "/notice_delete");
				formObj.attr("method", "post");
				formObj.submit();
			
			
		})
		
})

	
</script>
<body>

				
			<section id="container">	
	<table width="900" cellpadding="0" cellspacing="0" border="1" >
		<form name="readForm" method="post">
			<input type="hidden" name="notice_Number" value="${read.notice_Number}">
				<input type="hidden" id="page" name="page" value="${scri.page}"> 
					<input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}"> 
					<input type="hidden" id="searchType" name="searchType" value="${scri.searchType}"> 
					<input type="hidden" id="keyword" name="keyword" value="${scri.keyword}"> 
					<input type="hidden" id="FILE_NO" name="FILE_NO" value=""> 
			<tr>
				<td>번호</td>
				<td>${read.notice_Number}</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${read.notice_Readcount}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>
					${read.notice_Subject}</td>
			</tr>
		
			
		
			<hr>
			<tr>
				
				<div class="form-group" >
				<!-- 
					<td><c:forEach var="file" items="${file}">
						<a href="#" onclick="fn_fileDown('${file.FILE_NO}'); return false;">${file.ORG_FILE_NAME}</a>(${file.FILE_SIZE}kb)</td><br>
					
					</c:forEach>
					-->
					<!--  <td><img src="resources/imgUpload/20200213-8.PNG" class="oriImg"/></td>-->
				
					<td colspan="2"><img src="<c:url value='/resources/${read.notice_Image}' />" class="oriImg"></td>
           
				</div>
			</tr>	
			<tr>
				
				<td colspan="2"><textarea rows="10" cols="128">${read.notice_Content}</textarea></td>
			</tr>
			<tr>
			</tr>
            <div>
				<button type="submit" class="update_btn btn btn-warning">수정</button>
				<button type="submit" class="delete_btn btn btn-danger">삭제</button>
			
			</div>
			
		</form>


					
					</table>
<br>					
<hr>
<br>
</form>
</section>
</body>
</html>