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
				<h1>댓글 삭제</h1>
			</header>
			<hr />
			 

			<hr />
			
			<section id="container">
				<form name="updateForm" role="form" method="post" action="item_replyDelete">
					<input type="hidden" name="item_Number" value="${replyDelete.item_Number}" readonly="readonly"/>
					<input type="hidden" id="item_rNumber" name="item_rNumber" value="${replyDelete.item_rNumber}" />
						
					<div>
						<p>삭제 하시겠습니까?</p>
						<button type="submit" class="delete_btn">예 삭제합니다.</button>
						<button type="button" class="cancel_btn">아니오. 삭제하지 않습니다.</button>
					</div>
				</form>
			</section>
			<hr />
		</div>
	</body>
</html>