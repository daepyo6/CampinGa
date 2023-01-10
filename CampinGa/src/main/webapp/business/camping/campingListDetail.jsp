<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../header.jsp" %>
<%@ include file="/business/sub_menu.jsp"%>

<article>
	<form action="camp.do" method="post" enctype="multipart/form-data">
	<fieldset>
      <div class="joinTable">
       <div>
         <label>캠핑장 이름 : ${campingVO.cname}</label><input type="text" class="joinInput" name="cname" sezi="20">
         </div>
         <div class="inputDiv">
         <label>캠핑장 주소 : </label>
         	<select name="caddress1">
         		<!-- 나중에 forEach로 바꾸기 -->
	         	<option value="0">도/시 선택</option>
	         	<option value="1">서울시</option>
	         	<option value="2">경기도</option>
         	</select>
         	<select name="caddress2">
         		<!-- 나중에 forEach로 바꾸기 -->
	         	<option value="0">시/군 선택</option>
	         	<option value="1">가평군</option>
	         	<option value="2">김포시</option>
         	</select> <br>       	
         	<input type="text" name="caddress3" placeholder="상세주소를 입력해주세요">
         </div>    
         <div class="inputDiv">
         <label>문의처 : </label> 
            <input type="text" class="joinInput" name="phone" size="20">
            <input type="hidden" name="reid">
         </div>
         <br>
         <div class="inputDiv">
         <label>캠핑장 유형 : ${campingVO.category}</label> 
            <input type="password" class="joinInput" size="20"></div>
        <br>
         <div class="inputDiv">
          <label>운영기간 : </label> 
            <input type="text" class="joinInput" size="20"></div>
         <br>
         <div class="inputDiv">
         <label>운영일 : </label> 
            <input type="text" class="joinInput" size="30"></div> 
         <div class="inputDiv">
          <label>부대시설 : ${campingVO.facilities} </label> 
            <input type="text" class="joinInput" size="20"></div>
         <br>        
       <div class="buttons">
         <input type="button" value="등록하기" onclick="location.href='camp.do?command=businessmanCampingListInsert'">
         <input type="button" value="취소" onclick="location.href='camp.do?command=index'">
         </div>
      </div>
      
      <div id="cmp_3">
         <h2>detail Info</h2>
         <img src="images/camp01.jpg" class="img"/>
         <img src="images/camp02.jpg" class="img" />
         <img src="images/camp01.jpg" class="img" /><br>
         <h3>청라국제도시의 해변공원 내에 위치한 도심 캠핑장 캠핑을 위해 이동하는 거리가 아까운 이들에게 최적인 도심지
            캠핑장이다. 청라국제도시의 해변공원 내에 위치한 캠핑장으로 저렴한 가격과 일박 예약이 가능해서 당일 캠핑을 즐기기도 좋다.
            캠핑장 옆으로 서해와 영종도가 바라 보이는 산책코스가 있는 노을공원이 있다. 도심 공원 특성상 캠핑장비와 준비물 없는
            이들을 위해 캠핑장비와 취사시설등 일체를 대여해 주는 서비스도 마련되어 있다. 이외에도 바비큐 존, 텐트카라반존, 어린이
            놀시시설등을 갖추고 있다.</h3>
      </div>
      </fieldset>
   </form>
</article>
<%@ include file="../../footer.jsp" %>