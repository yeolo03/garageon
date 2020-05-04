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
			location.href = "/ex36/qna_list";
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
				action="/ex36/qna_modify">
				<input type="hidden" name="qna_Number" value="${modify.qna_Number}"
					readonly="readonly" />
				<table>
					<tbody>
						<tr>
							<td><label for="title">제목</label>
							<input type="text" id="qna_Subject" name="qna_Subject" value="${modify.qna_Subject}" /></td>
						</tr>
					
						<tr>
							<td><label for="content">내용</label>
							<textarea id="qna_Content" name="qna_Content"><c:out value="${modify.qna_Content}" /></textarea></td>
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