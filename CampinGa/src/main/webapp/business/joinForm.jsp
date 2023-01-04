<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<script src="business/business.js"></script>
<article>
   <form method="post" name="joinForm"> 
      <div id="joinTable">
         <h1>입점 신청</h1>
         <label>아이디</label> <br>
         <div class="inputDiv">
            <input type="text" class="joinInput" name="id" size="20">
            <input type="button" value="ID중복체크" onclick="idcheck(2);" class="button">
            <input type="hidden" name="reid">
         </div>   
         <label>사업자 이름</label> <br>
         <div class="inputDiv">
            <input type="text" class="joinInput" name="name" size="20">
         </div>
         <label>캠핑장 이름</label> <br>
         <div class="inputDiv">
            <input type="text" class="joinInput" name="cname" size="20">
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
         <label>캠핑장 주소</label>
         <div class="inputDiv">
         	<select name="caddress1">
         		<!-- 나중에 forEach로 바꾸기 -->
	         	<option value="0">도/시 선택</option>
	         	<option value="1">서울시</option>
	         	<option value="2">경기도</option>
         	</select>
         	<select name="caddress2">
         		<!-- 나중에 forEach로 바꾸기 -->
	         	<option value="0">시/군 선택</option>
	         	<option value="1">가평군</option>
	         	<option value="2">김포시</option>
         	</select> <br>       	
         	<input type="text" name="caddress3" placeholder="상세주소를 입력해주세요">
         </div>        
      </div>
      <input type="button" value="가입하기" onclick="busiJoinCheck()">
      <input type="button" value="메인으로" onclick="location.href='camp.do?command=index'">
   </form>
</article>

<%@ include file="../footer.jsp" %>