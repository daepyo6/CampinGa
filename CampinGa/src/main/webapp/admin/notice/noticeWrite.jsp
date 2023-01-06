<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
 <%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>

<article>
	<form name="frm" method="post"  >
	<input type="hidden" name="aid" value="${loginAdmin}">
		<table id="list">
			<tr>
				<th>제목</th><td width="343" colspan="5">
		       	<input type="text" name="subject" size="47" maxlength="100"></td>
		    </tr>
		    <tr>
				<th>상세설명</th><td colspan="5">
				<textarea name="content" rows="8" cols="70"></textarea></td>
			</tr>
			
		</table>
		<input class="btn" type="button" value="등록" onClick="go_save()">           
		<input class="btn" type="button" value="목록" onClick="go_mov()"> 
	</form>
</article>

<%@ include file="/admin/footer.jsp"%>