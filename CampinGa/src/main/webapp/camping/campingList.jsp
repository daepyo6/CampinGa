<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<link href="searchList.css" rel="stylesheet">
	<div id="campSerch">
        <input type="text" name="nameKey" placeholder="검색할 캠핑장 이름을 입력해주세요">
		<a href="#" onclick="searchCamp()"><img id="searchBtn" src="../images/sBtn.png"></a>
    </div>
    <div class="clear"></div>
    <hr>
    <div id="searchResult">
        <div id="campInfo">
        	<a href="#">
        		<img id="campInfo_img" src="../images/camp01.jpg">
        	</a>
            <div id="campInfo_text">
                <span>{해여림 빌리지}</span><span>예약가능</span><br>
                <span>{해여림 A}{100000}</span><br>
                <span>{4} ~ {10}</span><br>
                <span>{바베큐장, 주차장}</span><br>
            </div>           
        </div>
        <div id="campInfo">
            <a href="#">
        		<img id="campInfo_img" src="../images/camp01.jpg">
        	</a>
            <div id="campInfo_text">
                <span>{해여림 빌리지}</span><span>예약가능</span><br>
                <span>{해여림 A}{100000}</span><br>
                <span>{4} ~ {10}</span><br>
                <span>{바베큐장, 주차장}</span><br>
            </div>
        </div>
        <div id="campInfo">
            <a href="#">
        		<img id="campInfo_img" src="../images/camp01.jpg">
        	</a>
            <div id="campInfo_text">
                <span>{해여림 빌리지}</span><span>예약가능</span><br>
                <span>{해여림 A}{100000}</span><br>
                <span>{4} ~ {10}</span><br>
                <span>{바베큐장, 주차장}</span><br>
            </div>
        </div>
        <div id="campInfo">
            <a href="#">
        		<img id="campInfo_img" src="../images/camp01.jpg">
        	</a>
            <div id="campInfo_text">
                <span>{해여림 빌리지}</span><span>예약가능</span><br>
                <span>{해여림 A}{100000}</span><br>
                <span>{4} ~ {10}</span><br>
                <span>{바베큐장, 주차장}</span><br>
            </div>
        </div>
        <div id="campInfo">
            <a href="#">
        		<img id="campInfo_img" src="../images/camp01.jpg">
        	</a>
            <div id="campInfo_text">
                <span>{해여림 빌리지}</span><span>예약가능</span><br>
                <span>{해여림 A}{100000}</span><br>
                <span>{4} ~ {10}</span><br>
                <span>{바베큐장, 주차장}</span><br>
            </div>
        </div>
        <div id="campInfo">
            <a href="#">
        		<img id="campInfo_img" src="../images/camp01.jpg">
        	</a>
            <div id="campInfo_text">
                <span>{해여림 빌리지}</span><span>예약가능</span><br>
                <span>{해여림 A}{100000}</span><br>
                <span>{4} ~ {10}</span><br>
                <span>{바베큐장, 주차장}</span><br>
            </div>
        </div>
        <div id="campInfo">
            <a href="#">
        		<img id="campInfo_img" src="../images/camp01.jpg">
        	</a>
            <div id="campInfo_text">
                <span>{해여림 빌리지}</span><span>예약가능</span><br>
                <span>{해여림 A}{100000}</span><br>
                <span>{4} ~ {10}</span><br>
                <span>{바베큐장, 주차장}</span><br>
            </div>
        </div>
        <div id="campInfo">
            <a href="#">
        		<img id="campInfo_img" src="../images/camp01.jpg">
        	</a>
            <div id="campInfo_text">
                <span>{해여림 빌리지}</span><span>예약가능</span><br>
                <span>{해여림 A}{100000}</span><br>
                <span>{4} ~ {10}</span><br>
                <span>{바베큐장, 주차장}</span><br>
            </div>
        </div>
        <%--  캠프 정보 반복문
        <c:forEach items="campList" var="camp">
        <div id="campInfo">
        	<a href="#" onclick="go_campInfo('${camp.cseq}')">
            	<img id="campInfo_img" src="${camp.image}">
            </a>
            <div id="campInfo_text">
                <span>${camp.cname}</span>
                <c:if test="${camp.res_sta=='Y'}">예약가능</c:if>
                <c:if test="${camp.res_sta=='N'}">예약완료</c:if>
                <br>
                <span>${camp.res_sta}</span><br>
                <span>${camp.c_class}${100000}</span><br>
                <span>${camp.min_people} ~ ${camp.max_people}</span><br>
                <span>${camp.facilities}</span><br>
            </div>
        </div>
        </c:forEach> --%>
    </div>
    <div class="clear"></div>
<%@ include file="../footer.jsp" %>