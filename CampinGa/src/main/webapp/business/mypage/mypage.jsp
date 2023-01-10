<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<%@ include file="/business/sub_menu.jsp"%>

<article id="mypage">
   <!-- 회원 간단한 정보 + 정보수정 버튼-->
   <form method="post" name="memberInfo">
      <h1>회원정보</h1>
      <table class="memberInfoList">
         <tr>
            <td>이름</td>
            <td>${loginBusinessman.name}</td>
         </tr>
         <tr>
            <td>아이디</td>
            <td>${loginBusinessman.bid}</td>
         </tr>
         <tr>
            <td>이메일</td>
            <td>${loginBusinessman.email}</td>
         </tr>
         <tr>
            <td>전화번호</td>
            <td>${loginBusinessman.phone}</td>
         </tr>
         <tr>
			<td>
				<input type="button" value="정보수정"
						onclick="location.href='camp.do?command=businessmanEditForm'">
			</td>
			<td>
				<input type="button" value="회원탈퇴"
						onclick="location.href='camp.do?command=deleteBusinessman'">
			</td>
		</tr>
      </table>
   </form>


   

   
</article>
<%@ include file="../../footer.jsp"%>