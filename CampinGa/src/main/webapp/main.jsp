<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div id="main_img">
	<img id="mainImg" src="images/main.png"> 	
</div>
<div id="main_searchbar">
	<div id="selects">
	    <div id="selectAddress">
	    	<span>지역별</span>
	    	<select name="address1" class="selectAd" onchange="chDo(this.value)">
			    <option selected="selected">도/시 선택</option>
	            <option value='1'>서울</option>
	            <option value='2'>부산</option>
	            <option value='3'>대구</option>
	            <option value='4'>인천</option>
	            <option value='5'>광주</option>
	            <option value='6'>대전</option>
	            <option value='7'>울산</option>
	            <option value='8'>강원</option>
	            <option value='9'>경기</option>
	            <option value='10'>경남</option>
	            <option value='11'>경북</option>
	            <option value='12'>전남</option>
	            <option value='13'>전북</option>
	            <option value='14'>제주</option>
	            <option value='15'>충남</option>
	            <option value='16'>충북</option>
			</select>
			<select name="address2" class="selectAd" id="gungu">
			    <option value="0" selected="selected">시/군/구 선택</option>
			</select>
			<!-- 시/군/구 value는 한글 그대로임 -->
	    </div><br>
	    <div id="searchName">
	    	<span>캠핑장명</span> 
	    	<input type="text" id="inputText" name="cname" size="20">
	    	<input type="button" id="mainBtn" value="검색">
	    </div>
	    
    </div>    
</div>
<!-- new 캠핑장 -->
<div id="bestProduct" class="capingLine">
	<h2>New! 새롭게 들어온 캠핑장</h2>
	<c:forEach items="${newList}" var="productVO">
	
		<div id="item"> <!-- 상품 한개 , 한칸 -->
			<a href="camp.do?command=productDetail&pseq=${productVO.pseq}">
				<img src="product_images/${productVO.image}" />
				<h3>${productVO.name}	- <fmt:formatNumber value="${productVO.price2}" type="currency" /></h3>
			</a>
		</div>
		
	</c:forEach>
</div>

<!-- 추천 캠핑장 -->
<div id="bestProduct">
	<h2>Best! 제일 많이 방문하는 캠핑장</h2>
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
