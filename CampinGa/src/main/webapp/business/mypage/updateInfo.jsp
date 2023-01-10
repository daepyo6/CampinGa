<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<%@ include file="/business/sub_menu.jsp"%>

<script src="business/business.js"></script>
<article>
<h2>Update Information</h2>
<form method="post" name="updateBusinessInfo">
	<input type="hidden" name="command" value="updateBusinessInfo" />
	<fieldset>
		<legend>Basic Info</legend>
		<label>User ID </label><input type="text" name="bid" value="${loginBusinessman.bid}" readonly><br>
        <label>Name </label><input type="text" name="name"  value="${loginBusinessman.name}"><br> 
        <label>Phone Number </label><input  type="text" name="phone"  value="${loginBusinessman.phone}"><br>
        <label>E-Mail </label><input type="text" name="email" value="${loginBusinessman.email}"><br>
	</fieldset>
	<div id="buttons">
		<input type="button" value="정보수정" class="submit" onclick="go_update();"> 
		<input type="reset" value="취소" class="cancel" onclick="location.href='camp.do?command=businessmanMypage'">
	</div>
</form>
</article>

<%@ include file="../../footer.jsp" %>