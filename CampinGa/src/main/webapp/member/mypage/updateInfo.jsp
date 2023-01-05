<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<script src="member/script/member.js"></script>
<article>
<h2>Update Information</h2>
<form method="post" name="updateInfo">
	<input type="hidden" name="command" value="updateUserInfo" />
	<fieldset>
		<legend>Basic Info</legend>
		<label>User ID </label><input type="text" name="mid" value="${loginUser.mid}" readonly><br>
        <label>Name </label><input type="text" name="name"  value="${loginUser.name}"><br> 
        <label>Phone Number </label><input  type="text" name="mphone"  value="${loginUser.mphone}"><br>
        <label>E-Mail </label><input type="text" name="email" value="${loginUser.email}">
	</fieldset>
	<div id="buttons">
		<input type="button" value="정보수정" class="submit" onclick="go_update();"> 
		<input type="reset" value="취소" class="cancel">
	</div>
</form>
</article>

<%@ include file="../../footer.jsp" %>