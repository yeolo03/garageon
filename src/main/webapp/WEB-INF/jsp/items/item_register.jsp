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
				<h1>상품등록</h1>
			</header>
			<hr />
			 
			<nav>
			  홈 - 글 작성
			</nav>
			<hr />
			
			<section id="container">
				<form role="form" method="post" action="/items/write" enctype="multipart/form-data">
					<table>
						<tbody>
							<tr>
								<td>
									<label for="item_Name">상품명</label><input type="text" id="item_Name" name="item_Name" />
								</td>
							</tr>	
							<tr>
								<td>
									<label for="item_Writer">판매자</label><input tpye="text" id="item_Writer" name="item_Writer" ></textarea>
								</td>
							</tr>
							<tr>
								
								<tr>
								<td>
									<label for="item_Price">가격</label><input type="text" id="item_Price" name="item_Price" />
								</td>
								</tr>
								<tr>
								<td>
									<label for="item_Sort">악기종류</label><input type="text" id="item_Sort" name="item_Sort" />
								</td>
								</tr>
								<tr>
								<td>
									<label for="sales_Contact">판매자 연락처</label><input type="text" id="sales_Contact" name="sales_Contact" />
								</td>
								</tr>
								<tr>
								<td>
									<label for="sales_Kakaoid">판매자 카카오id</label><input type="text" id="sales_Kakaoid" name="sales_Kakaoid" />
								</td>
								</tr>
								<tr>
								<td>
									<label for="deal_location">거래선호위치</label><input type="text" id="deal_location" name="deal_location" />
								</td>
								
								
								<tr>
								<td>
									<label for="item_Detail">세부사항</label><textarea id="item_Detail" name="item_Detail"  rows="10" cols="70"></textarea>
								</td>
								</tr>
								
								<tr>
								<td>
						
								</td>
								</tr>
								<tr>
								
								<td>
								
								<div class="inputArea">
                        <label for="gdsImg">이미지</label>
 						<input type="file" id="item_Image" name="file" />
 						<div class="select_img"><img src="" /></div>
 
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