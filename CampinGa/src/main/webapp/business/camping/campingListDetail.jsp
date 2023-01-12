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
			<div> <br><br>
				<div>
					<label>이미지 <img src="images/${BusinessmanVO.image}" style="width: 300px; height: 200px;"></label> <br>
					<input type="file" size="20" name="image">
				</div>
				<br><br>
				<div>
					<label>소개</label> <br>
					<textarea rows="8" cols="65" name="content">${BusinessmanVO.content}</textarea>
				</div>
				<br><br>
				<div>
					<label>카테고리</label> <br>
					<select name="category">
						<option value="" selected="selected">카테고리를 선택하세요</option>
						<option value="auto">오토캠핑</option>
						<option value="camping">캠핑</option>
						<option value="caravane">카라반</option>
						<option value="campnic">캠프닉</option>
					</select>
				</div>
				<br><br>
				<div>
					<label>부대시설</label> <br>
					공용주차장<input type="checkbox" name="facilities" value="공용주차장"/>&nbsp;
     			    공용샤워실<input type="checkbox" name="facilities" value="공용샤워실"/>&nbsp;
     			    공용화장실<input type="checkbox" name="facilities" value="공용화장실"/>&nbsp;
     			   	카페<input type="checkbox" name="facilities" value="카페"/>&nbsp;
     			    편의점<input type="checkbox" name="facilities" value="편의점/매점"/>&nbsp;<br>
     			    개수대<input type="checkbox" name="facilities" value="개수대"/>&nbsp;
     			    바베큐장<input type="checkbox" name="facilities" value="바베큐장"/>&nbsp;
     			    수영장<input type="checkbox" name="facilities" value="수영장"/>&nbsp;
     			    개수대<input type="checkbox" name="facilities" value="개수대"/>&nbsp;
				</div>
				<br>
				<div class="buttons">
					<input type="submit" value="등록하기">
				</div>
			</div>
		</fieldset>
	</form>
</article>
<%@ include file="../../footer.jsp"%>