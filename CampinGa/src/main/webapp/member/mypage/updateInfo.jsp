<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<script src="member/script/member.js"></script>

<article>
<form method="post" name="updateInfo">
   <input type="hidden" name="command" value="updateUserInfo" />
    <div class="joinTable">
    <h2>Update Information</h2><br>
   <fieldset>
      <div class="inputDiv">
      <label>User ID </label><input type="text" name="mid" value="${loginUser.mid}" readonly><br>
      </div>
      <div class="inputDiv">
        <label>Name </label><input type="text" name="name"  value="${loginUser.name}"><br> 
        </div>
        <div class="inputDiv">
        <label>Phone Number </label><input  type="text" name="mphone"  value="${loginUser.mphone}"><br>
        </div>
        <div class="inputDiv">
        <label>E-Mail </label><input type="text" name="email" value="${loginUser.email}">
      </div>   
   </fieldset><br><br>
   <div id="mypagebtn">
      <input type="button" value="정보수정" class="submit" onclick="go_update();"> 
      <input type="reset" value="취소" class="cancel">
   </div>
   </div>
</form>
</article>

<%@ include file="../../footer.jsp" %>