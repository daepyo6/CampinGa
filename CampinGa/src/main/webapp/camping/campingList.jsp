<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<link href="camping/searchList.css" rel="stylesheet">
<script type="text/javascript" src="camping/campingList.js"></script>
<article>
	<!-- 지역 검색창 영역(예정) -->
	<div class="clear"></div>
	<div id="campSearch">
        <input type="text" id="key" placeholder="캠핑장 이름을 입력해주세요">
		<a href="#" onclick="searchCamp()"><img id="searchBtn" src="images/sBtn.png"></a>
    </div>
    <div class="clear"></div>
    <hr>
    <div id="searchResult">  
        <c:forEach items="${campList}" var="campVO">
        	<a href="camp.do?command=campDetail&bseq=${campVO.bseq}" >
		        <div id="campInfo">	        	
		            	<img id="campInfo_img" src="images/${campVO.image}">	            
		            <div id="campInfo_text">
		                <p>${campVO.cname}<br>
		                주소 : ${campVO.caddress1} ${campVO.caddress2} <br>
		                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${campVO.caddress3} <br>
		                카테고리 : ${campVO.category}<br>
		                편의시설 : ${campVO.facilities}</p>
		            </div>
		        </div>
	        </a>
        </c:forEach>
    </div>    
    <div class="clear"></div>
</article>
<%@ include file="../footer.jsp" %>