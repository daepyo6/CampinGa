<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp"%>
<link href="camping/searchList.css" rel="stylesheet">
<script type="text/javascript" src="camping/campingList.js"></script>
<style>
</style>
<article>
<!-- 예약자 정보 (예약자, 전화번호, 이메일) -->
<div>
	<table>
		<tr>
			<th>예약자 이름</th><br>
			<td></td>
		</tr>
		<tr>
			<th>휴대폰 번호</th><br>
			<td></td>
		</tr>
		<tr>
			<th>이메일</th><br>
			<td></td>
		</tr>
	</table>
</div>

<!-- 캠핑장 정보 (캠핑장이름, 객실정보, 체크인, 체크아웃, 결제금액)-->
<div>
	<table>
		<tr>
			<th>캠핑장 이름</th><br>
			<td></td>
		</tr>
		<tr>
			<th>객실정보</th><br>
			<td></td>
		</tr>
		<tr>
			<th>체크인</th><br>
			<td></td>
		</tr>
		<tr>
			<th>체크아웃</th><br>
			<td></td>
		</tr>
		<tr>
			<th>인원</th><br>
			<td></td>
		</tr>
		<tr>
			<th>결제금액</th><br>
			<td></td>
		</tr>
		<input type="button" value="예약하기">
	</table>
</div>

</article>
<%@ include file="../../footer.jsp"%>