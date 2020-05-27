<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		
		// 수정 
		var formObj = $("form[name='readForm']");
		$(".update_btn").on("click", function() {
			formObj.attr("action", "/items/item_modifyView");
			formObj.attr("method", "get");
			formObj.submit();
		})
		

		// 삭제
		$(".delete_btn").on("click", function() {
			
			  formObj.attr("action", "/items/item_delete");
				formObj.attr("method", "post");
				formObj.submit();
			
			
		})
		
		$(".replyWriteBtn").on("click", function(){
			  var formObj1 = $("form[name='replyForm']");
			  formObj1.attr("action", "/items/item_reply_witer");
			  formObj1.submit();
			  
			});
		
		//댓글 삭제 View
		$(".replyDeleteBtn").on("click", function(){
			location.href = "/items/item_replyDeleteView?=${read.item_Number}"
				+ "&item_rNumber="+$(this).attr("data-item_rNumber");
		});

		//댓글 수정 View
		$(".replyUpdateBtn").on("click", function(){
			location.href = "/items/item_replyUpdateView?=${read.item_Number}"
				+ "&item_rNumber="+$(this).attr("data-item_rNumber");
		});
		
		
})
/*
function fn_fileDown(fileNo){
			var formObj = $("form[name='readForm']");
			$("#FILE_NO").attr("value", fileNo);
			formObj.attr("action", "/fileDown");
			formObj.submit();
		}
		*/
	
</script>
<body>

				
			<section id="container">	
	<table width="1000" cellpadding="0" cellspacing="0" border="1" >
		<form name="readForm" method="post">
			<input type="hidden" name="item_Number" value="${read.item_Number}">
			<!--  
				<input type="hidden" id="page" name="page" value="${scri.page}"> 
					<input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}"> 
					<input type="hidden" id="searchType" name="searchType" value="${scri.searchType}"> 
					<input type="hidden" id="keyword" name="keyword" value="${scri.keyword}"> 
					<input type="hidden" id="FILE_NO" name="FILE_NO" value=""> 
					-->
			<tr>
				<td>상품명</td>
				<td>${read.item_Name}</td>
	
			</tr>
			<tr>
				<td>판매자</td>
				<td>${read.item_Writer}</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>
					${read.item_Price}</td>
			</tr>
			<tr>
				<td>세부사항</td>
				<td>
					${read.item_Detail}</td>
			</tr>
			<tr>
				<td>판매자 연락처</td>
				<td>
					${read.sales_Contact}</td>
			</tr>
			<tr>
				<td>판매자 카카오 id</td>
				<td>
					${read.sales_Kakaoid}</td>
			</tr>
			<tr>
				<td>거래선호 위치</td>
				<td>
					${read.deal_location}</td>
			</tr>
			<tr>
				<td>악기종류</td>
				<td>
					${read.item_Sort}</td>
			</tr>
			
			<tr>
				<td>작성날짜</td>
				<td>
					${read.item_Date}</td>
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
					<td colspan="2"><img src="<c:url value='/resources/${read.item_Image}' />" class="oriImg"></td>
          
				</div>
			</tr>	
			<tr>
			</tr>
            
			
		</form>


					
					</table>
					<div id="buttons">
				<button type="submit" class="update_btn btn btn-warning">수정</button>
				<button type="submit" class="delete_btn btn btn-danger">삭제</button>
			
			</div>
<br>					
<hr>
<br>
</form>
</section>

<div id="replyList">
  <ol class="replyList">
    <c:forEach items="${list}" var="list">
      <li>
        <p>
        
        작성자 :${list.item_reply_Writer} <br/>
        작성날짜 :${list.item_reply_Date} <br/> 
        
       작성내용: ${list.item_Detail}</p>
      

       <div>
 <button type="button" class="replyUpdateBtn" data-item_rNumber="${list.item_rNumber}">수정</button>
  <button type="button" class="replyDeleteBtn" data-item_rNumber="${list.item_rNumber}">삭제</button>
</div>

      </li>
    </c:forEach>   
  </ol>
</div>

<form name="replyForm" method="post">
  <input type="hidden" id="item_Number" name="item_Number" value="${read.item_Number}" />
  
  
<h1>댓글</h1>
  <div>
 <input type="text" id="item_reply_Writer" name="item_reply_Writer"  placeholder="작성자 를 입력하세요ex)구민호"/>
    <br/>
     <textarea id="item_Detail" name="item_Detail"  rows="10" cols="70" placeholder="댓글 내용을 입력하세요"></textarea>
  </div>
  <div>
 	 <button type="button" class="replyWriteBtn">작성</button>
  </div>
  
  
</form>

			<hr />
		</div>
	</body>
</html>
</body>
</html>