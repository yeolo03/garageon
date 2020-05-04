<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="zxx">
<head>
	<title>SolMusic | HTML Template</title>
	<meta charset="UTF-8">
	<meta name="description" content="SolMusic HTML Template">
	<meta name="keywords" content="music, html">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<!-- Favicon -->
	<link href="img/favicon.ico" rel="shortcut icon"/>

	<!-- Google font -->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i&display=swap" rel="stylesheet">
 
	<!-- Stylesheets -->
	<link rel="stylesheet" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" href="css/font-awesome.min.css"/>
	<link rel="stylesheet" href="css/owl.carousel.min.css"/>
	<link rel="stylesheet" href="css/slicknav.min.css"/>

	<!-- Main Stylesheets -->
	<link rel="stylesheet" href="css/style.css"/>


	<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
	
	<style type="text/css">
			.pagi1 {list-style: none;float: left; padding: 6px;}
			.w_review{padding:0px 0px 0px 600px;}
			.review{padding:0px 0px 0px 600px;}
			#container{padding:0px 0px 0px 500px;}
		</style>
	
	<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	 	<title>QNA게시판</title>
	 	
	 	</style>
		
		<!-- 합쳐지고 최소화된 최신 CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<!-- 부가적인 테마 -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	</head>

</head>

<!--Start of Tawk.to Script-->
<script type="text/javascript">
var Tawk_API=Tawk_API||{}, Tawk_LoadStart=new Date();
(function(){
var s1=document.createElement("script"),s0=document.getElementsByTagName("script")[0];
s1.async=true;
s1.src='https://embed.tawk.to/5e8eb3f369e9320caac1c3f9/default';
s1.charset='UTF-8';
s1.setAttribute('crossorigin','*');
s0.parentNode.insertBefore(s1,s0);
})();
</script>
<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Header section -->
	<header class="header-section clearfix">
		<a href="index.html" class="site-logo">
			<img src="img/logo.png" alt="">
		</a>
		<div class="header-right">
		<a href="#" class="hr-btn">Contact</a>
		      <span>|</span>
			<a href="#" class="hr-btn">My page</a>
			<span>|</span>
			<div class="user-panel">
				<a href="" class="login">Login</a>
				<a href="" class="register">Create an account</a>
			</div> 
		</div>
		<ul class="main-menu">
			<li><a href="notice_list">Notice</a></li>
			<li><a href="list">Review</a></li>
			<li><a href="#">Item</a>
				<ul class="sub-menu">
					<li><a href="items/item_register">Sales</a></li>
					<li><a href="item_list">Buy</a></li>
				
				</ul>
			</li>
			<li><a href="qna_list">QNA</a></li>
			
			
			
		</ul>
	</header>
	<!-- Header section end -->

	
<div id="root">
			<header>
			<a href="/ex36/index">메인으로 가기</a>
				<h1 class=w_review> QnA</h1>
			</header>
			<hr />
			 
			<nav  class=w_review>
			  문의 주실 사항을 적어주세요
			</nav>
			<hr />
			<section id="container">
			<div class="container1">
				<form role="form" method="post" action="/ex36/qna/write">
					<table>
						<tbody>
							<tr>
								<td>
									<label for="qna_Subject">제목</label><input type="text" id="qna_Subject" name="qna_Subject" />
								</td>
							</tr>	
							<tr>
								<td>
									<label for="qna_Content">내용</label><textarea id="qna_Content" name="qna_Content"  rows="10" cols="70"></textarea>
								</td>
							</tr>
							<tr>
								<td>
									<label for="qna_Writer">작성자</label><input type="text" id="qna_Writer" name="qna_Writer" />
								</td>
								<tr>
								
							<tr>
								<td>						
									<button class="btn btn btn-info" type="submit">작성</button>
								</td>
							</tr>			
						</tbody>	
					</table>
				</form>
			</section>
			<br><br>
			<section id="container">
				<form role="form" method="post">
					
						
						<c:forEach items="${list}" var = "list1">
							
								"${list1.qna_Writer}"님이 포스트를 올렸습니다.<br/>
								${list1.qna_Date}<br/>
								
								<a href="/ex36/qna/qna_test?qna_Number=${list1.qna_Number}">마이페이지로 가서 글 확인하기</a>
								
							
						<br/>
						<hr>
						</c:forEach>
						
													
				</form>
			</section>
			
			<hr />
		</div>

	<!-- Footer section -->
	<footer class="footer-section">
		<div class="container">
			<div class="row">
				<div class="col-xl-6 col-lg-7 order-lg-2">
					<div class="row">
						<div class="col-sm-4">
							<div class="footer-widget">
								<h2>About us</h2>
								<ul>
									<li><a href="">Our Story</a></li>
									<li><a href="">Sol Music Blog</a></li>
									<li><a href="">History</a></li>
								</ul>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="footer-widget">
								<h2>Products</h2>
								<ul>
									<li><a href="">Music</a></li>
									<li><a href="">Subscription</a></li>
									<li><a href="">Custom Music</a></li>
									<li><a href="">Footage</a></li>
								</ul>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="footer-widget">
								<h2>Playlists</h2>
								<ul>
									<li><a href="">Newsletter</a></li>
									<li><a href="">Careers</a></li>
									<li><a href="">Press</a></li>
									<li><a href="">Contact</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-6 col-lg-5 order-lg-1">
					<img src="img/logo.png" alt="">
					<div class="copyright"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></div>
					<div class="social-links">
						<a href=""><i class="fa fa-instagram"></i></a>
						<a href=""><i class="fa fa-pinterest"></i></a>
						<a href=""><i class="fa fa-facebook"></i></a>
						<a href=""><i class="fa fa-twitter"></i></a>
						<a href=""><i class="fa fa-youtube"></i></a>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- Footer section end -->
	
	<!--====== Javascripts & Jquery ======-->
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.slicknav.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/mixitup.min.js"></script>
	<script src="js/main.js"></script>

	</body>
</html>
