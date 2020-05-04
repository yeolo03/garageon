<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.oriImg{width:1000px;height:400px;}
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
		$(".replyWriteBtn").on("click", function(){
			  var formObj1 = $("form[name='replyForm']");
			  formObj1.attr("action", "/ex36/replyWrite");
			  formObj1.submit();
			  
			});
		//댓글 수정 View
		$(".replyUpdateBtn").on("click", function(){
			location.href = "/ex36/replyUpdateView?bno=${read.bno}"
				+ "&page=${scri.page}"
				+ "&perPageNum=${scri.perPageNum}"
				+ "&searchType=${scri.searchType}"
				+ "&keyword=${scri.keyword}"
				+ "&rno="+$(this).attr("data-rno");
							
		});
		//댓글 삭제 View
		$(".replyDeleteBtn").on("click", function(){
			location.href = "/ex36/replyDeleteView?bno=${read.bno}"
				+ "&page=${scri.page}"
				+ "&perPageNum=${scri.perPageNum}"
				+ "&searchType=${scri.searchType}"
				+ "&keyword=${scri.keyword}"
				+ "&rno="+$(this).attr("data-rno");
		});
		
		// 수정 
		var formObj = $("form[name='readForm']");
		$(".update_btn").on("click", function() {
			formObj.attr("action", "/ex36/board/modifyView");
			formObj.attr("method", "get");
			formObj.submit();
		})
		

		// 삭제
		$(".delete_btn").on("click", function() {
			
			  formObj.attr("action", "/ex36/delete");
				formObj.attr("method", "post");
				formObj.submit();
			
			
		})
		
})

function fn_fileDown(fileNo){
			var formObj = $("form[name='readForm']");
			$("#FILE_NO").attr("value", fileNo);
			formObj.attr("action", "/ex36/fileDown");
			formObj.submit();
		}
		
	
</script>
<body>

				
			<section id="container">	
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form name="readForm" method="post">
			<input type="hidden" name="bno" value="${read.bno}">
				<input type="hidden" id="page" name="page" value="${scri.page}"> 
					<input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}"> 
					<input type="hidden" id="searchType" name="searchType" value="${scri.searchType}"> 
					<input type="hidden" id="keyword" name="keyword" value="${scri.keyword}"> 
					<input type="hidden" id="FILE_NO" name="FILE_NO" value=""> 
			<tr>
				<td>번호</td>
				<td>${read.bno}</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${read.readCount}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${read.writer}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>
					${read.title}</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>
					${read.review_Email}</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					${read.review_Password}</td>
			</tr>
			
			
			<tr>
				<td>내용</td>
				<td><textarea rows="10">${read.content}</textarea></td>
			</tr>
		
			<hr>
			<tr>
				<td colspan="2">
				<div class="form-group" >
					<c:forEach var="file" items="${file}">
						
							<a href="#" onclick="fn_fileDown('${file.FILE_NO}'); return false;">${file.ORG_FILE_NAME}</a>(${file.FILE_SIZE}kb)<br>
						<!--  <img src="<c:url value='/mp/0a30e68a88f84d15938c16fe404bf113.jpg'/>">-->
						
						  <img src="<c:url value='/resources/${read.review_Image}' />" class="oriImg">

					</c:forEach></td>
				</div>
				
			</tr>	
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
<!-- 댓글 -->
<div id="replyList">
  <ol class="replyList">
    <c:forEach items="${replyList}" var="replyList">
      <li>
        <p>
        작성자 :${replyList.writer} <br/>
        작성날짜 :${replyList.regdate} <br/> 
        
       작성내용: ${replyList.content}</p>
      

       <div>
 <button type="button" class="replyUpdateBtn btn btn-warning" data-rno="${replyList.rno}">수정</button>
  <button type="button" class="replyDeleteBtn btn btn-danger" data-rno="${replyList.rno}">삭제</button>
</div>

      </li>
    </c:forEach>   
  </ol>
</div>

<form name="replyForm" method="post">
  <input type="hidden" id="bno" name="bno" value="${read.bno}" />
  <input type="hidden" id="page" name="page" value="${scri.page}"> 
  <input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}"> 
  <input type="hidden" id="searchType" name="searchType" value="${scri.searchType}"> 
  <input type="hidden" id="keyword" name="keyword" value="${scri.keyword}">
  

<h1>댓글</h1>
  <div>
 <input type="text" id="writer" name="writer"  placeholder="작성자 를 입력하세요ex)구민호"/>
    <br/>
     <textarea id="content" name="content"  rows="10" cols="70" placeholder="댓글 내용을 입력하세요"></textarea>
  </div>
  <div>
 	 <button type="button" class="replyWriteBtn btn btn-success">작성</button>
  </div>
</form>
</section>
</body>
</html>