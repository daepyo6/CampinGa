<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../header.jsp"%>
<%@ include file="/business/sub_menu.jsp"%>

<article style="height: 1100px">
	<form action="camp.do?command=businessmanCampingListUpdate" method="post" enctype="multipart/form-data">
		<input type="hidden" name="bseq" value="${BusinessmanVO.bseq}">
		<input type="hidden" name="oldimg" value="${BusinessmanVO.image}" >
		<div class="roomInsert">
			<div class="roomInsert_title">
				<span>캠핑장 정보수정</span>
			</div>
			<div class="roomInput">
				<span>캠핑장 이름</span>
				<div class="roomInput_div">
					<input type="text" name="cname" size="20" placeholder="${BusinessmanVO.cname}">
				</div>
			</div>
			<div class="roomInput">
				<span>현재 캠핑장 사진</span><br>
				<div style="text-align: center; margin-top: 15px;">
					<img src="images/${BusinessmanVO.image}" 
					style="width: 300px; height: 200px; border-radius: 10px;">
				</div>
				<div class="filebox">
				    <input class="upload-name" value="첨부파일" placeholder="첨부파일">
				    <label for="file">파일찾기</label> 
				    <input type="file" id="file" name="newimg">
				</div>
			</div>
			<div class="roomInput">
				<span>캠핑장 소개</span>
				<div class="roomInput_div">
				<textarea name="content">${BusinessmanVO.content}</textarea>
				</div>
			</div>
			<div class="roomInput">
				<span>카테고리</span>
				<div class="roomInput_div">
				<select name="category">
					<c:forEach items="${cateMap}" var="cate">
						<c:choose>
							<c:when test="${cate==BusinessmanVO.category}">
								<option value="${cate}" selected="selected">${cate}</option>
							</c:when>
							<c:otherwise>
								<option value="${cate}">${cate}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
				</div>
			</div>
			<div class="roomInput">
				<span>부대시설</span>
				<div class="roomInput_div" style="text-align: left;">
					<input type="checkbox" name="facilities" value="공용주차장"/>&nbsp;공용주차장&nbsp;&nbsp;
    			    <input type="checkbox" name="facilities" value="공용화장실"/>&nbsp;공용화장실&nbsp;&nbsp;
    			    <input type="checkbox" name="facilities" value="편의점/매점"/>&nbsp;편의점&nbsp;&nbsp;
    			   	<input type="checkbox" name="facilities" value="카페"/>&nbsp;카페&nbsp;&nbsp;<br>
    			    <input type="checkbox" name="facilities" value="공용샤워실"/>&nbsp;공용샤워실&nbsp;&nbsp;
    			    <input type="checkbox" name="facilities" value="바베큐장"/>&nbsp;바베큐장&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			    <input type="checkbox" name="facilities" value="수영장"/>&nbsp;수영장&nbsp;&nbsp;
    			    <input type="checkbox" name="facilities" value="개수대"/>&nbsp;개수대&nbsp;&nbsp;
				</div>
			</div>
				<div class="buttons">
					<input type="submit" value="등록하기">
				</div>
		</div>
	</form>
</article>
<%@ include file="../../footer.jsp"%>