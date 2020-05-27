<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>게시판</title>
</head>
<script type="text/javascript">
	$(document).ready(function() {

		$(".cancel_btn").on("click", function() {
			event.preventDefault();
			location.href = "/qna/qna_list";
		})
	})
</script>
<body>

	<div id="root">
		<header>
			<h1>공지사항</h1>
		</header>
		<hr />

		<nav>홈 - 글 작성</nav>
		<hr />

		<section id="container">
			<form name="updateForm" role="form" method="post"
				action="/ex36/items/item_modify" enctype="multipart/form-data">
				<input type="hidden" name="item_Number" value="${modify.item_Number}"
					readonly="readonly" />
				<table>
					<tbody>
						<tr>
							<td><label for="title">상품명</label>
							<input type="text" id="item_Name" name="item_Name" value="${modify.item_Name}" /></td>
						</tr>
						<tr>
							<td><label for="title">판매자</label>
							<input type="text" id="item_Writer" name="item_Writer" value="${modify.item_Writer}" /></td>
						</tr>
						<tr>
							<td><label for="title">가격</label>
							<input type="text" id="item_Price" name="item_Price" value="${modify.item_Price}" /></td>
						</tr>
						<tr>
							<td><label for="title">거래선호위치</label>
							<input type="text" id="deal_location" name="deal_location" value="${modify.deal_location}" /></td>
						</tr>
						<tr>
							<td><label for="title">판매자 연락처</label>
							<input type="text" id="sales_Contact" name="sales_Contact" value="${modify.sales_Contact}" /></td>
						</tr>
						<tr>
							<td><label for="title">판매자 카카오id</label>
							<input type="text" id="sales_Kakaoid" name="sales_Kakaoid" value="${modify.sales_Kakaoid}" /></td>
						</tr>
						<tr>
							<td><label for="title">악기종류</label>
							<input type="text" id="item_Sort" name="item_Sort" value="${modify.item_Sort}" /></td>
						</tr>
					
						<tr>
							<td><label for="content">세부사항</label>
							<textarea id="item_Detail" name="item_Detail"><c:out value="${modify.item_Detail}" /></textarea></td>
						</tr>
						<tr>
						<td>
<div class="inputArea">
 <label for="gdsImg">이미지</label>
 <input type="file" id="item_Image" name="file" />
 <div class="select_img">
 <img src="<c:url value='/resources/${modify.item_Image}' />">
  <input type="hidden" name="item_Image" value="${modify.item_Image}" />
  <input type="hidden" name="item_Thumbimage" value="${modify.item_Thumbimage}" /> 
 </div>
 
 <script>
  $("#item_Image").change(function(){
   if(this.files && this.files[0]) {
    var reader = new FileReader;
    reader.onload = function(data) {
     $(".select_img img").attr("src", data.target.result).width(500);        
    }
    reader.readAsDataURL(this.files[0]);
   }
  });
 </script>
 
</div>
</td>
</tr>
					
					</tbody>
				</table>
				<div>
					<button type="submit" class="update_btn">저장</button>
					<button type="submit" class="cancel_btn">취소</button>
				</div>
			</form>
		</section>
		<hr />
	</div>
</body>
</html>