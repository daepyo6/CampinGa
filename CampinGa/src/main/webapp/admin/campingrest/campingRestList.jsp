<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>
<article>
	<h1>캠핑장 객실 예약 리스트</h1>
	<form name="frm" method="post">
	<table style="float:right;">
		<tr>
			<td>객실 이름<input type="text" name="key" value="${key1}">
			<input class="btn" type="button" value="검색" onclik="go_search('adminRestList)">
			<input class="btn" type="button" name="btn_total" value="전체보기" onClick="go_total('adminRestList')">
		</td></tr>
	</table><br>
	<table id="restList">
		<tr>
			<th>예약 번호</th>
			<th>예약 일자</th>
			<th>캠핑장 이름</th>
			<th>객실 이름</th>
			<th>인원</th>
			<th>체크인</th>
			<th>체크 아웃</th>
			<th>예약자</th>
			<th>금액</th>
			<th>예약 상태</th>
		</tr>
		<c:forEach items="${restList}" var="reservationVO">
			<tr>
				<td>${reservationVO.reseq}&nbsp;</td>
				<td><fmt:formatDate value="${reservationVO.res_date}" type="both" dateStyle="short" timeStyle="short"/>&nbsp;&nbsp;</td>
				<td>${reservationVO.cname}&nbsp;&nbsp;</td>
				<td>${reservationVO.c_class}&nbsp;&nbsp;</td>
				<td>${reservationVO.people}&nbsp;&nbsp;</td>
				<td><fmt:formatDate value="${reservationVO.chk_in}"/>&nbsp;&nbsp;</td>
				<td><fmt:formatDate value="${reservationVO.chk_out}"/>&nbsp;&nbsp;</td>
				<td>${reservationVO.mid}&nbsp;&nbsp;</td>
				<td>${reservationVO.price}&nbsp;&nbsp;</td>
				<td>${reservationVO.res_sta}</td>
			</tr>
		</c:forEach>
	</table>
	</form>
</article>
<%@ include file="/admin/footer.jsp"%>