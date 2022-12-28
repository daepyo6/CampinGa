<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<script src="script/member.js"></script>
<article>
	<form method="post" name="joinForm">		
		<input type="hidden" name="command" value="join">
		<div id="joinTable">
			<span>${message}</span>
			<label>이름</label> <br>
			<div class="inputDiv">
				<input type="text" class="joinInput" name="name" size="20">
			</div>
			<label>아이디</label> <br>
			<div class="inputDiv">
				<input type="text" class="joinInput" name="id" size="20"></div>				
				<input type="button" value="ID중복체크" onclick="idcheck()" class="button">
				<input type="hidden" name="reid">
			<label>비밀번호</label> <br>
			<div class="inputDiv">
				<input type="password" class="joinInput" name="pwd" size="20">
			</div>
			<label>비밀번호 확인</label> <br>
			<div class="inputDiv">
				<input type="password" class="joinInput" name="pwd_check" size="20"></div>
			<label>핸드폰 번호</label> <br>
			<div class="inputDiv">
				<input type="text" class="joinInput" name="phone" size="20"></div>
			<label>이메일</label> <br>
			<div class="inputDiv">
				<input type="text" class="joinInput" name="email" size="30"></div>			
		</div>
		<input type="button" value="가입하기" onclick="joinCheck()">
		<input type="button" value="메인으로" onclick="location.href='camp.do?command=index'">
	</form>
</article>

<%@ include file="../footer.jsp" %>