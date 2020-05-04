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
				location.href = "/items/item_readView?item_Number=${replyUpdate.item_Number}"
					  
			})
			
		})
		
	</script>
	<body>
	
		<div id="root">
			<header>
				<h1>댓글 수정</h1>
			</header>
			<hr />
			 
			
			<hr />
			
			<section id="container">
				<form name="updateForm" role="form" method="post" action="item_replyUpdate">
					<input type="hidden" name="item_Number" value="${replyUpdate.item_Number}" readonly="readonly"/>
					<input type="hidden" id="item_rNumber" name="item_rNumber" value="${replyUpdate.item_rNumber}" />
					
					<table>
						<tbody>
							<tr>
								<td>
									<label for="content">댓글 내용</label><textarea id="item_Detail" name="item_Detail" rows="10" cols="70" value="${replyUpdate.item_Detail}" ></textarea>
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