<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp"%>
<%@ include file="/business/sub_menu.jsp"%>


	<div class="myCampInfo_title"><h1>캠핑장 정보 관리</h1></div>
<div class="myCampInfo">
	<table class="myCampInfo_table">
	<tr>
		<th colspan="2" height="60" style="font-size: 1.3rem; color:navy; border-bottom: 1px solid black;">
		${BusinessmanVO.cname}</th>
	</tr>
	<tr>
		<th height="220">이미지 : </th>
		<td><img class="myCampInfo_img" src="images/${BusinessmanVO.image}"></td>
	</tr>
	<tr>
		<th height="150">소개 : </th>
		<td>${BusinessmanVO.content}</td>
	</tr>
	<tr>
		<th height="45">카테고리 : </th>
		<td>${BusinessmanVO.category}</td>
	</tr>
	<tr>
		<th height="45">부대시설 : </th>
		<td>${BusinessmanVO.facilities}</td>
	</tr>
	</table>
	<div>
		<input type="button" value="수정하기" class="adpage_btn"
		onclick="location.href='camp.do?command=businessmanCampingListDetail'">
	</div>
</div>

<%@ include file="../../footer.jsp"%>