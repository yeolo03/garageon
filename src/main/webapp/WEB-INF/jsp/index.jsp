 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    

<!DOCTYPE html>
<html>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function movetoNotice(){
	location.href="notice_list"
}
function movetoQna(){
	location.href="qna/qna_list"
}
function movetoItem(){
	location.href=""
}
function movetoReview(){
	location.href="list"
}
function movetoLogin(){
	location.href="login"
}
function movetoRegister(){
	location.href="/login/register_view"
}
</script>


<body>
<p align="right">
<audio autoplay controls> <source src="${pageContext.request.contextPath}/resources/a.mp3" type="audio/mp3"> </audio>
</p>
<h1>저희 홈페이지에 오신 것을 환영합니다</h1>
<input type="button" class="notice_btn" value="공지사항" onclick="movetoNotice()">
<input type="button" class="qna_btn" value="QnA게시판" onclick="movetoQna()">
<input type="button" class="review_btn" value="후기게시판" onclick="movetoReview()">
<input type="button" class="item_btn" value="상품등록" onclick="movetoItem()"> 
<input type="button" class="login_btn" value="로그인" onclick="movetoLogin()">

 
<br>
<img src="${pageContext.request.contextPath}/resources/20200313172407.png">
	  <!--  <img src="<c:url value='/mp/0d547a5f0d174fb496b81c242ac769f0.jpg'/>">
  <a href="<c:url value="/ex45/mp/0d547a5f0d174fb496b81c242ac769f0.jpg"/>"></a>
-->
</body>
</html>