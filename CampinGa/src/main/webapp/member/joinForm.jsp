<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<link href="member/css/member.css" rel="stylesheet">  
<article>
   <form method="post" name="joinForm" action="camp.do">      
      <input type="hidden" name="command" value="join">
      <div id="joinTable">
         <h1>회원가입</h1>
         <label>이름</label> <br>
         <div class="inputDiv">
            <input type="text" class="joinInput" name="name" size="20">
         </div>
         <label>아이디</label> <br>
         <div class="inputDiv">
            <input type="text" class="joinInput" name="id" size="20">
            <input type="button" value="ID중복체크" onclick="idcheck(1);" class="button">
            <input type="hidden" name="reid">
         </div>                  
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
      <input type="submit" value="가입하기" onclick="return joinCheck()">
      <input type="button" value="메인으로" onclick="location.href='camp.do?command=index'">
   </form>
</article>

<%@ include file="../footer.jsp" %>