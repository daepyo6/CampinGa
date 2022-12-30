<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<article>
	<h2>회원 가입 약관</h2>
	<form id="join" method="post" name="contractFrm">	
		<div>가입유형</div>
		<input type="button" value="일반 회원" onclick="joinChoose(1)">
		<input type="button" value="사업자 회원" onclick="joinChoose(2)">
		<input type="hidden" name="user" value="">
		<br>
		<textarea name="contract" rows="15" cols="100" disabled="disabled">
		가입유형을 선택해주세요
		</textarea>		
		<br> <br>		
		<div>
			<input type="radio" name="okon"> 동의함 &nbsp; &nbsp; &nbsp;
			<input type="radio" name="okon" checked="checked"> 동의안함
		</div>		
		<input type="button" value="Next" class="submit" onclick="go_next();">	
	</form>
</article>

<%@ include file="../footer.jsp"%>