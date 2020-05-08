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
			location.href = "/ex36/notice_list";
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
				action="/ex36/notice_modify" enctype="multipart/form-data">
				<input type="hidden" name="notice_Number" value="${modify1.notice_Number}"
					readonly="readonly" />
				<table>
					<tbody>
						<tr>
							<td><label for="title">제목</label>
							<input type="text" id="notice_Subject" name="notice_Subject" value="${modify1.notice_Subject}" /></td>
						</tr>
				
						<tr>
							<td><label for="content">내용</label>
							<textarea id="notice_Content" name="notice_Content"><c:out value="${modify1.notice_Content}" /></textarea></td>
						</tr>
<tr>
<td>
		<div class="inputArea">
 <label for="gdsImg">이미지</label>
 <input type="file" id="notice_Image" name="file" />
 <div class="select_img">
 <img src="<c:url value='/resources/${modify1.notice_Image}' />">
  <input type="hidden" name="item_Image" value="${modify1.notice_Image}" /> 
 </div>
 
 <script>
  $("#notice_Image").change(function(){
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