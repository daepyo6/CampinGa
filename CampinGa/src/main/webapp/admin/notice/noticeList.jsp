<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>
<article id="mypage" class="adminPage">
	<h1>공지사항 리스트</h1>
	<form name="frm" method="post">		
		<table id="noticeList" class="rentList">
			<tr><th>번호</th><th>제목</th><th>등록일</th></tr>
			<c:forEach items="${noticeList}" var="notice">
				<tr>
					<td align="center">${notice.nseq}</td>
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
	<div class="paging" style="font-size:120%; font-weight:bold; text-align: center">
			<c:if test="${paging.prev}">
				<a href="camp.do?command=adminNoticeList&page=${paging.beginPage-1}#logo">◀</a>&nbsp;
			</c:if>
			<c:forEach begin="${paging.beginPage}" end="${paging.endPage}" var="index">
				<c:choose>
					<c:when test="${paging.page==index}">
						<span style="color:red">${index}&nbsp;</span>
					</c:when>
					<c:otherwise>
						<a href="camp.do?command=adminNoticeList&page=${index}#logo">${index}</a>&nbsp;
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${paging.next}">
				<a href="camp.do?command=adminNoticeList&page=${paging.endPage+1}#logo">▶</a>&nbsp;
			</c:if>
	</div>		
	
</article>
						

<%@ include file="/admin/footer.jsp"%>