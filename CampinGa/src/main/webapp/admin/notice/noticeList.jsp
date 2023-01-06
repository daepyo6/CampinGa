<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>

<article>
	<h1>공지사항 리스트</h1>
	<form name="frm" method="post">
			
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