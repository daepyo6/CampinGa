<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp"%>
<%@ include file="/business/sub_menu.jsp"%>


<fieldset>
<div>
	<img class="imgae"/>
</div>
<div>
	<label>이미지 : <img src="images/${BusinessmanVO.image}"></label><br><br> 
	<label>소개 : </label>${BusinessmanVO.content}<br> <br> 
	<label>카테고리 : </label>${BusinessmanVO.category}<br><br>
	<label>부대시설 : </label>${BusinessmanVO.facilities}<br>
		<br>
</div>
<br>
</fieldset>


	<input type="button" value="수정하기" class="submit"
	onclick="location.href='camp.do?command=businessmanCampingListDetail'">


<%@ include file="../../footer.jsp"%>