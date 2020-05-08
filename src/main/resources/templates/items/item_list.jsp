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

<title>게시판</title>
	 	<style type="text/css">
			.pagi1 {list-style: none;float: left; padding: 6px;}
			.w_review{padding:0px 0px 0px 700px;}
			.search{padding:0px 0px 0px 600px;}
			.review{padding:0px 0px 0px 600px;}
			.paging1{padding:0px 0px 0px 700px;}
			.oriImg{width:250px;height:220px;margin-left:50px;}
			.item{padding:0px 0px 0px 110px;}
			
		</style>
		
		<!-- 합쳐지고 최소화된 최신 CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<!-- 부가적인 테마 -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
</head>
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

	

		<body>
		<div id="root">
			<header>
				<h1 class="w_review">중고 악기 거래</h1>
			</header>
			<hr />
			 
			<nav class="w_review">
			  중고 악기 거래 페이지입니다.
			</nav>
			<hr />
			
			<section id="container">
				<form role="form" method="get">
					<table>
						<%
						int newLine=0;
						int aC=0;
						%>
						
						
						<c:forEach items="${list}" var = "list">
					
					<%
						if(newLine==0){
							
							out.print("<tr>");
						}
						newLine++;
						aC++;
						%>		
							 <td><a href="/ex36/items/item_readView?item_Number=${list.item_Number}">
							 <img src="<c:url value='/resources/${list.item_Thumbimage}' />" class="oriImg"><br>
							 <div class=item> ${list.item_Name}<br>
							 ${list.item_Price}원 </a></div>
							
							 </td>
							<%
							if(newLine==5){
								out.print("</tr>");
								newLine=0;
							}
							%> 
						
						</c:forEach>
						
					
					
	
	</table>
	</tr>
	<div class="search">
    <select name="searchType">
      <option value="a"<c:out value="${scri.searchType == null ? 'selected' : ''}"/>>-----</option>
      <option value="n"<c:out value="${scri.searchType eq 'n' ? 'selected' : ''}"/>>상품이름</option>
      <option value="w"<c:out value="${scri.searchType eq 'w' ? 'selected' : ''}"/>>상품판매자</option>
      <option value="s"<c:out value="${scri.searchType eq 's' ? 'selected' : ''}"/>>상품종류</option>
    </select>

    <input type="text" name="keyword" id="keywordInput" value="${scri.keyword}"/>

    <button class="searchBtn" type="button">검색</button>
    <script>
      $(function(){
        $('#searchBtn').click(function() {
        	 self.location = "list" + '${pageMaker.makeQuery(1)}' + "&searchType=" + $("select option:selected").val() + "&keyword=" + encodeURIComponent($('#keywordInput').val());
        });
      });   
    </script>
  </div>
					
					
					<div class=paging1>
  <ul class="pagination">
    <c:if test="${pageMaker.prev}">
    	<li class="pagi1"><a href="item_list${pageMaker.makeSearch(pageMaker.startPage - 1)}">이전</a></li>
    </c:if> 

    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
    	<li class="pagi1"><a href="item_list${pageMaker.makeSearch(idx)}">${idx}</a></li>
    </c:forEach>

    <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
    	<li class="pagi1"><a href="item_list${pageMaker.makeSearch(pageMaker.endPage + 1)}">다음</a></li>
    </c:if> 
  </ul>
</div>
					

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
