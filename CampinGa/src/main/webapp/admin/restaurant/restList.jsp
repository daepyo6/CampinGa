<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>


<article>
	<h1>캠핑장 정보 관리</h1>
	<form name="frm" method="post">
			<table>  <!-- 1행 1열짜리 각 버튼(검색, 전체보기, 상품 등록)들을 위한 테이블 -->
				<tr>
					<td width="642">상품명<input type="text" name="key" value="${key}">
						<input class="btn" type="button" name="btn_search" value="검색" 
							onClick="go_search( 'adminProductList' );">
						<input class="btn" type="button" name="btn_total" value="전체보기 " 
							onClick="go_total( 'adminProductList' );">
					</td>
				</tr>
			</table>	

         <table id="noticeList">
 <tr><th>사업자번호</th><th>이름</th><th>주소</th><th>연락처</th><th>등록일</th><th>삭제</th></tr>
				<c:forEach items="${campingList}" var="campingList">
					<tr>
						<td height="2" align="center">${campingList.bseq}</td>
						<td height="2" align="center">${campingList.cname}</td>
						<td height="2" align="center">
						${campingList.caddress1} ${campingList.caddress2} ${campingList.caddress3}</td>
					     <td height="2" align="center">${campingList.phone}</td>
					     <td><fmt:formatDate value="${campingList.c_indate}"/>
						<td><input type="checkbox" name="cseq" value="${campingList.cseq}"></td>
					</tr>
					</c:forEach>
					<tr>
					<th><a href="#" onClick="go_delete();"><h3>삭제하기</h3></a></th>
					</tr>
				
			</table>
	</form>
	
	<div class="clear"></div>

	<jsp:include page="/admin/paging/paging.jsp">
		<jsp:param name="command" value="shop.do?command=adminProductList" />
	</jsp:include>
	
</article>





<%@ include file="/admin/footer.jsp"%>
