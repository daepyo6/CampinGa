<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp"%>
<script src="business/business.js"></script>
<%@ include file="/business/sub_menu.jsp"%>



<article>
	<h1>Q&amp;A 게시판</h1>
	<form name="frm" method="post">
		<input type="hidden" name="qseq" value="${qnavo.qseq}">
		<table id="orderList">
			<!-- 게시물의 내용 -->

			<tr>
				<th>등록일</th>
				<td align="left"><fmt:formatDate value="${qnavo.indate}" /></td>
			</tr>
			<tr>
				<th>내용</th>
				<td align="left">${qnavo.content}</td>
			</tr>
		</table>
		<!-- 관리자가 쓴 답글 또는 답글 쓰는 입력란 표시 -->
		<c:choose>
			<c:when test='${qnavo.repyn=="n"}'>
				<table id="orderList">
					<tr>
						<td colspan="2"><textarea name="reply" rows="3" cols="50"></textarea>
							<input type="button" class="btn" value="저장" onClick="go_rep()"></td>
					</tr>
				</table>
			</c:when>
			<c:otherwise>
				<table id="orderList">
					<tr>
						<th>댓글</th>
						<td>${qnavo.reply}</td>
					</tr>
				</table>
			</c:otherwise>
		</c:choose>
		<input type="button" class="btn" value="목록"
			onClick="location.href='camp.do?command=campingQna'">
	</form>
</article>










<%@ include file="../../footer.jsp"%>