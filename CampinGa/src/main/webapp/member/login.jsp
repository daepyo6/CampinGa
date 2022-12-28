<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>



<article>
	<h1>Login</h1>
	<form method="post" action="camp.do" name="loginFrm">
		<input type="hidden" name="command" value="login" />
		<fieldset>
			<legend></legend>
				<label>User ID</label><input name="id" type="text"><br> 
		        <label>Password</label><input name="pwd" type="password"><br>
		         <input type="radio" name="user" value="1"/>개인 &nbsp; &nbsp; 
		   		 <input type="radio" name="user" value="2"/>사업자
		</fieldset>
		<div id="buttons">
	        <input type="submit" value="로그인" class="submit" 	onclick="return loginCheck()">
	        <input type="button" value="회원가입" class="cancel" 
	        	onclick="location.href='camp.do?command=joinForm'">  
	    </div><br><br>
	    <div>&nbsp;&nbsp;&nbsp;${message}</div>  
	</form>
</article>


<%@ include file="../footer.jsp" %>