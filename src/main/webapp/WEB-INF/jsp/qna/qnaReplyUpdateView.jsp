<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	 	<title>게시판</title>
	</head>
	<script type="text/javascript">
		$(document).ready(function(){
			var formObj = $("form[name='updateForm']");
			
			$(".cancel_btn").on("click", function(){
				location.href = "/qna/qna_test?qna_Number=${qnaReplyUpdate.qna_Number}"
					  
			})
			
		})
		
	</script>
	<body>
	
		<div id="root">
			<header>
				<h1> 게시판</h1>
			</header>
			<hr />
			 
			
			<hr />
			
			<section id="container">
				<form name="updateForm" role="form" method="post" action="qnaReplyUpdate">
					<input type="hidden" name="qna_Number" value="${qnaReplyUpdate.qna_Number}" readonly="readonly"/>
					<input type="hidden" id="qna_rNumber" name="qna_rNumber" value="${qnaReplyUpdate.qna_rNumber}" />
					
					<table>
						<tbody>
							<tr>
								<td>
									<label for="content">댓글 내용</label><input type="text" id="qna_Detail" name="qna_Detail" value="${qnaReplyUpdate.qna_Detail}"/>
								</td>
							</tr>	
							
						</tbody>			
					</table>
					<div>
						<button type="submit" class="update_btn">저장</button>
						<button type="button" class="cancel_btn">취소</button>
					</div>
				</form>
			</section>
			<hr />
		</div>
	</body>
</html>