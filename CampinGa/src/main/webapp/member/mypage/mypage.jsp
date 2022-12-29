<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../../header.jsp"%>
<article>

	<!-- 회원 간단한 정보 + 정보수정 버튼-->
	<form>
		<table id="memberInfoList">
			<tr>
				<th>회원정보</th>
			</tr>
			<tr>
				<td>이름</td>
				<td>${loginUser.name}</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${loginUser.email}</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td>${loginUser.mphone}</td>
			</tr>
			<tr>
				<td colspan="3"><input type="button" value="정보수정" onclick=""></td>
			</tr>
		</table>
	</form>


	<!-- "예약 조회" 현재 예약조회, 지난 예약조회-->
	<form>
		<table id="reservateList">
			<tr>
				<th>예약일자</th>
				<th>예약장소</th>
				<th>인원</th>
				<th>체크인</th>
				<th>체크아웃</th>
				<th>금액</th>
				<th>예약취소</th>
			</tr>
			<!-- 가짜데이터 이후 c:forEach 사용하여 테이블 조회할 것.-->
			<c:forEach items="${reList}" var="resVO">
				<tr>
					<td>${resVO.res_date}</td>
					<td><a href="#">${resVO.cname}&nbsp;${resVO.c_class}</a></td>
					<td>${resVO.people}명</td>
					<td>${resVO.chk_in}</td>
					<td>${resVO.chk_out}</td>
					<td>${resVO.price}</td>
					<td><input type="button" value="취소" onclick=""></td>
				</tr>
			</c:forEach>
		</table>
		<div class="clear"></div>
	</form>

	<!-- "내 즐겨찾기" 현재 회원이 즐겨찾기한 캠핑장의 내역을 출력 -->
	<form>
		<table id="favoritesList">
			<tr>
				<th>번호</th>
				<th>캠핑장이름</th>
				<th>캠핑장 전화번호</th>
				<th>즐겨찾기 해제</th>
			</tr>
			<!-- 가짜데이터 이후 c:forEach 사용하여 테이블 조회할 것.-->
			<c:forEach items="${favorList}" var="favorVO">
				<tr>
					<td>${favorVO.fseq}</td>
					<td><a href="#">${favorVO.cname}</a></td>
					<td>${favorVO.phone}</td>
					<td><input type="button" value="취소" onclick=""></td>
				</tr>
			</c:forEach>
		</table>
		<div class="clear"></div>
	</form>
</article>
<%@ include file="../../footer.jsp"%>