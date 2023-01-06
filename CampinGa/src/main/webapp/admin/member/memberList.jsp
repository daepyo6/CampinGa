<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>
<article>
	<h1>회원리스트</h1>  
	<form name="frm" method="post">
	<table style="float:right; ">
		<tr><td>회원 이름 <input type="text" name="key" value="${key1}">
		<input class="btn" type="button" value="검색" onclick="go_search('adminMemberList')">
		<input class="btn" type="button" name="btn_total" value="전체보기 " onClick="go_total('adminMemberList')"></td> </tr>
	</table><br>
	<table id="memberList">
		<tr>
			<th>아이디</th>
			<th> 이름 </th>
			<th>전화번호</th>
			<th>이메일</th>
		</tr>
	    <c:forEach items="${memberList}" var="memberVO">
		    <tr>
		    	<td><input type="checkbox" name="mid" value="${memberVO.mid}">${memberVO.mid}</td>
		    	<td>${memberVO.name}	</td>
		    	<td>${memberVO.mphone}</td>
		    	<td>${memberVO.email}</td>
		    </tr>
	  </c:forEach>
	  <tr>
     <th><a href="#" onClick="go_members_delete();">회원 삭제하기</a></th>
	  </tr>
	</table>
	<jsp:include page="/admin/paging/paging.jsp">   
	    <jsp:param value="camp.do?command=adminMemberList" name="command"/>
	</jsp:include>
	</form>
</article>


<%@ include file="/admin/footer.jsp"%>