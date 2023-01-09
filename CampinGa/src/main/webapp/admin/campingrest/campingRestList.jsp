<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>
<article id="mypage" class="adminPage">
	<h1>캠핑장 객실 예약 리스트</h1>
	<form name="frm" method="post"><br><br>
	<table class="adSearch" style="float:right;">
		<tr>
			<td class="searchTd">객실 이름&nbsp;&nbsp;<input type="text" name="key" value="${key1}">&nbsp;
			<input class="adpage_btn" type="button" value="검색" onclick="go_search('adminRestList)">
			<input class="adpage_btn" type="button" name="btn_total" value="전체보기" onClick="go_total('adminRestList')">
		</td></tr>
	</table><br>
	<table class="rentList">
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
				<td>${reservationVO.reseq}</td>
				<td><fmt:formatDate value="${reservationVO.res_date}" type="both" dateStyle="short" timeStyle="short"/>&nbsp;&nbsp;</td>
				<td>${reservationVO.cname}</td>
				<td>${reservationVO.c_class}</td>
				<td>${reservationVO.people}</td>
				<td><fmt:formatDate value="${reservationVO.chk_in}"/></td>
				<td><fmt:formatDate value="${reservationVO.chk_out}"/></td>
				<td>${reservationVO.mid}</td>
				<td>${reservationVO.price}</td>
				<td>${reservationVO.res_sta}</td>
			</tr>
		</c:forEach>
	</table>
	</form>
</article>
<%@ include file="/admin/footer.jsp"%>