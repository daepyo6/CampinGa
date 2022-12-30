<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<link href="camping/searchList.css" rel="stylesheet">
<script type="text/javascript" src="camping/campingList.js"></script>
<article>
	<!-- 지역 검색창 영역(예정) -->
	<div class="clear"></div>
	<div id="campSerch">
        <input type="text" name="nameKey" id="key" placeholder="검색할 캠핑장 이름을 입력해주세요">
		<a href="#" onclick="searchCamp()"><img id="searchBtn" src="images/sBtn.png"></a>
    </div>
    <div class="clear"></div>
    <hr>
    <div id="searchResult">  
        <c:forEach items="${campList}" var="campVO">
	        <div id="campInfo">
	        	<a href="camp.do?command=campdetail&cseq=${campVO.cseq}" >
	            	<img id="campInfo_img" src="images/camp02.jpg">
	            </a>
	            <div id="campInfo_text">
	            	<c:choose>
	                	<c:when test="${campVO.res_sta=='n'}"><span>예약불가능</span></c:when>
	                	<c:otherwise><span>예약가능</span></c:otherwise>
	                </c:choose><br>
	                <p>${campVO.cname} - ${campVO.c_class}<br>
	                가격 : ${campVO.price} 원 <br>
	                인원 : ${campVO.min_people} ~ ${campVO.max_people}명 <br>
	                편의시설 : ${campVO.facilities}</p>
	            </div>
	        </div>
        </c:forEach>
    </div>    
    <div class="clear"></div>
</article>
<%@ include file="../footer.jsp" %>