<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../header.jsp"%>
<%@ include file="/business/sub_menu.jsp"%>

<article>
	<form action="camp.do?command=businessmanCampingListUpdate" method="post" enctype="multipart/form-data">
		<input type="hidden" name="bseq" value="${BusinessmanVO.bseq}">
		<fieldset>
			<div> <br><br><br><br>
				<div>
					<label>이미지 : <img src="images/${BusinessmanVO.image}"></label> 
					<input type="file" size="20" name="image">
				</div>
				<br>
				<div>
					<label>소개 : ${BusinessmanVO.content}</label>
					<textarea rows="8" cols="65" name="content"></textarea>
				</div>
				<br>
				<div>
					<label>카테고리 : ${BusinessmanVO.category}</label> 
					<input type="text" size="30" name="category">
				</div>
				<div>
					<label>부대시설 : ${BusinessmanVO.facilities}</label> 
					<input type="text" size="20" name="facilities">
				</div>
				<br>
				<div class="buttons">
					<input type="submit" value="등록하기">
				</div>
			</div>
			</div>
		</fieldset>
	</form>
</article>
<%@ include file="../../footer.jsp"%>