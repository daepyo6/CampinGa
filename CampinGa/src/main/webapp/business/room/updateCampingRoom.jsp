<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp"%>
<%@ include file="/business/sub_menu.jsp"%>

<article>
	<form method="post" name="campingRoom" enctype="multipart/form-data" action="camp.do?command=updateCampingRoom">
		<input type="hidden" name="cseq" value="${campVO.cseq}">
		<div class="joinTable">
			<h1>객실 등록</h1>
			<div>
				<label>객실 이름</label>
				<input type="text" name="c_class" size="20" value="${campVO.c_class}">
			</div>
			<div>
				<label>객실 사진</label>
				<input type="file" name="c_image" size="20"><br>
				<input type="hidden" name="oldc_image" value="${campVO.c_image}">
				이전 파일 : ${campVO.c_image}
			</div>
			<div>
				<label>객실 설명</label> 
				<textarea rows="8" cols="65" name="c_content" >${campVO.c_content}</textarea>
			</div>
			<br>
			<div>
				<label>객실 가격</label> 
				<input type="text" name="price" size="20" value="${campVO.price}">
			</div>
			<br>
			<div>
				<label>기준인원</label> 
				<input type="text" name="min_people" size="5" value="${campVO.min_people}">
			</div>
			<br>
			<div>
				<label>최대인원</label> 
				<input type="text" name="max_people" size="5" value="${campVO.max_people}">
			</div>
			<br>
			<div class="buttons">
				<input type="submit" value="객실수정" class="button">
			</div>
		</div>
	</form>
</article>

<%@ include file="../../footer.jsp"%>