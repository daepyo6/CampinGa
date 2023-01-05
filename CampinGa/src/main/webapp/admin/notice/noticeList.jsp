<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>

<article>
	<h1>공지사항 리스트</h1>
	<form name="frm" method="post">
			<table>  <!-- 1행 1열짜리 각 버튼(검색, 전체보기, 상품 등록)들을 위한 테이블 -->
				<tr>
					<td width="642">상품명<input type="text" name="key" value="${key}">
						<input class="btn" type="button" name="btn_search" value="검색" 
							onClick="go_search( 'adminProductList' );">
						<input class="btn" type="button" name="btn_total" value="전체보기 " 
							onClick="go_total( 'adminProductList' );">
						<input class="btn" type="button" name="#" value="상품등록"  onClick="go_wrt();">
					</td>
				</tr>
			</table>	
			
			<table id="noticeList">
				<tr><th>번호</th><th>제목</th><th>등록일</th></tr>
				<c:forEach items="${noticeList}" var="notice">
					<tr>
						<td height="23" align="center">${notice.nseq}</td>
						<td style="text-align:left; padding-left:50px;">
							<a href="#" onClick="go_detail('${notice.nseq}');">${notice.subject}</a>
						</td>
					
						<td><fmt:formatDate value="${notice.indate}"/></td>
						<td>
							
		   	 			
		   	 			</td>
					</tr>
				</c:forEach>
			</table>
	</form>
	
	<div class="clear"></div>

	<jsp:include page="/admin/paging/paging.jsp">
		<jsp:param name="command" value="shop.do?command=adminProductList" />
	</jsp:include>
	
</article>
						

<%@ include file="/admin/footer.jsp"%>
