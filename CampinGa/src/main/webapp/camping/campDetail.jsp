<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<link href="camping/searchList.css" rel="stylesheet">
<script type="text/javascript" src="camping/campingList.js"></script>
<style>
</style>
<article>
	<!-- 캠핑장 세부설명 -->
	<%@ include file="../camping/detail.jsp"%>

	<!-- 캠핑장 객실 정보 -->
	<div id="roomBox_main">
		<c:forEach items="${campingList}" var="campVO">
			<div id="roomBox" onclick="location.href='camp.do?command=reserveForm'">
				<div class="room_img">
					<img src="images/${campVO.image}" class="img" />
				</div>
				<div>
					<table>
						<tr><th colspan="2">${campVO.c_class}</th></tr>
						<tr><td colspan="2">${campVO.category}</td></tr>
						<tr><td colspan="2">남은자리</td></tr>
						<tr>
							<td>기준인원 ${campVO.min_people}명/최대인원 ${campVO.max_people}명</td>
							<td>${campVO.price}원</td>
						</tr>
					</table>
				</div>
			</div>
		</c:forEach>
	</div>

	<!-- Q&A -->
	<div id="QnaBox">
		<h2>Q & A</h2>
		<table class="view">
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>등록일</th>
				<th>내용</th>
				<th>답변여부</th>
				<th>수정/삭제</th>
			</tr>
			<c:forEach items="${qnalist}" var="qnaVO">
				<tr>
					<td>${qnaVO.qseq}</td>
					<td>${qnaVO.mid}</td>
					<td><fmt:formatDate value="${qnaVO.indate}" type="date" /></td>
					<td align="left">${qnaVO.content}</td>
					<td><c:choose>
							<c:when test="${qnaVO.repyn==y}">${qnaVO.reply}</c:when>
							<c:otherwise>답변대기중</c:otherwise>
						</c:choose></td>
					<td colspan="2"><c:if test="${qnaVO.mid == loginUser.mid}">
							<input type="submit" value="수정"
								onclick="location.href='camp.do?command=campDetail&qseq=${qnaVO.qseq}&bseq=${bseq}'">
							<input type="button" value="삭제"
								onclick="location.href='camp.do?command=deleteQna&qseq=${qnaVO.qseq}&bseq=${bseq}'">
						</c:if></td>
				</tr>
				<c:if test="${qnaVO.qseq==updateQseq}">
					<tr>
						<td colspan="6">
							<form name="frm" method="post">
								<input type="hidden" name="qseq" value="${qnaVO.qseq}">
								<input type="hidden" name="bseq" value="${bseq}"> <input
									type="hidden" name="mid" value="${qnaVO.mid}">
								<textarea rows="8" cols="65" name="content">${qnaVO.content}</textarea>
								<input type="submit" value="확인" onclick="QnaCheck();">
							</form>
						</td>
					</tr>
				</c:if>
			</c:forEach>
		</table>
		<div class="clear"></div>
		<form name="frm" method="post" action="camp.do">
			<input type="hidden" name="command" value="insertQna"> <input
				type="hidden" name="bseq" value="${bseq}">
			<fieldset>
				<legend>Q & A</legend>
				<textarea rows="8" cols="65" name="content"></textarea>
				<div id="btns">
					<input type="submit" class="submit" value="등록">
				</div>
			</fieldset>
			<div class="clear"></div>
			<br>
		</form>
	</div>


	<!-- 리뷰 -->
	<div id="ReviewBox" align="center">
		<h2>Review</h2>
		<table class="view">
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>등록일</th>
				<th>내용</th>
				<th>수정/삭제</th>
			</tr>
			<c:forEach items="${reviewList}" var="ReviewVO">
				<tr align="center">
					<td>${ReviewVO.rseq}</td>
					<td>${ReviewVO.mid}</td>
					<td><fmt:formatDate value="${ReviewVO.indate}" /></td>
					<td align="left">${ReviewVO.content}</td>
					<td><c:if test="${ReviewVO.mid==loginUser.mid}">
							<input type="button" value="수정" class="submit"
								onclick="location.href='camp.do?command=campDetail&rseq=${ReviewVO.rseq}&bseq=${bseq}'">
							<input type="button" value="삭제" class="submit"
								onclick="location.href='camp.do?command=deleteReview&rseq=${ReviewVO.rseq}&bseq=${bseq}'">
						</c:if>
				</tr>

				<c:if test="${ReviewVO.rseq==updateRseq}">
					<tr>
						<td colspan="5">
							<form name="frm" method="post">
								<input type="hidden" name="rseq" value="${ReviewVO.rseq}">
								<input type="hidden" name="bseq" value="${bseq}"> <input
									type="hidden" name="mid" value="${ReviewVO.mid}">
								<textarea rows="8" cols="65" name="content">${ReviewVO.content}</textarea>
								<input type="submit" value="확인" onclick="reviewCheck();">
							</form>
						</td>
					</tr>
				</c:if>
			</c:forEach>
		</table>

		<form name="form" method="post" action="camp.do">
			<input type="hidden" name="command" value="insertReview"> <input
				type="hidden" name="bseq" value="${bseq}">
			<fieldset>
				<legend>Review</legend>
				<textarea rows="8" cols="65" name="content"></textarea>
				<div class="btns">
					<input type="submit" class="submit" value="등록">
				</div>
			</fieldset>
		</form>
	</div>
</article>
<%@ include file="../footer.jsp"%>