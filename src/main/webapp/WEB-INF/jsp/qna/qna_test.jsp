<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	 	<title>게시판</title>
	</head>
	<script type="text/javascript">
$(document).ready(function() {
		$(".replyWriteBtn").on("click", function(){
			  var formObj1 = $("form[name='replyForm']");
			  formObj1.attr("action", "/ex36/qnaReplyWrite");
			  formObj1.submit();
			  
			});
		

//댓글 삭제 View
$(".replyDeleteBtn").on("click", function(){
	location.href = "/ex36/qna/qnaReplyDeleteView?=${read1.qna_Number}"
		+ "&qna_rNumber="+$(this).attr("data-qna_rNumber");
});

//댓글 수정 View
$(".replyUpdateBtn").on("click", function(){
	location.href = "/ex36/qna/qnaReplyUpdateView?=${read1.qna_Number}"
		+ "&qna_rNumber="+$(this).attr("data-qna_rNumber");
});


//수정 
var formObj = $("form[name='qnaform']");
$(".update_btn").on("click", function() {
	formObj.attr("action", "/ex36/qna/modifyView");
	formObj.attr("method", "get");
	formObj.submit();
})


// 삭제
$(".delete_btn").on("click", function() {
	
	  formObj.attr("action", "/ex36/qna_delete");
		formObj.attr("method", "post");
		formObj.submit();
	
	
})
		
});

</script>
	<body>
	
		<div id="root">
			<header>
				<h1> 마이페이지</h1>
			</header>
			<hr />
			
			<section id="container">
			<table>
				<form name="qnaform" method="post">
					<input type="hidden" name="qna_Number" value="${read1.qna_Number}">
						<tbody>
							<h3>문의 주신 내용</h3>
								<td>
									제목:<br>
									 "${read1.qna_Subject}"
									 								</td>
							</tr>	
							<tr>
								<td>
									내용:<br>
									"${read1.qna_Content}"
								</td>
							</tr>
							
							
						</tbody>			
					</table>
					 <div>
				<button type="submit" class="update_btn">수정</button>
				<button type="submit" class="delete_btn">삭제</button>
			
			</div>
				</form>
				
			</section>
			
<div id="replyList">
  <ol class="replyList">
    <c:forEach items="${list}" var="list">
      <li>
        <p>
        
        작성자 :${list.qna_Name} <br/>
        작성날짜 :${list.qna_reply_Date} <br/> 
        
       작성내용: ${list.qna_Detail}</p>
      

       <div>
 <button type="button" class="replyUpdateBtn" data-qna_rNumber="${list.qna_rNumber}">수정</button>
  <button type="button" class="replyDeleteBtn" data-qna_rNumber="${list.qna_rNumber}">삭제</button>
</div>

      </li>
    </c:forEach>   
  </ol>
</div>

<form name="replyForm" method="post">
  <input type="hidden" id="qna_Number" name="qna_Number" value="${read1.qna_Number}" />
  
  
<h1>댓글</h1>
  <div>
 <input type="text" id="qna_Name" name="qna_Name"  placeholder="작성자 를 입력하세요ex)구민호"/>
    <br/>
     <textarea id="qna_Detail" name="qna_Detail"  rows="10" cols="70" placeholder="댓글 내용을 입력하세요"></textarea>
  </div>
  <div>
 	 <button type="button" class="replyWriteBtn">작성</button>
  </div>
  
  
</form>

			<hr />
		</div>
	</body>
</html>