<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp"%>
<%@ include file="/business/sub_menu.jsp"%>


<fieldset>
<div>
	<img class="imgae"/>
</div>
<div>
	<label>${campingVO.cname}</label> 
	<label>주소 : </label>${campingVO.caddress1}${campingVO.caddress2}${campingVO.caddress3}<br><br> 
	<label>문의처 : </label>010-1111-2222<br> <br> 
	<label>캠핑장 유형 : </label>${campingVO.category}<br><br> 
	<label>운영기간 : </label>봄, 여름, 가을, 겨울<br> <br> 
	<label>운영일 : </label>평일 + 주말<br> <br> 
	<label>부대시설 : </label>${campingVO.facilities}<br>
		<br>
</div>
<br>
	<div id="cmp_3">
		<img class="img" /><br>
		<h3>청라국제도시의 해변공원 내에 위치한 도심 캠핑장 캠핑을 위해 이동하는 거리가 아까운 이들에게 최적인 도심지
			캠핑장이다. 청라국제도시의 해변공원 내에 위치한 캠핑장으로 저렴한 가격과 일박 예약이 가능해서 당일 캠핑을 즐기기도 좋다.
			캠핑장 옆으로 서해와 영종도가 바라 보이는 산책코스가 있는 노을공원이 있다. 도심 공원 특성상 캠핑장비와 준비물 없는 이들을
			위해 캠핑장비와 취사시설등 일체를 대여해 주는 서비스도 마련되어 있다. 이외에도 바비큐 존, 텐트카라반존, 어린이
			놀시시설등을 갖추고 있다.</h3>
	</div>
</fieldset>


	<input type="button" value="등록하기" class="submit"
	onclick="location.href='camp.do?command=businessmanCampingListDetail'">
	<input type="button" value="수정하기" class="submit"
	onclick="location.href='camp.do?command=businessmanCampingListUpdate'">


<%@ include file="../../footer.jsp"%>