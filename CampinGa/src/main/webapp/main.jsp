<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>


<!-- 메인 이미지 시작 : 각기능별 페이지를 대표하는 이미지-->
<div id="main_img">
	<img src="images/main.png"  style="width:1198px; height:600px; 
				border-radius:20px 20px 20px 20px; border:2px solid white;"> 
</div>

<div id="main_searchbar">
	<div id="box">
	    <div class="searchbar">
	    	<span>지역별</span>
	    	<select name="" id="">
			    <option value="" selected="selected">전체/도</option>
			    <option value="1">서울시</option>
			    <option value="2">경기도</option>
			</select>
			<select name="" id="">
			    <option value="" selected="selected">전체/시/군</option>
			</select>
	    </div>
	    <div class="searchbar">
	    	<span>캠핑장명</span> 
	    	<input type="text" class="text" name="cname" size="20">
	    </div><br>
	    <input type="button" class="btn" value="검색">
    </div>
</div>






<!-- 신상품 -->
<h2>New! 새롭게 들어온 캠핑장</h2>
<div id="bestProduct">
	<c:forEach items="${newList}" var="productVO">
	
		<div id="item"> <!-- 상품 한개 , 한칸 -->
			<a href="camp.do?command=productDetail&pseq=${productVO.pseq}">
				<img src="product_images/${productVO.image}" />
				<h3>${productVO.name}	- <fmt:formatNumber value="${productVO.price2}" type="currency" /></h3>
			</a>
		</div>
		
	</c:forEach>
</div>


<!-- 베스트 상품 -->
<h2>Best! 제일 많이 방문하는 캠핑장</h2>
<div id="bestProduct">
	<c:forEach items="${bestList}" var="productVO">
	
		<div id="item"> <!-- 상품 한개 , 한칸 -->
			<a href="camp.do?command=productDetail&pseq=${productVO.pseq}">
				<img src="product_images/${productVO.image}" />
				<h3>${productVO.name}	- <fmt:formatNumber value="${productVO.price2}" type="currency" /></h3>
			</a>
		</div>
	</c:forEach>
</div>

<div class="clear"></div>


<%@ include file="footer.jsp" %>





