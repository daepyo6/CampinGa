<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="bar"></div>
<div id="campingdetail">
	<div id="campMain">
		<div id="campMain_img">
			<img src="images/camp01.jpg" />
		</div>
		<div id="campMain_info">
			<div id="campMain_info-title">
				<h2>${campMain.cname}</h2>
			</div>
			<label>주소 : </label><span>${campMain.caddress1}&nbsp;${campMain.caddress2}&nbsp;${campMain.caddress2}</span><br>
			<br><label>문의처 : </label><span>${campMain.phone}</span><br>
			<br><label>캠핑장 유형 : </label><span>${campMain.category}</span><br>
			<br><label>운영기간 : </label><span>봄, 여름, 가을, 겨울</span><br>
			<br><label>운영일 : </label><span>평일+주말</span><br>
			<br><label>주변이용가능시설 : </label><span>${campMain.facilities}</span><br>
			<br>
			<div id="campMain_info-btns">
			<c:choose>
				<c:when test="${chk_fav == 'y'}">
					<input type="button" value="즐겨찾기 삭제" class="submit"
						onclick="location.href='camp.do?command=deleteFavorites&bseq=${bseq}'">
				</c:when>
				<c:otherwise>
					<input type="button" value="즐겨찾기 추가" class="submit"
						onclick="location.href='camp.do?command=addFavorites&bseq=${bseq}'">
				</c:otherwise>
			</c:choose>
				

			</div>
		</div>
	</div>
	<div id="campDetail">
		<h2>캠핑장 소개</h2>
		<!-- 아래 이미지 3개 DB에서 불러올거라면 수정해야 함 -->
		<div id="campDetail_imgs">
			<img src="images/camp01.jpg" class="campDetail_img" /> <img
				src="images/camp02.jpg" class="campDetail_img" /> <img
				src="images/camp01.jpg" class="campDetail_img" /><br>
		</div>
		<h3>${campMain.content}</h3>
	</div>
