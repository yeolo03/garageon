<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	 	<title>게시판</title>
	</head>
	<body>
	
		<div id="root">
			<header>
				<h1>공지사항</h1>
			</header>
			<hr />
			 
			<nav>
			  홈 - 글 작성
			</nav>
			<hr />
			
			<section id="container">
				<form role="form" method="post" action="/notice/write" enctype="multipart/form-data">
					<table>
						<tbody>
							<tr>
								<td>
									<label for="title">제목</label><input type="text" id="notice_Subject" name="notice_Subject" />
								</td>
							</tr>	
							<tr>
								<td>
									<label for="content">내용</label><textarea id="notice_Content" name="notice_Content"  rows="10" cols="70"></textarea>
								</td>
							</tr>
							<tr>
								

								<tr>
								<td>
								<div class="inputArea">
                        <label for="gdsImg">이미지</label>
 						<input type="file" id="notice_Image" name="file" />
 						<div class="select_img"><img src="" /></div>
 
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
 				
 				<%=request.getRealPath("/") %><br>
 				
 				<button type="submit">작성</button>
 				</td>
 				
 				</tr>
 				<tr>
 	
                  </div>
								</td>
							</tr>			
						</tbody>			
					</table>
				</form>
			</section>
			<hr />
		</div>
	</body>
</html>