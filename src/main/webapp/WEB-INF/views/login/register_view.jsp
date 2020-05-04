<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<!-- 합쳐지고 최소화된 최신 CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<!-- 부가적인 테마 -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	 	
	 	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<script type="text/javascript">
		$(document).ready(function(){
			// 취소
			$(".cencle").on("click", function(){
				
				location.href = "/login";
						    
			})
		
			$("#submit").on("click", function(){
				if($("#user_Id").val()==""){
					alert("아이디를 입력해주세요.");
					$("#userId").focus();
					return false;
				}
				if($("#user_Password").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#userPass").focus();
					return false;
				}
				if($("#user_Name").val()==""){
					alert("성명을 입력해주세요.");
					$("#userName").focus();
					return false;
				}
				if($("#user_Email").val()==""){
					alert("성명을 입력해주세요.");
					$("#user_Email").focus();
					return false;
				}
				else{
					
					alert("축하합니다.회원가입이 되셨습니다.");
				}
			});
			
				
			
		}) 	
	</script>
<body>
<h1>회원가입 페이지 입니다.</h1>
          <table width="500" cellpadding="0" cellspacing="0" >
		<form action="register" method="post">
		<div class="form-group has-feedback">
                <tr>
				<td> 아이디 </td>
				<td> <input class="form-control" type="text" id="userId" name="userId" /> </td>
			</tr>
			<br><br>
			</div>
		
			<div class="form-group has-feedback">
			<tr>
				<td> 비밀번호</td>
				<td> <input class="form-control" type="password" id="user_Password" name="user_Password" size = "50"> </td>
			</tr>
			
			</div>
			<div class="form-group has-feedback">
			<tr>
				<td> 이름</td>
				<td> <input class="form-control" type="text" id="user_Name" name="user_Name" size = "50"> </td>
			</tr>
			
			</div>
			<div class="form-group has-feedback">
			<tr>
				<td> 이메일 </td>
				<td> <input class="form-control" type="text" id="user_Email" name="user_Email" size = "50"> </td>
			</tr>
			</div>

				<td colspan="2"> <button class="btn btn-success" input type="submit"  id="submit">입력  </a></td>
			</tr>
		</form>
	</table>
</body>
</html>