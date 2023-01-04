<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<div id="mainSearch">
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
		    <!-- 검색버튼 onclick 함수 필요함 -->	    
	    </div>    
	</div>
</div>
<!-- new 캠핑장 -->
<div id="newCampings">
	<div class="mainTitle">새로 추가된 캠핑장!!</div>
	<div class="newCamp">
		<img id="newCampImg" src="images/newImg1.jpg">
		<div class="ImgCover">캠핑장정보<br>자세히보기</div>
	</div>
	<div class="newCampName">캠핑장 이름</div>
	<div class="newCampInfo">율포해수녹차센터는 해수탕과 녹차탕을 갖췄다. 노천탕 앞에는 드넓은 득량만 바다와 솔숲이 펼쳐진다.</div>
	
</div>

<!-- 추천 캠핑장 -->
<div id="bestCampings">
	<div class="mainTitle">이달의 추천 캠핑장!!</div>

</div>

<div class="clear"></div>

<%@ include file="footer.jsp" %>
